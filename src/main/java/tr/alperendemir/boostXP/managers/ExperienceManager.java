package tr.alperendemir.boostXP.managers;

import org.bukkit.entity.Player;

public class ExperienceManager {

    public void giveExperience(Player player, int amount) {
        player.giveExp(amount);
    }
}