package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;

public class Ryu implements Listener, CommandExecutor
/*    */ {
	/*    */ private KPPvP main;
	/*    */ static KPPvP plugin;

	/*    */
	/*    */ public Ryu(KPPvP main)
	/*    */ {
		/* 20 */ this.main = main;
		/* 21 */ plugin = main;
		/*    */ }

	/*    */
	@EventHandler
	public void hadouken(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
				&& (Habilidade.getAbility(p).equalsIgnoreCase("Ryu"))
				&& (p.getItemInHand().getType() == Material.BEACON)) {
			if (Cooldown.add(p)) {
				API.MensagemCooldown(p);
				return;
			}

			e.setCancelled(true);
			p.updateInventory();

			Location location = p.getEyeLocation();
			BlockIterator blocksToAdd = new BlockIterator(location, 0.0D, 40);
			while (blocksToAdd.hasNext()) {
				Location blockToAdd = blocksToAdd.next().getLocation();
				p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, Material.LAVA, 20);
				p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.RyuAbility")), 3.0F,
						3.0F);
			}
			Snowball h = (Snowball) p.launchProjectile(Snowball.class);
			Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
			h.setVelocity(velo1);
			h.setMetadata("hadouken", new FixedMetadataValue(plugin, Boolean.valueOf(true)));
			Cooldown.add(p, KPPvP.kits.getInt("RyuCooldown"));
			return;
		}
	}

	@EventHandler
	public void dano(EntityDamageByEntityEvent e) {
		if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Snowball))) {
			Snowball s = (Snowball) e.getDamager();
			if (s.hasMetadata("hadouken")) {
				e.setDamage(e.getDamage() + KPPvP.kits.getDouble("RyuDamage"));
			}
		}
	}
	/*    */

	/*    */
	/*    */ public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	/*    */ {
		/* 27 */ Player p = (Player) sender;
		/*    */
		/* 29 */ if (cmd.getName().equalsIgnoreCase("kryu"))
		/*    */ {
			/*    */
			/*    */
			/*    */
			/* 34 */ if (Habilidade.ContainsAbility(p)) {
				/* 35 */ p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "??"))
						+ this.main.getConfig().getString("Message.KitUse").replace("&", "??"));
				/* 36 */ p.playSound(p.getLocation(),
						org.bukkit.Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
				/* 37 */ return true;
				/*    */ }
			/* 39 */ if (!p.hasPermission("kitpvp.kit.ryu"))
			/*    */ {
				/* 41 */ p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "??"))
						+ this.main.getConfig().getString("Permission").replace("&", "??").replaceAll("%permisson%",
								commandLabel));
				/* 42 */ p.playSound(p.getLocation(),
						Sound.valueOf(this.main.getConfig().getString("Sound.NoPermissionMessage")), 1.0F, 1.0F);
				/* 43 */ return true;
				/*    */ }
			/* 39 */ if (!Join.game.contains(p.getName()))
			/*    */ {
				/* 41 */ p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "??"))
						+ " ??eYou are not in kitpvp to choose this kit!");
				/* 42 */ return true;
				/*    */ }
			/* 44 */ p.getInventory().clear();
			/* 45 */ ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
			/* 46 */ ItemMeta souperaa = dima.getItemMeta();
			/* 47 */ souperaa.setDisplayName("??cSword");
			/* 48 */ dima.setItemMeta(souperaa);
			/* 49 */ ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
			/* 50 */ ItemMeta sopas = sopa.getItemMeta();
			/* 51 */ sopas.setDisplayName("??6Soup");
			/* 52 */ sopa.setItemMeta(sopas);
			ItemStack especial = new ItemStack(Material.BEACON);
			/* 61 */ ItemMeta especial2 = especial.getItemMeta();
			/* 62 */ especial2.setDisplayName("??bHadouken");
			/* 63 */ especial.setItemMeta(especial2);
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
			/* 67 */ Habilidade.setAbility(p, "Ryu");
			/* 68 */ p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "??"))
					+ this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Ryu").replace("&", "??"));
			/*    */
			/* 70 */ p.getInventory().addItem(new ItemStack[] { dima });
			/*    */ p.getInventory().addItem(new ItemStack[] { especial });
			/*    */
			/*    */
			/*    */ RTP.TeleportArenaRandom(p);
			/* 75 */ for (int i = 0; i <= 34; i++) {
				/* 76 */ p.getInventory().addItem(new ItemStack[] { sopa });
				/* 77 */ me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI.sendTitle(p, Integer.valueOf(20),
						Integer.valueOf(60), Integer.valueOf(20), this.main.getConfig().getString("Title.KitTitle"),
						this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Ryu"));
				/*    */ }
			KPPvP.give(p);
			/*    */ }
		/*    */
		/*    */
		/*    */
		/*    */
		/*    */
		/* 85 */ return false;
		/*    */ }
	/*    */ }
