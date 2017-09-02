package com.ulfric.palpatine;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

final class TaskRunnable implements Task {

	private final Runnable runnable;
	private final boolean repeats;
	private BukkitTask task;
	private List<Runnable> onExit;

	public TaskRunnable(Runnable runnable, Scheduling repeats) {
		this.runnable = runnable;
		this.repeats = repeats == Scheduling.REPEATING;
	}

	void task(BukkitTask task) {
		if (this.task != null) {
			throw new IllegalStateException("Task already set");
		}

		this.task = task;
	}

	@Override
	public void run() {
		if (!isRunning()) {
			cancel();
		}

		runnable.run();
		onExit();
	}

	@Override
	public void cancel() {
		task.cancel();
		onExit();
	}

	private boolean isRunning() {
		return Bukkit.getScheduler().isCurrentlyRunning(task.getTaskId());
	}

	@Override
	public void onExit(Runnable runnable) {
		if (onExit == null) {
			onExit = new ArrayList<>();
		}
		onExit.add(runnable);
	}

	private void onExit() {
		if (onExit != null) {
			onExit.forEach(Runnable::run);
		}
	}

	@Override
	public boolean isRepeating() {
		return repeats;
	}

}