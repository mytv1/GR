package giddyhero.soccersystem.client.manager.ui.widget;

import giddyhero.soccersystem.client.CSSClass;
import giddyhero.soccersystem.client.manager.resources.SSClientBundleBaseThemeManager;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ToggleButton;

public class TableInfoDisplay extends FlexTable{

	public TableInfoDisplay() {
		super();
		init();
	}

	private void init() {
		setStyleName(CSSClass.TABLE_INFO);
		setWidth("100%");
	}
	
	public class ActionPanel extends HorizontalPanel{
		public EditButton editButton = new EditButton();
		public DeleteButton deleteButton = new DeleteButton();
		
		public ActionPanel() {
			super();
			add(editButton);
			add(deleteButton);
		}
	}
	
	public class EditButton extends ToggleButton{
		
		public EditButton() {
			super(new Image(SSClientBundleBaseThemeManager.IMPL.getBundle().editIc()));
			setPixelSize(40, 40);
		}
	}
	
	public class DeleteButton extends ToggleButton{
		
		public DeleteButton() {
			super(new Image(SSClientBundleBaseThemeManager.IMPL.getBundle().deleteIc()));
			setPixelSize(40, 40);
		}
	}
	
}
