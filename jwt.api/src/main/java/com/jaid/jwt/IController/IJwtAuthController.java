package com.jaid.jwt.IController;

import com.jaid.jwt.model.UserData;
import com.jaid.jwt.response.JwtAuthTokenResponse;

public interface IJwtAuthController {

	JwtAuthTokenResponse getJwtAuthToken(UserData userDataRequest);

}
