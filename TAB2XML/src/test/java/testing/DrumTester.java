package testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Test.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import tab2xml.Tab;


public class DrumTester { 
	
	
	@Test
	
	/* 
	 * should be able to find the row values of all the points in the tab in the correct order 
	 */
	
	public void RowArrayListTest()
	{
	char[][] test1 = 
		{
				{'C', ' ', '|', '-', '-', 'x', '-', '-', '-','|', ' ', '-', '-', '-', 'x', '-', '-', '|'},
				{'R', ' ', '|', '-', 'o', 'x', '-', '-', '-','|', 'x', '-', '-', '-', '-', '-', 'x', '|'},
				{'F', 'T', '|', '-', '-', '-', 'x', '-', 'x','|', ' ', '-', '-', '-', '-', '-', '-', '|'},
				{'H', 'f', '|', 'o', '-', '-', '-', '-', 'x','|', '-', '-', '-', 'o', 'x', '-', '-', '|'},
				{'S', 'D', '|', '-', '-', '-', '-', 'x', '-','|', 'x', '-', '-', '-', '-', 'x', '-', '|'},
				{'B', ' ', '|', '-', 'x', '-', '-', '-', 'o','|', 'o', '-', 'o', '-', '-', '-', '-', '|'} 
		};
	
	boolean checker = false; 
	int oldDivider = 0; 
	int currentDivider = 0;
	ArrayList<Integer> exp = new ArrayList<>();
	ArrayList<Integer> act = new ArrayList<>();
	
	for (int col = 0; col<test1[0].length; col++)
	{
	     for (int row = test1.length - 1; row >= 0 ; row--)
	     {
	    	 
	    	 if (currentDivider == col)
	    	 {
	    		checker = true;
	    		break; 
	    	 }		    	 
	    	
	    	 else if (test1[row][col] == '|')
	    		{
	    		 oldDivider = currentDivider;
	    		 currentDivider = col;
	    		 checker = false;
	    		
	    		}
	
	

						if (checker == false)
						{
						
							for (int col1 = oldDivider; col1 < currentDivider; col1++)
						    {
								
						        for (int row1 = test1.length - 1; row1 >=0; row1--)
						        {
						        	//if (rowSymbols[row] == 8) means voice two
						        	if ((test1[row1][col1] == 'x' || test1[row1][col1] == 'o')  && (row1 != 5))
						        	{
						        		act.add(row1);
						
						        	}
						        }
						        
						    }
							 
							
							
							// run the loop a second time now to find the notes in voice 2 
						
							for (int col2 = oldDivider; col2 < currentDivider; col2++)
						    {
								
						        for (int row2 = test1.length - 1;row2>=0; row2--)
						        {
						        	
						        	 if ((test1[row2][col2] == 'x' || test1[row2][col2] == 'o')  && (row2== 5))
						        	{
						        		act.add(row2);
						        	}
						        
						        }
						        
						    }
							
						}
	     		}
	
			}    
	
	Integer[] expectedValues = {3, 1, 1, 0, 2, 4, 3, 2, 5, 5, 4, 1, 3, 3, 0, 4, 1, 5, 5};
	 exp = new ArrayList<>(Arrays.asList(expectedValues));
	 assertEquals(exp, act);
	}
	
	
	
	@Test
	public void ColArrayListTest()
	{
		char[][] test1 = 
			{
					{'C', ' ', '|', '-', '-', 'x', '-', '-', '-','|', ' ', '-', '-', '-', 'x', '-', '-', '|'},
					{'R', ' ', '|', '-', 'o', 'x', '-', '-', '-','|', 'x', '-', '-', '-', '-', '-', 'x', '|'},
					{'F', 'T', '|', '-', '-', '-', 'x', '-', 'x','|', ' ', '-', '-', '-', '-', '-', '-', '|'},
					{'H', 'f', '|', 'o', '-', '-', '-', '-', 'x','|', '-', '-', '-', 'o', 'x', '-', '-', '|'},
					{'S', 'D', '|', '-', '-', '-', '-', 'x', '-','|', 'x', '-', '-', '-', '-', 'x', '-', '|'},
					{'B', ' ', '|', '-', 'x', '-', '-', '-', 'o','|', 'o', '-', 'o', '-', '-', '-', '-', '|'} 
			};
		boolean checker = false; 
		int oldDivider = 0; 
		int currentDivider = 0;
		ArrayList<Integer> exp = new ArrayList<>();
		ArrayList<Integer> act = new ArrayList<>();
		
		for (int col = 0; col<test1[0].length; col++)
		{
		     for (int row = test1.length - 1; row >= 0 ; row--)
		     {
		    	 
		    	 if (currentDivider == col)
		    	 {
		    		checker = true;
		    		break; 
		    	 }		    	 
		    	
		    	 else if (test1[row][col] == '|')
		    		{
		    		 oldDivider = currentDivider;
		    		 currentDivider = col;
		    		 checker = false;
		    		}
		
								
						
							if (checker == false)
							{
						
								for (int col1 = oldDivider; col1 < currentDivider; col1++)
							    {
									
							        for (int row1 = test1.length - 1; row1 >=0; row1--)
							        {
							        	//if (rowSymbols[row] == 8) means voice two
							        	if ((test1[row1][col1] == 'x' || test1[row1][col1] == 'o')  && (row1 != 5))
							        	{
							        		act.add(col1);
						
							        	}
							        }
							        
							    }
								 
								
								
								// run the loop a second time now to find the notes in voice 2 
								for (int col2 = oldDivider; col2 < currentDivider; col2++)
							    {
									
							        for (int row2 = test1.length - 1;row2>=0; row2--)
							        {
							        	
							        	 if ((test1[row2][col2] == 'x' || test1[row2][col2] == 'o')  && (row2== 5))
							        	{
							        		act.add(col2);
							        	}
							        
							        }
							        
							    }
								
							}
								
		     			}
		
				}    
		
		Integer[] expectedValues = {3, 4, 5, 5, 6, 7, 8, 8, 4, 8, 10, 10, 13, 14, 14, 15, 16, 10, 12};
		 exp = new ArrayList<>(Arrays.asList(expectedValues));
		 assertEquals(exp, act);
		 
		}
	
	
	
	@Test
	public void StepDirection()
	{
		String exp;
		String act;
		int voice = 2;
		
		if (voice == 1)
		{
			act = "up";
		}
		else if (voice == 2)
		{
			act = "down";
		}
		else
		{
			act = "incorrect value";
		}
		
		exp = "down";
		assertEquals(exp, act);
		
	}
	
	
	
	
}
