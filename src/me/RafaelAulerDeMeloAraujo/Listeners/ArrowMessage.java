package me.RafaelAulerDeMeloAraujo.Listeners;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;

public class ArrowMessage implements Listener {

	@EventHandler
	public void onShot(EntityDamageByEntityEvent e) {

		if (Join.game.contains(e.getEntity().getName())) {

			if (e.getEntity() instanceof Player && e.getDamager() instanceof Arrow) {

				Player damagedPlayer = (Player) e.getEntity();
				Arrow arrow = (Arrow) e.getDamager();

				if (arrow.getShooter() != null && arrow.getShooter() instanceof Player) {

					Player shooter = (Player) arrow.getShooter();

					// ARROW HEALTH MESSAGE

					if (damagedPlayer.getName() != shooter.getName()) {

						new BukkitRunnable() {

							@Override
							public void run() {

								double health = Math.round(damagedPlayer.getHealth() * 10.0) / 10.0;

								if (health != 20.0) {

									shooter.sendMessage(API.NomeServer + ""
											+ KPPvP.messages.getString("ArrowHit-Message")
													.replace("%player%", damagedPlayer.getName())
													.replace("%health%", String.valueOf(health)).replace("&", "§"));
								}
							}
						}

								.runTaskLater(KPPvP.instance, 2L);

					}
				}
			}
		}
	}
}
