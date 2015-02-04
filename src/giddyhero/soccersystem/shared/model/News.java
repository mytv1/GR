package giddyhero.soccersystem.shared.model;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class News  implements Serializable, IsSerializable{
	public @Id
	Long id;
	public String title;
	public String content;

	private News() {

	}

	public News(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
