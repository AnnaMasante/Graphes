import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Exo3 {

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
		
		public static int[] Dijkstra(Graph g, int sdeb) {
			int[][] pSp = initialize(g);
			LinkedList<Integer> P = new LinkedList<Integer>();
			LinkedList<Integer> allSommet = new LinkedList<Integer>();
			int[] som = Exo1.AllSommet(g);
			for( int v: som) {
				allSommet.add(v);
			}
			int[] predec = new int[allSommet.size()];
			
			int[] d = new int[allSommet.size()];
			for(int i=0;i<d.length;i++) {
				d[i]=666;
			}
			d[sdeb]=0;
			
			//Tant qu'il existe un sommet hors de P
			//ou tant que allSommet n'est pas vide
			while(P.size()!=allSommet.size()) {		
				int sommet = getMin(d,P);//renvoie un sommet hors de p et de distance min
				System.out.println("sommet min : "+sommet);
				P.add(sommet);
				LinkedList<Integer> voisin = getVoisin(pSp,sommet,P);//Les voisins du sommet, non présents dans P
				//TEST
				/*for (int i : voisin) {
					System.out.println("Le voisin de "+sommet +" est : "+i);
				}*/
				for(int s : voisin) {
					//System.out.println("Le voiisn :" + s);
					if(d[s]>d[sommet]+poids(pSp,sommet,s)) {
						//System.out.println("Le poids est "+poids(pSp,sommet,s));
						//System.out.println("ditance " +d[s]);
						d[s] = d[sommet] + poids(pSp,sommet,s);
						//System.out.println("ditance " +d[s]);
						predec[s]= sommet;
					}
				}
				System.out.println("Size P :" +P.size());
				//System.out.println("Size allSommet :" +allSommet.size());
				
			}
			return predec;
		}
		
		public static int poids(int[][]pSp, int a, int b) {
			int p = 0;
			for(int[] l : pSp) {
				if(l[0]==a && l[2]==b) {
					p = l[1];
				}
			}
			return p;
		}
		public static LinkedList<Integer> getVoisin(int[][]pSp, int sommet, LinkedList<Integer> P) {
			LinkedList<Integer> l = new LinkedList<Integer>();
			for(int[] v : pSp) {
				/*System.out.println("(" +v[0] + ","+v[2]+" )");
				System.out.println("Bool :"+ (v[0]==sommet && !P.contains(v[2])));*/
				if(v[0]==sommet && !P.contains(v[2])) {
					l.add(v[2]);
					//System.out.println(v[2]);
				}
			}
			System.out.println(l.size());
			return l;
		}
		public static int getMin(int[] distance, LinkedList<Integer> P) {
			int min = 666;
			int check = 666;
			for(int i=0;i< distance.length;i++) {
				System.out.println("i = "+i+"Psize =" +P.size());
				System.out.println(" i = "+i+" distance = "+distance[i]);
				if(!P.contains(i)) {
					if(distance[i]<=min) {
						min = distance[i];
						check = i;
					}
				}
				
			}
			System.out.println("check = "+check);
			return check;
		}
		
		/*public int[][] init(Graph g,int[][] distanceSommet, LinkedList<Integer> tabSommet) {
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
		//Pour un sommet donné, on renvoie le sommet le plus proche
		public int getMin(LinkedList<Integer> P, int[][] pSp, int sdeb) {
			int min = 666;
			int sommet = -1;
			for (int[] v : pSp) {
				if(v[0]==sdeb) {
					if(v[1]<min) {
						min = v[1];
						sommet = v[2];
					}
				}
			}
			return sommet;
		}
		
		public LinkedList<Integer> getVoisin(LinkedList<Integer> allSommet,int[][] pSp, int sommet){
			LinkedList<Integer> voisin = new LinkedList<Integer>();
			for(int[] v : pSp) {
				if(v[0] == sommet && allSommet.contains(v[2])) {//si on a le bon sommet et que la destination fait encore parti des sommets où on est pas passé
					voisin.add(v[2]);
				}
			}
			return voisin; //on retourne la liste des voisins d'un sommet
		}
		
		public int[] maj_distance(int s1,int s2, int[] predec) {
			
		}
		public LinkedList<Integer> Dijkstra(Graph g,int sdeb){
			int[][] tabSommetPoidsSommet = initialize(g);
			int[] sommet = Exo1.AllSommet(g);
			LinkedList<Integer> allSommet = new LinkedList<Integer>();
			for( int v: sommet) {
				allSommet.add(v);
			}
			LinkedList<Integer> P = new LinkedList<Integer>();;
			int[][]distanceSommet = new int[allSommet.size()][2];
			distanceSommet = init(g,distanceSommet,allSommet);
			//Tant qu'il y a un sommet hors de P
			allSommet.remove(allSommet.indexOf(sdeb));
			P.add(sdeb);
			
			int[] predec = new int[allSommet.size()];
			
			while(allSommet.size()!=0) {
				int s = getMin(allSommet,tabSommetPoidsSommet,sdeb);
				sdeb = s;
				allSommet.remove(allSommet.indexOf(sdeb));
				P.add(sdeb);
				//Pour chq sommet voisin de sdeb
				for( int v : getVoisin(allSommet, tabSommetPoidsSommet,sdeb) ) {
					maj_distance(sdeb,v,predec);
				}
			}
			
			return P;
			
		}*/
		
}
