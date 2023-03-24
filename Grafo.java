import java.util.ArrayList;
import java.util.List;

public class Grafo {
    // Un elenco di elenchi per rappresentare un elenco di adiacenze
    List<List<Bordo>> adjList = null;

    // Costruttore
    Grafo(List<Bordo> bordi, int n) {
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // aggiunge i bordi al graph diretto
        for (Bordo b : bordi) {
            adjList.get(b.origine).add(b);
        }
    }
}
