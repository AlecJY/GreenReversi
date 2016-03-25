import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.*;
import java.util.List;

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private Class cls;

    public Score(Class cls) {
        this.cls = cls;
    }

    public void act()
    {
        World world = getWorld();
        List pieceList = world.getObjects(cls);
        setImage(new GreenfootImage(Integer.toString(pieceList.size() - 1), 50, Color.WHITE, null));
    }    
}
