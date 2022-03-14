package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;

public class Fireman implements Listener {
	@EventHandler
	public void damage(final EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Fireman") && (e.getCause() == EntityDamageEvent.DamageCause.LAVA
				|| e.getCause() == EntityDamageEvent.DamageCause.FIRE
				|| e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK)) {
			e.setCancelled(true);
			API.darEfeito(p, PotionEffectType.REGENERATION, KPPvP.kits.getInt("FiremanRegenonLavaTime"),
					KPPvP.kits.getInt("FiremanRegenonLavaAmplifier"));
		}
	}

	@EventHandler
	public void aoAgua(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		Block b = p.getLocation().getBlock();
		if ((Habilidade.getAbility(p).equalsIgnoreCase("Fireman"))
				&& ((b.getType() == Material.WATER) || (b.getType() == Material.STATIONARY_WATER))) {
			API.darEfeito(p, PotionEffectType.WEAKNESS, KPPvP.kits.getInt("FiremanWeaknessonWaterTime"),
					KPPvP.kits.getInt("FiremanWeaknessonWaterAmplifier"));
		}
	}
}
