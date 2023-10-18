package m1graf2023;

import java.util.*;
import java.io.*;
import java.util.regex.*;
/**
 * Represents a directed graph using an adjacency edge list.
 */
public class Graf implements graf_interface{
    private Map<Node, List<Edge>> adjEdList;

    /**
     * Constructs an empty graph.
     */
    public Graf() {
        adjEdList = new HashMap<>();
    }

    /**
     * Constructs a graph from the successor array.
     */
    public Graf(int... values) {
        adjEdList = new HashMap<>();
        int currentNode = 1;
        for(int val : values){
            addNode(currentNode);
            if(val == 0){
                currentNode++;
            }
            else
            {
                addNode(val);
                addEdge(currentNode,val);
            }
        }
    }
    /**
     * Returns the number of nodes in the graph.
     *
     * @return The number of nodes in the graph.
     */
    public int nbNodes() {
        return adjEdList.size(); // Returns the number of nodes in the graph
    }


    /**
     * Checks if a node exists in the graph.
     *
     * @param n The node to check.
     * @return true if the node exists in the graph, false otherwise.
     */
    public boolean existsNode(Node n) {
        return adjEdList.containsKey(n);
    }

    /**
     * Checks if a node with a specific ID exists in the graph.
     *
     * @param nodeId The ID of the node to check.
     * @return true if a node with the specified ID exists, false otherwise.
     */
    public boolean existsNode(int nodeId) {
        for (Node node : adjEdList.keySet()) {
            if (node.getId() == nodeId) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves a node instance by its ID.
     *
     * @param id The ID of the node to retrieve.
     * @return The node instance or null if no node with the given ID exists.
     */
    public Node getNode(int id) {
        for (Node node : adjEdList.keySet()) {
            if (node.getId() == id) {
                return node;
            }
        }
        return null;
    }

    /**
     * Adds a node to the graph.
     *
     * @param n The node to add.
     * @return true if the node is successfully added, false if it already exists in the graph.
     */
    public boolean addNode(Node n) {
        if (!existsNode(n)) {
            adjEdList.put(n, new ArrayList<>());
            return true;
        }
        return false;
    }

    /**
     * Adds a node with a specific ID to the graph.
     *
     * @param nodeId The ID of the node to add.
     * @return true if the node is successfully added, false if a node with the same ID already exists.
     */
    public boolean addNode(int nodeId) {
        Node newNode = new Node(nodeId);
        return addNode(newNode);
    }

    /**
     * Removes a node from the graph.
     *
     * @param n The node to remove.
     * @return true if the node is successfully removed, false if it does not exist in the graph.
     */
    public boolean removeNode(Node n) {
        if (existsNode(n)) {
            adjEdList.remove(n);

            // Remove all edges incident to the node
            for (List<Edge> edges : adjEdList.values()) {
                edges.removeIf(edge -> edge.getTo().equals(n));
            }

            return true;
        }
        return false;
    }

    /**
     * Removes a node with a specific ID from the graph.
     *
     * @param nodeId The ID of the node to remove.
     * @return true if the node is successfully removed, false if a node with the same ID does not exist in the graph.
     */
    public boolean removeNode(int nodeId) {
        Node nodeToRemove = getNode(nodeId);
        if (nodeToRemove != null) {
            return removeNode(nodeToRemove);
        }
        return false;
    }

    public List<Node> getSuccessors(Node n) {
        return null;
    }

    public List<Node> getSuccessorsMulti(Node n) {
        return null;
    }

    public boolean adjacent(Node u, Node v) {
        return false;
    }

    // ... Other methods ...

    /**
     * Retrieves a list of all nodes in the graph.
     *
     * @return A list of all nodes in the graph.
     */
    public List<Node> getAllNodes() {
        return new ArrayList<>(adjEdList.keySet());
    }

    /**
     * Finds the largest node ID used in the graph.
     *
     * @return The largest node ID or Integer.MIN_VALUE if no nodes exist.
     */
    public int largestNodeId() {
        int largestId = Integer.MIN_VALUE;
        for (Node node : adjEdList.keySet()) {
            int nodeId = node.getId();
            if (nodeId > largestId) {
                largestId = nodeId;
            }
        }
        return largestId;
    }

    /**
     * Finds the smallest node ID used in the graph.
     *
     * @return The smallest node ID or Integer.MAX_VALUE if no nodes exist.
     */
    public int smallestNodeId() {
        int smallestId = Integer.MAX_VALUE;
        for (Node node : adjEdList.keySet()) {
            int nodeId = node.getId();
            if (nodeId < smallestId) {
                smallestId = nodeId;
            }
        }
        return smallestId;
    }

    /**
     * Adds an edge to the graph.
     *
     * @param edge The edge to add.
     */
    public void addEdge(Edge edge) {
        Node fromNode = edge.getFrom();
        Node toNode = edge.getTo();

        if (!adjEdList.containsKey(fromNode)) {
            addNode(fromNode);
        }

        if (!adjEdList.containsKey(toNode)) {
            addNode(toNode);
        }

        adjEdList.get(fromNode).add(edge);
    }

    /**
     * Gets the out-edges of a node in the graph.
     *
     * @param node The node for which to retrieve out-edges.
     * @return A list of out-edges for the given node.
     */
    public List<Edge> getOutEdges(Node node) {
        return adjEdList.getOrDefault(node, Collections.emptyList());
    }

    /**
     * Returns the number of edges in the graph.
     *
     * @return The number of edges in the graph.
     */
    @Override
    public int nbEdges() {
        int count = 0;
        for (List<Edge> edges : adjEdList.values()) {
            count += edges.size();
        }
        return count;
    }

    /**
     * Checks if an edge exists between nodes u and v.
     *
     * @param u The source node.
     * @param v The target node.
     * @return true if an edge exists, false otherwise.
     */
    @Override
    public boolean existsEdge(Node u, Node v) {
        List<Edge> outEdges = adjEdList.get(u);
        if (outEdges != null) {
            for (Edge edge : outEdges) {
                if (edge.getTo().equals(v)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if an edge exists between nodes with the given IDs.
     *
     * @param uId The ID of the source node.
     * @param vId The ID of the target node.
     * @return true if an edge exists, false otherwise.
     */
    @Override
    public boolean existsEdge(int uId, int vId) {
        Node u = getNode(uId);
        Node v = getNode(vId);
        if (u != null && v != null) {
            return existsEdge(u, v);
        }
        return false;
    }

    /**
     * Adds an unweighted edge from node 'from' to node 'to'.
     *
     * @param from The source node.
     * @param to   The target node.
     */
    @Override
    public void addEdge(Node from, Node to) {
        addEdge(from, to, 0);
    }

    /**
     * Adds an unweighted edge between nodes with the given IDs.
     *
     * @param fromId The ID of the source node.
     * @param toId   The ID of the target node.
     */
    @Override
    public void addEdge(int fromId, int toId) {
        Node from = getNode(fromId);
        Node to = getNode(toId);
        if (from != null && to != null) {
            addEdge(from, to, 0);
        }
    }

    /**
     * Adds a weighted edge from node 'from' to node 'to'.
     *
     * @param from   The source node.
     * @param to     The target node.
     * @param weight The weight of the edge.
     */
    @Override
    public void addEdge(Node from, Node to, int weight) {
        adjEdList.computeIfAbsent(from, k -> new ArrayList<>()).add(new Edge(from, to, weight));
    }

    /**
     * Adds a weighted edge between nodes with the given IDs.
     *
     * @param fromId The ID of the source node.
     * @param toId   The ID of the target node.
     * @param weight The weight of the edge.
     */
    @Override
    public void addEdge(int fromId, int toId, int weight) {
        Node from = getNode(fromId);
        Node to = getNode(toId);
        if (from != null && to != null) {
            addEdge(from, to, weight);
        }
    }

    /**
     * Removes an edge between nodes 'from' and 'to'.
     *
     * @param from The source node.
     * @param to   The target node.
     * @return true if the removal succeeded, false otherwise.
     */
    @Override
    public boolean removeEdge(Node from, Node to) {
        List<Edge> outEdges = adjEdList.get(from);
        if (outEdges != null) {
            Iterator<Edge> iterator = outEdges.iterator();
            while (iterator.hasNext()) {
                Edge edge = iterator.next();
                if (edge.getTo().equals(to)) {
                    iterator.remove();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes an edge between nodes with the given IDs.
     *
     * @param fromId The ID of the source node.
     * @param toId   The ID of the target node.
     * @return true if the removal succeeded, false otherwise.
     */
    @Override
    public boolean removeEdge(int fromId, int toId) {
        Node from = getNode(fromId);
        Node to = getNode(toId);
        if (from != null && to != null) {
            return removeEdge(from, to);
        }
        return false;
    }

    public boolean removeEdge(Node from, Node to, int weight) {
        List<Edge> outEdges = adjEdList.get(from);
        if (outEdges != null) {
            Iterator<Edge> iterator = outEdges.iterator();
            while (iterator.hasNext()) {
                Edge edge = iterator.next();
                if (edge.getTo().equals(to) && edge.getWeight() == weight) {
                    iterator.remove();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeEdge(int fromId, int toId, int weight) {
        Node from = getNode(fromId);
        Node to = getNode(toId);
        if (from != null && to != null) {
            return removeEdge(from, to, weight);
        }
        return false;
    }

    @Override
    public List<Edge> getOutEdges(int nodeId) {
        Node node = getNode(nodeId);
        return getOutEdges(node);
    }

    @Override
    public List<Edge> getInEdges(Node n) {
        List<Edge> inEdges = new ArrayList<>();
        for (Node node : adjEdList.keySet()) {
            List<Edge> edges = adjEdList.get(node);
            if (edges != null) {
                for (Edge edge : edges) {
                    if (edge.getTo().equals(n)) {
                        inEdges.add(edge);
                    }
                }
            }
        }
        return inEdges;
    }

    @Override
    public List<Edge> getInEdges(int nodeId) {
        Node node = getNode(nodeId);
        return getInEdges(node);
    }

    @Override
    public List<Edge> getIncidentEdges(Node n) {
        List<Edge> incidentEdges = new ArrayList<>();
        incidentEdges.addAll(getOutEdges(n));
        incidentEdges.addAll(getInEdges(n));
        return incidentEdges;
    }

    @Override
    public List<Edge> getIncidentEdges(int nodeId) {
        Node node = getNode(nodeId);
        return getIncidentEdges(node);
    }

    @Override
    public List<Edge> getEdges(Node u, Node v) {
        List<Edge> edgesFromU = adjEdList.get(u);
        List<Edge> matchingEdges = new ArrayList<>();
        if (edgesFromU != null) {
            for (Edge edge : edgesFromU) {
                if (edge.getTo().equals(v)) {
                    matchingEdges.add(edge);
                }
            }
        }
        return matchingEdges;
    }

    @Override
    public List<Edge> getEdges(int uId, int vId) {
        Node u = getNode(uId);
        Node v = getNode(vId);
        return getEdges(u, v);
    }

    @Override
    public List<Edge> getAllEdges() {
        List<Edge> allEdges = new ArrayList<>();
        for (List<Edge> edges : adjEdList.values()) {
            allEdges.addAll(edges);
        }
        return allEdges;
    }
    @Override
    public int inDegree(Node n) {
        int inDegree = 0;
        for (List<Edge> edges : adjEdList.values()) {
            for (Edge edge : edges) {
                if (edge.getTo().equals(n)) {
                    inDegree++;
                }
            }
        }
        return inDegree;
    }

    @Override
    public int inDegree(int nodeId) {
        Node n = getNode(nodeId);
        if (n != null) {
            return inDegree(n);
        }
        return 0;
    }

    @Override
    public int outDegree(Node n) {
        List<Edge> outEdges = adjEdList.get(n);
        return outEdges != null ? outEdges.size() : 0;
    }

    @Override
    public int outDegree(int nodeId) {
        Node n = getNode(nodeId);
        if (n != null) {
            return outDegree(n);
        }
        return 0;
    }

    @Override
    public int degree(Node n) {
        return inDegree(n) + outDegree(n);
    }

    @Override
    public int degree(int nodeId) {
        Node n = getNode(nodeId);
        if (n != null) {
            return degree(n);
        }
        return 0;
    }
        // ... (previous methods)

        // Static method to import a graph from a DOT file with default extension ".gv"
        public static Graf fromDotFile(String filename) {
            return fromDotFile(filename, ".gv");
        }

        // Static method to import a graph from a DOT file with a specified extension
        public static Graf fromDotFile(String filename, String extension) {
            Graf graf = new Graf();

            try (BufferedReader reader = new BufferedReader(new FileReader(filename + extension))) {
                String line;
                Pattern edgePattern = Pattern.compile("(\\d+)\\s*->\\s*(\\d+);");

                while ((line = reader.readLine()) != null) {
                    Matcher matcher = edgePattern.matcher(line);
                    if (matcher.find()) {
                        int fromId = Integer.parseInt(matcher.group(1));
                        int toId = Integer.parseInt(matcher.group(2));
                        Node from = new Node(fromId);
                        Node to = new Node(toId);
                        graf.addNode(from);
                        graf.addNode(to);
                        graf.addEdge(new Edge(from, to));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return graf;
        }

        // Method to export the graph as a String in DOT syntax
        public String toDotString() {
            StringBuilder dotString = new StringBuilder("digraph G {\n");

            for (Edge edge : getAllEdges()) {
                dotString.append("  ").append(edge.getFrom().getId()).append(" -> ").append(edge.getTo().getId()).append(";\n");
            }

            dotString.append("}\n");

            return dotString.toString();
        }

        // Method to export the graph as a DOT file with default extension ".gv"
        public void toDotFile(String fileName) {
            toDotFile(fileName, ".gv");
        }

        // Method to export the graph as a DOT file with a specified extension
        public void toDotFile(String fileName, String extension) {
            try (PrintWriter writer = new PrintWriter(fileName + extension)) {
                writer.println(toDotString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
