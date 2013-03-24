package me.njb_said.MVM.timers;

import me.njb_said.MVM.Main;
import me.njb_said.MVM.Util;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Constant implements Runnable {

	public int number = 1811;
	public static int count = 1811;
	public int id = 0;

	  public Constant(int t) {
	    count = t;
	  }

	  public Constant() {
	  }
	  
	public void run() {

        count -= 1;
        
        if (count == 1810) {
			World w = Bukkit.getWorld("EventS1");
			w.setPVP(false);
        	Main.autoSoup();
        	Util.bc("First wave will begin in 10 Seconds.");
        }
        
      if (count == 1800) {
			Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "difficulty normal");
			Main.plugin.spawner.startMobs();
      }
      
      if (count == 1500) {
    	  PotionEffect strength = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, 1);
    	  for (Player p : Util.MvM) {
    		  p.addPotionEffect(strength);
    		  Util.sendMessage(p, "You have been given strength for surviving 5 minutes.");
    	  }
      }
      
      if (count < 1800) {
    	  Util.checkWinner();
      }
      
      if (count <= 0)
      {
        Main.stopCons();
        count = 3601;
        Main.stopMvMCountdown();
        Util.bc("§4Max Game Time Exceeded!");
        for (Player p : Bukkit.getOnlinePlayers()) {
          p.kickPlayer("§4Max Game Time Exceeded. \n \n §6Server is now restarting.");
        }
        Bukkit.getServer().shutdown();
      }
        
	}

}
