package giddyhero.soccersystem.client.manager.widget;

import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Panel;

public abstract class FocusParentPanel extends FocusPanel{

	public Panel hp;
	
	public FocusParentPanel() {
		super();
		hp = initPanel();
		add(hp);
	}
	
	public abstract Panel initPanel();
}
