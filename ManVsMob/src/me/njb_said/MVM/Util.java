package me.njb_said.MVM;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.kitteh.tag.TagAPI;

public class Util {

	public static Main plugin;
	  public Util(Main ins)
	  {
	    plugin = ins;
	  }
	  
	  
	  public static void giveKit(Player p, Integer it) {
		  PlayerInventory pInv = p.getInventory();
		  if (it == 1) {
			  pInv.clear();
			  pInv.setArmorContents(null);
			  
			  ItemStack s = new ItemStack(Material.DIAMOND_SWORD);
			  ItemMeta sm = s.getItemMeta();
			  sm.setDisplayName("§6Mob Whacker");
			  sm.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
			  s.setItemMeta(sm);
			  
			  ItemStack b = new ItemStack(Material.BOW);
			  ItemMeta bm = b.getItemMeta();
			  bm.setDisplayName("§9§lShooter");
			  bm.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
			  bm.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
			  b.setItemMeta(bm);
			  
			  ItemStack ss = new ItemStack(Material.IRON_SWORD);
			  ItemMeta ssm = ss.getItemMeta();
			  ssm.setDisplayName("§bSpare Sword");
			  ss.setItemMeta(ssm);
			  
			  ItemStack sb = new ItemStack(Material.BOW);
			  ItemMeta sbm = sb.getItemMeta();
			  sbm.setDisplayName("§cSpare Bow");
			  sb.setItemMeta(sbm);
			  
			  ItemStack mushmush = new ItemStack(Material.MUSHROOM_SOUP);
			  ItemMeta mushmosh = mushmush.getItemMeta();
			  mushmosh.setDisplayName("§aLife Saver");
			  mushmush.setItemMeta(mushmosh);
			  for (int i = 0; i < 40; i++) {
				  pInv.addItem(mushmush);
			  }
			  
			  pInv.setHelmet(new ItemStack(Material.IRON_HELMET));
			  pInv.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
			  pInv.setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			  pInv.setBoots(new ItemStack(Material.IRON_BOOTS));
			  pInv.setItem(0, s);
			  pInv.setItem(8, b);
			  pInv.setItem(9, ss);
			  pInv.setItem(17, sb);
			  pInv.setItem(35, new ItemStack(Material.ARROW));
		  }
		  if (it == 2) {
			  pInv.clear();
			  pInv.setArmorContents(null);
			  
			  pInv.setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
			  pInv.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
			  pInv.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
			  pInv.setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
			  
			  ItemStack stick = new ItemStack(Material.STICK);
			  ItemMeta stickm = stick.getItemMeta();
	      	  stickm.setDisplayName("§f§lSlapper.");
			  stickm.addEnchant(Enchantment.KNOCKBACK, 50, true);
			  stick.setItemMeta(stickm);
			  pInv.addItem(stick);
		  }
		  if (it == 3) {
			  ItemStack mushmush = new ItemStack(Material.MUSHROOM_SOUP);
			  ItemMeta mushmosh = mushmush.getItemMeta();
			  mushmosh.setDisplayName("§aLife Saver");
			  mushmush.setItemMeta(mushmosh);
			  for (int i = 0; i < 40; i++) {
				  pInv.addItem(mushmush);
			  }
		  }
		  if (it == 4) {
			  Util.clearInv(p);
		  }
		  if (it == 5) {
				ItemStack EmptyBowl = new ItemStack(Material.BOWL);
				ItemMeta BowlMeta = EmptyBowl.getItemMeta();
				BowlMeta.setDisplayName("§aLife Saver");
				EmptyBowl.setItemMeta(BowlMeta);
				
				pInv.remove(EmptyBowl);
				
				pInv.removeItem(new ItemStack(Material.BOWL));
		  }
	  }

		public static void clearInv(Player p) {
			PlayerInventory pInv = p.getInventory();
			pInv.clear();
			pInv.setArmorContents(null);
			clearPots(p);
			p.setHealth(20);
			p.setFoodLevel(20);
			p.setFireTicks(0);
		}

