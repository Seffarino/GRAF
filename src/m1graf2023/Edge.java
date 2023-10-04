package m1graf2023;

import java.util.Objects;

/**
 * Represents an edge in a graph.
 */
public class Edge implements Comparable<Edge>, edge_interface{
    private Node from;
    private Node to;
    private int weight;

    /**
     * Constructs an unweighted edge between two nodes.
     *
     * @param from The source node of the edge.
     * @param to   The target node of the edge.
     */
    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
        this.weight = 0;
    }

    /**
     * Constructs a weighted edge between two nodes.
     *
     * @param from   The source node of the edge.
     * @param to     The target node of the edge.
     * @param weight The weight of the edge.
     */
    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    /**
     * Gets the source node of the edge.
     *
     * @return The source node.
     */
    public Node getFrom() {
        return from;
    }

    /**
     * Gets the target node of the edge.
     *
     * @return The target node.
     */
    public Node getTo() {
        return to;
    }

    /**
     * Gets the weight of the edge.
     *
     * @return The weight of the edge, or null if it is not weighted.
     */
    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge other) {
        int cmp = Integer.compare(this.from.getId(), other.from.getId());
        if (cmp == 0) {
            cmp = Integer.compare(this.to.getId(), other.to.getId());
            if (cmp == 0) {
                cmp = Integer.compare(this.weight, other.weight);
            }
        }
        return cmp;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Edge other = (Edge) obj;
        return from.equals(other.from) && to.equals(other.to) && weight == other.weight;
    }

    public String toString() {
        return from.toString() + " -> " + to.toString() + " (Weight: " + weight + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(toString());
    }

    /**
     * Gets the source node of the edge.
     *
     * @return The source node.
     */
    @Override
    public Node from() {
        return from;
    }

    /**
     * Gets the target node of the edge.
     *
     * @return The target node.
     */
    @Override
    public Node to() {
        return to;
    }

    /**
     * Gets the symmetric of the edge as a new Edge instance.
     *
     * @return The symmetric edge.
     */
    @Override
    public Edge getSymmetric() {
        return new Edge(to, from, weight);
    }

    /**
     * Checks if the edge is a self-loop.
     *
     * @return true if the edge is a self-loop, false otherwise.
     */
    public boolean isSelfLoop() {
        return from.equals(to);
    }

    /**
     * Checks if the edge is weighted.
     *
     * @return true if the edge is weighted, false if it is not.
     */
    public boolean isWeighted() {
        return weight != 0;
    }

}

