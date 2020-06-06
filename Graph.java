import java.util.*;

public class Graph<T> {
	// We use Hashmap to store the edges in the graph 
    private Map<T, List<T> > map = new HashMap<>(); 
    
    // This function adds a new vertex to the graph 
    public void addVertex(T source) 
    { 
        getMap().put(source, new LinkedList<T>()); 
    } 
  
    // This function adds the edge 
    // between source to destination 
    public void addEdge(T source, T destination, boolean bidirectional) 
    { 
  
        if (!getMap().containsKey(source)) 
            addVertex(source); 
  
        if (!getMap().containsKey(destination)) 
            addVertex(destination); 
  
        getMap().get(source).add(destination); 
        if (bidirectional == true) { 
            getMap().get(destination).add(source); 
        } 
    } 
  
    // This function gives the count of vertices 
    public void getVertexCount() 
    { 
        System.out.println("The graph has "
                           + getMap().keySet().size() 
                           + " vertex"); 
    } 
  
 // This function gives the count of vertices 
    public int getNumberVertex() 
    { 
        return map.keySet().size(); 
    } 
    // This function gives the count of edges 
    public int getEdgesCount(boolean bidirection) 
    { 
        int count = 0; 
        for (T v : getMap().keySet()) { 
            count += getMap().get(v).size(); 
        } 
        if (bidirection == true) { 
            count = count / 2; 
        } 
        return count;
    } 
  
    // This function gives whether 
    // a vertex is present or not. 
    public void hasVertex(T s) 
    { 
        if (getMap().containsKey(s)) { 
            System.out.println("Le graphe a "
                               + s + " comme sommet."); 
        } 
        else { 
            System.out.println("Le graphe n'a pas "
                               + s + " comme sommet"); 
        } 
    } 
  
    // This function gives whether an edge is present or not. 
    public void hasEdge(T s, T d) 
    { 
        if (getMap().get(s).contains(d)) { 
            System.out.println("Le graphe a un arc entre "
                               + s + " et " + d + "."); 
        } 
        else { 
            System.out.println("Le graphe n'a pas d'arc entre "
                               + s + " et " + d + "."); 
        } 
    } 
    
    public boolean isConnected(T s, T d ) {
    	return getMap().get(s).contains(d);
    }
    
    // Prints la liste d'adjacence de chaque sommet 
    @Override
    public String toString() 
    { 
        StringBuilder builder = new StringBuilder(); 
  
        for (T v : getMap().keySet()) { 
            builder.append(v.toString() + ": "); 
            for (T w : getMap().get(v)) { 
                builder.append(w.toString() + " "); 
            } 
            builder.append("\n"); 
        } 
  
        return (builder.toString()); 
    }

	public Map<T, List<T> > getMap() {
		return map;
	}

	public void setMap(Map<T, List<T> > map) {
		this.map = map;
	}
    

}