package nz.ac.aut.hjw2617.dsa2017.lab04;

public class LinkedList {
	
	int size = 0;
	int start = 0;
	SLNode first = null;
	SLNode last = null;
			
	public void Add(SLNode node, int index){
		
		int counter = 0;
		
		if(first == null)
		{
			first = node;
			last = first;
		}else if(index == 0){
			
			node.next = first;
			first = node; 
		} else{
			SLNode current= first;
			
			while(current.next()!= null && counter<index){
				
				counter++;
				current = current.next();
			}
			 node.next = current.next();
			 current.next = node;
			 node.previous = current;
			 if(node.next() != null)
			 {
				 node.next.previous = node;
			 } else {
				 last = node;
			 }		 
		}	
		size++;
		
	}
	
	public boolean remove(int data){
		
		boolean found = false;
		if(found){
			size--;
		}
		 return found;
	}
	
	public SLNode first(){
		return first;
		
	}

}
