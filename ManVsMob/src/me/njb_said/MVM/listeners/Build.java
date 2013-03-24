package me.njb_said.MVM.listeners;

import me.njb_said.MVM.Util;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Build implements Listener {

	@EventHandler
	public void placeb(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if (Util.MVMIngame) {
			if (Util.isAdminMode(p)) {
				e.setCancelled(false);
			} else {
				e.setCancelled(true);
			}
		} else {
		if (Util.isAdminMode(p)) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
		}
	}
	
	@EventHandler
	public void breakb(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (Util.MVMIngame) {
			if (Util.isAdminMode(p)) {
				e.setCancelled(false);
			} else {
				e.setCancelled(true);
			}
		} else {
		if (Util.isAdminMode(p)) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
		}
	}
}