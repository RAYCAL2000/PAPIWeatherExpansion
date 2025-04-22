package com.raycal;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class WeatherUtil {
    private static double SNOW_THRESHOLD = 0.15;
    private static double DRY_THRESHOLD = 0.95;

    // Formats ticks into the readable format of HH:MM:SS.
    public static String formatTimeFromTicks(int ticks) {
        int totalSeconds = ticks / 20;
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;

        if (hours > 0) {
            return String.format("%d:%02d:%02d", hours, minutes, seconds);
        } else {
            return String.format("%d:%02d", minutes, seconds);
        }
    }

    public static String getPrecipitation(Player player, World world) {
        if (!world.isClearWeather()) {
            Location loc = player.getLocation();
            double temp = world.getTemperature((int) loc.getX(), (int) loc.getY(), (int) loc.getZ());

            if (temp < SNOW_THRESHOLD) return "Snow";
            if (temp < DRY_THRESHOLD) return "Rain";
        }
        return "Clear";
    }

    public static String getWeatherCondition(Player player, World world) {
        String status = getPrecipitation(player, world);
        return world.isThundering() ? status + " & Thunder" : status;
    }

    public static String getWeatherDuration(World world) {
        int ticks;

        if (world.isClearWeather()) {
            ticks = world.getClearWeatherDuration();
        } else {
            ticks = world.getWeatherDuration();
        }

        return formatTimeFromTicks(ticks);
    }



}
