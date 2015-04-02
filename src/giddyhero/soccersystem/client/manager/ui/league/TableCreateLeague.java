package giddyhero.soccersystem.client.manager.ui.league;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.manager.ui.widget.TableFormInput;
import giddyhero.soccersystem.client.manager.widget.SSFlexTable.TextAreaStandard;
import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.News;
import giddyhero.soccersystem.shared.model.Player;

public class TableCreateLeague extends TableFormInput{
	
	TextBoxStandard tbName = new TextBoxStandard();
	TextAreaStandard taInfo =  new TextAreaStandard("800px","200px");
	
	public TableCreateLeague() {
		super();
		init();
	}

	private void init() {
		initLabelColumn();
		initContentColum();
	}
	
	public League getLeague(){
		League league = new League(tbName.getText(), taInfo.getText());
		return league;
	}
	

	private void initContentColum() {
		setWidget(0, 1, tbName);
		setWidget(1, 1, taInfo);
	}

	private void initLabelColumn() {
		setWidget(0, 0, new LabelStandard("Name"));
		setWidget(1, 0, new LabelStandard("Info"));
	}
	
}
