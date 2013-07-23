package com.jackmaney.IntroductionToAlgorithms.Chapter2;

/**
 * This class represents an integer as an array of zeroes and ones
 * and is used in Exercise 2.1-4 of Introduction to Algorithms.
 * 
 * <strong>Note:</strong> We are using two's complement binary representations.
 * @author jack.maney
 *
 */
public class BinaryInteger extends Number{

	private int numberOfBits;
	private int[] bitArray;
	
	public BinaryInteger(int[] array){
		
		checkArray(array);
		
		this.bitArray = array;
		this.numberOfBits = array.length;
		
	}
	
	public BinaryInteger(int n,int numberOfBits){
		
		this.bitArray = intToBitArray(n, numberOfBits);
		this.numberOfBits = numberOfBits;
		
	}
	
	public BinaryInteger(int n){
		this(n,32);
	}
	
	public static int[] intToBitArray(int n,int numberOfBits){
		
		if(numberOfBits <= 0){
			throw new IllegalArgumentException("Can't have a negative number of bits!");
		}
		else if(numberOfBits > 32){
			throw new IllegalArgumentException("Sorry, 32 bits or less...this isn't BigInteger, pal!");
		}
		
		
		
		if(
			(n < -1 * Math.pow(2, numberOfBits - 1))
			||
			(n > Math.pow(2, numberOfBits - 1) - 1)
		){
			throw new IllegalArgumentException("Can't express " 
					+ n + " using " + numberOfBits + " bits");
		}
		
		int[] result = new int[numberOfBits];
		
		for(int i = 0; i < numberOfBits; i++){
			result[i] = 0;
		}
		
		if(n > 0){
			
			//We iteratively subtract powers of 2 from n...
			
			while(n > 0){
				
				//find largest power of 2 that is less than n:
				int powerOfTwo = 1;
				
				for(int i = 0; i <= Math.ceil(Math.log(n)/Math.log(2));i++){
					if(2 * powerOfTwo > n){
						break;
					}
					else{
						powerOfTwo *= 2;
					}
				}
				
				result[(int)(Math.log(powerOfTwo)/Math.log(2))] = 1;
				
				n -= powerOfTwo;
			}
			
			//Just one problem...we're counting the bits in the wrong order!
			//e.g. the ones place should be on the right end, not the left!
			
			for(int i = 0; i <= (float)(n-1)/2; i++){
				int temp = result[i];
				result[i] = result[result.length - i];
				result[result.length - i] = temp;
			}
				
		}
		else if(n < 0){
			//We'll cheat a bit and use the int[] constructor
			//along with the complement() method.
			
			int[] bitsForNegN = intToBitArray(-n, numberOfBits);
			
			BinaryInteger negN = new BinaryInteger(bitsForNegN);
			
			result = negN.complement().getBitArray();	
		}
		
		return result;
		
	}
	
	private void checkArray(int[] array){
		for(int i = 0; i < array.length; i++){
			if(array[i] != 1 && array[i] != 0){
				throw new IllegalArgumentException();
			}
		}
	}
	
	public BinaryInteger add(BinaryInteger other){
		
		if(getN() != other.getN()){
			throw new IllegalArgumentException();
		}
		
		int[] bits = new int[getN()];
		
		int carryOver = 0;
		
		for(int i = getN() - 1; i >= 0; i--){
			
			int bit = getBitArray()[i];
			int otherBit = getBitArray()[i];
			
			if(bit == 1 && otherBit == 1){
				bits[i] = 0;
				carryOver++;
			}
			else if(carryOver > 0){
				if(bit + otherBit == 1){
					bits[i] = 0;
				}
				else{
					bits[i] = 1;
					carryOver--;
				}
			}
			else{
				bits[i] = bit + otherBit;
			}
		}
		
		return new BinaryInteger(bits);
	}
	
	public BinaryInteger complement(){
		
		int[] bits = new int[getN()];
		
		for(int i = 0; i < getN(); i++){
			bits[i] = getBitArray()[i] == 1 ? 0 : 1;
		}
		
		BinaryInteger result = new BinaryInteger(bits);
		
		BinaryInteger one = new BinaryInteger(1);
		
		return result.add(one);
	}
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < getN(); i++){
			sb.append(getBitArray()[i]);
			
			if(i % 4 == 3){
				sb.append(" ");
			}
		}
		
		return sb.toString();
		
	}
	
	
	
	/**
	 * @return the n
	 */
	public int getN() {
		return numberOfBits;
	}


	/**
	 * @return the bitArray
	 */
	public int[] getBitArray() {
		return bitArray;
	}



	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return numberOfBits;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return (long)numberOfBits;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return (float)numberOfBits;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return (double)numberOfBits;
	}

}
