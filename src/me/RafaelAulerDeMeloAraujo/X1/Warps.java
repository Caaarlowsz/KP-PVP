package me.RafaelAulerDeMeloAraujo.X1;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Warps implements Listener, CommandExecutor {
	@EventHandler
	public void warps(InventoryClickEvent e) {
		if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
			Inventory inv = e.getInventory();
			Player p = (Player) e.getWhoClicked();
			if (inv.getTitle().equals("Warps")) {
				p.playSound(p.getLocation(), Sound.DOOR_CLOSE, 5.0F, 5.0F);
				e.setCancelled(true);
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aFPS")) {
					Bukkit.dispatchCommand(p, "kpjoinwarps fps");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aKNOCK")) {
					Bukkit.dispatchCommand(p, "kpjoinwarps knock");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aPOTPVP")) {
					Bukkit.dispatchCommand(p, "kpjoinwarps pot");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aLavaChallenge")) {
					Bukkit.dispatchCommand(p, "kpjoinwarps challenge");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a1v1")) {
					X1.entrar1v1(p);
					p.closeInventory();
				}
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("kpwarps")) {
			Inventory warps = Bukkit.createInventory(p, 9, "Warps");

			ItemStack fps = new ItemStack(Material.GLASS);
			ItemMeta fps2 = fps.getItemMeta();
			fps2.setDisplayName("§aFPS");
			List<String> lore1 = new ArrayList<String>();
			lore1.add("§7Warp para aumentar o FPS do seu mine !");
			fps2.setLore(lore1);
			fps.setItemMeta(fps2);

			ItemStack pot = new ItemStack(Material.POTION);
			ItemMeta pot1 = pot.getItemMeta();
			pot1.setDisplayName("§aPOTPVP");
			List<String> lore9 = new ArrayList<String>();
			lore9.add("§7Warp para tirar pvp com poções!");
			pot1.setLore(lore9);
			pot.setItemMeta(pot1);

			ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
			ItemMeta lava2 = lava.getItemMeta();
			lava2.setDisplayName("§aLavaChallenge");
			List<String> lore2 = new ArrayList<String>();
			lore2.add("§7Treine seu refil e recraft nesta warp !");
			lava2.setLore(lore2);
			lava.setItemMeta(lava2);

			ItemStack v1 = new ItemStack(Material.BLAZE_ROD);
			ItemMeta v12 = v1.getItemMeta();
			v12.setDisplayName("§a1v1");
			List<String> lore3 = new ArrayList<String>();
			lore3.add("§7Tire um x1 com outros jogadores !");
			v12.setLore(lore3);
			v1.setItemMeta(v12);

			ItemStack vinagre = new ItemStack(Material.STICK);
			ItemMeta vinagre1 = vinagre.getItemMeta();
			vinagre1.setDisplayName("§aKNOCK");
			List<String> lore4 = new ArrayList<String>();
			lore4.add("§7Tente derrubar o outro para fora da arena !");
			vinagre1.setLore(lore4);
			vinagre.setItemMeta(vinagre1);

			warps.setItem(0, fps);
			warps.setItem(1, v1);
			warps.setItem(2, lava);
			warps.setItem(3, pot);
			warps.setItem(4, vinagre);

			p.openInventory(warps);
		}

		{
		}
		return false;
	}
}
