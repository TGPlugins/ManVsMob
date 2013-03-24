package me.njb_said.MVM.timers;

import me.njb_said.MVM.Main;
import me.njb_said.MVM.Util;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class MvMCountdown implements Runnable{
	
	public int number = 61;
	public static int count = 61;
	public int id = 0;

	
	public MvMCountdown(int t) {
		MvMCountdown.count = t;
	}

	public MvMCountdown() {
	}
	public void run() {

        count -= 1;
        	if (count < 61) {
        		for (Player player : Bukkit.getOnlinePlayers()) {
        			player.setExp(0);
        			player.setLevel(count);
        		}
        	}
        
        	if ((count == 60) || (count == 50) || (count == 40) || (count == 30) || (count == 20) || (count == 10)) {
        		Util.bc("Game starting in " + count + " seconds.");
        	}

            if (count < 6) {
              for (Player player : Bukkit.getOnlinePlayers()) {
                player.playSound(player.getLocation(), Sound.LAVA_POP, 60.0F, 0.0F);
              }
            }

            if ((count < 6) && (count > 0)) {
        		Util.bc("Game starting in " + count + " seconds.");
            }
        	
        	if (count == 0) {
        		Main.stopMvMCountdown();
        		Util.MVMIngame = true;
        		Util.bc("Game starting...");
        		System.out.println("1");
        		for (Player p : Bukkit.getOnlinePlayers()) {
        			if (Util.isAdminMode(p)) {
            			Util.AdminModeList.add(p);
            			p.chat("/game remove " + p.getName());
            			Util.giveKit(p, 2);
            			p.setGameMode(GameMode.CREATIVE);
            			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1F, 1F);
        			} else {
        				p.setGameMode(GameMode.ADVENTURE);
        				Util.giveKit(p, 1);
        				p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1F, 1F);
        			}
        		}
        		System.out.println("2");
        		System.out.println("3");
        		Main.startCons();
        	}
	}
}