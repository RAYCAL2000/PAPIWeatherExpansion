package com.raycal;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WeatherExpansion extends PlaceholderExpansion {

    public WeatherExpansion() {
    }

    @Override
    @NotNull
    public String getAuthor() {
        return "RAYCAL2000";
    }

    @Override
    @NotNull
    public String getIdentifier() {
        return "weather";
    }

    @Override
    @NotNull
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onRequest(OfflinePlayer offlinePlayer, String identifier) {
        Player player = offlinePlayer.getPlayer();

        // Check if the player is null (offline or not logged in)
        if (player == null) {
            return ""; // Return empty string if the player is not online
        }

        // Split identifier by "_"
        String[] parts = identifier.split("_");
        String key = parts[0].toLowerCase(); // e.g., "duration", "condition", etc.
        String worldName = parts.length > 1 ? identifier.substring(identifier.indexOf("_") + 1) : null;

        // Determine the world to use
        World world = null;
        if (worldName != null) {
            world = Bukkit.getWorld(worldName);
            if (world == null) return ""; // Return empty string if world is invalid
        } else {
            world = player.getWorld(); // Default to the player's current world
        }

        // Return based on placeholder type
        return switch (key) {
            case "condition" -> WeatherUtil.getWeatherCondition(player, world);
            case "precipitation" -> WeatherUtil.getPrecipitation(player, world);
            case "thunder" -> String.valueOf(world.isThundering());
            case "duration" -> WeatherUtil.getWeatherDuration(world);
            default -> ""; // Return empty string for unrecognized keys
        };
    }
}