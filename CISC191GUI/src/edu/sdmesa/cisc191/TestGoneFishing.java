package edu.sdmesa.cisc191;

/**
 * Lead Author(s):
 * 
 * @author Tasha Frankie
 * @author Allan Schougaard
 * @author Alex Chow
 * 
 *         Other contributors:
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         Bechtold, S., Brannen, S., Link, J., Merdes, M., Philipp, M.,
 *         Rancourt, J. D., & Stein, C. (n.d.).
 *         JUnit 5 user guide. JUnit 5.
 *         https://junit.org/junit5/docs/current/user-guide/
 * 
 *         Version/date: 2.0
 * 
 *         Responsibilities of class:
 *         Test the Gone Fishing Game's non-visual implementation
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.event.*;

class TestGoneFishing
{

	@Test
	void testGoneFishingModel()
	{
		GoneFishingModel model = new GoneFishingModel();
		assertEquals(10, model.getFishRemaining());
		assertEquals(30, model.getTriesRemaining());
		assertFalse(model.fishWin());
		assertFalse(model.playerWins());
		assertFalse(model.isGameOver());

		model.fishAt(0, 0);
		assertTrue(model.getFishRemaining() >= 9);
		assertEquals(29, model.getTriesRemaining());
		assertFalse(model.fishWin());
		assertFalse(model.playerWins());
		assertFalse(model.isGameOver());

		model.fishAt(5, 5);
		assertTrue(model.getFishRemaining() >= 8);
		assertEquals(28, model.getTriesRemaining());
		assertFalse(model.fishWin());
		assertFalse(model.playerWins());
		assertFalse(model.isGameOver());

		// New model, fish 30 times maybe
		model = new GoneFishingModel();
		for (int row = 0; row < 6; row++)
		{
			for (int column = 0; column < 5; column++)
			{
				if (!model.isGameOver())
				{
					model.fishAt(row, column);
				}
			}
		}

		assertTrue(model.getFishRemaining() >= 0);
		assertTrue(model.getTriesRemaining() >= 0);
		assertTrue(model.playerWins() || model.fishWin());
		assertTrue(model.isGameOver());
	}

	@Test
	void testFishingButton()
	{
		FishingButton fishingButton = new FishingButton(1, 2);
		assertEquals(1, fishingButton.getRow());
		assertEquals(2, fishingButton.getColumn());

		assertTrue(fishingButton instanceof JButton);

		// Remember what the button looks like before we click on it
		String buttonTextBefore = fishingButton.getText();
		fishingButton.reveal(true);
		// When revealed the button should change to a fish
		String fishText = fishingButton.getText();
		assertNotEquals(fishText, buttonTextBefore);
		// When revealed the button should change to not-fish
		fishingButton.reveal(false);
		assertNotEquals(fishingButton.getText(), buttonTextBefore);
		assertNotEquals(fishingButton.getText(), fishText);
	}

	@Test 
	void testGoneFishingView()
	{
		GoneFishingView view = new GoneFishingView();
		assertTrue(view instanceof JFrame);

		// We cannot check what the GUI looks like,
		// only that we can call the methods
		view.setMaxFish(10);
		view.setMaxTries(30);
		view.updateFishRemaining(11);
		view.updateTriesRemaining(10);
	}

	@Test
	void testGoneFishingController()
	{
		GoneFishingModel model = new GoneFishingModel();
		GoneFishingView view = new GoneFishingView();
		GoneFishingController controller = new GoneFishingController(model,
				view);

		FishingButton button = new FishingButton(1, 2);
		String buttonTextBefore = button.getText();
		
		// Button should be revealed
		controller.onFishingButtonClicked(button);
		// When revealed the button should change
		assertNotEquals(button.getText(), buttonTextBefore);
		// There should be one less tries remaining
		assertEquals(29, model.getTriesRemaining());
		// There should be nine or ten fish remaining depending on whether we
		// caught anything.
		assertTrue(model.getFishRemaining() == 10
				|| model.getFishRemaining() == 9);
	}

	@Test
	void testGoneFishingButtonListener()
	{
		GoneFishingModel model = new GoneFishingModel();
		GoneFishingView view = new GoneFishingView();
		GoneFishingController controller = new GoneFishingController(model,
				view);
		FishingButton fishingButton = new FishingButton(1, 2);
		FishingButtonListener listener = new FishingButtonListener(controller,
				fishingButton);
		String buttonTextBefore = fishingButton.getText();
		// Click the button
		fishingButton.doClick();
		// Button text should change
		assertNotEquals(buttonTextBefore, fishingButton.getText());
		// There should be one less tries remaining
		assertEquals(29, model.getTriesRemaining());
		// There should be nine or ten fish remaining depending on whether we
		// caught anything.
		assertTrue(model.getFishRemaining() == 10
				|| model.getFishRemaining() == 9);
	}

	@Test
	void testTriesAndFishRemaining()
	{
		GoneFishingModel model = new GoneFishingModel();
		GoneFishingView view = new GoneFishingView();
		GoneFishingController controller = new GoneFishingController(model,
				view);

		int triesRemaining = model.getTriesRemaining();

		// Click each button if possible until we run out of tries
		for (int i = 0; i < GoneFishingModel.DIMENSION; i++)
		{
			for (int j = 0; j < GoneFishingModel.DIMENSION; j++)
			{
				if (!model.isGameOver())
				{
					// Manually inject buttons with listeners
					FishingButton fishingButton = new FishingButton(i, j);
					FishingButtonListener listener = new FishingButtonListener(
							controller, fishingButton);
					// Click a button, use a try
					fishingButton.doClick();
					triesRemaining--;
					assertEquals(triesRemaining, model.getTriesRemaining());
				}
			}
		}

		assertEquals(0, model.getTriesRemaining());
		// There are at least six positions not checked,
		// so there can be at most six fish left
		assertTrue(model.getFishRemaining() <= 6);
	}

	@Test
	void testGoneFishingButtonShouldntBeClickedTwice()
	{
		GoneFishingModel model = new GoneFishingModel();
		GoneFishingView view = new GoneFishingView();
		GoneFishingController controller = new GoneFishingController(model,
				view);

		FishingButton fishingButton = new FishingButton(2, 1);
		FishingButtonListener listener = new FishingButtonListener(controller,
				fishingButton);

		// Simulate a click
		fishingButton.doClick();
		int triesAfterFirstClick = model.getTriesRemaining();
		// Simulate a click on the same button
		fishingButton.doClick();
		int triesAfterSecondClick = model.getTriesRemaining();
		// Second click should not change anything
		assertEquals(triesAfterFirstClick, triesAfterSecondClick);
	}
}
