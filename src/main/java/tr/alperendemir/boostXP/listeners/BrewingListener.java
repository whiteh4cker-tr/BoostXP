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

    public BrewingListener(ExperienceManager experienceManager) {
        this.experienceManager = experienceManager;
    }

    @EventHandler
    public void onBrew(BrewEvent event) {
        Block block = event.getBlock();
        BrewingStand brewingStand = (BrewingStand) block.getState();

        // Get the inventory of the brewing stand
        BrewerInventory inventory = brewingStand.getInventory();

        // Check if the brewing process is complete
        if (inventory.getContents().length == 0) {
            return; // No items in the brewing stand
        }

        // Find the closest player within 10 blocks
        List<Player> nearbyPlayers = block.getWorld().getPlayers().stream()
                .filter(player -> player.getLocation().distanceSquared(block.getLocation()) <= 100) // Within 10 blocks
                .toList();

        if (!nearbyPlayers.isEmpty()) {
            // Find the closest player
            Optional<Player> closestPlayer = nearbyPlayers.stream()
                    .min(Comparator.comparingDouble(player -> player.getLocation().distanceSquared(block.getLocation())));

            Player brewer = closestPlayer.get();
            experienceManager.giveExperience(brewer, 5);
        }
    }
}