package com.incra.ratpack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.After;
import org.junit.Test;
import ratpack.http.client.ReceivedResponse;
import ratpack.test.CloseableApplicationUnderTest;
import ratpack.test.MainClassApplicationUnderTest;
import ratpack.test.http.TestHttpClient;

public class RatpackTest {

  private final CloseableApplicationUnderTest aut = new MainClassApplicationUnderTest(
      Ratpack01.class);
  private final TestHttpClient httpClient = aut.getHttpClient();

  @After
  public void tearDown() throws Exception {
    aut.close();
  }

  @Test
  public void redirectsToIndexHtml() {
    final ReceivedResponse response = httpClient.get();
    assertEquals(200, response.getStatusCode());
    assertThat(response.getBody().getText(), containsString("root handler!"));
  }
}
