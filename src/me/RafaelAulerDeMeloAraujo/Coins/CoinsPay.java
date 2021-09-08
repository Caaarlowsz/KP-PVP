package me.RafaelAulerDeMeloAraujo.Coins;



import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



@SuppressWarnings("unused")
public class CoinsPay implements CommandExecutor {
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("paycoins")) {
			if (args.length == 0) {
					sender.sendMessage( "§c§l/paycoins [player] [amount]");
					return true;
				}
				Player target = Bukkit.getPlayerExact(args[0]);
				if ((target == null) || (!(target instanceof Player))) {
					sender.sendMessage("§c§lThe Player is offline");
					return true;
				}
				if (isNumeric(args[1])) {
					Double coins = Double.parseDouble(args[1]);
					Coins.addCoins(target.getName(), coins);
					Coins.removeCoins(sender.getName(), coins);
					sender.sendMessage( "§eYou pay the player " + target.getName() + "" + coins
							+ " §bCoins");
					target.sendMessage("§e"+ sender.getName() + "§e pay you " + coins
							+ " §bCoins!");
					target.sendMessage( "§6Your balance is updated!");
					Coins.loadCoins();
					
				}
				return false;
			}
	{
		
	}
	return false;
}
}