package net.bunnehrealm.realmfest.commands;

import net.bunnehrealm.realmfest.RealmFest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

public class BouquetCommand implements CommandExecutor {

	RealmFest plugin = RealmFest.plugin;

	public BouquetCommand(RealmFest realmFest) {
		this.plugin = realmFest;
	}

	public Item item10;
	public Item item9;
	public Item item8;
	public Item item7;
	public Item item6;
	public Item item5;
	public Item item4;
	public Item item3;
	public Item item2;
	public Item item1;

	@Override
	public boolean onCommand(CommandSender cs, Command command, String label,
			String[] args) {

		if (!(cs instanceof Player)) {
			cs.sendMessage(ChatColor.RED + "This is a player only command!");
		} else {
			final Player p = (Player) cs;
			if (!(p.hasPermission("realmfest.bouquet") || p.isOp())) {
				p.sendMessage(ChatColor.RED
						+ "You do not have permission to use this command!");
				return false;
			} else {
				
				final Location use = p.getLocation();
				use.setX(p.getLocation().getX() + 2);

				double x1 = (Math.random() * (0.5 - (-1)));
				double y1 = (Math.random() * 1);
				double z1 = (Math.random() * (0.5 - (-1)));

				ItemStack is1 = new ItemStack(Material.RED_ROSE);
				final Item item1 = p.getWorld().dropItem(use, is1);
				Vector v1 = new Vector(x1, y1, z1);
				item1.setVelocity(v1);

				item1.setPickupDelay(Integer.MAX_VALUE);

				new BukkitRunnable() {
					@Override
					public void run() {
						item1.remove();
					}
				}.runTaskLater(plugin, 120L);

				BukkitScheduler schedule2 = Bukkit.getScheduler();
				schedule2.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x2 = (Math.random() * (0.5 - (-1)));
						double y2 = (Math.random() * 1);
						double z2 = (Math.random() * (0.5 - (-1)));

						ItemStack is2 = new ItemStack(Material.YELLOW_FLOWER);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item2 = p.getWorld().dropItem(
								use, is2);
						Vector v2 = new Vector(x2, y2, z2);
						item2.setVelocity(v2);

						item2.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item2.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 15);

				BukkitScheduler schedule3 = Bukkit.getScheduler();
				schedule3.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x3 = (Math.random() * (0.5 - (-1)));
						double y3 = (Math.random() * 1);
						double z3 = (Math.random() * (0.5 - (-1)));

						ItemStack is3 = new ItemStack(Material.DOUBLE_PLANT);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item3 = p.getWorld().dropItem(
								use, is3);
						Vector v3 = new Vector(x3, y3, z3);
						item3.setVelocity(v3);

						item3.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item3.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 30);

				BukkitScheduler schedule4 = Bukkit.getScheduler();
				schedule4.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x4 = (Math.random() * (0.5 - (-1)));
						double y4 = (Math.random() * 1);
						double z4 = (Math.random() * (0.5 - (-1)));

						ItemStack is4 = new ItemStack(Material.DOUBLE_PLANT);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item4 = p.getWorld().dropItem(
								use, is4);
						Vector v4 = new Vector(x4, y4, z4);
						item4.setVelocity(v4);

						item4.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item4.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 40);

				BukkitScheduler schedule5 = Bukkit.getScheduler();
				schedule5.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x5 = (Math.random() * (0.5 - (-1)));
						double y5 = (Math.random() * 1);
						double z5 = (Math.random() * (0.5 - (-1)));

						ItemStack is5 = new ItemStack(Material.RED_ROSE);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item5 = p.getWorld().dropItem(
								use, is5);
						Vector v5 = new Vector(x5, y5, z5);
						item5.setVelocity(v5);

