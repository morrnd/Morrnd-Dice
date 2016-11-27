package uk.morrnd.dice;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String alias, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(args.length == 0) {
				player.sendMessage(ChatColor.GOLD + "[MR]" + ChatColor.YELLOW + "Error: please specify the amount of sides you wish to roll.");
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
					
					int messageRange = 30;
					for(Entity e :player.getNearbyEntities(messageRange, messageRange, messageRange)){
						if(e instanceof Player){  
							((Player)e).sendMessage(ChatColor.GOLD + "[MR]" + ChatColor.YELLOW + player.getDisplayName() + " rolled a " + args[0] + " and got a " + rvalue + "!");
						}
					}
					return true;
				}
				catch(Exception e) {
					player.sendMessage(ChatColor.GOLD + "[MR]" + ChatColor.YELLOW + "An error occurred.");
					return false;
				}
			}
		} if(sender instanceof ConsoleCommandSender) {
			Logger log = Bukkit.getLogger();
			log.info("[MR]Error: this is a player only command.");
		}
		return false;
	}
	
}
