package com.lena.qa.mantis.tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
  @Test
  public void testRegistration(){
    app.registration().start("user21", "user21@localhost.localdomain");
  }
}
