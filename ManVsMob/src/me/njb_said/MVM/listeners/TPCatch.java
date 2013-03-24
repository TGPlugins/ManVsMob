package me.njb_said.MVM.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.kitteh.tag.TagAPI;

public class TPCatch implements Listener {

	  @EventHandler
	  public void onPlayerTeleport(PlayerTeleportEvent e)
	  {
		  TagAPI.refreshPlayer(e.getPlayer());
	  }
}
