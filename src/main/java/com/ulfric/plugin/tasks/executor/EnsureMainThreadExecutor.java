package com.ulfric.plugin.tasks.executor;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

import org.bukkit.Server;

import com.ulfric.plugin.tasks.Scheduler;

public class EnsureMainThreadExecutor extends AbstractExecutorService {

	private final Scheduler scheduler;
	private final Server server;

	public EnsureMainThreadExecutor(Scheduler scheduler, Server server) {
		Objects.requireNonNull(scheduler, "scheduler");
		Objects.requireNonNull(server, "server");

		this.scheduler = scheduler;
		this.server = server;
	}

	@Override
	public void shutdown() {
	}

	@Override
	public List<Runnable> shutdownNow() {
		return Collections.emptyList();
	}

	@Override
	public boolean isShutdown() {
		return false;
	}

	@Override
	public boolean isTerminated() {
		return false;
	}

	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
		return true;
	}

	@Override
	public void execute(Runnable command) {
		if (server.isPrimaryThread()) {
			command.run();
			return;
		}

		scheduler.runOnMainThread(command);
	}

}
