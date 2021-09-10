package me.RafaelAulerDeMeloAraujo.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class SS implements CommandExecutor, Listener {
	public static ArrayList<Player> congelado;

	static {
		SS.congelado = new ArrayList<Player>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("ss")) {
			if (p.hasPermission("kitpvp.ss")) {
				if (args.length == 0) {
					p.sendMessage(String.valueOf(API.NomeServer) + "§cSintaxe correta: /ss (nome)");
				} else {
					final Player t = Bukkit.getPlayer(args[0]);
					if (t == null) {
						p.sendMessage("§4§lERRO §fEsse jogador está offline");
						return true;
					}
					if (!SS.congelado.contains(t)) {
						SS.congelado.add(t);
						t.sendMessage(String.valueOf(API.NomeServer) + "§7Voc\u00ea foi puxado para uma SS por: §c"
								+ p.getDisplayName());
						t.sendMessage(
								String.valueOf(API.NomeServer) + "§7Siga as instruçoes do staffer e passe o AnyDesk");
						p.sendMessage(String.valueOf(API.NomeServer) + "§7Voc\u00ea colocou: §c" + t.getDisplayName()
								+ " em SS");
						Bukkit.broadcast(org.bukkit.ChatColor.RED + t.getName() + " foi colocado na SS pelo staff "
								+ p.getName(), "kitpvp.staff");
					} else {
						SS.congelado.remove(t);
						t.sendMessage(String.valueOf(API.NomeServer) + "§7Voc\u00ea foi liberado por: §a"
								+ p.getDisplayName());
						p.sendMessage(
								String.valueOf(API.NomeServer) + "§7Voc\u00ea liberou: §a" + t.getDisplayName());
					}
					if (SS.congelado.contains(t)) {
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
							@Override
							public void run() {
								SS.congelado.remove(t);
								t.sendMessage(String.valueOf(API.NomeServer)
										+ "§7Voc\u00ea foi descongelado depois de uma hora");
							}
						}, 72000L);
					}
				}
			} else {
				p.sendMessage("§4§lERRO: §fVocê não tem permissão para executar esse comando");
			}
		}
		return false;
	}

	@EventHandler
	public void aoSair(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (SS.congelado.contains(p)) {
			SS.congelado.remove(p);
			Bukkit.broadcast(org.bukkit.ChatColor.RED + p.getName() + " deslogou enquanto em SS", "kitpvp.staff");
		}
	}

	@EventHandler
	public void aoComando(final PlayerCommandPreprocessEvent e) {
		final Player p = e.getPlayer();
		if (SS.congelado.contains(p) && !e.getMessage().startsWith("/tell")) {
			e.setCancelled(true);
			p.sendMessage(
					String.valueOf(API.NomeServer) + "§cVoc\u00ea n\u00e3o pode digitar comando quando estiver em SS");
		}
	}

	@EventHandler
	public void aoAndar(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (SS.congelado.contains(p)) {
			e.setTo(p.getLocation());
			p.sendMessage(String.valueOf(API.NomeServer) + "§cVoc\u00ea est\u00e1 em SS");
			p.sendMessage(String.valueOf(API.NomeServer) + "Passe seu anydesk para o Staff");
		}
	}
}
