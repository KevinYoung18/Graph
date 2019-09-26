import java.util.LinkedList;

public interface GraphInterface<T> 
{
	public void addEdge(int source, int target);	
	public void removeEdge(int source, int target);
	public void addVertex(T data);
	public boolean isEdge(int source, int target);
	public T getData(int vertex);
	public void setData(int vertex, T data);
	public LinkedList<Integer> getNeighbors(int vertex);
	public int size();
}
