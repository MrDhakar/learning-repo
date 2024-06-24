package com.jupiter.dev;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.serviceregistrationanddiscovery.IJobSchedularController;
import com.example.serviceregistrationanddiscovery.MyAppRequest;
	
@Controller
public class JobSchedularController implements IJobSchedularController {
	
	@Autowired
	IJobSchedularService jobSchedularService;
	
	

	private String generateJobId() {
		// TODO Auto-generated method stub
		long timestamp = System.currentTimeMillis();

		String randomStr = generateRandomString(6);

		// Combine them to form the unique ID
		String uniqueId = timestamp + "-" + randomStr;
		return uniqueId;
	}

	private String generateRandomString(int length) {
		// TODO Auto-generated method stub
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder(length);
		for(int i=0;i<length;i++) {
			sb.append(chars.charAt(random.nextInt(chars.length())));
		}
		return sb.toString();
	}

	@Override
	public List<String> getJobsIds(MyAppRequest myAppRequest) {
			String jobId=generateJobId();
			
			long nextExecutionTime = LocalDateTime.now()
					.plus(Duration.parse(myAppRequest.getExecutionInterval()))
					.atZone(ZoneOffset.systemDefault())
					.toInstant()
					.getEpochSecond()/60;
			
			
			TaskSchedule taskSchedule = new TaskSchedule();
			
			jobSchedularService.save(taskSchedule);
			List<String> jobIdList = new ArrayList<String>();
			jobIdList.add(jobId);
			return jobIdList;
	}

}
