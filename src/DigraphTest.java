import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DigraphTest {

	@Test
	void testVertexOnlyConstructor() {
		Digraph test = new Digraph(5);
		assertEquals(test.V, 5,
				"When a graph is created with 5 verties as the paramter the number of vertices should be 5");

		test = new Digraph(0);
		assertEquals(test.V, 0,
				"When a graph is created with 0 verties as the paramter the number of vertices should be 0");

		assertThrows(IllegalArgumentException.class, () -> {
			Digraph invalidGraph = new Digraph(-2);
		}, "When a negative number is passed as a paramter to the contructor it should throw a runtime exception");
	}

	@Test
	void testIsVertexValid() {
		Digraph test = new Digraph(4);

		assertFalse(test.isVertexValid(-1), "If the supplied vertex < 0 then it is invalid");
		assertTrue(test.isVertexValid(3), "If the supplied vertex > 0 and < V then it is valid");
		assertFalse(test.isVertexValid(4), "If the supplied vertex > V then it is invalid");
	}

	@Test
	void testAddEdge() {
		Digraph test = new Digraph(4);
		assertEquals(test.E, 0, "Whenever a graph is first constructed it should have 0 edges");

		test.addEdge(1, 0);
		assertEquals(test.E, 1, "Whenever an edge is added to an empty graph it should have 1 edge");

		test.addEdge(0, 1);
		assertEquals(test.E, 2,
				"If an edge is added but in an opposite direction the number of edges should still increase");

		assertThrows(IllegalArgumentException.class, () -> {
			test.addEdge(1, 0);
		}, "Whenever an edge is added to a graph that already has that edge an exception should be thrown");

		assertThrows(IllegalArgumentException.class, () -> {
			test.addEdge(-1, 2);
		}, "Whenever an edge with an invalid vertex is added to a graph an exception should be thrown");

		assertThrows(IllegalArgumentException.class, () -> {
			test.addEdge(2, 4);
		}, "Whenever an edge with an invalid vertex is added to a graph an exception should be thrown");

		assertThrows(IllegalArgumentException.class, () -> {
			test.addEdge(-1, 4);
		}, "Whenever an edge with an invalid vertex is added to a graph an exception should be thrown");
	}
	
	@Test
	void testIndegree() {
		Digraph testGraph = new Digraph(4);
		testGraph.addEdge(0,1);
		testGraph.addEdge(0, 2);
		testGraph.addEdge(1, 3);
		testGraph.addEdge(2, 3);
		
		assertThrows(IllegalArgumentException.class, () -> {
			testGraph.indegree(5);
		}, "If the vertex passed as the input is invalid then an exception is thrown");

		assertEquals(0, testGraph.indegree(0), "In this graph vertex 0 has no inbound edges i.e. indegree = 0");
		assertEquals(1, testGraph.indegree(1), "In this graph vertex 1 has 1 inbound edges i.e. indegree = 1");
		assertEquals(1, testGraph.indegree(2), "In this graph vertex 2 has 1 inbound edges i.e. indegree = 1");
		assertEquals(2, testGraph.indegree(3), "In this graph vertex 3 has 2 inbound edges i.e. indegree = 2");
	}
}
