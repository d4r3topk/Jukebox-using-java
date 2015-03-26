
public class Node {

  Node left, right;
  String filepath;
  Node(String filepath){
	  this.filepath = filepath;
	  //Need to concatenate with folderpath here
	  this.left = null;
	  this.right = null;
  }
  

}
