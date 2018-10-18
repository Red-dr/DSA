package nz.ac.aut.hjw2617.dsa2017.lab04;

public class SLNode {
	
	int data;
	SLNode next;
	SLNode previous;
	
	
/*
 * holds the slingley linked lists data
 */
	public SLNode (int data){
		
		this.data = data;
	}
/*
 *	
 */
	public void setnext(SLNode next){
		
		this.next = next;
		
	}
	/*
	 * returns the next LSNode in the list
	 */
	public SLNode next(){
		
		return next;
	}
	
	public void setprevious(SLNode previous){
		
		this.previous = previous;
	}
/*
 * retuns the SLNode Previous node
 */
	public SLNode previous(){
		
		return previous;
	}
}
