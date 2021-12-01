
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
    private final Stack<Card> discardPile = new Stack<>() ;

    /**
     * no-arg constructor
     */
    public Deck()
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
        return super.pile.remove( 0 ) ;

        } // end deal()


    /**
     * Discards a card to the discard pile
     */
    public void discardCard( Card card )
        {
        this.discardPile.push( card ) ;

        } // end discardCard()


    /**
     * Re-shuffles the deck once it runs out of cards
     */
    public void reshuffle()
        {
        // sets aside top card of discard pile
        Card lastPlayed = this.discardPile.pop() ;

        // sends rest of the cards back to the deck
        while ( !this.discardPile.isEmpty() )
            {
            super.pile.add( this.discardPile.pop() ) ;
            } // end while

        // shuffles deck
        super.shuffle() ;

        // returns last played to the discard pile
        this.discardPile.push( lastPlayed ) ;

        } // end reshuffle()


    /**
     * Returns last card that was played which is the card on top of discard pile
     * stack
     *
     * @return card that was last played
     */
    public Card lastPlayed()
        {
        return this.discardPile.peek() ;

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
        // creating deck
        System.out.println( "Creating Deck of Uno:" ) ;
        Deck unoDeck = new Deck() ;
        System.out.println( unoDeck.toString() ) ;
        System.out.println() ;

        // testing deal()
        System.out.println( "Testing deal():" ) ;
        System.out.println( "Dealing card" ) ;
        unoDeck.deal() ;
        System.out.println( "Dealing card" ) ;
        unoDeck.deal() ;
        System.out.println( unoDeck.toString() ) ;
        System.out.println() ;

        // testing discard()
        System.out.println( "Testing discard():" ) ;
        Card card1 = unoDeck.deal() ;
        System.out.println( "Discarding" ) ;
        unoDeck.discardCard( card1 ) ;
        Card card2 = unoDeck.deal() ;
        System.out.println( "Discarding" ) ;
        unoDeck.discardCard( card2 ) ;
        System.out.println( String.format( "Last played: %s",
                                           unoDeck.lastPlayed() ) ) ;
        System.out.println( String.format( "# of cards discarded: %s",
                                           unoDeck.discardPile.size() ) ) ;
        System.out.println() ;

        // testing lastPlayed()
        System.out.println( "Testing lastPlayed():" ) ;
        Card card3 = unoDeck.deal() ;
        System.out.println( String.format( "Discarding %s", card3.toString() ) ) ;
        unoDeck.discardCard( card3 ) ;
        System.out.println( String.format( "Last played: %s",
                                           unoDeck.lastPlayed() ) ) ;
        System.out.println() ;

        // testing reshuffle()
        System.out.println( "Testing reshuffle" ) ;
        System.out.println( "Emptying deck" ) ;
        while ( !unoDeck.pile.isEmpty() )
            {
            unoDeck.discardCard( unoDeck.deal() ) ;
            }
        System.out.println( unoDeck.toString() ) ;
        System.out.println( "Reshuffling" ) ;
        unoDeck.reshuffle() ;
        System.out.println( unoDeck.toString() ) ;

        } // end main()

    }
// end class Deck