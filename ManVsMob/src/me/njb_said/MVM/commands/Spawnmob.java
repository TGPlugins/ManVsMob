package me.njb_said.MVM.commands;

import me.njb_said.MVM.Util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Spawnmob implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	   {
	     	if (sender instanceof Player) {
	     		Player p = (Player)sender;
	     		if (cmd.getName().equalsIgnoreCase("spawnmob")) {
	     			if (Util.isAdminMode(p)) {
	     				if (args.length == 0) {
	     					p.sendMessage("§aSpawnmob usage: \n §e/spawnmob §b<mobname> <amount> \n §9Heres an example: §d/spawnmob zombie 10");
	     				} else {
	     					EntityType Mob = EntityType.fromName(args[0]);
	     					if (Mob == null) {
	     						Util.sendMessage(p, "§dMob not found.");
	     					}
	     					int amount = 0;
	     					
	     					try{
	     						amount = Integer.parseInt(args[1]);
	     					}catch(NumberFormatException e) {
	     						
	     						Util.sendMessage(p, "§dYou didnt type an amount!");
	     					}
	     					
	     					for (int i = 0; i < amount; i++) {
	     						p.getLocation().getWorld().spawnEntity(p.getLocation(), Mob);
	     					}
	     					p.sendMessage("§aSpawned §c" + String.valueOf(amount) + " §6" + Mob.getName());
	     					for (Player admins : Util.AdminModeList) {
	     						if (admins.getName().equals(p.getName())) {
	     							continue;
	     						}
	     						admins.sendMessage("§7§o[" + p.getName() + "§7§o: Spawned " + String.valueOf(amount) + " §7§o" + Mob.getName() + "§7§o]");
	     					}
	     				}
	     				
	     			} else {
	     				Util.adminMode(p);
	     			}
	     		}
	     	} else {
	     		sender.sendMessage("Invalid Sender (Player Required");
	     	}
	     	return false;
	     	}
	}
