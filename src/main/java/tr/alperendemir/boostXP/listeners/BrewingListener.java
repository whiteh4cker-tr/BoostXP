package tr.alperendemir.boostXP.listeners;

import org.bukkit.block.Block;
import org.bukkit.block.BrewingStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.plugin.java.JavaPlugin;
import tr.alperendemir.boostXP.managers.ExperienceManager;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BrewingListener implements Listener {

    private final ExperienceManager experienceManager;
    private final JavaPlugin plugin;

    public BrewingListener(ExperienceManager experienceManager, JavaPlugin plugin) {
        this.experienceManager = experienceManager;
        this.plugin = plugin;
    }

    @EventHandler
    public void onBrew(BrewEvent event) {
        Block block = event.getBlock();
        BrewingStand brewingStand = (BrewingStand) block.getState();

        // Debug: Log that the event was triggered
        plugin.getLogger().info("BrewEvent triggered at " + block.getLocation());

        // Get the inventory of the brewing stand
        BrewerInventory inventory = brewingStand.getInventory();

        // Check if the brewing process is complete
        if (inventory.getContents().length == 0) {
            plugin.getLogger().info("Brewing stand is empty. Skipping XP reward.");
            return; // No items in the brewing stand
        }

        // Find the closest player within 10 blocks
        List<Player> nearbyPlayers = block.getWorld().getPlayers().stream()
                .filter(player -> player.getLocation().distanceSquared(block.getLocation()) <= 100) // Within 10 blocks
                .toList();

        // Debug: Log nearby players
        plugin.getLogger().info("Nearby players: " + nearbyPlayers.size());

        if (!nearbyPlayers.isEmpty()) {
            // Find the closest player
            Optional<Player> closestPlayer = nearbyPlayers.stream()
                    .min(Comparator.comparingDouble(player -> player.getLocation().distanceSquared(block.getLocation())));

            Player brewer = closestPlayer.get();
            experienceManager.giveExperience(brewer, 5);
            plugin.getLogger().info("Gave 5 XP to player: " + brewer.getName());
        } else {
            plugin.getLogger().info("No nearby players found.");
        }
    }
}