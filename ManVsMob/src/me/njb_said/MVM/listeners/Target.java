package me.njb_said.MVM.listeners;

import me.njb_said.MVM.Util;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class Target implements Listener {

	@EventHandler
	public void target(EntityTargetEvent e) {
		if (e.getTarget() instanceof Player) {
			if (!Util.MVMIngame) {
				e.setCancelled(true);
			}
		}
	}
	
}
