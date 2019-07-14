package tavern;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		/* Rules:
		 * 
		 * 1) The sum of the divisors (including 1, but not the number itself) of the tap number is greater than tap number itself
		 * 2) No subset of those divisors sums up to the tap number itself
		 * 
		 */
		
		// ( Rule 1 ) Check if Divisors are matches first rule.  # Get sum of divisors and then check if sum of divisors is higher then the number itself
		// If it matches get subsets of set (divisors)
		//  ( Rule 2 ) Check if sum of subset is equal TapNumber then stop checking for subsets anymore and avoid this tap number
		// At the end show all 
		
		TavernMethods methods = new TavernMethods();
		
		List<Integer> BestBeerTaps = new ArrayList<Integer>();
		System.out.println("Loading...");
		for (int i = 1; i <= 1000; i++) {
			if(methods.isTheBestBeerTap(i) == true) { //
				BestBeerTaps.add(i);
			}
		}
		for (Integer beertap : BestBeerTaps) {
			System.out.println(beertap);
		}
		
		
	}	
}
