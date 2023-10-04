import static org.junit.jupiter.api.Assertions.*;

import m1graf2023.Edge;
import m1graf2023.Graf;
import m1graf2023.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import m1graf2023.Graf;
import m1graf2023.Node;
import m1graf2023.Edge;


class GrafTest {
    private Graf graf;

    @BeforeEach
    void setUp() {
        graf = new Graf();
    }

    @Test
    void testAddNode() {
        Node node = new Node(1);
        assertTrue(graf.addNode(node));
        assertEquals(1, graf.nbNodes());
    }

    @Test
    void testAddNodeWithId() {
        assertTrue(graf.addNode(2));
        assertEquals(1, graf.nbNodes());
    }

    @Test
    void testRemoveNode() {
        Node node = new Node(1);
        graf.addNode(node);
        assertTrue(graf.removeNode(node));
        assertEquals(0, graf.nbNodes());
    }

    @Test
    void testRemoveNodeWithId() {
        graf.addNode(1);
        assertTrue(graf.removeNode(1));
        assertEquals(0, graf.nbNodes());
    }

    @Test
    void testExistsNode() {
        Node node = new Node(1);
        graf.addNode(node);
        assertTrue(graf.existsNode(node));
    }

    @Test
    void testExistsNodeWithId() {
        graf.addNode(1);
        assertTrue(graf.existsNode(1));
    }
    @Test
    void testAddEdge() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Edge edge = new Edge(node1, node2);

        graf.addNode(node1);
        graf.addNode(node2);
        graf.addEdge(edge);

        assertEquals(1, graf.getOutEdges(node1).size());
        assertEquals(edge, graf.getOutEdges(node1).get(0));
    }

    @Test
    void testAddAndRemoveEdges() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        // Add edges
        graf.addEdge(node1, node2, 5);
        graf.addEdge(node1, node3, 3);

        // Test existence of edges
        assertTrue(graf.existsEdge(node1, node2));
        assertTrue(graf.existsEdge(node1, node3));
        assertFalse(graf.existsEdge(node2, node3));

        // Remove an edge
        assertTrue(graf.removeEdge(node1, node2));
        assertFalse(graf.existsEdge(node1, node2));

        // Remove another edge
        assertTrue(graf.removeEdge(node1, node3));
        assertFalse(graf.existsEdge(node1, node3));
    }

    @Test
    void testGetOutEdges() {
        // Create nodes and add edges
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        graf.addEdge(node1, node2, 5);
        graf.addEdge(node1, node3, 3);

        // Test getOutEdges
        assertEquals(2, graf.getOutEdges(node1).size());
        assertEquals(0, graf.getOutEdges(node2).size());
        assertEquals(0, graf.getOutEdges(node3).size());
    }

    @Test
    void testGetInEdges() {
        // Create nodes and add edges
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        graf.addEdge(node1, node2, 5);
        graf.addEdge(node1, node3, 3);

        // Test getInEdges
        assertEquals(0, graf.getInEdges(node1).size());
        assertEquals(1, graf.getInEdges(node2).size());
        assertEquals(1, graf.getInEdges(node3).size());
    }

    // Add more test methods for other operations...

    @Test
    void testNbEdges() {
        // Create nodes and add edges
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        graf.addEdge(node1, node2, 5);
        graf.addEdge(node1, node3, 3);

        assertEquals(2, graf.nbEdges());
    }

    @Test
    void testGetAllEdges() {
        // Create nodes and add edges
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        graf.addEdge(node1, node2, 5);
        graf.addEdge(node1, node3, 3);

        assertEquals(2, graf.getAllEdges().size());
    }

    @Test
    void testInDegree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        // Add edges
        graf.addEdge(node1, node2);
        graf.addEdge(node1, node3);
        graf.addEdge(node2, node3);

        assertEquals(0, graf.inDegree(node1));
        assertEquals(1, graf.inDegree(node2));
        assertEquals(2, graf.inDegree(node3));
    }

    @Test
    void testOutDegree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        // Add edges
        graf.addEdge(node1, node2);
        graf.addEdge(node1, node3);
        graf.addEdge(node2, node3);

        assertEquals(2, graf.outDegree(node1));
        assertEquals(1, graf.outDegree(node2));
        assertEquals(0, graf.outDegree(node3));
    }

    @Test
    void testDegree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        // Add edges
        graf.addEdge(node1, node2);
        graf.addEdge(node1, node3);
        graf.addEdge(node2, node3);

        assertEquals(2, graf.degree(node1));
        assertEquals(2, graf.degree(node2));
        assertEquals(2, graf.degree(node3));
    }

    // Add more test methods as needed.

}
