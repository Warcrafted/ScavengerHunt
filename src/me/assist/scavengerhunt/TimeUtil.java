package me.assist.scavengerhunt;

public class TimeUtil {

	public static String formatIntoHHMMSS(int secs) {
		int remainder = secs % 3600;
		int minutes = remainder / 60;
		int seconds = remainder % 60;

		return new StringBuilder().append(minutes).append(":").append(seconds < 10 ? "0" : "").append(seconds).toString();
	}
}
