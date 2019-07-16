package com.wha.spring.idao;

import java.util.List;

import com.wha.spring.model.Notification;


public interface NotifDao {
	
	Notification saveNotification(Notification notification);

	void updateNotification(Notification notification);

	public List<Notification> findAllNotifications();

	Notification findById(int id);

	void deleteNotification(int id);


}
