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
