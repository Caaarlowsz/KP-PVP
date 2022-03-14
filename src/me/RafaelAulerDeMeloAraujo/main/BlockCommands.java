/*    */
package me.RafaelAulerDeMeloAraujo.main;

/*    */ import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/*    */
/*    */ public class BlockCommands implements org.bukkit.event.Listener
/*    */ {
	/*    */ private KPPvP main;
	/*    */ static KPPvP plugin;

	/*    */
	/*    */ public BlockCommands(KPPvP main)
	/*    */ {
		/* 15 */ this.main = main;
		/* 16 */ plugin = main;
		/*    */ }

	/*    */
	/*    */ @org.bukkit.event.EventHandler
	/*    */ public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
		/* 21 */ if ((!e.getPlayer().hasPermission("kitpvp.unblockedcmds")) && (!e.getPlayer().isOp()) &&
		/* 22 */ (KPPvP.plugin.getConfig().isSet("BLOCKED_COMMANDS"))
				&& (me.RafaelAulerDeMeloAraujo.SpecialAbility.Join.game.contains(e.getPlayer().getName()) && (KPPvP
						.getInstace().getConfig().getString("EnableCommandBlockingInKitPvP").equalsIgnoreCase("true"))))
		/*    */ {
			/* 24 */ java.util.List<String> list = KPPvP.plugin.getConfig().getStringList("BLOCKED_COMMANDS");
			/* 25 */ if (list.contains(e.getMessage()))
			/*    */ {
				/* 27 */ e.setCancelled(true);
				/* 28 */ e.getPlayer().sendMessage(
						String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + String.valueOf(
								this.main.getConfig().getString("Message.BlockedCMD-OnKitPvP").replace("&", "§")));
				/*    */ }
			/*    */ }
		/*    */ }
	/*    */ }

/*
 * Location: D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12
 * (1).jar!\me\RafaelAulerDeMeloAraujo\main\BlockCommands.class Java compiler
 * version: 8 (52.0) JD-Core Version: 0.7.1
 */
