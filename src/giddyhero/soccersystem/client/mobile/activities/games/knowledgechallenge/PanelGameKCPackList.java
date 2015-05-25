package giddyhero.soccersystem.client.mobile.activities.games.knowledgechallenge;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class PanelGameKCPackList extends VerticalPanel {

	public PanelGameKCPackList() {
		super();
		add(new PanelKnowledgePack(ClientBundleMobile.INST.get().gamePackNews(), "NEWS Pack",
				"Knowledge about recently news information"));
		add(new PanelKnowledgePack(ClientBundleMobile.INST.get().gamePackRule(), "Rule Pack",
				"Knowledge about your football rule"));
		add(new PanelKnowledgePack(ClientBundleMobile.INST.get().gamePackLeague(), "League Pack",
				"Knowledge about hottest league information"));
	}

	class PanelKnowledgePack extends FocusPanel {
		HorizontalPanel container = new HorizontalPanel();
		Image imgIcon = new Image();
		Label lbTitle = new Label(), lbDescription = new Label();

		public PanelKnowledgePack(ImageResource resource, String title, String description) {
			super();

			add(container);

			CSSUtils.Mobile.setWidthPercent(container, 0.95f);
			Style style = container.getElement().getStyle();
			style.setBorderStyle(BorderStyle.SOLID);
			style.setMargin(2, Unit.PCT);
			style.setBackgroundColor("lightgreen");

			style = imgIcon.getElement().getStyle();
			imgIcon.setResource(resource);
			container.add(imgIcon);
			CSSUtils.Mobile.setSizePercent(imgIcon, 0.25f, 0.15f);
			style.setPadding(5, Unit.PCT);

			VerticalPanel vp = new VerticalPanel();
			style = vp.getElement().getStyle();
			style.setPadding(5, Unit.PCT);
			container.add(vp);

			lbTitle.setText(title);
			style = lbTitle.getElement().getStyle();
			style.setFontWeight(FontWeight.BOLD);
			style.setFontSize(150, Unit.PCT);
			style.setTextAlign(TextAlign.CENTER);
			vp.add(lbTitle);

			lbDescription.setText(description);
			style = lbDescription.getElement().getStyle();
			style.setPadding(5, Unit.PCT);
			vp.add(lbDescription);

			container.add(new PanelPackInfo());

			addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					VerticalPanel parent = (VerticalPanel) PanelGameKCPackList.this.getParent();
					PanelGameKCPackList.this.removeFromParent();
					parent.add(new PanelGameStarting());
				}
			});
		}

		class PanelPackInfo extends VerticalPanel {
			Label lbPercent = new Label("80%"), lbQuesNum = new Label("Question : 20"),
					lbPoint = new Label("Point : 5"), lbTitle = new Label("Challenge");

			public PanelPackInfo() {
				super();
				CSSUtils.Mobile.setSizePercent(PanelPackInfo.this, 0.25f, 0.18f);
				Style style = getElement().getStyle();
//				style.setBorderStyle(BorderStyle.SOLID);
//				style.setBorderColor("#343434");
				style.setColor("white");
				style.setBackgroundColor("green");

				style = lbTitle.getElement().getStyle();
				style.setTextAlign(TextAlign.CENTER);
				add(lbTitle);

				style = lbPercent.getElement().getStyle();
				style.setTextAlign(TextAlign.CENTER);
				style.setFontSize(200, Unit.PCT);
				add(lbPercent);

				style = lbQuesNum.getElement().getStyle();
				style.setTextAlign(TextAlign.CENTER);
				add(lbQuesNum);

				style = lbPoint.getElement().getStyle();
				style.setTextAlign(TextAlign.CENTER);
				add(lbPoint);
			}
		}
	}

	
}
