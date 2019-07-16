package com.wha.spring.iservice;

import java.util.List;

import com.wha.spring.model.Notification;


public interface NotifService {
	
	Notification saveNotification(Notification notification);

	Notification findById(int id);

	void updateNotification(Notification notification);

	public List<Notification> findAllNotifications();

	public void deleteNotification(int id);

}
