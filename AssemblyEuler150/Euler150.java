import java.util.*;

public class Euler150{
	public static void main(String args[]) {
		//Row major : 32 X (10 X 3 + 4) = 272 , then add it to the base address
		
		//Test 1
		//int [] numbers = {10, 273519, -153582, 450905, 5108, 288723, -97242, 394845, -488152, 83831, 341882, 301473, 466844, -200869, 366094, -237787, 180048, -408705, 439266, 88809, 499780, -104477, 451830, 381165, -313736, -409465, -17078, -113359, 13804, 455019, -388898, 359349, -355680, 89743, 127922, 30841, 229524, -480269, -345658, 163709, -166968, 310679, 194330, 70849, -516036, -411781, -491602, 523333, 293360, -262753, -235646, -181751, -477980, 275459, 459414, 332301};
		//sol = -1495491
	
		
		//Test 2 (Eulers)
		//sol = -42
		int [] numbers = {6, 15, -14, -7, 20, -13, -5, -3, 8, 23, -26, 1, -4, -5, -18, 5, -16, 31, 2, 9, 28, 3};
		
		//Test 3  
		//int [] numbers = {4, 0, -3, -4, 1, 7, 2, 3, 5, 6, 7};
		//sol = -7
		
		//Test 4
		//int [] numbers = {7, 273519, -153582, 450905, 5108, 288723, -97242, 394845, -488152, 83831, 341882, 301473, 466844, -200869, 366094, -237787, 180048, -408705, 439266, 88809, 499780, -104477, 451830, 381165, -313736, -409465, -17078, -113359, 13804};
		//sol: -488152

				
				
		
		int depth = numbers[0];
		int [][] triangle = new int[depth][depth];
		int index = 1;
		
		//Make the triangle 
		for (int i = 0; i < depth;i++) { 
			System.out.println();
			for(int j=0; j < i+1;j++) {
				System.out.print(numbers[index]+ " ");
				triangle[i][j] = numbers[index];
				index++;
			}
		}
	
		
	//Actual sum finder
		
		long startTime = System.nanoTime();
		int startRow = 0;
		int startCol = 0;
		int endCol = startCol + 1 ; 	//Exclusive //How far you want to go in the next row
		int currSum = 0;
		int minSum = triangle[0][0] + triangle[1][0] +  triangle[1][1];  //Make minSum the sum of the smallest top of the triangle
		int i=0;
		int j=0;
		
 for(int x=0 ;x < depth-1;x++) {		//Iterate through the rows
   for(int y=0; y < x+1 ;y++ ) {    //Iterate through the columns
		 startRow = x;
		 startCol= y;
		 endCol = y+1;
		 currSum = 0;
		
	 for(i = startRow; i < depth;i++) {		//Find the sum of each apex by starting at 3 numbers & then expanding
	    for (j = startCol; j < endCol;j++) {		//change start col depending on where we are at in the triangle
					currSum += triangle[i][j];
			}
			endCol++; //Look at one extra column the next time through
			
			if(currSum < minSum) { 
				minSum = currSum;
			}
			
			
		}
	  }
	
	}
 long endTime = System.nanoTime();
 float elapsedTime = endTime - startTime;
 System.out.println();
 System.out.println("Minimum Sum = "+minSum);
 System.out.println("Runtime = "+elapsedTime+ " nanoseconds");
		
		
		
		
		
		
		
  }
	
	
	
	
	
}


