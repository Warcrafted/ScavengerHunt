package me.assist.scavengerhunt;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class Util {

	public static void new_() {
		
	}
	
	public static Location stringToLocation(String str) {
		String[] split = str.split(":");

		if (split.length == 6) {
			World world = Bukkit.getWorld(split[0]);

			double x = Double.parseDouble(split[1]);
			double y = Double.parseDouble(split[2]);
			double z = Double.parseDouble(split[3]);

			float yaw = Float.parseFloat(split[4]);
			float pitch = Float.parseFloat(split[5]);

			return new Location(world, x, y, z, yaw, pitch);
		}

		return null;
	}

	public static String locationToString(Location loc, boolean block) {
		return loc.getWorld().getName() + ":" + (block ? loc.getBlockX() : loc.getX()) + ":" + (block ? loc.getBlockY() : loc.getY()) + ":" + (block ? loc.getBlockZ() : loc.getZ()) + ":" + loc.getYaw() + ":" + loc.getPitch();
	}
}
