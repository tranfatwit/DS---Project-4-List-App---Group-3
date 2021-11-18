
package edu.wit.scds.comp2000.list.app.card ;

/**
 * Class that represents a wild card in UNO (Wild or Wild Draw-Four)
 *
 * @author Fabio Tran
 * @version 1.0.0 2021-11-15 Initial implementation
 */
public final class WildCard extends AbstractCard
    {

    /**
     * 2-arg constructor that takes in color and type of a wild card
     *
     * @param color
     *     color of card
     * @param type
     *     type of wild card
     */
    public WildCard( CardColor color, CardType type )
        {
        super( color, type ) ;

        } // end WildCard()

    // TODO create a method to compare cards
    
    @Override
    public boolean equals( Object obj )
        {
        // testing same instance
        if ( obj == this )
            {
            return true ;
            } // end if

        // testing for null
        if ( obj == null )
            {
            return false ;
            } // end if

        // testing instance
        if ( ! ( obj instanceof WildCard ) )
            {
            return false ;
            } // end if

        // cast to compare type of wild card
        final WildCard card = (WildCard) obj ;
        return card.getType() == super.getType() ;

        } // end equals()


    @Override
    public String toString()
        {
        return String.format( "%s", getType() ) ;

        } // end toString()


    /**
     * Used for testing
     *
     * @param args
     *     unused
     */
    public static void main( String[] args )
        {
        // creating instances of WildCard
        System.out.println( "Creating instances of WildCard \n" ) ;
        WildCard wildCard = new WildCard( null, CardType.WILD ) ;
        WildCard anotherWildCard = new WildCard( null, CardType.WILD ) ;
        WildCard wildDrawFourCard = new WildCard( null, CardType.WILD_DRAW_FOUR ) ;

        // testing getColor()
        System.out.println( "Testing getColor():" ) ;
        System.out.println( wildCard.getColor() ) ;
        System.out.println( anotherWildCard.getColor() ) ;
        System.out.println( wildDrawFourCard.getColor() ) ;
        System.out.println() ;

        // testing getType()
        System.out.println( "Testing getType():" ) ;
        System.out.println( wildCard.getType() ) ;
        System.out.println( anotherWildCard.getType() ) ;
        System.out.println( wildDrawFourCard.getType() ) ;
        System.out.println() ;

        // testing equals()
        System.out.println( "Testing equals():" ) ;
        System.out.println( wildCard.equals( wildCard ) ) ;
        System.out.println( wildCard.equals( null ) ) ;
        System.out.println( wildCard.equals( wildDrawFourCard ) ) ;
        System.out.println( wildCard.equals( anotherWildCard ) ) ;
        System.out.println() ;

        // testing toString()
        System.out.println( "Testing toString():" ) ;
        System.out.println( wildCard ) ;
        System.out.println( anotherWildCard ) ;
        System.out.println( wildDrawFourCard ) ;

        } // end main()
    }
// end class WildCard