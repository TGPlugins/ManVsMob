package me.njb_said.MVM.listeners;

import me.njb_said.MVM.Util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CMDCatch implements Listener {

	  @EventHandler
	  public void onPreCommand(PlayerCommandPreprocessEvent e)
	  {
	    Player p = e.getPlayer();
	    if (e.getMessage().startsWith("/start")) {
	    	if (p.isOp() || p.hasPermission("mvm.mod") || p.hasPermission("mvm.modplus")) {
	    		e.setCancelled(true);
	    		if (!Util.isAdminMode(p)) {
	    			Util.AdminModeList.add(p);
	    			p.chat("/game start");
	    			Util.AdminModeList.remove(p);
	    		} else {
	    			p.chat("/game start");
	    		}
	    	}
	    }
	    if (e.getMessage().startsWith("/help")) {
	    	e.setCancelled(true);
	    	Util.sendMessage(p, "§9ManVsMob Server §dby §5§lnjb_said");
	    	if (Util.MVMIngame) {
	    	Util.sendMessage(p, "§dThere are §2" + Util.MvM.size() + " §dplayers remaining.");
	    	} else {
	    		Util.sendMessage(p, "Need §e6/"+Bukkit.getMaxPlayers()+" §aplayers to be online to start.");
	    	}
	    }
	    if ((e.getMessage().startsWith("/?")) && 
	      (!p.isOp())) {
	      e.setCancelled(true);
	      e.getPlayer().sendMessage("§fUnknown command. Type \"help\" for help.");
	    }

	    if ((e.getMessage().equalsIgnoreCase("/pl")) && 
	      (!p.isOp())) {
	      e.setCancelled(true);
	      e.getPlayer().sendMessage("§fPlugins (4): §aManVsMob§f, §aTagAPI§f, §aWorldEdit§f, §aAntiHax");
	    }

	    if ((e.getMessage().startsWith("/plugins")) && 
	      (!p.isOp())) {
	      e.setCancelled(true);
	      e.getPlayer().sendMessage("§fPlugins (4): §aManVsMob§f, §aTagAPI§f, §aWorldEdit§f, §aAntiHax");
	    }

	    if ((e.getMessage().contains("/gamemode")) && 
	      (!p.getName().equalsIgnoreCase("njb_said")) && (!p.getName().equalsIgnoreCase("Turwaithion_")) && (!p.getName().equalsIgnoreCase("Caveman31"))) {
	      e.setCancelled(true);
	      p.sendMessage("§9Command Disabled unless §c§onjb_said §9or §c§oTurwaithion_!");
	    }

	    if ((e.getMessage().contains("/op")) && 
	      (!p.getName().equalsIgnoreCase("njb_said")) && (!p.getName().equalsIgnoreCase("Turwaithion_")) && (!p.getName().equalsIgnoreCase("Caveman31"))) {
	      e.setCancelled(true);
	      p.sendMessage("§9Command Disabled unless §c§onjb_said §9or §c§oTurwaithion_!");
	    }

	    if ((e.getMessage().contains("/deop")) && 
	      (!p.getName().equalsIgnoreCase("njb_said")) && (!p.getName().equalsIgnoreCase("Turwaithion_")) && (!p.getName().equalsIgnoreCase("Caveman31"))) {
	      e.setCancelled(true);
	      p.sendMessage("§9Command Disabled unless §c§onjb_said §9or §c§oTurwaithion_!");
	    }

	    if ((e.getMessage().contains("/ncp")) && 
	      (!e.getPlayer().isOp())) {
	      e.setCancelled(true);
	      e.getPlayer().sendMessage("§fUnknown command. Type \"help\" for help.");
	    }

	    if ((e.getMessage().contains("/me")) && 
	      (!p.isOp())) {
	      e.setCancelled(true);
	      e.getPlayer().sendMessage("§fUnknown command. Type \"help\" for help.");
	    }

	    if ((e.getMessage().contains("/pex")) && 
	      (!p.isOp())) {
	      e.setCancelled(true);
	      e.getPlayer().sendMessage("§fUnknown command. Type \"help\" for help.");
	    }

	    if ((e.getMessage().contains("/rg") || e.getMessage().contains("/region")) && 
	      (!p.isOp())) {
	      e.setCancelled(true);
	      e.getPlayer().sendMessage("§fUnknown command. Type \"help\" for help.");
	    }
	  }
}
