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

public class SmokeCommand implements CommandExecutor {
	RealmFest plugin = RealmFest.plugin;

	public SmokeCommand(RealmFest instance) {
		this.plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender cs, Command command, String label,
			String[] args) {

		if (label.equalsIgnoreCase("smoke")) {
			if (!(cs instanceof Player)) {
				cs.sendMessage(ChatColor.RED + "This is a player only command!");
			} else {
				Player p = (Player) cs;
				if (!(p.hasPermission("realmfest.smoke") || p.isOp())) {
					p.sendMessage(ChatColor.RED
							+ "You do not have permission to use this command!");
				} else {
					if (!(plugin.players.getBoolean(p.getUniqueId().toString()
							+ ".smoking"))
							|| !(plugin.players.contains(p.getUniqueId()
									.toString() + ".smoking"))) {
						plugin.players.set(p.getUniqueId().toString()
								+ ".smoking", true);
						plugin.savePlayers();
					} else {
						plugin.players.set(p.getUniqueId().toString()
								+ ".smoking", false);
						plugin.savePlayers();
					}

					return false;
				}
			}
			return false;
		}
		return false;
	}
}