		public static void clearPots(Player p) {
			p.removePotionEffect(PotionEffectType.BLINDNESS);
			p.removePotionEffect(PotionEffectType.CONFUSION);
			p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
			p.removePotionEffect(PotionEffectType.FAST_DIGGING);
			p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
			p.removePotionEffect(PotionEffectType.HARM);
			p.removePotionEffect(PotionEffectType.HEAL);
			p.removePotionEffect(PotionEffectType.HUNGER);
			p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
			p.removePotionEffect(PotionEffectType.INVISIBILITY);
			p.removePotionEffect(PotionEffectType.JUMP);
			p.removePotionEffect(PotionEffectType.NIGHT_VISION);
			p.removePotionEffect(PotionEffectType.POISON);
			p.removePotionEffect(PotionEffectType.REGENERATION);
			p.removePotionEffect(PotionEffectType.SLOW);
			p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
			p.removePotionEffect(PotionEffectType.SPEED);
			p.removePotionEffect(PotionEffectType.WATER_BREATHING);
			p.removePotionEffect(PotionEffectType.WEAKNESS);
			p.removePotionEffect(PotionEffectType.WITHER);
		}
	  
	  
	  public static Boolean MVMIngame = false;
	  
	  public static Boolean Manual = false;
	  public static Boolean Automated = true;
	  
	  public static Boolean pvp = false;
	  public static Boolean chaton = true;
	  
	  public static Boolean Maintenance = false;
	  
	  public static ArrayList<Player> spectator = new ArrayList<Player>();
		
		public static ArrayList<Player> AdminModeList = new ArrayList<Player>();
		
		public static ArrayList<Player> MvM = new ArrayList<Player>();
		public static HashMap<String, String> MvMString = new HashMap<String, String>();
		
		public static Boolean isAdminMode(Player p) {

			return AdminModeList.contains(p);
		}
		  public static Boolean isAlive(Player p) {
			  return Boolean.valueOf(MvM.contains(p));
		  }
		  public static Boolean isSpectator(Player p) {
			  return Boolean.valueOf(spectator.contains(p));
		  }

		  public static ArrayList<Player> getSpectators() {
			  return spectator;
		  }
		
		public static void joinMVM(Player p) {
			MvM.add(p);
			MvMString.put(p.getDisplayName(), p.getDisplayName());
			TagAPI.refreshPlayer(p);
		}
		
		public static void leaveMvM(Player p) {
			MvM.remove(p);
			MvMString.remove(p.getDisplayName());
			TagAPI.refreshPlayer(p);
		}


	  public static void bc(String msg) {
	    Bukkit.broadcastMessage("§6[§cMvM§6] §a" + msg);
	  }
	  public static void sendMessage(Player p, String msg) {
	    p.sendMessage("§6[§cMvM§6] §a" + msg);
	  }
	  public static void noPerms(Player p) {
	    sendMessage(p, "§4You are not allowed todo that.");
	  }
	  public static void adminMode(Player p) {
		  sendMessage(p, "§4You must be in admin mode. (§4§o/admin§r§4)");
	  }
	  public static void noTrust(Player p) {
	    sendMessage(p, "§4I dont trust you, so you cant do that!");
	  }

	  public static String getShortStr(String s)
	  {
	    if (s.length() == 16) {
	      String shorts = s.substring(0, s.length() - 5);
	      return shorts;
	    }
	    if (s.length() == 15) {
	      String shorts = s.substring(0, s.length() - 4);
	      return shorts;
	    }
	    if (s.length() == 14) {
	      String shorts = s.substring(0, s.length() - 3);
	      return shorts;
	    }
	    if (s.length() == 13) {
	      String shorts = s.substring(0, s.length() - 2);
	      return shorts;
	    }
	    if (s.length() == 12) {
	      String shorts = s.substring(0, s.length() - 1);
	      return shorts;
	    }
	    return s;
	  }

