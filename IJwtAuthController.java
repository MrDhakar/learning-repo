package com.jaid.jwt.api.IController;

import com.jaid.jwt.api.model.UserData;
import com.jaid.jwt.api.response.JwtAuthTokenResponse;

public interface IJwtAuthController {

	JwtAuthTokenResponse getJwtAuthToken(UserData userDataRequest);

}
