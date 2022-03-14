package me.RafaelAulerDeMeloAraujo.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;

public class Motd implements Listener {
	@EventHandler(priority = EventPriority.MONITOR)
	public void onPing(ServerListPingEvent e) {
		e.setMotd(KPPvP.getInstace().getConfig().getString("MotdLine1").replace("&", "§") + "\n"
				+ KPPvP.getInstace().getConfig().getString("MotdLine2").replace("&", "§"));
	}
}