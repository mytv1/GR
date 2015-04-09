package giddyhero.soccersystem.client.manager.ui.team;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.manager.ui.player.TablePlayer;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Team;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * This class initation need least 1 player in database
 * @author CyberFish
 *
 */
public class WindowCreateTeam extends FlowPanel {
	public static final int WIDTH = 1100, HEIGHT = 620;
//	Button btCreate = new Button("Create");
	TableTeamCreated tblCreated;
	TablePlayerCreating tblCreating;
	Label lbCreated = new Label("Created Teams");
	Team teamTemp;

	public WindowCreateTeam() {
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


	private void initTableCreating() {
		tblCreating = new TablePlayerCreating();
		tblCreating.setHeight("120px");
		CSSUtils.setMarginTop(tblCreating, 20);

//		SystemManager.Service.player.getFirstPlayer( new AsyncCallback<Player>() {
//
//			@Override
//			public void onFailure(Throwable caught) {
//				Window.alert("FAILURE");
//			}
//
//			@Override
//			public void onSuccess(Player result) {
//				playerTemp = result;
//				playerTemp.name = "Name";
//				playerTemp.avatarUrl = "http://www.grammarly.com/blog/wp-content/uploads/2015/01/Silhouette-question-mark.jpeg";
//				ArrayList<Player> listPlayerTemp = new ArrayList<Player>();
//				listPlayerTemp.add(playerTemp);
////				tblCreating.setData(listPlayerTemp);
//			}
//		});
		
		teamTemp = new Team("Name", "", "Name", 1990, "England");
		teamTemp.id = 6632254138744832L;
		teamTemp.name = "Name";
		teamTemp.logoUrl = "http://www.grammarly.com/blog/wp-content/uploads/2015/01/Silhouette-question-mark.jpeg";
		ArrayList<Team> listTeamTemp = new ArrayList<Team>();
		listTeamTemp.add(teamTemp);
		tblCreating.setData(listTeamTemp);
		
		add(tblCreating);
	}

	private void initTableCreated() {
		tblCreated = new TableTeamCreated();
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

	class TablePlayerCreating extends TableTeam {
		Column<Team, String> colCreate;

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
			colCreate = new Column<Team, String>(new ButtonCell()) {

				@Override
				public String getValue(Team object) {
					return "Create";
				}
			};
			colCreate.setFieldUpdater(new FieldUpdater<Team, String>() {
				
				@Override
				public void update(int index, final Team object, String value) {
					Window.alert("Team : "+object.toString());
					object.id = null;
					SystemManager.Service.team.saveTeam(object, new AsyncCallback<Team>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Create player fail "+caught.toString());
							object.id = 6632254138744832L;
						}

						@Override
						public void onSuccess(Team result) {
							Window.alert("Create team success : "+result.toString());
							object.id = 6632254138744832L;
							tblCreated.teamsProvider.getList().add(result);
							
						}
					});
				}
			});

			addColumn(colCreate, "Create");
		}
	}

	class TableTeamCreated extends TableTeam {

		public TableTeamCreated() {
			super();
			init();
		}

		private void init() {

		}
	}

}
