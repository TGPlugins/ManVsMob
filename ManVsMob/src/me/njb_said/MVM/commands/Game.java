package me.njb_said.MVM.commands;

import me.njb_said.MVM.Main;
import me.njb_said.MVM.Util;
import me.njb_said.MVM.Vanish;
import me.njb_said.MVM.timers.MvMCountdown;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Game implements CommandExecutor {

	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		  if (cmd.getName().equalsIgnoreCase("game")) {
			  
			  if (sender instanceof Player) {
				  	Player p = (Player) sender;
				  	if (Util.isAdminMode(p)) {
				  		if (args.length == 0) {
				  			Main.sendMessage(p, "Game/Server Commands:");
				  			Main.sendMessage(p, "/game start - Start the game.");
				  			Main.sendMessage(p, "/game pvp [on|off] - Turn pvp on or off");
				  			Main.sendMessage(p, "/game mutechat - Toggle the chat");
				  			Main.sendMessage(p, "/game kit <kit> [name|all] - Give a player a kit");
				  			Main.sendMessage(p, "/game kits - List kits");
				  			Main.sendMessage(p, "/game clear [name|all] - Clear all or a player");
				  			Main.sendMessage(p, "/game add <name> - Put a player ingame");
				  			Main.sendMessage(p, "/game remove <name> - Remove a player from the game");
				  			Main.sendMessage(p, "/game setwave [number] - Set the wave.");
				  			Main.sendMessage(p, "To set spawns use /set. To teleport to spawns use /goto");
				  		} else if (args.length == 1) {
				  			if (args[0].equalsIgnoreCase("pvp")) {
				  				Main.sendMessage(p, "/game pvp [on|off]");
				  				Main.sendMessage(p, "Toggle pvp on/off");
				  			} else if (args[0].equalsIgnoreCase("mutechat")) {
				  					if (Util.chaton) {
				  						Util.chaton = false;
				  						Util.bc("Chat has been disabled by " + p.getName() + ".");
				  						Util.bc("Only admins may talk.");
				  					} else {
				  						Util.chaton = true;
				  						Util.bc("Chat has been enabled by " + p.getName() + ".");
				  						Util.bc("You can speak again!");
				  					}
				  			} else if (args[0].equalsIgnoreCase("kit")) {
				  				Util.sendMessage(p, "/game kit <kit> [name|all]");
				  				Util.sendMessage(p, "Give yourself. Everyone or a player a kit.");
				  				Util.sendMessage(p, "/game kits for a list of kits.");
				  			} else if (args[0].equalsIgnoreCase("kits")) {
				  				Util.sendMessage(p, "Kits:");
				  				Util.sendMessage(p, "MvM - MVM Kit");
				  				Util.sendMessage(p, "Clear - No Items, Potions or Armour.");
				  				Util.sendMessage(p, "Soup - Fill empty inventory slots with soup.");
				  				Util.sendMessage(p, "Admin - Knockback 50 Stick and chainmail.");
				  			} else if (args[0].equalsIgnoreCase("clear")) {
				  				Main.sendMessage(p, "/game clear [name|all]");
				  				Main.sendMessage(p, "Clear all or a player.");
				  				Main.sendMessage(p, "Same as /game kit clear");
				  			} else if (args[0].equalsIgnoreCase("add")) {
				  				Main.sendMessage(p, "/game add <name>");
				  				Main.sendMessage(p, "Put a player ingame.");
				  			} else if (args[0].equalsIgnoreCase("remove")) {
				  				Main.sendMessage(p, "/game remove <name>");
				  				Main.sendMessage(p, "Remove a player from the game.");
				  			} else if (args[0].equalsIgnoreCase("setwave")) {
				  				Main.sendMessage(p, "/game setwave [number]");
				  				Main.sendMessage(p, "Set the wave.");
				  			} else if (args[0].equalsIgnoreCase("start")) {
				  				if (Util.MVMIngame) {
				  					Main.sendMessage(p, "Action not possible.");
				  				} else {
				  					Main.sendMessage(p, "You have started the game.");
				  					Util.bc("Game has been started by " + p.getName());
				  					Main.stopMvMCountdown();
				  					MvMCountdown.count = 31;
				  					Main.startMvMCountdown();
				  				}
				  			} else {
					  			Main.sendMessage(p, "Game/Server Commands:");
					  			Main.sendMessage(p, "/game start - Start the game.");
					  			Main.sendMessage(p, "/game pvp [on|off] - Turn pvp on or off");
					  			Main.sendMessage(p, "/game mutechat - Toggle the chat");
					  			Main.sendMessage(p, "/game kit <kit> [name|all] - Give a player a kit");
					  			Main.sendMessage(p, "/game kits - List kits");
					  			Main.sendMessage(p, "/game clear [name|all] - Clear all or a player");
					  			Main.sendMessage(p, "/game add <name> - Put a player ingame");
					  			Main.sendMessage(p, "/game remove <name> - Remove a player from the game");
					  			Main.sendMessage(p, "/game setwave [number] - Set the wave.");
					  			Main.sendMessage(p, "To set spawns use /set. To teleport to spawns use /goto");
				  			}
				  		} else if (args.length == 2) {
				  			if ((args[0].equalsIgnoreCase("pvp"))) {
				  					if (args[1].equalsIgnoreCase("on")) {
				  						World w = p.getWorld();
				  						w.setPVP(true);
				  						Util.sendMessage(p, "PVP Enabled."); 
				  						Util.bc("PVP Enabled by "+p.getName());
				  					} else if (args[1].equalsIgnoreCase("off")) {
				  						World w = p.getWorld();
				  						w.setPVP(false);
				  						Util.sendMessage(p, "PVP Disabled.");
				  						Util.bc("PVP Disabled by "+p.getName()); 
				  					} else {
				  						Main.sendMessage(p, "/game pvp [on|off]");
				  						Main.sendMessage(p, "Toggle pvp on/off");
				  					}
				  			} else if (args[0].equalsIgnoreCase("setwave")) {
				  				int w;
				  				try {
				  					w =Integer.parseInt(args[1]);
				  					Main.WaveCount = w;
				  					Util.bc("§9Wave count has been chanegd to §b" +w+ " §9by §c"+p.getName());
				  				}catch(NumberFormatException e) {
					 					  Util.sendMessage(p, "§9You didnt type a number.");
				  				}
				  			} else if (args[0].equalsIgnoreCase("add")) {
				  				Player pp = Bukkit.getPlayer(args[1]);
				  				if (pp != null) {
				  					if (Util.isAlive(pp)) {
				  						Main.sendMessage(p, "That player is already ingame.");
				  					} else {
				  						Util.leaveMvM(pp);
				  						Util.spectator.remove(pp);
				  						Util.joinMVM(pp);
				  						Util.giveKit(pp, 4);
				  						Util.giveKit(pp, 1);
				  						pp.setAllowFlight(false);
				  						pp.setFlying(false);
				  						Vanish.unVanish(pp);
				  						Util.AdminModeList.remove(pp);
				  						pp.setGameMode(GameMode.ADVENTURE);
				  						Main.sendMessage(pp, "You have been put ingame by " + p.getName());
				  						Main.sendMessage(p, "Player put ingame.");
				  					}
				  				} else {
				  					Main.sendMessage(p, "'"+args[1]+"' couldnt be found.");
				  				}
				  			} else if (args[0].equalsIgnoreCase("remove")) {
				  				Player pp = Bukkit.getPlayer(args[1]);
				  				if (pp != null) {
				  					if (Util.isSpectator(pp)) {
				  						Main.sendMessage(p, "That player is not ingame.");
				  					} else {
				  						Util.leaveMvM(pp);
				  						Util.spectator.add(pp);
				  						pp.setAllowFlight(true);
				  						pp.setFlying(true);
				  						if (p.isOp()) {
				  	            			Util.AdminModeList.add(pp);
				  						}
				  						if (Util.isAdminMode(pp)) {
				  							pp.setGameMode(GameMode.CREATIVE);
				  						} else {
					  						pp.setGameMode(GameMode.ADVENTURE);
				  						}
				  						Vanish.vanish(pp);
				  						Util.giveKit(pp, 4);
				  						Main.sendMessage(pp, "You have been removed from the game by " + p.getName());
				  						Main.sendMessage(p, "Player removed from game.");
				  					}
				  				} else {
				  					Main.sendMessage(p, "'"+args[1]+"' couldnt be found.");
				  				}
				  			} else if (args[0].equalsIgnoreCase("kit")) {
				  				if (args[1].equalsIgnoreCase("mvm")) {
				  					Util.giveKit(p, 1);
				  					Main.sendMessage(p, "Kit: MVM Given.");
				  				} else if (args[1].equalsIgnoreCase("clear")) {
				  					Util.giveKit(p, 4);
				  					Main.sendMessage(p, "Kit: Clear Given.");
				  				} else if (args[1].equalsIgnoreCase("soup")) {
				  					Util.giveKit(p, 3);
				  					Main.sendMessage(p, "Kit: Soup Given.");
				  				} else if (args[1].equalsIgnoreCase("admin")) {
				  					Util.giveKit(p, 2);
				  					Main.sendMessage(p, "Kit: Admin Given.");
				  				} else {
				  					Util.sendMessage(p, "Kits:");
				  					Util.sendMessage(p, "MvM - MVM Kit");
				  					Util.sendMessage(p, "Clear - No Items, Potions or Armour.");
				  					Util.sendMessage(p, "Soup - Fill empty inventory slots with soup.");
				  					Util.sendMessage(p, "Admin - Knockback 50 Stick and chainmail.");
				  				}
				  			} else if (args[0].equalsIgnoreCase("clear")) {
			  					Player pp = Bukkit.getPlayer(args[1]);
			  					if (args[1].equalsIgnoreCase("all")) {
			  						Main.sendMessage(p, "Cleared all inventories potions and armor.");
			  						for (Player ppp : Bukkit.getOnlinePlayers()) {
			  							Util.giveKit(ppp, 4);
			  							  if (ppp.getName().equals(p.getName())) {
			  								  continue;
			  							  }
				  							Util.sendMessage(ppp, "Inventory, Potions and Armor cleared by " + p.getName());
			  						}
			  					} else {
			  						if (pp != null) {
			  							Util.giveKit(pp, 4);
			  							Util.sendMessage(pp, "Inventory, Potions and Armor cleared by " + p.getName());
			  							Util.sendMessage(p, "Inventory, Potions and Armor cleared for " + pp.getName());
			  						} else {
		  							Main.sendMessage(p, "'"+args[1]+"' couldnt be found.");
			  						}
			  					}
				  			} else {
					  			Main.sendMessage(p, "Game/Server Commands:");
					  			Main.sendMessage(p, "/game start - Start the game.");
					  			Main.sendMessage(p, "/game pvp [on|off] - Turn pvp on or off");
					  			Main.sendMessage(p, "/game mutechat - Toggle the chat");
					  			Main.sendMessage(p, "/game kit <kit> [name|all] - Give a player a kit");
					  			Main.sendMessage(p, "/game kits - List kits");
					  			Main.sendMessage(p, "/game clear [name|all] - Clear all or a player");
					  			Main.sendMessage(p, "/game add <name> - Put a player ingame");
					  			Main.sendMessage(p, "/game remove <name> - Remove a player from the game");
					  			Main.sendMessage(p, "/game setwave [number] - Set the wave.");
					  			Main.sendMessage(p, "To set spawns use /set. To teleport to spawns use /goto");
				  			}
				  		} else if (args.length == 3) {
				  			if (args[0].equalsIgnoreCase("kit")) {
				  				if ((args[1].equalsIgnoreCase("mvm")) || (args[1].equalsIgnoreCase("clear")) || (args[1].equalsIgnoreCase("soup")) || (args[1].equalsIgnoreCase("admin"))) {
				  					Player pp = Bukkit.getPlayer(args[2]);
				  					if (args[2].equalsIgnoreCase("all")) {
				  						if (args[1].equalsIgnoreCase("mvm")) {
				  							Main.sendMessage(p, "Kit: MVM Given to all.");
				  							for (Player ppp : Util.MvM) {
				  								Util.giveKit(ppp, 1);
					  							  if (ppp.getName().equals(p.getName())) {
					  								  continue;
					  							  }
						  							Main.sendMessage(ppp, "Kit: "+args[1]+" given.");
				  							}
				  						} else if (args[1].equalsIgnoreCase("clear")) {
				  							Main.sendMessage(p, "Kit: Clear Given to all.");
				  							for (Player ppp : Util.MvM) {
				  								Util.giveKit(ppp, 4);
				  							  if (ppp.getName().equals(p.getName())) {
				  								  continue;
				  							  }
					  							Main.sendMessage(ppp, "Kit: "+args[1]+" given.");
				  							}
				  						} else if (args[1].equalsIgnoreCase("soup")) {
				  							Main.sendMessage(p, "Kit: Soup Given to all.");
				  							for (Player ppp : Util.MvM) {
				  								Util.giveKit(ppp, 3);
					  							  if (ppp.getName().equals(p.getName())) {
					  								  continue;
					  							  }
						  							Main.sendMessage(ppp, "Kit: "+args[1]+" given.");
				  							}
				  						} else if (args[1].equalsIgnoreCase("admin")) {
				  							Main.sendMessage(p, "Kit: Admin Given to all.");
				  							for (Player ppp : Util.MvM) {
				  								Util.giveKit(ppp, 2);
					  							  if (ppp.getName().equals(p.getName())) {
					  								  continue;
					  							  }
						  							Main.sendMessage(ppp, "Kit: "+args[1]+" given.");
				  							}
				  						} else {
				  							Util.sendMessage(p, "Kits:");
				  							Util.sendMessage(p, "MvM - MVM Kit");
				  							Util.sendMessage(p, "Clear - No Items, Potions or Armour.");
				  							Util.sendMessage(p, "Soup - Fill empty inventory slots with soup.");
				  							Util.sendMessage(p, "Admin - Knockback 50 Stick and chainmail.");
				  						}
				  					} else {
				  						if (pp != null) {
				  							if (args[1].equalsIgnoreCase("mvm")) {
				  								Util.giveKit(pp, 1);
				  								Main.sendMessage(p, "Kit: " + args[1] + " given to " + pp.getName()+".");
				  								Main.sendMessage(pp, "Kit: " + args[1] + " given.");
				  							} else if (args[1].equalsIgnoreCase("clear")) {
				  								Util.giveKit(pp, 4);
				  								Main.sendMessage(p, "Kit: " + args[1] + " given to " + pp.getName()+".");
				  								Main.sendMessage(pp, "Kit: " + args[1] + " given.");
				  							} else if (args[1].equalsIgnoreCase("soup")) {
				  								Util.giveKit(pp, 3);
				  								Main.sendMessage(p, "Kit: " + args[1] + " given to " + pp.getName()+".");
				  								Main.sendMessage(pp, "Kit: " + args[1] + " given.");
				  							} else if (args[1].equalsIgnoreCase("admin")) {
				  								Util.giveKit(pp, 2);
				  								Main.sendMessage(p, "Kit: " + args[1] + " given to " + pp.getName()+".");
				  								Main.sendMessage(pp, "Kit: " + args[1] + " given.");
				  							} else {
				  								Util.sendMessage(p, "Kits:");
				  								Util.sendMessage(p, "MvM - MVM Kit");
				  								Util.sendMessage(p, "Clear - No Items, Potions or Armour.");
				  								Util.sendMessage(p, "Soup - Fill empty inventory slots with soup.");
				  								Util.sendMessage(p, "Admin - Knockback 50 Stick and chainmail.");
				  							}
				  						} else {
				  							Main.sendMessage(p, "'"+args[2]+"' couldnt be found.");
				  						}
				  					}
				  				} else {
				  					Util.sendMessage(p, "Kits:");
				  					Util.sendMessage(p, "MvM - MVM Kit");
				  					Util.sendMessage(p, "Clear - No Items, Potions or Armour.");
				  					Util.sendMessage(p, "Soup - Fill empty inventory slots with soup.");
				  					Util.sendMessage(p, "Admin - Knockback 50 Stick and chainmail.");
				  				}
				  			} else {
					  			Main.sendMessage(p, "Game/Server Commands:");
					  			Main.sendMessage(p, "/game start - Start the game.");
					  			Main.sendMessage(p, "/game pvp [on|off] - Turn pvp on or off");
					  			Main.sendMessage(p, "/game mutechat - Toggle the chat");
					  			Main.sendMessage(p, "/game kit <kit> [name|all] - Give a player a kit");
					  			Main.sendMessage(p, "/game kits - List kits");
					  			Main.sendMessage(p, "/game clear [name|all] - Clear all or a player");
					  			Main.sendMessage(p, "/game add <name> - Put a player ingame");
					  			Main.sendMessage(p, "/game remove <name> - Remove a player from the game");
					  			Main.sendMessage(p, "/game setwave [number] - Set the wave.");
					  			Main.sendMessage(p, "To set spawns use /set. To teleport to spawns use /goto");
				  			}
				  		}
				  	} else {
				  		Util.adminMode(p);
				  	}
			  } else {
				  sender.sendMessage("Invalid Sender (Player Required");
			  }
		  }
		  return false;		  
	  	}
}
