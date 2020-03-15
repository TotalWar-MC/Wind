package net.earomc.twwind;

import org.bukkit.scheduler.BukkitRunnable;

public class WindUpdaterTask extends BukkitRunnable {

    private WindProvider windProvider;

    public WindUpdaterTask(WindProvider windProvider) {
        this.windProvider = windProvider;
    }

    @Override
    public void run() {
        windProvider.updateWind();
    }
}
