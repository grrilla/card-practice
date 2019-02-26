package models.tarot;

import org.junit.Test;

import java.util.Stack;

import static models.tarot.MajorArcana.*;
import static models.tarot.MajorArcanaNumeral.*;
import static org.junit.Assert.*;

public class MajorArcanaCardTest {

    @Test
    public void testMajorArcanaCardHasCorrectSuitAndRank() {
        MajorArcanaCard card = new MajorArcanaCard(MAGICIAN);
        assertEquals(I, card.getRank());
        assertEquals(MAGICIAN, card.getSuit());

        card = new MajorArcanaCard(WORLD);
        assertEquals(XXI, card.getRank());
        assertEquals(WORLD, card.getSuit());

        card = new MajorArcanaCard(FOOL);
        assertNotEquals(X, card.getRank());
    }

    @Test
    public void testMajorArcanaDeterminesRank() {
        assertEquals(O, new MajorArcanaCard(FOOL).getRank());
        assertEquals(I, new MajorArcanaCard(MAGICIAN).getRank());
        assertEquals(II, new MajorArcanaCard(HIGH_PRIESTESS).getRank());
        assertEquals(III, new MajorArcanaCard(EMPRESS).getRank());
        assertEquals(IV, new MajorArcanaCard(EMPEROR).getRank());
        assertEquals(V, new MajorArcanaCard(HIEROPHANT).getRank());
        assertEquals(VI, new MajorArcanaCard(LOVERS).getRank());
        assertEquals(VII, new MajorArcanaCard(CHARIOT).getRank());
        assertEquals(VIII, new MajorArcanaCard(STRENGTH).getRank());
        assertEquals(IX, new MajorArcanaCard(HERMIT).getRank());
        assertEquals(X, new MajorArcanaCard(WHEEL_OF_FORTUNE).getRank());
        assertEquals(XI, new MajorArcanaCard(JUSTICE).getRank());
        assertEquals(XII, new MajorArcanaCard(HANGED_MAN).getRank());
        assertEquals(XIII, new MajorArcanaCard(DEATH).getRank());
        assertEquals(XIV, new MajorArcanaCard(TEMPERANCE).getRank());
        assertEquals(XV, new MajorArcanaCard(DEVIL).getRank());
        assertEquals(XVI, new MajorArcanaCard(TOWER).getRank());
        assertEquals(XVII, new MajorArcanaCard(STAR).getRank());
        assertEquals(XVIII, new MajorArcanaCard(MOON).getRank());
        assertEquals(XIX, new MajorArcanaCard(SUN).getRank());
        assertEquals(XX, new MajorArcanaCard(JUDGEMENT).getRank());
        assertEquals(XXI, new MajorArcanaCard(WORLD).getRank());
    }

    @Test
    public void testEveryMajorArcanaCardCanBeRepresented() {
        Stack<TarotCard> cardStack = new Stack<>();

        for (MajorArcana a : MajorArcana.values()) {
            cardStack.push(new MajorArcanaCard(a));
        }

        assertEquals(22, cardStack.size());
        assertAllMajorArcanaCardsArePresent(cardStack);
    }

    static void assertAllMajorArcanaCardsArePresent(Stack<TarotCard> cardStack) {
        assertTrue(cardStack.search(new MajorArcanaCard(FOOL)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(MAGICIAN)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(HIGH_PRIESTESS)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(EMPRESS)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(EMPEROR)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(HIEROPHANT)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(LOVERS)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(CHARIOT)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(STRENGTH)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(HERMIT)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(WHEEL_OF_FORTUNE)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(JUSTICE)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(HANGED_MAN)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(DEATH)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(TEMPERANCE)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(DEVIL)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(TOWER)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(STAR)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(MOON)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(SUN)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(JUDGEMENT)) > -1);
        assertTrue(cardStack.search(new MajorArcanaCard(WORLD)) > -1);
    }

    @Test
    public void testMajorArcanaCardPropertiesDetermineEquality() {
        assertEquals(new MajorArcanaCard(MAGICIAN), new MajorArcanaCard(MAGICIAN));
        assertNotEquals(new MajorArcanaCard(MAGICIAN), new MajorArcanaCard(JUSTICE));
    }

    @Test
    public void testMajorArcanaCardIsHumanReadable() {
        assertEquals("XXI: The World", new MajorArcanaCard(WORLD).toString());
    }
}