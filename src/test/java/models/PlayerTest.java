package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

  @Test
  public void testPlayerHasAHand() {
    assertNotNull(new Player().getHand());
  }
}