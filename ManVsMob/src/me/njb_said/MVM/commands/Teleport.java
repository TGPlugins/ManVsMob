package me.njb_said.MVM.commands;

import me.njb_said.MVM.Util;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor {

	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		  if (cmd.getName().equalsIgnoreCase("tp")) {
			  
			  if (sender instanceof Player) {
				  	Player p = (Player) sender;
				  	if (p.isOp() || p.hasPermission("mvm.modplus") || Util.isAdminMode(p)) {
				  		if (args.length == 0) {
				  			Util.sendMessage(p, "Teleport menu:");
				  			Util.sendMessage(p, "§e/teleport <name> §d- §aTeleport to a player");
				  			Util.sendMessage(p, "§e/teleport <name> [other-name] §d- §aTeleport a player to another player");
				  			p.sendMessage(" ");
				  		} else if (args.length == 1) {
				  			Player target = Bukkit.getPlayer(args[0]);
				  			if (target != null) {
				  				Util.sendMessage(p, "§9Teleporting to " +target.getDisplayName());
				  				p.teleport(target);
				  			} else {
				  				Util.sendMessage(p, "§b§l'"+args[0]+"' §dcouldnt be found.");
				  			}
				  		} else if (args.length == 2) {
				  			Player p1 = Bukkit.getPlayer(args[0]);
				  			Player p2 = Bukkit.getPlayer(args[1]);
				  			if (p1 != null) {
				  				if (p2 != null) {
				  					Util.sendMessage(p, "§9Teleporting "+p1.getDisplayName()+" §9to "+p2.getDisplayName()+ "§9.");
				  					Util.sendMessage(p1, "§9"+p.getDisplayName()+" §9has teleported you to §9"+p2.getDisplayName()+"§9.");
				  					p1.teleport(p2);
				  				} else {
					  				Util.sendMessage(p, "§b§l'"+args[1]+"' §dcouldnt be found.");
				  				}
				  			} else {
				  				Util.sendMessage(p, "§b§l'"+args[0]+"' §dcouldnt be found.");
				  			}
				  		}
				  	} else {
				  		Util.noPerms(p);
				  	}
			  }
		  }
		  if (cmd.getName().equalsIgnoreCase("tpall")) {
			  
			  if (sender instanceof Player) {
				  	Player p = (Player) sender;
				  	if (p.isOp() || p.hasPermission("mvm.modplus") || Util.isAdminMode(p)) {
				  		if (args.length == 0) {
				  			Util.sendMessage(p, "§9Teleporting all to you.");
				  			Util.bc("§9Teleporting all to " + p.getDisplayName());
				  			for (Player pp : Bukkit.getOnlinePlayers()) {
				  				if (pp.getName().equals(p.getName())) {
				  					continue;
				  				}
				  				pp.teleport(p);
				  			}
				  		} else if (args.length == 1) {
				  			Player target = Bukkit.getPlayer(args[0]);
				  			if (target != null) {
				  				Util.sendMessage(p, "§9Teleporting all to "+target.getDisplayName());
				  				Util.bc("§9Teleporting all to " +target.getDisplayName());
					  			for (Player pp : Bukkit.getOnlinePlayers()) {
					  				if (pp.getName().equals(target.getName())) {
					  					continue;
					  				}
					  				pp.teleport(p);
					  			}
				  			}
				  		}
				  	} else {
				  	Util.noPerms(p);
				  	}
			  }
		  }
		  return false;
	  }
}
