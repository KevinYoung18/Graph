the Graph class implements the GraphInterface interface and generics and creates a graph object using an adjacency list 
the index of each node is the order in which it is created beginning at 0 (i.e. 0, 1, 2, ...)

Methods:
	addEdge: adds an edge to the graph from the vertices at the indices represented by parameters source to target 
		if that edge doesn't exist can also pass the objects as parameters source and destination, this will 
		create an edge between vertices containing  those objects
	removeEdge: removes an edge to the graph from the vertices at the indices represented by parameters source to 
		target if that edge exists can also pass the objects as parameters source and destination, this will remove an 
		edge between vertices containing  those objects
	addVertex: creates a new vertex with the parameter data at the index after the last added node
	isEdge: returns true if an edge exists between the vertices at the indices represented by parameters source and destination
	setData: sets parameter data to the vertex corresponding to the index from parameter vertex
	getData: return data at vertex corresponding to the index from parameter vertex
	getNeighbors: returns a linked list containing index of nodes
	getVertexContaining: returns index of a vertex containing parameter data
	
