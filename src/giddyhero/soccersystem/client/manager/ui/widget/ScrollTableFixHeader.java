package giddyhero.soccersystem.client.manager.ui.widget;

import java.awt.ScrollPane;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HTMLTable.ColumnFormatter;
import com.google.gwt.user.client.ui.ScrollPanel;

public abstract class ScrollTableFixHeader extends FlexTable{
	public TableHeader tblHeader;
	public TableContent tblContent;
	public ScrollPanel spContent = new ScrollPanel();
 
	public ScrollTableFixHeader() {
		super();
		init();
	}
	
	public class TableHeader extends TableInfoDisplay{
		public TableHeader() {
			super();
			ColumnFormatter columnFormatter = initColumnFormater();
			if (columnFormatter != null)
				setColumnFormatter(columnFormatter);
		}
	}
	
	public class TableContent extends TableInfoDisplay{
		public TableContent() {
			super();
			ColumnFormatter columnFormatter = initColumnFormater();
			if (columnFormatter != null)
				setColumnFormatter(columnFormatter);
		}
	}
	
	public abstract ColumnFormatter initColumnFormater();
	
	public abstract void initHeader();
	
	public abstract void initContent();

	private void init() {
		tblHeader = new TableHeader();
		tblContent = new TableContent();
		spContent.add(tblContent);
		
		add(tblHeader);
		add(spContent);
		
		initHeader();
		initContent();
	}
	

}
