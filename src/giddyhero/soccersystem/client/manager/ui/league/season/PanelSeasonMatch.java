package giddyhero.soccersystem.client.manager.ui.league.season;

import java.util.ArrayList;
import java.util.List;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.manager.ui.player.TablePlayer;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.Player;
import giddyhero.soccersystem.shared.model.Standing;
import giddyhero.soccersystem.shared.model.Team;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.dom.client.TableSectionElement;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ToggleButton;

public class PanelSeasonMatch extends FlowPanel {
	TableMatchCreating tblCreating;
	TableMatchCreated tblCreated;
	Label lbCreated = new Label("Table"), lbCreating = new Label("Add New Match"), lbClearMatch = new Label(
			"Clear matches");
	long seasonId;
	List<Team> teams;
	List<Match> matches;
	Button btClearMatch = new Button("Clear Matches");

	public PanelSeasonMatch(List<Team> teams) {
		super();
		this.teams = teams;
		initTheme();
		initTable();
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
		tblCreated.setData(matches);
	}

	public void setSeasonId(long seasonId) {
		this.seasonId = seasonId;
	}

	private void initTheme() {
		CSSUtils.setBackgroundColor(this, "#DEDEDE");
		CSSUtils.setMarginTop(this, 20);
	}

	private void initTable() {
		initComponentClearMatch();
		initLabelCreating();
		initTableCreating();
		initLabelCreated();
		initTableCreated();
	}

	private void initComponentClearMatch() {
		CSSUtils.setFontSize(lbClearMatch, "medium");
		CSSUtils.setPadding(lbClearMatch, 10);
		add(lbClearMatch);
		
		HorizontalPanel hp = new HorizontalPanel();
		add(hp);
		btClearMatch.setPixelSize(250, 40);
		btClearMatch.getElement().getStyle().setMarginLeft(20, Unit.PX);
		btClearMatch.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				SystemManager.Service.league.clearMatchesOfSeason(seasonId,new AsyncCallback<Integer>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Delete fail " + caught.toString());

					}

					@Override
					public void onSuccess(Integer result) {
						Window.alert("Delete successful " + result + " matches");
						tblCreated.matchProvider.getList().clear();
					}
				});
			}
		});
		hp.add(btClearMatch);
		
		Label lbNotice = new Label("Becareful!");
		lbNotice.getElement().getStyle().setMarginLeft(40, Unit.PX);
		hp.add(lbNotice);
	}

	private void initLabelCreated() {
		CSSUtils.setFontSize(lbCreated, "medium");
		CSSUtils.setPadding(lbCreated, 10);
		add(lbCreated);
	}

	private void initLabelCreating() {
		CSSUtils.setFontSize(lbCreating, "medium");
		CSSUtils.setPadding(lbCreating, 10);
		add(lbCreating);
	}

	private void initTableCreated() {
		tblCreated = new TableMatchCreated(teams);
		add(tblCreated);

	}

	private void initTableCreating() {
		tblCreating = new TableMatchCreating(teams);
		tblCreating.setHeight("60px");

		add(tblCreating);
	}

	class TableMatchCreated extends TableMatch {

		public TableMatchCreated(List<Team> teams) {
			super(teams);
			addHandlerToSaveButton();
			CSSUtils.setMarginBottom(TableMatchCreated.this, 100);
		}

		private void addHandlerToSaveButton() {
			colSave.setFieldUpdater(new FieldUpdater<Match, String>() {

				@Override
				public void update(final int index, Match object, String value) {
					SystemManager.Service.league.saveMatch(object, seasonId, new AsyncCallback<Match>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Save Match fail : " + caught.toString());
						}

						@Override
						public void onSuccess(Match result) {
							Window.alert("Save match success ");
						}

					});
				}
			});
		}
	}

	class TableMatchCreating extends TableMatch {
		Column<Match, String> colCreate;
		Match matchTemp = new Match();

		public TableMatchCreating(List<Team> teams) {
			super(teams);
			init();
			setTempData();
		}

		private void setTempData() {
			matchTemp.id = 0L;
			if (PanelSeasonMatch.this.teams.size() > 1) {
				matchTemp.homeTeamId = teams.get(0).id;
				matchTemp.awayTeamId = teams.get(0).id;
			}
			ArrayList<Match> listScore = new ArrayList<Match>();
			listScore.add(matchTemp);
			setData(listScore);
		}

		private void init() {
			removeColumn(colId);
			removeColumn(colSave);
			removeColumn(colDelete);
			removeColumn(colStatus);
			removeColumn(colDate);
			removeColumn(colMinutes);
			removeColumn(colDetail);
			initColCreateButton();

		}

		private void initColCreateButton() {
			colCreate = new Column<Match, String>(new ButtonCell()) {

				@Override
				public String getValue(Match object) {
					return "Create";
				}
			};
			colCreate.setFieldUpdater(new FieldUpdater<Match, String>() {

				@Override
				public void update(int index, final Match object, String value) {
					object.id = null;
					Window.alert("Click");
					SystemManager.Service.league.saveMatch(object, seasonId, new AsyncCallback<Match>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Save match fail : " + caught.toString());
						}

						@Override
						public void onSuccess(Match result) {
							Window.alert("Save match success  ");
							ArrayList<Match> cloneList = new ArrayList<Match>();
							List<Match> targetList = tblCreated.matchProvider.getList();
							for (Match scoreInfo : targetList) {
								cloneList.add(scoreInfo);
							}
							cloneList.add(result);
							tblCreated.setData(cloneList);
						}

					});
				}
			});

			addColumn(colCreate, "Create");
		}
	}

}
