package me.RafaelAulerDeMeloAraujo.Coins;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.configuration.file.YamlConfiguration;

import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;

public class Coins {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static HashMap<String, Double> bal = new HashMap();

	public static HashMap<String, Double> getCoinsMap() {
		return bal;
	}

	public static Double getCoins(String player) {
		File playersfile = new File(KPPvP.plugin.getDataFolder() + File.separator, "user-data.yml");
		YamlConfiguration players = YamlConfiguration.loadConfiguration(playersfile);
		return Double.valueOf(players.getDouble("Coins." + player));
	}

	public static boolean hasAccount(String player) {
		File playersfile = new File(KPPvP.plugin.getDataFolder() + File.separator, "user-data.yml");
		YamlConfiguration players = YamlConfiguration.loadConfiguration(playersfile);
		return players.contains(player);
	}

	public static void setCoins(String player, double amount) {
		bal.put(player, Double.valueOf(amount));
		saveCoins();
	}

	public static void addCoins(String player, double amount) {
		bal.put(player, Double.valueOf(getCoins(player).doubleValue() + amount));
		saveCoins();
	}

	public static void removeCoins(String player, double amount) {
		bal.put(player, Double.valueOf(getCoins(player).doubleValue() - amount));
		saveCoins();
	}

	public static void saveCoins() {
		File playersfile = new File(KPPvP.plugin.getDataFolder() + File.separator, "user-data.yml");
		YamlConfiguration players = YamlConfiguration.loadConfiguration(playersfile);
		for (String p : getCoinsMap().keySet()) {
			players.set("Coins." + p, getCoinsMap().get(p));
			try {
				players.save(playersfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void loadCoins() {
		File playersfile = new File(KPPvP.plugin.getDataFolder() + File.separator, "user-data.yml");
		YamlConfiguration.loadConfiguration(playersfile);
	}
}
