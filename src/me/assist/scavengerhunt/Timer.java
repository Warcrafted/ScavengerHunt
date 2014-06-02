package me.assist.scavengerhunt;

import org.bukkit.scheduler.BukkitRunnable;

public class Timer extends BukkitRunnable {
	
	private int time = 0;
	
	public Timer(int time) {
		this.time = time;
	}

	@Override
	public void run() {
		time--;
		
		if(time == 0) {
			this.cancel();
		}
	}
	
	public int getTime() {
		return time;
	}
}
