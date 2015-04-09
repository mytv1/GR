package giddyhero.soccersystem.shared.model;

import com.google.gwt.view.client.ProvidesKey;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class News  implements SerializableEntity{
		public static final ProvidesKey<News> KEY_PROVIDER = new ProvidesKey<News>() {
		@Override
		public Object getKey(News item) {
			return item == null ? null : item.id;
		}
	};
	
	public @Id
	Long id;
	public String title = "";
	public String titleImageUrl = "";
	public String content = "";
	public String category = "";

	private News() {

	}

	public News(String title, String titleImageUrl, String category, String content) {
		this.title = title;
		this.content = content;
		this.titleImageUrl = titleImageUrl;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Title : "+title+" \n Content "+content;
	}
	
	
	
}
