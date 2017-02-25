import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheLetch on 23/02/2017.
 */
public class Vertex<T> {

    private long id;
    private T data;
    private List<Edge<T>> edgeList;
    private List<Vertex<T>> adjacentVertexList;
    private boolean isLeaf= false;

    public Vertex(long id){
        edgeList= new ArrayList<>();
        adjacentVertexList =new ArrayList<>();
        isLeaf=true;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void addAdjacentVertex(Edge<T> edge, Vertex<T> vertex){
        edgeList.add(edge);
        adjacentVertexList.add(vertex);
    }

    public void setAsLeaf(){
        isLeaf = true;
    }

    public void setAsNonLeaf(){
        isLeaf= false;
    }

    public boolean checkIfLeaf(){

        return isLeaf;
    }

    public long getId() {
        return id;
    }

    public T getData() {
        return data;
    }

    public List<Edge<T>> getEdgeList() {
        return edgeList;
    }

    public List<Vertex<T>> getAdjacentVertexList() {
        return adjacentVertexList;
    }

    int getDegree(){
        return edgeList.size();
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
