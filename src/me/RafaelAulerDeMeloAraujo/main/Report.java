package me.RafaelAulerDeMeloAraujo.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class Report implements CommandExecutor {
	public String[] aliases;
	public String description;
	public static ArrayList<String> reportou;

	static {
		Report.reportou = new ArrayList<String>();
	}

	public Report() {
		this.aliases = new String[] { "report" };
		this.description = "Reportar";
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		final Player p = (Player) sender;
		if (args.length < 2) {
			p.sendMessage(String.valueOf(API.NomeServer) + "§cEscreva: /report (nome) (motivo) §2§§");
		} else if (args.length >= 2) {
			final Player t = Bukkit.getPlayer(args[0]);
			if (t == null) {
				p.sendMessage(String.valueOf(API.NomeServer) + "§4Esse Jogador esta offline");
				return true;
			}
			if (t == p) {
				p.sendMessage(String.valueOf(API.NomeServer) + "§4Voce nao pode se reportar");
				return true;
			}
			final StringBuilder sb = new StringBuilder();
			for (int i = 1; i < args.length; ++i) {
				sb.append(args[i]).append(" ");
				final String motivo = sb.toString().trim();
				sender.sendMessage(String.valueOf("§b§lPVP") + " §4Voc\u00ea reportou: §5" + t.getDisplayName());
				for (Player todos : Bukkit.getOnlinePlayers()) {
					if (todos.hasPermission("kitpvp.report")) {
						todos.sendMessage("§7-----------§5Novo Report§7-----------");
						todos.sendMessage("§4Reporter: §c" + p.getDisplayName());
						todos.sendMessage("§4Reportado: §c" + t.getDisplayName());
						todos.sendMessage("§4Motivo: §c" + motivo);
						todos.sendMessage("§7-----------§5Novo Report§7-----------");
					}
				}
			}
		}
		return true;
	}
}
