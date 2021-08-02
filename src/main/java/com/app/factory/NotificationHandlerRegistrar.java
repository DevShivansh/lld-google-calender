package com.app.factory;

import com.app.enums.NotificationType;
import com.app.handler.NotificationHandler;

public interface NotificationHandlerRegistrar {

	void register(NotificationType type, NotificationHandler handler);
}
