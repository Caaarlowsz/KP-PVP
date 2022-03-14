package me.RafaelAulerDeMeloAraujo.main;

import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class KPSETCHALLENGE implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("setchallenge")) {
			if (!p.hasPermission("kitpvp.setspawn")) {
				return true;
			}
			KPPvP.plugin.getConfig().set("CHALLENGE.World", p.getLocation().getWorld().getName());
			KPPvP.plugin.getConfig().set("CHALLENGE.X", Double.valueOf(p.getLocation().getX()));
			KPPvP.plugin.getConfig().set("CHALLENGE.Y", Double.valueOf(p.getLocation().getY()));
			KPPvP.plugin.getConfig().set("CHALLENGE.Z", Double.valueOf(p.getLocation().getZ()));
			KPPvP.plugin.getConfig().set("CHALLENGE.Pitch", Float.valueOf(p.getLocation().getPitch()));
			KPPvP.plugin.getConfig().set("CHALLENGE.Yaw", Float.valueOf(p.getLocation().getYaw()));
			KPPvP.plugin.saveConfig();

			p.sendMessage(API.NomeServer + "CHALLENGE SETADA COM SUCESSO!");
			return true;
		}
		return false;
	}
}
