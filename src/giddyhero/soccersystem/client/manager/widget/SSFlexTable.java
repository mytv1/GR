package giddyhero.soccersystem.client.manager.widget;

import giddyhero.soccersystem.client.manager.resources.SSClientBundleBaseThemeManager;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ToggleButton;

public class SSFlexTable extends FlexTable {

	public SSFlexTable() {
		super();
		init();
	}

	private void init() {
		setWidth("100%");
	}

	public ActionPanel createActionPanelIn(int row, int col) {
		ActionPanel actionPanel = new ActionPanel();
		setWidget(row, col, actionPanel);
		return actionPanel;
	}

	public class ActionPanel extends HorizontalPanel {
		public ActionButton btEdit = new ActionButton(SSClientBundleBaseThemeManager.IMPL.getBundle().editIc());
		public ActionButton btDelete = new ActionButton(SSClientBundleBaseThemeManager.IMPL.getBundle().deleteIc());

		public ActionPanel() {
			super();
			add(btEdit);
			add(btDelete);
			style();
		}

		private void style() {
			Style style = getElement().getStyle();
			style.setProperty("marginLeft", "auto");
			style.setProperty("marginRight", "auto");
		}
	}

	public class ActionButton extends ToggleButton {

		
		public ActionButton(ImageResource imgResource) {
			super(new Image(imgResource));
			style();
		}

		private void style() {
			setPixelSize(40, 40);
			Style style = getElement().getStyle();
			style.setMarginLeft(10, Unit.PX);
			style.setMarginRight(10, Unit.PX);
		}
	}


	public class LabelStandard extends Label {

		public LabelStandard(String name) {
			super(name);
			init();
		}

		private void init() {
			CSSUtils.setFontWeight(this, "bold");
			// getElement().getStyle().setProperty("fontWeight", "bold");
		}
	}

	public class TextAreaStandard extends TextArea {

		public TextAreaStandard(String width, String height) {
			super();
			this.setSize(width, height);
		}
	}

	public class TextBoxStandard extends TextBox {

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

		private void init() {
			setWidth("90%");
		}
	}
}
