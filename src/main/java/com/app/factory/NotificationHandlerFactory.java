package com.app.factory;

import java.util.HashMap;
import java.util.Map;

import com.app.enums.NotificationType;
import com.app.handler.NotificationHandler;

public class NotificationHandlerFactory implements NotificationHandlerRegistrar{

	public static NotificationHandlerFactory INSTANCE = new NotificationHandlerFactory();
	
	private Map<NotificationType, NotificationHandler> handlers;
	
	private NotificationHandlerFactory() {
		handlers = new HashMap<NotificationType, NotificationHandler>();
	}

	@Override
	public void register(NotificationType type, NotificationHandler handler) {
		handlers.put(type, handler);
	}

	public NotificationHandler get(NotificationType type) {
		
		if(!handlers.containsKey(type))
			throw new RuntimeException("Handler not registered with factory for NotificationType");
		return handlers.get(type);
		
	}
	
	
	
}
