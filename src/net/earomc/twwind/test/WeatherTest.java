package net.earomc.twwind.test;

import net.earomc.twwind.TWWind;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class WeatherTest implements Listener {

    private World world;

    public WeatherTest(World world) {
        this.world = world;
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        net.minecraft.server.v1_12_R1.World world1 = ((CraftWorld)world).getHandle();
        world1.getWorldData().I();
    }

    public void startDisplayingWeather() {
        new BukkitRunnable() {
            @Override
            public void run() {
                System.out.println("------------------");
                System.out.println("Weather Duration: " + world.getWeatherDuration());
                System.out.println("Is thundering: " + world.isThundering());
                System.out.println("Thunder Duration: " + world.getThunderDuration());
                System.out.println("------------------");
            }
        }.runTaskTimer(TWWind.getPlugin(), 0, 1);
    }

}
