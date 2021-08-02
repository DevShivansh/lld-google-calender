package com.app.services;

import com.app.enums.NotificationType;

public interface NotificationService {

	public void notify(NotificationType type, Object...args);
}
