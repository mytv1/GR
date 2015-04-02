package giddyhero.soccersystem.client.manager.ui.player;

import giddyhero.soccersystem.client.CSSClass;
import giddyhero.soccersystem.client.HistoryToken;
import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.manager.ui.widget.ResizableImageCell;
import giddyhero.soccersystem.client.manager.ui.widget.ScrollTableFixHeader;
import giddyhero.soccersystem.client.manager.widget.SSFlexTable.ActionPanel;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.Position;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.SerializableEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.DatePickerCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.ImageCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.client.SafeHtmlTemplates.Template;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;
import com.googlecode.mgwt.ui.client.util.CssUtil;
import com.sun.media.sound.DataPusher;

public class PanelPlayerAll extends FlowPanel {

	Button btCreate = new Button("New Player");
	TablePlayer tablePlayer;

	public PanelPlayerAll() {
		super();
		init();
	}

	private void init() {
		initButtonCreate();
		tablePlayer = new TablePlayer();
		setAllPlayerData();
		add(tablePlayer);
		
	}

	private void initButtonCreate() {
		CSSUtils.setMarginTop(btCreate, 10);
		CSSUtils.setMarginBottom(btCreate, 20);
		btCreate.setPixelSize(120, 40);
		btCreate.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.open("Manager.html#"+HistoryToken.WINDOW_CREATE_PLAYER, "window name", "width="+WindowCreatePlayer.WIDTH+", height="+WindowCreatePlayer.HEIGHT);
			}
		});
		add(btCreate);		
	}

	public void setAllPlayerData() {
		SystemManager.Service.player.getAllPlayers(new AsyncCallback<Player[]>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("get player fail");
			}

			@Override
			public void onSuccess(Player[] result) {
//				Window.alert("get player success " + result.length);
				List<Player> players = new ArrayList<Player>();
				for (int i = 0; i < result.length; i++) {
					players.add(result[i]);
				}
				tablePlayer.setData(players);
			}

		});
	}

}
