package me.njb_said.MVM.listeners;

import me.njb_said.MVM.Util;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class Explode implements Listener {

	@EventHandler
	public void explode(EntityExplodeEvent e) {
		if (Util.MVMIngame) {
			e.blockList().clear();
		} else {
			e.setCancelled(true);
		}
	}
	
}
