import java.util.*;

/**
 * Created by TheLetch on 23/02/2017.
 */
public class Graph<T> {

    private List<Edge<T>> edges;
    private Map<Long,Vertex<T>> vertices;
    boolean isDirected = false;
    private Vertex<T> root;

    public Graph(boolean isDirected){
        edges = new ArrayList<>();
        vertices = new HashMap<>();
        this.isDirected =isDirected;
    }

    public void addEdge(long startVertexId, long endVertexId, int weight){
        Vertex<T> start = null;
        if (vertices.containsKey(startVertexId)) {
            start=vertices.get(startVertexId);
            if (this.isDirected && start.checkIfLeaf())
                start.setAsNonLeaf();
        }
        else {
            start = new Vertex<T>(startVertexId);
            vertices.put(startVertexId,start);

        }
        Vertex<T> end= null;
        if (vertices.containsKey(endVertexId)) end=vertices.get(endVertexId);
        else {
            end= new Vertex<T>(endVertexId);
            vertices.put(endVertexId,end);
        }


        Edge<T> edge = new Edge<T>(start,end, isDirected,weight);
        edges.add(edge);
        start.addAdjacentVertex(edge,end);
        if (!isDirected){
            end.addAdjacentVertex(edge,start);
        }
    }

    public void addEdge(long startVertexId, long endVertexId){
        addEdge(startVertexId,endVertexId,0);
    }


    //Obviously for directed graphs
    public void addDirectedVertex(Vertex<T> vertex){
        if (vertices.containsKey(vertex.getId())) return;
        if (vertices.size()==0) root = vertex;
        vertices.put(vertex.getId(),vertex);
        for (Edge<T> edge: vertex.getEdgeList()) edges.add(edge);
    }

    //obviously for undirected graphs
    public Vertex<T> addUndirectedVertex(long id){
        if (vertices.containsKey(id)){
            return vertices.get(id);
        }
        Vertex<T> v = new Vertex<T>(id);
        vertices.put(id,v);
        return v;
    }

    public void setDataForVertex(long id, T data){
        if (vertices.containsKey(id)){
            Vertex<T> vertex= vertices.get(id);
            vertex.setData(data);
        }
    }

    public void setRoot(Vertex<T> root) {
        this.root = root;
    }


    public Vertex<T> getRoot(){
        return root;
    }

    //    public Vertex<T> getRoot() {
//        return root;
//    }

    public Vertex<T> getVertex(long id){
        return vertices.get(id);
    }


    public List<Edge<T>> getEdges() {
        return edges;
    }

    public Collection<Vertex<T>> getVertices(){
        return  vertices.values();
    }


}
