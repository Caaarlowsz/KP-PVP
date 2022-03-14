package me.RafaelAulerDeMeloAraujo.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;

public class NoExplosion implements Listener {
	@EventHandler
	public void NoExplodeMyMapPlease(EntityExplodeEvent e) {
		World w = Bukkit.getServer().getWorld(KPPvP.plugin.getConfig().getString("Spawn.World"));
		if (e.getEntity().getWorld().equals(w)) {
			e.setCancelled(true);
		}
	}
}