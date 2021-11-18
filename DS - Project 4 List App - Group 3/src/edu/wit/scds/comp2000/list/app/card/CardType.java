
package edu.wit.scds.comp2000.list.app.card ;

/**
 * Enumeration for card types in UNO
 *
 * @author Fabio Tran
 * @version 1.0.0 2021-11-15 Initial implementation
 */
public enum CardType
    {

    // Card Type, Display Name
    /** number card */
    NUMBER ( "Number Card" ),
    /** skip card */
    SKIP ( "Skip Card" ),
    /** reverse card */
    REVERSE ( "Reverse Card" ),
    /** draw-two card */
    DRAW_TWO ( "Draw-Two Card" ),
    /** wild card */
    WILD ( "Wild Card" ),
    /** draw-four wild card */
    WILD_DRAW_FOUR ( "Wild Draw-Four Card" );

    /** instance variable to format name for display */
    public final String typeDisplayName ;

    /**
     * @param typeDisplayName
     *     formatted name for display
     */
    private CardType( final String typeDisplayName )
        {
        this.typeDisplayName = typeDisplayName ;

        } // end 1-arg constructor


    @Override
    public String toString()
        {
        return this.typeDisplayName ;

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
        System.out.println( CardType.NUMBER ) ;
        System.out.println( CardType.SKIP ) ;
        System.out.println( CardType.REVERSE ) ;
        System.out.println( CardType.DRAW_TWO ) ;
        System.out.println( CardType.WILD ) ;
        System.out.println( CardType.WILD_DRAW_FOUR ) ;

        } // end main()
    }
// end enum CardType