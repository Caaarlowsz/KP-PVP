/*    */
package me.RafaelAulerDeMeloAraujo.Listeners;

/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/*    */
/*    */ import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;

/*    */
/*    */
/*    */ public class CommandsSounds/*    */ implements Listener
/*    */ {
	/*    */ private KPPvP main;

	/*    */
	/*    */ public CommandsSounds(KPPvP main)
	/*    */ {
		/* 19 */ this.main = main;
		/*    */ }

	/*    */
	/*    */
	/*    */
	/*    */
	/*    */
	/*    */ @EventHandler
	/*    */ public void writeCommands(PlayerCommandPreprocessEvent e)
	/*    */ {
		/* 29 */ if (this.main.getConfig().getString("EnableSoundsToAllCommands").equalsIgnoreCase("true")) {
			/* 30 */ e.getPlayer().playSound(e.getPlayer().getLocation(),
					Sound.valueOf(this.main.getConfig().getString("Sound.CommandsSounds")), 1.0F, 1.0F);
			/*    */ }
		/*    */ }
	/*    */ }

/*
 * Location: D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12
 * (1).jar!\me\RafaelAulerDeMeloAraujo\Listeners\CommandsSounds.class Java
 * compiler version: 8 (52.0) JD-Core Version: 0.7.1
 */
