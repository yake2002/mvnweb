package test.bbs.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbs.domain.User;
import com.bbs.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestUserService {

	@Autowired
	private UserService userService;
	
	private static Logger logger = Logger.getLogger(Test.class); 

	@Test
	public void testLog() {
		logger.debug("debug info");
	}
	
	@Test
	public void hasMAtchUser() {

		User user1 = new User();

		User user2 = new User();

		user1.setUserName("admin");

		user1.setPassword("123456");

		user2.setUserName("admin");

		user2.setPassword("11111");

		boolean b1 = userService.hasMatchUser(user1);

		// boolean b2 = userService.hasMatchUser(user2);

		assertTrue(b1);

		// assertTrue(b2);

	}

	@Test
	public void findUserByUserName() {

		User user = new User();

		user.setUserName("admin");

		User user1 = userService.findUserByUserName(user);

		System.out.println(user1.getUserName());

		assertEquals(user1.getUserName(), "admin");

	}

	@Test
	public void loginSucess() {

		User user = new User();

		user.setUserName("admin");

		user = userService.findUserByUserName(user);

		userService.loginSucess(user);

	}

	@Test
	public void insertUser() {

		User user = new User();

		user.setUserName("user1");

		user.setPassword("123456");

		user.setCredits(0);

		user.setLastIp("255.255.255.255");

		user.setLastVisit(new Date(0));

		userService.insertUser(user);

	}

	@Test
	public void updateUserInfo() {

		User user = new User();

		user.setUserId(2);

		user.setLastVisit(new Date());

		user.setCredits(5 + user.getCredits());

		userService.UpdateUser(user);

	}

}
