package com.raycal;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
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
    public String onRequest(OfflinePlayer player, String identifier) {
        if (identifier.equalsIgnoreCase("info")) {
            return "Hello World!";
        }

        if (identifier.equalsIgnoreCase("noinfo")) {
            return "Goodbye World!";
        }

        return null; //
    }
}