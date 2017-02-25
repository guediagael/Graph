import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by TheLetch on 24/02/2017.
 */
public class Krukskal<T> {

    public class EdgeComparator implements Comparator<Edge<T>>{

        @Override
        public int compare(Edge<T> edge1, Edge<T> edge2) {
            if (edge1.getWeight()<=edge2.getWeight())
            return -1;
            else return 1;
        }
    }


    public List<Edge<T>> getMST(Graph<T> graph){
        List<Edge<T>> allEdges = graph.getEdges();
        EdgeComparator edgeComparator = new EdgeComparator();

        //sort all edges in non decreasing order
        Collections.sort(allEdges, edgeComparator);
        DisjointSet disjointSet = new DisjointSet();

        //create as many disjoint sets as the total vertices
        for (Vertex<T> vertex : graph.getVertices()) {
            disjointSet.makeSet(vertex.getId());
        }

        List<Edge<T>> resultEdge = new ArrayList<Edge<T>>();

        for (Edge<T> edge : allEdges) {
            //get the sets of two vertices of the edge
            long root1 = disjointSet.findSet(edge.getVertex1().getId());
            long root2 = disjointSet.findSet(edge.getVertex2().getId());

            //check if the vertices are in same set or different set
            //if vertices are in same set then ignore the edge
            if (root1 == root2) {
                continue;
            } else {
                //if vertices are in different set then add the edge to result and union these two sets into one
                resultEdge.add(edge);
                disjointSet.union(edge.getVertex1().getId(), edge.getVertex2().getId());
            }

        }
        return resultEdge;
    }


    public List<Edge<T>> getMaxST(Graph<T> graph){
        List<Edge<T>> allEdges = graph.getEdges();
        List<Edge<T>> minST = getMST(graph);
        List<Edge<T>> maxST = new ArrayList<>();
        for (Edge<T> edge: allEdges){
            if (minST.contains(edge)) continue;
            maxST.add(edge);
        }

        return maxST;

    }
}
