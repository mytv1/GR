package giddyhero.soccersystem.client.mobile.widget;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;

import com.googlecode.mgwt.ui.client.widget.button.Button;

public class SSButton extends Button{

	public SSButton(String string) {
		super(string);
		addStyleName(ClientBundleMobile.INST.get().style().btSS());
	}
}
