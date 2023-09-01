
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.critters.BlusterCritter;
	import info.gridworld.grid.Location;

	import java.awt.Color;

	/**
	 * This class runs a world that contains critters. <br />
	 * This class is not tested on the AP CS A and AB exams.
	 */
	public class BlusterCritterRunner
	{
	    public static void main(String[] args)
	    {
	        ActorWorld world = new ActorWorld();
	        world.add(new Location(7, 8), new Critter());
	        world.add(new Location(3, 3), new Critter());
	        world.add(new Location(2, 8), new Critter());
	        world.add(new Location(5, 5), new Critter());
	        world.add(new Location(1, 5), new Critter());
	        world.add(new Location(7, 2), new Critter());
	        world.add(new Location(4, 4), new BlusterCritter());
	        world.add(new Location(5, 8), new BlusterCritter());
	        
	        world.show();
	    }
	}

