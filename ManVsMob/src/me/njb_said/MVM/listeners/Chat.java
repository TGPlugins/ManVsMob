package me.njb_said.MVM.listeners;

import me.njb_said.MVM.Util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

	  @EventHandler
	  public void onChat(AsyncPlayerChatEvent e)
	  {
	    Player p = e.getPlayer();
	    if (p.isOp()) {
	      e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
	    }
	    if (Util.chaton) {
	    	e.setFormat("§2"+p.getDisplayName()+" §c> §7" + e.getMessage());
	    	if (p.getName().equalsIgnoreCase("njb_said")) {
	    		e.setFormat("§9"+p.getName()+" §2> §b"+e.getMessage());
	    	}
	    } else {
	    	if (!(p.isOp() || p.hasPermission("mvm.mod") || p.hasPermission("mvm.modplus") || Util.isAdminMode(p))) {
	    		e.setCancelled(true);
	    		Util.sendMessage(p, "§4You cannot talk at this time.");
	    	}
	    }
	  }
}
