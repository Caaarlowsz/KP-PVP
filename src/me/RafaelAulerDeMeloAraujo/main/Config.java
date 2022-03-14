
package me.RafaelAulerDeMeloAraujo.main;

import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;

public class Config {
	private static KPPvP main;

	public Config(KPPvP main) {
	}

	public static String tr(String s) {
		return String.valueOf(main.getConfig().getString("Prefix").replace("&", "§"));
	}
}
