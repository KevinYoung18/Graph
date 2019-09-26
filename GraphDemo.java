import java.util.Iterator;

public class GraphDemo 
{
	public static void main(String[] args)
	{
		//recreates graph from task description
		Graph<String> graph = new Graph<String>();
		graph.addVertex("A");//0
		graph.addVertex("B");//1
		graph.addVertex("C");//2
		graph.addVertex("D");//3
		graph.addVertex("E");//4
		graph.addVertex("F");//5
		graph.addVertex("G");//6
		graph.addVertex("H");//7
		graph.addVertex("I");//8
		graph.addEdge(0,1);
		graph.addEdge(0,3);
		graph.addEdge(0,4);
		graph.addEdge(1,4);
		graph.addEdge(3,6);
		graph.addEdge(6,7);
		graph.addEdge(6,8);
		graph.addEdge(8,5);
		graph.addEdge(5,2);
		graph.addEdge(5,7);
		graph.addEdge(4,7);
		graph.addEdge(4,5);
		graph.addEdge(7,8);
		
		//create and print breadth first iterator beginning at node 0
		System.out.println("Breadth first traversal: ");
		Iterator<String> bfTraversal = graph.breadthFirst(0);
		while(bfTraversal.hasNext())
		{
			System.out.print(bfTraversal.next() + " ");
		}
		
		//create and print depth first iterator beginning at node 0
		System.out.println("\n\nDepth first traversal: ");
		Iterator<String> dfTraversal = graph.depthFirst(0);
		while(dfTraversal.hasNext())
		{
			System.out.print(dfTraversal.next() + " ");
		}
		
		
		 
	}
}
