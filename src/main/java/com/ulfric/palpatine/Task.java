package com.ulfric.palpatine;

public interface Task extends Runnable {

	void cancel();

	void onExit(Runnable runnable);

}