import java.util.LinkedList;

public class main {
	
	public static void main(String args[]) 
    { 
        System.out.println("Exercice 1\n");
		
		// Object of graph is created. 
        Graph<Integer> g = new Graph<Integer>(); 
        
        //ajout sommet
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        
        g.addEdge(0, 1, true);
        g.addEdge(1, 2, true);
        //g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);
        
        int boom = Exo1.CC(g);
        System.out.println(boom +" composantes connexes");
        
        
        System.out.println("Exercice 2\n");
        
        
        System.out.println("Exercice 3");
        Graph<Integer> h = new Graph<Integer>(); 
        //ajout sommet
        h.addVertex(0);
        h.addVertex(1);
        h.addVertex(2);
        h.addVertex(3);
        
        h.addEdge(0, 1, false);
        h.addEdge(1, 2, false);
        h.addEdge(3, 4, false);
        h.addEdge(2, 4, false);
        h.addEdge(4, 1, false);
        
        int[] tab = Exo3.Dijkstra(h,0);
        for(int i=0; i<tab.length;i++) {
        	System.out.println(tab[i]+" est le prédecesseur de "+i);
        }
        
        System.out.println(tab.length);

    } 
}
