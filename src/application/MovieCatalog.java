package application;

import java.io.*;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

class MovieCatalog {
    private AVLTree[] catalog;
   // private int size;
    private int capacity;
    private FileChooser fileChooser;
    
    public MovieCatalog(int initialCapacity) {
        this.capacity = initialCapacity;
        this.catalog = new AVLTree[capacity];
        for (int i = 0; i < capacity; i++) {
        	catalog[i] = new AVLTree();
        }
    }
    
    public MovieCatalog() {
    	allocate();
    }

    // Constructor to allocate the hash table
    public void allocate() {
        this.capacity =211;
        catalog = new AVLTree[capacity];

        // Initialize each bucket in the hash table with an empty AVL tree
        for (int i = 0; i < capacity; i++) {
            catalog[i] = new AVLTree();
        }
    }

    // Simple hash function for titles
    public int hashFunction(String title) {
        int hash = 0;
        for (int i = 0; i < title.length(); i++) {
            hash = 31 * hash + title.charAt(i);
        }

        // Ensure that the result is always non-negative
        int positiveHash = hash % capacity;
        if (positiveHash < 0) {
            positiveHash += capacity;  // Ensure it's positive if negative
        }

        return positiveHash;
    }
    // Put a movie in the catalog (add or update)
    public void put(Movie movie) {
    	if (avgheight()>=3) {
	            rehash();
        }
        int index = hashFunction(movie.getTitle());
        catalog[index].insert(movie);
        
    }
    
    public ObservableList<Movie> searchForYear(int year){
        ObservableList<Movie> l = FXCollections.observableArrayList();
        for (int i = 0; i < catalog.length; i++) {
            SLL s = catalog[i].searchByYear(year);  // Get the linked list of movies for the year
            SNode n = s.getFirst();  // Get the first node in the list
            if (n != null) {
                // Traverse the linked list and add each movie to the ObservableList
                for (int j = 0; j < s.getCount(); j++) {
                    l.add((Movie) n.getElement());  // Add movie to the ObservableList
                    n = n.getNext();  // Move to the next node in the list
                }
            }
        }
        return l;  // Return the list of movies for the specified year
    }

    // Get a movie by title
    public Movie get(String title) {
        int i = hashFunction(title.trim());
		Movie n=catalog[i].search(title);
		return n;
    }

    // Erase a movie by title
    public void erase(String title) {
        int index = hashFunction(title);
        
        catalog[index].delete(get(title));
    }

 

    // Find the next prime number larger than a given size
    private int findNextPrime(int size) {
        while (true) {
            if (isPrime(size)) {
                return size;
            }
            size++;
        }
    }

    // Deallocate the hash table 
    public void deallocate() {
        // Loop through each AVLTree in the catalog and clear its memory
        for (int i = 0; i < capacity; i++) {
                //catalog[i] = null;
                catalog[i].clearTree();
        }
    }
    
	  private void rehash() {
	    	
	        
	        AVLTree[] newTable = new AVLTree[nextPrime(2*capacity)];
	        for (int i = 0; i < newTable.length; i++) {
	            newTable[i] = new AVLTree();
	        }
	
	        // Rehash all existing movies into the new table
	        for (AVLTree oldTree : catalog) {
	        	rehashTree(oldTree, newTable);
	        }
	
	        catalog = newTable;
	}
	    
	    private double avgheight() {
	    	// Calculate the average height
	        int totalHeight = 0;
	        for (AVLTree tree : catalog) {
	            totalHeight += tree.getAverageHeight();
	        }

	        return totalHeight / catalog.length;
	    }
	private void rehashTree(AVLTree oldTree, AVLTree[] newTable) {
	    // Perform an in-order traversal of the old AVL tree to extract all the movies
	    inOrderTraversalAndRehash(oldTree.getRoot(), newTable);
	}
	private void inOrderTraversalAndRehash(Node node, AVLTree[] newTable) {
	    if (node == null) {
	        return;
	    }
	
	    // First traverse the left subtree
	    inOrderTraversalAndRehash(node.getLeft(), newTable);
	
	    // Rehash the current movie into the new table
	    Movie movie = (Movie)node.getData();
	    int newIndex = hashFunction(movie.getTitle());
	    newTable[newIndex].insert(movie);
	
	    // Then traverse the right subtree
	    inOrderTraversalAndRehash(node.getRight(), newTable);
	}
	
