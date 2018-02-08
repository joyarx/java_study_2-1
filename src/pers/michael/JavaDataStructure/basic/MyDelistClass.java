package pers.michael.JavaDataStructure.basic;

import java.util.Scanner;

public class MyDelistClass {
	
	public class MyNode{
		private int value;
		private MyNode next = null;
		private MyNode prev = null;
		
		public void setValue(int input) {
			value = input;
			System.out.println(value);
		}
		public int getValue() {
			return value;
		}
		public MyNode getNext() {
			return next;
		}
		public void setNext(MyNode node) {
			next = node;
		}
		public MyNode getPrev() { 
			return prev;
		}
		public void setPrev(MyNode node) {
			prev = node;
		}
	}
	
	public static class MyDelist{
		
		private MyNode root = new MyNode();
		private int size = 0;
		
		public int getSize() {
			return size;
		}
		public void insert(int index, MyNode node) {
			
			MyNode next = root;
			
			if(index>size) return;
			for (int i=0; i<index; i++) {				
				next = next.getNext();
			}
			if (next.getNext()!=null)
				node.setNext(next.getNext());
			next.setNext(node);
			
			node.setPrev(next);
			node.getNext().setPrev(node);
			
			size++;
		}	
		
		public MyNode get(int index) {
			
			MyNode next = root;
			
			if(index>size) return null;
			for (int i=0; i<index; i++) {				
				next = next.getNext();
			}
            return next;	
		}
		
		public void remove(int index) {
			
			MyNode current = root;
			
			if (index > size || index <= 0) return;
			
			for (int i=0; i<index-1; i++) {				
				current = current.getNext();
			}
			current.setNext(current.getNext().getNext());
			size--;
		}
		
		public void replace(int index, MyNode node) {
			
			MyNode next = root;
			
			if(index > size) return;
			for (int i=0; i<index-1; i++) {				
				next = next.getNext();
			}		
			next.getPrev().setNext(node);
			next.getNext().setPrev(node);
			node.setPrev(next.getPrev());
			node.setNext(next.getNext());

		}
		public void view() 
		{
			MyNode current = root;
			
			for (int i=0; i<=size; i++) {
				System.out.println(i + " " + current.getValue());
				current = current.getNext();
			}
		}

	}

}
