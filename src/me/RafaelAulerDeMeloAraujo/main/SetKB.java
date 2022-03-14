package me.RafaelAulerDeMeloAraujo.main;

import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class SetKB implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("setknock")) {
			if (!p.hasPermission("kitpvp.setknock")) {
				return true;
			}
			KPPvP.plugin.getConfig().set("KNOCK.World", p.getLocation().getWorld().getName());
			KPPvP.plugin.getConfig().set("KNOCK.X", Double.valueOf(p.getLocation().getX()));
			KPPvP.plugin.getConfig().set("KNOCK.Y", Double.valueOf(p.getLocation().getY()));
			KPPvP.plugin.getConfig().set("KNOCK.Z", Double.valueOf(p.getLocation().getZ()));
			KPPvP.plugin.getConfig().set("KNOCK.Pitch", Float.valueOf(p.getLocation().getPitch()));
			KPPvP.plugin.getConfig().set("KNOCK.Yaw", Float.valueOf(p.getLocation().getYaw()));
			KPPvP.plugin.saveConfig();

			p.sendMessage(API.NomeServer + "KNOCK SETADA COM SUCESSO!");
			return true;
		}
		return false;
	}
}