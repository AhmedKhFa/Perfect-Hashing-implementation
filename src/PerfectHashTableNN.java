import java.util.ArrayList;





public class PerfectHashTableNN extends PerfectHashTable {


	private int numOfTries ;
	
	public PerfectHashTableNN(ArrayList<Integer> e) {
		super(e);
	}
	

	public PerfectHashTableNN()
	{
	      super();	
	}

	
   @Override
	public void buildTable() throws Exception {
		
	   if(elements == null)
		   throw new Exception("EmptyElementsListException") ;
	   
	   int n = elements.size();
	   int b = (int) Math.floor(Math.log(n*n)/Math.log(2));
	   		
	   uh = new UniversalHashing(b) ;
	   
	   boolean collision;
	   int idx , e ;
		
		do
		{
			
			table = new Object[n*n];
			collision  = false ;
			uh.generateUniversalHF();

			for (int i = 0; i < elements.size(); i++) {
				e=elements.get(i);
				idx = uh.h(e); 
				
				if(table[idx]!=null && ((int)table[idx])!=e)
				{
					numOfTries++;
					collision =true ;
					break;	
				}
				
				table[idx] = e;
			}
			
		}while(collision);
	   
		elements = null ;  
	}
   
//    public void insert(int i) // for duplicate
//  	{
//  		if(elements == null)
//  			elements = new ArrayList<Integer>();
//  		
//  		elements.remove((Object)i);	
//  		elements.add(i);
//  	}

   
    public void insert(int i)
	{
		if(elements == null)
			elements = new ArrayList<Integer>();
		
		elements.add(i);
	}

	public int getNumOfTries()
	{
		return numOfTries;
	}
	
	@Override
	public boolean lookUp(int i) {
		
		int idx = uh.h(i) ;
		if(idx<table.length && table[idx]!=null && (int)table[idx]==i)
			return true ;
		
		return false;
	}
   
   /******************************************* Printing ********************************************/
    public void printTable()
    {
    	System.out.print("[|");
    	for (int i = 0; i < table.length; i++) {
    		if(table[i]!=null)
			 System.out.print(table[i]+"|");
    		else
    			System.out.print(" |");
		}
    	System.out.println("]");
    }
   @Override
	public void printNumOfTries() {
		
		System.out.println("Number of times to re-build the hash table ="+numOfTries);
		
	}

	@Override
	public void printSize() {
		// TODO Auto-generated method stub
		System.out.println("The Size Of The Table = "+table.length);
	}


	
	
	

}
