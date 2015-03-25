package giddyhero.soccersystem.shared;

import java.util.HashMap;
import java.util.Map.Entry;

public class Position  {
	int id;
	String name;
	public static final HashMap<Integer, String> positions = new HashMap<>();

	static {
		positions.put(0,"Goal Keeper");
		positions.put(1,"Center Back");
		positions.put(2,"Right Back");
		positions.put(3,"Left Back");
		positions.put(4,"Center Midfielder");
		positions.put(5,"Left Midfielder");
		positions.put(6,"Right Midfielder");
		positions.put(7,"Center Foward");
		positions.put(8,"Right Foward");
		positions.put(9,"Left Foward");
	}
	
	public static String getPositionNameById(int id){
		for(Entry<Integer, String> entry : Position.positions.entrySet()) {
		    int key = entry.getKey();
		    if (key == id)
		    	return entry.getValue();
		}
		return "N/A";
	}



}
