package files;

class Node<T>{
    protected T data;
    protected Node next;
   
   Node(T num){
        this.data = num;
        next = null;
    }
}
public class GenericLinkList<T>{
	static int el=0;
	protected Node head;
	   
    public GenericLinkList(){
        head = null;
    }
   
    @SuppressWarnings("unchecked")
	public <T> void insertData(T data) {
    	
    	if(head==null) {
    	
    		head= new Node(data);
    		
    		
    	}else {
    	
    		Node temp=head;
    		while(temp.next!=null) {
    			temp=temp.next;
    		}
    		temp.next=new Node(data);
    	}
    
    }
   
    public void PrintLinkNode(GenericLinkList<T> myobj) {
    	
    	Node temp=head;
    	while(temp!=null) {
    		
    		myobj.insertData(temp.data);
    		temp=temp.next;
    	}
    }
    public void PrintLinkNode() {
    	
    	Node temp=head;
    	while(temp!=null) {
    		
    		System.out.println(temp.data+" ");
    		temp=temp.next;
    	}
    }
    public int[] StorePrintLinkNode() {
    	int MyArr[] = new int[100];
    	int i=0;
    	Node temp=head;
    	while(temp!=null) {
    		
    		MyArr[i++]=(int)temp.data;
    		temp=temp.next;
    	}
    	return MyArr;
    }
    public boolean searchLinkNode(T data) {
    	
    	boolean flag=false;
    	Node temp = head;
    	while(temp!=null) {
    		
    		if(temp.data==data) {
    			flag = true;
    			break;
    		}
    		temp=temp.next;
    	}
    	return flag;
    }
	
    public void remove(T data) {
    	
    	if(head.data==data) {
    		head = head.next;
    	}else {
    		Node temp = head;
    		Node prev = null;
    		while(temp!=null) {
    			if(temp.data==data) {
    				prev.next=temp.next;
    			}
    			prev=temp;
    			temp = temp.next;
    		}
    	}
    }
 
 }
