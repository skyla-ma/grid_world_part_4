package info.gridworld.critters;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class CellCritter extends Critter {
	int n = 0;
	
	public void makeMove(Location loc)
    {
        if (loc == null)
            removeSelfFromGrid();
    }
	
	public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        locs.add(getLocation());
        return locs;
    }
	
	public Location selectMoveLocation(ArrayList<Location> locs) {
		if(n==0 || n>=5) {
			return null;
		}
		return getLocation();
	}
	
	public ArrayList<Actor> getActors()
	{
		 ArrayList<Actor> actors = new ArrayList<Actor>();
		 Location loc = getLocation();
	        int dir = getDirection();
	        for(int i=0; i<8; i++) {
	        	Location next = loc.getAdjacentLocation(dir);
	        	dir += 45;
	        	if(getGrid().isValid(next) && getGrid().get(next)!= null && getGrid().get(next) instanceof CellCritter) {
	            	actors.add(getGrid().get(next));
	            }
	        }
	        return actors;
    }
	
	public void processActors(ArrayList<Actor> actors)
    {
        n = actors.size();
        if(n>=1 && n<=3) {
        	ArrayList<Location> empty = getGrid().getEmptyAdjacentLocations(getLocation());
        	int c = empty.size();
        	if(c==0) {
        		return;
        	}
        	int r = (int) (Math.random() * c);
        	CellCritter alice = new CellCritter();
        	alice.putSelfInGrid(getGrid(), empty.get(r));
        }
    }
}
