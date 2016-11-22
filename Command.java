package uk.morrnd.dice;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String alias, String[] args) {
		Player player = (Player) sender;
		
		if(args.length == 0) {
			player.sendMessage(ChatColor.GOLD + "[MR]" + ChatColor.YELLOW + "Please add how many sides!");
			return false;
		} if(args.length > 1) {
			player.sendMessage(ChatColor.GOLD + "[MR]" + ChatColor.YELLOW + "Error: too many arguments provided.");
			return false;
		} else {
			try {
				Integer max = Integer.valueOf(args[0]);
				double random = Math.random() * max;
				float rvalue = (float)Math.ceil(random);
				
				player.sendMessage(ChatColor.GOLD + "[MR]" + ChatColor.YELLOW + "You rolled a " + args[0] + " and got a " + rvalue + "!");
				return true;
			}
			catch(Exception e) {
				player.sendMessage(ChatColor.GOLD + "[MR]" + ChatColor.YELLOW + "An error occurred.");
				return false;
			}
		}
	}
	
}
