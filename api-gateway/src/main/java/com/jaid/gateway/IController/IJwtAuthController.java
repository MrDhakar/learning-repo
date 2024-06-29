package com.jaid.gateway.IController;

import com.jaid.gateway.model.UserData;
import com.jaid.gateway.response.JwtAuthTokenResponse;

public interface IJwtAuthController {

	JwtAuthTokenResponse getJwtAuthToken(UserData userDataRequest);

}
