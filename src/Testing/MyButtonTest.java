package Testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import p4_group_8_repo.MyButton;

public class MyButtonTest extends ApplicationTest{
	MyButton btn1, btn2;
	
	@Before
	public void set() {
		btn1 = new MyButton("ButtonName",25);
		btn2 = new MyButton("file:src/p4_group_8_repo/BackButton2.png",20,50);
	}
	@Test
	public void testButtonName() {
		assertEquals("ButtonName",btn1.getText());
	}
	
	@Test
	public void testLayoutXandY() {
		assertTrue(20==btn2.getLayoutX());
		assertFalse(50!=btn2.getLayoutY());
	}

}
