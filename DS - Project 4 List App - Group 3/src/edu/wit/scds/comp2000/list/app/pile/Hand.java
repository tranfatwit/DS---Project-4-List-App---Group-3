
package edu.wit.scds.comp2000.list.app.pile ;

import edu.wit.scds.comp2000.list.app.card.Card ;
import edu.wit.scds.comp2000.list.app.card.CardColor ;
import edu.wit.scds.comp2000.list.app.card.CardType ;

/**
 * @author Tim Magee
 * @version 1.0.0 2021-11-30 Initial implementation
 */
public class Hand extends Pile
    {

    // private final Pile hand ;

    /**
     * no-arg constructor a players hand at the start of the game will always be
     * zero, since cards have not been dealt
     */
    public Hand()
        {
        super() ;
        }


    /**
     * Receives a card and stores it in pile
     *
     * @param card
     *     card to add to pile
     */
    public void receiveCard( Card card )
        {
        super.addCard( card ) ;
        } // end receiveCard()


    /**
     * Discards a card from the pile
     *
     * @param card
     *     card to discard from pile
     */
    public void discardCard( Card card )
        {
        super.removeCard( card ) ;
        } // end discardCard()


    /**
     * returns the hand as a string in format "[x, y, z]
     */
    @Override
    public String toString()
        {
        String ret = "[" ;
        for ( int i = 0 ; i < ( this.pile.size() - 1 ) ; i++ )
            {
            ret += this.pile.get( i ) + ", " ;
            }
        return ret + this.pile.get( this.pile.size() - 1 ) + "]" ;

        }


    /**
     * used for testing
     *
     * @param args
     */
    public static void main( String[] args )
        {
        // tests to see if initial hand size is zero
        System.out.println( "Creating hand..." ) ;
        Hand testHand = new Hand() ;
        System.out.println( "Number of cards in hand: " + testHand.pile.size() +
                            "\n" ) ;

        // creates cards that will be added to hand
        System.out.println( "Creating cards..." ) ;
        Card redOne = new Card( CardColor.RED, CardType.ONE ) ;
        Card anotherRedOne = new Card( CardColor.RED, CardType.ONE ) ;
        Card blueReverse = new Card( CardColor.BLUE, CardType.REVERSE ) ;
        Card yellowReverse = new Card( CardColor.YELLOW, CardType.REVERSE ) ;
        Card wildCard = new Card( CardColor.WILD, CardType.WILD ) ;
        System.out.println() ;

        // testing for every time a card is added to testHand
        System.out.println( "Adding cards to testHand..." ) ;
        System.out.print( "---Adding a Red-1 to testHand...\n---" ) ;
        testHand.addCard( redOne ) ;
        System.out.println( testHand.toString() ) ;
        System.out.print( "---Adding a Blue-Reverse to testHand...\n---" ) ;
        testHand.addCard( blueReverse ) ;
        System.out.println( testHand.toString() ) ;
        System.out.print( "---Adding a Yellow-Reverse to testHand...\n---" ) ;
        testHand.addCard( yellowReverse ) ;
        System.out.println( testHand.toString() ) ;
        System.out.print( "---Adding a Red-1 to testHand...\n---" ) ;
        testHand.addCard( anotherRedOne ) ;
        System.out.println( testHand.toString() ) ;
        System.out.print( "---Adding a Wild Card to testHand...\n---" ) ;
        testHand.addCard( wildCard ) ;
        System.out.println( testHand.toString() ) ;
        System.out.println() ;

        System.out.println( "Testing Complete." ) ;

        }

    }
// end class Hand