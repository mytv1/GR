package giddyhero.soccersystem.client.manager.ui.widget;

import giddyhero.soccersystem.client.CSSClass;
import giddyhero.soccersystem.client.manager.widget.SSFlexTable;

public class TableFormInput extends SSFlexTable{

	public TableFormInput() {
		super();
		init();
	}
	
	
	private void init() {
		setStyleName(CSSClass.TABLE_FORM_INPUT);
		setWidth("100%");
		ColumnFormatter columFormatter = new ColumnFormatter();
		columFormatter.setWidth(0, "100px");
		setColumnFormatter(columFormatter);
	}

}
