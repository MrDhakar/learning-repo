package com.jaid.jwt.api.IController;

import com.jaid.jwt.api.request.MyAppRequest;
import com.jaid.jwt.api.response.MyAppResponse;

public interface IMyAppController {
   MyAppResponse mytask(MyAppRequest myAppRequest);
}