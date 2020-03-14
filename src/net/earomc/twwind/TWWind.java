package net.earomc.twwind;

import net.earomc.twwind.test.WeatherTest;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TWWind extends JavaPlugin {

    private static TWWind plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getConsoleSender().sendMessage("§cActivated TW-Wind");
        WeatherTest weatherTest = new WeatherTest(Bukkit.getWorld("world"));
        weatherTest.startDisplayingWeather();
    }

    public static TWWind getPlugin() {
        return plugin;
    }
}
