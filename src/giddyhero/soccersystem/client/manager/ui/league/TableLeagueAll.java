package giddyhero.soccersystem.client.manager.ui.league;

import java.util.List;

import giddyhero.soccersystem.client.HistoryToken;
import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.manager.ui.league.season.PanelSeasonCreate;
import giddyhero.soccersystem.client.manager.ui.league.season.PanelSeason;
import giddyhero.soccersystem.client.manager.ui.widget.TableInfoDisplay;
import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.Season;
import giddyhero.soccersystem.shared.model.SerializableEntity;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ListBox;

public class TableLeagueAll extends TableInfoDisplay {

	Season[] seasons;
	PanelSeasonCreate panelSeasonCreate;

	public TableLeagueAll() {
		super();
		init();
	}

	public void setSeasonCreatePanel(PanelSeasonCreate seasonCreatePanel) {
		this.panelSeasonCreate = seasonCreatePanel;
	}

	private void init() {
		initHeader();
		initContent();
	}

	private void initContent() {
		getAllAvailableSeason();
	}

	private void initHeader() {
		setText(0, 0, "ID");
		setText(0, 1, "Name");
		setText(0, 2, "Info");
		setText(0, 3, "Season");
		setText(0, 4, "Action");
	}

	private void getAllAvailableSeason() {
		SystemManager.Service.league.getAllSeason(new AsyncCallback<Season[]>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("get All season failure "+caught.toString());
			}

			@Override
			public void onSuccess(Season[] result) {
				Window.alert("Get : "+result.length+" season available");
				seasons = result;
				initTableData();
			}

		});
	}

	private void initTableData() {
		SystemManager.Service.league.getAllLeague(new AsyncCallback<League[]>() {

			@Override
			public void onFailure(Throwable caught) {

			}

			@Override
			public void onSuccess(League[] result) {
				for (int i = 0; i < result.length; i++) {
					final League league = result[i];
					setText(1 + i, 0, "" + league.id);
					setText(1 + i, 1, "" + league.name);
					setText(1 + i, 2, league.info);
					setWidget(1 + i, 3, new LeagueSeasonEditGroup(league));
					// setWidget(1+i, 4, createCustomLeagueActionPanel(league));
					ActionPanel actionPanel = new ActionPanel();
					actionPanel.btDelete.addClickHandler(new ClickHandler() {

						@Override
						public void onClick(ClickEvent event) {
							SystemManager.Service.league.deleteLeague(league.id,
									new AsyncCallback<Void>() {

										@Override
										public void onFailure(Throwable caught) {

										}

										@Override
										public void onSuccess(Void result) {
											Window.alert("Delete league success");
										}
									});
						}
					});
					setWidget(1 + i, 4, actionPanel);
				}
			}

		});

	}

	class LeagueSeasonEditGroup extends FlowPanel {
		ListBox lbSeasons;
		Button btView;
		Button btNew;
		League league;
		List<Long>  seasonIds;
		Season[] seasons;

		public LeagueSeasonEditGroup(League league) {
			this.league = league;
			this.seasonIds = league.seasonIds;
			createViewButton();
			createNewButton();
			createSeasonListBox();
		}

		private void createSeasonListBox() {
			if (seasonIds != null) {
				lbSeasons = new ListBox();
				add(lbSeasons);
				seasons = new Season[seasonIds.size()];
				for (int i = 0; i < seasonIds.size(); i++) {
					long id = seasonIds.get(i);
					seasons[i] = getSeasonOfId(id);
					if (seasons[i] != null)
					lbSeasons.addItem("" + seasons[i].year, "" + id);
				}
			}
		}

		private void createNewButton() {
			btNew = new Button("New");
			btNew.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					panelSeasonCreate.setLeague(league);
					panelSeasonCreate.setVisible(true);
				}
			});
			add(btNew);
		}

		private void createViewButton() {
			btView = new Button("View");
			btView.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					long id = Long.parseLong(lbSeasons.getValue(lbSeasons.getSelectedIndex()));
					History.newItem(HistoryToken.SEASON+""+id);
//					SoccerSystem.mainPage.addNewCenterContent(new PanelSeasonOverView(league, getSeasonOfId(id)));
					 
				}
			});
			add(btView);
		}

		private Season getSeasonOfId(long id) {
			for (int i = 0; i < TableLeagueAll.this.seasons.length; i++) {
				Season season = TableLeagueAll.this.seasons[i];
				if (season.id == id)
					return season;
			}
			return null;
		}

	}
}
