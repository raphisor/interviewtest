package com.strenger.interviewtest.pojo.user;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUsersResponse {

  private List<User> users;
}