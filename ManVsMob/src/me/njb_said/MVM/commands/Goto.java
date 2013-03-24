package me.njb_said.MVM.commands;

import me.njb_said.MVM.Main;
import me.njb_said.MVM.Util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Goto implements CommandExecutor {

	private Main plugin;
	public Goto(Main ins) {
		plugin = ins;
	}
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		  	if (cmd.getName().equalsIgnoreCase("goto")) {
		  		if (sender instanceof Player) {
		  			Player p = (Player)sender;
				  	if (Util.isAdminMode(p)) {
		  				if (args.length == 1) {
		  					if (args[0].equalsIgnoreCase("spawn")) {
		  						p.teleport(plugin.config.getSpawn());
		  						Main.sendMessage(p, "§9Teleported to §9§oSpawn");
		  					} else if (args[0].equalsIgnoreCase("lobby")) {
		  						p.teleport(plugin.config.getLobbySpawn());
		  						Main.sendMessage(p, "§9Teleported to §9§oLobby Spawn");
		  					} else if (args[0].equalsIgnoreCase("mob1")) {
		  						p.teleport(plugin.config.getMob1());
		  						Main.sendMessage(p, "§9Teleported to §9§oMob spawn 1");
		  						p.getWorld().spawnEntity(plugin.config.getMob1(), EntityType.ZOMBIE);
		  					} else if (args[0].equalsIgnoreCase("mob2")) {
		  						p.teleport(plugin.config.getMob2());
		  						Main.sendMessage(p, "§9Teleported to §9§oMob spawn 2");
		  						p.getWorld().spawnEntity(plugin.config.getMob2(), EntityType.ZOMBIE);
		  					} else if (args[0].equalsIgnoreCase("mob3")) {
		  						p.teleport(plugin.config.getMob3());
		  						Main.sendMessage(p, "§9Teleported to §9§oMob spawn 3");
		  						p.getWorld().spawnEntity(plugin.config.getMob3(), EntityType.ZOMBIE);
		  					} else if (args[0].equalsIgnoreCase("enchant")) {
		  						p.teleport(plugin.config.getEnchant());
		  						Main.sendMessage(p, "§9Teleported to §9§oEnchant toggle");
		  						Main.sendMessage(p, "§9Enchant toggle block is §9§o" + plugin.config.getEnchantID());
		  					} else {
		  						Main.sendMessage(p, "Usage: §5§o/goto [spawn|mob1|mob2|mob3|enchant]");
		  						Main.sendMessage(p, "§9Teleport to the spawns for MvM.");
		  					}
		  				} else {
	  						Main.sendMessage(p, "Usage: §5§o/goto [spawn|mob1|mob2|mob3|enchant]");
	  						Main.sendMessage(p, "§9Teleport to the spawns for MvM.");
		  				}
				  	} else {
				  		Util.adminMode(p);
				  	}
		  		}
		  	}
		  	return false;
	  }
}
