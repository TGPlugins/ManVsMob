package me.njb_said.MVM;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Vanish {
	  static ArrayList<String> vanished = new ArrayList<String>();
	  
	  public static void vanish(Player p) {
		    for (Player player : Bukkit.getOnlinePlayers()) {
			      if (player.getName().equals(p.getName())) {
			        continue;
			      }
			      if (!Util.isAdminMode(p)) {
			        player.hidePlayer(p);
			      }
			    }
			    if (!p.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
			    	p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1));
			    }
			    if (!p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
			    	p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
			    }
			    vanished.add(p.getName());
	  }
	  
	  public static boolean isVanished(Player p) {
		  return vanished.contains(p.getName());
	  }
	  
	  public static void update() {
		  for (Player p : Bukkit.getOnlinePlayers()) {
			  if (isVanished(p)) {
				  vanish(p);
			  } else {
				  unVanish(p);
			  }
		  }
	  }
	  
	  public static void unVanish(Player p) {
		  for (Player player : Bukkit.getOnlinePlayers()) {
		      player.showPlayer(p);
		    }
			  if (p.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
			    	p.removePotionEffect(PotionEffectType.INVISIBILITY);
			    }
			  if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
			    	p.removePotionEffect(PotionEffectType.NIGHT_VISION);
			    }
		    vanished.remove(p.getName());
	  }
}