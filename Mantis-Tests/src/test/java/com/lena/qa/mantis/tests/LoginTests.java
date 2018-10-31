package com.lena.qa.mantis.tests;

import com.lena.qa.mantis.appmanager.HTTPSession;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase {
  @Test
  public  void testLogin() throws IOException {
    HTTPSession session = app.newSession();

    assertTrue(session.login("administrator", "root"));
   assertTrue(session.isLoggedin("administrator"));
  }
}
