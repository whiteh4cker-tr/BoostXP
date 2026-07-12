package tr.alperendemir.boostXP.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import tr.alperendemir.boostXP.managers.ExperienceManager;

import java.util.Arrays;
import java.util.List;

public class BlockBreakListener implements Listener {

    private final ExperienceManager experienceManager;
    private final int xpAmount;
    private final List<Material> logTypes = Arrays.asList(
            Material.ACACIA_LOG, Material.BIRCH_LOG, Material.DARK_OAK_LOG,
            Material.JUNGLE_LOG, Material.OAK_LOG, Material.SPRUCE_LOG,
            Material.MANGROVE_LOG, Material.CHERRY_LOG
    );

    public BlockBreakListener(ExperienceManager experienceManager, int xpAmount) {
        this.experienceManager = experienceManager;
        this.xpAmount = xpAmount;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        if (logTypes.contains(block.getType())) {
            experienceManager.giveExperience(player, xpAmount);
        }
    }
}