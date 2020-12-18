package Testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import p4_group_8_repo.InfoLabel;

public class InfoLabelTest extends ApplicationTest{
	InfoLabel infoText,infoNum;
	@Before
	public void set() {
		infoText = new InfoLabel("Text");
		infoNum = new InfoLabel(2);
	}
	
	@Test
	public void testText() {		
		assertEquals("Text",infoText.getText());
	}
	
	@Test
	public void testNumbers() {
		assertEquals("2",infoNum.getText());
	}
}
