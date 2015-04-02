package giddyhero.soccersystem.client.manager.ui.match;

import giddyhero.soccersystem.client.HistoryToken;
import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.Match;
import giddyhero.soccersystem.shared.model.Team;

import java.util.Date;
import java.util.List;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.datepicker.client.DateBox;

public class WindowCreateMatch extends FlowPanel {

	FormMatchCreate formMatchCreate = new FormMatchCreate();
	TableCreatedMatch tblCreatedMatch = new TableCreatedMatch();
	final int WIDTH = 1000;
	List<Team> teams;
	Button btCreate = new Button("Create");

	public WindowCreateMatch() {
		super();
		getAllTeam();
		init();
	}

	private void init() {
		setPixelSize(1100, 500);
		add(formMatchCreate);
		add(tblCreatedMatch);
		initCreateButton();
	}

	private void initCreateButton() {
		btCreate.setPixelSize(150, 50);
		btCreate.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Match[] matches = tblCreatedMatch.getAllMatch();
				SystemManager.Service.league.saveMatches(matches, new AsyncCallback<Integer>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Create match failure : "+caught.toString());
					}

					@Override
					public void onSuccess(Integer result) {
						Window.alert("Create "+result+" match success : ");						
					}
				});
			}
		});
		getElement().getStyle().setTextAlign(Style.TextAlign.CENTER);
//		CSSUtils.setMarginCenter(btCreate);
		add(btCreate);
	}

	private void getAllTeam() {
		SystemManager.Service.team.getAllTeams(new AsyncCallback<List<Team>>() {

			@Override
			public void onSuccess(List<Team> result) {
				Window.alert("get team : " + result.size());
				teams = result;
				formMatchCreate.pnTeamSelect.setData();
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("failure : " + caught.toString());
			}
		});
	}

	class FormMatchCreate extends FlexTable {
		public DateBox dateBox = new DateBox();
		public PanelTeamSelect pnTeamSelect;
		public Button btAdd = new Button("+");

		public FormMatchCreate() {
			super();
			init();
			style();
		}

		private void style() {
			Style style = getElement().getStyle();
			style.setBorderStyle(Style.BorderStyle.SOLID);
			style.setMargin(40, Unit.PX);
			style.setPadding(10, Unit.PX);
			style.setBackgroundColor(CSSUtils.COLOR_DIV);
			style.setTextAlign(TextAlign.CENTER);
			setWidth(WIDTH + "px");
		}

		private void init() {
			setText(0, 0, "Time");
			setText(0, 1, "Home vs Away");
			setText(0, 2, "Add");

			dateBox.setValue(new Date(0, 0, 0, 0, 0, 0));
			setWidget(1, 0, dateBox);
			
			pnTeamSelect = new PanelTeamSelect();
			setWidget(1, 1, pnTeamSelect);

			btAdd.setPixelSize(100, 30);
			btAdd.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					String homeTeamName = pnTeamSelect.lbxHome.getSelectedItemText();
					String awayTeamName = pnTeamSelect.lbxAway.getSelectedItemText();
					String homeTeamId = pnTeamSelect.lbxHome.getSelectedValue();
					String awayTeamId = pnTeamSelect.lbxAway.getSelectedValue();
					Window.alert("home : "+homeTeamName+" - "+homeTeamId+" away : "+awayTeamName+" - "+awayTeamId);
					tblCreatedMatch.addMatchColum(dateBox.getValue(), homeTeamName, homeTeamId, awayTeamName, awayTeamId);
				}
			});
			setWidget(1, 2, btAdd);
		}

	}

	class TableCreatedMatch extends FlexTable {

		public TableCreatedMatch() {
			super();
			init();
			style();
		}

		private void style() {
			Style style = getElement().getStyle();
			style.setMargin(40, Unit.PX);
			style.setPadding(10, Unit.PX);
			style.setBackgroundColor(CSSUtils.COLOR_DIV);
			style.setTextAlign(TextAlign.CENTER);
			setWidth(WIDTH + "px");
		}

		private void init() {
			setText(0, 0, "Index");
			setText(0, 1, "Time");
			setText(0, 2, "Home");
			setText(0, 3, "VS");
			setText(0, 4, "Away");
			setText(0, 5, "Delete");
		}

		public void addMatchColum(Date date, String homeTeamName, String homeTeamId, String awayTeamName,
				String awayTeamId) {
			int count = getRowCount();
			Button btDelete = new Button("Delete");
			final Label lbIndex = new Label(""+count);
			btDelete.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					int index = Integer.parseInt(lbIndex.getText());
					removeRowByCustomIndex(index);
				}
			});

			setWidget(count, 0, lbIndex);
			setText(count, 1, date.toString());
			setText(count, 2, "(" +homeTeamId+") "+ homeTeamName);
			setText(count, 3, " - ");
			setText(count, 4, "(" +awayTeamId+") "+ awayTeamName);
//			setText(count, 4,  awayTeamName+" (" +awayTeamId+") ");
			setWidget(count, 5, btDelete);
		}

		private void removeRowByCustomIndex(int index) {
			int row = getRowCount();
			for (int i = 1; i < row; i++) {
				Label lbIndex = (Label) getWidget(i, 0);
				String text = lbIndex.getText();
				if (text.equalsIgnoreCase("" + index)) {
					rearrange(i);
					removeRow(i);
					break;
				}
			}
		}

		private void rearrange(int fromIndex) {
			int row = getRowCount();
			for (int i = fromIndex + 1; i < row; i++) {
				{
					Label lbIndex = (Label) getWidget(i, 0);
					lbIndex.setText(""+(i-1));
				}
			}
		}
		
		public Match[] getAllMatch(){
			int row = getRowCount();
			Match[] matches = new Match[row-1];
//			Window.alert("get all match");
			for (int i = 1 ; i < row; i++) {
				{
//					Window.alert("row : "+i);
					String time = getText(i, 1);
					String homeTeamIdStr = (String)getText(i, 2) .subSequence(1, 17);
					String awayTeamIdStr = (String)getText(i, 4) .subSequence(1, 17);
					long homeTeamId = Long.parseLong(homeTeamIdStr);
					long awayTeamId = Long.parseLong(awayTeamIdStr);
//					Window.alert("home : "+homeTeamIdStr+" -- "+homeTeamId+"  --------------- away : "+awayTeamIdStr+" -- "+awayTeamId);
					long seasonId = HistoryToken.Utils.getSeasonIdFromMatchCreateToken();
					Match match = new Match(time, homeTeamId, awayTeamId, seasonId);
					matches[i-1] = match;
				}
			}
			return matches;
		}

	}

	class PanelTeamSelect extends HorizontalPanel {
		ListBox lbxHome = new ListBox(), lbxAway = new ListBox();
		Label lbVs = new Label(" vs ");

		public PanelTeamSelect() {
			super();
			style();
			init();
		}

		private void style() {
			CSSUtils.setMarginCenter(PanelTeamSelect.this);
			Style style = lbVs.getElement().getStyle();
			style.setMarginLeft(40, Unit.PX);
			style.setMarginRight(40, Unit.PX);
		}

		public void init() {
			add(lbxHome);

			add(lbVs);

			add(lbxAway);
		}

		public void setData() {
			for (Team team : teams) {
				lbxHome.addItem(team.name, "" + team.id);
				lbxAway.addItem(team.name, "" + team.id);
			}
		}

	}

}
