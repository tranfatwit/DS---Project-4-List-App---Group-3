
package edu.wit.scds.comp2000.list.app.card ;

/**
 * Enumeration for card colors in UNO
 *
 * @author Fabio Tran
 * @version 1.0.0 2021-11-15 Initial implementation
 */
public enum CardColor
    {

    // Color, Display Name
    /** red card */
    RED ( "Red" ),
    /** yellow card */
    YELLOW ( "Yellow" ),
    /** yellow card */
    GREEN ( "Green" ),
    /** blue card */
    BLUE ( "Blue" );

    /** instance variable to format name for display */
    public final String colorDisplayName ;

    /**
     * @param colorDisplayName
     *     formatted name for display
     */
    private CardColor( final String colorDisplayName )
        {
        this.colorDisplayName = colorDisplayName ;

        } // end 1-arg constructor


    @Override
    public String toString()
        {
        return this.colorDisplayName ;

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
        System.out.println( CardColor.RED ) ;
        System.out.println( CardColor.YELLOW ) ;
        System.out.println( CardColor.GREEN ) ;
        System.out.println( CardColor.BLUE ) ;

        } // end main()

    }
// end enum CardColor