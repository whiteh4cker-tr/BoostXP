package tr.alperendemir.boostXP.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import tr.alperendemir.boostXP.managers.ExperienceManager;

import java.util.Arrays;
import java.util.List;

public class PlayerHarvestListener implements Listener {

    private final ExperienceManager experienceManager;
    private final List<Material> cropTypes = Arrays.asList(
            Material.WHEAT, Material.CARROTS, Material.POTATOES,
            Material.BEETROOTS, Material.NETHER_WART
    );

    public PlayerHarvestListener(ExperienceManager experienceManager) {
        this.experienceManager = experienceManager;
    }

    @EventHandler
    public void onHarvest(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        if (cropTypes.contains(block.getType())) {
            if (block.getBlockData() instanceof Ageable) {
                Ageable ageable = (Ageable) block.getBlockData();
                if (ageable.getAge() == ageable.getMaximumAge()) {
                    experienceManager.giveExperience(player, 2); // Give 2 XP per fully grown crop
                }
            }
        }
    }
}