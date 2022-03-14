package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;

public class Resouper implements Listener {
	@EventHandler
	public void aomatar(final PlayerDeathEvent e) {
		if (e.getEntity().getKiller() instanceof Player) {
			final Player p = e.getEntity().getKiller();
			if (Habilidade.getAbility(p).equalsIgnoreCase("Resouper")) {
				for (int i = 0; i < p.getInventory().getSize(); ++i) {
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
					p.updateInventory();
				}
				p.sendMessage(String.valueOf(API.NomeServer)
						+ (KPPvP.messages.getString("ResouperMessage").replace("&", "§")));
			}
		}
	}
}
