import java.util.LinkedList;
import java.util.Scanner;

public class Exo2 {
	
	//int[][]  prédécesseur = new 
	public static int[][] initialize(Graph g){
		int[] tab = Exo1.AllSommet(g);
		int number = g.getEdgesCount(false)+g.getEdgesCount(true);
		int[][] res = new int[number][3];
		int i = 0;
		for (int v : tab) {
			LinkedList<Integer> listeSuccesseur = Exo1.giveSuccessor(g, v);
			Scanner sc = new Scanner(System.in);
			for(int w : listeSuccesseur) {
				System.out.println("Quel est le poids de l'arc entre "+v+" et "+w);
				int scan = Integer.parseInt(sc.nextLine());
				res[i][0] = v;
				res[i][1] = scan;
				res[i][2] = w;
			}
			i++;
		}
		return res;//On retourne le tableau [ [s1, poids, s2], ...]
	}
	
	public int[][] init(Graph g,int[][] distanceSommet, int[] tabSommet) {
		//Le sommet de début est le premier sommet de res
//		int[][] tab = initialize(g);
		//int[] tabSommet = Exo1.AllSommet(g);
		//int[][] distanceSommet = new int[tabSommet.length][2];
		int j = 0;
		boolean check = true;
		for(int v : tabSommet) {
			if(check!=true){
				distanceSommet[0][0] = v;//Sommet de départ
				distanceSommet[0][1] = 0;
			}else {
				check = false;
				distanceSommet[0][0] = v;
				distanceSommet[0][1] = 666; //Distance à l'infini
			}
		}
		return distanceSommet;
	}
	
	//Trouve le sommet de distance minimale
	public int min(Graph g,int[] tab,int[][] distanceSommet) {
		//int[][] distanceSommet = init(g);
		int min = 666;
		int sommet = -1;
		//int[] tab = Exo1.AllSommet(g);
		for (int v : tab ) {//Pour chque sommet
			int dS = getDistance(distanceSommet,v); 
			if (dS<min) {
				min = dS;
				sommet = v;
			}
		}
		return sommet;
	}
	
	//recherche distance sommet
	public int getDistance (int[][] dS, int s) {
		int d = 0;
		for (int[] v : dS) {
			if(v[0]==s) {
				d = v[1];
			}
		}
		return d;
	}
	
	public int[][] newDistance(int[][] dS, int[][] dP,int s1, int s2) {
		int dS1 = getDistance(dS,s1);
		int dS2 = getDistance(dS, s2);
		if(dS2>dS1+getPoids(dP,s1,s2)) {
			changeDistance(dS, s2, dS1+getPoids(dP,s1,s2));
			
		}
		return dS;
	}
	
	//Retourne le poids d'un arc entre deux sommets
	public int getPoids(int[][] dP, int s1, int s2) {
		int poids = 0;
		for(int[] v : dP) {
			if(v[0]==s1 && v[2]==s2) {
				poids = v[1];
			}
		}
		return poids;
	}
	
	
	public void changeDistance(int[][] dS,int s, int newValeur) {
		
	}
	
	
	public int[] dijkstra(Graph g) {
		//initialisation
		int[] tabSommet = Exo1.AllSommet(g); //Le tableau de tous les sommets
		int[][] distanceSommet = new int[tabSommet.length][2];//
		init(g,distanceSommet,tabSommet);//Les sommets autres que le sommet début sont à l'infini
		int[][] tabSommetPoids = initialize(g);
		
		while(!isEmpty(tabSommet)) {//Tant que le tableau de tous les sommets n'est pas vide
			int s1 = min(g,tabSommet,distanceSommet);
			
			
		}
		
	}
	
	public boolean isEmpty(int[] tab ) {
		boolean check = true;
		for(int i=0; i<tab.length;i++) {
			if(tab[i]!=-1) {
				check = false;
			}
		}
		return check;
	}
	
}
