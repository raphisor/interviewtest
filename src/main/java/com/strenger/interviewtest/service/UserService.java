package com.strenger.interviewtest.service;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private OkHttpClient okHttpClient;
  private static String BASE_URL = "https://jsonplaceholder.typicode.com";

  public Response getUsers() throws IOException {
    String url = BASE_URL + "/users";
    Request request = new Request.Builder().url(url).build();

    LOGGER.info("Sending request to {}", url);
    Response response = okHttpClient.newCall(request).execute();

    if (response.isSuccessful()) {
      LOGGER.info("Received successful response from {}", url);
    } else {
      LOGGER.error("Received unsuccessful response from {}. Status code: {}", url, response.code());
    }

    return response;
  }

}