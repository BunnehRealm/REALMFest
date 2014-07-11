package net.bunnehrealm.realmfest.listeners;

import net.bunnehrealm.realmfest.RealmFest;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class BDamageListener implements Listener {
	RealmFest plugin = RealmFest.plugin;

	public BDamageListener(RealmFest instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void onBlockHit(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (p.isInsideVehicle()) {
				if (e.getCause() == DamageCause.SUFFOCATION)
					e.setCancelled(true);
			}
		}
	}
}
