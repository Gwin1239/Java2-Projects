package test;

import molecule.Molecule;
import molecule.MoleculeCollection;
import molecule.exceptions.InvalidAtomException;
import molecule.exceptions.InvalidSequenceException;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class MoleculeCollectionTest {

	@Test
	public void testConstructor() 
	{
		MoleculeCollection one = new MoleculeCollection();
		@SuppressWarnings({ "unchecked", "rawtypes" })
		LinkedList<Molecule> first = new LinkedList();
		assertEquals(0, one.moleculeWeights());
		assertEquals(first, one.getMoleculeList());
	}
	
	@Test
	public void testNullList()
	{
		MoleculeCollection one = new MoleculeCollection(null);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		LinkedList<Molecule> first = new LinkedList();
		assertEquals(0, one.moleculeWeights());
		assertEquals(first, one.getMoleculeList());
	}
	
	@Test
	public void testAddMolecule()
	{
		MoleculeCollection one = new MoleculeCollection();
		one.addMolecule(0, new Molecule("CH"));
		assertEquals(13, one.moleculeWeights());
		
	}
	
	@Test
	public void testCompare()
	{
		MoleculeCollection one = new MoleculeCollection();
		Molecule asap = new Molecule("CH");
		one.addMolecule(2, asap);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		LinkedList<Molecule> first = new LinkedList();
		first.add(asap);
		assertEquals(0, ((Molecule) one.getMoleculeList().get(0)).compareTo((Molecule) first.get(0)));
		
	}
	
	@Test
	public void testSeqChange()
	{
		MoleculeCollection one = new MoleculeCollection();
		one.addMolecule(0, new Molecule("CH"));
		one.addMolecule(1, new Molecule("CH"));
		one.changeSequence(1, "CHO");
		assertEquals(42, one.moleculeWeights());
	}
	
	@Test
	public void testSort()
	{
		MoleculeCollection one = new MoleculeCollection();
		one.addMolecule(0, new Molecule("CH"));
		one.addMolecule(1, new Molecule("C2H"));
		one.addMolecule(2, new Molecule("CHO"));
		MoleculeCollection two = new MoleculeCollection();
		two.addMolecule(0, new Molecule("C2H"));
		two.addMolecule(1, new Molecule("CHO"));
		two.addMolecule(2, new Molecule("CH"));
		two.sort();
		assertEquals(0, ((Molecule) two.getMoleculeList().get(0)).compareTo((Molecule) one.getMoleculeList().get(0)));
		assertEquals(0, ((Molecule) one.getMoleculeList().get(1)).compareTo((Molecule) two.getMoleculeList().get(1)));
		assertEquals(0, ((Molecule) two.getMoleculeList().get(2)).compareTo((Molecule) one.getMoleculeList().get(2)));
	}
	
	@Test
	public void testChangeSequenceInvalid()
	{
		MoleculeCollection one = new MoleculeCollection();
		one.addMolecule(0, new Molecule("CH"));
		one.addMolecule(1, new Molecule("CH"));
		
		boolean e;
		
		try
		{
			one.changeSequence(1, "JSJ12");
			e = false;
		}
		catch (InvalidAtomException y)
		{
			e = true;
			assertTrue(e);
		}
		
		try
		{
			one.changeSequence(1, "(CH");
		}
		catch (InvalidSequenceException z)
		{
			
		}
		
	}

}
