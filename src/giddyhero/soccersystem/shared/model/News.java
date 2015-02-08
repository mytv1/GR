package giddyhero.soccersystem.shared.model;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class News  implements Serializable, IsSerializable{
	public @Id
	Long id;
	public String title = "";
	public String titleImageUrl = "";
	public String content = "";
	public String category = "";
	public long taggedPlayer = -1;

	private News() {

	}

	public News(String title, String titleImageUrl, String category,long taggedPlayer, String content) {
		this.title = title;
		this.content = content;
		this.titleImageUrl = titleImageUrl;
		this.category = category;
		this.taggedPlayer = taggedPlayer;
	}

	@Override
	public String toString() {
		return "Title : "+title+" \n Content "+content;
	}
	
	
	
}
