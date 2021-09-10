package me.RafaelAulerDeMeloAraujo.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Deshfire;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Gladiator;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;

/*     */ public class Respawn/*     */ implements Listener
/*     */ {

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {

		if (Join.game.contains((e.getEntity().getName()))) {

			Player victim = e.getEntity();
			e.setDeathMessage("");

			victim.getWorld().playEffect(victim.getLocation().add(0.0D, 1.0D, 0.0D), Effect.STEP_SOUND, 152);
			respawnPlayer(victim);

		}

	}

	private void respawnPlayer(Player p) {

		Location deathLocation = p.getLocation();
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> p.spigot().respawn(), 1);

		p.setGameMode(GameMode.SPECTATOR);
		p.teleport(deathLocation);

		new BukkitRunnable() {

			int time = 5;

			@Override
			public void run() {

				if (time != 0) {

					TitleAPI.sendTitle(p, Integer.valueOf(20), Integer.valueOf(40), Integer.valueOf(20),
							Main.getInstace().getConfig().getString("Title.DeathTitle"),
							Main.getInstace().getConfig().getString("Title.DeathSubTitle"));
					p.playSound(p.getLocation(),
							org.bukkit.Sound.valueOf(Main.getInstance().getConfig().getString("Sound.Respawning")),
							3.0F, 3.0F);
					time--;

				} else {
					p.getInventory().clear();
					p.getInventory().clear();
					for (PotionEffect effect : p.getActivePotionEffects()) {
						/* 70 */ p.removePotionEffect(effect.getType());
						/*     */ }
					/* 73 */ p.getInventory().clear();
					/* 74 */ p.getInventory().setHelmet(new ItemStack(Material.AIR));
					/* 75 */ p.getInventory().setChestplate(new ItemStack(Material.AIR));
					/* 76 */ Habilidade.removeAbility(p);
					/* 77 */ me.RafaelAulerDeMeloAraujo.SpecialAbility.Cooldown.remove(p);
					/* 78 */ Deshfire.cooldownm.remove(p);
					/* 79 */ Deshfire.armadura.remove(p.getName());
					/* 80 */ Gladiator.lutando.remove(p.getName());
					/* 81 */ Gladiator.gladgladiator.remove(p.getName());
					/* 82 */ org.bukkit.World w = org.bukkit.Bukkit.getServer()
							.getWorld(Main.plugin.getConfig().getString("Spawn.World"));
					/* 83 */ double x = Main.plugin.getConfig().getDouble("Spawn.X");
					/* 84 */ double y = Main.plugin.getConfig().getDouble("Spawn.Y");
					/* 85 */ double z = Main.plugin.getConfig().getDouble("Spawn.Z");
					/* 86 */ Location lobby = new Location(w, x, y, z);
					/* 87 */ lobby.setPitch((float) Main.plugin.getConfig().getDouble("Spawn.Pitch"));
					/* 88 */ lobby.setYaw((float) Main.plugin.getConfig().getDouble("Spawn.Yaw"));
					/* 89 */ p.getInventory().clear();
					/* 90 */ p.teleport(lobby);
					/*     */
					p.getInventory().setLeggings(new ItemStack(Material.AIR));
					p.getInventory().setBoots(new ItemStack(Material.AIR));
					ItemStack kits1 = new ItemStack(Material.CHEST);
					/* 96 */ ItemMeta kits12 = kits1.getItemMeta();
					/* 97 */ kits12.setDisplayName(Main.messages.getString("KitItemName").replace("&", "§"));
					/* 98 */ kits1.setItemMeta(kits12);
					/* 95 */ ItemStack kits = new ItemStack(Material.DIAMOND);
					/* 96 */ ItemMeta kits2 = kits.getItemMeta();
					/* 97 */ kits2.setDisplayName(Main.messages.getString("ShopItemName").replace("&", "§"));
					/* 98 */ kits.setItemMeta(kits2);
					/* 99 */ ItemStack st = new ItemStack(Material.COMPASS);
					/* 100 */ ItemMeta st2 = st.getItemMeta();
					/* 101 */ st2.setDisplayName(Main.messages.getString("1v1ItemName").replace("&", "§"));
					/* 102 */ st.setItemMeta(st2);
					ItemStack stats = new ItemStack(Material.NAME_TAG);
					/* 227 */ ItemMeta stats2 = kits.getItemMeta();
					/* 228 */ stats2.setDisplayName(Main.messages.getString("StatsItemName").replace("&", "§"));
					/* 229 */ stats.setItemMeta(stats2);

					ItemStack stats1 = new ItemStack(Material.WOOD_SWORD);
					/* 227 */ ItemMeta stats12 = stats1.getItemMeta();
					/* 228 */ stats12.setDisplayName(Main.messages.getString("ClickTestItemName").replace("&", "§"));
					/* 229 */ stats1.setItemMeta(stats12);

					/* 103 */

					p.getInventory().setItem(4, kits1);
					p.getInventory().setItem(6, kits);
					p.getInventory().setItem(2, st);
					p.setAllowFlight(false);
					API.tirarEfeitos(p);
					p.updateInventory();
					p.sendMessage(ChatColor.YELLOW + "Voce respawnou");
					p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 30, 0));
					p.playSound(p.getLocation(),
							org.bukkit.Sound.valueOf(Main.getInstance().getConfig().getString("Sound.RespawnSucess")),
							3.0F, 3.0F);
					p.setGameMode(GameMode.SURVIVAL);

					cancel();

				}

			}

		}.runTaskTimer(Main.getInstance(), 0L, 20L);

	}

}