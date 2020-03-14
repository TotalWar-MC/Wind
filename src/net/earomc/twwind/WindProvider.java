package net.earomc.twwind;

import org.bukkit.World;

public class WindProvider {


    private World world;
    private WeatherType weather;

    public WindProvider(World world) {
        this.world = world;
    }

    private void updateWind() {
        this.weather = getCurrentWeather();
    }




    public WeatherType getCurrentWeather() {
        if (world.isThundering() && world.hasStorm()) {
            return WeatherType.THUNDER;
        }
        if (world.hasStorm() && !world.isThundering()) {
            return WeatherType.RAIN;
        }
        return WeatherType.CLEAR;
    }

    public WeatherType getWeather() {
        return weather;
    }
}
