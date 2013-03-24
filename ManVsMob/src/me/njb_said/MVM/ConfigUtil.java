package me.njb_said.MVM;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class ConfigUtil {

	final Main p;
	
	public ConfigUtil(Main instance) {
		p = instance;
	}

	  public Location getLobbySpawn()
	  {
	    return new Location(Bukkit.getWorld(p.getConfig().getString("LobbySpawn.world")), 
	      p.getConfig().getInt("LobbySpawn.x"), 
	      p.getConfig().getInt("LobbySpawn.y"), 
	      p.getConfig().getInt("LobbySpawn.z"));
	  }

	  public void setLobbySpawn(Location l) {
	    p.getConfig().set("LobbySpawn.world", l.getWorld().getName());
	    p.getConfig().set("LobbySpawn.x", Integer.valueOf(l.getBlockX()));
	    p.getConfig().set("LobbySpawn.y", Integer.valueOf(l.getBlockY()));
	    p.getConfig().set("LobbySpawn.z", Integer.valueOf(l.getBlockZ()));
	    p.saveConfig();
	  }
	  public Location getSpawn()
	  {
	    return new Location(Bukkit.getWorld(p.getConfig().getString("Spawn.world")), 
	      p.getConfig().getInt("Spawn.x"), 
	      p.getConfig().getInt("Spawn.y"), 
	      p.getConfig().getInt("Spawn.z"));
	  }

	  public void setSpawn(Location l) {
	    p.getConfig().set("Spawn.world", l.getWorld().getName());
	    p.getConfig().set("Spawn.x", Integer.valueOf(l.getBlockX()));
	    p.getConfig().set("Spawn.y", Integer.valueOf(l.getBlockY()));
	    p.getConfig().set("Spawn.z", Integer.valueOf(l.getBlockZ()));
	    p.saveConfig();
	  }
	  
	  public Location getMob1()
	  {
	    return new Location(Bukkit.getWorld(p.getConfig().getString("Mob1.world")), 
	      p.getConfig().getInt("Mob1.x"), 
	      p.getConfig().getInt("Mob1.y"), 
	      p.getConfig().getInt("Mob1.z"));
	  }

	  public void setMob1(Location l) {
	    p.getConfig().set("Mob1.world", l.getWorld().getName());
	    p.getConfig().set("Mob1.x", Integer.valueOf(l.getBlockX()));
	    p.getConfig().set("Mob1.y", Integer.valueOf(l.getBlockY()));
	    p.getConfig().set("Mob1.z", Integer.valueOf(l.getBlockZ()));
	    p.saveConfig();
	  }
	  
	  public Location getMob2()
	  {
	    return new Location(Bukkit.getWorld(p.getConfig().getString("Mob2.world")), 
	      p.getConfig().getInt("Mob2.x"), 
	      p.getConfig().getInt("Mob2.y"), 
	      p.getConfig().getInt("Mob2.z"));
	  }

	  public void setMob2(Location l) {
	    p.getConfig().set("Mob2.world", l.getWorld().getName());
	    p.getConfig().set("Mob2.x", Integer.valueOf(l.getBlockX()));
	    p.getConfig().set("Mob2.y", Integer.valueOf(l.getBlockY()));
	    p.getConfig().set("Mob2.z", Integer.valueOf(l.getBlockZ()));
	    p.saveConfig();
	  }
	  
	  public Location getMob3()
	  {
	    return new Location(Bukkit.getWorld(p.getConfig().getString("Mob3.world")), 
	      p.getConfig().getInt("Mob3.x"), 
	      p.getConfig().getInt("Mob3.y"), 
	      p.getConfig().getInt("Mob3.z"));
	  }

	  public void setMob3(Location l) {
	    p.getConfig().set("Mob3.world", l.getWorld().getName());
	    p.getConfig().set("Mob3.x", Integer.valueOf(l.getBlockX()));
	    p.getConfig().set("Mob3.y", Integer.valueOf(l.getBlockY()));
	    p.getConfig().set("Mob3.z", Integer.valueOf(l.getBlockZ()));
	    p.saveConfig();
	  }
	  
	  public Location getEnchant()
	  {
	    return new Location(Bukkit.getWorld(p.getConfig().getString("Enchant.world")), 
	      p.getConfig().getInt("Enchant.x"), 
	      p.getConfig().getInt("Enchant.y"), 
	      p.getConfig().getInt("Enchant.z"));
	  }

	  public void setEnchant(Location l) {
	    p.getConfig().set("Enchant.world", l.getWorld().getName());
	    p.getConfig().set("Enchant.x", Integer.valueOf(l.getBlockX()));
	    p.getConfig().set("Enchant.y", Integer.valueOf(l.getBlockY()));
	    p.getConfig().set("Enchant.z", Integer.valueOf(l.getBlockZ()));
	    p.saveConfig();
	  }
	  

		public int getEnchantID() {
			return p.getConfig().getInt("EnchantID");
		}
	

}
