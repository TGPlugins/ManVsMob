package me.njb_said.MVM.listeners;

import me.njb_said.MVM.Util;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class Damage implements Listener {
	
	@EventHandler
	public void damage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (!Util.MVMIngame) {
				e.setCancelled(true);
			}
			if (Util.isSpectator(p)) {
					e.setCancelled(true);
			}
		}
		if ((e instanceof EntityDamageByEntityEvent)) {
			EntityDamageByEntityEvent ev = (EntityDamageByEntityEvent)e;
			Entity damager = ev.getDamager();
			if ((damager instanceof Player)) {
				Player p = (Player)damager;
				if (Util.isSpectator(p)) {
					if (!Util.isAdminMode(p)) {
					e.setCancelled(true);
					}
				}
			}
		}
		if (!Util.MVMIngame) {
			e.setCancelled(true);
		}
	}
}
