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

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class DeathListener implements Listener {

	public DeathListener(RealmFest realmFest) {

	}

	@EventHandler
	public void onPlayerDeath(EntityDamageByEntityEvent e) {
		if (e.getEntity().getType() == EntityType.PLAYER) {
			Player p = (Player) e.getEntity();
				if (e.getDamager().getType() == EntityType.ZOMBIE) {
					Zombie z = (Zombie) p.getKiller();
					ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
					SkullMeta meta = (SkullMeta) skull.getItemMeta();
					meta.setOwner(p.getName());
					skull.setItemMeta(meta);
					z.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
					ItemStack is2 = new ItemStack(Material.IRON_HELMET);
					p.getEquipment().setHelmet(is2);
				} else if (e.getDamager().getType() == EntityType.SKELETON) {
					Skeleton z = (Skeleton) p.getKiller();
					ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1,
							(short) 3);
					SkullMeta meta = (SkullMeta) skull.getItemMeta();
					meta.setOwner(p.getName());
					skull.setItemMeta(meta);
					z.getEquipment().setHelmet(skull);
				}
			}
		
	}
}