	  /*public static Location getSpawn()
	  {
	    return new Location(Bukkit.getWorld(plugin.getConfig().getString("Spawn.world")), 
	      plugin.getConfig().getInt("Spawn.x"), 
	      plugin.getConfig().getInt("Spawn.y"), 
	      plugin.getConfig().getInt("Spawn.z"));
	  }

	  public static void setSpawn(Location l) {
	    plugin.getConfig().set("Spawn.world", l.getWorld().getName());
	    plugin.getConfig().set("Spawn.x", Integer.valueOf(l.getBlockX()));
	    plugin.getConfig().set("Spawn.y", Integer.valueOf(l.getBlockY()));
	    plugin.getConfig().set("Spawn.z", Integer.valueOf(l.getBlockZ()));
	    plugin.saveConfig();
	  }

	  public static Location getMobSpawnLoc1()
	  {
	    return new Location(Bukkit.getWorld(plugin.getConfig().getString("MobSpawnLoc1.world")), 
	      plugin.getConfig().getInt("MobMobSpawnLoc1.x"), 
	      plugin.getConfig().getInt("MobSpawnLoc1.y"), 
	      plugin.getConfig().getInt("MobSpawnLoc1.z"));
	  }

	  public static void setMobSpawnLoc1(Location l) {
	    plugin.getConfig().set("MobSpawnLoc1.world", l.getWorld().getName());
	    plugin.getConfig().set("MobSpawnLoc1.x", Integer.valueOf(l.getBlockX()));
	    plugin.getConfig().set("MobSpawnLoc1.y", Integer.valueOf(l.getBlockY()));
	    plugin.getConfig().set("MobSpawnLoc1.z", Integer.valueOf(l.getBlockZ()));
	    plugin.saveConfig();
	  }

	  public static Location getMobSpawnLoc2()
	  {
	    return new Location(Bukkit.getWorld(plugin.getConfig().getString("MobSpawnLoc2.world")), 
	      plugin.getConfig().getInt("MobSpawnLoc2.x"), 
	      plugin.getConfig().getInt("MobSpawnLoc2.y"), 
	      plugin.getConfig().getInt("MobSpawnLoc2.z"));
	  }

	  public static void setMobSpawnLoc2(Location l) {
	    plugin.getConfig().set("MobSpawnLoc2.world", l.getWorld().getName());
	    plugin.getConfig().set("MobSpawnLoc2.x", Integer.valueOf(l.getBlockX()));
	    plugin.getConfig().set("MobSpawnLoc2.y", Integer.valueOf(l.getBlockY()));
	    plugin.getConfig().set("MobSpawnLoc2.z", Integer.valueOf(l.getBlockZ()));
	    plugin.saveConfig();
	  }

	  public static Location getMobSpawnLoc3() {
	    return new Location(Bukkit.getWorld(plugin.getConfig().getString("MobSpawnLoc3.world")), 
	      plugin.getConfig().getInt("MobSpawnLoc3.x"), 
	      plugin.getConfig().getInt("MobSpawnLoc3.y"), 
	      plugin.getConfig().getInt("MobSpawnLoc3.z"));
	  }

	  public static void setMobSpawnLoc3(Location l) {
	    plugin.getConfig().set("MobSpawnLoc3.world", l.getWorld().getName());
	    plugin.getConfig().set("MobSpawnLoc3.x", Integer.valueOf(l.getBlockX()));
	    plugin.getConfig().set("MobSpawnLoc3.y", Integer.valueOf(l.getBlockY()));
	    plugin.getConfig().set("MobSpawnLoc3.z", Integer.valueOf(l.getBlockZ()));
	    plugin.saveConfig();
	  }

	  public static Location getEnchantToggle() {
	    return new Location(Bukkit.getWorld(plugin.getConfig().getString("Enchant.world")), 
	      plugin.getConfig().getInt("Enchant.x"), 
	      plugin.getConfig().getInt("Enchant.y"), 
	      plugin.getConfig().getInt("Enchant.z"));
	  }

	  public static void setEnchantToggle(Location l) {
	    plugin.getConfig().set("Enchant.world", l.getWorld().getName());
	    plugin.getConfig().set("Enchant.x", Integer.valueOf(l.getBlockX()));
	    plugin.getConfig().set("Enchant.y", Integer.valueOf(l.getBlockY()));
	    plugin.getConfig().set("Enchant.z", Integer.valueOf(l.getBlockZ()));
	    plugin.saveConfig();
	  }

	public static int getEnchantID() {
		return plugin.getConfig().getInt("EnchantID");
	}*/

	public static void checkWinner() {
		if (Util.MvM.size() <= 1) {
			if (Util.MvM.size() == 0) {
				Main.stopCons();
				Main.stopMvMCountdown();
				Bukkit.getServer().getScheduler().cancelAllTasks();
				Bukkit.getServer().shutdown();
			} else {
				Main.stopCons();
				Main.stopMvMCountdown();
				Bukkit.getServer().shutdown();
			}
		}
	}
}
