
package edu.wit.scds.comp2000.list.app.card ;

/**
 * Class that represents an action card in UNO (Skip, Reverse, or Draw-Two)
 *
 * @author Fabio Tran
 * @version 1.0.0 2021-11-15 Initial implementation
 */
public final class ActionCard extends AbstractCard
    {

    /**
     * 2-arg constructor that takes in color and type of an action card
     *
     * @param color
     *     color of card
     * @param type
     *     type of action card
     */
    public ActionCard( CardColor color, CardType type )
        {
        super( color, type ) ;

        } // end ActionCard()

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
        if ( ! ( obj instanceof ActionCard ) )
            {
            return false ;
            } // end if

        // cast to compare type of action card
        final ActionCard otherCard = (ActionCard) obj ;
        return ( ( ( otherCard.getColor() == super.getColor() ) &&
                   ( otherCard.getType() == super.getType() ) ) ) ;

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
        // creating instances of ActionCard
        System.out.println( "Creating instances of ActionCard \n" ) ;
        ActionCard blueReverseCard = new ActionCard( CardColor.BLUE,
                                                     CardType.REVERSE ) ;
        ActionCard anotherBlueReverseCard = new ActionCard( CardColor.BLUE,
                                                            CardType.REVERSE ) ;
        ActionCard yellowDrawTwoCard = new ActionCard( CardColor.YELLOW,
                                                       CardType.DRAW_TWO ) ;

        // testing getColor()
        System.out.println( "Testing getColor():" ) ;
        System.out.println( blueReverseCard.getColor() ) ;
        System.out.println( yellowDrawTwoCard.getColor() ) ;
        System.out.println() ;

        // testing getType()
        System.out.println( "Testing getType():" ) ;
        System.out.println( blueReverseCard.getType() ) ;
        System.out.println( yellowDrawTwoCard.getType() ) ;
        System.out.println() ;

        // testing equals()
        System.out.println( "Testing equals():" ) ;
        System.out.println( blueReverseCard.equals( blueReverseCard ) ) ;
        System.out.println( blueReverseCard.equals( null ) ) ;
        System.out.println( blueReverseCard.equals( yellowDrawTwoCard ) ) ;
        System.out.println( blueReverseCard.equals( anotherBlueReverseCard ) ) ;
        System.out.println() ;

        // testing toString()
        System.out.println( "Testing toString():" ) ;
        System.out.println( blueReverseCard ) ;
        System.out.println( yellowDrawTwoCard ) ;

        } // end main()

    }
// end class ActionCard