package com.wha.spring.controller;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//import com.wha.spring.idao.NotifDao;
import com.wha.spring.iservice.NotifService;
//import com.wha.spring.model.Compte;
import com.wha.spring.model.Notification;
//import com.wha.spring.model.User;

@RestController
@RequestMapping("notifs")
public class NotificationControlleur {
	
	@Autowired
	NotifService notifService;
	

	@RequestMapping(value = "/create/dummy", method = RequestMethod.GET)
	public Notification dummy() {
<<<<<<< HEAD
	Notification notif1 = new Notification(0, Calendar.getInstance(), " message envoye t'es pauvre",null);
		notifService.saveNotification(notif1);	
		return notif1;
=======
		 LocalDate date = LocalDate.now();
	Notification notif1 = new Notification(0, date, " message envoye t'es pauvre",null);
		notifService.saveNotification(notif1);
		return notif1;

		
>>>>>>> springTrans
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public ResponseEntity<List<Notification>> getAll() {
		List<Notification> resultat =  notifService.findAllNotifications(); 
		return new ResponseEntity<List<Notification>>(resultat, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")
	public Notification  createNotification (@RequestBody Notification  notification) {
		Notification newNotification  = notifService.saveNotification (notification);
		return newNotification ;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update")
	public Notification updateNotification(@RequestBody Notification  notification) {
		notifService.updateNotification(notification);
		return notification ;
	
	}

}
