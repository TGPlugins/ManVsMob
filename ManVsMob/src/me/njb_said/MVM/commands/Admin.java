package me.njb_said.MVM.commands;

import me.njb_said.MVM.Util;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Admin implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	   {
	     Player p = null;
	     if ((sender instanceof Player)) {
	       p = (Player)sender;
	     }
 		if ((p.isOp()) || (p.hasPermission("mvm.modplus"))) {
    		 if (args.length == 0) {
 				if (!Util.AdminModeList.contains(p)) {
 					p.sendMessage("§9§oYou are now in §c§nadmin mode.");
 					p.sendMessage("§7§oUse /admin <name> to put another player into/out of admin mode.");
 					p.setGameMode(GameMode.CREATIVE);
 					Util.AdminModeList.add(p);
 				} else if (Util.AdminModeList.contains(p)) {
 					Util.AdminModeList.remove(p);
 					p.sendMessage("§9§oYou are no longer in §c§nadmin mode.");
 					p.sendMessage("§7§oUse /admin <name> to put another player into/out of admin mode.");
 					p.setGameMode(GameMode.ADVENTURE);
 					if (Util.isSpectator(p)) {
 					p.setAllowFlight(true);
 					} else {
 						if (!Util.MVMIngame) {
 						p.setAllowFlight(true);
 						} else {
 							p.setAllowFlight(false);
 						}
 					}
 					}
    		 } else if (args.length == 1) {
    	    	 Player target = Bukkit.getServer().getPlayer(args[0]);
	 				if (!Util.AdminModeList.contains(target)) {
	 					p.sendMessage("§9§o"+target.getName()+" is now in §c§nadmin mode.");
	 					target.sendMessage("§9§oYou are now in §c§nadmin mode.");
	 					target.setGameMode(GameMode.CREATIVE);
	 					Util.AdminModeList.add(target);
	 				} else if (Util.AdminModeList.contains(target)) {
	 					Util.AdminModeList.remove(target);
	 					p.sendMessage("§9§o"+target.getName()+"is no longer in §c§nadmin mode.");
	 					target.sendMessage("§9§oYou are no longer in §c§nadmin mode.");
	 					target.setGameMode(GameMode.ADVENTURE);
	 			 		if ((target.isOp())) {
	 					target.setAllowFlight(true);
	 					}
	 				}
    		 }
 		} else {
 			p.sendMessage("§4You must be a Mod+ Or Admin to do that!");
 			p.sendMessage("§3§oIf you are a mod+ or admin please contact njb_said on teamspeak!");
 		}
     
		return false;
	   }
}
