package giddyhero.soccersystem.client.manager.ui.widget;

import giddyhero.soccersystem.client.CSSClass;
import giddyhero.soccersystem.client.manager.widget.GHFlowPanel;
import giddyhero.soccersystem.client.manager.widget.GHLabel;
import giddyhero.soccersystem.client.manager.widget.GHTextArea;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.googlecode.mgwt.ui.client.widget.panel.flex.FlexPanel;

public class TableFormInput extends FlexTable{

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


	public class LabelStandard extends GHLabel{
		
		public LabelStandard(String name) {
			super(name);
			init();
		}

		private void init() {
			setFontWeight("bold");
		}
	}
	
	public class TextAreaStandard extends TextArea{
		
		public TextAreaStandard(String width, String height) {
			super();
			this.setSize(width, height);
		}
	}
	
	public class TextBoxStandard extends TextBox{
		
		public TextBoxStandard() {
			super();
			init();
		}
		
		public TextBoxStandard(String width) {
			this();
			this.setWidth(width);
		}
		
		public TextBoxStandard(String width, String height) {
			this();
			this.setSize(width, height);
		}
		
		private void init(){
			setWidth("90%");
		}
	}
	
}
