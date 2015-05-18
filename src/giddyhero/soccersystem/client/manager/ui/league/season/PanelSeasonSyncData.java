package giddyhero.soccersystem.client.manager.ui.league.season;

import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PanelSeasonSyncData extends VerticalPanel {
	
	Label lbTitle = new Label("Sync Data With Third Pary Database");
	PanelApiFootballSync pnApiFootballSync = new PanelApiFootballSync();
	public DialogBoxSeasonSync db = new DialogBoxSeasonSync();
	
	public PanelSeasonSyncData() {
		super();
		init();
		style();
	}

	private void init() {
		add(lbTitle);
		add(pnApiFootballSync);
	}

	private void style() {
		Style style = getElement().getStyle();
		style.setWidth(100, Unit.PCT);
		style.setMarginBottom(1, Unit.PCT);
		style.setPadding(1, Unit.PCT);
		style.setBackgroundColor("lightgrey");
		
		style = lbTitle.getElement().getStyle();
		style.setPaddingBottom(2, Unit.PCT);
		style.setFontSize(140, Unit.PCT);
	}

	class PanelApiFootballSync extends HorizontalPanel{
		
		Button btSync = new Button("Sync");
		Label lbDescription = new Label("Sync with site : www.api.football-data.org");
		
		public PanelApiFootballSync() {
			super();
			init();
			style();
		
		}
		
		private void init() {
			btSync.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					db.show();
					db.center();
				}
			});
			add(btSync);
			add(lbDescription);
		}

		private void style() {
			Style style = btSync.getElement().getStyle();
			style.setWidth(150, Unit.PX);
			style.setHeight(30, Unit.PX);
			
			style = lbDescription.getElement().getStyle();
			style.setMarginLeft(5, Unit.PCT);
			style.setWidth(500, Unit.PX);
		}
	}
	
	
	
	
}
