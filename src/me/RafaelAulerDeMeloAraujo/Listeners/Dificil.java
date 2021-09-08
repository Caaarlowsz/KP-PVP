package me.RafaelAulerDeMeloAraujo.Listeners;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class Dificil
  implements Listener
{
  private Dificil plugin;
  
  public Dificil(Dificil instance)
  {
    this.plugin = instance;
  }
  
  public Dificil() {}
  
  @EventHandler
  public void onSignChange(SignChangeEvent e)
  {
    if (e.getLine(0).equalsIgnoreCase("Dificil"))
    {
      e.setLine(0, "§eChallenge");
      e.setLine(1, "§cRecompensa");
      e.setLine(2, "§cLV Dificil");
      e.setLine(3, "§eClique aqui");
    }
  }
  
  @EventHandler
  public void inv(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null) && (
      (e.getClickedBlock().getType() == Material.WALL_SIGN) || (e.getClickedBlock().getType() == Material.SIGN_POST)))
    {
      Sign s = (Sign)e.getClickedBlock().getState();
      String[] lines = s.getLines();
      if ((lines.length > 0) && (lines[0].equals("§eChallenge")) && 
        (lines.length > 1) && (lines[1].equals("§cRecompensa")) && 
        (lines.length > 2) && (lines[2].equals("§cLV Dificil")) && 
        (lines.length > 3) && (lines[3].equals("§eClique aqui")))
      {
        Coins.addCoins(p.getName(), 1000.0D);
        p.sendMessage("§aVoce ganhou 1000 coins por passar");
        p.sendMessage("§cO Nivel Dificil do challenge");
        
API.ItemSpawn(p);
        p.sendMessage(API.NomeServer+ "§a Voce voltou pro spawn");
      }
    }
  }
}
