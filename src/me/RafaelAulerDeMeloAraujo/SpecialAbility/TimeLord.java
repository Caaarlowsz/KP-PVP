/*    */
package me.RafaelAulerDeMeloAraujo.SpecialAbility;

/*    */
/*    */ import java.util.ArrayList;

/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;

/*    */ import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;

/*    */
/*    */ public class TimeLord implements org.bukkit.event.Listener
/*    */ {
	/*    */ static KPPvP plugin;

	/*    */
	/*    */ public TimeLord(KPPvP main)
	/*    */ {
		/* 23 */ plugin = main;
		/*    */ }

	/*    */
	/*    */
	/*    */
	/* 28 */ public static ArrayList<String> playercongelados = new ArrayList<>();

	/*    */
	/*    */ @EventHandler
	/*    */ public void onTimerLord(PlayerInteractEvent e)
	/*    */ {
		/* 33 */ final Player p = e.getPlayer();
		/* 34 */ if ((Habilidade.getAbility(p).equalsIgnoreCase("TimeLord"))
				&& ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
				&& (p.getInventory().getItemInHand().getType() == org.bukkit.Material.WATCH)) {
			/* 35 */ if (Cooldown.add(p)) {
				/* 36 */ API.MensagemCooldown(p);
				/* 37 */ return;
				/*    */ }

			/* 39 */ Cooldown.add(p, KPPvP.kits.getInt("TimelordCooldown"));
			/* 40 */ p.sendMessage(
					String.valueOf(API.NomeServer) + KPPvP.messages.getString("TimelordUse").replace("&", "§"));
			/* 41 */ for (final Entity pertos : p.getNearbyEntities(KPPvP.kits.getDouble("TimelordRadius"),
					KPPvP.kits.getDouble("TimelordRadius"), KPPvP.kits.getDouble("TimelordRadius"))) {
				if (pertos instanceof Player) {
					if (!Habilidade.ContainsAbility((Player) pertos)) {
						return;
					}
					/* 42 */ playercongelados.add(((Player) pertos).getName());
					/* 43 */ ((Player) pertos).sendMessage(String.valueOf(API.NomeServer)
							+ KPPvP.messages.getString("Timelordfrozen").replace("&", "§"));
					/* 45 */ org.bukkit.Bukkit.getScheduler().scheduleSyncDelayedTask(KPPvP.plugin, new Runnable()
					/*    */ {
						/*    */ public void run() {
							/* 48 */ TimeLord.playercongelados.remove(((Player) pertos).getName());
							/* 49 */ ((Player) pertos).sendMessage(String.valueOf(API.NomeServer)
									+ KPPvP.messages.getString("TimelordUnfrozen").replace("&", "§"));
							/*    */ }
						/* 51 */ }, 160L);
					/*    */ {
						/* 53 */ org.bukkit.Bukkit.getScheduler().scheduleSyncDelayedTask(KPPvP.plugin, new Runnable()
						/*    */ {
							/*    */ public void run() {
								/* 56 */ p.sendMessage(API.fimcooldown);
								/*    */ }
							/* 58 */ }, KPPvP.kits.getInt("TimelordCooldown") * 20);
						/*    */ }
				}
			}
		}
		/*    */ }

	/*
	 * /*
	 */
	/*    */ @EventHandler
	/*    */ public void onTimerLordado(PlayerMoveEvent e) {
		/* 64 */ Player p = e.getPlayer();
		/* 65 */ if (playercongelados.contains(p.getName())) {
			/* 66 */ e.setTo(p.getLocation());
			/*    */ }
		/*    */ }
	/*    */
	/*    */ }

/*
 * Location: D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12
 * (1).jar!\me\RafaelAulerDeMeloAraujo\SpecialAbility\TimeLord.class Java
 * compiler version: 8 (52.0) JD-Core Version: 0.7.1
 */
