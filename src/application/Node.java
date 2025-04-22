package application;

import java.util.LinkedList;

public class Node {
	//private String key;
	private Node left,right;
	private Object data;
	private int height;
	
	public Node(String key, Object data) {
		super();
		//this.key = key;
		this.data = data;
		this.left = null;
        this.right = null;
        this.height = 0; 
       
	}
//	public String getKey() {
//		return key;
//	}
//	public void setKey(String key) {
//		this.key = key;
//	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	
	
	

}
