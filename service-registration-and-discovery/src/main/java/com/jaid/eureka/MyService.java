package com.example.serviceregistrationanddiscovery;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MyService implements IMyService {

	@Override
	public List<User> userList() {

		List<User> users = new ArrayList<User>();
		User user = new User(1, "manish");
		users.add(user);

		user = new User(2, "akash");
		users.add(user);

		user = new User(3, "suresh");
		users.add(user);

		user = new User(4, "ramesh");
		users.add(user);
		user = new User(5, "ravi");
		users.add(user);
		
		return users;
	}

	@Override
	public List<UserLead> getUserLead() {

		List<UserLead> userLeadList = new ArrayList<UserLead>();
		UserLead userLead = new UserLead(1, "new car", "a@a.com", 0, null);
		userLeadList.add(userLead);

		userLead = new UserLead(2, "new mobile", "a@a.com", 0, null);
		userLeadList.add(userLead);

		userLead = new UserLead(3, "new things 3", "b@b.com", 0, null);
		userLeadList.add(userLead);

		userLead = new UserLead(4, "new thing 4", "c@c.com", 0, null);
		userLeadList.add(userLead);

		userLead = new UserLead(5, "new thing 5", "a@a.com", 0, null);
		userLeadList.add(userLead);

		userLead = new UserLead(6, "new thing 6", "d@d.com", 0, null);
		userLeadList.add(userLead);
		userLead = new UserLead(7, "new thing 7", "e@e.com", 0, null);
		userLeadList.add(userLead);
		
		userLead = new UserLead(8, "new thing 8", "s@s.com", 0, null);
		userLeadList.add(userLead);
		
		return userLeadList;
	}

}
