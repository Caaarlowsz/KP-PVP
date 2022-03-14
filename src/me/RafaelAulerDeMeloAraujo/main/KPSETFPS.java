package me.RafaelAulerDeMeloAraujo.main;

import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class KPSETFPS implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("setfps")) {
			if (!p.hasPermission("kitpvp.setspawn")) {
				return true;
			}
			KPPvP.plugin.getConfig().set("FPS.World", p.getLocation().getWorld().getName());
			KPPvP.plugin.getConfig().set("FPS.X", Double.valueOf(p.getLocation().getX()));
			KPPvP.plugin.getConfig().set("FPS.Y", Double.valueOf(p.getLocation().getY()));
			KPPvP.plugin.getConfig().set("FPS.Z", Double.valueOf(p.getLocation().getZ()));
			KPPvP.plugin.getConfig().set("FPS.Pitch", Float.valueOf(p.getLocation().getPitch()));
			KPPvP.plugin.getConfig().set("FPS.Yaw", Float.valueOf(p.getLocation().getYaw()));
			KPPvP.plugin.saveConfig();

			p.sendMessage(API.NomeServer + "FPS SETADA COM SUCESSO!");
			return true;
		}
		return false;
	}
}
