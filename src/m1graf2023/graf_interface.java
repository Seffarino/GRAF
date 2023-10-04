package m1graf2023;

import java.util.List;

public interface graf_interface {

    int nbEdges();

    boolean existsEdge(Node u, Node v);

    boolean existsEdge(int uId, int vId);

    void addEdge(Node from, Node to);

    void addEdge(int fromId, int toId);

    void addEdge(Node from, Node to, int weight);

    void addEdge(int fromId, int toId, int weight);

    boolean removeEdge(Node from, Node to);

    boolean removeEdge(int fromId, int toId);

    boolean removeEdge(Node from, Node to, int weight);

    boolean removeEdge(int fromId, int toId, int weight);

    List<Edge> getOutEdges(Node n);

    List<Edge> getOutEdges(int nodeId);

    List<Edge> getInEdges(Node n);

    List<Edge> getInEdges(int nodeId);

    List<Edge> getIncidentEdges(Node n);

    List<Edge> getIncidentEdges(int nodeId);

    List<Edge> getEdges(Node u, Node v);

    List<Edge> getEdges(int uId, int vId);

    List<Edge> getAllEdges();

    int inDegree(Node n);

    int inDegree(int nodeId);

    int outDegree(Node n);

    int outDegree(int nodeId);

    int degree(Node n);

    int degree(int nodeId);

}
