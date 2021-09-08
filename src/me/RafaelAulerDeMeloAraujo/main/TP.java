package me.RafaelAulerDeMeloAraujo.main;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class TP
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(API.NomeServer + "Comandos apenas no servidor!");
      return true;
    }
    Player player = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("tp"))
    {
      if (!player.hasPermission("kitpvp.staff"))
      {
    	  player.sendMessage("§c§lERRO §fVoce nao tem permissão para executar esse comando");
        return true;
      }
      if (args.length == 0)
      {
        player.sendMessage(API.NomeServer + "Use /tp [player] para ir ate um player!");
        player.sendMessage(API.NomeServer + "Use /s [player] para puxar um player ate voce!");
        return true;
      }
      if (args.length == 1)
      {
        Player target = Bukkit.getPlayerExact(args[0]);
        if ((target == null) || (!(target instanceof Player)))
        {
          player.sendMessage(API.NomeServer + "Jogador nao encontrado!");
          return true;
        }
        player.teleport(target);
        player.sendMessage(API.NomeServer + "§aTeleportado para §a" + target.getName());
        Bukkit.getLogger().info("§c" + player.getName() + " Teleportou-se ate " + target.getName());
        Bukkit.broadcast(API.NomeServer + "§a" + player.getName() + ChatColor.GRAY + " se teleportou para: §a" + target.getName(), "kitpvp.staff");
        return true;
      }
      if (args.length > 1)
      {
        player.sendMessage(API.NomeServer + "Use /tp [player] para ir ate um player!");
        player.sendMessage(API.NomeServer + "Use /s [player] para puxar um player ate voce!");
        return true;
      }
    }
    else if (cmd.getName().equalsIgnoreCase("s"))
    {
      if (!player.hasPermission("kitpvp.staff"))
      {
        player.sendMessage(API.NomeServer + "Voce nao tem permissao para fazer isso!");
        return true;
      }
      if (args.length == 0)
      {
        player.sendMessage(API.NomeServer + "Use /tp [player] para ir ate um player!");
        player.sendMessage(API.NomeServer + "Use /s [player] para puxar um player ate voce!");
        return true;
      }
      if (args.length == 1)
      {
        Player target = Bukkit.getPlayerExact(args[0]);
        if ((target == null) || (!(target instanceof Player)))
        {
          player.sendMessage(API.NomeServer + "Jogador nao encontrado!");
          return true;
        }
        target.teleport(player);
        player.sendMessage(API.NomeServer + "Voce trouxe o jogador §a" + target.getName());
        Bukkit.getLogger().info("§c" + player.getName() + " puxou" + target.getName());
        Bukkit.broadcast(API.NomeServer + "§a" + player.getName() + ChatColor.GRAY + " puxou o jogador:" + target.getName() + " ate ele", "kitpvp.staff");
        return true;
      }
      if (args.length > 1)
      {
        player.sendMessage(API.NomeServer + "Use /tp [player] para ir ate um player!");
        player.sendMessage(API.NomeServer + "Use /s [player] para puxar um player ate voce!");
        return true;
      }
    }
    return false;
  }
}
