package models;

import models.standard.StandardDeck;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardGameTest {

  @Test
  public void testCreateGame() {
    assertNotNull(new CardGame(new StandardDeck()));
  }

  @Test
  public void testGameHasAssociatedDeck() {
    assertNotNull(new CardGame(new StandardDeck()).getDeck());
  }

}