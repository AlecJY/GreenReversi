import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends World
{

    private Current currentText = new Current();
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
        addObject(blackpiece3,10,3);
        WhitePiece whitepiece = new WhitePiece();
        addObject(whitepiece,10,4);
        WhitePiece whitepiece2 = new WhitePiece();
        addObject(whitepiece2,5,5);
        WhitePiece whitepiece3 = new WhitePiece();
        addObject(whitepiece3,4,4);

        Score blackScore = new Score(BlackPiece.class);
        addObject(blackScore, 11, 3);
        Score whiteScore = new Score(WhitePiece.class);
        addObject(whiteScore, 11, 4);

        addObject(currentText, 10, 7);
        Piece piece = new Piece();
        addObject(piece, 12, 7);
    }

    private int current = 1;

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            int x = Greenfoot.getMouseInfo().getX();
            int y = Greenfoot.getMouseInfo().getY();
            if (getObjectsAt(x, y, Piece.class).isEmpty() && x >= 1 && x <= 8 && y >= 1 && y <= 8) {
                if (current == 1) {
                    if (reverse(x, y, current)) {
                        addObject(new BlackPiece(), x, y);
                        currentText.reverse();
                        current = 2;
                    }
                } else {
                    if (reverse(x, y, current)) {
                        addObject(new WhitePiece(), x, y);
                        currentText.reverse();
                        current = 1;
                    }
                }
            }
        }
    }

    private int getPieceType(int x, int y) {
        List pieces = getObjectsAt(x, y, Piece.class);
        if (pieces.isEmpty()) {
            return 0;
        } else if (pieces.get(0).getClass() == BlackPiece.class) {
            return 1;
        } else {
            return 2;
        }
    }

    private int checkLine(int x, int y, int dx, int dy, int current) {
        for (int i = 1; x+dx*i <= 8 && x+dx*i >= 1 && y+dy*i <= 8 && y+dy*i >= 1; i++) {
            if (getPieceType(x+dx*i, y+dy*i) == current) {
                return i;
            } else if (getPieceType(x+dx*i, y+dy*i) == 0) {
                break;
            }
        }
        return -1;
    }

    private boolean reversePieces(int x, int y, int dx, int dy, int site) {
        boolean reversed = false;
        for (int i = 1; i < site; i++) {
            reversePiece(x+dx*i, y+dy*i);
        }
        return reversed;
    }

    private void reversePiece(int x, int y) {
        Piece piece = getObjectsAt(x, y, Piece.class).get(0);
        removeObject(piece);
        if (piece.getClass() == BlackPiece.class) {
            addObject(new WhitePiece(), x, y);
        } else {
            addObject(new BlackPiece(), x, y);
        }
    }

    private boolean reverse(int x, int y, int current) {
        boolean reversed = false;
        int site;

        site = checkLine(x, y, 1, 0, current);
        if (site > 1) {
            reversePieces(x, y, 1, 0, site);
            reversed = true;
        }

        site = checkLine(x, y, -1, 0, current);
        if (site > 1) {
            reversePieces(x, y, -1, 0, site);
            reversed = true;
        }

        site = checkLine(x, y, 0, 1, current);
        if (site > 1) {
            reversePieces(x, y, 0, 1, site);
            reversed = true;
        }

        site = checkLine(x, y, 0, -1, current);
        if (site > 1) {
            reversePieces(x, y, 0, -1, site);
            reversed = true;
        }

        site = checkLine(x, y, 1, 1, current);
        if (site > 1) {
            reversePieces(x, y, 1, 1, site);
            reversed = true;
        }

        site = checkLine(x, y, -1, -1, current);
        if (site > 1) {
            reversePieces(x, y, -1, -1, site);
            reversed = true;
        }

        site = checkLine(x, y, 1, -1, current);
        if (site > 1) {
            reversePieces(x, y, 1, -1, site);
            reversed = true;
        }

        site = checkLine(x, y, -1, 1, current);
        if (site > 1) {
            reversePieces(x, y, -1, 1, site);
            reversed = true;
        }
        return reversed;
    }

    private boolean checkWin() {
        return false;
    }


}
