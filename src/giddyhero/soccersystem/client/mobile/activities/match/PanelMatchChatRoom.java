package giddyhero.soccersystem.client.mobile.activities.match;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class PanelMatchChatRoom extends VerticalPanel {

	VerticalPanel vpChatAll = new VerticalPanel();
	ScrollPanel spChatAll = new ScrollPanel();
	HorizontalPanel hpChatting = new HorizontalPanel();
	Image imgIcon = new Image();
	TextBox tbChat = new TextBox();
	Button btSend = new Button("Send");
	static String OTHER_MESSAGER_CODE = "other";

	public PanelMatchChatRoom() {
		super();
		init();
		style();
		test();
	}

	private void test() {
		vpChatAll.add(new MessageMine("Hello Julian? Do you think Barca will win this game??"));
		vpChatAll.add(new MessageOther("Hi James, Barca has full team with full strong, i don't think they will be beaten!"));
		
	}

	private void style() {
		CSSUtils.Mobile.setSizePercent(spChatAll, 1f, 0.75f);
		CSSUtils.Mobile.setSizePercent(hpChatting, 1f, 0.05f);
		CSSUtils.Mobile.setSizePercent(tbChat, 0.7f, 0.05f);

		Style style = tbChat.getElement().getStyle();
		style.setMarginLeft(2, Unit.PCT);
		// CSSUtils.Mobile.setSizePercent(imgIcon, 0.1f, 0.05f);
		// CSSUtils.Mobile.setSizePercent(btSend, 0.1f, 0.05f);

	}

	private void init() {
		spChatAll.setWidget(vpChatAll);
		add(spChatAll);

		hpChatting.add(tbChat);
		imgIcon.setResource(ClientBundleMobile.INST.get().icSmile());
		hpChatting.add(imgIcon);

		btSend.addTapHandler(new TapHandler() {

			@Override
			public void onTap(TapEvent event) {
				String str = tbChat.getText();
				if (str.contains(OTHER_MESSAGER_CODE))
					{
						str = str.replace(OTHER_MESSAGER_CODE, "");
						vpChatAll.add(new MessageOther(str));
					}
				else
					{
						vpChatAll.add(new MessageMine(str));
					}
				tbChat.setText("");
			}
		});
		hpChatting.add(btSend);
		add(hpChatting);
	}

	class Message extends HorizontalPanel {
		protected Label lbName = new Label();
		protected Label lbContent = new Label();
		SimplePanel spName = new SimplePanel(lbName), spContent = new SimplePanel(lbContent);

		public Message(String name, String content) {
			super();
			init();
			style();
			lbName.setText(name);
			lbContent.setText(content);
		}

		private void init() {

		}

		private void style() {
			CSSUtils.Mobile.setWidthPercent(lbName, 0.2f);
			CSSUtils.Mobile.setWidthPercent(spContent, 0.65f);
			Style style = getElement().getStyle();
			style.setMarginTop(2, Unit.PCT);
			style.setMarginBottom(2, Unit.PCT);

			style = lbName.getElement().getStyle();
			style.setPaddingTop(10, Unit.PCT);
			style.setTextAlign(TextAlign.CENTER);
			style.setFontWeight(FontWeight.BOLD);
			lbName.addStyleName(ClientBundleMobile.INST.get().style().wordWrap());

			style = lbContent.getElement().getStyle();
			style.setPadding(3, Unit.PCT);
			style.setBackgroundColor("#ababab");
			lbContent.addStyleName(ClientBundleMobile.INST.get().style().wordWrap());

		}
	}

	class MessageMine extends Message {

		public MessageMine(String str) {
			super("Me", str);
			add(spContent);
			add(spName);
			style();
		}

		private void style() {
			Style style = getElement().getStyle();
			style.setMarginLeft(18, Unit.PCT);

			style = lbContent.getElement().getStyle();
			style.setTextAlign(TextAlign.RIGHT);
		}
	}

	class MessageOther extends Message {

		public MessageOther(String str) {
			super("Someone", str);
			add(spName);
			add(spContent);
			style();
		}

		private void style() {
			Style style = lbContent.getElement().getStyle();
			style.setTextAlign(TextAlign.LEFT);
		}
	}

}
