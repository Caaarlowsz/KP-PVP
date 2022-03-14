package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;

public class Monk implements Listener {
	@EventHandler
	public void aoMonk(final PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		if (e.getRightClicked() instanceof Player) {
			final Player jogadorClicado = (Player) e.getRightClicked();
			if (Habilidade.getAbility(p).equalsIgnoreCase("Monk")
					&& p.getItemInHand().getType() == Material.BLAZE_ROD) {
				if (Cooldown.add(p)) {
					API.MensagemCooldown(p);
					return;
				}
				final int random = new Random().nextInt(jogadorClicado.getInventory().getSize() - 10 + 1 + 10);
				final ItemStack ItemSelecionado = jogadorClicado.getInventory().getItem(random);
				final ItemStack ItemMudado = jogadorClicado.getItemInHand();
				jogadorClicado.setItemInHand(ItemSelecionado);
				jogadorClicado.getInventory().setItem(random, ItemMudado);
				jogadorClicado.sendMessage(
						String.valueOf(API.NomeServer) + KPPvP.messages.getString("MonkedMessage").replace("&", "§"));
				p.sendMessage(String.valueOf(API.NomeServer) + KPPvP.messages.getString("MonkUse").replace("&", "§")
						.replace("%player%", jogadorClicado.getName()));
				Cooldown.add(p, KPPvP.kits.getInt("MonkCooldown"));
				Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) KPPvP.getInstance(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.sendMessage(API.fimcooldown);
					}
				}, 20L * KPPvP.kits.getInt("MonkCooldown"));
			}
		}
	}
}