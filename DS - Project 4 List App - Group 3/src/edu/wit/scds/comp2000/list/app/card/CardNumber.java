
package edu.wit.scds.comp2000.list.app.card ;

/**
 * Enumeration for card numbers in UNO. Used as a parameter to create a card object
 *
 * @author Fabio Tran
 * @version 1.0.0 2021-11-17 Initial implementation
 */
public enum CardNumber
    {

    // Element, Display Name
    /** number zero */
    ZERO ( "Zero" ),
    /** number one */
    ONE ( "One" ),
    /** number two */
    TWO ( "Two" ),
    /** number three */
    THREE ( "Three" ),
    /** number four */
    FOUR ( "Four" ),
    /** number five */
    FIVE ( "Five" ),
    /** number six */
    SIX ( "Six" ),
    /** number seven */
    SEVEN ( "Seven" ),
    /** number eight */
    EIGHT ( "Eight" ),
    /** number nine */
    NINE ( "Nine" ),
    /** no number for cards such as Wild Card */
    NONE ( "" );

    /** instance variable to hold formatted display name */
    public final String numberDisplayName ;

    /**
     * @param numberDisplayName
     *     formatted name for display
     */
    private CardNumber( final String numberDisplayName )
        {
        this.numberDisplayName = numberDisplayName ;

        } // end 1-arg constructor


    @Override
    public String toString()
        {
        return this.numberDisplayName ;

        }   // end toString()


    /**
     * Used for testing
     *
     * @param args
     *     unused
     */
    public static void main( String[] args )
        {
        // testing toString()
        System.out.println( "Testing toString():" ) ;
        System.out.println( String.format( "ZERO: %s", CardNumber.ZERO ) ) ;
        System.out.println( String.format( "ONE: %s", CardNumber.ONE ) ) ;
        System.out.println( String.format( "TWO: %s", CardNumber.TWO ) ) ;
        System.out.println( String.format( "THREE: %s", CardNumber.THREE ) ) ;
        System.out.println( String.format( "FOUR: %s", CardNumber.FOUR ) ) ;
        System.out.println( String.format( "FIVE: %s", CardNumber.FIVE ) ) ;
        System.out.println( String.format( "SIX: %s", CardNumber.SIX ) ) ;
        System.out.println( String.format( "SEVEN: %s", CardNumber.SEVEN ) ) ;
        System.out.println( String.format( "EIGHT: %s", CardNumber.EIGHT ) ) ;
        System.out.println( String.format( "NINE: %s", CardNumber.NINE ) ) ;
        System.out.println( String.format( "NONE: %s", CardNumber.NONE ) ) ;

        } // end main()

    }
// end class CardNumbers