package tr.alperendemir.boostXP;

import org.bukkit.plugin.java.JavaPlugin;
import tr.alperendemir.boostXP.listeners.BlockBreakListener;
import tr.alperendemir.boostXP.listeners.BrewingListener;
import tr.alperendemir.boostXP.listeners.PlayerHarvestListener;
import tr.alperendemir.boostXP.managers.ExperienceManager;

public class BoostXP extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        int logXp = getConfig().getInt("experience.log-breaking", 1);
        int brewingXp = getConfig().getInt("experience.brewing", 5);
        int cropXp = getConfig().getInt("experience.crop-harvesting", 2);

        ExperienceManager experienceManager = new ExperienceManager();

        // Register event listeners
        getServer().getPluginManager().registerEvents(new BlockBreakListener(experienceManager, logXp), this);
        getServer().getPluginManager().registerEvents(new BrewingListener(experienceManager, brewingXp), this);
        getServer().getPluginManager().registerEvents(new PlayerHarvestListener(experienceManager, cropXp), this);

        getLogger().info("BoostXP has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("BoostXP has been disabled!");
    }
}