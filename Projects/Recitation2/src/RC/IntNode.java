package RC;

public class IntNode {
	    public int data;
	    public IntNode next;
	    public IntNode(int data, IntNode next) {
	        this.data = data; this.next = next;
	    }
	    public String toString() {
	        return data + "";
	    }

	public static IntNode addBefore(IntNode front, int target, int newItem) {
		IntNode prev=null, curr=front;
		while(curr != null && curr.data != target) {
			prev =curr;
			curr = curr.next;    	
        }
		if(curr == null) {
			return front;
		}
		IntNode temp = new IntNode(newItem,curr);
		if(prev ==null) {
			return temp;
		}
		prev.next = temp;
		return front;
		
	}
	
	public static IntNode addBeforeLast(IntNode front, int item) {
		//Check for null at end
		if(front ==null) {
			return null;
		}
		IntNode prev=null, curr=front;
		while(curr != null) { //While loop that gets LL w/ target before the last one
			prev =curr;
			curr = curr.next;    	
        }
		if(curr == null) {
			return front;
		}
		IntNode temp = new IntNode(item,curr);
		if(prev ==null) {
			return temp;
		}
		prev.next = temp;
		return front;
		
        
	} 
	 public static StringNode deleteAllOccurrences(StringNode front, String target) {
        if(front == null) {
        	return null;
        }
        StringNode prev=null, curr=front;
        while(curr != null) {
        	if(curr.data == target) {
        		if(prev == null) {
        			front = curr.next;
        		}
        		else {
        			prev= curr;
        		}
        		prev.next = curr.next;
        	}
        	else prev = curr;
        	curr = curr.next;
        }
        return front;
	 } 
	 public IntNode commonElements(IntNode frontL1, IntNode frontL2) {
	 	IntNode first =null, last = null;
        while(frontL1 == null && frontL2  == null) {
        	
        }
		return last;
	 
        
   } 



	public class StringNode {
	    public String data;
	    public StringNode next;
	    public StringNode(String data, StringNode next) {
	        this.data = data; this.next = next;
	    }
	    public String toString() {
	        return data;
	    }
	   public int numberOfOccurrences(StringNode front, String target) {
          //Traverse but add a count
	    int count =0;
	      while(front != null) {
	    	  if(front.data.equals(target)) {
	    		  count++;
	    	  }
	    	  front.next=front;
	      }
	      return count;
      } 
	}
	}