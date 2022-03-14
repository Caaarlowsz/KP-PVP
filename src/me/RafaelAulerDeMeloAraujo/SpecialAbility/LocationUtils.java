package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import com.github.caaarlowsz.kpmc.kitpvp.KPPvP;

public class LocationUtils {

	public static Location getLocation() {
		String wname = KPPvP.plugin.getConfig().getString("Spawn.World");

		if (wname == null || wname.equalsIgnoreCase("")) {
			return null;
		} else {
			World w = Bukkit.getServer().getWorld(wname);
			double x = KPPvP.plugin.getConfig().getDouble("Spawn.X");
			double y = KPPvP.plugin.getConfig().getDouble("Spawn.Y");
			double z = KPPvP.plugin.getConfig().getDouble("Spawn.Z");
			float yaw = KPPvP.plugin.getConfig().getInt("Spawn.Yaw");
			float pitch = KPPvP.plugin.getConfig().getInt("Spawn.Pitch");

			return new Location(w, x, y, z, yaw, pitch);
		}
	}
}