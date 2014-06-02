package me.assist.scavengerhunt;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class SignFile {

	private Core plugin;

	private File file;
	private FileConfiguration conf;

	public SignFile(Core instance) {
		plugin = instance;
	}

	public void load() {
		if (file == null) {
			file = new File(plugin.getDataFolder(), "signs.yml");
		}

		conf = YamlConfiguration.loadConfiguration(file);
	}

	public FileConfiguration getConfig() {
		if (conf == null) {
			load();
		}

		return conf;
	}

	public void save() {
		if (file == null || conf == null) {
			return;
		}

		try {
			getConfig().save(file);
		} catch (IOException ex) {
			plugin.getLogger().severe("Unable to save signs.yml.");
			ex.printStackTrace();
		}
	}

	public boolean delete() {
		if (file == null) {
			return false;
		}

		return file.delete();
	}
}
