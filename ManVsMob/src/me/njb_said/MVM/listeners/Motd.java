package me.njb_said.MVM.listeners;

import me.njb_said.MVM.Util;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class Motd implements Listener {
	
	@EventHandler
	public void motd(ServerListPingEvent e) {
		if (Util.MVMIngame) {
			e.setMotd("§6[§cMvM§6] §9Started §a- §b"+Util.MvM.size()+" §balive.");
		} else if (Util.Maintenance) {
			e.setMotd("§6[§cMvM§6] §dMaintenance");
		} else {
			e.setMotd("§6[§cMvM§6] §5Waiting for players");
		}
	}

}
