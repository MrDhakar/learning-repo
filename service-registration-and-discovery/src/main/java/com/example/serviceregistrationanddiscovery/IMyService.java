package com.example.serviceregistrationanddiscovery;

import java.util.List;

public interface IMyService {
  List<User> userList();
  List<UserLead> getUserLead();
}
