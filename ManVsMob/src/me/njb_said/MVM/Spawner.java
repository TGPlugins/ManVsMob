package me.njb_said.MVM;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Spawner {

	final Main p;
	
	public Spawner(Main instance) {
		p = instance;
	}

	  static Random generator = new Random();
	  static Location spawn = null;

	  public static void pickLoc() {
	    int rand = generator.nextInt(3);
	    if (rand == 0) {
	      spawn = getMobSpawn1();
	    }
	    if (rand == 1) {
	      spawn = getMobSpawn2();
	    }
	    if (rand == 2)
	      spawn = getMobSpawn3();
	  }

	  public static Location getPlayerMVMSpawn()
	  {
	    Location loc = Bukkit.getWorld("EventS1").getSpawnLocation();
	    loc.setX(-210.0D);
	    loc.setZ(109.0D);
	    loc.setY(108.0D);

	    return loc;
	  }

	  public static Location getEnchant() {
	    Location loc = Bukkit.getWorld("EventS1").getSpawnLocation();
	    loc.setX(-231.5D);
	    loc.setY(106.5D);
	    loc.setZ(81.5D);
	    return loc;
	  }

	  public static Location getMobSpawn1()
	  {
	    Location loc = Bukkit.getWorld("EventS1").getSpawnLocation();
	    loc.setX(-240.5D);
	    loc.setY(109.5D);
	    loc.setZ(125.5D);

	    return loc;
	  }

	  public static Location getMobSpawn2() {
	    Location loc = Bukkit.getWorld("EventS1").getSpawnLocation();
	    loc.setX(-242.5D);
	    loc.setY(109.5D);
	    loc.setZ(108.5D);
	    return loc;
	  }

	  public static Location getMobSpawn3() {
	    Location loc = Bukkit.getWorld("EventS1").getSpawnLocation();
	    loc.setX(-238.5D);
	    loc.setY(109.5D);
	    loc.setZ(91.5D);
	    return loc;
	  }

	public void startMobs() {
		System.out.println("-1");
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(new Main(), new Runnable() {
			public void run() {
				System.out.println("2");
				if (Util.MVMIngame) {
					if ((Main.WaveCount == 5) || (Main.WaveCount == 10) || (Main.WaveCount == 15) || (Main.WaveCount == 20)) {
						Location l = getEnchant();
						l.getBlock().setTypeId(98);
						Util.bc("You now have access to the enchantment table.");
					}
					if ((Main.WaveCount == 6) || (Main.WaveCount == 11) || (Main.WaveCount == 16) || (Main.WaveCount == 21)) {
						Location l = getEnchant();
						l.getBlock().setTypeId(0);
						Util.bc("You can no longer use the enchantment table.");
						for (Player p : Util.MvM) {
							p.teleport(getPlayerMVMSpawn());
						}
					}
					System.out.println("5");
					Util.bc("§6Wave " + Main.WaveCount);
					System.out.println("6");
					pickLoc();
					System.out.println("picked");
					System.out.println("definedworld");
					EntityType zombie = EntityType.ZOMBIE;
					EntityType skeleton = EntityType.SKELETON;
					EntityType spider = EntityType.SPIDER;
					EntityType slime = EntityType.SLIME;
					EntityType magmacube = EntityType.MAGMA_CUBE;
					EntityType cavespider = EntityType.CAVE_SPIDER;
					EntityType witch = EntityType.WITCH;
					EntityType tnt = EntityType.PRIMED_TNT;
					EntityType cow = EntityType.MUSHROOM_COW;
					EntityType blaze = EntityType.BLAZE;
					if (Main.WaveCount == 1) {
						System.out.println("5");
						for (int i = 0; i < 25; i++) {
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, zombie);
						}
					}
					if (Main.WaveCount == 2) {
						for (int i = 0; i < 25; i++) {
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, spider);
						}
					}
					if (Main.WaveCount == 3) {
						for (int i = 0; i < 20; i++) {
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, zombie);
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, skeleton);
						}
					}
					if (Main.WaveCount == 4) {
						for (int i = 0; i < 20; i++) {
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, zombie);
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, spider);
						}
					}
					if (Main.WaveCount == 5) {
						for (int i = 0; i < 20; i++) {
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, spider);
						}
						for (int i = 0; i < 7; i++) {	
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, witch);
						}
					}
					if (Main.WaveCount == 6) {
						for (int i = 0; i < 25; i++) {
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, slime);
						}
					}
					if (Main.WaveCount == 7) {
						for (int i = 0; i < 25; i++) {
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, magmacube);
						}
					}
					if (Main.WaveCount == 8) {
						for (int i = 0; i < 30; i++) {
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, cavespider);
						}
					}
					if (Main.WaveCount == 9) {
						for (int i = 0; i < 40; i++) {
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, zombie);
						}
					}
					if (Main.WaveCount == 10) {
						for (int i = 0; i < 10; i++) {
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, witch);
						}
						for (int i = 0; i < 30; i++) {
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, blaze);
						}
					}
					if (Main.WaveCount > 10) {
						Util.bc("§dServer doesnt have more than 10 waves right now.");
						
						Util.bc("§4PVP Enabled.");
						World w = Bukkit.getWorld("world");
						w.setPVP(true);
						w.setDifficulty(Difficulty.HARD);
						pickLoc();
						
						for (int i = 0; i < 30; i++) {
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, zombie);
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, slime);
						}
						pickLoc();
						for (int i = 0; i < 10; i++) {
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, cavespider);
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, witch);
						}
						pickLoc();
						for (int i = 0; i < 30; i++) {
							getPlayerMVMSpawn().getWorld().spawnEntity(spawn, EntityType.CREEPER);
						}
						for (int i = 0; i < 10; i++) {
							getPlayerMVMSpawn().getWorld().spawnEntity(getMobSpawn1(), tnt);
							getPlayerMVMSpawn().getWorld().spawnEntity(getMobSpawn2(), tnt);
							getPlayerMVMSpawn().getWorld().spawnEntity(getMobSpawn3(), tnt);
							getPlayerMVMSpawn().getWorld().spawnEntity(getPlayerMVMSpawn(), cow);
						}
					}
					Main.WaveCount += 1;
				}
			}
		}, 0L, 1200L);
	}

}
