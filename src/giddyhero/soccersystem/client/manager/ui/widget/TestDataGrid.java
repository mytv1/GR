package giddyhero.soccersystem.client.manager.ui.widget;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.shared.model.Player;

import java.util.ArrayList;
import java.util.List;


import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;

public class TestDataGrid extends FlowPanel{

	public TestDataGrid() {
		super();
		init();
	}

	private void init() {
		add(new Label("West"));
		SystemManager.Service.player.getAllPlayers(new AsyncCallback<Player[]>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("get player fail");
			}

			@Override
			public void onSuccess(Player[] result) {
				Window.alert("get player success "+result.length);
				List<Player> players = new ArrayList<Player>();
				for (int i = 0; i < result.length; i++) {
					players.add(result[i]);
				}
				DataGrid<Player> dataGrid = new DataGrid<Player>(Player.KEY_PROVIDER);
				dataGrid.setSize("600px", "300px");
				ListHandler<Player> sortHandler = new ListHandler<Player>(players);
				dataGrid.addColumnSortHandler(sortHandler);

//				final SelectionModel<Player> selectionModel = new MultiSelectionModel<Player>(Player.KEY_PROVIDER);
//				dataGrid.setSelectionModel(selectionModel,
//						DefaultSelectionEventManager.<Player> createCheckboxManager());

				Column<Player, String> nameColum = new Column<Player, String>(new EditTextCell()) {

					@Override
					public String getValue(Player object) {
						return object.name;
					}
				};
				
				Column<Player, String> idColum = new Column<Player, String>(new EditTextCell()) {

					@Override
					public String getValue(Player object) {
						return object.avatarUrl;
					}
				};
				dataGrid.addColumn(nameColum,"Name");
				dataGrid.addColumn(idColum,"Id");
				  dataGrid.setEmptyTableWidget(new Label("Empty"));
				  dataGrid.setRowData(players);
				add(dataGrid);
				
//				DataGrid<String> dataGrid = new DataGrid<String>();
//				dataGrid.addColumn(new TextColumn<String>() {
//					public String getValue(String object) {
//						return object.toString();
//					}
//				}, "Category");
//				
//				dataGrid.addColumn(new TextColumn<String>() {
//					public String getValue(String object) {
//						return object.toString();
//					}
//				}, "Category2");
//				
//				ArrayList<String> strings = new ArrayList<String>();
//				strings.add("abc");
//				strings.add("def");
//				strings.add("ghi");
//				dataGrid.setRowData(strings);
//				add(dataGrid);
			}
		});		
	}

}
