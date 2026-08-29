/**
* Lead Author(s):
* @author Alex Chow
* @author Allan Schougaard
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2026-05-03
*/
package edu.sdmesa.cisc191;

import javax.swing.JOptionPane;

/**
 * Purpose: The responsibility of GoneFishingGame is start the game running
 */
public class GoneFishingGame 
{
	/**
	 * Starts the game
	 * 
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		try
		{
			GoneFishingModel model = new GoneFishingModel();
			// Show the view
			GoneFishingView view = new GoneFishingView();
			// Start the game
			new GoneFishingController(model, view);
		}
		catch (Exception exception)
		{
			// TODO: Alert the user as to what went wrong using a message dialog
			// Hint: see the textbook excerpt supplied (yes, it has all the answers)
		}
	}
}
