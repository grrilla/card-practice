package models.standard.war;

import models.Deck;
import models.standard.StandardDeck;
import models.standard.StandardPlayingCard;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

import static models.standard.StandardPlayingCard.StandardRank.ACE;
import static models.standard.StandardPlayingCard.StandardRank.EIGHT;
import static models.standard.StandardPlayingCard.StandardRank.NINE;
import static models.standard.StandardPlayingCard.StandardRank.SEVEN;
import static models.standard.StandardPlayingCard.StandardRank.TEN;
import static models.standard.StandardPlayingCard.StandardSuit.CLUBS;
import static models.standard.StandardPlayingCard.StandardSuit.DIAMONDS;
import static models.standard.StandardPlayingCard.StandardSuit.HEARTS;
import static models.standard.StandardPlayingCard.StandardSuit.SPADES;
import static models.standard.StandardPlayingCardTest.assertAllRanksOfGivenSuitArePresent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class WarGameTest {
  @Test
  public void testWarGameHasDealer() {
    assertNotNull(new WarGame().getDealer());
  }

  @Test
  public void testWarGameHasAtLeastOnePlayers() {
    assertTrue(new WarGame().getPlayers().size() > 0);
  }

  @Test
  public void testWarGameHasStandardDeck() {
    Deck deck = new WarGame().getDeck();
    assertNotNull(deck);
    assertTrue(deck instanceof StandardDeck);
  }

  @Test
  public void testWarPlayersAndDealerEachStartWithHandThatIsDeckSizeDividedAsEquallyAsPossible() {
    WarGame game = new WarGame();
    List<WarPlayer> players = game.getPlayers();
    assertEquals(2, players.size());
    for (WarPlayer p : players) {
      assertEquals(26, p.getHand().size());
    }
    assertEquals(26, game.getDealer().getHand().size());
    assertDeckStateMaintained(game);

    game = new WarGame(3);
    players = game.getPlayers();
    assertEquals(3, players.size());
    assertEquals(18, players.get(0).getHand().size());
    assertEquals(17, players.get(1).getHand().size());
    assertEquals(17, players.get(2).getHand().size());
    assertEquals(17, game.getDealer().getHand().size());
    assertDeckStateMaintained(game);
  }

  @Test
  public void testWarPlayerCanPlayOneCardOnTurn() {
    WarGame game = new WarGame();
    List<WarPlayer> players = game.getPlayers();
    assertEquals(2, players.size());
    WarPlayer onlyPlayer = players.get(0);

    assertEquals(26, onlyPlayer.getHand().size());
    onlyPlayer.play();
    assertEquals(25, onlyPlayer.getHand().size());

    assertDeckStateMaintained(game);
  }

  @Test
  public void testARoundOfPlayedCardsIsTheValueOfOneCardFromTheTopOfEachPlayersHand() {
    WarGame game = new WarGame();
    List<WarPlayer> players = game.getPlayers();
    WarPlayer dealer = game.getDealer();
    for (WarPlayer p : players) {
      StandardPlayingCard playerPeeked = p.getHand().getCards().peek();
      p.play();
      assertEquals(playerPeeked, p.getPlayedCards().peek());
    }
    assertDeckStateMaintained(game);
  }

  @Test
  public void testARoundOfPlayedCardsCanBeEvaluatedByReturningPlayerWithHighestValueCard() {
    WarGame game = new WarGame();
    List<WarPlayer> players = game.getPlayers();
    WarPlayer warPlayer = players.get(0);
    WarPlayer dealer = game.getDealer();

    assertNotEquals(warPlayer, dealer);
    assertEquals(players.get(1), dealer);

    WarHand warPlayerHand = warPlayer.getHand();
    warPlayerHand.getCards().clear();
    warPlayerHand.addCard(new StandardPlayingCard(TEN, HEARTS));
    warPlayer.play();

    WarHand dealerHand = dealer.getHand();
    dealerHand.getCards().clear();
    dealerHand.addCard(new StandardPlayingCard(ACE, SPADES));
    dealer.play();

    assertEquals(dealer, game.getRoundWinner());
  }

  @Test
  public void testWinnerOfRoundGetsAllCardsFromRound() {
    WarGame game = new WarGame();
    List<WarPlayer> players = game.getPlayers();
    WarPlayer warPlayer = players.get(0);
    WarPlayer dealer = game.getDealer();

    assertNotEquals(warPlayer, dealer);
    assertEquals(players.get(1), dealer);

    WarHand warPlayerHand = warPlayer.getHand();
    warPlayerHand.getCards().clear();
    warPlayerHand.addCard(new StandardPlayingCard(TEN, HEARTS));

    WarHand dealerHand = dealer.getHand();
    dealerHand.getCards().clear();
    dealerHand.addCard(new StandardPlayingCard(ACE, SPADES));

    game.playRound();
    assertEquals(2, dealer.getCardsWon().size());
    assertEquals(0, warPlayer.getCardsWon().size());
  }

  @Test
  public void testPlayersHaveNoPlayedCardsAfterRoundResolves() {
    WarGame game = new WarGame();
    List<WarPlayer> players = game.getPlayers();
    WarPlayer warPlayer = players.get(0);
    WarPlayer dealer = game.getDealer();

    assertNotEquals(warPlayer, dealer);
    assertEquals(players.get(1), dealer);

    WarHand warPlayerHand = warPlayer.getHand();
    warPlayerHand.getCards().clear();
    warPlayerHand.addCard(new StandardPlayingCard(TEN, HEARTS));

    WarHand dealerHand = dealer.getHand();
    dealerHand.getCards().clear();
    dealerHand.addCard(new StandardPlayingCard(ACE, SPADES));

    game.playRound();
    assertEquals(0, dealer.getPlayedCards().size());
    assertEquals(0, warPlayer.getPlayedCards().size());
  }

  @Test
  public void testRoundsCanBePlayedAndResolvedWithoutBreakingDeckContinuity() {
    WarGame game = new WarGame();
    for (int i = 0; i < 5; i++) {
      game.playRound();
    }
    assertDeckStateMaintained(game);
  }

  private static void assertDeckStateMaintained(WarGame game) {
    Stack<StandardPlayingCard> cardsOnTable = new Stack<>();

    for (WarPlayer p : game.getPlayers()) {
      cardsOnTable.addAll(p.getPlayedCards());
      cardsOnTable.addAll(p.getCardsWon());
      cardsOnTable.addAll(p.getHand().getCards());
    }

    assertEquals(52, cardsOnTable.size());
    assertAllRanksOfGivenSuitArePresent(cardsOnTable, SPADES);
    assertAllRanksOfGivenSuitArePresent(cardsOnTable, HEARTS);
    assertAllRanksOfGivenSuitArePresent(cardsOnTable, CLUBS);
    assertAllRanksOfGivenSuitArePresent(cardsOnTable, DIAMONDS);
  }

  @Test
  public void testWinnerOfRoundWithTieResolvedByWars() {
    WarGame game = new WarGame();
    List<WarPlayer> players = game.getPlayers();
    WarPlayer warPlayer = players.get(0);
    WarPlayer dealer = game.getDealer();

    assertNotEquals(warPlayer, dealer);
    assertEquals(players.get(1), dealer);

    WarHand warPlayerHand = warPlayer.getHand();
    warPlayerHand.getCards().clear();
    warPlayerHand.addCard(new StandardPlayingCard(EIGHT, SPADES));
    warPlayerHand.addCard(new StandardPlayingCard(ACE, HEARTS));
    warPlayerHand.addCard(new StandardPlayingCard(ACE, DIAMONDS));
    warPlayerHand.addCard(new StandardPlayingCard(TEN, CLUBS));
    warPlayerHand.addCard(new StandardPlayingCard(TEN, HEARTS));
    warPlayerHand.addCard(new StandardPlayingCard(EIGHT, HEARTS));
    warPlayerHand.addCard(new StandardPlayingCard(EIGHT, CLUBS));
    warPlayerHand.addCard(new StandardPlayingCard(EIGHT, DIAMONDS));
    warPlayerHand.addCard(new StandardPlayingCard(ACE, SPADES));

    WarHand dealerHand = dealer.getHand();
    dealerHand.getCards().clear();
    dealerHand.addCard(new StandardPlayingCard(SEVEN, CLUBS));
    dealerHand.addCard(new StandardPlayingCard(TEN, DIAMONDS));
    dealerHand.addCard(new StandardPlayingCard(NINE, SPADES));
    dealerHand.addCard(new StandardPlayingCard(NINE, DIAMONDS));
    dealerHand.addCard(new StandardPlayingCard(TEN, SPADES));
    dealerHand.addCard(new StandardPlayingCard(NINE, CLUBS));
    dealerHand.addCard(new StandardPlayingCard(NINE, HEARTS));
    dealerHand.addCard(new StandardPlayingCard(SEVEN, DIAMONDS));
    dealerHand.addCard(new StandardPlayingCard(ACE, CLUBS));

    game.playRound();
    assertEquals(0, dealer.getCardsWon().size());
    assertEquals(18, warPlayer.getCardsWon().size());
  }

  // TODO: refill empty hands from cards won between rounds

  // TODO: eliminating players between rounds


}