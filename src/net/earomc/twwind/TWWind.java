package net.earomc.twwind;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class TWWind extends JavaPlugin {

    private static TWWind instance;
    private BukkitTask windUpdaterTask;
    private WindProvider windProvider;


    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage("§cActivated TW-Wind");
        windProvider = new WindProvider(Bukkit.getWorlds().get(0));
        windUpdaterTask = new WindUpdaterTask(windProvider).runTaskTimer(this, 0, 20);
    }

    public WindProvider getWindProvider() {
        return windProvider;
    }

    public static TWWind getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        windUpdaterTask.cancel();
        instance = null;
    }
}
