package com.ulfric.palpatine;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import com.ulfric.palpatine.time.Tick;

import java.time.temporal.TemporalAmount;
import java.util.Objects;

public class Scheduler {

	protected final Plugin plugin;

	public Scheduler(Plugin plugin) {
		Objects.requireNonNull(plugin, "plugin");

		this.plugin = plugin;
	}

	public Task runOnMainThread(Runnable runnable) {
		TaskRunnable run = new TaskRunnable(runnable);
		BukkitTask task = scheduler().runTask(plugin, run);
		run.task(task);
		return run;
	}

	public Task runOnMainThreadLater(Runnable runnable, TemporalAmount when) {
		TaskRunnable run = new TaskRunnable(runnable);
		BukkitTask task = scheduler().runTaskLater(plugin, run, Tick.getAsTicks(when));
		run.task(task);
		return run;
	}

	protected BukkitScheduler scheduler() {
		Server server = plugin.getServer();
		if (server == null) {
			return Bukkit.getScheduler();
		}
		return server.getScheduler();
	}

}