package info.gridworld.critters;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;

public class ZoolanderCritter extends Critter{
	
	public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (a instanceof Flower)
                a.removeSelfFromGrid();
        }
    }
        
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if(getGrid().isValid(next) && getGrid().get(next)==null) {
             locs.add(next);
        }
        return locs;
    }
    
    public void makeMove(Location loc)
    {
        if (getMoveLocations().size() == 0)
            setDirection(getDirection() + Location.RIGHT);
        else
            moveTo(loc);
    }

    
}
