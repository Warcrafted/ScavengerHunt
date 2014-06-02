package me.assist.scavengerhunt;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

	private Economy economy = null;

	public void onEnable() {
		saveDefaultConfig();

		if (getServer().getPluginManager().getPlugin("Vault") != null) {
			getLogger().info("Found Vault, attempting to hook...");

			if (setupEconomy()) {
				getLogger().info("Succesfully hooked into Vault.");
			} else {
				getLogger().severe("Unable to hook into Vault.");
			}
		}
	}

	public double getReward() {
		return economy != null ? getConfig().getDouble("economy.reward") : 0.0;
	}

	public int usingTimer() {
		return getConfig().getBoolean("timer.enabled") ? getConfig().getInt("timer.time") : 0;
	}

	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);

		if (economyProvider != null) {
			economy = economyProvider.getProvider();
		}

		return (economy != null);
	}
}
