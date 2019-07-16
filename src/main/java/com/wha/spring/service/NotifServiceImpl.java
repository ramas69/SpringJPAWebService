package com.wha.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.NotifDao;
import com.wha.spring.iservice.NotifService;
import com.wha.spring.model.Notification;

@Service("notifService")
@Transactional
public class NotifServiceImpl implements NotifService {
	@Autowired
	NotifDao notifDao;

	@Override
	public Notification saveNotification(Notification notification) {
		notifDao.saveNotification(notification);
		return notification;
	}

	@Override
	public void updateNotification(Notification notification) {
		notifDao.updateNotification(notification);
		
	}

	@Override
	public List<Notification> findAllNotifications() {
		return notifDao.findAllNotifications();
	}

	@Override
	public Notification findById(int id) {
		// TODO Auto-generated method stub
		return notifDao.findById(id);
	}

	@Override
	public void deleteNotification(int id) {
		notifDao.deleteNotification(id);
		
	}
	
	
}
