package me.njb_said.MVM;

import java.util.List;

import me.njb_said.MVM.commands.Admin;
import me.njb_said.MVM.commands.Game;
import me.njb_said.MVM.commands.Goto;
import me.njb_said.MVM.commands.Invis;
import me.njb_said.MVM.commands.Map;
import me.njb_said.MVM.commands.Spawnmob;
import me.njb_said.MVM.commands.Teleport;
import me.njb_said.MVM.listeners.Build;
import me.njb_said.MVM.listeners.CMDCatch;
import me.njb_said.MVM.listeners.Chat;
import me.njb_said.MVM.listeners.Damage;
import me.njb_said.MVM.listeners.Death;
import me.njb_said.MVM.listeners.Decay;
import me.njb_said.MVM.listeners.Drop;
import me.njb_said.MVM.listeners.Explode;
import me.njb_said.MVM.listeners.Fire;
import me.njb_said.MVM.listeners.Hunger;
import me.njb_said.MVM.listeners.Join;
import me.njb_said.MVM.listeners.Motd;
import me.njb_said.MVM.listeners.Pickup;
import me.njb_said.MVM.listeners.Quit;
import me.njb_said.MVM.listeners.Soup;
import me.njb_said.MVM.listeners.TPCatch;
import me.njb_said.MVM.listeners.TagHandler;
import me.njb_said.MVM.listeners.Target;
import me.njb_said.MVM.timers.Constant;
import me.njb_said.MVM.timers.MvMCountdown;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.kitteh.tag.TagAPI;

public class Main extends JavaPlugin {

	  public static Main plugin;
	  public ConfigUtil config;
	  public Spawner spawner;

	  public Main()
	  {
	    plugin = this;
	    config = new ConfigUtil(this);
	    spawner = new Spawner(this);
	  }
	public static int WaveCount = 1;
	
	public void onEnable() {
		
	    getConfig().options().copyDefaults(true);
	    saveConfig();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Build(), this);
		pm.registerEvents(new Chat(), this);
		pm.registerEvents(new CMDCatch(), this);
		pm.registerEvents(new Damage(), this);
		pm.registerEvents(new Death(this), this);
		pm.registerEvents(new Decay(), this);
		pm.registerEvents(new Drop(), this);
		pm.registerEvents(new Explode(), this);
		pm.registerEvents(new Fire(), this);
		pm.registerEvents(new Hunger(), this);
		pm.registerEvents(new Join(this), this);
		pm.registerEvents(new Motd(), this);
		pm.registerEvents(new Pickup(), this);
		pm.registerEvents(new Soup(), this);
		pm.registerEvents(new TagHandler(), this);
		pm.registerEvents(new Target(), this);
		pm.registerEvents(new TPCatch(), this);
		pm.registerEvents(new Quit(), this);
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			public void run() {
				
				Bukkit.dispatchCommand(getServer().getConsoleSender(), "difficulty peaceful");
				World w = Bukkit.getWorld("EventS1");
				List<LivingEntity> mobList = w.getLivingEntities();
				for(LivingEntity ent : mobList)
				{
					if (!(ent instanceof Player)) {
				     ent.remove();
					}
				}
				
			}
		}, 20 * 5);
		
		
		getCommand("game").setExecutor(new Game());
		getCommand("tp").setExecutor(new Teleport());
		getCommand("tpall").setExecutor(new Teleport());
		getCommand("spawnmob").setExecutor(new Spawnmob());
		getCommand("admin").setExecutor(new Admin());
		getCommand("set").setExecutor(new Map(this));
		getCommand("goto").setExecutor(new Goto(this));
		getCommand("vanish").setExecutor(new Invis());
		getCommand("unvanish").setExecutor(new Invis());
		}
	
	public void onDisable() {
	    getConfig().options().copyDefaults(true);
	    saveConfig();
	    stopCons();
	    stopMvMCountdown();
		Bukkit.getScheduler().cancelAllTasks();
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.kickPlayer("§6[§cMvM§6] §aServer is now restarting");
		}
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stop");
	}
	
	public static void sendMessage(Player p, String message) {
		p.sendMessage("§6[§cMvM§6] §a" + message);
	}
	
	public static void startMvMCountdown() {
		stopMvMCountdown();

		mvmCount = new MvMCountdown();
		mvmCount.id = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(new Main(), mvmCount, 0L, 20L);
	}

	public static void startMvMCountdown(int i) {
		stopMvMCountdown();
		    	
	  	mvmCount = new MvMCountdown(i);
	  	mvmCount.id = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(new Main(), mvmCount, 20L, 20L);
		    	
	}

	public static void stopMvMCountdown() {
		if (mvmCount != null) {
			Bukkit.getServer().getScheduler().cancelTask(mvmCount.id);
			mvmCount = null;
		}
	}
	public static MvMCountdown mvmCount = null;
	
	public static void startCons() {
		stopMvMCountdown();
		
		consCount = new Constant();
		consCount.id = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(new Main(), consCount, 0L, 20L);
	}
	
	public static void startCons(int i) {
		stopMvMCountdown();
		
		consCount = new Constant(i);
		consCount.id = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(new Main(), consCount, 20L, 20L);
	}
	
	public static void stopCons() {
		if (consCount != null) {
			Bukkit.getServer().getScheduler().cancelTask(consCount.id);
			consCount = null;
		}
	}
	public static Constant consCount = null;
	
	
	public static void autoSoup() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(new Main(), new Runnable() {
			public void run() {
				for (Player p : Util.MvM) {
					TagAPI.refreshPlayer(p);
					Util.giveKit(p, 5); // Remove bowls
					Util.giveKit(p, 3); // Give soup
				}
				Util.bc("Soup has been refilled.");
			}
		}, 0L, 20 * 60);
	}
	
	
}