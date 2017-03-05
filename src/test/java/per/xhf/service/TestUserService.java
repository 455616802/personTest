package per.xhf.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-test.xml"})
public class TestUserService {

	@Autowired
	private UserService userService;
	
	@Test
	public void testHasMatchUser(){
		boolean rs = userService.getMatchCount("123xdp", "123");
		System.out.println(rs);
	}
}
