import java.util.Scanner;



public class Client {

	public static long sleeping;
	public static int flag = 0;

	public static void main(String args[]) throws Exception 
	{
		Scanner in = new Scanner(System.in);
		CDList cdl = new CDList();
		Node n1 = cdl.create_endInsert("/home/utkarsh/Music/Lost.mp3");
		Functions fn = new Functions(n1);
		while(true){
			System.out.println("1.Play; 2. Pause; 3. Exit");
			int ch = in.nextInt();
			switch(ch){
			case 1 : if(flag==1) fn.resumeThread();
			fn.play(); break;
			case 2 : fn.suspendThread(); fn.pause(); flag = 1; 
			break;
			case 3 : System.exit(0); break;
			}
		}
		
		
	}
}