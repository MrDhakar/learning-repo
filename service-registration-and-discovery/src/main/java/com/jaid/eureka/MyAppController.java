package com.example.serviceregistrationanddiscovery;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyAppController implements IMyAppController {

	@Autowired
	IMyService myservice;
	
	
	@Override
	public MyAppResponse api() {
		
		MyAppResponse response = new MyAppResponse();
		
		/*
		 * while(true) {
		 * 
		 * }
		 */
		List<UserLead> leadList= myservice.getUserLead();
		List<User> users = myservice.userList();

		List<UserLead> newLeadList = leadList.stream().filter(x->x.getUserAssignId()==0).collect(Collectors.toList());
		
		HashMap<String,Integer> hashmap= new HashMap<String,Integer>();
		
		int maxUsers= users.size();
		int counter=0;
		for(UserLead userLead: newLeadList) {
			if(hashmap.containsKey(userLead.getEmail())) {
				userLead.setRepeatFlag("R");
				userLead.setUserAssignId(hashmap.get(userLead.getEmail()));
			}
			else {
				
				int userIndex = counter%maxUsers;
				int userId =users.get(userIndex).getId();
				
				userLead.setUserAssignId(userId);
				hashmap.put(userLead.getEmail(), userId);
				counter++;
			}
		}
		
		newLeadList.stream().forEach(t -> System.out.println("Id: "+t.getId()+" EmailId: "+t.getEmail()+
				" desc "+t.getDesc()+" assignid "+t.getUserAssignId()+" flag "+t.getRepeatFlag()) );
		response.setUserLeads(newLeadList);
		return response;
	}

}
