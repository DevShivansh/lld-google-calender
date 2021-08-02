package com.app.handler;

@FunctionalInterface
public interface NotificationHandler {

	public void handle(Object...args);
}
