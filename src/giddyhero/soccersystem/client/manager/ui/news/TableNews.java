package giddyhero.soccersystem.client.manager.ui.news;

import giddyhero.soccersystem.client.SystemManager;
import giddyhero.soccersystem.client.manager.ui.widget.ResizableImageCell;
import giddyhero.soccersystem.client.share.CSSUtils;
import giddyhero.soccersystem.shared.model.News;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;

public class TableNews extends DataGrid<News> {
	ListDataProvider<News> newsProvider = new ListDataProvider<>(News.KEY_PROVIDER);
	public Column<News, String> colHeight, colId, colAvatar, colName, colCategory, colTeam, colSave, colDelete,
			colAvatarUrl, colContent;
	List<News> news;
	String[] categories = new String[] { "Premier League", "Laliga", "Bundesliga", "UEFA Champion League", "V-League",
			"Transfer" };
	SingleSelectionModel<News> selectionModel;

	public TableNews() {
		super(News.KEY_PROVIDER);
		init();
		style();
	}

	private void style() {
		CSSUtils.setMarginCenter(this);
	}

	private void init() {
		initTableBase();
		getData();
	}

	protected void startInit() {
		initColumn();
	}

	private void getData() {
		startInit();

	}

	private void initColumn() {
		initCheckBoxColumn();
		initIdColumn();
		initTitleColumn();
		initTitleImageColumn();
		initTitleImageUrlColumn();
		// initEstablishYearColumn();
		initCategoryColumn();
		// initContentColumn();
		initSaveColumn();
		initDeleteColumn();
	}

	private void initCheckBoxColumn() {
		Column<News, Boolean> checkColumn = new Column<News, Boolean>(new CheckboxCell(true, false)) {
			@Override
			public Boolean getValue(News object) {
				return selectionModel.isSelected(object);
			}
		};
		addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
		setColumnWidth(checkColumn, 40, Unit.PX);
	}

	private void initContentColumn() {
		colContent = new Column<News, String>(new EditTextCell()) {

			@Override
			public String getValue(News object) {
				return object.content;
			}
		};
		colContent.setFieldUpdater(new FieldUpdater<News, String>() {

			@Override
			public void update(int index, News object, String value) {
				object.content = value;
				newsProvider.getList().set(index, object);
			}
		});
		addColumn(colContent, "Content");
	}

	private void initTitleImageUrlColumn() {
		colAvatarUrl = new Column<News, String>(new EditTextCell()) {

			@Override
			public String getValue(News object) {
				return object.titleImageUrl;
			}
		};
		colAvatarUrl.setFieldUpdater(new FieldUpdater<News, String>() {

			@Override
			public void update(int index, News object, String value) {
				object.titleImageUrl = value;
				newsProvider.getList().set(index, object);
			}
		});
		addColumn(colAvatarUrl, "Avatar Url");
	}

	//
	// private void initEstablishYearColumn() {
	// colEstablishYear = new Column<News, String>(new EditTextCell()) {
	//
	// @Override
	// public String getValue(News object) {
	// int year = object.establishYear;
	// return Integer.toString(year);
	// }
	// };
	// colEstablishYear.setFieldUpdater(new FieldUpdater<News, String>() {
	//
	// @Override
	// public void update(int index, News object, String value) {
	// object.establishYear = Integer.parseInt(value);
	// teamsProvider.getList().set(index, object);
	// }
	// });
	// addColumn(colEstablishYear, "Establish");
	// }

	private void initDeleteColumn() {
		colDelete = new Column<News, String>(new ButtonCell()) {

			@Override
			public String getValue(News object) {
				return "Delete";
			}
		};

		colDelete.setFieldUpdater(new FieldUpdater<News, String>() {

			@Override
			public void update(final int index, News object, String value) {
				SystemManager.Service.news.deleteNews(object.id, new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Delete player failure : " + caught.toString());
					}

					@Override
					public void onSuccess(Void result) {
						newsProvider.getList().remove(index);
						redraw();
					}
				});
			}
		});
		addColumn(colDelete, "Delete");
	}

	private void initSaveColumn() {
		colSave = new Column<News, String>(new ButtonCell()) {

			@Override
			public String getValue(News object) {
				return "Save";
			}
		};

		colSave.setFieldUpdater(new FieldUpdater<News, String>() {

			@Override
			public void update(final int index, News object, String value) {
				SystemManager.Service.news.saveNews(object, new AsyncCallback<News>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Save player fail " + caught.toString());
					}

					@Override
					public void onSuccess(News result) {
						Window.alert("Save player success : " + result.toString());
					}

				});
			}
		});
		addColumn(colSave, "Save");
	}

	private void initCategoryColumn() {
		ArrayList<String> listNation = new ArrayList<String>();
		for (String str : categories) {
			listNation.add(str);
		}
		SelectionCell selectionCell = new SelectionCell(listNation);
		colCategory = new Column<News, String>(selectionCell) {

			@Override
			public String getValue(News object) {
				return object.category;
			}
		};
		colCategory.setFieldUpdater(new FieldUpdater<News, String>() {

			@Override
			public void update(int index, News object, String value) {
				object.category = value;
				newsProvider.getList().set(index, object);
			}
		});
		addColumn(colCategory, "Category");
	}

	private void initTitleImageColumn() {

		ResizableImageCell imgCell = new ResizableImageCell("40px", "40px");
		colAvatar = new Column<News, String>(imgCell) {

			@Override
			public String getValue(News object) {
				return object.titleImageUrl;
			}
		};
		colAvatar.setFieldUpdater(new FieldUpdater<News, String>() {

			@Override
			public void update(int index, News object, String value) {
				object.titleImageUrl = value;
				newsProvider.getList().set(index, object);
			}
		});
		addColumn(colAvatar, "Avatar");
	}

	private void initTitleColumn() {
		colName = new Column<News, String>(new EditTextCell()) {

			@Override
			public String getValue(News object) {
				return object.title;
			}
		};
		colName.setFieldUpdater(new FieldUpdater<News, String>() {

			@Override
			public void update(int index, News object, String value) {
				object.title = value;
				newsProvider.getList().set(index, object);
			}
		});
		addColumn(colName, "Name");
	}

	private void initIdColumn() {
		colId = new Column<News, String>(new TextCell()) {

			@Override
			public String getValue(News object) {
				return object.id.toString();
			}
		};
		addColumn(colId, "Id");
	}

	private void initTableBase() {
		setSize("500px", "400px");
		ListHandler<News> sortHandler = new ListHandler<News>(newsProvider.getList());
		addColumnSortHandler(sortHandler);

		selectionModel = new SingleSelectionModel<News>(News.KEY_PROVIDER);
		setSelectionModel(selectionModel, DefaultSelectionEventManager.<News> createCheckboxManager());

		setEmptyTableWidget(new Label("Empty"));
		newsProvider.addDataDisplay(this);
		setFocus(false);
	}

	public void setData(List<News> listNews) {
		newsProvider.setList(listNews);
		setRowData(newsProvider.getList());
		redraw();
	}
}
