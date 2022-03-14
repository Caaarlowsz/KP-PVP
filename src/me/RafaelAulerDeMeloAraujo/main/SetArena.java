package me.RafaelAulerDeMeloAraujo.main;

import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class SetArena implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Sem console");
			return true;
		}
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("setarena")) {
			if (!p.hasPermission("kitpvp.setarena")) {
				sender.sendMessage("§c§lERRO §fVocê nao tem permissão para executar esse comando");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage(String.valueOf(API.NomeServer) + "Escreva: /setarena (1|4) §2§§");
				return true;
			}
			if (args[0].equalsIgnoreCase("1")) {
				p.sendMessage(String.valueOf(API.NomeServer) + "§aVoc\u00ea setou a ARENA 1");
				KPPvP.plugin.getConfig().set("arena1.x", (Object) p.getLocation().getX());
				KPPvP.plugin.getConfig().set("arena1.y", (Object) p.getLocation().getY());
				KPPvP.plugin.getConfig().set("arena1.z", (Object) p.getLocation().getZ());
				KPPvP.plugin.getConfig().set("arena1.pitch", (Object) p.getLocation().getPitch());
				KPPvP.plugin.getConfig().set("arena1.yaw", (Object) p.getLocation().getYaw());
				KPPvP.plugin.getConfig().set("arena1.world", (Object) p.getLocation().getWorld().getName());
				KPPvP.plugin.saveConfig();
			}
			if (args[0].equalsIgnoreCase("2")) {
				p.sendMessage(String.valueOf(API.NomeServer) + "§aVoc\u00ea setou a ARENA 2");
				KPPvP.plugin.getConfig().set("arena2.x", (Object) p.getLocation().getX());
				KPPvP.plugin.getConfig().set("arena2.y", (Object) p.getLocation().getY());
				KPPvP.plugin.getConfig().set("arena2.z", (Object) p.getLocation().getZ());
				KPPvP.plugin.getConfig().set("arena2.pitch", (Object) p.getLocation().getPitch());
				KPPvP.plugin.getConfig().set("arena2.yaw", (Object) p.getLocation().getYaw());
				KPPvP.plugin.getConfig().set("arena2.world", (Object) p.getLocation().getWorld().getName());
				KPPvP.plugin.saveConfig();
			}
			if (args[0].equalsIgnoreCase("3")) {
				p.sendMessage(String.valueOf(API.NomeServer) + "§aVoc\u00ea setou a ARENA 3");
				KPPvP.plugin.getConfig().set("arena3.x", (Object) p.getLocation().getX());
				KPPvP.plugin.getConfig().set("arena3.y", (Object) p.getLocation().getY());
				KPPvP.plugin.getConfig().set("arena3.z", (Object) p.getLocation().getZ());
				KPPvP.plugin.getConfig().set("arena3.pitch", (Object) p.getLocation().getPitch());
				KPPvP.plugin.getConfig().set("arena3.yaw", (Object) p.getLocation().getYaw());
				KPPvP.plugin.getConfig().set("arena3.world", (Object) p.getLocation().getWorld().getName());
				KPPvP.plugin.saveConfig();
			}
			if (args[0].equalsIgnoreCase("4")) {
				p.sendMessage(String.valueOf(API.NomeServer) + "§aVoc\u00ea setou a ARENA 4");
				KPPvP.plugin.getConfig().set("arena4.x", (Object) p.getLocation().getX());
				KPPvP.plugin.getConfig().set("arena4.y", (Object) p.getLocation().getY());
				KPPvP.plugin.getConfig().set("arena4.z", (Object) p.getLocation().getZ());
				KPPvP.plugin.getConfig().set("arena4.pitch", (Object) p.getLocation().getPitch());
				KPPvP.plugin.getConfig().set("arena4.yaw", (Object) p.getLocation().getYaw());
				KPPvP.plugin.getConfig().set("arena4.world", (Object) p.getLocation().getWorld().getName());
				KPPvP.plugin.saveConfig();
			}
		} else {
			p.sendMessage(API.NomeServer + "§cVoce nao tem acesso a esse comado.");
		}
		{
			return false;
		}
	}
}