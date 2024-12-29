package tr.alperendemir.boostXP;

import org.bukkit.plugin.java.JavaPlugin;
import tr.alperendemir.boostXP.listeners.BlockBreakListener;
import tr.alperendemir.boostXP.listeners.BrewingListener;
import tr.alperendemir.boostXP.listeners.PlayerHarvestListener;
import tr.alperendemir.boostXP.managers.ExperienceManager;

public class BoostXP extends JavaPlugin {

    @Override
    public void onEnable() {
        ExperienceManager experienceManager = new ExperienceManager();

        // Register event listeners
        getServer().getPluginManager().registerEvents(new BlockBreakListener(experienceManager), this);
        getServer().getPluginManager().registerEvents(new BrewingListener(experienceManager), this); // Pass the plugin instance
        getServer().getPluginManager().registerEvents(new PlayerHarvestListener(experienceManager), this);

        getLogger().info("BoostXP has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("BoostXP has been disabled!");
    }
}