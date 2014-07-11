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
