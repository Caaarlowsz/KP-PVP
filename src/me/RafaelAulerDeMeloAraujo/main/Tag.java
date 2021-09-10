package me.RafaelAulerDeMeloAraujo.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nametagedit.plugin.NametagEdit;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class Tag implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tag")) {
			if (args.length == 0) {
				p.sendMessage(
						"§7Tags Existentes no Servidor: §7(§7Membro | §aVip§7 | §4Champion§7 | §cRuby| §cMiniYT  §7| §bYoutuber §7| §eAjudante §7| §2Moderador §7| §5Coordenador §7| §9Gerente §7| §bAdmin §7| §3Diretor §7| §4Dono)");
				return true;
			} else if ((args[0].equalsIgnoreCase("dono")) && (p.hasPermission("tag.dono"))) {
				p.setDisplayName("§4[Dono] " + p.getName());
				NametagEdit.getApi().setPrefix(p.getName(), "§4[Dono] ");
				p.setPlayerListName("§4[Dono] " + p.getName());
				p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §4[Dono]");
			} else if ((args[0].equalsIgnoreCase("diretor")) && (p.hasPermission("tag.diretor"))) {
				p.setDisplayName("§3[Diretor] " + p.getName());
				NametagEdit.getApi().setPrefix(p.getName(), "§3[Diretor] ");
				p.setPlayerListName("§3[Diretor] " + p.getName());
				p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §3[Diretor]");
			} else if ((args[0].equalsIgnoreCase("gerente")) && (p.hasPermission("tag.gerente"))) {
				p.setDisplayName("§9[Gerente] " + p.getName());
				NametagEdit.getApi().setPrefix(p.getName(), "§9[Gerente] ");
				p.setPlayerListName("§9[Gerente] " + p.getName());
				p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §9[Gerente]");
			} else if ((args[0].equalsIgnoreCase("admin")) && (p.hasPermission("tag.admin"))) {
				p.setDisplayName("§b[Admin] " + p.getName());
				NametagEdit.getApi().setPrefix(p.getName(), "§b[Admin] ");
				p.setPlayerListName("§b[Admin] " + p.getName());
				p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §b[Admin]");
			} else if ((args[0].equalsIgnoreCase("coordenador")) && (p.hasPermission("tag.coordenador"))) {
				p.setDisplayName("§5[Coordenador] " + p.getName());
				NametagEdit.getApi().setPrefix(p.getName(), "§5[Coordenador] ");
				p.setPlayerListName("§5[Coordenador] " + p.getName());
				p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §5[Coordenador]");
			} else if ((args[0].equalsIgnoreCase("moderador")) && (p.hasPermission("tag.moderador"))) {
				p.setDisplayName("§2[Moderador] " + p.getName());
				NametagEdit.getApi().setPrefix(p.getName(), "§2[Moderador] ");
				p.setPlayerListName("§2[Moderador] " + p.getName());
				p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §2Moderador");
			} else if ((args[0].equalsIgnoreCase("ajudante")) && (p.hasPermission("tag.ajudante"))) {
				p.setDisplayName("§e[Ajudante] " + p.getName());
				NametagEdit.getApi().setPrefix(p.getName(), "§e[Ajudante] ");
				p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §e[Ajudante]");
				p.setPlayerListName("§e[Ajudante] " + p.getName());
			} else if ((args[0].equalsIgnoreCase("miniyt")) && (p.hasPermission("tag.miniyt"))) {
				p.setDisplayName("§c[MiniYT] " + p.getName());
				NametagEdit.getApi().setPrefix(p.getName(), "§c[MiniYT] ");
				p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §c[MiniYT]");
				p.setPlayerListName("§c[MiniYT] " + p.getName());
			} else if ((args[0].equalsIgnoreCase("champion")) && (p.hasPermission("tag.champion"))) {
				p.setDisplayName("§d[Champion] " + p.getName());
				NametagEdit.getApi().setPrefix(p.getName(), "§d[Champion] ");
				p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §d[Champion]");
				p.setPlayerListName("§d[Champion] " + p.getName());
			} else if ((args[0].equalsIgnoreCase("youtuber")) && (p.hasPermission("tag.youtuber"))) {
				p.setDisplayName("§b[Youtuber] " + p.getName());
				NametagEdit.getApi().setPrefix(p.getName(), "§b[Youtuber] ");
				p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §b§lYoutuber");
				p.setPlayerListName("§b[Youtuber] " + p.getName());
			} else if ((args[0].equalsIgnoreCase("ruby")) && (p.hasPermission("tag.ruby"))) {
				p.setDisplayName("§c[Ruby] " + p.getName());
				NametagEdit.getApi().setPrefix(p.getName(), "§c[Ruby] ");
				p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §c§lRUBY");
				p.setPlayerListName("§c[Ruby] " + p.getName());
			} else if ((args[0].equalsIgnoreCase("vip")) && (p.hasPermission("tag.vip"))) {
				p.setDisplayName("§a[Vip] " + p.getName());
				NametagEdit.getApi().setPrefix(p.getName(), "§a[VIP] ");
				p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §a§lVIP");
				p.setPlayerListName("§a[Vip] " + p.getName());
			} else if (args[0].equalsIgnoreCase("membro")) {
				p.setDisplayName("§7" + p.getName());
				NametagEdit.getApi().setPrefix(p.getName(), "§7");
				p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §7§lMEMBRO");
				p.setPlayerListName("§7" + p.getName());
			}
			return false;
		}
		{
		}
		return false;
	}
}
