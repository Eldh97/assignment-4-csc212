class BSTNode<K extends Comparable<K>, T> {
	public K key;
	public T data;
	public BSTNode<K, T> left, right;

	public BSTNode(K key, T data) {
		this.key = key;
		this.data = data;
		left = right = null;
	}
}

public class BST<K extends Comparable<K>, T> implements Map<K, T> {

	private BSTNode<K, T> root, current;

	public BST() {
		current = root = null;
	}

	@Override
	public boolean empty() {
		return root == null;
	}

	@Override
	public boolean full() {
		return false;
	}

	@Override
	public void clear() {
		current = root = null;
	}

	@Override
	public T retrieve() {
		return current.data;
	}
	
	@Override
	public void update(T e) {
		current.data = e;
	}

	@Override
	public boolean find(K key) {
		BSTNode<K, T> p = root,q = current;
		
		
		if(empty() )
		return false;
		
		while(p != null) {

		int res = key.compareTo(p.key);
		
		if(res == 0) {
		current = p;
		return true;
		}
		else if(res < 0)
		p = p.left;
		else
		p = p.right;
		}
		
		current = q;
		return false;
		
	}

	@Override
	public int nbKeyComp(K key) {
		
		BSTNode<K, T> p = root;
		int count =0 ;	
		
		
		
		if(empty() )
			return 0;
		
		while(p != null) {
			count++;
			int res = key.compareTo(p.key);
			
			if(res == 0) {
				return count ;
			}
			
			if(res < 0) {
				p = p.left;
			
			}else {
				p = p.right;
			}
	
	}
		return count ;
} 

	
	
	
	

	@Override
	public boolean insert(K key, T val) {
		if (root == null) {
			current = root = new BSTNode<K, T>(key, val);
			return true;
		}

		BSTNode<K, T> p = root;
		BSTNode<K, T> q = null;
		
		
		while (p != null) {
			int res = key.compareTo(p.key);
			if (res == 0) {
				break;
			} else {
				q = p;
				if (res < 0) {
					p = p.left;
				} else {
					p = p.right;
				}
			}
		}
		if (p != null) {
			return false;
		}

		BSTNode<K, T> tmp = new BSTNode<K, T>(key, val);
		if (key.compareTo(q.key) < 0) {
			q.left = tmp;
		} else {
			q.right = tmp;
		}
		current = tmp;
		return true;
	}
	
	
	

	@Override
	public boolean remove(K k) {

		// Search for k
		K k1 = k;
		BSTNode<K, T> p = root;
		BSTNode<K, T> q = null; // Parent of p
		while (p != null) {
			int res = k1.compareTo(p.key);
			if (res < 0) {
				q = p;
				p = p.left;
			} else if (res > 0) {
				q = p;
				p = p.right;
			} else { // Found the key

				// Check the three cases
				if ((p.left != null) && (p.right != null)) { // Case 3: two
																// children
					// Search for the min in the right subtree
					BSTNode<K, T> min = p.right;
					q = p;
					while (min.left != null) {
						q = min;
						min = min.left;
					}
					p.key = min.key;
					p.data = min.data;
					k1 = min.key;
					p = min;
					// Now fall back to either case 1 or 2
				}

				// The subtree rooted at p will change here
				if (p.left != null) { // One child
					p = p.left;
				} else { // One or no children
					p = p.right;
				}

				if (q == null) { // No parent for p, root must change
					root = p;
				} else {
					if (k1.compareTo(q.key) < 0) {
						q.left = p;
					} else {
						q.right = p;
					}
				}
				current = root;
				return true;

			}
		}

		return false; // Not found
	}

	@Override
	public List<Pair<K, T>> getAll() {
		
		if( empty())
			return null;
	
		List<Pair<K,T> > l = new LinkedList<Pair<K,T>>();
		
		recGetAll(root,l);
		return l;
	
	}
	
	private void recGetAll(BSTNode<K,T> p , List<Pair<K,T>> l){
		
		
			if(p == null)		
				return ;
			
			recGetAll(p.left,l);
			Pair<K,T> s = new Pair<K,T>(p.key , p.data);
			l.insert(s);
			recGetAll(p.right,l);	
		
		
		}
		
	
	
	}
	


	
