public interface Map<K extends Comparable<K>, T> {

	// Return true if the tree is empty.
	boolean empty();

	// Return true if the tree is full.
	boolean full();

	// Removes all elements in the map.
	void clear();

	// Return the key and data of the current element
	T retrieve();

	// Update the data of current element.
	void update(T e);

	// Search for element with key key and make it the current element if it exists. If the element does not exist the current is unchanged and false is returned.
	boolean find(K key);

	// Return the number of key comparisons needed to find key. Current must not change.
	int nbKeyComp(K key);

	// Insert a new element if does not exist and return true. The current points to the new element. If the element already exists, current does not change and false is returned.
	boolean insert(K key, T data);

	// Remove the element with key key if it exists and return true. If the element does not exist false is returned (the position of current is unspecified after calling this method).
	boolean remove(K key);

	// Return all elements of the map as a List sorted in increasing order of the keys.
	List<Pair<K, T>> getAll();
}
