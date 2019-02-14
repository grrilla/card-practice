package models;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MajorArcanaCardTest {
  
  @Test
  public void testCreateMajorArcanaCard() {
    assertNotNull(new MajorArcanaCard());
  }

  @Test
  public void testMajorArcanaCardHasSuitAndRank() {
    MajorArcanaCard majorArcana = new MajorArcanaCard();
    assertEquals(ACE, majorArcana.getRank());
    assertEquals(SWORDS, majorArcana.getSuit());
  }

  @Test
  public void testMajorArcanaCardHasSpecifiedSuitAndRank() {
    MajorArcanaCard majorArcana = new MajorArcanaCard(ACE, SWORDS);
    assertEquals(ACE, majorArcana.getRank());
    assertEquals(SWORDS, majorArcana.getSuit());

    majorArcana = new MajorArcanaCard(TWO, PENTACLES);
    assertEquals(TWO, majorArcana.getRank());
    assertEquals(PENTACLES, majorArcana.getSuit());
  }

  @Test
  public void testEveryMajorArcanaCardCanBeRepresented() {
    Stack<PlayingCard> stackOfMajorArcanaCards = new Stack<>();

    for (MajorArcanaSuit s : MajorArcanaSuit.values()) {
      for (MajorArcanaRank r : MajorArcanaRank.values()) {
        stackOfMajorArcanaCards.push(new MajorArcanaCard(r, s));
      }
    }

    assertEquals(56, stackOfMajorArcanaCards.size());

    assertMajorArcanaIsPresent(stackOfMajorArcanaCards);
  }

  private void assertMajorArcanaIsPresent(Stack<PlayingCard> stackOfTarotPlayingCards) {
    assertAllRanksOfGivenSuitArePresent(stackOfTarotPlayingCards, SWORDS);
    assertAllRanksOfGivenSuitArePresent(stackOfTarotPlayingCards, PENTACLES);
    assertAllRanksOfGivenSuitArePresent(stackOfTarotPlayingCards, WANDS);
    assertAllRanksOfGivenSuitArePresent(stackOfTarotPlayingCards, CUPS);
  }

  static void assertAllMajorArcanaCardsArePresent(Stack<PlayingCard> stackOfTarotPlayingCards, Suit suit) {

    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(FOOL)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(MAGICIAN)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(HIGH_PRIESTESS)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(EMPRESS)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(EMPEROR)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(HIEROPHANT)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(LOVERS)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(CHARIOT)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(STRENGTH)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(HERMIT)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(WHEEL_OF_FORTUNE)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(JUSTICE)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(THE_HANGED_MAN)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(DEATH)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(TEMPERANCE)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(DEVIL)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(THE_TOWER)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(THE_STAR)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(THE_MOON)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(THE_SUN)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(JUDGEMENT)) > -1);
    assertTrue(stackOfTarotPlayingCards.search(new MajorArcanaCard(THE_WORLD)) > -1);
  }

  @Test
  public void testMajorArcanaCardPropertiesDetermineEquality() {
    assertEquals(new MajorArcanaCard(), new MajorArcanaCard());
    assertEquals(new MajorArcanaCard(TWO, SWORDS), new MajorArcanaCard(TWO, SWORDS));
    assertNotEquals(new MajorArcanaCard(TWO, CUPS), new MajorArcanaCard(TWO, SWORDS));
  }

  @Test
  public void testMajorArcanaCardIsHumanReadable() {
    assertEquals("ACE of SWORDS", new MajorArcanaCard().toString());
  }
}