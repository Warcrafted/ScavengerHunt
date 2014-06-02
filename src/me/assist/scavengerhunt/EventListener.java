package me.assist.scavengerhunt;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class EventListener implements Listener {

	private Core plugin;

	public EventListener(Core instance) {
		plugin = instance;
	}

	@EventHandler
	public void onSignChange(SignChangeEvent event) {
		String[] lines = event.getLines();

		if (lines[0].equalsIgnoreCase(ChatColor.stripColor("[ScavengerHunt]"))) {
			Player[] online = Bukkit.getServer().getOnlinePlayers();
			Player random = online[new Random().nextInt(online.length)];

			event.setLine(1, random.getName().length() > 16 ? (random.getName().subSequence(0, random.getName().length() - 2) + "..") : random.getName());

			int time = plugin.usingTimer();

			if (time != 0) {
				event.setLine(2, "Time: " + TimeUtil.formatIntoHHMMSS(time));

				Timer timer = new Timer(time);
				timer.runTaskTimer(plugin, 20, 20);
			}

			double reward = plugin.getReward();

			if (reward != 0) {
				event.setLine(3, (reward) + "$");
			}
		}
	}
}
