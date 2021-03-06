package me.RafaelAulerDeMeloAraujo.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;

public class SoupSign implements Listener {
	@EventHandler
	public void onSignChange(final SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("sopa") && e.getPlayer().hasPermission("kitpvp.createsigns")) {
			e.setLine(0, KPPvP.messages.getString("SoupSignLine1").replace("&", "§"));
			e.setLine(1, KPPvP.messages.getString("SoupSignLine2").replace("&", "§"));
			e.setLine(2, KPPvP.messages.getString("SoupSignLine3").replace("&", "§"));
			e.setLine(3, KPPvP.messages.getString("SoupSignLine4").replace("&", "§"));
		}
	}

	@EventHandler
	public void inv(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack sopas = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta sopasm = sopas.getItemMeta();
		sopasm.setDisplayName("§6Sopa");
		sopas.setItemMeta(sopasm);
		final Inventory inve = Bukkit.getServer().createInventory((InventoryHolder) p, 36, "§bSopas gratis!");
		inve.setItem(0, sopas);
		inve.setItem(1, sopas);
		inve.setItem(2, sopas);
		inve.setItem(3, sopas);
		inve.setItem(4, sopas);
		inve.setItem(5, sopas);
		inve.setItem(6, sopas);
		inve.setItem(7, sopas);
		inve.setItem(8, sopas);
		inve.setItem(9, sopas);
		inve.setItem(10, sopas);
		inve.setItem(11, sopas);
		inve.setItem(12, sopas);
		inve.setItem(13, sopas);
		inve.setItem(14, sopas);
		inve.setItem(15, sopas);
		inve.setItem(16, sopas);
		inve.setItem(17, sopas);
		inve.setItem(18, sopas);
		inve.setItem(19, sopas);
		inve.setItem(20, sopas);
		inve.setItem(21, sopas);
		inve.setItem(22, sopas);
		inve.setItem(23, sopas);
		inve.setItem(24, sopas);
		inve.setItem(25, sopas);
		inve.setItem(26, sopas);
		inve.setItem(27, sopas);
		inve.setItem(28, sopas);
		inve.setItem(29, sopas);
		inve.setItem(30, sopas);
		inve.setItem(31, sopas);
		inve.setItem(32, sopas);
		inve.setItem(33, sopas);
		inve.setItem(34, sopas);
		inve.setItem(35, sopas);
		if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null)
				&& ((e.getClickedBlock().getType() == Material.SIGN_POST)
						|| (e.getClickedBlock().getType() == Material.WALL_SIGN))) {
			final Sign s = (Sign) e.getClickedBlock().getState();
			final String[] lines = s.getLines();
			if (lines.length > 0 && lines[0].equals(KPPvP.messages.getString("SoupSignLine1").replace("&", "§"))
					&& lines.length > 1 && lines[1].equals(KPPvP.messages.getString("SoupSignLine2").replace("&", "§"))
					&& lines.length > 2 && lines[2].equals(KPPvP.messages.getString("SoupSignLine3").replace("&", "§"))
					&& lines.length > 3 && lines[3].equals(KPPvP.messages.getString("SoupSignLine4").replace("&", "§"))
					&& Join.game.contains(p.getName())) {
				p.openInventory(inve);
			}
		}
	}

}
