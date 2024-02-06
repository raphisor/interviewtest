package com.strenger.interviewtest.pojo.testdata;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UITestData {

  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private String zipCode;
  private List<String> itemsToBuy;
}
