package giddyhero.soccersystem.client.manager.ui.league;

import giddyhero.soccersystem.client.SoccerSystem;
import giddyhero.soccersystem.client.manager.ui.league.season.SeasonCreatePanel;
import giddyhero.soccersystem.client.manager.ui.league.season.SeasonOverViewPanel;
import giddyhero.soccersystem.client.manager.ui.widget.TableInfoDisplay;
import giddyhero.soccersystem.shared.model.League;
import giddyhero.soccersystem.shared.model.Season;
import giddyhero.soccersystem.shared.model.SerializableEntity;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Widget;

public class LeagueAllPanel extends TableInfoDisplay {

	private static LeagueAllPanelUiBinder uiBinder = GWT.create(LeagueAllPanelUiBinder.class);

	interface LeagueAllPanelUiBinder extends UiBinder<Widget, LeagueAllPanel> {
	}

//	@UiField
//	FlexTable tblLeague;
	@UiField 
	ToggleButton btNewLeague;
	@UiField
	LeagueCreatePanel pnNewLeague;
	@UiField
	SeasonCreatePanel pnSeasonCreate;
	Season[] seasons;
	
	public LeagueAllPanel() {
		super();
//		initWidget(uiBinder.createAndBindUi(this));
		getAllAvailableSeason();
		initTableBase();
//		initNewLeagueButton();

	}

	private void getAllAvailableSeason() {
		SoccerSystem.Service.league.getAllSeason(new AsyncCallback<Season[]>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("get All season failure");
			}

			@Override
			public void onSuccess(Season[] result) {
				seasons = result;
				initTableData();
			}
			
		});
	}

	private void initNewLeagueButton() {
		pnNewLeague.setVisible(false);
	}

	@UiHandler("btNewLeague")
	void onButtonNewLeague(ClickEvent e) {
			pnNewLeague.setVisible(btNewLeague.isDown());
		
	}
	
	private void initTableBase() {
		setText(0, 0, "ID");
		setText(0, 1, "Name");
		setText(0, 2, "Info");
		setText(0, 3, "Seasons");
		setText(0, 4, "Action");
	}

	private void initTableData() {
		SoccerSystem.Service.league.getAllLeague(new AsyncCallback<League[]>() {

			@Override
			public void onFailure(Throwable caught) {
				
			}

			@Override
			public void onSuccess(League[] result) {
				for (int i = 0; i < result.length; i++) {
					League league = result[i];
					setText(1+i, 0, ""+league.id);
					setText(1+i, 1, ""+league.name);
					setText(1+i, 2, league.info);
					setWidget(1+i, 3, new LeagueSeasonEditGroup(league));
					setWidget(1+i, 4, createCustomLeagueActionPanel(league));
					setWidget(1+i, 4, new ActionPanel());
				}
			}
			
			private Widget createCustomLeagueActionPanel(final League league) {
				ActionPanel editDeletePanel = new ActionPanel();
				editDeletePanel.deleteButton.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						SoccerSystem.Service.general.deleteEntity(SerializableEntity.LEAGUE, league.id, new AsyncCallback<Boolean>() {

							@Override
							public void onFailure(Throwable caught) {
								
							}

							@Override
							public void onSuccess(Boolean result) {
								
								SoccerSystem.Service.general.deleteEntities(SerializableEntity.SEASON, league.seasonIds, new AsyncCallback<Void>() {

									@Override
									public void onFailure(Throwable caught) {
										Window.alert("Delete league but not delete season of that league");
									}

									@Override
									public void onSuccess(Void result) {
										Window.alert("Delete league success");										
									}
								});
							}
						});
					}
				});
				return editDeletePanel;
			}
			
		});
		
	}
	
	class LeagueSeasonEditGroup extends FlowPanel{
		ListBox lbSeasons;
		Button btView;
		Button btNew;
		League league;
		long[] seasonIds;
		Season[] seasons;
		
		public LeagueSeasonEditGroup(League league) {
			this.league = league;
			this.seasonIds = league.seasonIds;
			createViewButton();
			createNewButton();
			createSeasonListBox();
		}

		private void createSeasonListBox() {
			if (seasonIds != null){
				lbSeasons = new ListBox();
				add(lbSeasons);
				seasons = new Season[seasonIds.length];
				Window.alert("Length : "+seasonIds.length);
				for (int i = 0; i < seasonIds.length; i++) {
					long id = seasonIds[i];
					seasons[i] = getSeasonOfId(id);
					lbSeasons.addItem(""+seasons[i].year, ""+id);
				}
			}
		}

		private void createNewButton() {
			btNew = new Button("New");
			btNew.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					pnSeasonCreate.setLeague(league);
					pnSeasonCreate.setVisible(true);
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
					SoccerSystem.mainPage.addNewCenterContent(new SeasonOverViewPanel(league, getSeasonOfId(id)));
//					History.newItem(MainPage.Constant.SEASON);
				}
			});
			add(btView);
		}
		
		private Season getSeasonOfId(long id){
			for (int i = 0; i < LeagueAllPanel.this.seasons.length; i++) {
				Season season = LeagueAllPanel.this.seasons[i];
				if (season.id == id)
					return season;
			}
			return null;
		}
		
	}
	
	
	
}
