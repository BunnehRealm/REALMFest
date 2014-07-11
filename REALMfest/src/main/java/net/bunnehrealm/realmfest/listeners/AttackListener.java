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

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class AttackListener implements Listener {
	RealmFest plugin = RealmFest.plugin;

	public AttackListener(RealmFest instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void onAttack(EntityDamageByEntityEvent e) {
		if ((e.getDamager() instanceof Player)
				&& (e.getEntity() instanceof Player)) {
			Player p = (Player) e.getEntity();
			Player t = (Player) e.getDamager();
			if (!((plugin.players.getBoolean(p.getUniqueId() + ".pvpenabled")) && (plugin.players
					.getBoolean(t.getUniqueId() + ".pvpenabled")))) {
				e.setCancelled(true);
			} else {
				e.setCancelled(false);
			}
		}

		else if ((e.getDamager() instanceof Arrow)) {
			Arrow arrow = (Arrow) e.getDamager();
			if ((arrow.getShooter() instanceof Player)
					&& ((e.getEntity() instanceof Player))) {
				Player p = (Player) arrow.getShooter();
				Player t = (Player) e.getEntity();
				if (!((plugin.players.getBoolean(p.getUniqueId()
						+ ".pvpenabled")) && (plugin.players.getBoolean(t
						.getUniqueId() + ".pvpenabled")))) {
					e.setCancelled(true);
				} else {
					e.setCancelled(false);
				}
			}
		}
		else if ((e.getDamager() instanceof ThrownPotion)) {
			ThrownPotion thrownpotion = (ThrownPotion) e.getDamager();
			if ((thrownpotion.getShooter() instanceof Player)
					&& ((e.getEntity() instanceof Player))) {
				Player p = (Player) thrownpotion.getShooter();
				Player t = (Player) e.getEntity();
				if (!((plugin.players.getBoolean(p.getUniqueId()
						+ ".pvpenabled")) && (plugin.players.getBoolean(t
						.getUniqueId() + ".pvpenabled")))) {
					e.setCancelled(true);
				} else {
					e.setCancelled(false);
				}
			}
		}
	}

}
