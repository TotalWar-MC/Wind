package net.earomc.twwind;

import org.bukkit.World;
import org.bukkit.util.noise.SimplexNoiseGenerator;

import java.util.Random;

public class WindProvider {

    private World world;
    private WeatherType weather;
    private Vector2 globalWindDirection;
    private double baseWindStrength;
    private double i = 0;
    private SimplexNoiseGenerator noiseGenerator;

    public WindProvider(World world) {
        this.world = world;
        this.globalWindDirection = new Vector2((int) (Math.random() * 10), (int) (Math.random() * 10));
        this.baseWindStrength = globalWindDirection.length();
        this.noiseGenerator = new SimplexNoiseGenerator(new Random().nextLong());

    }

    public void updateWind() {
        i+=0.2;
        if (i % 10000 == 0) {
            i = 0;
        }
        this.weather = getCurrentWeather();
        globalWindDirection.add(noiseGenerator.noise(i-2000), noiseGenerator.noise(i+2000));
        globalWindDirection.multiply(noiseGenerator.noise(i));
        this.baseWindStrength = globalWindDirection.length();
    }

    /**
     * @return returns the base wind strength without height and weather multiplier
     */
    public double getBaseWindStrength() {
        return baseWindStrength;
    }

    /**
     * Uses a function to calculate a wind strength multiplier based on height.
     * The function is: height = a * (x^2 - 2xc) or: height = a * (x-c)^2 - ac^2
     * @param y the height coordinate where you want to get the wind strength from.
     * @return returns the wind strength on a specific height.
     */
    public double getWindStrength(double y) {
        double a = 1/-8000d;
        double c = 256;
        double heightMultiplier = a * Math.pow(y-c, 2) - a*Math.pow(c, 2);
        return heightMultiplier * baseWindStrength * weather.getWindMultiplier();
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

    public Vector2 getGlobalWindDirection() {
        return globalWindDirection;
    }
}
