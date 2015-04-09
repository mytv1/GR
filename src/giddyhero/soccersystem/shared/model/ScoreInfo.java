package giddyhero.soccersystem.shared.model;


import com.google.gwt.view.client.ProvidesKey;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class ScoreInfo implements SerializableEntity {

	  public static final ProvidesKey<ScoreInfo> KEY_PROVIDER = new ProvidesKey<ScoreInfo>() {
	      @Override
	      public Object getKey(ScoreInfo item) {
	        return item == null ? null : item.id;
	      }
	    };
	
	public @Id Long id;
	public @Index long teamId;
	public long seasonId;
	public int played;
	public int win;
	public int draw;
	public int lose;
	public int goalFor;
	public int goalAgaints;

	 public ScoreInfo() {
		  teamId = 0;
		  seasonId = 0;
		  played = 0;
		  win = 0;
		  draw = 0;
		  lose = 0;
		  goalFor = 0;
		  goalAgaints = 0;
	}
	
	public ScoreInfo(long teamId, int played, int win, int goalFor, int goalAgaints){
		this.teamId = teamId;
		this.played = played;
		this.win = win;
		this.goalFor = goalFor;
		this.goalAgaints = goalAgaints;
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
	

}
