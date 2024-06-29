package com.jaid.gateway.IController;

import com.jaid.gateway.request.MyAppRequest;
import com.jaid.gateway.response.MyAppResponse;

public interface IMyAppController {
   MyAppResponse mytask(MyAppRequest myAppRequest);
}