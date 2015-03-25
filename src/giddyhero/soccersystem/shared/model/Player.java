package giddyhero.soccersystem.shared.model;

import com.google.gwt.user.client.ui.Image;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Player implements SerializableEntity {
	private static final long serialVersionUID = 1L;
	public @Id
	Long id;
	public String name;
	public int year, month, day;
	public int height;
	public int positionId;
	public String nationality;
	public String avatarUrl;
	@Index public Long currentTeamId;

	public Player() {
	}

	public Player(String name, int year,int month, int day, int height, int positionId,
			String nationality, String avatarUrl) {
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
		this.height = height;
		this.positionId = positionId;
		this.nationality = nationality;
		this.avatarUrl = avatarUrl;
	}
	

	@Override
	public String toString() {
		return "name " + name + "\n " + day + " - "
				+ month + " - " + year + "\nheight "
				+ height + "\n position id : " + positionId
				+ "\n nationality : " + nationality + "\n Avatar Url : "
				+ avatarUrl;
	}

	public Image getAvatar() {
		Image image = new Image();
		if (avatarUrl != null)
			image.setUrl(avatarUrl);
		image.setPixelSize(60, 60);
		return image;
	}
}
