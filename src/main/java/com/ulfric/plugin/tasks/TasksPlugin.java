package com.ulfric.plugin.tasks;

import com.ulfric.plugin.Plugin;

public class TasksPlugin extends Plugin {

	public TasksPlugin() { // TODO remove bindings on shutdown
		Plugin.FACTORY.bind(Scheduler.class).toFunction(parameters ->
			new Scheduler(Plugin.getProvidingPlugin(parameters.getHolder())));
	}

}
