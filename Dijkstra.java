import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    public static void getRotta(int[] prev, int i, List<Integer> rotta) {
        if (i >= 0) {
            getRotta(prev, prev[i], rotta);
            rotta.add(i);
        }
    }

    // Esegui l'algoritmo di Dijkstra su un dato graph
    public static void findShortestPaths(Grafo grafo, int origine, int n) {
        // crea un min-heap e invia il nodo sorgente con distanza 0
        PriorityQueue<Node> minHeap;
        minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.peso));
        minHeap.add(new Node(origine, 0));

        // imposta la distanza iniziale dalla sorgente a `v` come infinito
        List<Integer> dist;
        dist = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));

        // la distanza dalla sorgente a se stessa è zero
        dist.set(origine, 0);

        // array booleano per tenere traccia dei vertici per quale minimo
        // il costo è già stato trovato
        boolean[] fatto = new boolean[n];
        fatto[origine] = true;

        // memorizza il predecessore di un vertice (in un percorso di stampa)
        int[] prev = new int[n];
        prev[origine] = -1;

        // corri finché min-heap non è vuoto
        while (!minHeap.isEmpty()) {
            // Rimuove e restituisce il vertice migliore
            Node node = minHeap.poll();

            // ottieni il numero del vertice
            int u = node.vertice;

            // fare per ogni vicino `v` di `u`
            for (Bordo bordo : grafo.adjList.get(u)) {
                int v = bordo.dest;
                int peso = bordo.peso;

                // Fase di rilassamento
                if (!fatto[v] && (dist.get(u) + peso) < dist.get(v)) {
                    dist.set(v, dist.get(u) + peso);
                    prev[v] = u;
                    minHeap.add(new Node(v, dist.get(v)));
                }
            }

            // contrassegna il vertice `u` come fatto in modo che non venga più ripreso
            fatto[u] = true;
        }

        List<Integer> rotta = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i != origine && dist.get(i) != Integer.MAX_VALUE) {
                getRotta(prev, i, rotta);
                System.out.printf("Percorso (%d -> %d): Costo Minimo = %d, Rotta = %s\n",
                        origine, i, dist.get(i), rotta);
                rotta.clear();
            }
        }
    }

}
