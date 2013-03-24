package me.njb_said.MVM.commands;

import me.njb_said.MVM.Main;
import me.njb_said.MVM.Util;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Map implements CommandExecutor {

	private Main plugin;
	public Map(Main ins) {
		plugin = ins;
	}
	

	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		  	if (cmd.getName().equalsIgnoreCase("set")) {
		  		if (sender instanceof Player) {
		  			Player p = (Player)sender;
				  	if (Util.isAdminMode(p)) {
		  				if (args.length == 1) {
		  					if (args[0].equalsIgnoreCase("spawn")) {
		  						Location l = p.getLocation();
		  						plugin.config.setSpawn(l);
		  						Main.sendMessage(p, "§9Spawn set.");
		  					} else if (args[0].equalsIgnoreCase("lobby")) {
		  						Location l = p.getLocation();
		  						plugin.config.setSpawn(l);
		  						Main.sendMessage(p, "§9Lobby Spawn set.");
		  					} else if (args[0].equalsIgnoreCase("mob1")) {
		  						Location l = p.getLocation();
		  						plugin.config.setMob1(l);
		  						Main.sendMessage(p, "§9Mob Spawn 1 set.");
		  					} else if (args[0].equalsIgnoreCase("mob2")) {
		  						Location l = p.getLocation();
		  						plugin.config.setMob2(l);
		  						Main.sendMessage(p, "§9Mob Spawn 2 set.");
		  					} else if (args[0].equalsIgnoreCase("mob3")) {
		  						Location l = p.getLocation();
		  						plugin.config.setMob3(l);
		  						Main.sendMessage(p, "§9Mob Spawn 3 set.");
		  					} else if (args[0].equalsIgnoreCase("enchant")) {
		  						Location l = p.getLocation();
		  						plugin.config.setEnchant(l);
		  						Main.sendMessage(p, "§9Enchantment toggle block set.");
		  					} else {
		  						Main.sendMessage(p, "Usage: §5§o/set [spawn|mob1|mob2|mob3|enchant]");
		  						Main.sendMessage(p, "§9Set the spawns for MvM.");
		  					}
		  				} else {
		  					Main.sendMessage(p, "Usage: §5§o/set [spawn|mob1|mob2|mob3|enchant]");
		  					Main.sendMessage(p, "§9Set the spawns for MvM.");
		  				}
				  	} else {
				  		Util.adminMode(p);
				  	}
		  		}
		  	}
		  	return false;
	  }
}
