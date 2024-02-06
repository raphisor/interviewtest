package com.strenger.interviewtest.service;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private OkHttpClient okHttpClient;
  private static String BASE_URL = "https://jsonplaceholder.typicode.com";

  public Response getUsers() throws IOException {
    Request request = new Request.Builder().url(BASE_URL + "/users").build();
    return okHttpClient.newCall(request).execute();
  }

}
