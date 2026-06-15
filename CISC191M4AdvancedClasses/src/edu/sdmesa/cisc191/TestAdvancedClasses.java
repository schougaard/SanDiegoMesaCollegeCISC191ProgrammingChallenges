package edu.sdmesa.cisc191;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Lead Author(s):
 * 
 * @author Tasha Frankie
 * @author Allan Schougaard
 * 
 *         Other contributors:
 *         None
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
 *         Version/date: 1.0
 * 
 *         Responsibilities of class:
 *         Test class and methods to support a push bike shop
 */

/**
 * Your mission, should you choose to accept it:
 * 
 * For each of the test methods below create a method in a class that
 * makes the test run and pass.
 * 
 * Each class must be in a separate file. Use File -> New -> Class
 * 
 * Read the test methods to understand what the classes' methods
 * should do. The assertEquals methods check to see if the two arguments are
 * equal. If they are equal the test passes; if not, the test will be marked as
 * failed and the execution stops.
 * 
 * To run the tests in this file from the main menu, select Run -> Run As ->
 * JUnit
 * with the file selected.
 * 
 * To implement a test method:
 * 
 * 1. Uncomment the entire test method. To uncomment a block, select the block
 * and hold down Ctrl while typing /
 * 
 * 2. To make the test compile and run: implement a method with the correct
 * signature, but returning a fake value, such as -1, null or similar. After
 * this the test method should run but fail.
 * 
 * 3. To make the tests pass: Then change the method to return the correct value
 * and run the test again.
 * 
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestAdvancedClasses
{

	@Test
	@Order(1)
	void testInheritance1()
	{
		// A unicycle is-a cycle with one wheel

		Unicycle unicycle1 = new Unicycle("Uni");
		assertEquals(1, unicycle1.getNumberOfWheels());
		assertEquals("Uni", unicycle1.getMake());
		assertEquals("Uni1", unicycle1.getFrameNumber());

		Cycle unicycle2 = new Unicycle("Uni");
		assertEquals(1, unicycle2.getNumberOfWheels());
		assertEquals("Uni", unicycle2.getMake());
		assertEquals("Uni2", unicycle2.getFrameNumber());
	}

//	@Test
//	@Order(2)
//	void testInheritance2()
//	{
//		// A bicycle is-a cycle with two wheels
//
//		Bicycle bicycle1 = new Bicycle("Tooney");
//		assertEquals(2, bicycle1.getNumberOfWheels());
//		assertEquals("Tooney", bicycle1.getMake());
//		assertEquals("Tooney3", bicycle1.getFrameNumber());
//
//		Cycle bicycle2 = new Bicycle("Tooney");
//		assertEquals(2, bicycle2.getNumberOfWheels());
//		assertEquals("Tooney", bicycle2.getMake());
//		assertEquals("Tooney4", bicycle2.getFrameNumber());
//	}
//
//	@Test
//	@Order(3)
//	void testInheritance3()
//	{
//		// An electronic mountain bike is-a bicycle
//
//		EletricMountainBike eBike1 = new EletricMountainBike("eBike");
//		assertEquals(2, eBike1.getNumberOfWheels());
//		assertEquals("eBike", eBike1.getMake());
//		assertEquals("eBike5", eBike1.getFrameNumber());
//
//		Bicycle eBike2 = new EletricMountainBike("Bik-E");
//		assertEquals(2, eBike2.getNumberOfWheels());
//		assertEquals("Bik-E", eBike2.getMake());
//		assertEquals("Bik-E6", eBike2.getFrameNumber());
//	}
//
//	@Test
//	@Order(4)
//	void testInheritance4()
//	{
//		// Implement that: A unicycle is-a cycle and a cycle has-a color
//		// Hint:
//		// Where is the best class to implement color, so you do not have to
//		// repeat code in multiple classes?
//
//		Unicycle unicycle1 = new Unicycle("Uni");
//		unicycle1.setColor(Color.RED);
//		assertEquals(1, unicycle1.getNumberOfWheels());
//		assertEquals("Uni", unicycle1.getMake());
//		assertEquals(Color.RED, unicycle1.getColor());
//
//		Bicycle bicycle1 = new Bicycle("Tooney");
//		bicycle1.setColor(Color.BLUE);
//		assertEquals(2, bicycle1.getNumberOfWheels());
//		assertEquals("Tooney", bicycle1.getMake());
//		assertEquals(Color.BLUE, bicycle1.getColor());
//
//		Cycle cycle1 = new Unicycle("Uni");
//		cycle1.setColor(Color.CYAN);
//		assertEquals(1, cycle1.getNumberOfWheels());
//		assertEquals("Uni", cycle1.getMake());
//		assertEquals(Color.CYAN, cycle1.getColor());
//
//		Cycle cycle2 = new Bicycle("Tooney");
//		cycle2.setColor(Color.GREEN);
//		assertEquals(2, cycle2.getNumberOfWheels());
//		assertEquals("Tooney", cycle2.getMake());
//		assertEquals(Color.GREEN, cycle2.getColor());
//
//		// An electric mountain bike is-a cycle
//		Cycle eBike = new ElectricMountainBike("EMB");
//		assertEquals("EMB", eBike.getMake());
//		assertEquals("EMB3", eBike.getFrameNumber());
//		eBike.setColor(Color.RED);
//		assertEquals(Color.RED, eBike.getColor());
//		// An electric mountain bike is-a cycle with two wheels,
//		// also known as a ...
//		// Hint: use inheritance so you do not have to write any new code
//		assertEquals(2, eBike.getNumberOfWheels());
//	}
//
//	@Test
//	@Order(5)
//	void testToString()
//	{
//		// toString returns the frame number and the color
//		// Where can we conveniently implement toString?
//		Cycle cycle1 = new Unicycle("Uni");
//		cycle1.setColor(Color.RED);
//		assertTrue(cycle1.toString().startsWith(cycle1.getFrameNumber()));
//		assertTrue(cycle1.toString().endsWith(Color.RED.toString()));
//
//		Cycle cycle2 = new Bicycle("Bic");
//		cycle2.setColor(Color.BLUE);
//		assertTrue(cycle1.toString().startsWith(cycle1.getFrameNumber()));
//		assertTrue(cycle2.toString().endsWith(Color.BLUE.toString()));
//
//		// Since toString contains the frame number, the strings should be
//		// different
//		assertNotEquals(cycle1.toString(), cycle2.toString());
//	}
//
//	@Test
//	@Order(6)
//	void testEquals()
//	{
//		Cycle cycle1 = new Unicycle("Uni");
//		cycle1.setColor(Color.WHITE);
//		Cycle cycle2 = new Unicycle("Uni");
//		cycle2.setColor(Color.WHITE);
//		Cycle cycle3 = cycle1;
//
//		// Cycles are "equal" if their frame "numbers" are the same
//		// Because different cycles have different frame numbers:
//		assertNotEquals(cycle1.getFrameNumber(), cycle2.getFrameNumber());
//
//		assertTrue(cycle1.equals(cycle1));
//		assertFalse(cycle1.equals(cycle2));
//		assertFalse(cycle2.equals(cycle1));
//		assertTrue(cycle1.equals(cycle3));
//		assertTrue(cycle3.equals(cycle1));
//
//		assertFalse(cycle1.equals("Not a bike"));
//		assertFalse(cycle1.equals(null));
//
//		Bicycle bike1 = new Bicycle("Toony");
//		bike1.setColor(Color.RED);
//		Bicycle bike2 = new Bicycle("Toony");
//		bike2.setColor(Color.RED);
//
//		assertTrue(bike1.equals(bike1));
//		assertFalse(bike1.equals(bike2));
//		assertFalse(bike2.equals(bike1));
//		assertFalse(bike1.equals("Not a bike"));
//		assertFalse(bike1.equals(null));
//
//		assertFalse(cycle1.equals(bike2));
//		assertFalse(bike1.equals(cycle2));
//	}
//
//	@Test
//	@Order(7)
//	void testGearable()
//	{
//		Gearable conveyance = new ElectricMountainBike("EMBG");
//		// toString is one of the few methods all objects respond to
//		// and we have implemented our own in Cycle which includes the make
//		assertTrue(conveyance.toString().contains("EMBG"));
//
//		assertEquals(1, conveyance.getGear());
//		conveyance.gearUp();
//		assertEquals(2, conveyance.getGear());
//		conveyance.gearUp();
//		assertEquals(3, conveyance.getGear());
//		conveyance.gearDown();
//		assertEquals(2, conveyance.getGear());
//		conveyance.gearDown();
//		assertEquals(1, conveyance.getGear());
//		conveyance.gearDown();
//		assertEquals(1, conveyance.getGear());
//	}
//
//	@Test
//	@Order(8)
//	void testMovable()
//	{
//		Movable conveyance = new ElectricMountainBike("EMBM");
//		assertTrue(conveyance.toString().contains("ENMBM"));
//
//		assertEquals(0, conveyance.getSpeed());
//		conveyance.speedUp();
//		assertEquals(1, conveyance.getSpeed());
//		conveyance.speedUp();
//		assertEquals(2, conveyance.getSpeed());
//		conveyance.speedUp();
//		conveyance.speedUp();
//		conveyance.speedUp();
//		assertEquals(5, conveyance.getSpeed());
//		conveyance.slowDown();
//		assertEquals(3, conveyance.getSpeed());
//		conveyance.slowDown();
//		assertEquals(1, conveyance.getSpeed());
//		conveyance.slowDown();
//		assertEquals(0, conveyance.getSpeed());
//		conveyance.slowDown();
//		assertEquals(0, conveyance.getSpeed());
//	}
//
//	@Test
//	@Order(9)
//	void testChargable()
//	{
//		Chargeable conveyance = new ElectricMountainBike("EMBC");
//		assertTrue(conveyance.toString().contains("EMBC"));
//
//		assertEquals(0, conveyance.getCharge());
//		conveyance.chargeTo(80);
//		assertEquals(80, conveyance.getCharge());
//		conveyance.chargeTo(100);
//		assertEquals(100, conveyance.getCharge());
//		conveyance.chargeTo(120);
//		assertEquals(100, conveyance.getCharge());
//	}
//
//	@Test
//	@Order(10)
//	void testDynamicBinding()
//	{
//		BikeShop shop = new BikeShop("Joe's Bike Rack");
//		assertEquals("Joe's Bike Rack", shop.getName());
//		assertTrue(shop.toString().contains("Joe's Bike Rack"));
//
//		// Model that a bike shop has-many cycles
//		// Hint: if you are using a has-many relationship the variable name
//		// should be plural
//		// Make sure the bike shop can have at least 10 cycles.
//		assertEquals(0, shop.getNumberOfCyclesInStock());
//		assertTrue(shop.toString()
//				.contains("We are currently sold out - check back soon!"));
//
//		// You can use this to print out the data (can you see why it works?):
//		// System.out.println(shop);
//
//		ElectricMountainBike conveyance1 = new ElectricMountainBike(
//				"BigMountainBike");
//		shop.addToInventory(conveyance1);
//		assertEquals(1, shop.getNumberOfCyclesInStock());
//		assertTrue(shop.toString()
//				.contains("We have the following cycle(s) for sale:"));
//		assertFalse(shop.toString()
//				.contains("We are currently sold out - check back soon!"));
//		assertTrue(shop.toString().contains(conveyance1.toString()));
//
//		Unicycle conveyance2 = new Unicycle("Ooney");
//		shop.addCycle(conveyance2);
//		assertEquals(2, shop.getNumberOfCyclesInStock());
//		assertTrue(shop.toString().contains(conveyance2.toString()));
//		assertTrue(shop.toString().contains(conveyance1.toString()));
//
//		Bicycle conveyance3 = new Bicycle("Tooney");
//		shop.addCycle(conveyance3);
//		assertEquals(3, shop.getNumberOfCyclesInStock());
//		assertTrue(shop.toString().contains(conveyance3.toString()));
//		assertTrue(shop.toString().contains(conveyance2.toString()));
//		assertTrue(shop.toString().contains(conveyance1.toString()));
//
//		Cycle conveyance4 = new ElectricMountainBike("SmallMountainBike");
//		shop.addCycle(conveyance4);
//		assertEquals(4, shop.getNumberOfCyclesInStock());
//		assertTrue(shop.toString().contains(conveyance4.toString()));
//		assertTrue(shop.toString().contains(conveyance3.toString()));
//		assertTrue(shop.toString().contains(conveyance2.toString()));
//		assertTrue(shop.toString().contains(conveyance1.toString()));
//	}

}
