package me.njb_said.MVM.commands;

import me.njb_said.MVM.Util;
import me.njb_said.MVM.Vanish;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Invis implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	   {
	     Player p = null;
	     if ((sender instanceof Player)) {
	       p = (Player)sender;
	     }
	     if (cmd.getName().equalsIgnoreCase("vanish")) {
	    	 if (Util.isAdminMode(p)) {
	    		 if (args.length == 0) {
						Vanish.vanish(p);
	  						p.sendMessage("§cYou are now invisible.");
	    		 } else if (args.length == 1) {
	    	    	 Player target = Bukkit.getServer().getPlayer(args[0]);
						Vanish.vanish(target);
	    			 target.sendMessage("§c" + p.getName() + "§c has made you invisible.");
	    			 p.sendMessage("§c" + target.getName() + " §cis now invisible.");
	    		 }
	    	 } else {
	    	 		Util.adminMode(p);
	    	 }
	     }
	  		if (cmd.getName().equalsIgnoreCase("unvanish")) {
		    	 if (Util.isAdminMode(p)) {
	  					if (args.length == 0) {
	  						Vanish.unVanish(p);
	  						p.sendMessage("§aYou are no longer invisible.");
	  					} else if (args.length == 1) {
	  					Player target = Bukkit.getServer().getPlayer(args[0]);
	  					Vanish.unVanish(target);
	  					target.sendMessage("§a" + p.getName() + "§a has made you visible.");
	  					p.sendMessage("§a" + target.getName() + " §ais no longer invisible.");
	  					}
	  				} else {
		    	 		Util.adminMode(p);
	  				}
	  		}
		return false;
	   }
}
