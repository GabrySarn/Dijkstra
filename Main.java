import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        // inizializza i bordi come nel diagramma sopra
        // (u, v, w) rappresentano lo spigolo dal vertice `u` al vertice `v` avente peso `w`
        List<Bordo> bordi = Arrays.asList(
                new Bordo(0, 1, 2), new Bordo(0, 4, 8), new Bordo(1, 2, 6),
                new Bordo(1, 3, 2), new Bordo(2, 6, 5), new Bordo(2, 1, 6),
                new Bordo(3, 1, 2), new Bordo(3, 4, 2), new Bordo(4, 0, 8),
                new Bordo(4, 3, 2), new Bordo(4, 5,3), new Bordo(5, 4, 3),
                new Bordo(5,6,1), new Bordo(5,3,9), new Bordo(6,5,1),
                new Bordo(6,2,5)
                );         
 
        // numero totale di nodi nel graph (etichettato da 0 a 4)
        int n = 7;
 
        // costruisci il graph
        Grafo g = new Grafo(bordi, n);
 
        // esegue l'algoritmo di Dijkstra da ogni nodo
        for (int origine = 0; origine < n; origine++) {
            Dijkstra.findShortestPaths(g, origine, n);
        }
    }
}


