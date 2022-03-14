package me.RafaelAulerDeMeloAraujo.Listeners;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;

@SuppressWarnings("unused")
public class JoinSign implements Listener {
	private KPPvP plugin;

	public JoinSign(KPPvP main) {
		this.plugin = main;
	}

	public JoinSign() {
	}

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("[kp]") && (e.getLine(1).equalsIgnoreCase("join"))
				&& e.getPlayer().hasPermission("kitpvp.createsigns")) {
			e.setLine(0, KPPvP.messages.getString("JoinSignLine1").replace("&", "§"));
			e.setLine(1, KPPvP.messages.getString("JoinSignLine2").replace("&", "§"));
			e.setLine(2, KPPvP.messages.getString("JoinSignLine3").replace("&", "§"));
			e.setLine(3, KPPvP.messages.getString("JoinSignLine4").replace("&", "§"));
		}
	}

	@EventHandler
	public void inv(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null)
				&& ((e.getClickedBlock().getType() == Material.WALL_SIGN)
						|| (e.getClickedBlock().getType() == Material.SIGN_POST))) {
			Sign s = (Sign) e.getClickedBlock().getState();
			String[] lines = s.getLines();
			if ((lines.length > 0) && (lines[0].equals(KPPvP.messages.getString("JoinSignLine1").replace("&", "§"))
					&& (lines.length > 1)
					&& (lines[1].equals(KPPvP.messages.getString("JoinSignLine2").replace("&", "§"))
							&& (lines.length > 2)
							&& (lines[2].equals(KPPvP.messages.getString("JoinSignLine3").replace("&", "§"))
									&& (lines.length > 3) && (lines[3]
											.equals(KPPvP.messages.getString("JoinSignLine4").replace("&", "§"))))))) {
				p.performCommand("kitpvp join");
			}
		}
	}
}