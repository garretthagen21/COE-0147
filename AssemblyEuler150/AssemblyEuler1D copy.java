public class AssemblyEuler1D{
	public static void main(String args[]) {
		//Row major : 32 X (10 X 3 + 4) = 272 , then add it to the base address
		int sol;
		//Test 1
		int [] numbers = {10, 273519, -153582, 450905, 5108, 288723, -97242, 394845, -488152, 83831, 341882, 301473, 466844, -200869, 366094, -237787, 180048, -408705, 439266, 88809, 499780, -104477, 451830, 381165, -313736, -409465, -17078, -113359, 13804, 455019, -388898, 359349, -355680, 89743, 127922, 30841, 229524, -480269, -345658, 163709, -166968, 310679, 194330, 70849, -516036, -411781, -491602, 523333, 293360, -262753, -235646, -181751, -477980, 275459, 459414, 332301};
		sol = -1495491;
		
		
		//Test 2 (Eulers)
		//sol = -42;
	    //int [] numbers = {6, 15, -14, -7, 20, -13, -5, -3, 8, 23, -26, 1, -4, -5, -18, 5, -16, 31, 2, 9, 28, 3};
		
		//Test 3  
		//int [] numbers = {4, 0, -3, -4, 1, 7, 2, 3, 5, 6, 7};
		//sol = -7;
		
		//Test 4
		//int [] numbers = {7, 273519, -153582, 450905, 5108, 288723, -97242, 394845, -488152, 83831, 341882, 301473, 466844, -200869, 366094, -237787, 180048, -408705, 439266, 88809, 499780, -104477, 451830, 381165, -313736, -409465, -17078, -113359, 13804};
		//sol: -488152;

				
		long startTime = System.nanoTime();		
		int depth = numbers[0];
		int minSum = numbers[1];
		int counter = 0;
		int currentRow = 1;
		int endIndex = (depth*(depth+1)/2);
		
		for(int i = 1; i <= endIndex; i++) {		//Basic iterator
			
			if(counter == currentRow) {	//Counter iterates N times for N apexes and then moves the row and resets on the N+1 time	
				counter = 0;			
				currentRow++;   	//What row is our current apex at
			}
			int rowSpan = 1;
			int startAddIndex = i;
			int triangleSum = 0;		//inital sum is the apex and then we add rows from there
			
			
			
	
			
			for(int tempRow = currentRow; tempRow <= depth; tempRow++) {			//go from here to the bottom
				
			   for(int j = 0; j < rowSpan ; j++) {		         //get the sum of the row below our apex
					triangleSum += numbers[j+startAddIndex];		//get the sum of the row and add it to the triangle
				}
			   if(triangleSum < minSum) 			//Check again after we calculated all of the triangles below it
					minSum = triangleSum; 
			   
				startAddIndex += tempRow; //Our next start index will be this far away from the current one
				rowSpan++;	//We will look at +1 elements in the next row 
			}
			
			counter++;
		}
		
		 
		
		 long endTime = System.nanoTime();
		 float elapsedTime = endTime - startTime;
		 elapsedTime = elapsedTime/1000000;
		 //System.out.println();
		 System.out.println("Minimum Sum = "+minSum);
		 if(sol == minSum) 
			 System.out.println("Pass!");
		 else
			 System.out.println("Fail!"); 
		 
		 System.out.println("Runtime = "+elapsedTime+ " milliseconds");
		
	}
	
}