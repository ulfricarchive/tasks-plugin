package com.ulfric.plugin.tasks.executor;

import java.util.function.Supplier;

import org.bukkit.Server;

import com.ulfric.dragoon.extension.inject.Inject;
import com.ulfric.plugin.tasks.Scheduler;

public class EnsureMainThreadExecutorSupplier implements Supplier<EnsureMainThreadExecutor> {

	@Inject
	private Scheduler scheduler;

	@Inject
	private Server server;

	@Override
	public EnsureMainThreadExecutor get() {
		return new EnsureMainThreadExecutor(scheduler, server);
	}

}
