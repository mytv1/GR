package giddyhero.soccersystem.client.mobile.activities.games.knowledgechallenge;

import giddyhero.soccersystem.client.mobile.resources.ClientBundleMobile;
import giddyhero.soccersystem.client.share.CSSUtils;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.button.Button;
import com.googlecode.mgwt.ui.client.widget.carousel.Carousel;

public class PanelGamePlaying extends FlowPanel {

	Carousel carousel = new Carousel();

	public PanelGamePlaying() {
		super();
		add(carousel);
		setTempData();
	}

	private void setTempData() {
		CSSUtils.Mobile.setSizePercent(carousel, 1.0f, 0.9f);
		for (int i = 0; i < 20; i++) {
			PanelTest pnTest = new PanelTest(i);
			carousel.add(pnTest);
		}

	}

	class PanelTest extends VerticalPanel {
		VerticalPanel vpQuestion = new VerticalPanel(), vpAnswers = new VerticalPanel();
		HorizontalPanel hpButton = new HorizontalPanel();
		ArrayList<CheckBoxAnswer> listCheckBox = new ArrayList<CheckBoxAnswer>();
		Button btPrevious = new Button("Previous"), btNext = new Button("Next");
		Label lbQuestionNumber = new Label();
		int index = 0 ;
		
		public PanelTest(int questionNumber) {
			super();
			index = questionNumber;
			init();
			style();
			setTempData();
		}
		

		private void setTempData() {
			setQuestions(
					"https://s-media-cache-ak0.pinimg.com/736x/4f/8e/07/4f8e075c67b0309447e686c7f401a158.jpg",
					"The players on an association football team who play nearest to the opposing team's goal, and are therefore most responsible for scoring goals.");
			setAnswers("Striker", "Middlefield", "Center Back", "Goal Keepper");

		}
		

		private void init() {
			lbQuestionNumber.setText("Question "+(index+1));
			
			add(lbQuestionNumber);
			add(vpQuestion);
			add(vpAnswers);
			
			if (index > 0)
				btPrevious.addTapHandler(new TapHandler() {
					
					@Override
					public void onTap(TapEvent event) {
						carousel.setSelectedPage(index-1);
					}
				});
			else
				btPrevious.setVisible(false);
			if (index < 19)
				btNext.addTapHandler(new TapHandler() {
					
					@Override
					public void onTap(TapEvent event) {
						carousel.setSelectedPage(index+1);
					}
				});
			else
				btNext.setVisible(false);
			hpButton.add(btPrevious);
			hpButton.add(btNext);
			add(hpButton);
		}

		private void style() {
			CSSUtils.Mobile.setSizePercent(vpQuestion, 1.0f, 0.5f);
			CSSUtils.Mobile.setHeightPercent(vpAnswers,  0.2f);
			CSSUtils.Mobile.setHeightPercent(hpButton,  0.1f);
			
			CSSUtils.setMarginCenter(vpAnswers);
			CSSUtils.setMarginCenter(hpButton);
			
			CSSUtils.Mobile.setWidthPercent(btPrevious,  0.2f);
			CSSUtils.Mobile.setWidthPercent(btNext,  0.2f);
			
			lbQuestionNumber.addStyleName(ClientBundleMobile.INST.get().style().lbTitle());
		}

		public void setQuestions(String... datas) {
			for (String string : datas) {
				if (isImageLink(string))
					vpQuestion.add(new ImageQuestion(string));
				else
					vpQuestion.add(new LabelQuestion(string));
			}
		}

		private boolean isImageLink(String str) {
			if (str.contains(".jpg") || str.contains(".png") || str.contains(".jpeg"))
				return true;
			return false;
		}

		public void setAnswers(String... datas) {
			for (String string : datas) {
				CheckBoxAnswer cbAnswer = new CheckBoxAnswer(string);
				vpAnswers.add(cbAnswer);
				listCheckBox.add(cbAnswer);
			}
		}
	}

	class ImageQuestion extends Image {

		public ImageQuestion(String url) {
			super(url);
			style();
		}

		private void style() {
			addStyleName(ClientBundleMobile.INST.get().style().imgGameKCQuestion());
			CSSUtils.Mobile.setSizePercent(ImageQuestion.this, 0.9f, 0.2f);
		}

	}

	class LabelQuestion extends Label {

		public LabelQuestion(String str) {
			super(str);
			style();
		}

		private void style() {
			addStyleName(ClientBundleMobile.INST.get().style().lbGameKCQuestion());
		}
	}

	class CheckBoxAnswer extends CheckBox {

		public CheckBoxAnswer(String str) {
			super(str);
		}
	}

}
