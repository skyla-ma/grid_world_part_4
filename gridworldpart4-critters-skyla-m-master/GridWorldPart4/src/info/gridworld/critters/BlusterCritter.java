package info.gridworld.critters;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class BlusterCritter extends Critter {
	
	private static double FACTOR = 0.05;
	public static int c = 2;
	
	public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location loc = getLocation();
        int dir = getDirection();
        for(int i=0; i<8; i++) {
        	Location next = loc.getAdjacentLocation(dir);
        	if(getGrid().isValid(next) && getGrid().get(next)!= null && getGrid().get(next) instanceof Critter) {
            	actors.add(getGrid().get(next));
            }
        	Location next2 = next.getAdjacentLocation(dir);
        	if(getGrid().isValid(next2) && getGrid().get(next2)!= null && getGrid().get(next2) instanceof Critter) {
            	actors.add(getGrid().get(next2));
            }
        	dir+=45;
        }
        return actors;
    }
		
	public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n >= c) {
        	 Color c = getColor();
             int red = (int) (c.getRed() * (1 - FACTOR));
             int green = (int) (c.getGreen() * (1 - FACTOR));
             int blue = (int) (c.getBlue() * (1 - FACTOR));

             setColor(new Color(red, green, blue));
            return;
        }
        
        if(n < c) {
        	int red, green, blue;
        	 Color c = getColor();
        	 
        	 if(c.getRed()*(1+FACTOR)>255) {
        		 red = 255;
        	 }
        	 
        	 else if(c.getRed()==0) {
        		 red = 2;
        	 }
        	 
        	 else {
        		 red = (int) (c.getRed() * (1 + FACTOR));
        	 }
        	 
        	 if(c.getGreen()*(1+FACTOR)>255) {
        		 green = 255;
        	 }
        	 
        	 else if(c.getGreen()==0) {
        		 green = 2;
        	 }
        	 
        	 else {
        		 green = (int) (c.getGreen() * (1 + FACTOR));
        	 }
        	 
        	 if(c.getBlue()*(1+FACTOR)>255) {
        		 blue = 255;
        	 }
        	 
        	 else if(c.getBlue()==0) {
        		 blue = 2;
        	 }
        	 
        	 else {	 
        		 blue = (int) (c.getBlue() * (1 + FACTOR));
        	 }

             setColor(new Color(red, green, blue));
            return;
        }
    }
}
