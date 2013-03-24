package me.njb_said.MVM.listeners;

import me.njb_said.MVM.Main;
import me.njb_said.MVM.Util;
import me.njb_said.MVM.Vanish;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {

	private Main plugin;
	public Death(Main ins) {
		plugin = ins;
	}
	
	@EventHandler
	public void drops(EntityDeathEvent e) {
		if (Util.MVMIngame) {
			e.getDrops().clear();
			if (e.getEntity() instanceof Player) {
				e.setDroppedExp(0);
			}
		}
	}
	
	@EventHandler
	public void death(PlayerDeathEvent e) {
		Player p = e.getEntity();
		String pname = p.getName();
		String pdn = p.getDisplayName();
		p.setHealth(20);
		p.setFoodLevel(20);
		p.setFireTicks(0);
		Util.clearInv(p);
		e.setDroppedExp(0);
		e.getDrops().clear();
		if (Util.MVMIngame) {
		Util.leaveMvM(p);
		p.teleport(plugin.config.getSpawn());
		if (p.getKiller() != null) {
			Player k = p.getKiller();
			String kdn = k.getDisplayName();
			e.setDeathMessage(null);
			Util.bc("§2"+pdn+" §dhas been killed by §2"+kdn+"§d.");
			if ((p.isOp()) || (p.hasPermission("mvm.mod")) || (p.hasPermission("mvm.modplus"))) {
				Util.spectator.add(p);
				Vanish.vanish(p);
				if (p.hasPermission("mvm.mod")) {
					p.setGameMode(GameMode.ADVENTURE);
					p.setAllowFlight(true);
					p.sendMessage("§3You died and are now a spectator.");
				} else {
				Util.AdminModeList.add(p);
				p.sendMessage("§cYou died and are now in admin mode and vanished.");
				p.setGameMode(GameMode.CREATIVE);
				}
				p.setFlying(true);
			} else {
				p.kickPlayer("§2"+pdn+" §dhas been killed by §2"+kdn+"§d.");
			}
		} else {
			String dm = e.getDeathMessage().replace(pname, pdn+"§d");
			e.setDeathMessage("§6[§cMvM§6] §d"+dm+"§d.");
			if ((p.isOp()) || (p.hasPermission("mvm.mod")) || (p.hasPermission("mvm.modplus"))) {
				Util.spectator.add(p);
				Vanish.vanish(p);
				if (p.hasPermission("mvm.mod")) {
					p.setGameMode(GameMode.ADVENTURE);
					p.setAllowFlight(true);
					p.sendMessage("§3You died and are now a spectator.");
				} else {
				Util.AdminModeList.add(p);
				p.sendMessage("§cYou died and are now in admin mode and vanished.");
				p.setGameMode(GameMode.CREATIVE);
				}
				p.setFlying(true);
			} else {
				p.kickPlayer("§d"+dm+"§d.");
			}
		}
		Util.bc("There are §6" + Util.MvM.size() + " §aplayers remain.");
		}
	}
}