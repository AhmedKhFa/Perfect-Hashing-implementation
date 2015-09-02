import java.util.ArrayList;





public class PerfectHashTableN extends PerfectHashTable {


	public PerfectHashTableN(ArrayList<Integer> e)
	{
		super(e);
	}
	
	public void buildTable() throws Exception {
		
		if(elements == null)
			   throw new Exception("EmptyElementsListException") ;
		
		 int idx ;
         int n = elements.size();
		 int b = (int) Math.floor(Math.log(n)/Math.log(2));
		  
		 table = new PerfectHashTableNN[n]; 
		 uh = new UniversalHashing(b) ;
		 uh.generateUniversalHF();
		
		 for (int i = 0; i < elements.size(); i++) {
			
			 idx = uh.h(elements.get(i));
			 
			 if(table[idx]==null)
			 {
				 table[idx] = new PerfectHashTableNN();
			 }
			 
			 ((PerfectHashTableNN)table[idx]).insert(elements.get(i));
		 }
		 
		 for (int i = 0; i < elements.size(); i++) {
			if(table[i]!=null)
			{
				try{
				 ((PerfectHashTableNN)table[i]).buildTable();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		 }
		 
		 elements = null ;
	}
	
	@Override
	public boolean lookUp(int i) {
		
		int idx = uh.h(i) ;
		if(idx<table.length && table[idx]!=null)
			return ((PerfectHashTableNN)table[idx]).lookUp(i);
		
		return false ;
	}

	
	/******************************************* Printing ********************************************/
	
	public void printNumOfTries() {
		
		int sum = 0 , bin;
		
		System.out.println("\n* Number of times of re-building :\n---------------------------------");
		for (int i = 0; i < table.length; i++) {
			
			if(table[i]!=null)
			{
				 bin = ((PerfectHashTableNN)table[i]).getNumOfTries();
				 sum += bin ;
			}
			else 
				bin=0;
			System.out.println("  -Bin #"+i+" :"+bin);
		}
		
		System.out.println("\n* Number of times to re-build all bins ="+sum);
	}
	

	public void printTable()
	{
		System.out.println("________________________________________________");
		for (int i = 0; i < table.length; i++) {
			if(table[i]!=null)
			{
				((PerfectHashTable)table[i]).printTable();
			}
			else
				System.out.println("[ ]");
		}
		System.out.println("________________________________________________");
	}
	
	public void printSize()
	{
		int sum = 0 ;
		for (int i = 0; i < table.length; i++) {
			if(table[i]!=null)
			{
				 sum +=((PerfectHashTableNN)table[i]).table.length;
			}
		}
		
		System.out.printf("* The hash table consumes (Space) = "+sum+ "= %.1f n\n",(sum*1.0/table.length));
	}

	

	
	
}
