package com.ulfric.palpatine;

public interface Task extends Runnable {

	void cancel();

	boolean isComplete();

	boolean isQueued();

	boolean isRunning();

}