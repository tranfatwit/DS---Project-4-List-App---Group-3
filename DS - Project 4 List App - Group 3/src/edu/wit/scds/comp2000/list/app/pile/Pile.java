
package edu.wit.scds.comp2000.list.app.pile ;

import edu.wit.scds.comp2000.list.app.card.Card ;
import edu.wit.scds.comp2000.list.app.card.CardColor ;
import edu.wit.scds.comp2000.list.app.card.CardType ;

import java.util.ArrayList ;
import java.util.Collections ;
import java.util.List ;

/**
 * Class to represent a pile of cards
 *
 * @author Fabio Tran
 * @version 1.0.0 2021-11-18 Initial implementation
 */
public class Pile
    {

    // array-list used to store pile of cards
    final protected List<Card> pile ;

    /**
     * no-arg constructor
     */
    protected Pile()
        {
        // capacity is chosen because a deck of UNO has at most 108 cards
        this.pile = new ArrayList<>( 108 ) ;

        } // end no-arg constructor


    /**
     * Adds a card to the pile
     *
     * @param card
     *     card to add
     */
    protected void addCard( Card card )
        {
        this.pile.add( card ) ;

        } // end addCard()


    /**
     * Removes a card from the pile
     *
     * @param card
     *     card to remove
     * @return
     */
    protected void removeCard( Card card )
        {
        this.pile.remove( card ) ;

        } // end removeCard()


    /**
     * Searches for a card in the pile
     *
     * @return card
     */
    protected int search(Card card)
        {
        // TODO finish implementing
        return 0;
        //for (Card card : this.pile) {
        //}
        //} 
      
        } // end search() 


    /**
     * Shuffles pile of cards
     */
    protected void shuffle()
        {
        Collections.shuffle( this.pile ) ;

        } // end shuffle()


    /**
     * Sorts pile of cards
     */
    protected void sort()
        {
        // TODO implement 
        }


    /**
     * Displays all cards in pile in string format
     *
     * @return string of all cards in pile
     */
    protected String displayCards()
        {
        String result = "" ;

        for ( Card card : this.pile )
            {
            result += card.toString() ;
            } // end for

        return result ;

        } // end displayCards()


    @Override
    public String toString()
        {
        return "" ;
        }


    /**
     * Used for testing
     *
     * @param args
     *     unused
     */
    public static void main( String[] args )
        {
        // creating instances of Card
        System.out.println( "Creating cards:" ) ;
        Card redOne = new Card( CardColor.RED, CardType.ONE ) ;
        System.out.println( "redOne" ) ;
        Card anotherRedOne = new Card( CardColor.RED, CardType.ONE ) ;
        System.out.println( "anotherRedOne" ) ;
        Card blueReverse = new Card( CardColor.BLUE, CardType.REVERSE ) ;
        System.out.println( "blueReverse" ) ;
        Card yellowReverse = new Card( CardColor.YELLOW, CardType.REVERSE ) ;
        System.out.println( "yellowReverse" ) ;
        Card wildCard = new Card( CardColor.WILD, CardType.WILD_DRAW_FOUR ) ;
        System.out.println( "wildCard" ) ;
        System.out.println() ;

        Pile pile = new Pile() ;
        pile.displayCards() ;

        } // end main()

    }
// end class Pile