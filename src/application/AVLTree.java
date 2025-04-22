package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AVLTree {
	 private Node root;
	 private Movie topRanked;
	 private Movie leastRanked;

	    // Utility methods for AVL Tree balancing

	    private int getHeight(Node node) {
	        if (node == null) return -1;  // A null node has a height of -1
	        return node.getHeight();
	    }
	    
	    public int getAverageHeight() {
	        return calculateAverageHeight(root);
	    }

	    private int calculateAverageHeight(Node node) {
	        if (node == null) return 0;
	        return node.getHeight();
	    }
	    

	    public Node getRoot() {
			return root;
		}


		private void updateHeight(Node node) {
	        node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
	    }

	    private int getBalance(Node node) {
	        int leftHeight = getHeight(node.getLeft());
	        int rightHeight = getHeight(node.getRight());
	        return leftHeight - rightHeight;
	    }
	    

	    private Node rotateRight(Node node) {
	    	Node leftChild = node.getLeft();
	        node.setLeft(leftChild.getRight());
	        leftChild.setRight(node);
	        updateHeight(node);
	        updateHeight(leftChild);
	        return leftChild;
	    }

	    private Node rotateLeft(Node node) {
	    	Node rightChild = node.getRight();
	        node.setRight(rightChild.getLeft());
	        rightChild.setLeft(node);
	        updateHeight(node);
	        updateHeight(rightChild);
	        return rightChild;
	    }

	    // Insert a movie into the AVL tree
	    public void insert(Object data) {
	        root = insert(data,root);
	    }

	    private Node insert(Object data, Node node) {
	        // If the current node is null, create a new node with the given data
	        if (node == null) {
	            return new Node(((Movie) data).getTitle(), data);
	        }
	        
	        // Compare the movie title (key) with the current node's key
	        int comparison = ((Movie) data).getTitle().trim().toLowerCase().compareTo(((Movie)node.getData()).getTitle().trim().toLowerCase());
	        
	        // If the data's title is greater than the current node's title, insert into the right subtree
	        if (comparison > 0) {
	            node.setRight(insert(data, node.getRight()));
	        } 
	        // If the data's title is smaller, insert into the left subtree
	        else if (comparison < 0) {
	            node.setLeft(insert(data, node.getLeft()));
	        }
	        // If the title already exists, don't insert the data (no duplicates allowed)
	        else {
	            // return the existing node without any changes to prevent duplicates
	        	node.setData(data);
	            return node;
	        }

	        // Update the height and balance the tree after insertion
	        updateHeight(node);
	        node = balance(node);
	        
	        // Return the potentially rebalanced node
	        return node;
	    }
	    
	    public void delete(Object data) {
	        root = delete(data, root);
	    }

	    private Node delete(Object data, Node node) {
	        // If the node is null, return null (base case)
	        if (node == null) {
	            return null;
	        }

	        // Compare the title of the movie to the key of the current node
	        Movie movie = (Movie) data;
	        String title = movie.getTitle();

	        if (title.compareTo(((Movie)node.getData()).getTitle()) > 0) {
	            // Movie title is greater, go to the right
	            node.setRight(delete(data, node.getRight()));
	        } else if (title.compareTo(((Movie)node.getData()).getTitle()) < 0) {
	            // Movie title is smaller, go to the left
	            node.setLeft(delete(data, node.getLeft()));
	        } else {
	            // Node to delete is found
	            // Case 1: Node has no children (leaf node)
	            if (node.getLeft() == null && node.getRight() == null) {
	                return null;
	            }
	            // Case 2: Node has one child
	            else if (node.getLeft() == null) {
	                return node.getRight();
	            }
	            else if (node.getRight() == null) {
	                return node.getLeft();
	            }
	            // Case 3: Node has two children
	            else {
	                // Find the in-order successor (smallest node in the right subtree)
	                Node successor = getMin(node.getRight());
	                // Replace the current node's key with the successor's key and data
	                //node.setKey(((Movie)successor.getData()).getTitle());
	                node.setData(successor.getData());
	                // Delete the successor node from the right subtree
	                node.setRight(delete(successor.getData(), node.getRight()));
	            }
	        }
	     // Update the height of the current node
	        updateHeight(node);
	        // Rebalance the tree
	        return balance(node);
	    }
	    
	    private Node getMin(Node node) {
	        while (node.getLeft() != null) {
	            node = node.getLeft();
	        }
	        return node;
	    }
	    

	    public Movie search(String title) {
	        if (title == null) {
	            return null;  // or handle null title case
	        }
	        return search(title, root);
	    }
	    private Movie search(String title, Node node) {
	        if (node == null) {
	            return null;
	        }

	        Movie currentMovie = (Movie) node.getData();
	        String nodeTitle = currentMovie.getTitle().trim().toLowerCase();
	        String searchTitle = title.trim().toLowerCase();

	        System.out.println("Searching for: " + searchTitle);
	        System.out.println("Checking node with title: " + nodeTitle);

	        // Compare the given title with the current node's key (movie title)
	        int comparison = searchTitle.compareTo(nodeTitle);

	        if (comparison > 0) {
	            // If the title is greater, search in the right subtree
	            return search(title, node.getRight());
	        } else if (comparison < 0) {
	            // If the title is smaller, search in the left subtree
	            return search(title, node.getLeft());
	        } else {
	            // If the titles match, return the movie object associated with the node
	            return currentMovie;  
	        }
	    }


	    
	 // Search for movies by year in all nodes, including duplicates
	    public SLL searchByYear(int year) {
	        SLL result = new SLL();

	        // Traverse the tree and collect movies with matching year
	        collectMoviesByYear(root, year, result);

	        return result;
	    }

	    private void collectMoviesByYear(Node node, int year, SLL result) {
	        if (node == null) {
	            return;
	        }

	        // Check the current node's movie
	        Movie movie = (Movie) node.getData();
	        if (movie.getYear() == year) {
	            result.addFirst(movie);  // Add to result if the movie's year matches
	        }

	        // Recurse into left and right subtrees
	        collectMoviesByYear(node.getLeft(), year, result);
	        collectMoviesByYear(node.getRight(), year, result);
	    }
	    
	    private Node balance(Node node) {
	    	int bf=getBalance(node);
	    	if(bf>1) {//left side problem
	    		if(getBalance(node.getLeft())>=0) {//single rotation to the right
	    			node=rotateRight(node);
	    		}
	    		else {//double rotation to the right
	    			node.setLeft(rotateLeft(node.getLeft()));
	    			node=rotateRight(node);
	    		}
	    	}
	    	else if(bf<-1) {
	    		if(getBalance(node.getRight())<=0) {
	    			node=rotateLeft(node);
	    		}
	    		else {
	    			node.setRight(rotateRight(node.getRight()));
	    			node=rotateLeft(node);
	    		}
	    	}
	    	return node;
	    }
	    
	    public ObservableList<Movie> getMoviesInAscendingOrder() {
	        ObservableList<Movie> movieList = FXCollections.observableArrayList();
	        inOrderTraversal(root, movieList);  // Perform in-order traversal to fill the list
	        return movieList;
	    }

	    private void inOrderTraversal(Node node, ObservableList<Movie> movieList) {
	        if (node == null) {
	            return;
	        }

	        // First, traverse the left subtree
	        inOrderTraversal(node.getLeft(), movieList);

	        // Then, visit the current node (add its data to the list)
	        movieList.add((Movie) node.getData());  

	        // Finally, traverse the right subtree
	        inOrderTraversal(node.getRight(), movieList);
	    }
	    
	    public ObservableList<Movie> getMoviesInDescendingOrder() {
	        ObservableList<Movie> movieList = FXCollections.observableArrayList();
	        inOrderDescendingTraversal(root, movieList);  // Perform reverse in-order traversal to fill the list
	        return movieList;
	    }

	    private void inOrderDescendingTraversal(Node node, ObservableList<Movie> movieList) {
	        if (node == null) {
	            return;
	        }

	        // First, traverse the right subtree (this is the change for descending order)
	        inOrderDescendingTraversal(node.getRight(), movieList);

	        // Then, visit the current node (add its data to the list)
	        movieList.add((Movie) node.getData());  // Assuming 'Movie' is your data class

	        // Finally, traverse the left subtree (this is the change for descending order)
	        inOrderDescendingTraversal(node.getLeft(), movieList);
	    }
	    
	    public void clearTree() {
	        root = null;  
	       
	    }
	    public boolean isEmpty() {
	    	if(root==null)
	    		return true;
	    	return false;			
	    }
	    
	    //highest rank movie 
	    public Movie getHighestRankedMovie() {
	        return getHighestRankedMovie(root);
	    }

	    private Movie getHighestRankedMovie(Node node) {
	        if (node == null) {
	            return null; // Return null if the node is empty
	        }

	        // Get the current movie from the node
	        Movie currentMovie = (Movie) node.getData();
	        Movie highestRankedMovie = currentMovie; // Assume the current movie is the highest-ranked

	        // Search the left and right subtrees for higher-ranked movies
	        Movie leftHighest = getHighestRankedMovie(node.getLeft());
	        if (leftHighest != null && leftHighest.getRating() > highestRankedMovie.getRating()) {
	            highestRankedMovie = leftHighest; // Update if the left movie has a higher rank
	        }

	        Movie rightHighest = getHighestRankedMovie(node.getRight());
	        if (rightHighest != null && rightHighest.getRating() > highestRankedMovie.getRating()) {
	            highestRankedMovie = rightHighest; // Update if the right movie has a higher rank
	        }

	        return highestRankedMovie;
	    }
	    
	    //lowest Rank
	    public Movie getLowestRankedMovie() {
	        return getLowestRankedMovie(root);
	    }

	    private Movie getLowestRankedMovie(Node node) {
	        if (node == null) {
	            return null; // Return null if the node is empty
	        }

	        // Get the current movie from the node
	        Movie currentMovie = (Movie) node.getData();
	        Movie lowestRankedMovie = currentMovie; // Assume the current movie is the lowest-ranked

	        // Search the left and right subtrees for lower-ranked movies
	        Movie leftLowest = getLowestRankedMovie(node.getLeft());
	        if (leftLowest != null && leftLowest.getRating() < lowestRankedMovie.getRating()) {
	            lowestRankedMovie = leftLowest; // Update if the left movie has a lower rank
	        }

	        Movie rightLowest = getLowestRankedMovie(node.getRight());
	        if (rightLowest != null && rightLowest.getRating() < lowestRankedMovie.getRating()) {
	            lowestRankedMovie = rightLowest; // Update if the right movie has a lower rank
	        }

	        return lowestRankedMovie;
	    }

}
