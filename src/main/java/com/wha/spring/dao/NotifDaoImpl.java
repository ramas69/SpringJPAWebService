package com.wha.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wha.spring.idao.NotifDao;
import com.wha.spring.model.Notification;


@Repository("notifDao")
@Transactional
public class NotifDaoImpl extends AbstractDao implements NotifDao {

	@Override
	public Notification saveNotification(Notification notification) {
		em.persist(notification);
		return notification;
		
	}

	@Override
	public void updateNotification(Notification notification) {
		em.merge(notification);
		
	}

	@Override
	public List<Notification> findAllNotifications() {
		return em.createQuery("From notification").getResultList();
	}

	@Override
	public Notification findById(int id) {
		return (Notification) em.find(Notification.class, id);
	}

	@Override
	public void deleteNotification(int id) {
		em.remove(findById(id));
		
	}

}
