package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;

public class Poseidon implements Listener {
	@EventHandler
	public void aoPoseidon(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		Block b = p.getLocation().getBlock();
		if ((Habilidade.getAbility(p).equalsIgnoreCase("Poseidon"))
				&& ((b.getType() == Material.WATER) || (b.getType() == Material.STATIONARY_WATER))) {
			API.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, KPPvP.kits.getInt("PoseidonStrenghtTime"),
					KPPvP.kits.getInt("PoseidonStrenghtAmplifier"));
			API.darEfeito(p, PotionEffectType.DAMAGE_RESISTANCE, KPPvP.kits.getInt("PoseidonDamageResistanceTime"),
					KPPvP.kits.getInt("PoseidonDamageResistanceAmplifier"));
			API.darEfeito(p, PotionEffectType.SPEED, KPPvP.kits.getInt("PoseidonSpeedTime"),
					KPPvP.kits.getInt("PoseidonSpeedAmplifier"));
		}
	}
}
