package m1graf2023;

import java.util.*;

/**
 * Represents a node in a graph.
 */
public class Node implements Comparable<Node> {
    private int id;
    private String name;

    /**
     * Constructs a node with the given ID.
     *
     * @param id The unique identifier for the node.
     */
    public Node(int id) {
        this.id = id;
        this.name = null;
    }

    /**
     * Constructs a node with the given ID and name.
     *
     * @param id   The unique identifier for the node.
     * @param name The name of the node.
     */
    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets the ID of the node.
     *
     * @return The ID of the node.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the node.
     *
     * @return The name of the node.
     */
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Node other = (Node) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}