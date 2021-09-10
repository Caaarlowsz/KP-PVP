package me.RafaelAulerDeMeloAraujo.Listeners;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class Facil implements Listener {

	public Facil(Facil instance) {
	}

	public Facil() {
	}

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("Facil")) {
			e.setLine(0, "§eChallenge");
			e.setLine(1, "§cRecompensa");
			e.setLine(2, "§cLV Facil");
			e.setLine(3, "§eClique aqui");
		}
	}

	@EventHandler
	public void inv(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null)
				&& ((e.getClickedBlock().getType() == Material.WALL_SIGN)
						|| (e.getClickedBlock().getType() == Material.SIGN_POST))) {
			Sign s = (Sign) e.getClickedBlock().getState();
			String[] lines = s.getLines();
			if ((lines.length > 0) && (lines[0].equals("§eChallenge")) && (lines.length > 1)
					&& (lines[1].equals("§cRecompensa")) && (lines.length > 2) && (lines[2].equals("§cLV Facil"))
					&& (lines.length > 3) && (lines[3].equals("§eClique aqui"))) {
				Coins.addCoins(p.getName(), 200.0D);
				p.sendMessage("§aVoce ganhou 200 coins por passar");
				p.sendMessage("§cO Nivel Facil do challenge");

				API.ItemSpawn(p);
				p.sendMessage(API.NomeServer + "§a Voce voltou pro spawn");
			}
		}
	}
}
