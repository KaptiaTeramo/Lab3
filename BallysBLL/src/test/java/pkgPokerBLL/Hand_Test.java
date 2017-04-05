package pkgPokerBLL;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import PkgException.HandException;
import pkgPokerEnum.eHandStrength;
import pkgPokerEnum.eRank;
import pkgPokerEnum.eSuit;


public class Hand_Test {

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		

	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	

	
	@Test
	public void Test5OfAKind() throws HandException {
		Hand h = new Hand();
		
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.JOKER, eRank.JOKER,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.FiveOfAKind);
		assertTrue(h.getHandScore().getHiHand() == eRank.TEN);
		
	}
	
	
	@Test
	public void TestRoyalFlush() throws HandException {
		Hand h = new Hand();
 
		
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.RoyalFlush);
		assertTrue(h.getHandScore().getHiHand() == eRank.ACE);
		
	}
	
	@Test
	public void TestStraightFlush() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.QUEEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.NINE,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void TestFourOfAKind() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.FourOfAKind);
		assertTrue(h.getHandScore().getHiHand() == eRank.TEN);
	}
	
	@Test
	public void TestFourOfAKind2() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.FourOfAKind);
		assertTrue(h.getHandScore().getHiHand() == eRank.ACE);
	}
	
	@Test
	public void TestFullHouse1() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TWO,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.FullHouse);
		assertTrue(h.getHandScore().getHiHand() == eRank.TEN);
		assertTrue(h.getHandScore().getLoHand() == eRank.TWO);
	}
	
	@Test
	public void TestFullHouse2() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TEN,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.FullHouse);
		assertTrue(h.getHandScore().getHiHand() == eRank.TWO);
		assertTrue(h.getHandScore().getLoHand() == eRank.TEN);
	}
	
	@Test
	public void TestFlush() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.KING,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.Flush);
		assertTrue(h.getHandScore().getHiHand() == eRank.ACE);
	}
	
	@Test
	public void TestStraight1() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.SIX,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.Straight);
		assertTrue(h.getHandScore().getHiHand() == eRank.SIX);
		assertTrue(h.getHandScore().getLoHand() == null);
	}
	
	@Test
	public void TestStraight2() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.Straight);
		assertTrue(h.getHandScore().getHiHand() == eRank.FIVE);
		assertTrue(h.getHandScore().getLoHand() == null);
	}
	
	@Test
	public void TestStraight3() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.SIX,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.FIVE,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertFalse(h.getHandScore().getHandStrength() == eHandStrength.Straight);
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.HighCard);
		assertTrue(h.getHandScore().getHiHand() == eRank.ACE);
		assertTrue(h.getHandScore().getLoHand() == null);
	}
	
	@Test
	public void ThreeOfAKind1() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.ThreeOfAKind);
		assertTrue(h.getHandScore().getHiHand() == eRank.TWO);
	}

	@Test
	public void ThreeOfAKind2() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.THREE,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.ThreeOfAKind);
		assertTrue(h.getHandScore().getHiHand() == eRank.THREE);
	}	
	
	@Test
	public void ThreeOfAKind3() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TWO,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.ThreeOfAKind);
		assertTrue(h.getHandScore().getHiHand() == eRank.FOUR);
	}	
	
	@Test
	public void TwoPair1() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.TwoPair);
		assertTrue(h.getHandScore().getHiHand() == eRank.TEN);
		assertTrue(h.getHandScore().getLoHand() == eRank.THREE);
	}
	
	@Test
	public void TwoPair2() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.SIX,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.TwoPair);
		assertTrue(h.getHandScore().getHiHand() == eRank.TEN);
		assertTrue(h.getHandScore().getLoHand() == eRank.THREE);
	}
	
	@Test
	public void TwoPair3() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.TEN,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.TWO,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.TwoPair);
		assertTrue(h.getHandScore().getHiHand() == eRank.TEN);
		assertTrue(h.getHandScore().getLoHand() == eRank.THREE);
	}
	
	@Test
	public void Pair1() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.Pair);
		assertTrue(h.getHandScore().getHiHand() == eRank.KING);
		assertTrue(h.getHandScore().getLoHand() == null);
	}
		
	@Test
	public void Pair2() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.KING,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.Pair);
		assertTrue(h.getHandScore().getHiHand() == eRank.KING);
		assertTrue(h.getHandScore().getLoHand() == null);
	}
	
	@Test
	public void Pair3() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.ACE,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.Pair);
		assertTrue(h.getHandScore().getHiHand() == eRank.JACK);
		assertTrue(h.getHandScore().getLoHand() == null);
	}
	
	@Test
	public void Pair4() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.Pair);
		assertTrue(h.getHandScore().getHiHand() == eRank.TWO);
		assertTrue(h.getHandScore().getLoHand() == null);
	}
	
	@Test
	public void HighCard() throws HandException {
		Hand h = new Hand();
		h.AddToCardsInHand(new Card(eSuit.CLUBS, eRank.TWO,1));
		h.AddToCardsInHand(new Card(eSuit.SPADES, eRank.THREE,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.FOUR,1));
		h.AddToCardsInHand(new Card(eSuit.DIAMONDS, eRank.JACK,1));
		h.AddToCardsInHand(new Card(eSuit.HEARTS, eRank.KING,1));
		
		try {
			h = h.EvaluateHand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		assertTrue(h.getHandScore().getHandStrength() == eHandStrength.HighCard);
		assertTrue(h.getHandScore().getHiHand() == eRank.KING);
	}
}