	//========= Load movies from file==============
	public void loadMoviesFromFile() {
	    fileChooser = new FileChooser();
	    File file = fileChooser.showOpenDialog(new Stage()); 
	    if (file != null) {
	        try (Scanner scanner = new Scanner(file)) {
	            String line;
	            String title = null;
	            String description = null;
	            double rating = 0;
	            int year = 0;
	            int i=0;

	            while (scanner.hasNext()) {
	                line = scanner.nextLine().trim();
	                if (line.isEmpty()) {
	                    // If we encounter an empty line, it means we finished one movie record.
	                    if (title != null && description != null && year != 0 && rating != 0) {
	                        // Create a Movie object and put it into the catalog
	                        put(new Movie(title, description, year, rating));
	                        System.out.println(i++);
	                    }
	                    // Reset fields for the next movie
	                    title = description = null;
	                    year = 0;
	                    rating = 0;
	                } else {
	                    // Process each field based on its label
	                    String[] parts = line.split(":", 2);  // Split into key and value
	                    if (parts.length == 2) {
	                        String key = parts[0].trim();
	                        String value = parts[1].trim();

	                        // Store data based on the key
	                        switch (key.toLowerCase()) {
	                            case "title":
	                                title = value;
	                                break;
	                            case "description":
	                                description = value;
	                                break;
	                            case "release year":
	                                try {
	                                    year = Integer.parseInt(value);
	                                } catch (NumberFormatException e) {
	                                    System.out.println("Invalid year format for: " + title);
	                                }
	                                break;
	                            case "rating":
	                                try {
	                                    rating = Double.parseDouble(value);
	                                } catch (NumberFormatException e) {
	                                    System.out.println("Invalid rating format for: " + title);
	                                }
	                                break;
	                            default:
	                                System.out.println("Unknown field: " + key);
	                        }
	                    }
	                }
	            }

	            // If there’s any remaining movie data not added (in case the file doesn't end with an empty line)
	            if (title != null && description != null && year != 0 && rating != 0) {
	                put(new Movie(title, description, year, rating));
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (IllegalArgumentException o) {
	            o.printStackTrace();
	        }
	    }
	}
	
	//=========== Save movies to file======================
    public void saveMoviesToFile() {
    	fileChooser = new FileChooser();
	    File file = fileChooser.showOpenDialog(new Stage());
	    if(file!=null) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	            for (int i = 0; i < capacity; i++) {
	                AVLTree tree = catalog[i];
	                if (!tree.isEmpty()) {
	                    // Traverse the AVL tree and write to file 
	                    writeMoviesToFile(tree, writer);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		    }
    }

    // In-order traversal of AVL Tree to write movies to file
    private void writeMoviesToFile(AVLTree tree, BufferedWriter writer) {
        writeMoviesToFile(tree.getRoot(), writer);
    }

    // Recursive method to traverse AVL tree in-order and write movie details
    private void writeMoviesToFile(Node node, BufferedWriter writer) {
        if (node == null) {
            return;  // Base case: If the node is null, stop recursion
        }

        // Recursively traverse the left subtree
        writeMoviesToFile(node.getLeft(), writer);

        try {
            // Write the current movie's details to the file
            Movie movie = (Movie)node.getData();
            writer.write("Title: " + movie.getTitle());
            writer.newLine();  
            writer.write("Description: " + movie.getDescription());
            writer.newLine();  
            writer.write("Release Year: " + movie.getYear());
            writer.newLine();  
            writer.write("Rating: " + movie.getRating());
            writer.newLine();  
            writer.newLine();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Recursively traverse the right subtree
        writeMoviesToFile(node.getRight(), writer);
    }
    
    private int nextPrime(int n) {
    	if(n%2==0)
    		n++;
    	while(!isPrime(n)) {
    		n+=2;
    	}
    	return n;
    }
    private boolean isPrime(int n) {
    	if(n==2||n==3)
    		return true;
    	if(n<2||n%2==0)
    		return false;
    	for(int i=3;i*i<=n;i+=2) {
    		if(n%i==0)
    			return false;
    	}
    	return true;
    }
    
    public AVLTree[] getTrees() {
    	return catalog;
    }
}
