package com.jaid.jwt.IController;

import com.jaid.jwt.request.MyAppRequest;
import com.jaid.jwt.response.MyAppResponse;

public interface IMyAppController {
   MyAppResponse mytask(MyAppRequest myAppRequest);
}