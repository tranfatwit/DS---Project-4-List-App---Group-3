
package edu.wit.scds.comp2000.list.app.card ;

/**
 * Class that represents an abstract base card in UNO
 *
 * @author Fabio Tran
 * @version 1.0.0 2021-11-17 Initial implementation
 */
public abstract class AbstractCard
    {

    /** holds card type and color */
    private final CardColor color ;
    private final CardType type ;

    /**
     * 2-arg constructor that takes in color and type of a card
     *
     * @param color
     *     color of card
     * @param type
     *     type of card
     */
    protected AbstractCard( CardColor color, CardType type )
        {
        this.color = color ;
        this.type = type ;

        } // end 2-arg constructor


    /**
     * Retrieves color of card
     *
     * @return color of card
     */
    public CardColor getColor()
        {
        return this.color ;

        } // end getColor()


    /**
     * Retrieves type of card
     *
     * @return type of card
     */
    public final CardType getType()
        {
        return this.type ;

        } // end getType()

    // TODO create a method to compare cards
    // ideas: compareTo(other card)
    // for number card, if other card's color or number matches this card then return true

    @Override
    public abstract boolean equals( Object obj ) ;


    @Override
    public abstract String toString() ;

    }
// end class AbstractCard