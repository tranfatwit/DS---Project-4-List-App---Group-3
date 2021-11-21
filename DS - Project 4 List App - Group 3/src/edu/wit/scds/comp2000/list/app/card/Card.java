
package edu.wit.scds.comp2000.list.app.card ;

import java.util.ArrayList ;
import java.util.List ;
import java.util.Objects ;

/**
 * Class to create card objects for UNO Game.
 *
 * @author Fabio Tran
 * @version 1.0.0 2021-11-18 Initial implementation
 */
public class Card implements Comparable<Card>
    {

    /** holds card color, number, and type */
    public final CardColor color ;
    public final CardNumber number ;
    public final CardType type ;

    // used to store color chosen by player when a wild card is used
    public CardColor wildColor ;

    /**
     * 3-arg constructor that takes in color, number, and type of a card
     *
     * @param color
     *     color of card
     * @param number
     *     number of card
     * @param type
     *     type of card
     */
    public Card( CardColor color, CardNumber number, CardType type )
        {
        this.color = color ;
        this.number = number ;
        this.type = type ;

        } // end 3-arg constructor


    /**
     * Used to set the color of a card when a wild card is played
     *
     * @param color
     *     color chosen by player
     */
    public void setColorForWild( CardColor color )
        {
        this.wildColor = color ;

        } // end setColorForWild()


    /**
     * Compares this instance of card to otherCard. It will return true if otherCard
     * is of type Wild or Wild Draw-Four, if both cards are the same color, if both
     * cards are the same number, or if both cards are the same action.
     *
     * @param otherCard
     *     card to match
     * @return true if matches
     */
    public boolean matchCard( Card otherCard )
        {
        // checks if otherCard is Wild or Wild Draw-Four
        if ( otherCard.color == CardColor.ANY )
            {
            return true ;
            } // end if
        // checks if otherCard and this card are the same color
        if ( ( otherCard.color == this.color ) ||
             ( otherCard.color == this.wildColor ) )
            {
            return true ;
            } // end if
        // checks if otherCard and this card are the same number
        if ( ( otherCard.type == CardType.NUMBER ) &&
             ( this.type == CardType.NUMBER ) )
            {
            if ( this.number == otherCard.number )
                {
                return true ;
                } // end if
            } // end if
        // by process of elimination this checks if otherCard and this card are the
        // same type of action card (reverse, draw-two, skip)
        if ( this.type == otherCard.type )
            {
            return true ;
            } // end if

        // false otherwise
        return false ;

        } // end match()


    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo( Card otherCard )
        {
        final int cardOrder = this.color.compareTo( otherCard.color ) ;

        if ( cardOrder == 0 )
            {
            return this.number.compareTo( otherCard.number ) ;
            } // end if

        return cardOrder ;

        } // end compareTo()


    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#equals(java.lang.Object)
     */
    @Override
    public boolean equals( Object obj )
        {
        // testing if same object
        if ( this == obj )
            {
            return true ;
            } // end if

        // testing if same reference type
        if ( obj instanceof Card )
            {
            // cast to compare
            final Card otherCard = (Card) obj ;

            return ( this.color == otherCard.color ) &&
                   ( this.number == otherCard.number ) &&
                   ( this.type == otherCard.type ) ;
            } // end if

        // false otherwise
        return false ;

        } // end equals()


    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
        {
        return Objects.hash( this.color, this.number, this.type ) ;

        } // end hashCode()


    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
        {
        // formatted string if card is a wild card
        if ( this.color == CardColor.ANY )
            {
            return String.format( "%s", this.type ) ;
            }
        // formatted string if card is an action card
        if ( this.number == CardNumber.NONE )
            {
            return String.format( "%s %s", this.color, this.type ) ;
            }
        // formatted string if card is a number card
        return String.format( "%s %s", this.color, this.number ) ;

        } // end toString()


    /**
     * Used for testing
     *
     * @param args
     *     unused
     */
    public static void main( String[] args )
        {
        // creating instances of Card
        System.out.println( "Creating instances of Card:" ) ;
        Card redOne = new Card( CardColor.RED, CardNumber.ONE, CardType.NUMBER ) ;
        System.out.println( "redOne" ) ;
        Card anotherRedOne = new Card( CardColor.RED,
                                       CardNumber.ONE,
                                       CardType.NUMBER ) ;
        System.out.println( "anotherRedOne" ) ;
        Card redTwo = new Card( CardColor.RED, CardNumber.TWO, CardType.NUMBER ) ;
        System.out.println( "redTWO" ) ;
        Card blueDrawTwo = new Card( CardColor.BLUE,
                                     CardNumber.NONE,
                                     CardType.DRAW_TWO ) ;
        System.out.println( "blueDrawTwo" ) ;
        Card greenReverse = new Card( CardColor.GREEN,
                                      CardNumber.NONE,
                                      CardType.REVERSE ) ;
        System.out.println( "greenReverse" ) ;
        Card yellowSkip = new Card( CardColor.YELLOW,
                                    CardNumber.NONE,
                                    CardType.SKIP ) ;
        System.out.println( "yellowSkip" ) ;
        Card greenSkip = new Card( CardColor.GREEN,
                                   CardNumber.NONE,
                                   CardType.SKIP ) ;
        System.out.println( "greenSkip" ) ;
        Card wild = new Card( CardColor.ANY, CardNumber.NONE, CardType.WILD ) ;
        System.out.println( "wild" ) ;
        Card wildDrawFour = new Card( CardColor.ANY,
                                      CardNumber.NONE,
                                      CardType.WILD_DRAW_FOUR ) ;
        System.out.println( "wildDrawFour" ) ;
        System.out.println() ;

        // testing setColorForWild()
        System.out.println( "Testing setColorForWild():" ) ;
        wildDrawFour.setColorForWild( CardColor.BLUE ) ;
        System.out.println( String.format( "wildDrawFour set to blue: %s",
                                           wildDrawFour.wildColor ) ) ;
        wild.setColorForWild( CardColor.YELLOW ) ;
        System.out.println( String.format( "wild set to yellow: %s",
                                           wild.wildColor ) ) ;
        System.out.println() ;

        // testing match()
        System.out.println( "Testing match():" ) ;
        System.out.println( String.format( "redOne matches with redOne: %s",
                                           redOne.matchCard( redOne ) ) ) ;
        System.out.println( String.format( "redOne matches with redTwo: %s",
                                           redOne.matchCard( redTwo ) ) ) ;
        System.out.println( String.format( "yellowSkip matches with redOne: %s",
                                           yellowSkip.matchCard( redOne ) ) ) ;
        System.out.println( String.format( "yellowSkip matches with greenSkip: %s",
                                           yellowSkip.matchCard( greenSkip ) ) ) ;
        System.out.println( String.format( "wild matches with wildDrawFour: %s",
                                           wild.matchCard( wildDrawFour ) ) ) ;
        System.out.println( String.format( "wildDrawFour set to blue matches with blueDrawTwo: %s",
                                           wildDrawFour.matchCard( blueDrawTwo ) ) ) ;
        System.out.println() ;

        // testing compareTo()
        System.out.println( "Testing compareTo()" ) ;
        System.out.println( String.format( "redOne compared to redOne: %s",
                                           redOne.compareTo( redOne ) ) ) ;
        System.out.println( String.format( "redOne compared to redTwo: %s",
                                           redOne.compareTo( redTwo ) ) ) ;
        System.out.println( String.format( "yellowSkip compared to redOne: %s",
                                           yellowSkip.compareTo( redOne ) ) ) ;
        System.out.println( String.format( "yellowSkip compared to greenReverse: %s",
                                           yellowSkip.compareTo( greenReverse ) ) ) ;
        System.out.println( String.format( "wild compared to wildDrawFour: %s",
                                           wild.compareTo( wildDrawFour ) ) ) ;
        System.out.println( String.format( "wildDrawFour compared to blueDrawTwo: %s",
                                           wildDrawFour.compareTo( blueDrawTwo ) ) ) ;
        System.out.println() ;

        // testing equals()
        System.out.println( "Testing equals():" ) ;
        System.out.println( String.format( "redOne equals redOne: %s",
                                           redOne.equals( redOne ) ) ) ;
        System.out.println( String.format( "redOne equals anotherRedOne: %s",
                                           redOne.equals( anotherRedOne ) ) ) ;
        System.out.println( String.format( "yellowSkip equals redOne: %s",
                                           yellowSkip.equals( redOne ) ) ) ;
        System.out.println( String.format( "yellowSkip equals greenReverse: %s",
                                           yellowSkip.equals( greenReverse ) ) ) ;
        System.out.println( String.format( "wild equals wildDrawFour: %s",
                                           wild.equals( wildDrawFour ) ) ) ;
        System.out.println( String.format( "wildDrawFour equals blueDrawTwo: %s",
                                           wildDrawFour.equals( blueDrawTwo ) ) ) ;
        System.out.println() ;

        // testing hashCode()
        System.out.println( "Testing hashCode():" ) ;
        System.out.println( String.format( "redOne: %s", redOne.hashCode() ) ) ;
        System.out.println( String.format( "yellowSkip: %s",
                                           yellowSkip.hashCode() ) ) ;
        System.out.println( String.format( "greenReverse: %s",
                                           greenReverse.hashCode() ) ) ;
        System.out.println( String.format( "blueDrawTwo: %s",
                                           blueDrawTwo.hashCode() ) ) ;
        System.out.println( String.format( "wild: %s", wild.hashCode() ) ) ;
        System.out.println( String.format( "wildDrawFour: %s",
                                           wildDrawFour.hashCode() ) ) ;

        System.out.println() ;

        // testing toString()
        System.out.println( "Testing toString():" ) ;
        System.out.println( String.format( "redOne: %s", redOne ) ) ;
        System.out.println( String.format( "yellowSkip: %s", yellowSkip ) ) ;
        System.out.println( String.format( "greenReverse: %s", greenReverse ) ) ;
        System.out.println( String.format( "blueDrawTwo: %s", blueDrawTwo ) ) ;
        System.out.println( String.format( "wild: %s", wild ) ) ;
        System.out.println( String.format( "wildDrawFour: %s", wildDrawFour ) ) ;
        System.out.println() ;

        // testing deck creation
        System.out.println( "Creating and Printing UNO Deck:" ) ;
        List<Card> deck = new ArrayList<>( 108 ) ;

        final CardColor[] colors = CardColor.values() ;
        final CardNumber[] numbers = CardNumber.values() ;
        final CardType[] types = CardType.values() ;

        // creating numbered cards
        for ( CardColor color : colors )
            {
            if ( color.equals( CardColor.ANY ) )
                {
                continue ;
                } // end if

            for ( CardNumber number : numbers )
                {
                if ( number.equals( CardNumber.NONE ) )
                    {
                    continue ;
                    } // end if

                if ( number.equals( CardNumber.ZERO ) )
                    {
                    Card newCard = new Card( color, number, CardType.NUMBER ) ;
                    System.out.println( newCard ) ;

                    deck.add( newCard ) ;

                    continue ;
                    } // end if

                for ( int i = 0 ; i < 2 ; i++ )
                    {

                    Card newCard = new Card( color, number, CardType.NUMBER ) ;
                    System.out.println( newCard ) ;

                    deck.add( newCard ) ;
                    } // end for

                } // end for

            } // end for

        // creating action cards
        for ( CardColor color : colors )
            {
            if ( color.equals( CardColor.ANY ) )
                {
                continue ;
                } // end if

            for ( CardNumber number : numbers )
                {
                if ( !number.equals( CardNumber.NONE ) )
                    {
                    continue ;
                    } // end if

                for ( CardType type : types )
                    {
                    if ( type.equals( CardType.NUMBER ) ||
                         type.equals( CardType.WILD ) ||
                         type.equals( CardType.WILD_DRAW_FOUR ) )
                        {
                        continue ;
                        } // end if

                    for ( int i = 0 ; i < 2 ; i++ )
                        {
                        Card newCard = new Card( color, CardNumber.NONE, type ) ;
                        System.out.println( newCard ) ;

                        deck.add( newCard ) ;
                        } // end for

                    } // end for

                } // end for

            }

        // creating wild cards
        for ( CardColor color : colors )
            {
            if ( !color.equals( CardColor.ANY ) )
                {
                continue ;
                } // end if
            for ( CardType type : types )
                {
                if ( type.equals( CardType.NUMBER ) ||
                     type.equals( CardType.SKIP ) ||
                     type.equals( CardType.REVERSE ) ||
                     type.equals( CardType.DRAW_TWO ) )
                    {
                    continue ;
                    } // end if

                for ( int i = 0 ; i < 4 ; i++ )
                    {
                    Card newCard = new Card( color, CardNumber.NONE, type ) ;
                    System.out.println( newCard ) ;

                    deck.add( newCard ) ;
                    } // end for

                } // end for

            } // end for

        } // end main()

    }
// end class Card