/*     */
package me.RafaelAulerDeMeloAraujo.SpecialAbility;

/*     */
/*     */ import java.util.ArrayList;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.block.BlockIgniteEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;

/*     */ import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ public class Thor/*     */ implements Listener
/*     */ {
	/*     */ public KPPvP plugin;

	/*     */
	/*     */ public Thor(KPPvP main)
	/*     */ {
		/* 49 */ this.plugin = main;
		/*     */ }

	/*     */
	/* 52 */ public static ArrayList<String> cooldown = new ArrayList<>();

	/*     */
	/*     */ @EventHandler
	/*     */ public void onPlayerThor(PlayerInteractEvent e)
	/*     */ {
		/* 57 */ final Player p = e.getPlayer();
		/*     */
		/* 59 */ if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
			/* 60 */ return;
			/*     */ }
		/* 62 */ if ((p.getItemInHand().getType() == Material.GOLD_AXE) &&
		/* 63 */ (Habilidade.getAbility(p) == "Thor"))
		/*     */ {
			/* 65 */ if (Cooldown.add(p))
			/*     */ {
				/* 67 */ e.setCancelled(true);
				/* 68 */ API.MensagemCooldown(p);
				/* 69 */ return;
				/*     */ }

			/* 72 */ e.setCancelled(true);
			/* 73 */ Block b = e.getClickedBlock();
			/*     */
			/* 75 */ World w = p.getWorld();
			/*     */
			/* 77 */ Location loc = w.getHighestBlockAt(b.getLocation()).getLocation();
			p.getWorld().strikeLightning(loc);
			p.getWorld().strikeLightning(loc);
			p.getWorld().strikeLightning(loc);
			p.getWorld().strikeLightning(loc);
			/* 80 */ Cooldown.add(p, KPPvP.kits.getInt("ThorCooldown"));
			/* 81 */ Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
			/*     */ {
				/*     */ public void run()
				/*     */ {
					/* 85 */ Cooldown.remove(p);
					/* 86 */ p.sendMessage(API.fimcooldown);
					/*     */ }
				/* 88 */ }, KPPvP.kits.getInt("ThorCooldown") * 20);
			/*     */ }
		/*     */ }

	/*     */
	/*     */ @EventHandler
	/*     */ public void OnBlock(BlockIgniteEvent e)
	/*     */ {
		/* 95 */ if (e.getCause() == BlockIgniteEvent.IgniteCause.LIGHTNING) {
			/* 96 */ e.setCancelled(true);
		}
		/*     */ }

	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */
	/*     */ @EventHandler
	/*     */ public void OnBlockBB(EntityDamageEvent e)
	/*     */ {
		/* 110 */ if (!(e.getEntity() instanceof Player)) {
			/* 111 */ return;
			/*     */ }
		/* 113 */ Player p = (Player) e.getEntity();
		/* 114 */ if ((Habilidade.getAbility(p) == "Thor")
				&& (e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING)) {
			/* 115 */ e.setCancelled(true);
			/*     */ }
		/*     */ }
}

/*
 * Location: D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12
 * (1).jar!\me\RafaelAulerDeMeloAraujo\SpecialAbility\Thor.class Java compiler
 * version: 8 (52.0) JD-Core Version: 0.7.1
 */
