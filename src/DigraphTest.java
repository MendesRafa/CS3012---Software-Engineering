import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DigraphTest {

	@Test
	void testVertexOnlyConstructor() {
		Digraph test = new Digraph(5);
		assertEquals(test.V, 5, "When a graph is created with 5 verties as the paramter the number of vertices should be 5");
		
		test = new Digraph(0);
		assertEquals(test.V, 0, "When a graph is created with 0 verties as the paramter the number of vertices should be 0");
		
		assertThrows(RuntimeException.class, () -> {
			Digraph invalidGraph = new Digraph(-2);
		}, "When a negative number is passed as a paramter to the contructor it should throw a runtime exception");
	}

}
