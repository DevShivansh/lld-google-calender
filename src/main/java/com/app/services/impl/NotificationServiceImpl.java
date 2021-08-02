package com.app.services.impl;

import org.springframework.scheduling.annotation.Async;

import com.app.enums.NotificationType;
import com.app.factory.NotificationHandlerFactory;
import com.app.services.NotificationService;

public class NotificationServiceImpl implements NotificationService{

	@Override
	@Async
	public void notify(NotificationType type, Object... args) {
	
		NotificationHandlerFactory.INSTANCE.get(type).handle(args);
	}

}
