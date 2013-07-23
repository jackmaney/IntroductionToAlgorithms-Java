package com.jackmaney.IntroductionToAlgorithms.Chapter2;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class BinaryIntegerTest {
	
	@Test
	public void BasicTest() {
		
		int[] bits = {0,1,1,0,1};
		BinaryInteger b = new BinaryInteger(bits);
		assertTrue(b instanceof BinaryInteger);
		assertTrue(b.getNumberOfBits() == 5);
		assertTrue(b.toString().equals("0110 1"));
		assertTrue(b.asInt() == 13);
		
	}
	
	@Test
	public void AddTest() {
		
		int[] bits = {0,1,1,0,1};
		BinaryInteger b = new BinaryInteger(bits);
		
		int[] negBits = {1,1,0,0,1};
		BinaryInteger c = new BinaryInteger(negBits);
		assertTrue(c.add(b).asInt() == 6);
	}
	
	@Test
	public void IntConstructorTest() {
		BinaryInteger b = new BinaryInteger(12,8);
		int[] expected = {0,0,0,0,1,1,0,0};
		assertTrue(Arrays.equals(b.getBitArray(), expected));
	}
	
	@Test
	public void ZeroTest() {
		BinaryInteger z = new BinaryInteger(0,8);
		int[] expectedZero = {0,0,0,0,0,0,0,0};
		BinaryInteger ez = new BinaryInteger(expectedZero);
		
		assertTrue(z.equals(ez));
		assertTrue(z.complement().equals(z));
	}
	
	@Test
	public void ComplementTest(){
		BinaryInteger b = new BinaryInteger(81,8);
		assertTrue(b.complement().equals(new BinaryInteger(-81,8)));
	}

}
