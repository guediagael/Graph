/**
 * Created by TheLetch on 23/02/2017.
 */
public class Edge<T> {

    private boolean DIRECTION_FLAG = false;
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private int weight;

    public Edge(Vertex<T> outgoing , Vertex<T> incoming){
        vertex1 =outgoing;
        vertex2 =incoming;
    }

    public Edge(Vertex<T> start, Vertex<T> end,boolean isDirected){
        vertex1= start;
        vertex2=end;
        DIRECTION_FLAG=isDirected;
    }

    public Edge(Vertex<T> start, Vertex<T> end,boolean isDirected,int weight){
        vertex1= start;
        vertex2=end;
        this.weight= weight;
        DIRECTION_FLAG=isDirected;
    }

    public void setVertex1(Vertex<T> vertex1) {
        this.vertex1 = vertex1;
    }

    public void setVertex2(Vertex<T> vertex2) {
        this.vertex2 = vertex2;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public boolean getDirectionFlag() {
        return DIRECTION_FLAG;
    }

    public Vertex<T> getVertex1() {
        return vertex1;
    }

    public Vertex<T> getVertex2() {
        return vertex2;
    }

    public int getWeight() {
        return weight;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
        result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
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
        Edge other = (Edge) obj;
        if (vertex1 == null) {
            if (other.vertex1 != null)
                return false;
        } else if (!vertex1.equals(other.vertex1))
            return false;
        if (vertex2 == null) {
            if (other.vertex2 != null)
                return false;
        } else if (!vertex2.equals(other.vertex2))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Edge [isDirected=" + DIRECTION_FLAG + ", vertex1=" + vertex1
                + ", vertex2=" + vertex2 + ", weight=" + weight + "]";
    }

}
