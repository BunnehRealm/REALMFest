/*REALM Fest for adding fun commands and functions to bukkit.
 Copyright (C) 2013  Rory Finnegan
 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
