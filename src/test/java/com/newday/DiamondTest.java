package com.newday;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DiamondTest {
	
	private Diamond diamond;
	private String diamondString = """
  A  |
 B B |
C   C|
 B B |
  A  |
""".replace("|\n", "\n");

	@Before
	public void setUp() throws Exception {
		diamond = new Diamond();
	}

	@Test
	public void testGetLetterPosition() {
		assertEquals(Integer.valueOf(1), Integer.valueOf(diamond.getLetterPosition("B")));
	}
	
	@Test
	public void testCharacterSequenceInline() {
		assertEquals("  A  \n B B \nC   C\n B B \n  A  \n", diamond.print("C"));
	}
	
	@Test
	public void testCharacterSequence() {
		assertEquals(diamondString, diamond.print("C"));
	}

}
