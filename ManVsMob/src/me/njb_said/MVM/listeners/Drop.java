package me.njb_said.MVM.listeners;

import me.njb_said.MVM.Util;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class Drop implements Listener {

	
	@EventHandler
	public void drop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if (Util.MVMIngame) {
				if (Util.isAdminMode(p)) {
					e.setCancelled(false);
				} else {
					Item drop = e.getItemDrop();
					if (drop.getItemStack().getTypeId() == 281) {
						e.setCancelled(false);
					} else {
					e.setCancelled(true);
					}
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
    public void onItemSpawn(ItemSpawnEvent event) {
        boolean n = event.getEntity().getItemStack().getType() == Material.BOWL;
            if(n == true){
                event.getEntity().remove();
               
            }   
    }
	
	
}
