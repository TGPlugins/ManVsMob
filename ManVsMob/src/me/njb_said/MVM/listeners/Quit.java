package me.njb_said.MVM.listeners;

import me.njb_said.MVM.Util;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Quit implements Listener {
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		Util.leaveMvM(p);
		Util.AdminModeList.remove(p);
		Util.spectator.remove(p);
	}
	
	@EventHandler
	public void onKick(PlayerKickEvent e) {
		Player p = e.getPlayer();
		Util.leaveMvM(p);
		Util.AdminModeList.remove(p);
		Util.spectator.remove(p);
		e.setLeaveMessage(null);
	}

}
