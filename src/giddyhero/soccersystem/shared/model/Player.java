package giddyhero.soccersystem.shared.model;

import java.util.Date;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.view.client.ProvidesKey;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Player implements SerializableEntity{
	private static final long serialVersionUID = 1L;
	public @Id Long id;
	public String name;
	public String birth;
	public int height;
	public int positionId;
	public String nationality;
	public String avatarUrl;
	@Index public long currentTeamId;

	public Player() {
	}

	public Player(String name, String birthStr, int height, int positionId,
			String nationality, String avatarUrl) {
		this.name = name;
		this.birth = birthStr;
		this.height = height;
		this.positionId = positionId;
		this.nationality = nationality;
		this.avatarUrl = avatarUrl;
	}
	

	@Override
	public String toString() {
		return "name " + name +
				"\n " + birth + 
				"\nheight "+ height + 
				"\n position id : " + positionId
				+ "\n nationality : " + nationality + 
				"\n Avatar Url : "+ avatarUrl+
				"\nTeam Id : "+currentTeamId;
	}
	

	public Image getAvatar() {
		Image image = new Image();
		if (avatarUrl != null)
			image.setUrl(avatarUrl);
		image.setPixelSize(60, 60);
		return image;
	}

	  public static final ProvidesKey<Player> KEY_PROVIDER = new ProvidesKey<Player>() {
	      @Override
	      public Object getKey(Player item) {
	        return item == null ? null : item.id;
	      }
	    };
}
