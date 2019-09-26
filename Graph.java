import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph<T> implements GraphInterface<T> 
{

	private LinkedList<LinkedList<Integer>> graph = new  LinkedList<LinkedList<Integer>>();
	private LinkedList<T> data;
	
	public Graph()
	{
		graph = new  LinkedList<LinkedList<Integer>>();
		data = new LinkedList<T>();
	}
	
	public void addEdge(T source, T target)
	{
		addEdge(this.getVertexContaining(source),this.getVertexContaining(target));
	}
	public void addEdge(int source, int target) 
	{
		if(!this.isEdge(source, target))
			graph.get(source).add(target);
	}

	public void addVertex(T data) 
	{
		LinkedList<Integer> vertex= new LinkedList<Integer>();
		graph.add(vertex);
		this.data.add(data);

	}
	
	public boolean isEdge(int source, int target) {
		return graph.get(source).contains(target);
	}

	public T getData(int vertex) 
	{
		return data.get(vertex);
	}

	public void setData(int vertex, T data) {
		this.data.set(vertex, data);

	}

	public LinkedList<Integer> getNeighbors(int vertex) {
		return graph.get(vertex);
	}

	public int size() {
		return graph.size();
	}

	public void removeEdge(T source, T target)
	{
		removeEdge(this.getVertexContaining(source),this.getVertexContaining(target));
	}
	public void removeEdge(int source, int target) {
		if(this.isEdge(source, target))
			graph.get(source).remove(target);
	}
	
	public int getVertexContaining(T data)
	{
		return this.data.indexOf(data);
	}
	
	public Iterator<T> breadthFirst(int startingIndex)
	{
		LinkedList<Integer> order = new LinkedList<Integer>(); // order to visit elements
		LinkedList<Integer> toVisit = new LinkedList<Integer>(); //queue of elements to be visited
		
		LinkedList<Integer> currentVertex;
		toVisit.push(startingIndex);
		
		while(!toVisit.isEmpty())
		{	
			int nextVertex = toVisit.pollFirst();
			currentVertex = graph.get(nextVertex);
			order.add(nextVertex);
			//push all neighbors of current vertex to toVisit
			for(int j = 0; j < currentVertex.size(); j++)
			{
				//only push items that haven't been visited or are not on the queue toVisit
				if(!order.contains(currentVertex.get(j)) && !toVisit.contains(currentVertex.get(j)))
				{
					toVisit.add(currentVertex.get(j));
				}
			}		
		}
		Iterator<T> bfTraversal = new GraphIterator(order);
		return bfTraversal;
		
	}
	public Iterator<T> depthFirst(int startingIndex)
	{
		LinkedList<Integer> order = new LinkedList<Integer>();
		Stack<Integer> vStack = new Stack<Integer>();
		LinkedList<Integer> currentVertex;
		
		vStack.push(startingIndex);
		order.add(startingIndex);
		while(!vStack.isEmpty())
		{
			currentVertex = graph.get(vStack.peek()); //set current vertex to list corresponding to top of stack
			
			if(!currentVertex.isEmpty())
			{
				int neighbor = currentVertex.pollFirst();
				
				//cycle through visited neighbors to find unvisited neighbor
				while(order.contains(neighbor))
				{
					if(currentVertex.isEmpty())
						break;
					neighbor = currentVertex.pollFirst();
				}
				// if all neighbors have been cycled through without finding unvisited node
				if(order.contains(neighbor))
				{
					vStack.pop();
				}
				else
				{
					order.add(neighbor);
					vStack.add(neighbor);
				}
			}
			else {
				vStack.pop();
			}
		}
		Iterator<T> dfTraversal = new GraphIterator(order);
		return dfTraversal;
	}
	private class GraphIterator implements Iterator<T>
	{
		LinkedList<Integer> order;
		
		public GraphIterator(LinkedList<Integer> list)
		{
			order = list;
		}
		public boolean hasNext() {
			return !order.isEmpty();
		}
		
		public T next() {
			return data.get(order.pollFirst());
		}
		
	}
}
