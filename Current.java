import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.Color;
import java.util.List;

/**
 * Write a description of class Current here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Current extends Actor
{
    private boolean current = false;

    public Current() {
        setImage(new GreenfootImage("Current:", 40, Color.WHITE, null));
    }
    public void act() 
    {
        World world = getWorld();
        Piece piece = world.getObjectsAt(getX()+2, getY(), Piece.class).get(0);
        if (current == false) {
            piece.setImage("piece_black.png");
        } else {
            piece.setImage("piece_white.png");
        }
    }

    public void reverse() {
        if (current == false) {
            current = true;
        } else {
            current = false;
        }
    }
}
