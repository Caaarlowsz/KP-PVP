package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
/*    */
/*    */
/*    */ import org.bukkit.inventory.ItemStack;
/*    */
/*    */ import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/*    */ import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;

/*    */
/*    */ public class Camel implements org.bukkit.command.CommandExecutor, Listener
/*    */ {
	/*    */ private KPPvP main;
	/*    */ static KPPvP plugin;

	/*    */
	/*    */ public Camel(KPPvP main)
	/*    */ {
		/* 20 */ this.main = main;
		/* 21 */ plugin = main;
		/*    */ }

	/*    */ @EventHandler
	void onPlayerCamel(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND)
				|| (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SANDSTONE))
				&& (Habilidade.getAbility(p) == "Camel")) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, KPPvP.kits.getInt("CamelRegenTime") * 20,
					KPPvP.kits.getInt("CamelRegenAmplifier")));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, KPPvP.kits.getInt("CamelSpeedTime") * 20,
					KPPvP.kits.getInt("CamelSpeedAmplifier")));
		}
	}

	/*    */
	/*    */ public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	/*    */ {
		/* 27 */ Player p = (Player) sender;
		/*    */
		/* 29 */ if (cmd.getName().equalsIgnoreCase("kcamel"))
		/*    */ {
			/*    */
			/*    */ /* 69 */ if (!p.hasPermission("kitpvp.kit.camel"))
			/*     */ {
				/* 71 */ p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§"))
						+ this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%",
								commandLabel));
				/* 72 */ p.playSound(p.getLocation(),
						Sound.valueOf(this.main.getConfig().getString("Sound.NoPermissionMessage")), 1.0F, 1.0F);
				/* 73 */ return true;
				/*     */ }
			/*    */
			/* 34 */ if (Habilidade.ContainsAbility(p)) {
				/* 35 */ p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§"))
						+ this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
				/* 36 */ p.playSound(p.getLocation(),
						org.bukkit.Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
				/* 37 */ return true;
				/*    */ }
			/* 39 */ if (!Join.game.contains(p.getName()))
			/*    */ {
				/* 41 */ p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§"))
						+ " §eYou are not in kitpvp to choose this kit!");
				/* 42 */ return true;
				/*    */ }
			/* 44 */ p.getInventory().clear();
			/* 45 */ ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
			/* 46 */ ItemMeta souperaa = dima.getItemMeta();
			/* 47 */ souperaa.setDisplayName("§cSword");
			/* 48 */ dima.setItemMeta(souperaa);
			/* 49 */ ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
			/* 50 */ ItemMeta sopas = sopa.getItemMeta();
			/* 51 */ sopas.setDisplayName("§6Soup");
			/* 52 */ sopa.setItemMeta(sopas);
			/*    */
			/*    */
			/* 55 */ ItemStack capacete0 = new ItemStack(Material.IRON_HELMET);
			/*    */
			/* 57 */ ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
			/*    */
			/* 59 */ ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
			/*    */
			/* 61 */ ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
			/*    */
			/* 63 */ p.getInventory().setHelmet(capacete0);
			/* 64 */ p.getInventory().setChestplate(peitoral0);
			/* 65 */ p.getInventory().setLeggings(calca0);
			/* 66 */ p.getInventory().setBoots(Bota0);
			/* 67 */ Habilidade.setAbility(p, "Camel");
			/* 68 */ p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§"))
					+ this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Basic").replace("&", "§"));
			/*    */
			/* 70 */ p.getInventory().addItem(new ItemStack[] { dima });
			/*    */ RTP.TeleportArenaRandom(p);
			/*    */ KPPvP.give(p);
			/*    */
			/*    */
			/* 75 */ for (int i = 0; i <= 34; i++) {
				/* 76 */ p.getInventory().addItem(new ItemStack[] { sopa });
				/* 77 */ me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI.sendTitle(p, Integer.valueOf(5),
						Integer.valueOf(20), Integer.valueOf(5), this.main.getConfig().getString("Title.KitTitle"),
						this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Camel"));
				/*    */ }
			/*    */ }
		/*    */
		/*    */
		/*    */
		/*    */
		/*    */
		/* 85 */ return false;
		/*    */ }
	/*    */ }

/*
 * Location: D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12
 * (1).jar!\me\RafaelAulerDeMeloAraujo\SpecialAbility\Basic.class Java compiler
 * version: 8 (52.0) JD-Core Version: 0.7.1
 */
