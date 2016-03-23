import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends World
{

    /**
     * Constructor for objects of class Board.
     * 
     */
    public Board()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(14, 10, 75); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        BlackPiece blackpiece = new BlackPiece();
        addObject(blackpiece,5,4);
        BlackPiece blackpiece2 = new BlackPiece();
        addObject(blackpiece2,4,5);
        BlackPiece blackpiece3 = new BlackPiece();
        addObject(blackpiece3,10,4);
        WhitePiece whitepiece = new WhitePiece();
        addObject(whitepiece,10,5);
        WhitePiece whitepiece2 = new WhitePiece();
        addObject(whitepiece2,5,5);
        WhitePiece whitepiece3 = new WhitePiece();
        addObject(whitepiece3,4,4);
    }
}
