package tavern;

import java.util.ArrayList;

public class TavernMethods {
	
	public boolean sumsUpWithTapNumber = false;
	public int TapNumber = 0;
	
	public boolean isTheBestBeerTap(int number) {
		
		TapNumber = number;
		//get divisors
		ArrayList<Integer> Set = new ArrayList<Integer>();
		int total = 0;
		for (int i = 1; i < TapNumber; i++) {
			if(TapNumber%i == 0) {
				Set.add(i);
				total += i;
			}
		}
		//check if the sum of divisors is higher then the number itself and then get the subsets of the set
		if(total > TapNumber) { 
			//System.out.println(TapNumber + " has " + Set.size()+ " sets");
			GetSubsets(Set);
			if(sumsUpWithTapNumber == false) {
				return true;
			}
			else {
				sumsUpWithTapNumber = false;
			}
		}
		Set.clear();
		
		return false;
	}
	
	public void GetSubsets(ArrayList<Integer> Set) {
		int n = Set.size();
		
	    int[] SetInArray = new int[n];
	    for (int i=0; i < SetInArray.length; i++)
	    {
	        SetInArray[i] = Set.get(i).intValue();
	    }
		int[] subSet = new int[n];
		
		helper(SetInArray, subSet, 0);
	}
	
	//Helper method of finding subsets of divisors set
	public void helper(int[] set, int[] subset, int i) {
		int total = 0;
		
		if(i == set.length) {
			for (int j = 0; j < subset.length; j++) {
				total += subset[j];
			}
			if(total == TapNumber) {
				sumsUpWithTapNumber = true;
				// here we can try to stop checking for subsets of a set because it will increase performance 
			}
		}
		else if(sumsUpWithTapNumber == false) {
			subset[i] = 0;
			helper(set, subset, i+1);
			subset[i] = set[i];
			helper(set, subset, i+1);
		}
	}
}
