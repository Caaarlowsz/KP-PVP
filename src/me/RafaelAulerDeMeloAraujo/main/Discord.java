package me.RafaelAulerDeMeloAraujo.main;

import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Discord implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (label.equalsIgnoreCase("discord")) {
			p.sendMessage("§9§lDISCORD: " + KPPvP.getInstace().getConfig().getString("Discord").replace("&", "§"));
			p.playSound(p.getLocation(), Sound.BLAZE_HIT, 12.0F, 12.0F);
		}
		return false;
	}
}
