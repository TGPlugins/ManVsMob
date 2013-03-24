package me.njb_said.MVM.listeners;

import me.njb_said.MVM.Util;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.kitteh.tag.PlayerReceiveNameTagEvent;

public class TagHandler implements Listener {
	
	@EventHandler
	public void tag(PlayerReceiveNameTagEvent e) {
		if (Util.MVMIngame) {
			if (Util.isAlive(e.getNamedPlayer())) {
				e.setTag("§c" + e.getNamedPlayer().getName());
			} else if (Util.isSpectator(e.getNamedPlayer())) {
				e.setTag("§3"+e.getNamedPlayer().getName());
			} else if (Util.isAdminMode(e.getNamedPlayer())) {
				e.setTag("§4"+e.getNamedPlayer().getName());
			}
		} else {
			e.setTag("§9"+e.getNamedPlayer().getName());
		}
	}
}
