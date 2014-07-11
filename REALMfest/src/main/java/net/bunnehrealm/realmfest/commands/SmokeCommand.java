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
