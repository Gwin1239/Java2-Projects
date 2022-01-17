// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC, Canvas pdf


package molecule;

import java.util.ArrayList;
import java.util.LinkedList;

import molecule.exceptions.InvalidAtomException;
import molecule.exceptions.InvalidSequenceException;

/**
 * A collection of Molecules maintained in a LinkedList.
 *  Allows for adding, sorting, and updating Molecules in the collection.
 *  A List of the Molecules can also be retrieved;
 *  the returned list is a deep copy of the list held in the MoleculeCollection.
 * @author gdjossou
 *
 */
public class MoleculeCollection
{
	/**
	 * List collection for molecule.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private LinkedList<Molecule> moleculeOne = new LinkedList();
	
	/**
	 * Creates a new MoleculeCollection containing no Molecules yet.
	 */
	public MoleculeCollection()
	{
		
	}
	
	/**
	 * Creates a new MoleculeCollection based upon an existing list of Molecules.
	 * The newly created MoleculeCollection will store a deep copy of the data in
	 *  moleculeListIn to enforce encapsulation.
	 * If the passed reference is null, the created MoleculeCollection will be empty.
	 * @param moleculeListIn - LinkedList of Molecules used to create a new MoleculeCollection.
	 */
	public MoleculeCollection(LinkedList<Molecule> moleculeListIn)
	{
		this.setLinkedList(moleculeListIn);
	}
	
	/**
	 * Adds a copy of a given Molecule to this MoleculeCollection at the given index.
	 * Future external changes to the original Molecule will not impact values in the collection.
	 * If add is null, this MoleculeCollection is unchanged. If the given index is out of range,
	 *  the Molecule will be added to the end of the Collection
	 * @param index - The index in which to add the Molecule
	 * @param add - Molecule to be added to the Collection
	 */
	public void addMolecule(int index, Molecule add)
	{
		if (add != null)
		{
			Molecule one = (Molecule) add.clone();
			if (index == -1)
			{
				this.moleculeOne.addFirst(one);
			}
			else if (index < this.moleculeOne.size() && index >= -1)
			{
				this.moleculeOne.add(index, one);
			}
			else
			{
				this.moleculeOne.add(one);
			}
		}
	}
	
	/**
	 * Reorders the MoleculeCollection based on atomic weight.
	 * Molecules with the same weights should appear in their original order of insertion
	 *  relative to one another (ie., sort() is a stable sorting algorithm).
	 */
	public void sort()
	{
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ArrayList<Molecule> sorted = new ArrayList(this.moleculeOne);
		for (int i = 0; i < sorted.size(); i++)
		{
			for (int j = 0; j < sorted.size(); j++)
			{
				if (((Molecule) sorted.get(i)).getWeight() < ((Molecule) sorted.get(j)).getWeight())
				{
					Molecule three = (Molecule) sorted.get(i);
					sorted.set(i, (Molecule) sorted.get(j));
					sorted.set(j, three);
				}
			}
		}
		this.moleculeOne.clear();
		for (int i = 0; i < sorted.size(); i++)
		{
			this.moleculeOne.add((Molecule) sorted.get(i));
		}
	}
	
	/**
	 * Sums the weights of all Molecules in the MoleculeCollection.
	 * @return The sum of all weights in the collection.
	 */
	public int moleculeWeights()
	{
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ArrayList<Molecule> together = new ArrayList(this.moleculeOne);
		int sum = 0;
		
		for (int i = 0; i < together.size(); i++)
		{
			sum += ((Molecule) together.get(i)).getWeight();
		}
		return sum;
	}
	
	/**
	 * Generates and returns a deep copy of a list containing all of the Molecules in this MoleculeCollection.
	 * Modifying the returned list will not impact the contents of this MoleculeCollection in any way.
	 * @return Deep copy of the Molecules
	 */
	public LinkedList<Molecule> getMoleculeList()
	{
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ArrayList<Molecule> listOne = new ArrayList(this.moleculeOne);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		LinkedList<Molecule> listTwo = new LinkedList();
		if (!this.moleculeOne.isEmpty())
		{
			for (int j = 0; j < listOne.size(); j++)
			{
				listTwo.add((Molecule) ((Molecule) listOne.get(j)).clone());
			}
		}
		return listTwo;
	}
	
	/**
	 * Changes the sequence of a Molecule in the collection at the specified index.
	 * This does not create a new Molecule, rather modifies an existing Molecule.
	 * If the provided sequence is not valid due to either an invalid sequence or an invalid atom,
	 *  the original state of the Molecule at the specified index should be unaffected and
	 *  the resulting exception will be thrown to the caller.
	 * @param index - Location of the Molecule to update
	 * @param newSequence - New sequence of the specified Molecule
	 * @throws InvalidAtomException - Thrown if the new sequence is invalid due to unknown atom
	 * @throws InvalidSequenceException - Thrown if the new sequence is invalid due to format
	 */
	public void changeSequence(int index, String newSequence) throws InvalidAtomException, InvalidSequenceException
	{
		for (int i = 0; i < newSequence.length(); i++)
		{
			char yolo = Character.toUpperCase(newSequence.charAt(i));
			if (Character.isAlphabetic(newSequence.charAt(i)))
			{
				if (yolo != 'H' && yolo != 'C' && yolo != 'O')
				{
					throw new InvalidAtomException(newSequence.charAt(i));
				}
			}
			else if (yolo != '(' && yolo != ')' && !Character.isDigit(yolo))
			{
				throw new InvalidAtomException(newSequence.charAt(i));
			}
		}
		((Molecule) this.moleculeOne.get(index)).setSequence(newSequence);
	}

	
	
	/**
	 * Helper for LinkedList.
	 * @param moleculeListIn LinkedList used for a new MoleculeCollection.
	 */
	private void setLinkedList(LinkedList<Molecule> moleculeListIn)
	{
		if (moleculeListIn != null)
		{
			@SuppressWarnings({ "rawtypes", "unchecked" })
			ArrayList<Molecule> four = new ArrayList(moleculeListIn);
			
			for (int i = 0; i < four.size(); i++)
			{
				this.moleculeOne.add((Molecule) ((Molecule) four.get(i)).clone());
			}
		}
	}
	
}
