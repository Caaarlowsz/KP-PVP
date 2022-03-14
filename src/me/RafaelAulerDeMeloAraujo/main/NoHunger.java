/*    */
package me.RafaelAulerDeMeloAraujo.main;

/*    */
/*    */ import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;
import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.FoodLevelChangeEvent;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;

/*    */
/*    */ public class NoHunger implements Listener
/*    */ {

	/*    */
	/*    */
	/*    */ @EventHandler
	/*    */ public void onFall(FoodLevelChangeEvent e) {
		/*    */
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		Player p = (Player) e.getEntity();
		if ((Join.game.contains(p.getName())
				&& (KPPvP.getInstace().getConfig().getString("DisableHungerOnKitPvP").equalsIgnoreCase("true")))) {
			e.setCancelled(true);
		}

	}
}
