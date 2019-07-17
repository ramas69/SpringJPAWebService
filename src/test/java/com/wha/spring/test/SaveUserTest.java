package com.wha.spring.test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;








import com.wha.spring.config.JPAConfig;
import com.wha.spring.config.WebConfig;
import com.wha.spring.idao.ConseillerDao;
import com.wha.spring.iservice.UserService;
import com.wha.spring.model.Conseiller;
import com.wha.spring.model.User;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebConfig.class, JPAConfig.class })
public class SaveUserTest {
 ConseillerDao conseillerDao; 
	@Autowired
	UserService us;

	@Test
	@Transactional
	@Rollback(true)
	public void test() {
		assertThat(us, instanceOf(UserService.class));

  		Conseiller cs=new Conseiller(0, "omar", "kabil", "omar@h.fr", "bron", "0231456598", "omar01", "omar02");
  		conseillerDao.saveConseiller(cs);
  		List<Conseiller> conseillers=conseillerDao.findAllConseillers();
		
		//assertEquals("omar", conseillers.get(0).getNom());

		//assertThat(us.findById(1), instanceOf(User.class));
	}


}
