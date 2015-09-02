import java.util.ArrayList;


public  abstract class PerfectHashTable {

	Object[] table ;
	UniversalHashing uh ;
	ArrayList<Integer> elements ;
	
	public PerfectHashTable(ArrayList<Integer> e)
	{
		elements = e ;
	}
	
	public PerfectHashTable()
	{ 
		elements = new ArrayList<Integer>();
	}
	
	
	public abstract void buildTable() throws Exception;
	public abstract boolean lookUp(int i) ;
	public abstract void printNumOfTries();
	public abstract void printTable();
	public abstract void printSize();
}
