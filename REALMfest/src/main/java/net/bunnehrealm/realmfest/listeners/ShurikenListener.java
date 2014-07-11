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

package net.bunnehrealm.realmfest.listeners;

import net.bunnehrealm.realmfest.RealmFest;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ShurikenListener implements Listener {
	RealmFest plugin = RealmFest.plugin;

	public ShurikenListener(RealmFest instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void onThrow(PlayerInteractEvent e) {

		Player p = e.getPlayer();
		if (plugin.players.getBoolean(p.getUniqueId() + ".shuriken")) {
			if (e.getAction() == Action.RIGHT_CLICK_AIR) {

				Location loc = p.getLocation();
				loc.setY(loc.getY() + 1);

				FallingBlock shuriken = e.getPlayer().getWorld()
						.spawnFallingBlock(loc, 55, (byte) 0);
				shuriken.setVelocity(p.getEyeLocation().getDirection()
						.multiply(3));
				shuriken.setDropItem(false);
			}
		}
	}

	@EventHandler
	public void onChange(EntityChangeBlockEvent e) {
		if (e.getEntity() instanceof FallingBlock) {
			FallingBlock block = (FallingBlock) e.getEntity();
			if (block.getMaterial().equals(Material.REDSTONE_WIRE)) {
				e.setCancelled(true);
			}
		}
	}
}
