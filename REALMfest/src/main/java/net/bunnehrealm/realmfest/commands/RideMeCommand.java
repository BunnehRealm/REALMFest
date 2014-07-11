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

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class RideMeCommand implements CommandExecutor{

	RealmFest plugin = RealmFest.plugin;
	
	public RideMeCommand(RealmFest realmFest) {
		this.plugin = realmFest;
	}

	@Override
	public boolean onCommand(CommandSender cs, Command command,
			String label, String[] args) {
		
		if (label.equalsIgnoreCase("rideme")) {
			if (!(cs instanceof Player)) {
				cs.sendMessage("That is a player only command");
				return false;
			}
			Player p = (Player) cs;
			if (!(p.hasPermission("realmfest.rideme") || p.isOp())) {
				p.sendMessage(ChatColor.RED
						+ "You do not have permission to use this command!");
				return false;
			}
			if (args.length != 1) {
				p.sendMessage(ChatColor.RED + "Incorrect amount of arguments!");
			} else {

				Player target = Bukkit.getPlayer(args[0]);
				if (!(p.getNearbyEntities(5, 5, 5).contains(target))) {
					p.sendMessage(ChatColor.RED
							+ "That player is not close enought to you to perform the command!");
				} else {
					if (p.getPassenger() != null) {
						p.sendMessage(ChatColor.RED
								+ "You are already being ridden!");
					} else {
						p.setPassenger(target);
					}
				}
			}

		}

		return false;
	}

}
