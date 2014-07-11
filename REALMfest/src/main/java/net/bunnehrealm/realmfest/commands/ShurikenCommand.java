package net.bunnehrealm.realmfest.commands;

import net.bunnehrealm.realmfest.RealmFest;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShurikenCommand implements CommandExecutor{
	RealmFest plugin = RealmFest.plugin;
	
	public ShurikenCommand(RealmFest instance){
		this.plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender cs, Command command,
			String label, String[] args) {
		
		if(label.equalsIgnoreCase("shuriken")){
			if(!(cs instanceof Player)){
				cs.sendMessage("This is a player only command!");
				return false;
			}
			else{
				Player p = (Player) cs;
				if(!(p.hasPermission("realmfest.shuriken") || p.isOp())){
					p.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
					return false;
				}
				else{
					if(!(plugin.players.getBoolean(p.getUniqueId() + ".shuriken"))){
						plugin.players.set(p.getUniqueId() + ".shuriken", true);
						p.sendMessage(ChatColor.BLUE + "You take out your sharp blades.");
						plugin.savePlayers();
						return true;
					}
					else{
						plugin.players.set(p.getUniqueId() + ".shuriken", false);
						p.sendMessage(ChatColor.BLUE + "You sheath your blades.");
						plugin.savePlayers();
						return true;
					}
				}
			}
		}
		
		return false;
	}

}
