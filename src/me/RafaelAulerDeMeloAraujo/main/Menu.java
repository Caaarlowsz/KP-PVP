/*     */
package me.RafaelAulerDeMeloAraujo.main;

/*     */ import java.util.Arrays;

/*     */ import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.FoodLevelChangeEvent;
/*     */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerKickEvent;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */
/*     */ import org.bukkit.inventory.meta.ItemMeta;

import com.nametagedit.plugin.NametagEdit;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.Coins.XP;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Level;
/*     */ import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Cooldown;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Deshfire;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;

/*     */ public class Menu/*     */ implements Listener, CommandExecutor
/*     */ {
	/*     */ private KPPvP main;

	/*     */
	/*     */
	/*     */ public Menu(KPPvP main)
	/*     */ {
		/* 62 */ this.main = main;
		/*     */ }

	/*     */
	/*     */ @EventHandler
	/*     */ public void onJoin(PlayerJoinEvent e) {
		/* 67 */ Player p = e.getPlayer();
		/*     */
		/*     */
		/* 70 */ Habilidade.removeAbility(p);
		/* 71 */ Deshfire.Armadura.remove(p.getName());
		/* 72 */ Deshfire.Armadura2.remove(p.getName());
		/* 73 */ Deshfire.cooldownm.remove(p);
		if (!KPPvP.plugin.getConfig().getBoolean("bungeemode")) {
			/* 74 */ Join.game.remove(p.getName());
		}
		/* 75 */ Cooldown.remove(p);
		/*     */
		/*     */
		/*     */
		/* 79 */ Streak.killstreak.put(p.getName(), Integer.valueOf(0));
		/*     */

		/*     */
		/* 84 */ if (this.main.getConfig().getString("JoinItem.JoinSound").equalsIgnoreCase("true"))
			/* 85 */ p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Join")), 1.0F,
					1.0F);
		/*     */ }

	/*     */
	/*     */ public static void createButton(Material mat, Inventory inv, int Slot, String name, String lore) {
		/* 89 */ ItemStack item = new ItemStack(mat);
		/*     */
		/* 91 */ ItemMeta meta = item.getItemMeta();
		/* 92 */ meta.setDisplayName(name);
		/* 93 */ meta.setLore(Arrays.asList(new String[] { lore }));
		/* 94 */ item.setItemMeta(meta);
		/* 95 */ inv.setItem(Slot, item);
		/*     */ }

	/*    */ @EventHandler
	/*    */ public void onFall(FoodLevelChangeEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		e.setCancelled(true);
	}

	@EventHandler
	/*     */ public void onEventTA(PlayerJoinEvent e)
	/*     */ {
		Player p = e.getPlayer();
		ItemStack kits1 = new ItemStack(Material.CHEST);
		/* 96 */ ItemMeta kits12 = kits1.getItemMeta();
		/* 97 */ kits12.setDisplayName(KPPvP.messages.getString("KitItemName").replace("&", "§"));
		/* 98 */ kits1.setItemMeta(kits12);
		/* 95 */ ItemStack kits = new ItemStack(Material.DIAMOND);
		/* 96 */ ItemMeta kits2 = kits.getItemMeta();
		/* 97 */ kits2.setDisplayName(KPPvP.messages.getString("ShopItemName").replace("&", "§"));
		/* 98 */ kits.setItemMeta(kits2);
		/* 99 */ ItemStack st = new ItemStack(Material.COMPASS);
		/* 100 */ ItemMeta st2 = st.getItemMeta();
		/* 101 */ st2.setDisplayName(KPPvP.messages.getString("1v1ItemName").replace("&", "§"));
		/* 102 */ st.setItemMeta(st2);
		ItemStack stats = new ItemStack(Material.NAME_TAG);
		/* 227 */ ItemMeta stats2 = kits.getItemMeta();
		/* 228 */ stats2.setDisplayName(KPPvP.messages.getString("StatsItemName").replace("&", "§"));
		/* 229 */ stats.setItemMeta(stats2);

		ItemStack stats1 = new ItemStack(Material.WOOD_SWORD);
		/* 227 */ ItemMeta stats12 = stats1.getItemMeta();
		/* 228 */ stats12.setDisplayName(KPPvP.messages.getString("ClickTestItemName").replace("&", "§"));
		/* 229 */ stats1.setItemMeta(stats12);

		/* 103 */

		p.getInventory().setItem(4, kits1);
		p.getInventory().setItem(6, kits);
		p.getInventory().setItem(2, st);
	}

	/*     */ @EventHandler
	/*     */ public void onEvent(PlayerJoinEvent e)
	/*     */ {
		e.setJoinMessage(null);
		Player p = e.getPlayer();
		if (!KPPvP.plugin.getConfig().getBoolean("bungeemode")) {
			return;
		}
		if (!Join.game.contains(p.getName())) {
			/* 74 */ Join.game.add(p.getName());
		}
		/*     */
		/* 200 */ World w = Bukkit.getServer().getWorld(KPPvP.plugin.getConfig().getString("Spawn.World"));
		/* 201 */ double x = KPPvP.plugin.getConfig().getDouble("Spawn.X");
		/* 202 */ double y = KPPvP.plugin.getConfig().getDouble("Spawn.Y");
		/* 203 */ double z = KPPvP.plugin.getConfig().getDouble("Spawn.Z");
		/* 204 */ Location lobby = new Location(w, x, y, z);

		/*     */
		/* 211 */ lobby.setPitch((float) KPPvP.plugin.getConfig().getDouble("Spawn.Pitch"));
		/* 212 */ lobby.setYaw((float) KPPvP.plugin.getConfig().getDouble("Spawn.Yaw"));
		/* 213 */ p.getInventory().clear();
		/*     */
		/*     */
		/* 216 */ p.teleport(lobby);
		/*     */
		/*     */
		/* 219 */ p.getInventory().clear();
		/* 220 */ p.getInventory().setArmorContents(null);
		/* 94 */
		ItemStack kits1 = new ItemStack(Material.CHEST);
		/* 96 */ ItemMeta kits12 = kits1.getItemMeta();
		/* 97 */ kits12.setDisplayName(KPPvP.messages.getString("KitItemName").replace("&", "§"));
		/* 98 */ kits1.setItemMeta(kits12);
		/* 95 */ ItemStack kits = new ItemStack(Material.DIAMOND);
		/* 96 */ ItemMeta kits2 = kits.getItemMeta();
		/* 97 */ kits2.setDisplayName(KPPvP.messages.getString("ShopItemName").replace("&", "§"));
		/* 98 */ kits.setItemMeta(kits2);
		/* 99 */ ItemStack st = new ItemStack(Material.COMPASS);
		/* 100 */ ItemMeta st2 = st.getItemMeta();
		/* 101 */ st2.setDisplayName(KPPvP.messages.getString("1v1ItemName").replace("&", "§"));
		/* 102 */ st.setItemMeta(st2);
		ItemStack stats = new ItemStack(Material.NAME_TAG);
		/* 227 */ ItemMeta stats2 = kits.getItemMeta();
		/* 228 */ stats2.setDisplayName(KPPvP.messages.getString("StatsItemName").replace("&", "§"));
		/* 229 */ stats.setItemMeta(stats2);

		ItemStack stats1 = new ItemStack(Material.WOOD_SWORD);
		/* 227 */ ItemMeta stats12 = stats1.getItemMeta();
		/* 228 */ stats12.setDisplayName(KPPvP.messages.getString("ClickTestItemName").replace("&", "§"));
		/* 229 */ stats1.setItemMeta(stats12);

		/* 103 */

		p.getInventory().setItem(4, kits1);
		p.getInventory().setItem(6, kits);
		p.getInventory().setItem(2, st);
		p.setGameMode(GameMode.SURVIVAL);
		p.updateInventory();
		e.setJoinMessage(null);
		/*     */

		/*     */ TitleAPI.sendTabTitle(p, "§a§lKITPVP \n§fServidor de KitPvP (1.8 - 1.16)",
				"§aDiscord: §f" + KPPvP.getInstace().getConfig().getString("Discord").replace("&", "§"));
		/* 235 */ p.setExp(0.0F);
		/* 236 */ p.setExhaustion(20.0F);
		/* 237 */ p.setFireTicks(0);
		/* 238 */ p.setFoodLevel(20000);
		/* 239 */ TitleAPI.sendTitle(p, Integer.valueOf(40), Integer.valueOf(80), Integer.valueOf(40),
				this.main.getConfig().getString("Title.JoinTitle"),
				this.main.getConfig().getString("Title.JoinSubTitle"));
		API.tirarEfeitos(p);
	}

	/*     */
	/*     */ @EventHandler
	/*     */ public void onLeave(PlayerQuitEvent e)
	/*     */ {
		/* 117 */ Player p = e.getPlayer();
		/*     */ if (Join.game.contains(p.getName()) && !KPPvP.plugin.getConfig().getBoolean("bungeemode")) {
			/*     */
			/*     */
			/*     */
			/* 122 */ p.chat("/kitpvp leave");
		}
		/*     */ }

	@EventHandler
	/*     */ public void onEvent(PlayerQuitEvent e)
	/*     */ {
		e.setQuitMessage(null);
	}

	/*     */
	/*     */ @EventHandler
	/*     */ public void onLeave(PlayerKickEvent e)
	/*     */ {
		/* 128 */ Player p = e.getPlayer();
		/*     */ if (Join.game.contains(p.getName()) && !KPPvP.plugin.getConfig().getBoolean("bungeemode")) {
			/*     */
			/*     */
			/*     */
			/* 133 */ p.chat("/kitpvp leave");
		}
		/*     */ }

	/*     */

	/*     */
	/*     */ @EventHandler
	/*     */ public void quickcommand(PlayerCommandPreprocessEvent e)
	/*     */ {
		/* 336 */ if ((e.getMessage().equalsIgnoreCase("/kitpvp kit"))
				&& (Join.game.contains(e.getPlayer().getName()))) {
			/* 337 */ e.setCancelled(true);
			/* 338 */ Player p = e.getPlayer();
			/* 339 */ p.chat("/kpkitmenu");
			/*     */
			/* 341 */ if (!Join.game.contains(e.getPlayer().getName()))
			/*     */ {
				/* 343 */ e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
				/* 344 */ e.getPlayer().closeInventory();
				/*     */ }
			/*     */ }
		/*     */ }

	/*     */
	/*     */ @EventHandler
	/*     */ public void quickcommand1(PlayerCommandPreprocessEvent e)
	/*     */ {
		/* 352 */ if (e.getMessage().equalsIgnoreCase("/kitpvp kits")) {
			/* 353 */ e.setCancelled(true);
			/* 354 */ Player p = e.getPlayer();
			/* 355 */ p.chat("/kpkitmenu");
			/* 356 */ if (!Join.game.contains(e.getPlayer().getName()))
			/*     */ {
				/* 358 */ e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
				/* 359 */ e.getPlayer().closeInventory();
				/*     */ }
			/*     */ }
		/*     */ }

	/*     */
	/*     */ @EventHandler
	/*     */ public void quickcommand2(PlayerCommandPreprocessEvent e)
	/*     */ {
		/* 367 */ if (e.getMessage().equalsIgnoreCase("/kitpvp kitmenu")) {
			/* 368 */ e.setCancelled(true);
			/* 369 */ Player p = e.getPlayer();
			/* 370 */ p.chat("/kpkitmenu");
			/* 371 */ if (!Join.game.contains(e.getPlayer().getName()))
			/*     */ {
				/* 373 */ e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
				/* 374 */ e.getPlayer().closeInventory();
				/*     */ }
			/*     */ }
		/*     */ }

	/*     */
	/*     */ @EventHandler
	/*     */ public void quickcommand3(PlayerCommandPreprocessEvent e)
	/*     */ {
		/* 382 */ if (e.getMessage().equalsIgnoreCase("/kpkits")) {
			/* 383 */ e.setCancelled(true);
			/* 384 */ Player p = e.getPlayer();
			/* 385 */ p.chat("/kpkitmenu");
			/*     */
			/*     */
			/* 388 */ if (!Join.game.contains(e.getPlayer().getName()))
			/*     */ {
				/* 390 */ e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
				/* 391 */ e.getPlayer().closeInventory();
				/*     */ }
			/*     */ }
		/*     */ }

	/*     */ @EventHandler
	/*     */ public void quickcommand3f(PlayerCommandPreprocessEvent e)
	/*     */ {
		/* 382 */ if (e.getMessage().equalsIgnoreCase("/kp kits")) {
			/* 383 */ e.setCancelled(true);
			/* 384 */ Player p = e.getPlayer();
			/* 385 */ p.chat("/kpkitmenu");
			/*     */
			/*     */
			/* 388 */ if (!Join.game.contains(e.getPlayer().getName()))
			/*     */ {
				/* 390 */ e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
				/* 391 */ e.getPlayer().closeInventory();
				/*     */ }
			/*     */ }
		/*     */ }

	/*     */
	/*     */
	/*     */ @EventHandler
	/*     */ public void quickcommand4(PlayerCommandPreprocessEvent e)
	/*     */ {
		/* 400 */ if (e.getMessage().equalsIgnoreCase("/kpkit")) {
			/* 401 */ e.setCancelled(true);
			/* 402 */ Player p = e.getPlayer();
			/* 403 */ p.chat("/kpkitmenu");
			/* 404 */ if (!Join.game.contains(e.getPlayer().getName()))
			/*     */ {
				/* 406 */ e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
				/* 407 */ e.getPlayer().closeInventory();
				/*     */ }
			/*     */ }
		/*     */ }

	@EventHandler
	public void onPlayerJoinT(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("*")) {
			p.setDisplayName("§4[Dono] " + p.getName());
			NametagEdit.getApi().setPrefix(p.getName(), "§4[Dono] ");
			p.setPlayerListName("§4[Dono] " + p.getName());
			p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §4[Dono]");
			return;
		}
		if (p.hasPermission("tag.diretor")) {
			p.setDisplayName("§3[Diretor] " + p.getName());
			NametagEdit.getApi().setPrefix(p.getName(), "§3[Diretor] ");
			p.setPlayerListName("§3[Diretor] " + p.getName());
			p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §3[Diretor]");
			return;
		}
		if (p.hasPermission("tag.admin")) {
			p.setDisplayName("§b[Admin] " + p.getName());
			NametagEdit.getApi().setPrefix(p.getName(), "§b[Admin] ");
			p.setPlayerListName("§b[Admin] " + p.getName());
			p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §b[Admin]");
			return;
		}
		if (p.hasPermission("tag.gerente")) {
			p.setDisplayName("§9[Gerente] " + p.getName());
			NametagEdit.getApi().setPrefix(p.getName(), "§9[Gerente] ");
			p.setPlayerListName("§9[Gerente] " + p.getName());
			p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §9[Gerente]");
			return;
		}
		if (p.hasPermission("tag.coordenador")) {
			p.setDisplayName("§5[Coordenador] " + p.getName());
			NametagEdit.getApi().setPrefix(p.getName(), "§5[Coordenador] ");
			p.setPlayerListName("§5[Coordenador] " + p.getName());
			p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §5[Coordenador]");
			return;
		}
		if (p.hasPermission("tag.moderador")) {
			p.setDisplayName("§2[Moderador] " + p.getName());
			NametagEdit.getApi().setPrefix(p.getName(), "§2[Moderador] ");
			p.setPlayerListName("§2[Moderador] " + p.getName());
			p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §2Moderador");
			return;
		}
		if (p.hasPermission("tag.ajudante")) {
			p.setDisplayName("§e[Ajudante] " + p.getName());
			NametagEdit.getApi().setPrefix(p.getName(), "§e[Ajudante] ");
			p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §e[Ajudante]");
			p.setPlayerListName("§e[Ajudante] " + p.getName());
			return;
		}
		if (p.hasPermission("tag.youtuber")) {
			p.setDisplayName("§b[Youtuber] " + p.getName());
			NametagEdit.getApi().setPrefix(p.getName(), "§b[Youtuber] ");
			p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §b§lYoutuber");
			p.setPlayerListName("§b[Youtuber] " + p.getName());
			return;
		}
		if (p.hasPermission("tag.miniyt")) {
			p.setDisplayName("§c[MiniYT] " + p.getName());
			NametagEdit.getApi().setPrefix(p.getName(), "§c[MiniYT] ");
			p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §c[MiniYT]");
			p.setPlayerListName("§c[MiniYT] " + p.getName());
			return;
		}
		if (p.hasPermission("tag.ruby")) {
			p.setDisplayName("§c[Ruby] " + p.getName());
			NametagEdit.getApi().setPrefix(p.getName(), "§c[Ruby] ");
			p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §c§lRUBY");
			p.setPlayerListName("§c[Ruby] " + p.getName());
			return;
		}
		if (p.hasPermission("tag.champion")) {
			p.setDisplayName("§d[Champion] " + p.getName());
			NametagEdit.getApi().setPrefix(p.getName(), "§d[Champion] ");
			p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §d[Champion]");
			p.setPlayerListName("§d[Champion] " + p.getName());
			return;
		}
		if (p.hasPermission("tag.vip")) {
			p.setDisplayName("§a[Vip] " + p.getName());
			NametagEdit.getApi().setPrefix(p.getName(), "§a[VIP] ");
			p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §a§lVIP");
			p.setPlayerListName("§a[Vip] " + p.getName());
			return;
		}
		if (!p.hasPermission("tag.vip") && !p.hasPermission("tag.ruby") && !p.hasPermission("tag.champion")
				&& !p.hasPermission("tag.youtuber") && !p.hasPermission("tag.miniyt")
				&& !p.hasPermission("tag.ajudante") && !p.hasPermission("tag.moderador")
				&& !p.hasPermission("tag.gerente") && !p.hasPermission("tag.admin")
				&& !p.hasPermission("tag.coordenador") && !p.hasPermission("tag.diretor") && !p.isOp()) {
			p.setDisplayName("§7" + p.getName());
			NametagEdit.getApi().setPrefix(p.getName(), "§7");
			p.sendMessage(API.NomeServer + "§aVoce esta usando a tag §7§lMEMBRO");
			p.setPlayerListName("§7" + p.getName());
			return;
		}
	}

	/*
	 * 401 *
	 * 
	 * 
	 * /* 407
	 */
	/*     */
	/*     */
	/*     */
	@EventHandler
	public void onBauKit(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((p.getItemInHand().getType().equals(Material.DIAMOND)) && (p.getItemInHand().getItemMeta().hasDisplayName())
				&& !Habilidade.ContainsAbility(p) && Join.game.contains(p.getName())) {
			e.setCancelled(true);
			if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
				p.openInventory(Shop.shop);
				p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu")), 12.0F,
						1.0F);
			}
		}
	}

	@EventHandler
	public void onKit(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((p.getItemInHand().getType().equals(Material.COMPASS)) && (p.getItemInHand().getItemMeta().hasDisplayName())
				&& !Habilidade.ContainsAbility(p) && Join.game.contains(p.getName())) {
			e.setCancelled(true);
			if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
				Bukkit.dispatchCommand(p, "kpwarps");
				p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu")), 12.0F,
						1.0F);
			}
		}
	}

	@EventHandler
	public void onKit2(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((p.getItemInHand().getType().equals(Material.WOOD_SWORD))
				&& (p.getItemInHand().getItemMeta().hasDisplayName()) && !Habilidade.ContainsAbility(p)
				&& Join.game.contains(p.getName())) {
			e.setCancelled(true);
			if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
				ClickTest.StartClick(p);
			}
		}
	}

	@EventHandler
	public void onStats(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((p.getItemInHand().getType().equals(Material.NAME_TAG))
				&& (p.getItemInHand().getItemMeta().hasDisplayName()) && !Habilidade.ContainsAbility(p)
				&& Join.game.contains(p.getName())) {
			e.setCancelled(true);
			if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
				p.sendMessage("§b");
				int kills = KPPvP.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills");
				int deaths = KPPvP.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".deaths");
				p.sendMessage(KPPvP.messages.getString("Status").replace("&", "§").replace("%player%", p.getName()));
				p.sendMessage("");
				p.sendMessage(KPPvP.messages.getString("StatusKills").replace("&", "§") + kills);
				p.sendMessage(KPPvP.messages.getString("StatusDeaths").replace("&", "§") + deaths);
				p.sendMessage(KPPvP.messages.getString("StatusCoins").replace("&", "§") + Coins.getCoins(p.getName()));
				p.sendMessage(
						KPPvP.messages.getString("StatusKS").replace("&", "§") + Streak.killstreak.get(p.getName()));
				p.sendMessage(KPPvP.messages.getString("StatusXP").replace("&", "§") + XP.getXP(p.getName()));
				p.sendMessage(KPPvP.messages.getString("StatusLevel").replace("&", "§") + Level.getLevel(p));
				p.sendMessage("§b");
				p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu")), 12.0F,
						1.0F);
			}
		}
	}

	@EventHandler
	public void v1(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((p.getItemInHand().getType().equals(Material.CHEST)) && (p.getItemInHand().getItemMeta().hasDisplayName())
				&& !Habilidade.ContainsAbility(p) && Join.game.contains(p.getName())) {
			e.setCancelled(true);
			if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
				Bukkit.dispatchCommand(p, "kpkitmenu");
				p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu")), 12.0F,
						1.0F);
			}
		}
	}

	/*     */ public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3)
	/*     */ {
		/* 452 */ return false;
		/*     */ }
	/*     */ }
