package me.njb_said.MVM.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

public class Decay implements Listener {
	
	  @EventHandler
	  public void onDecay(LeavesDecayEvent e) {
	    e.setCancelled(true);
	  }

}
