package info.gridworld.critters;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.*;

public class HoarderCritter extends Critter{
	
	private Location loc;
	private boolean isHolding;
	private Actor chosenActor;
	private ArrayList<Actor> alreadyHeld;

	public HoarderCritter() {
		loc = new Location(0,0);
	}
	
	public HoarderCritter(Location loc) {
		this.loc = new Location(loc.getRow(),loc.getCol());
		//this.loc = loc;
		alreadyHeld = new ArrayList<Actor>();
	}
	
	public void processActors(ArrayList<Actor> actors) {
		 int n = actors.size();
		 for(int i=0; i<n; i++) {
			 for(int j=0; j<alreadyHeld.size(); j++) {
				 if(actors.get(i).getLocation().equals(alreadyHeld.get(j).getLocation())) {
					 actors.remove(i);
					 i--;
				 }
			 }
			 
		 }
	     if (n > 0) {
	        int r = (int) (Math.random() * n);
	        chosenActor = actors.get(r); 
	        alreadyHeld.add(chosenActor);
	        chosenActor.removeSelfFromGrid();
	        isHolding = true;
	     }
	}
	
	public ArrayList<Location> getMoveLocations(){
		ArrayList<Location> locs = new ArrayList<Location>();
		ArrayList<Location> empty = getGrid().getEmptyAdjacentLocations(getLocation());
		if(isHolding == true) {
			Location next = getLocation().getAdjacentLocation(getLocation().getDirectionToward(loc));
			if((getLocation().getCol() == loc.getCol()) || (getLocation().getRow() == loc.getRow())) {
				if(!emptyOrNot(next)) {
					chosenActor.putSelfInGrid(getGrid(), getLocation());
						if(empty.size() == 0){
							locs.add(null);
						}
						else {
							locs = empty;
						}
				}
				else {
					locs.add(next);
				}
			}
			
			else {
				if(emptyOrNot(next)) {
					locs.add(next);
				}
				
				if(emptyOrNot(getLocation().getAdjacentLocation(getLocation().getDirectionToward(loc)+45))) {
					locs.add(getLocation().getAdjacentLocation(getLocation().getDirectionToward(loc)+45));
				}
		
				if(emptyOrNot(getLocation().getAdjacentLocation(getLocation().getDirectionToward(loc)-45))) {
					locs.add(getLocation().getAdjacentLocation(getLocation().getDirectionToward(loc)-45));
				}
				
				if(locs.size()==0) {
					chosenActor.putSelfInGrid(getGrid(), getLocation());
					if(empty.size() == 0){
						locs.add(null);
					}
					else {
						locs = empty;
					}
				}
			}
			if(getLocation().equals(loc)) {
				chosenActor.putSelfInGrid(getGrid(), loc);
				locs = empty;
			}
		}
		else {
			locs = empty;
		}
          return locs; 
    }
	
	
	private boolean emptyOrNot(Location next){
		ArrayList<Location> empty = getGrid().getEmptyAdjacentLocations(getLocation());
		for(int i=0; i<empty.size();i++) {
			if(next.equals(empty.get(i))) {
				return true;
			}
		}
		return false;
	
	}
}
