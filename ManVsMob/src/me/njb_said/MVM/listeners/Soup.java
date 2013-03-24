package me.njb_said.MVM.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Soup implements Listener {
	
	@EventHandler
	public void onSoup (PlayerInteractEvent e) {
			Player p = e.getPlayer();
			
			if (p.getHealth() != 20)
			{
				int soup = 5;
				if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && (p.getItemInHand().getType() == Material.MUSHROOM_SOUP)) {
					p.setHealth(p.getHealth() + soup > p.getMaxHealth() ? p.getMaxHealth() : p.getHealth() + soup);
					e.getPlayer().getItemInHand().setType(Material.BOWL);
				}
			}
		}
	}