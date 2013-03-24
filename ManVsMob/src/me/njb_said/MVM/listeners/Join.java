package me.njb_said.MVM.listeners;

import me.njb_said.MVM.Main;
import me.njb_said.MVM.Util;
import me.njb_said.MVM.Vanish;
import me.njb_said.MVM.timers.MvMCountdown;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.kitteh.tag.TagAPI;

public class Join implements Listener {
	
	public Main plugin;
	public Join(Main ins) {
		plugin = ins;
	}

	@EventHandler
	public void join(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		TagAPI.refreshPlayer(p);;
		Vanish.unVanish(p);
		Util.clearInv(p);
		p.setGameMode(GameMode.ADVENTURE);
		p.setLevel(0);
		p.teleport(plugin.config.getSpawn());
		if (p.isOp()) {
			p.setDisplayName("§4"+p.getName()+"§r");
			p.setPlayerListName("§4"+Util.getShortStr(p.getName())+"§r");
			p.setAllowFlight(true);
			p.setFlying(true);
		} else if (p.hasPermission("mvm.modplus")) {
			p.setDisplayName("§d"+p.getName()+"§r");
			p.setPlayerListName("§d"+Util.getShortStr(p.getName())+"§r");
			p.setAllowFlight(true);
			p.setFlying(true);
		} else if (p.hasPermission("mvm.mod")) {
			p.setDisplayName("§b"+p.getName()+"§r");
			p.setPlayerListName("§b"+Util.getShortStr(p.getName())+"§r");
		} else if (p.hasPermission("mvm.vip")) {
			p.setDisplayName("§5"+p.getName()+"§r");
			p.setPlayerListName("§5"+Util.getShortStr(p.getName())+"§r");
		} else if (p.hasPermission("mvm.donator")) {
			p.setDisplayName("§6"+p.getName()+"§r");
			p.setPlayerListName("§6"+Util.getShortStr(p.getName())+"§r");
		} else {
			p.setDisplayName("§2"+p.getName()+"§r");
			p.setPlayerListName("§2"+Util.getShortStr(p.getName())+"§r");
		}
		
		
		if (!Util.MVMIngame) {
			if (Util.Automated) {
				Util.joinMVM(p);
				if (Util.MvM.size() <= 6) {
					Main.sendMessage(p, "Waiting for §e6/" + Bukkit.getMaxPlayers() + " players §9to be online.");
					Main.sendMessage(p, "MvM Will start with 6 people online.");
					if (Util.MvM.size() == 6) {
						MvMCountdown.count = 61;
						Main.startMvMCountdown();
					}
				} else {
					Util.sendMessage(p, "MvM is starting...");
				}
			}
		} else {
			Util.leaveMvM(p);
			if (!p.isFlying()) {
				p.setFlying(true);
			}
			p.setAllowFlight(true);
			if (!(p.getGameMode() == GameMode.ADVENTURE)) {
				p.setGameMode(GameMode.ADVENTURE);
			}
			Util.spectator.add(p);
			Vanish.vanish(p);
			Main.sendMessage(p, "Game has started.");
			Main.sendMessage(p, "Use /admin to enter admin mode");
		}
	}
	
	@EventHandler
	public void login(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if (Util.MVMIngame) {
			if ((p.isOp()) || (p.hasPermission("mvm.modplus")) || (p.hasPermission("mvm.mod"))) {
				e.allow();
			} else {
				e.setKickMessage("§9§lGame started.");
				e.disallow(PlayerLoginEvent.Result.KICK_OTHER, e.getKickMessage());
			}
		}
		if (e.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
			if ((p.hasPermission("mvm.vip"))
					|| (p.hasPermission("mvm.donator"))
					|| (p.hasPermission("mvm.modplus"))
					|| (p.hasPermission("mvm.modplus"))
					|| (p.hasPermission("mvm.vip"))
					|| (p.isOp())) {
				e.allow();
			} else {
				e.setKickMessage("§e§oServer is full §3- \n \n §c§lshop.techge3ks.com §bto join when full.");
			}
		}
	}

}
