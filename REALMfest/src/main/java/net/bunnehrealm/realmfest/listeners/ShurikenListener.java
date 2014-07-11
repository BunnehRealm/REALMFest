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
