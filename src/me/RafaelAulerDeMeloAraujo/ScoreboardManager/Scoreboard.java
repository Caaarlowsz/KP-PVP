package me.RafaelAulerDeMeloAraujo.ScoreboardManager;

import org.bukkit.entity.Player;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.Coins.XP;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.main.AntiDeathDrop;

public class Scoreboard {

	public static void setScoreBoard(Player player) {
		SimpleScoreboard scoreboard = new SimpleScoreboard("§a§lKITPVP");

		int k = AntiDeathDrop.GetKills(player);
		int d = AntiDeathDrop.GetDeaths(player);
		scoreboard.add(" ");
		scoreboard.add("§f Matou: §a" + k);
		scoreboard.add("§f Morreu: §c" + d);
		scoreboard.add("§f Streak: §e" + Streak.killstreak.get(player.getName()));
		scoreboard.add(" ");
		scoreboard.add("§f Coins: §b" + Coins.getCoins(player.getName()));
		scoreboard.add("§f Nível: §b" + Level.getLevel(player));
		scoreboard.add(" ");
		scoreboard.add("§f XP: §b" + XP.getXP(player.getName()));
		scoreboard.add("§f Kit: §b" + Habilidade.getAbility(player));
		scoreboard.build();
		TablistPrefix tablistPrefix = new TablistPrefix(scoreboard.getScoreboard());
		tablistPrefix.applyPlayer();
		scoreboard.send(new Player[] { player });
	}
}