package giddyhero.soccersystem.shared.model;


import com.google.gwt.view.client.ProvidesKey;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Standing implements SerializableEntity {

	  public static final ProvidesKey<Standing> KEY_PROVIDER = new ProvidesKey<Standing>() {
	      @Override
	      public Object getKey(Standing item) {
	        return item == null ? null : item.id;
	      }
	    };
	
	public @Id Long id;
	public @Index long teamId;
	public @Index long seasonId;
	public int played;
	public int win;
	public int draw;
	public int lose;
	public int goalFor;
	public int goalAgaints;
	public String teamName = "";

	 public Standing() {
		  teamId = 0;
		  seasonId = 0;
		  played = 0;
		  win = 0;
		  draw = 0;
		  lose = 0;
		  goalFor = 0;
		  goalAgaints = 0;
	}
	
	public Standing(long teamId, int played, int win, int goalFor, int goalAgaints){
		this.teamId = teamId;
		this.played = played;
		this.win = win;
		this.goalFor = goalFor;
		this.goalAgaints = goalAgaints;
	}

	public Standing(long teamId,String teamName) {
		this.teamId = teamId;
		this.teamName = teamName;
	}

	@Override
	public String toString() {
		return "id " + id +
				"\n teamId " + teamId + 
				"\n played "+ played + 
				"\n win : " + win
				+ "\n goalFor : " + goalFor + 
				"\n goalAgaints : "+ goalAgaints;
	}

	public void refresh() {
		played = 0;
		win = 0;
		draw = 0;
		lose = 0;
		goalAgaints = 0;
		goalFor = 0;
		
		
	}
	

}
