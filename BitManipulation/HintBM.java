package cracking.code.interviewQ.BitManipulation;

public class HintBM {
	
	/*
	 * Two's complement and negative number
	 * 
	 * Logical Right Shift;
	 * -------------------
	 * 	=> We shift the bits and put a 0 in the most significant bit, which is indicated with a >>> operator.
	 * 
	 * Arithmetic Right Shift;
	 * ---------------------
	 * => We shift values to the right but fill in the new bits with the value of the sign bit, which is indicated by a
	 * >> operator
	 * 
	 *  for Arithmetic Right Shift >> append new bits with the value of sign bit in the Most Significant Bit. 
	 *  for Arithmetic Left Shift  << append new bits with the value of 0 in the Least Significant Bit.
	 *  
	 * Common Bit Tasks: Getting and Setting
	 * 
	 * n &(n-1) == 0 indicates
	 * When you subtract 1 from a number, you look at the least significant bit. If it's a 1 you change it to 0, and you
	   are done. If it's a zero, you must "borrow" from a larger bit. So, you go to increasingly larger bits, changing
	   each bit from a Oto a 1, until you find a 1. You flip that 1 to a O and you are done.
	 * if n = abcde1000
       then n-1 = abcde0111
       abcde must be all 0s, which means that n must look like this: 00001000
	 * 
	 * 
	 * 
	 * 
	 */
}
