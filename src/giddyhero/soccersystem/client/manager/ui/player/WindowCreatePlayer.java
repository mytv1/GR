package giddyhero.soccersystem.client.manager.ui.player;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ProvidesResize;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.datepicker.client.DateBox;

/**
 * This class initation need least 1 player in database
 * @author CyberFish
 *
 */
public class WindowCreatePlayer extends FlowPanel {
	public static final int WIDTH = 1100, HEIGHT = 570;
//	Button btCreate = new Button("Create");
	TablePlayerCreated tblCreated;
	TablePlayerCreating tblCreating;
	Label lbCreated = new Label("Created Players");
	Player playerTemp;

	public WindowCreatePlayer() {
		super();
		init();
	}

	private void init() {
		setPixelSize(1100, 600);

		initTableCreating();
		
		initLabelCreated();
		
		add(lbCreated);
		initTableCreated();
		
//		initCreateButton();
		// setAllPlayerData();
	}

	private void initLabelCreated() {
		CSSUtils.setMarginCenter(lbCreated);
		CSSUtils.setFontSize(lbCreated, "large");
		CSSUtils.setFontWeight(lbCreated, "bold");
		lbCreated.getElement().getStyle().setTextAlign(Style.TextAlign.CENTER);
		CSSUtils.setMarginTop(lbCreated, 30);
		CSSUtils.setMarginBottom(lbCreated, 10);
	}

	public void setAllPlayerData() {
		SystemManager.Service.player.getAllPlayers(new AsyncCallback<Player[]>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("get player fail");
			}

			@Override
			public void onSuccess(Player[] result) {
				// Window.alert("get player success " + result.length);
				List<Player> players = new ArrayList<Player>();
				for (int i = 0; i < result.length; i++) {
					players.add(result[i]);
				}
				tblCreated.setData(players);
			}

		});
	}

	private void initTableCreating() {
		tblCreating = new TablePlayerCreating();
		tblCreating.setHeight("120px");
		CSSUtils.setMarginTop(tblCreating, 20);

		SystemManager.Service.player.getFirstPlayer( new AsyncCallback<Player>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("FAILURE");
			}

			@Override
			public void onSuccess(Player result) {
//				Window.alert("success "+result.name);
				playerTemp = result;
				playerTemp.name = "Name";
				playerTemp.avatarUrl = "http://www.grammarly.com/blog/wp-content/uploads/2015/01/Silhouette-question-mark.jpeg";
				ArrayList<Player> listPlayerTemp = new ArrayList<Player>();
				listPlayerTemp.add(playerTemp);
				tblCreating.setData(listPlayerTemp);
			}
		});
		
		add(tblCreating);
	}

	private void initTableCreated() {
		tblCreated = new TablePlayerCreated();
		tblCreated.setHeight("400px");
		add(tblCreated);
	}

//	private void initCreateButton() {
//		btCreate.setPixelSize(150, 50);
//		btCreate.addClickHandler(new ClickHandler() {
//
//			@Override
//			public void onClick(ClickEvent event) {
//				
//			}
//		});
//		getElement().getStyle().setTextAlign(Style.TextAlign.CENTER);
//		add(btCreate);
//	}

	class TablePlayerCreating extends TablePlayer {
		Column<Player, String> colCreate;

		public TablePlayerCreating() {
			super();
		}
		
		

		@Override
		protected void startInit() {
			super.startInit();
			init();
		}



		private void init() {
			removeColumn(colId);
			// removeColumn(colAvatar);
			// removeColumn(colAvatarUrl);
			// removeColumn(colBirth);
			// removeColumn(colDelete);
			//
			// removeColumn(colHeight);
			// removeColumn(colName);
			// removeColumn(colNation);
			//
			// removeColumn(colPosition);
			removeColumn(colSave);
			removeColumn(colDelete);
			 initColCreateButton();
		}

		private void initColCreateButton() {
			colCreate = new Column<Player, String>(new ButtonCell()) {

				@Override
				public String getValue(Player object) {
					return "Create";
				}
			};
			colCreate.setFieldUpdater(new FieldUpdater<Player, String>() {
				
				@Override
				public void update(int index, final Player object, String value) {
					Window.alert("Player : "+object.toString());
					object.id = null;
					SystemManager.Service.player.savePlayer(object, new AsyncCallback<Player>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Create player fail");
							object.id = 6632254138744832L;
						}

						@Override
						public void onSuccess(Player result) {
							Window.alert("Create player success");
							object.id = 6632254138744832L;
							tblCreated.playersProvider.getList().add(result);
							
						}
					});
				}
			});

			addColumn(colCreate, "Create");
		}
	}

	class TablePlayerCreated extends TablePlayer {

		public TablePlayerCreated() {
			super();
			init();
		}

		private void init() {

		}
	}

}
