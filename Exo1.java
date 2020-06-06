import java.util.LinkedList;
public class Exo1 {
/*But de l'exercice 
 * Le graphe non orienté est-il connexe ?
 * Si oui, calcul du nombre de composantes connexes
 */
	//retourne le nombre de composantes connexes
	public static int CC(Graph g){
		int[][] tabSommet = AllSommetColored(g);
		int i = 0;
		int couleur = 0;
		while(!checkAllColored(tabSommet)) {
			while(tabSommet[i][1]!=0 && i!=tabSommet.length) {//Tant que le sommet choisi est colorié ( != 0 ) 
				i++;
			}//On a choisi un sommet non colorié
			couleur++; //on choisit une nouvelle couleur
			CC_Sommet(g,tabSommet, i,couleur);
		}
		return couleur;
	}
	
	//indique si connexe
	public boolean isConnexe(int couleur) { 
		return couleur>=1;
	}
	public static void CC_Sommet(Graph g, int[][] tabSommet, int sommet,int couleur) {
		colorSommet(tabSommet, sommet, couleur);
		LinkedList<Integer> liste = giveSuccessor(g,sommet);
		for(int v : liste) {//pour tous les sommets successeurs
			if(tabSommet[v][1]==0) {
				CC_Sommet(g,tabSommet,v,couleur);
			}
		}
	}
	
	//Pour un sommet donné renvoie la liste des successeurs
	public static LinkedList<Integer> giveSuccessor(Graph g, int head) {
		LinkedList liste = new LinkedList();
		int[] successor = AllSommet(g);
		for (int v : successor) { //Pour chacun des sommets du graphe
			if (g.isConnected(head,v)) { //Si connecté
				liste.add(v);
			}
		}
		return liste;
	}
	
	public static int[][] colorSommet(int[][] tabSommet,int som, int couleur) {
		for(int[] v : tabSommet) {
			if(v[0]==som) {
				v[1] = couleur;
			}
		}
		return tabSommet;
	}
	
	public static int[][] AllSommetColored(Graph g) {//Tous les sommets sont en noirs
		int[][] sommet = new int[g.getMap().keySet().size()][2];
		int i = 0;
		for(Object v : g.getMap().keySet() ) {
			sommet[i][0]= (Integer)v;
			sommet[i][1]=0;
			i++;
		}
		return sommet;	
	}
	
	public static boolean checkAllColored(int[][] tab ) {
		boolean check = true;
		int size = tab.length;
		for(int i = 0; i<size; i++) {
			if(tab[i][1]==0) {
				check = false;
			}
		}
		return check;
	}
	
	public static int[] AllSommet(Graph g) {
		int[] sommet = new int[g.getMap().keySet().size()];
		int i = 0;
		for(Object v: g.getMap().keySet()) {
			sommet[i] =(Integer) v;
			i++;
		}
		return sommet;
	}
}