						item5.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item5.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 50);

				BukkitScheduler schedule6 = Bukkit.getScheduler();
				schedule6.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x6 = (Math.random() * (0.5 - (-1)));
						double y6 = (Math.random() * 1);
						double z6 = (Math.random() * (0.5 - (-1)));

						ItemStack is6 = new ItemStack(Material.YELLOW_FLOWER);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item6 = p.getWorld().dropItem(
								use, is6);
						Vector v6 = new Vector(x6, y6, z6);
						item6.setVelocity(v6);

						item6.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item6.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 60);

				BukkitScheduler schedule7 = Bukkit.getScheduler();
				schedule7.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x7 = (Math.random() * (0.5 - (-1)));
						double y7 = (Math.random() * 1);
						double z7 = (Math.random() * (0.5 - (-1)));

						ItemStack is7 = new ItemStack(Material.RED_ROSE);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item7 = p.getWorld().dropItem(
								use, is7);
						Vector v7 = new Vector(x7, y7, z7);
						item7.setVelocity(v7);

						item7.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item7.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 70);

				BukkitScheduler schedule8 = Bukkit.getScheduler();
				schedule8.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x8 = (Math.random() * (0.5 - (-1)));
						double y8 = (Math.random() * 1);
						double z8 = (Math.random() * (0.5 - (-1)));

						ItemStack is8 = new ItemStack(Material.DOUBLE_PLANT);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item8 = p.getWorld().dropItem(
								use, is8);
						Vector v8 = new Vector(x8, y8, z8);
						item8.setVelocity(v8);

						item8.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item8.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 80);

				BukkitScheduler schedule9 = Bukkit.getScheduler();
				schedule9.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x9 = (Math.random() * (0.5 - (-1)));
						double y9 = (Math.random() * 1);
						double z9 = (Math.random() * (0.5 - (-1)));

						ItemStack is9 = new ItemStack(Material.YELLOW_FLOWER);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item9 = p.getWorld().dropItem(
								use, is9);
						Vector v9 = new Vector(x9, y9, z9);
						item9.setVelocity(v9);

						item9.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item9.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 90);

				BukkitScheduler schedule10 = Bukkit.getScheduler();
				schedule10.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x10 = (Math.random() * (0.5 - (-1)));
						double y10 = (Math.random() * 1);
						double z10 = (Math.random() * (0.5 - (-0.1)));

						ItemStack is10 = new ItemStack(Material.RED_ROSE);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item10 = p.getWorld().dropItem(
								use, is10);
						Vector v10 = new Vector(x10, y10, z10);
						item10.setVelocity(v10);

						item10.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item10.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 100);

				double x11 = (Math.random() * (0.5 - (-1)));
				double y11 = (Math.random() * 1);
				double z11 = (Math.random() * (0.5 - (-1)));

				ItemStack is11 = new ItemStack(Material.RED_ROSE);
				use.setX(p.getLocation().getX());
				use.setY(p.getLocation().getY() + 2);
				use.setZ(p.getLocation().getZ());
				final Item item11 = p.getWorld()
						.dropItem(use, is11);
				Vector v11 = new Vector(x11, y11, z11);
				item11.setVelocity(v11);

				item11.setPickupDelay(Integer.MAX_VALUE);

				new BukkitRunnable() {
					@Override
					public void run() {
						item11.remove();
					}
				}.runTaskLater(plugin, 11L);

				BukkitScheduler schedule12 = Bukkit.getScheduler();
				schedule12.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x12 = (Math.random() * (0.12 - (-1)));
						double y12 = (Math.random() * 1);
						double z12 = (Math.random() * (0.12 - (-1)));

						ItemStack is12 = new ItemStack(Material.YELLOW_FLOWER);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						
						final Item item12 = p.getWorld().dropItem(
								use, is12);
						Vector v12 = new Vector(x12, y12, z12);
						item12.setVelocity(v12);

						item12.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item12.remove();
							}
						}.runTaskLater(plugin, 1120L);

					}

				}, 25);

				BukkitScheduler schedule13 = Bukkit.getScheduler();
				schedule13.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x13 = (Math.random() * (0.12 - (-1)));
						double y13 = (Math.random() * 1);
						double z13 = (Math.random() * (0.12 - (-1)));

						ItemStack is13 = new ItemStack(Material.DOUBLE_PLANT);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item13 = p.getWorld().dropItem(
								use, is13);
						Vector v13 = new Vector(x13, y13, z13);
						item13.setVelocity(v13);

						item13.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item13.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 35);

				BukkitScheduler schedule14 = Bukkit.getScheduler();
				schedule14.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x14 = (Math.random() * (0.12 - (-1)));
						double y14 = (Math.random() * 1);
						double z14 = (Math.random() * (0.12 - (-1)));

						ItemStack is14 = new ItemStack(Material.DOUBLE_PLANT);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item14 = p.getWorld().dropItem(
								use, is14);
						Vector v14 = new Vector(x14, y14, z14);
						item14.setVelocity(v14);

						item14.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item14.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 45);

				BukkitScheduler schedule15 = Bukkit.getScheduler();
				schedule12.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x15 = (Math.random() * (0.12 - (-1)));
						double y15 = (Math.random() * 1);
						double z15 = (Math.random() * (0.12 - (-1)));

						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						ItemStack is15 = new ItemStack(Material.RED_ROSE);
						final Item item15 = p.getWorld().dropItem(
								use, is15);
						Vector v15 = new Vector(x15, y15, z15);
						item15.setVelocity(v15);

						item15.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item15.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 55);

				BukkitScheduler schedule16 = Bukkit.getScheduler();
				schedule16.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x16 = (Math.random() * (0.12 - (-1)));
						double y16 = (Math.random() * 1);
						double z16 = (Math.random() * (0.12 - (-1)));

						ItemStack is16 = new ItemStack(Material.YELLOW_FLOWER);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item16 = p.getWorld().dropItem(
								use, is16);
						Vector v16 = new Vector(x16, y16, z16);
						item16.setVelocity(v16);

						item16.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item16.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 65);

				BukkitScheduler schedule17 = Bukkit.getScheduler();
				schedule17.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x17 = (Math.random() * (0.12 - (-1)));
						double y17 = (Math.random() * 1);
						double z17 = (Math.random() * (0.12 - (-1)));

						ItemStack is17 = new ItemStack(Material.RED_ROSE);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item17 = p.getWorld().dropItem(
								use, is17);
						Vector v17 = new Vector(x17, y17, z17);
						item17.setVelocity(v17);

						item17.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item17.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 75);

				BukkitScheduler schedule18 = Bukkit.getScheduler();
				schedule18.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x18 = (Math.random() * (0.12 - (-1)));
						double y18 = (Math.random() * 1);
						double z18 = (Math.random() * (0.12 - (-1)));

						ItemStack is18 = new ItemStack(Material.DOUBLE_PLANT);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item18 = p.getWorld().dropItem(
								use, is18);
						Vector v18 = new Vector(x18, y18, z18);
						item18.setVelocity(v18);

						item18.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item18.remove();
							}
						}.runTaskLater(plugin, 1120L);

					}

				}, 85);

				BukkitScheduler schedule19 = Bukkit.getScheduler();
				schedule19.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x19 = (Math.random() * (0.12 - (-1)));
						double y19 = (Math.random() * 1);
						double z19 = (Math.random() * (0.12 - (-1)));

						ItemStack is19 = new ItemStack(Material.YELLOW_FLOWER);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item19 = p.getWorld().dropItem(
								use, is19);
						Vector v19 = new Vector(x19, y19, z19);
						item19.setVelocity(v19);

						item19.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item19.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 95);

				BukkitScheduler schedule20 = Bukkit.getScheduler();
				schedule20.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x20 = (Math.random() * (0.12 - (-1)));
						double y20 = (Math.random() * 1);
						double z20 = (Math.random() * (0.12 - (-0.1)));

						ItemStack is20 = new ItemStack(Material.RED_ROSE);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item20 = p.getWorld().dropItem(
								use, is20);
						Vector v20 = new Vector(x20, y20, z20);
						item20.setVelocity(v20);

						item20.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item20.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 110);
				
				
				
				
				
				double x21 = (Math.random() * (0.5 - (-1)));
				double y21 = (Math.random() * 1);
				double z21 = (Math.random() * (0.5 - (-1)));

				ItemStack is21 = new ItemStack(Material.RED_ROSE);
				use.setX(p.getLocation().getX());
				use.setY(p.getLocation().getY() + 2);
				use.setZ(p.getLocation().getZ());
				final Item item21 = p.getWorld()
						.dropItem(use, is21);
				Vector v21 = new Vector(x21, y21, z21);
				item1.setVelocity(v21);

				item21.setPickupDelay(Integer.MAX_VALUE);

				new BukkitRunnable() {
					@Override
					public void run() {
						item21.remove();
					}
				}.runTaskLater(plugin, 120L);

				BukkitScheduler schedule22 = Bukkit.getScheduler();
				schedule22.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x22 = (Math.random() * (0.15 - (-0.15)));
						double y22 = (Math.random() * 1);
						double z22 = (Math.random() * (0.15 - (-0.15)));

						ItemStack is22 = new ItemStack(Material.YELLOW_FLOWER);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						
						final Item item22 = p.getWorld().dropItem(
								use, is22);
						Vector v22 = new Vector(x22, y22, z22);
						item22.setVelocity(v22);

						item22.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item22.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 25);

				BukkitScheduler schedule23 = Bukkit.getScheduler();
				schedule23.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x23 = (Math.random() * (0.15 - (-0.15)));
						double y23 = (Math.random() * 1);
						double z23 = (Math.random() * (0.15 - (-0.15)));

						ItemStack is23 = new ItemStack(Material.DOUBLE_PLANT);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item23 = p.getWorld().dropItem(
								use, is23);
						Vector v23 = new Vector(x23, y23, z23);
						item23.setVelocity(v23);

						item23.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item23.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 35);

				BukkitScheduler schedule24 = Bukkit.getScheduler();
				schedule24.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x24 = (Math.random() * (0.15 - (-0.15)));
						double y24 = (Math.random() * 1);
						double z24 = (Math.random() * (0.15 - (-0.15)));

						ItemStack is24 = new ItemStack(Material.DOUBLE_PLANT);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item24 = p.getWorld().dropItem(
								use, is24);
						Vector v24 = new Vector(x24, y24, z24);
						item24.setVelocity(v24);

						item24.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item24.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 45);

				BukkitScheduler schedule25 = Bukkit.getScheduler();
				schedule22.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x25 = (Math.random() * (0.15 - (-0.15)));
						double y25 = (Math.random() * 1);
						double z25 = (Math.random() * (0.15 - (-0.15)));

						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						ItemStack is25 = new ItemStack(Material.RED_ROSE);
						final Item item25 = p.getWorld().dropItem(
								use, is25);
						Vector v25 = new Vector(x25, y25, z25);
						item25.setVelocity(v25);

						item25.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item25.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 55);

				BukkitScheduler schedule26 = Bukkit.getScheduler();
				schedule26.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x26 = (Math.random() * (0.15 - (-0.15)));
						double y26 = (Math.random() * 1);
						double z26 = (Math.random() * (0.15 - (-0.15)));

						ItemStack is26 = new ItemStack(Material.YELLOW_FLOWER);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item26 = p.getWorld().dropItem(
								use, is26);
						Vector v26 = new Vector(x26, y26, z26);
						item26.setVelocity(v26);

						item26.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item26.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 65);

				BukkitScheduler schedule27 = Bukkit.getScheduler();
				schedule27.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x27 = (Math.random() * (0.15 - (-0.15)));
						double y27 = (Math.random() * 1);
						double z27 = (Math.random() * (0.15 - (-0.15)));

						ItemStack is27 = new ItemStack(Material.RED_ROSE);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item27 = p.getWorld().dropItem(
								use, is27);
						Vector v27 = new Vector(x27, y27, z27);
						item27.setVelocity(v27);

						item27.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item27.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 75);

				BukkitScheduler schedule28 = Bukkit.getScheduler();
				schedule28.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x28 = (Math.random() * (0.15 - (-0.15)));
						double y28 = (Math.random() * 1);
						double z28 = (Math.random() * (0.15 - (-0.15)));

						ItemStack is28 = new ItemStack(Material.DOUBLE_PLANT);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item28 = p.getWorld().dropItem(
								use, is28);
						Vector v28 = new Vector(x28, y28, z28);
						item28.setVelocity(v28);

						item28.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item28.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 85);

				BukkitScheduler schedule29 = Bukkit.getScheduler();
				schedule29.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x29 = (Math.random() * (0.15 - (-0.15)));
						double y29 = (Math.random() * 1);
						double z29 = (Math.random() * (0.15 - (-0.15)));

						ItemStack is29 = new ItemStack(Material.YELLOW_FLOWER);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item29 = p.getWorld().dropItem(
								use, is29);
						Vector v29 = new Vector(x29, y29, z29);
						item29.setVelocity(v29);

						item29.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item29.remove();
							}
						}.runTaskLater(plugin, 120L);

					}

				}, 95);

				BukkitScheduler schedule30 = Bukkit.getScheduler();
				schedule10.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {

						double x30 = (Math.random() * (0.15 - (-0.15)));
						double y30 = (Math.random() * 1);
						double z30 = (Math.random() * (0.15 - (-0.15)));

						ItemStack is30 = new ItemStack(Material.RED_ROSE);
						use.setX(p.getLocation().getX());
						use.setY(p.getLocation().getY() + 2);
						use.setZ(p.getLocation().getZ());
						final Item item30 = p.getWorld().dropItem(
								use, is30);
						Vector v30 = new Vector(x30, y30, z30);
						item10.setVelocity(v30);

						item30.setPickupDelay(Integer.MAX_VALUE);
						new BukkitRunnable() {
							@Override
							public void run() {
								item30.remove();
							}
						}.runTaskLater(plugin,120L);

					}

				}, 5);

			}
		}

		return false;
	}

}
