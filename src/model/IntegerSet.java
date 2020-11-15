package model;
import java.util.ArrayList;
public class IntegerSet{
	private ArrayList <Integer> elements;
	private String name;
	private int cardinality;
	public IntegerSet(String name){
		this.name = name;
		elements = new ArrayList<Integer>();
	}
	public String toString(){
		String x = "";
		String str = "";
		for(int i = 0; i < elements.size(); i++){
			x = "  " + elements.get(i) + ",";
		}
		str = name + "{" + x + " }";
		return str;
	}
	public void addElement(int e){
		elements.add(e);
	}
	public void eraseElement(int o){
		int e = findElement(o);
		elements.remove(e);
	}
	public int findElement(int x){
		int i = 0;
		int p = 0;
		boolean encontro = false;
		while(i < getCardinality() && encontro == false){
			if(elements.get(i) == x){
				encontro = true;
				p = i;
    		}
			i++;
		}
		return p;
	}
	public IntegerSet union(IntegerSet set, String name){
		int prueba = 0;
		IntegerSet unionSet = new IntegerSet (name);
		for(int i = 0; i < getCardinality(); i++){
			unionSet.addElement(elements.get(i));
		}
		for(int i = 0; i < getCardinality(); i++){
			for(int o = 0; i < elements.size(); o++){
				prueba++;
			}
			if(prueba == getCardinality()){
				unionSet.addElement(((Integer)set.getElements().get(i)).intValue());
				prueba = 0;
			}else{
				prueba = 0;
			}
		}
		return unionSet;
	}
	public IntegerSet difference(IntegerSet set, String name){
		int prueba = 0;
		IntegerSet diffSet = new IntegerSet (name);
		for(int i = 0; i < getCardinality(); i++){
			for(int o = 0; i < elements.size(); o++){
				if(set.getElements().get(o) != elements.get(i)){
					prueba++;
			    }
			}
			if(prueba < getCardinality()){
				diffSet.addElement(elements.get(i));
				prueba = 0;
			}else{
				prueba = 0;
			}
		}
		return diffSet;
	}
	public IntegerSet intersection(IntegerSet set, String name){
		IntegerSet interSet = new IntegerSet (name);
		for(int i = 0; i < getCardinality(); i++){
			for(int o = 0; i < elements.size(); o++){
				if(set.getElements().get(o) == elements.get(i)){
					interSet.addElement(elements.get(i).intValue());
			    }
			}
		}
		return interSet;
	}
	public IntegerSet symmetricDifference(IntegerSet setA, IntegerSet setB){
		IntegerSet sDiffSet = new IntegerSet (name);
		for(int i = 0; i < getCardinality(); i++){
			sDiffSet.addElement(((Integer)setA.getElements().get(i)).intValue());
		}
		for(int i = 0; i < getCardinality(); i++){
			sDiffSet.addElement(((Integer)setB.getElements().get(i)).intValue());
		}
		return sDiffSet;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String n){
		this.name = n;
	}
	public ArrayList getElements(){
		return this.elements;
	}
	public int getCardinality(){
		return elements.size();
	}
}