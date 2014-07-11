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

package net.bunnehrealm.realmfest.managers;

import net.bunnehrealm.realmfest.RealmFest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public class PvpManager {
	static RealmFest plugin = RealmFest.plugin;

	public PvpManager(RealmFest instance) {
		PvpManager.plugin = instance;
	}

	public static void enablePvP(Player p) {
		RealmFest.plugin.players.set(p.getUniqueId() + ".pvpenabled", true);
		p.sendMessage(ChatColor.AQUA + "PvP has been " + ChatColor.GREEN
				+ "enabled");
	}

	public static void disablePvP(final Player p) {
		p.sendMessage(ChatColor.AQUA + "Your PvP will be disabled in "
				+ ChatColor.GREEN
				+ RealmFest.plugin.getConfig().getInt("PvP.leavetime")
				+ ChatColor.AQUA + " seconds!");
		BukkitScheduler bs = Bukkit.getScheduler();
		bs.scheduleSyncDelayedTask(plugin, new BukkitRunnable() {

			@Override
			public void run() {
				RealmFest.plugin.players.set(p.getUniqueId() + ".pvpenabled",
						false);
				p.sendMessage(ChatColor.AQUA + "PvP has been "
						+ ChatColor.GREEN + "disabled");
			}

		}, 20 * plugin.getConfig().getInt("PvP.leavetime"));
	}

	public void updatePvp() {
		final BukkitScheduler bs = Bukkit.getScheduler();
		bs.scheduleSyncRepeatingTask(plugin, new BukkitRunnable() {
			@Override
			public void run() {
				for (final Player p : Bukkit.getOnlinePlayers()) {
					if (RealmFest.plugin.players.getBoolean(p.getUniqueId()
							+ ".pvpenabled")) {

						Location loc = p.getLocation();
						loc.setY(p.getLocation().getY() + 2);

						ItemStack is = new ItemStack(Material.DIAMOND_SWORD);
						final Item item = p.getWorld().dropItem(
								loc, is);
						item.setPickupDelay(Integer.MAX_VALUE);

						if (p.getPassenger() != null) {
							
						} else {
							
							bs.runTaskLater(plugin, new BukkitRunnable() {

								@Override
								public void run() {
									item.remove();

								}

							}, 1);
						}

					}
				}
			}
		}

		, 0, 2);
	}

}
