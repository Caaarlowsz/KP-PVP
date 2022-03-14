package me.RafaelAulerDeMeloAraujo.main;

import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class kpsetspawn implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("setspawn")) {
			if (!p.hasPermission("kitpvp.setspawn")) {
				return true;
			}
			KPPvP.plugin.getConfig().set("Spawn.World", p.getLocation().getWorld().getName());
			KPPvP.plugin.getConfig().set("Spawn.X", Double.valueOf(p.getLocation().getX()));
			KPPvP.plugin.getConfig().set("Spawn.Y", Double.valueOf(p.getLocation().getY()));
			KPPvP.plugin.getConfig().set("Spawn.Z", Double.valueOf(p.getLocation().getZ()));
			KPPvP.plugin.getConfig().set("Spawn.Pitch", Float.valueOf(p.getLocation().getPitch()));
			KPPvP.plugin.getConfig().set("Spawn.Yaw", Float.valueOf(p.getLocation().getYaw()));
			KPPvP.plugin.saveConfig();
			KPPvP.plugin.getConfig().set("SpawnD.World", p.getLocation().getWorld().getName());
			KPPvP.plugin.getConfig().set("SpawnD.X", Double.valueOf(p.getLocation().getX()));
			KPPvP.plugin.getConfig().set("SpawnD.Y", Double.valueOf(p.getLocation().getY()));
			KPPvP.plugin.getConfig().set("SpawnD.Z", Double.valueOf(p.getLocation().getZ()));
			KPPvP.plugin.getConfig().set("SpawnD.Pitch", Float.valueOf(p.getLocation().getPitch()));
			KPPvP.plugin.getConfig().set("SpawnD.Yaw", Float.valueOf(p.getLocation().getYaw()));
			KPPvP.plugin.saveConfig();

			p.sendMessage(API.NomeServer + KPPvP.messages.getString("SpawnSeted").replace("&", "§"));
			return true;
		}
		return false;
	}
}
