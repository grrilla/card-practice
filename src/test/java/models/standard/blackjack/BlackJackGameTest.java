package models.standard.blackjack;

import org.junit.Test;

import static org.junit.Assert.*;

public class BlackJackGameTest {

  @Test
  public void testBlackJackGameHasDealer() {
    assertNotNull(new BlackJackGame().getDealer());
  }

  @Test
  public void testBlackJackGameHasAtLeastOnePlayer() {
    assertTrue(new BlackJackGame().getPlayers().size() > 0);
  }

  @Test
  public void testBlackJackGameHasDeck() {
    assertNotNull(new BlackJackGame().getDeck());
  }

  @Test
  public void testBlackJackDealerStartsWithExactlyTwoCards() {
    assertTrue(new BlackJackGame().getDealer().getHand().size() == 2);
  }

  @Test
  public void testBlackJackPlayersStartWithExactlyTwoCards() {
    BlackJackGame game = new BlackJackGame();
    for (Player p : game.getPlayers()) {
      assertTrue(p.getHand().size() == 2);
    }
  }
}