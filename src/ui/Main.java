package ui;
import model.MathApp;
import java.util.Scanner;
public class Main{

	public static MathApp objApp;
	public final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		objApp= new MathApp();
		//cargarDatos();
		int o = 1;
		while(o != 0){
			o = menu();
			definirAccion(o);
		}
    }
    public static int menu(){
		int opcion;
		System.out.println("***********************MENU**********************");
		System.out.println("-(1) Agregar set");
		System.out.println("-(2) Borrar set");
		System.out.println("-(3) Agregar elemento a un set");
		System.out.println("-(4) Borrar elemento de un set");
		System.out.println("-(5) Operar sets");
		System.out.println("-(6) Mostrar todos los sets");
		System.out.println("-(7) Buscar un set");
		System.out.println("-(0) Salir");
		opcion = sc.nextInt();
		sc.nextLine();
		return opcion;
	}
	public static void definirAccion(int op){
		switch(op){
			case 0: //done
			break;
			case 1: addSet();//done
			break;
			case 2: deleteSet();//done
			break;
			case 3: addElementSet();//done
			break;
			case 4: deleteElementSet();//done
			break;
			case 5: operateSet();//done
			break;
			case 6: showAllSets();//done
			break;
			case 7: searchSet();//done
			break;
			default: System.out.println("Opcion no valida, intente nuevamente");
			//menu();
			break;
		}
	}
	public static void showAllSets(){
		String x;
		x = objApp.showSets();
		System.out.println(x);
	}
	public static void searchSet(){
		String setName;
		System.out.println("Inserte el nombre del set");
		setName = sc.nextLine();
		objApp.findSet(setName);
	}
	public static void addSet(){
		String setName;
		System.out.println("Inserte el nombre del set que va a crear");
		setName = sc.nextLine();
		objApp.createSet(setName);
	}
	public static void deleteSet(){
		String setName;
		System.out.println("Inserte el nombre del set que quiere eliminar");
		setName = sc.nextLine();
		objApp.removeSet(setName);
	}
	public static void addElementSet(){
		int setElement;
		String setName;
		System.out.println("Inserte el numero que quiere agregar al set");
		setElement = sc.nextInt();
		sc.nextLine();
		System.out.println("Inserte el nombre del set al que se le añadira el numero");
		setName = sc.nextLine();
		objApp.createSetElement(setElement, setName);
	}
	public static void deleteElementSet(){
		String setName;
		int setElement;
		System.out.println("Inserte el numero que quiere eliminar del set");
		setElement = sc.nextInt();
		sc.nextLine();
		System.out.println("Inserte el nombre del set al que se le agregara el numero");
		setName = sc.nextLine();
		objApp.eraseSetElement(setElement, setName);
	} 
	public static void operateSet(){
		String set1,set2,newSet;
		int operation;
		System.out.println("Determine la operacion que va a realizar\n(1)Union\n(2)Diferencia\n(3)Interseccion\n(4)interseccion simetrica");
		operation = sc.nextInt();
		sc.nextLine();
		System.out.println("Escriba el nombre del primer set");
		set1 = sc.nextLine();
		System.out.println("Escriba el nombre del segundo set");
		set2 = sc.nextLine();
		newSet = set1 + " Union " + set2;
		switch(operation){
			case 1: objApp.union(set1,set2,newSet);
			break;
			case 2: objApp.intersection(set1,set2,newSet);
			break;
			case 3: objApp.difference(set1,set2,newSet);
			break;
			case 4: objApp.symmetricDifference(set1,set2,newSet);
			break;
			default: System.out.println("Ingrese una opcion valida");
			break;
		}
	}
	
}