import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;




public class Main {

	public static ArrayList<Integer> load(String file) throws FileNotFoundException
	{
		ArrayList<Integer> elements = new ArrayList<Integer>();
		Scanner sc = new Scanner(new FileInputStream(new File (file)));
		elements = new ArrayList<Integer>();
		
		while(sc.hasNext())
			elements.add(sc.nextInt());
		

		sc.close();
		
		return elements ;
	}
	
	public static void main(String[] args) throws Exception
	{ 
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> temp = null ;
		PerfectHashTable table = null ;
		while(true){
			System.out.println("______________________________________________________");
			System.out.println("(1)Load Keys\n(2)Build O(N) HashTable\n(3)Build O(N^2) HashTable\n(4)LookUp\n(5)Print the Table\n(6)Exit");
			int ch = scan.nextInt();
			
			if(ch==1){
				temp = load("keys2.txt");
				System.out.println("N ="+temp.size());
			}
			else if (ch==6)
				break ;
			else if(ch==5)
			{
				if(table != null)
					table.printTable();
			}
			else if(ch==4)
			{
				if(table!=null)
				{
					int i = scan.nextInt();
					if(table.lookUp(i))
						System.out.println("Found");
					else
						System.out.println("Not Found");
				}
			}
			else 
			{
				if(ch==2)
					table = new PerfectHashTableN(temp);
				else 
					table = new PerfectHashTableNN(temp);
				
				table.buildTable();
				
				table.printNumOfTries();
				table.printSize();	
			}
		}
		
		scan.close();
		
	}
}
