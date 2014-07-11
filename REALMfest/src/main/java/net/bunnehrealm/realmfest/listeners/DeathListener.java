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
