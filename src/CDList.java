
public class CDList {

	Node cdlist = null;
	
	public Node create_endInsert(String filepath){
	   Node n1 = new Node(filepath);
	   if(cdlist == null)
	   {
		   cdlist = n1;
		   cdlist.right = cdlist;
		   cdlist.left = cdlist;
	   }
	   else
	   {
       Node temp = cdlist.left;
       temp.right = n1;
       n1.left = temp;
       cdlist.left = n1;
       n1.right = cdlist;
	   }
	   return n1;
	}
	
	public Node create_positionInsert(String filepath, int pos)//pos got from DB
	{
		Node n1 = new Node(filepath);
		
		if(pos==1)//Insert at first position
		{
			if(cdlist==null)//Empty list
			{
				cdlist = n1;
			    cdlist.right = n1;
			    cdlist.left = n1;
			}   
			else
			{
				Node last = null;
			    last = cdlist.left;
			    n1.left = last; last.right = n1;
			    cdlist.left = n1; n1.right = cdlist;
			    cdlist = n1;
			}
			return n1;
		}
		
		else
		{
			if(cdlist==null)//Empty list
			{
				cdlist = n1;
			    cdlist.right = n1;
			    cdlist.left = n1;
			}
			
			Node temp = cdlist; Node prev = null; int i = 0;
			while((temp.right!=cdlist)&&(i<pos))
			{
				prev = temp;
				temp = temp.right;
				i++;
			}
			
			if(pos==i)
			{
				prev.right = n1; n1.left = prev;
				temp.left = n1; n1.right = temp;
			}
			else if(pos==i+1)//End insertion
			{
				temp.right = n1; n1.left = temp;
				n1.right = cdlist; cdlist.left = n1;
			}
			else
			{
				//Invalid input
			}
		}
		return n1;
		
	   }
	
	 public void deletePosition(String filepath, int pos){
		 
		 if(cdlist==null){
			 //Empty list
		 }
		 if(pos==1)
		 {
			 if(cdlist.right == cdlist)
			 {
				 cdlist = null; 
			 }
			 else
			 {
			 cdlist.left.right = cdlist.right;
			 cdlist.right.left = cdlist.left;
			 cdlist = cdlist.right;
			 }
		 }
		 else
		 {
			 Node temp = cdlist; Node prev = null; int i = 0;
			 while((temp.right!=cdlist)&&(i<pos)){
				 prev = temp;
				 temp = temp.right;
				 i++;
			 }
			 if(pos==i)
			 {
				 prev.right = temp.right;
				 temp.right.left = prev;
			 }
			 else if(pos==i+1)
			 {
				 prev.right = cdlist;
				 cdlist.left = prev;
			 }	 
		 }
		 
	 }
	 
	 
}
