import java.util.Random;


public class UniversalHashing {

	private int b ;
	private int[] h;
	public UniversalHashing(int b )
	{
		this.b = b ; 
	}
	
	public void generateUniversalHF()
	{
		
		h = new int[b];
		Random r = new Random();
		
		for (int i = 0; i < b; i++) {
			h[i] = r.nextInt();
		}

	}
	
	
	public int h(int k )
	{
	    if(b==0)
	    	return 0 ;
	    
		StringBuilder sb = new StringBuilder();
		int numOfOnes ;
		
		for (int i = 0; i < b; i++) {
			
		    numOfOnes = Integer.bitCount(k&h[i]);
			sb.append(numOfOnes%2);
		}
		
		return Integer.parseInt(sb.toString(),2);
	}
}
