package giddyhero.soccersystem.client.manager.ui.general;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class EditDeletePanel extends Composite{

	private static EditDeletePanelUiBinder uiBinder = GWT
			.create(EditDeletePanelUiBinder.class);

	interface EditDeletePanelUiBinder extends UiBinder<Widget, EditDeletePanel> {
	}
	
	@UiField
	Button btDelete, btEdit;

	public EditDeletePanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public Button getBtDelete() {
		return btDelete;
	}
	
	public Button getBtEdit() {
		return btEdit;
	}
	
	
	
}
