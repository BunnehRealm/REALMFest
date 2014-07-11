package net.bunnehrealm.realmfest;

import java.io.File;

import net.bunnehrealm.realmfest.commands.BouquetCommand;
import net.bunnehrealm.realmfest.commands.PvpCommand;
import net.bunnehrealm.realmfest.commands.RideCommand;
import net.bunnehrealm.realmfest.commands.RideMeCommand;
import net.bunnehrealm.realmfest.commands.ShurikenCommand;
import net.bunnehrealm.realmfest.commands.SmokeCommand;
import net.bunnehrealm.realmfest.listeners.AttackListener;
import net.bunnehrealm.realmfest.listeners.BDamageListener;
import net.bunnehrealm.realmfest.listeners.DeathListener;
import net.bunnehrealm.realmfest.listeners.ShurikenListener;
import net.bunnehrealm.realmfest.managers.PvpManager;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class RealmFest extends JavaPlugin {

	public static RealmFest plugin;

	public File playersFile;
	public FileConfiguration players;

	public RideCommand rc = new RideCommand(this);
	public RideMeCommand rmc = new RideMeCommand(this);
	public BouquetCommand bc = new BouquetCommand(this);
	public SmokeCommand sc = new SmokeCommand(this);
	public PvpCommand pvpc = new PvpCommand(this);
	public ShurikenCommand shkc = new ShurikenCommand(this);

	public BDamageListener bdl = new BDamageListener(this);
	public AttackListener al = new AttackListener(this);
	public ShurikenListener sl = new ShurikenListener(this);
	public DeathListener dl = new DeathListener(this);

	public PvpManager pvpm = new PvpManager(this);

	@Override
	public void onDisable() {
		plugin = null;
	}

	@Override
	public void onEnable() {
		plugin = this;
		playersFile = new File(getDataFolder(), "Players.yml");
		players = new YamlConfiguration();

		getCommand("ride").setExecutor(rc);
		getCommand("rideme").setExecutor(rmc);
		getCommand("bouquet").setExecutor(bc);
		getCommand("smoke").setExecutor(sc);
		getCommand("pvp").setExecutor(pvpc);
		getCommand("shuriken").setExecutor(shkc);

		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(bdl, this);
		pm.registerEvents(al, this);
		pm.registerEvents(sl, this);
		pm.registerEvents(dl, this);

		try {
			firstPlayerRun();
		} catch (Exception e) {
			e.printStackTrace();
		}

		loadPlayers();
		savePlayers();

		getConfig().options().copyDefaults(true);

		if (!(this.getConfig().contains("PvP.leavetime"))) {
			this.getConfig().set("PvP.leavetime", 60);
		}

		saveConfig();

		pvpm.updatePvp();

		BukkitScheduler bs = Bukkit.getScheduler();
		bs.scheduleSyncRepeatingTask(plugin, new Runnable() {

			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()) {
					if (players.getBoolean(p.getUniqueId().toString()
							+ ".smoking")) {

						p.getWorld().playEffect(p.getLocation(), Effect.SMOKE,
								4);
						Location waist = p.getLocation();
						waist.setY(p.getLocation().getY() + 1);
						p.getWorld().playEffect(waist, Effect.SMOKE, 4);
					}

				}

			}
		}

		, 0, 5);

	}

	public void firstPlayerRun() throws Exception {
		if (!playersFile.exists()) {
			getLogger().info("Creating a Players.yml file");
			playersFile.getParentFile().mkdirs();
			playersFile.createNewFile();

		}
	}

	public void loadPlayers() {
		try {
			players.load(playersFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void savePlayers() {
		try {
			players.save(playersFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void smokeCheck(Player p) {
		if (plugin.players.getBoolean(p.getUniqueId().toString() + ".smoking")) {
			p.sendMessage("swerg");
			p.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 3);
		}
	}

}
