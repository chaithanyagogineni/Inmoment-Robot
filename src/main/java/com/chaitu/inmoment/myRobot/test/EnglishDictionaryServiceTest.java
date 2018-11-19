package com.chaitu.inmoment.myRobot.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.chaitu.inmoment.myRobot.service.EnglishDictionaryService;

/*
 * This class performs the tests for the EnglishDictionaryServiceTest
 * 
 */
public class EnglishDictionaryServiceTest {

	//Test 1 to check the correctness of term with starting letter below 'm'
	@Test
	public void test_for_term_belowM() {
		EnglishDictionaryService service = new EnglishDictionaryService();
		String expected_definition ="";
		expected_definition=service.getTermDefiniton("Abide");
		assertEquals("To stand the consequences of; to answer for; to suffer for.Dearly I abide that boast so vain. Milton.",expected_definition);
		
	}
	//Test 2 to check the correctness of term with starting letter above 'm'
	@Test
	public void test_for_term_afterM() {
		EnglishDictionaryService service = new EnglishDictionaryService();
		String expected_definition ="";
	    expected_definition=service.getTermDefiniton("Zilla");
		assertEquals("A low, thorny, suffrutescent, crucifeous plant (Zillamyagroides) found in the deserts of Egypt. Its leaves are boiled inwater, and eaten, by the Arabs.",expected_definition);
	}

}
