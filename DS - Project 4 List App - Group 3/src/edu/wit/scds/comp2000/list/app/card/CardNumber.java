
package edu.wit.scds.comp2000.list.app.card ;

/**
 * Enumeration for card numbers in UNO
 *
 * @author Fabio Tran
 * @version 1.0.0 2021-11-17 Initial implementation
 */
public enum CardNumber
    {

    // Card Number, Display Name
    /** number zero */
    ZERO ( "#0" ),
    /** number one */
    ONE ( "#1" ),
    /** number two */
    TWO ( "#2" ),
    /** number three */
    THREE ( "#3" ),
    /** number four */
    FOUR ( "#4" ),
    /** number five */
    FIVE ( "#5" ),
    /** number six */
    SIX ( "#6" ),
    /** number seven */
    SEVEN ( "#7" ),
    /** number eight */
    EIGHT ( "#8" ),
    /** number nine */
    NINE ( "#9" );

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

        }   // end method toString()


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
        System.out.println( CardNumber.ZERO ) ;
        System.out.println( CardNumber.ONE ) ;
        System.out.println( CardNumber.TWO ) ;
        System.out.println( CardNumber.THREE ) ;
        System.out.println( CardNumber.FOUR ) ;
        System.out.println( CardNumber.FIVE ) ;
        System.out.println( CardNumber.SIX ) ;
        System.out.println( CardNumber.SEVEN ) ;
        System.out.println( CardNumber.EIGHT ) ;
        System.out.println( CardNumber.NINE ) ;

        } // end main()

    }
// end class CardNumbers