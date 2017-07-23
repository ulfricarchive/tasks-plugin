package com.ulfric.palpatine;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

final class TaskRunnable implements Task { // TODO thread safety

	private final Runnable runnable;
	private BukkitTask task;
	private boolean ran;

	public TaskRunnable(Runnable runnable) {
		this.runnable = runnable;
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
		this.ran = true;
	}

	@Override
	public void cancel() {
		task.cancel();
	}

	@Override
	public boolean isComplete() {
		return this.ran;
	}

	@Override
	public boolean isQueued() {
		return Bukkit.getScheduler().isQueued(task.getTaskId());
	}

	@Override
	public boolean isRunning() {
		return Bukkit.getScheduler().isCurrentlyRunning(task.getTaskId());
	}

}