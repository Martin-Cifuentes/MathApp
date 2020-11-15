package model;
import java.util.ArrayList;
public class MathApp{
	private ArrayList <IntegerSet> sets;

	public MathApp(){
		sets = new ArrayList<IntegerSet>();
	}
	public String showSets(){
		String x = "";
		for(int i = 0; i < sets.size(); i++){
			x = sets.get(i).toString() + "\n";
		}
		return x;
	}
	public void createSetElement(int element, String name){
		int x = findSet(name);
		boolean salir = false;
		for(int i = 0; i < sets.get(x).getElements().size(); i++){
			if(sets.get(0) != null && element == (((Integer)sets.get(x).getElements().get(i)).intValue()) && salir == false){
				System.out.println("El set ya existe");
				salir = true;
			}
		}
		if(salir == false){
			sets.get(x).addElement(element);
		}
	}
	public void eraseSetElement(int element, String name){
		int x = findSet(name);
		sets.get(x).eraseElement(element);
	}
	public void createSet(String name){
		int i = 0;
		boolean salir = false;
		while(i < sets.size() && salir == false){
			if(sets.get(0) != null && name == sets.get(i).getName()){
				System.out.println("El set ya existe");
				salir = true;
			}
			i++;
		}
		if(salir == false){
			IntegerSet s = new IntegerSet(name);
			sets.add(s);
		}
	}
	public void removeSet(String name){
		int p = findSet(name);
		sets.remove(p);
	}
	public int findSet(String setN){
		int i = 0;
		int p = 0;
		boolean encontro = false;
		while(i < sets.size() && encontro == false){
			if(sets.get(i).getName() == setN){
				encontro = true;
				p = i;
    		}
			i++;
		}
		return p;
	}
	public void union(String set1Name,String set2Name,String newSetName){
		IntegerSet newSet;
		int x = findSet(set1Name);
		int y = findSet(set2Name);
		IntegerSet set1 = sets.get(x);
		IntegerSet set2 = sets.get(y);
		if(x != 0 && y != 0){
			newSet = set1.union(set2,newSetName);
		}
	}
	public void difference(String set1Name,String set2Name,String newSetName){
		IntegerSet newSet;
		int x = findSet(set1Name);
		int y = findSet(set2Name);
		IntegerSet set1 = sets.get(x);
		IntegerSet set2 = sets.get(y);
		if(x != 0 && y != 0){
			newSet = set1.difference(set2,newSetName);
		}
	}
	public void intersection(String set1Name,String set2Name,String newSetName){
		IntegerSet newSet;
		int x = findSet(set1Name);
		int y = findSet(set2Name);
		IntegerSet set1 = sets.get(x);
		IntegerSet set2 = sets.get(y);
		if(x != 0 && y != 0){
			newSet = set1.intersection(set2,newSetName);
		}
	}
	public void symmetricDifference(String set1Name,String set2Name,String newSetName){
		IntegerSet newSet = new IntegerSet (newSetName);
		int x = findSet(set1Name);
		int y = findSet(set2Name);
		IntegerSet set1 = sets.get(x);
		IntegerSet set2 = sets.get(y);
		IntegerSet aSet = set1.difference(set2,"s1");
		IntegerSet bSet = set2.difference(set1,"s2");
		if(x != 0 && y != 0){
			newSet = set1.symmetricDifference(aSet,bSet);
		}
	}
}