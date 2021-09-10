package me.RafaelAulerDeMeloAraujo.main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class Mensagens implements Listener {
	public static void start() {
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
			String[] msg = {

					"§fAchou um §4§LCHEATER? §fReporte ele utilizando o comando /report",
					"§fVeja o link do nosso §9§lDiscord §fdigitando /discord",
					"§fVocê pode comprar kits na loja de kits usando §eCoins",
					"§fUtilize /youtuber para ver os requisitos de Tag",
					"§fUtilize /ranks para ver as informações sobre o sistema de níveis",
					"§fUtilize /regras para ver as regras do Servidor.", };

			public void run() {
				Bukkit.broadcastMessage(API.NomeServer + this.msg[new java.util.Random().nextInt(this.msg.length)]);
			}
		}, 800L);
	}
}