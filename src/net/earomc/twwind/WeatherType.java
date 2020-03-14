package net.earomc.twwind;

public enum WeatherType {
    CLEAR(1f),
    RAIN(1.5f),
    THUNDER(2.5f);

    private float windMultiplier;

    WeatherType(float windMultiplier) {
        this.windMultiplier = windMultiplier;
    }

    public float getWindMultiplier() {
        return windMultiplier;
    }
}
