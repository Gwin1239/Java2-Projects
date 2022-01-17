package molecule;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

public class RandomTests {

	public static void main(String[] args) 
	{
		//Molecule a = new Molecule(null);
		//Molecule d = (Molecule)a.clone();
		
		//System.out.println(a.getWeight());
		
		
		//MoleculeCollection one = new MoleculeCollection();
		//LinkedList<Molecule> first = new LinkedList();
		
		//System.out.println(one.moleculeWeights());
		
		//System.out.println(one.getMoleculeList());
		
		MoleculeCollection one = new MoleculeCollection();
		one.addMolecule(0, new Molecule("CH"));
		one.addMolecule(1, new Molecule("CH"));
		one.changeSequence(1, "CHO");
		
		System.out.println(one.moleculeWeights());
	}

}
