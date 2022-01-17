package test;

import molecule.Molecule;
import molecule.exceptions.InvalidAtomException;
import molecule.exceptions.InvalidSequenceException;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoleculeTest {

	@Test
	public void testConstructor() 
	{
		Molecule a = new Molecule("(CH)3");
		assertEquals(39, a.getWeight());
		assertEquals("(CH)3", a.getSequence());
	}
	
	@Test
	public void testAtomWeight() 
	{
		assertEquals(16, Molecule.atomWeight('O'));
	}
	
	@Test
	public void testAtomWeightWrong() 
	{
		try
		{
			Molecule.atomWeight('a');
		}
		catch (InvalidAtomException b)
		{
			assertFalse(false);
		}
	}
	
	@Test
	public void testClone() 
	{
		Molecule a = new Molecule("CH");
		Molecule d = (Molecule)a.clone();
		a.setSequence("C2H");
		assertEquals("C2H", a.getSequence());
		assertEquals("CH", d.getSequence());
		assertEquals(13, d.getWeight());
		assertEquals(25, a.getWeight());
	}
	
	
	@Test
	public void testCloneNull() 
	{
		Molecule a = new Molecule(null);
		Molecule d = (Molecule)a.clone();
		
		assertEquals(0, a.getWeight());
		assertEquals(0, d.getWeight());
	}
	
	
	@Test
	public void testCompareTo() 
	{
		Molecule a = new Molecule("CH");
		Molecule d = (Molecule)a.clone();
		a.setSequence("C2H");
		assertEquals(12, a.compareTo(d));
	}
	
	@Test
	public void testSetSequenceWrong() 
	{
		Molecule a = new Molecule("CH");
		
		try
		{
			a.setSequence("CHef");
		}
		catch (InvalidAtomException f)
		{
			assertEquals("CH", a.getSequence());
		}
		
		try 
		{
			a.setSequence("C(H)");
		}
		catch (InvalidSequenceException h)
		{
			assertEquals("CH", a.getSequence());
		}
	}
	

	@Test
	public void testToString() 
	{
		Molecule a = new Molecule("CH");
		assertEquals("CH                       : 13", a.toString());
	}
	
	
	
	@Test
	public void testInvalidPar()
	{
		try
		{
			new Molecule("(C");
		}
		catch (InvalidSequenceException r)
		{
			
		}
	}
	
}
