package com.ulfric.plugin.tasks;

public interface Task extends Runnable {

	void cancel();

	void onExit(Runnable runnable);

	boolean isRepeating();

}