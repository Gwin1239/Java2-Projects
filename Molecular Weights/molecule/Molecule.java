// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC, Canvas pdf

package molecule;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;
import molecule.exceptions.InvalidAtomException;
import molecule.exceptions.InvalidSequenceException;

/**
 * Objects of the Molecule class represent a single chemical molecule made up of any number
 *  of hydrogen, carbon, and oxygen atoms.
 *  The class provides functionality to compute the atomic weight of the molecule.
 *  @author gdjossou
 */
public class Molecule implements Comparable<Molecule>, Cloneable
{
	/**
	 * Number for carbon.
	 */
	private static final int CARBON = 12;
	
	/**
	 * Number for Oxygen.
	 */
	private static final int OXYGEN = 16;
	
	/**
	 * Number for Width.
	 */
	private static final int WIDTH = 25;
	
	/**
	 * Integer for storing weight.
	 */
	private int weight;
	
	/**
	 * String for the sequence.
	 */
	private String first;
	
	
	/**
	 * Creates a new Molecule made up of the H, C, and O atoms in the configuration specified by sequenceIn.
	 * @param sequenceIn - The sequence of atoms for this Molecule.
	 * @throws InvalidAtomException - if any non C, H, O atom exists in sequenceIn
	 * @throws InvalidSequenceException - if unmatched parentheses exist in sequenceIn or
	 *  incoming sequence is null or empty String.
	 */
	public Molecule(String sequenceIn) throws InvalidAtomException, InvalidSequenceException
	{
		this.setSequence(sequenceIn);
	}
	

	/**
	 * Updates the sequence of atoms represented by this Molecule.
	 * @param sequenceIn - The new molecular sequence to be used for this Molecule.
	 * @throws InvalidAtomException - if any non C, H, O atom exists in sequenceIn
	 * @throws InvalidSequenceException - if unmatched parentheses exist in sequenceIn
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setSequence(String sequenceIn) throws InvalidAtomException, InvalidSequenceException
	{
		if (sequenceIn != null)
		{
			Stack<Integer> sequenceOne = new Stack();
			String r = "(" + sequenceIn + ")";
			for (int i = 0; i < r.length(); ++i)
			{
				char index = r.charAt(i);
				this.quickCheck(index, r, sequenceOne);
				if (Character.isDigit(index))
				{
					ArrayList num;
					for (num = new ArrayList();
							Character.isDigit(r.charAt(i + 1)); index = r.charAt(i))
					{
						num.add(Integer.parseInt(String.valueOf(index)));
						++i;
					}
					num.add(Integer.parseInt(String.valueOf(index)));
					String second = "";
					
					int value;
					for (value = 0; value < num.size(); ++value)
					{
						second = second + String.valueOf(num.get(value));
					}
					value = Integer.parseInt(second);
					value *= (Integer) sequenceOne.pop();
					sequenceOne.push(value);
				}
				this.checkPar(index, sequenceOne);
			}
			if (sequenceOne.size() != 1)
			{
				throw new InvalidSequenceException();
			}
			this.first = sequenceIn;
			this.weight = (Integer) sequenceOne.pop();
		}
	}
	
	/**
	 * Retrieves a String containing this Molecule's sequence of atoms.
	 * @return Molecular sequence of the Molecule.
	 */
	public String getSequence()
	{
		return this.first;
	}
	
	/**
	 * Retrieves this Molecule's weight, which is calculated based on the 
	 * Molecule's sequence per the algorithm specified.
	 * @return Weight of the Molecule.
	 */
	public int getWeight()
	{
		return this.weight;
	}
	
	/**
	 * Generates and returns a String with the Molecule's sequence and weight. The format of the String is
	 * 
	 * [SEQUENCE               ]: WEIGHT
	 * 
	 * Where SEQUENCE has a field width of 25 and is left justified
	 * (square brackets are just placeholders and will not appear in actual return values).
	 * WEIGHT should be left-justified. There is no space following the SEQUENCE field and the colon.
	 * @return The generated String.
	 */
	@Override
	public String toString()
	{
		int line = WIDTH - this.first.length();
		String lineOne = "";
		
		for (int i = 0; i < line; ++i)
		{
			lineOne = lineOne + " ";
		}
		return this.first + lineOne + ": " + this.weight;
	}

	/**
	 * 	Static utility method to return the atomic weight of a given atom.
	 *  Supported atoms are Carbon (C), Hydrogen (H), and Oxygen (O), and the value of the atom parameter
	 *   corresponds to the single letter abbreviation for these atoms (case insensitive).
	 *  Atomic weights are given in their nearest whole number:
	 *   Hydrogen - 1 
	 *   Carbon - 12 
	 *   Oxygen - 16
	 * @param atom - Character for atom abbreviation
	 * @return Atomic weight of passed atom
	 * @throws molecule.exceptions.InvalidAtomException - Thrown if an unsupported atom is passed
	 */
	public static int atomWeight(char atom) throws InvalidAtomException
	{
		char atomOne = Character.toUpperCase(atom);
		int weighttt;
		switch (atomOne)
		{
			case 'H':
				weighttt = 1;
				break;
			case 'C':
				weighttt = CARBON;
				break;
			case 'O':
				weighttt = OXYGEN;
				break;
			default:
				throw new InvalidAtomException(atom);
			
		}
		return weighttt;
	}

	/**
	 * Compares this Molecule to a passed Molecule, determining natural order.
	 * Molecules with the same weight (regardless of sequence) are considered equal.
	 * All others are ordered relative to the magnitude of their weights.
	 * @param other - Incoming Molecule to be compared with this (local) Molecule.
	 * @return Returns an int less than 0 if the local Molecule is less than the passed Molecule,
	 *  an int greater than 0 if the local Molecule is greater than the passed Molecule,
	 *  and a 0 if the Molecules are equal.

	 */
	public int compareTo(Molecule other)
	{
		int done = this.weight - other.getWeight();
		return done;
	}
	
	/**
	 * Returns a deep copy of the Molecule.
	 * The reference returned should refer to a completely separate molecule with no direct or
	 *  indirect aliasing of any instance data in the original Molecule.
	 *  NOTE: This method should NOT throw a CloneNotSupportedException.
	 *  @return Deep copy of the calling Molecule.
	 */
	@Override
	public Object clone()
	{
		Molecule newww;
		try
		{
			newww = (Molecule) super.clone();
		}
		catch (CloneNotSupportedException a)
		{
			newww = new Molecule(this.getSequence());
		}
		return newww;
	}
	
	/**
	 * Helper used in setSequence.
	 * @param index Helper index.
	 * @param input Helper input.
	 * @param sequenceOne Helper sequence.
	 */
	private void quickCheck(char index, String input, Stack<Integer> sequenceOne)
	{
		if (index == '(')
		{
			sequenceOne.push(-1);
		}
		else if (Character.isAlphabetic(index))
		{
			sequenceOne.push(atomWeight(index));
		}
	}
	
	/**
	 * Helper to check for the parenthesis.
	 * @param index Helper index.
	 * @param sequenceOne Helper sequence.
	 */
	private void checkPar(char index, Stack<Integer> sequenceOne)
	{
		if (index == ')')
		{
			int sum;
			
			for (sum = 0; !sequenceOne.isEmpty() && (Integer) sequenceOne.peek() != -1; 
					sum += (Integer) sequenceOne.pop())
			{
				System.out.println("");
			}
			
			try
			{
				sequenceOne.pop();
				sequenceOne.push(sum);
			}
			catch (EmptyStackException b)
			{
				b.getMessage();
			}
		}
	}
	

}
