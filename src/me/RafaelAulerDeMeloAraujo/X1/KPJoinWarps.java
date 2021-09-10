package me.RafaelAulerDeMeloAraujo.X1;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;
import me.RafaelAulerDeMeloAraujo.main.Main;

public class KPJoinWarps implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("kpjoinwarps")) {
			if (args.length == 0) {
				p.sendMessage("§e§l[!] §cEsse comando nao existe.");
				return true;
			}
			if (args[0].equalsIgnoreCase("fps")) {
				if (Habilidade.ContainsAbility(p)) {
					p.sendMessage("§4Voce ja escolheu um kit!");
					return true;
				}
				if ((Main.plugin.getConfig().getString("FPS.World")) == null) {
					p.sendMessage(API.NomeServer + "§eA Warp FPS nao esta setada!");
					return true;
				}
				p.getInventory().clear();
				World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("FPS.World"));
				double x = Main.plugin.getConfig().getDouble("FPS.X");
				double y = Main.plugin.getConfig().getDouble("FPS.Y");
				double z = Main.plugin.getConfig().getDouble("FPS.Z");
				Location lobby = new Location(w, x, y, z);
				lobby.setPitch((float) Main.plugin.getConfig().getDouble("FPS.Pitch"));
				lobby.setYaw((float) Main.plugin.getConfig().getDouble("FPS.Yaw"));
				p.getInventory().clear();
				p.teleport(lobby);
				p.setExp(0.0F);
				p.setExhaustion(20.0F);
				p.setFireTicks(0);
				p.setFoodLevel(20000);
				p.setHealth(20.0D);
				Habilidade.setAbility(p, "FPS");
				p.setAllowFlight(false);
				ItemStack capacete1 = new ItemStack(Material.IRON_HELMET);
				ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);

				ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);

				ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
				ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
				dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				ItemMeta souperaa = dima.getItemMeta();
				souperaa.setDisplayName("§bEspada");
				dima.setItemMeta(souperaa);
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
				ItemMeta sopas = sopa.getItemMeta();
				sopas.setDisplayName("§eSopa");
				sopa.setItemMeta(sopas);
				p.getInventory().addItem(new ItemStack[] { dima });
				p.getInventory().setChestplate(peitoral0);
				p.getInventory().setLeggings(calca0);
				p.getInventory().setBoots(Bota0);
				p.getInventory().setHelmet(capacete1);
				for (int i = 0; i <= 34; i++) {
					p.getInventory().addItem(new ItemStack[] { sopa });
				}
				p.sendMessage("§aBem vindo a warp §7FPS §a!");
				TitleAPI.sendTitle(p, Integer.valueOf(40), Integer.valueOf(40), Integer.valueOf(60), "§a§lWarp",
						"§f§lBem vindo a Fps!");
			}
			if (args[0].equalsIgnoreCase("knock")) {
				if (Habilidade.ContainsAbility(p)) {
					p.sendMessage("§4Voce ja escolheu um kit!");
					return true;
				}
				if ((Main.plugin.getConfig().getString("KNOCK.World")) == null) {
					p.sendMessage(API.NomeServer + "§eA Warp KNOCK nao esta setada!");
					return true;
				}
				p.getInventory().clear();
				World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("KNOCK.World"));
				double x = Main.plugin.getConfig().getDouble("KNOCK.X");
				double y = Main.plugin.getConfig().getDouble("KNOCK.Y");
				double z = Main.plugin.getConfig().getDouble("KNOCK.Z");
				Location lobby = new Location(w, x, y, z);
				lobby.setPitch((float) Main.plugin.getConfig().getDouble("KNOCK.Pitch"));
				lobby.setYaw((float) Main.plugin.getConfig().getDouble("KNOCK.Yaw"));
				p.getInventory().clear();
				p.teleport(lobby);
				p.setExp(0.0F);
				p.setExhaustion(20.0F);
				p.setFireTicks(0);
				p.setFoodLevel(20000);
				p.setHealth(20.0D);
				Habilidade.setAbility(p, "KNOCK");
				p.setAllowFlight(false);

				ItemStack dima = new ItemStack(Material.STICK);
				dima.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
				ItemMeta souperaa = dima.getItemMeta();
				souperaa.setDisplayName("§bStick!");
				dima.setItemMeta(souperaa);
				p.getInventory().addItem(new ItemStack[] { dima });
				p.sendMessage("§aBem vindo a warp §7KNOCK §a!");
				TitleAPI.sendTitle(p, Integer.valueOf(40), Integer.valueOf(40), Integer.valueOf(60), "§a§lWarp",
						"§f§lBem vindo a KNOCK!");
			}
			if (args[0].equalsIgnoreCase("pot")) {
				if (Habilidade.ContainsAbility(p)) {
					p.sendMessage("§4Voce ja escolheu um kit!");
					return true;
				}
				if ((Main.plugin.getConfig().getString("POT.World")) == null) {
					p.sendMessage(API.NomeServer + "§eA Warp POT nao esta setada!");
					return true;
				}
				p.getInventory().clear();
				World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("POT.World"));
				double x = Main.plugin.getConfig().getDouble("POT.X");
				double y = Main.plugin.getConfig().getDouble("POT.Y");
				double z = Main.plugin.getConfig().getDouble("POT.Z");
				Location lobby = new Location(w, x, y, z);
				lobby.setPitch((float) Main.plugin.getConfig().getDouble("POT.Pitch"));
				lobby.setYaw((float) Main.plugin.getConfig().getDouble("POT.Yaw"));
				p.getInventory().clear();
				p.teleport(lobby);
				p.setExp(0.0F);
				p.setExhaustion(20.0F);
				p.setFireTicks(0);
				p.setFoodLevel(20000);
				p.setHealth(20.0D);
				Habilidade.setAbility(p, "POTPVP");
				p.setAllowFlight(false);
				ItemStack capacete1 = new ItemStack(Material.IRON_HELMET);
				ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);

				ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);

				ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
				ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
				dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				ItemMeta souperaa = dima.getItemMeta();
				souperaa.setDisplayName("§bEspada");
				dima.setItemMeta(souperaa);
				ItemStack sopa = new ItemStack(Material.POTION, 1, (short) 16421);
				ItemMeta sopas = sopa.getItemMeta();
				sopas.setDisplayName("§ePotinho Magico");
				sopa.setItemMeta(sopas);
				p.getInventory().addItem(new ItemStack[] { dima });
				p.getInventory().setChestplate(peitoral0);
				p.getInventory().setLeggings(calca0);
				p.getInventory().setBoots(Bota0);
				p.getInventory().setHelmet(capacete1);
				for (int i = 0; i <= 34; i++) {
					p.getInventory().addItem(new ItemStack[] { sopa });
				}
				p.sendMessage("§aBem vindo a warp §7PotPvP §a!");
				TitleAPI.sendTitle(p, Integer.valueOf(40), Integer.valueOf(40), Integer.valueOf(60), "§a§lWarp",
						"§f§lBem vindo a PotPvP!");
			}
			if (args[0].equalsIgnoreCase("challenge")) {
				if (Habilidade.ContainsAbility(p)) {
					p.sendMessage("§4Voce ja escolheu um kit!");
					return true;
				}
				if ((Main.plugin.getConfig().getString("CHALLENGE.World")) == null) {
					p.sendMessage(API.NomeServer + "§eA Warp LavaChallenge nao esta setada!");
					return true;
				}
				p.getInventory().clear();
				World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("CHALLENGE.World"));
				double x = Main.plugin.getConfig().getDouble("CHALLENGE.X");
				double y = Main.plugin.getConfig().getDouble("CHALLENGE.Y");
				double z = Main.plugin.getConfig().getDouble("CHALLENGE.Z");
				Location lobby = new Location(w, x, y, z);
				lobby.setPitch((float) Main.plugin.getConfig().getDouble("CHALLENGE.Pitch"));
				lobby.setYaw((float) Main.plugin.getConfig().getDouble("CHALLENGE.Yaw"));
				p.getInventory().clear();
				p.teleport(lobby);
				p.setExp(0.0F);
				p.setExhaustion(20.0F);
				p.setFireTicks(0);
				p.setFoodLevel(20000);
				p.setHealth(20.0D);
				Habilidade.setAbility(p, "CHALLENGE");
				p.setAllowFlight(false);
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
				ItemMeta sopas = sopa.getItemMeta();
				sopas.setDisplayName("§eSopa");
				sopa.setItemMeta(sopas);
				Main.give(p);
				for (int i = 0; i <= 34; i++) {
					p.getInventory().addItem(new ItemStack[] { sopa });
				}
				p.sendMessage("§aBem vindo a warp §7Challenge §a!");
				TitleAPI.sendTitle(p, Integer.valueOf(40), Integer.valueOf(40), Integer.valueOf(60), "§a§lWarp",
						"§f§lBem vindo a Challenge!");
			}
		}
		return false;
	}
}
