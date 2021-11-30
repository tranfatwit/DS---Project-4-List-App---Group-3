
package edu.wit.scds.comp2000.list.app.pile ;

import edu.wit.scds.comp2000.list.app.card.Card ;
import edu.wit.scds.comp2000.list.app.card.CardColor ;
import edu.wit.scds.comp2000.list.app.card.CardType ;

import java.util.ArrayList ;
import java.util.List ;
import java.util.Stack ;

/**
 * Class to create a Deck of UNO cards
 *
 * @author Fabio Tran
 * @version 1.0.0 2021-11-18 Initial implementation
 */
public class Deck extends Pile
    {

    /**
     * Used to store cards played by players, top card of the stack will be used to
     * determine what cards can be played next
     */
    Stack<Card> discardPile = new Stack<>() ;

    /**
     * no-arg constructor
     */
    private Deck()
        {
        for ( CardColor color : CardColor.values() )
            {
            if ( color == CardColor.WILD )
                {
                for ( CardType type : CardType.values() )
                    {
                    if ( ( type == CardType.WILD ) ||
                         ( type == CardType.WILD_DRAW_FOUR ) )
                        {
                        for ( int i = 0 ; i < 4 ; i++ )
                            {
                            Card card = new Card( color, type ) ;
                            super.pile.add( card ) ;
                            } // end for

                        } // end if

                    } // end for

                continue ;

                } // end if

            for ( CardType type : CardType.values() )
                {
                if ( type == CardType.ZERO )
                    {
                    Card card = new Card( color, type ) ;
                    super.pile.add( card ) ;
                    continue ;
                    } // end if

                if ( ( type == CardType.WILD ) ||
                     ( type == CardType.WILD_DRAW_FOUR ) )
                    {
                    continue ;
                    } // end if

                for ( int i = 0 ; i < 2 ; i++ )
                    {
                    Card card = new Card( color, type ) ;
                    super.pile.add( card ) ;
                    } // end for

                } // end for

            } // end for

        } // end deck()


    /**
     * Deals the player one card from the deck
     *
     * @return card to be dealt
     */
    public Card deal()
        {
        // TODO test
        return super.pile.remove( 0 ) ;

        } // end deal()


    /**
     * Adds a card to the discard pile
     */
    public void discard( Card card )
        {
        this.discardPile.push( card ) ;

        } // end discard()


    /**
     * Re-shuffles the deck once it runs out of cards
     */
    public void reshuffle()
        {
        // TODO test
        Card lastPlayed = lastPlayed() ;

        for ( Card card : this.discardPile )
            {
            super.pile.add( this.discardPile.pop() ) ;
            } // end for

        this.discardPile.push( lastPlayed ) ;

        } // end re=shuffle()


    /**
     * Returns last card that was played which is the card on top of discard pile
     * stack
     *
     * @return
     */
    public Card lastPlayed()
        {
        if ( !this.discardPile.empty() )
            {
            return this.discardPile.pop() ;
            } // end if

        return null ;

        } // end lastPlayed()


    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
        {
        // stores string display name of cards in a list to be separated with commas
        // using String.join
        List<String> results = new ArrayList<>( 108 ) ;

        for ( Card card : this.pile )
            {
            results.add( card.toString() ) ;
            } // end for

        return "Cards in Deck: " + String.join( ", ", results ) ;

        } // end toString()


    /**
     * Used for testing
     *
     * @param args
     *     unused
     */
    public static void main( String[] args )
        {
        // TODO test
        // creating deck
        System.out.println( "Creating Deck of Uno:" ) ;
        Deck unoDeck = new Deck() ;
        System.out.println( unoDeck.toString() ) ;
        System.out.println() ;

        // testing deal()

        // testing discard()

        // testing reshuffle()

        // testing lastPlayed()

        } // end main()

    }
// end class Deck