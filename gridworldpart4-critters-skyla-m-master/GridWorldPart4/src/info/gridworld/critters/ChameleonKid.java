package info.gridworld.critters;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.actor.Critter;

public class ChameleonKid extends ChameleonCritter{
	
	public ArrayList<Actor> getActors() {
		
		ArrayList<Actor> actors = new ArrayList<Actor>();
		Location loc = getLocation();
        Location front = loc.getAdjacentLocation(getDirection());
        Location behind = loc.getAdjacentLocation(getDirection()+180);
        
        if(getGrid().isValid(front) && getGrid().get(front)!=null) {
        	actors.add(getGrid().get(front));
        }
        if(getGrid().isValid(behind) && getGrid().get(behind)!=null) {
        	actors.add(getGrid().get(behind));
        }
        return actors;
			
	}
}
