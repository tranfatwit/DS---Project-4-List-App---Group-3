
package edu.wit.scds.comp2000.list.app.card ;

/**
 * Class that represents a number card in UNO
 *
 * @author Fabio Tran
 * @version 1.0.0 2021-11-15 Initial implementation
 */
public final class NumberCard extends AbstractCard
    {

    private final CardNumber number ; // holds number of an UNO number card

    /**
     * 2-arg constructor that takes in color and number of an UNO number card
     *
     * @param color
     *     color of card
     * @param number
     *     number of card
     */
    public NumberCard( CardColor color, CardNumber number )
        {
        super( color, CardType.NUMBER ) ;
        this.number = number ;

        } // end 2-arg constructor


    /**
     * Retrieves number of card
     *
     * @return number of card
     */
    public CardNumber getNumber()
        {
        return this.number ;

        } // end getNumber()

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
        if ( ! ( obj instanceof NumberCard ) )
            {
            return false ;
            } // end if

        // cast to compare color and value of card
        final NumberCard otherCard = (NumberCard) obj ;
        return ( ( ( otherCard.getColor() == super.getColor() ) &&
                   ( otherCard.getNumber() == getNumber() ) ) ) ;

        } // end equals()


    @Override
    public String toString()
        {
        return String.format( "%s %s Card", getColor(), getNumber() ) ;

        } // end toString()


    /**
     * Used for testing
     *
     * @param args
     *     unused
     */
    public static void main( String[] args )
        {
        // creating instances of NumberCard
        System.out.println( "Creating instances of NumberCard \n" ) ;
        NumberCard oneBlue = new NumberCard( CardColor.BLUE, CardNumber.ONE ) ;
        NumberCard anotherOneBlue = new NumberCard( CardColor.BLUE,
                                                    CardNumber.ONE ) ;
        NumberCard twoYellow = new NumberCard( CardColor.YELLOW, CardNumber.TWO ) ;

        // testing getColor()
        System.out.println( "Testing getColor():" ) ;
        System.out.println( oneBlue.getColor() ) ;
        System.out.println( twoYellow.getColor() ) ;
        System.out.println() ;

        // testing getType()
        System.out.println( "Testing getType():" ) ;
        System.out.println( oneBlue.getType() ) ;
        System.out.println( twoYellow.getType() ) ;
        System.out.println() ;

        // testing equals()
        System.out.println( "Testing equals():" ) ;
        System.out.println( oneBlue.equals( oneBlue ) ) ;
        System.out.println( oneBlue.equals( null ) ) ;
        System.out.println( oneBlue.equals( twoYellow ) ) ;
        System.out.println( oneBlue.equals( anotherOneBlue ) ) ;
        System.out.println() ;

        // testing toString()
        System.out.println( "Testing toString():" ) ;
        System.out.println( oneBlue ) ;
        System.out.println( twoYellow ) ;
        System.out.println() ;

        } // end main()

    }
// end class NumberCard