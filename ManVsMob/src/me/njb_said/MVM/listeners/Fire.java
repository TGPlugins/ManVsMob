package me.njb_said.MVM.listeners;

import me.njb_said.MVM.Util;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;

public class Fire implements Listener {

	@EventHandler
	public void fire(BlockBurnEvent e) {
		if (Util.MVMIngame) {
		e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void ignite(BlockIgniteEvent e) {
		if (Util.MVMIngame) {
			e.setCancelled(true);
		}
	}
	
}
