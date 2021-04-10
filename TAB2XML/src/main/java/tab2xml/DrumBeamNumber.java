package tab2xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

	


public class DrumBeamNumber {

	ArrayList <Integer> duration;
	ArrayList<Integer> voice;
	ArrayList<Boolean> hasBeamNum;
	ArrayList<Boolean> secondBeamNum;
	ArrayList<String> beamStatus;
	ArrayList<String> secondBeamStatus;
	
<<<<<<< HEAD
	ArrayList <Integer> BeamStatus(ArrayList<Integer> rowCoordinate, ArrayList<Integer> colCoordinate, 
			ArrayList <Character> NoteHeadReader, ArrayList<Integer> barLineCols)
	{
		//[2, 1, 1, 0, 2, 4, 3, 2, 5, 5, 4, 1, 3, 3, 0, 4, 1, 5, 5]
		//[3, 4, 5, 5, 6, 7, 8, 8, 4, 8, 10, 10, 13, 14, 14, 15, 16, 10, 12]
		//[x, o, x, x, x, x, x, x, x, o, x, x, o, x, x, x, x, o, o
		// if (duration equals 2 or 1 there's a chance of beam number being activated )
		// if notehead of next part is same, then beam number continues or starts, else it ends)
		// need to get duration and then based off that and notehead we can get everything else 
		// if col if same, the second number is skipped;
		
		hasBeamNum = new ArrayList<Boolean>();
		secondBeamNum = new ArrayList<Boolean>();
		beamStatus = new ArrayList<String>();
		secondBeamStatus = new ArrayList<String>();
		
		voice = new ArrayList <Integer> ();
		 duration = new ArrayList <Integer> ();			 
				 
			for(int j = 0; j < rowCoordinate.size(); j++) {
				
				int row = rowCoordinate.get(j);
				int col = colCoordinate.get(j);
				int nextCol = 0;
				int nextNextCol = 0;
				int preCol = 0;
				if(j+1 < rowCoordinate.size()) {nextCol = colCoordinate.get(j+1);} 
				if(j+2 < rowCoordinate.size()) {nextNextCol = colCoordinate.get(j+2);} 
				if(j>0) {preCol = colCoordinate.get(j-1);}
				
				int durationcount = 0;
				boolean breaksDivider = false; 
				 
				 
				if (col != nextCol)
				{
					for (int i = 0; i < barLineCols.size(); i++) 
					{
						if(i+1 < barLineCols.size()) 
						{
							if ((barLineCols.get(i) < col) && (nextCol > barLineCols.get(i+1)) && (col< barLineCols.get(i+1)))
							{
							durationcount = barLineCols.get(i+1) - col; 
							breaksDivider  = true;
							
							}
						}
						
						
						if (breaksDivider == false)
						{
							durationcount = nextCol - col; 
							breaksDivider = true;
							
						}
						
						if (nextCol == 0)
						{
							durationcount = barLineCols.get(barLineCols.size()-1) - col;
						}
						
						if((nextCol<col) && (barLineCols.get(i)>col))
						{
							 durationcount = barLineCols.get(i) - col;
							 break;
						}
					}
						
					
				}
				
				if (col == nextCol)
				{
					
					for (int i = 0; i < barLineCols.size(); i++) 
					{
						if(i+1 < barLineCols.size()) 
						{
							if ((barLineCols.get(i) < col) && (nextNextCol > barLineCols.get(i+1)) && (col< barLineCols.get(i+1)))
								{
								durationcount = barLineCols.get(i+1) - col; 
								breaksDivider  = true;
							
								}
						}
						
						
						if (breaksDivider == false)
						{
							durationcount = nextNextCol - col;
							breaksDivider = true;
							
						}
						
						if (nextNextCol == 0)
						{
							durationcount = barLineCols.get(barLineCols.size()-1) - col;
						}
						
						if((nextNextCol<col) && (barLineCols.get(i)>col))
						{
							 durationcount = barLineCols.get(i) - col;
							 break;
						}
					}
					
				}
				duration.add(durationcount);
				breaksDivider = false;
				
				
				
				
				
			
			}
			 
		
			
			
			for(int j = 0; j < rowCoordinate.size(); j++) {
			
				int row = rowCoordinate.get(j);
				
				if ( row == 5)
				{
					voice.add(2);
				}
				else
				{
					voice.add(1);
				}
			
			
			
			
			
			
			
			
			}
			
			
			
			
			
			
			
			int NumofNotes = 0;
			int counter = 0;
			
			for(int j = 0; j < rowCoordinate.size(); j++) {
				
				int row = rowCoordinate.get(j);
				int col = colCoordinate.get(j);
				int nextCol = 0;
				int nextNextCol = 0;
				int preCol = 0;
				
				boolean chord = false;
				boolean isNextchord = false;
				
				int currentDuration = duration.get(j); 
				int nextDuration = 0; 
				int nextNextDuration = 0; 
				int preDuration = 0; 
				
				char currentHead = NoteHeadReader.get(j); 
				char nextHead = 0; 
				char nextNextHead = 0; 
				char preHead = 0; 
				
				int currentVoice = voice.get(j);
				int nextVoice = 0;
				int preVoice = 0;
				
				if(j+1 < rowCoordinate.size()) 
				{nextCol = colCoordinate.get(j+1);
				nextDuration = duration.get(j+1);
				nextVoice = voice.get(j+1);
				nextHead = NoteHeadReader.get(j+1);} 
				
				if(j+2 < rowCoordinate.size()) 
				{nextNextCol = colCoordinate.get(j+2);
				nextNextDuration = duration.get(j+2);
				nextNextHead = NoteHeadReader.get(j+2); } 
				
				if(j>0) 
				{preCol = colCoordinate.get(j-1);
				preDuration = duration.get(j-1);
				preVoice = voice.get(j-1);
				preHead = NoteHeadReader.get(j-1); }
				
			
				counter = currentDuration + counter;
				NumofNotes++;
				

				//int [] rowsample = {0, 1, 2, 1, 1, 1, 1, 2, 1, 1, 5, 5, 2, 2, 2, 2, 3, 3, 4, 4, 0, 5, 5};
				
				//int [] colsample = {3, 5, 7, 7, 9, 11, 13, 15, 15, 17, 3, 11, 20, 21, 22, 23, 24, 25, 26, 27, 28, 20, 28};
				//char [] headsample = {'x', 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'o', 'o'};
				
				if(preCol == col)
				{
					// tells us we are dealing with a coard situation so we dont need to enter a beam 
				// measure 1 = false
				// measure 2 = false
				currentDuration =10000;
				chord = true;
				}	
			
				if (nextCol == nextNextCol)
				{
					isNextchord = true; 
				}
						
				
				if ((currentDuration == 2) || (currentDuration == 1))
						{
										
			
										if (((nextDuration == 2) || (nextDuration == 1)) && (nextHead == currentHead) && (currentVoice == nextVoice) || (isNextchord = true))
										{
											
											//lets us know there's a chance of a beam, could be cpntinue or start 
											
													if ((j == 0) || (preDuration == 2) || (preDuration == 1))
													{
														//this tells us its either start or continue 
														
														
																	if ((NumofNotes !=4) && (counter < 9) && (currentVoice == nextVoice))
																	{
																		
																							if (j == 0)
																							{
																										if ( nextDuration == 2)
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(false);
																											beamStatus.add("start");
																											secondBeamStatus.add("null");
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("start");
																											secondBeamStatus.add("start");
																										}
																							}
																	
																							else if (NumofNotes == 1)
																							{
																										if ( nextDuration == 2)
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(false);
																											beamStatus.add("start");
																											secondBeamStatus.add("null");
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("start");
																											secondBeamStatus.add("start");
																										}
																	
																							}
																							
																							else if (nextCol < col) 
																							{
																										if ( currentDuration== 2)
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(false);
																											beamStatus.add("end");
																											secondBeamStatus.add("null");
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("end");
																											secondBeamStatus.add("end");
																										}
																	
																							}
																							
																							else if ((col == nextCol) && (nextNextCol < col ))
																									{
																										if ( currentDuration== 2)
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(false);
																											beamStatus.add("end");
																											secondBeamStatus.add("null");
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("end");
																											secondBeamStatus.add("end");
																										}
																								
																									}
																							
																			
																							else if ((currentDuration == 2) && (nextDuration == 2))
																							{
																										if ((j == 0) || (preDuration == currentDuration))
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(false);
																											beamStatus.add("continue");
																											secondBeamStatus.add("null");
																											//measure 1 = continue	
																											// example 2,2,2
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("end");
																											//means 1,2,2 
																											//measure 1 = continue 
																											//measure 2 = end 
																										}
																	
																							}
																							else if ((currentDuration == 1) && (nextDuration == 1))
																							{
																										if ((j == 0) || (preDuration == currentDuration))
																										{
																											//example 1,1,1
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("continue");
																											//measure 2 = continue		
																											//measure 1 = continue
																											
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("start");
																											// example 2,1,1
																											// measure 2 = start
																											//measure 1 = continue	
																										}
																							
																							}
																							else if ((currentDuration == 1) && (nextDuration == 2))
																							{
																										if ((j == 0) || (preDuration == currentDuration))
																										{
																											//example 1,1,2
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("end");
																											//measure 2 = end		
																											//measure 1 = continue
																											
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("continue");
																										
																											// example 2,1,2
																											// measure 2 = start
																											//measure 1 = continue	
																										}
																							
																							 }
																							else if ((currentDuration == 2) && (nextDuration == 1))
																							{
																										if ((j == 0) || (preDuration == currentDuration))
																										{
																											//example 2,2,1
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("start");
																											//measure 2 = start		
																											//measure 1 = continue
																											
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("end");
																											// example 1,2,1
																											// measure 2 = end
																											//measure 1 = continue	
																										}
																							
																							 }
																	
																								
																	}
																	else 
																	{
																		counter = 0;
																		NumofNotes = 0;
																		
																			if (currentDuration == 1) 
																			{
																				hasBeamNum.add(true);
																				secondBeamNum.add(true);
																				beamStatus.add("end");
																				secondBeamStatus.add("end");
																				// end it 
																				
																			}
																			else 
																			{
																				hasBeamNum.add(true);
																				secondBeamNum.add(false);
																				beamStatus.add("end");
																				secondBeamStatus.add("null");
																				// end it 
																			}
																		
																	}
													}
											
													else 
													// pre duration not equal to 2 or 1 
													{
																	if ((currentDuration == 2) && (nextDuration == 1))
																	{
																		hasBeamNum.add(true);
																		secondBeamNum.add(true);
																		beamStatus.add("start");
																		secondBeamStatus.add("start");
																		//example 3,2,1
																		//measure 1 start
																		// measure 2 start
																		
																	}
																	else if ((currentDuration == 2) && (nextDuration == 2))
																	{
																		hasBeamNum.add(true);
																		secondBeamNum.add(false);
																		beamStatus.add("start");
																		secondBeamStatus.add("null");
																		//example 3,2,2
																		// measure 1 start
																		
																	}
																	else if ((currentDuration == 1) && (nextDuration == 2))
																	{
																		hasBeamNum.add(true);
																		secondBeamNum.add(false);
																		beamStatus.add("start");
																		secondBeamStatus.add("null");
																		//example 3,1,2
																		// measure 1 start
																		
																		
																	}
																	else if ((currentDuration == 1) && (nextDuration == 1))
																	{
																		hasBeamNum.add(true);
																		secondBeamNum.add(true);
																		beamStatus.add("start");
																		secondBeamStatus.add("start");
																		//example 3,1,1
																		//measure 1 start
																		// measure 2 start
																		
																	}
													}
													
												
									    }
										
										else if (((preDuration == 2) || (preDuration == 1)  && (preHead == currentHead)) || (j == 0))
										{
											// example 1,2,3
											// tells us the current duration is the end of a beam 
											//current and pre are 2 or 1 , but next does not equal 1 or 2 					
											counter = 0;
											NumofNotes = 0;
													
													if (currentDuration == 2)
													{
														hasBeamNum.add(true);
														secondBeamNum.add(false);
														beamStatus.add("end");
														secondBeamStatus.add("null");
														
														//example 1,2,3
														//measure 1 end 
														
													}
													else 
													{
														hasBeamNum.add(true);
														secondBeamNum.add(true);
														beamStatus.add("end");
														secondBeamStatus.add("end");
														//example 1,1,3
														//measure 1 end 
														//measure 2 end 
														
													}
											
										}
											
								
									else 
									{
										
										//tells us that the notes before or after are not 1 or 2 , so no beam connection 
											hasBeamNum.add(false);
											secondBeamNum.add(false);
											beamStatus.add("null");
											secondBeamStatus.add("null");
											NumofNotes = 0;
									}
							

								
						}
						
						else 
						{
							// if current duration isnt 2 or 1 not par of a beam 
							hasBeamNum.add(false);
							secondBeamNum.add(false);
							beamStatus.add("null");
							secondBeamStatus.add("null");
							
							
							
							if (chord== false)
							{
							NumofNotes = 0;
							}
							else
							{
								NumofNotes = NumofNotes - 1;
							}
							
							chord = false;
						}		
				
				if (currentVoice != nextVoice)
				{
					counter = 0;
				}
				
				System.out.print(NumofNotes + "  ");
				System.out.print(counter + "  ");
				System.out.println();
				
				if (NumofNotes ==4)
				{
					NumofNotes = 0;
				}
				
				if (counter > 8)
				{
					counter = 0;
				}
				
		}
		
		
		
		
		
		
		
		
		
		
		return barLineCols;
	
	
	
			
}
}
=======

	
	ArrayList <String> BeamOneStatus(ArrayList<Integer> rowCoordinate, ArrayList<Integer> colCoordinate, 
			ArrayList <Character> NoteHeadReader, ArrayList<Integer> barLineCols, int [] rowSymbols)
	{
		//[2, 1, 1, 0, 2, 4, 3, 2, 5, 5, 4, 1, 3, 3, 0, 4, 1, 5, 5]
		//[3, 4, 5, 5, 6, 7, 8, 8, 4, 8, 10, 10, 13, 14, 14, 15, 16, 10, 12]
		//[x, o, x, x, x, x, x, x, x, o, x, x, o, x, x, x, x, o, o
		// if (duration equals 2 or 1 there's a chance of beam number being activated )
		// if notehead of next part is same, then beam number continues or begins, else it ends)
		// need to get duration and then based off that and notehead we can get everything else 
		// if col if same, the second number is skipped;
		
		hasBeamNum = new ArrayList<Boolean>();
		secondBeamNum = new ArrayList<Boolean>();
		beamStatus = new ArrayList<String>();
		secondBeamStatus = new ArrayList<String>();
		
		voice = new ArrayList <Integer> ();
		 duration = new ArrayList <Integer> ();			 
				 
			for(int j = 0; j < rowCoordinate.size(); j++) {
				
				int row = rowCoordinate.get(j);
				int col = colCoordinate.get(j);
				int nextCol = 0;
				int nextNextCol = 0;
				int preCol = 0;
				if(j+1 < rowCoordinate.size()) {nextCol = colCoordinate.get(j+1);} 
				if(j+2 < rowCoordinate.size()) {nextNextCol = colCoordinate.get(j+2);} 
				if(j>0) {preCol = colCoordinate.get(j-1);}
				
				int durationcount = 0;
				boolean breaksDivider = false; 
				 
				 
				if (col != nextCol)
				{
					for (int i = 0; i < barLineCols.size(); i++) 
					{
						if(i+1 < barLineCols.size()) 
						{
							if ((barLineCols.get(i) < col) && (nextCol > barLineCols.get(i+1)) && (col< barLineCols.get(i+1)))
							{
							durationcount = barLineCols.get(i+1) - col; 
							breaksDivider  = true;
							
							}
						}
						
						
						if (breaksDivider == false)
						{
							durationcount = nextCol - col; 
							breaksDivider = true;
							
						}
						
						if (nextCol == 0)
						{
							durationcount = barLineCols.get(barLineCols.size()-1) - col;
						}
						
						if((nextCol<col) && (barLineCols.get(i)>col))
						{
							 durationcount = barLineCols.get(i) - col;
							 break;
						}
					}
						
					
				}
				
				if (col == nextCol)
				{
					
					for (int i = 0; i < barLineCols.size(); i++) 
					{
						if(i+1 < barLineCols.size()) 
						{
							if ((barLineCols.get(i) < col) && (nextNextCol > barLineCols.get(i+1)) && (col< barLineCols.get(i+1)))
								{
								durationcount = barLineCols.get(i+1) - col; 
								breaksDivider  = true;
							
								}
						}
						
						
						if (breaksDivider == false)
						{
							durationcount = nextNextCol - col;
							breaksDivider = true;
							
						}
						
						if (nextNextCol == 0)
						{
							durationcount = barLineCols.get(barLineCols.size()-1) - col;
						}
						
						if((nextNextCol<col) && (barLineCols.get(i)>col))
						{
							 durationcount = barLineCols.get(i) - col;
							 break;
						}
					}
					
				}
				duration.add(durationcount);
				breaksDivider = false;
				
				
				
				
				
			
			}
			 
		
			
			
			for(int j = 0; j < rowCoordinate.size(); j++) {
			
				int row = rowCoordinate.get(j);
				
				if (rowSymbols[row]== 8)
				{
					voice.add(2);
				}
				else
				{
					voice.add(1);
				}
			
			
			
			
			
			
			
			
			}
			
			
			
			
			
			
			
			int NumofNotes = 0;
			int counter = 0;
			
			for(int j = 0; j < rowCoordinate.size(); j++) {
				
				int row = rowCoordinate.get(j);
				int col = colCoordinate.get(j);
				int nextCol = 0;
				int nextNextCol = 0;
				int preCol = 0;
				
				boolean chord = false;
				boolean isNextchord = false;
				
				int currentDuration = duration.get(j); 
				int nextDuration = 0; 
				int nextNextDuration = 0; 
				int preDuration = 0; 
				
				char currentHead = NoteHeadReader.get(j); 
				char nextHead = 0; 
				char nextNextHead = 0; 
				char preHead = 0; 
				
				int currentVoice = voice.get(j);
				int nextVoice = 0;
				int preVoice = 0;
				
				if(j+1 < rowCoordinate.size()) 
				{nextCol = colCoordinate.get(j+1);
				nextDuration = duration.get(j+1);
				nextVoice = voice.get(j+1);
				nextHead = NoteHeadReader.get(j+1);} 
				
				if(j+2 < rowCoordinate.size()) 
				{nextNextCol = colCoordinate.get(j+2);
				nextNextDuration = duration.get(j+2);
				nextNextHead = NoteHeadReader.get(j+2); } 
				
				if(j>0) 
				{preCol = colCoordinate.get(j-1);
				preDuration = duration.get(j-1);
				preVoice = voice.get(j-1);
				preHead = NoteHeadReader.get(j-1); }
				
			
				counter = currentDuration + counter;
				NumofNotes++;
				

				//int [] rowsample = {0, 1, 2, 1, 1, 1, 1, 2, 1, 1, 5, 5, 2, 2, 2, 2, 3, 3, 4, 4, 0, 5, 5};
				
				//int [] colsample = {3, 5, 7, 7, 9, 11, 13, 15, 15, 17, 3, 11, 20, 21, 22, 23, 24, 25, 26, 27, 28, 20, 28};
				//char [] headsample = {'x', 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'o', 'o'};
				
				if(preCol == col)
				{
					// tells us we are dealing with a coard situation so we dont need to enter a beam 
				// measure 1 = false
				// measure 2 = false
				currentDuration =10000;
				chord = true;
				}	
			
				if (nextCol == nextNextCol)
				{
					isNextchord = true; 
				}
						
				
				if ((currentDuration == 2) || (currentDuration == 1))
						{
										
			
										if (((nextDuration == 2) || (nextDuration == 1)) && (nextHead == currentHead) && (currentVoice == nextVoice) || (isNextchord = true))
										{
											
											//lets us know there's a chance of a beam, could be cpntinue or begin 
											
													if ((j == 0) || (preDuration == 2) || (preDuration == 1))
													{
														//this tells us its either begin or continue 
														
														
																	if ((NumofNotes !=4) && (counter < 9) && (currentVoice == nextVoice))
																	{
																		
																							if (j == 0)
																							{
																										if ( nextDuration == 2)
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(false);
																											beamStatus.add("begin");
																											secondBeamStatus.add(null);
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("begin");
																											secondBeamStatus.add("begin");
																										}
																							}
																	
																							else if (NumofNotes == 1)
																							{
																										if ( nextDuration == 2)
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(false);
																											beamStatus.add("begin");
																											secondBeamStatus.add(null);
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("begin");
																											secondBeamStatus.add("begin");
																										}
																	
																							}
																							
																							else if (nextCol < col) 
																							{
																										if ( currentDuration== 2)
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(false);
																											beamStatus.add("end");
																											secondBeamStatus.add(null);
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("end");
																											secondBeamStatus.add("end");
																										}
																	
																							}
																							
																							else if ((col == nextCol) && (nextNextCol < col ))
																									{
																										if ( currentDuration== 2)
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(false);
																											beamStatus.add("end");
																											secondBeamStatus.add(null);
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("end");
																											secondBeamStatus.add("end");
																										}
																								
																									}
																							
																			
																							else if ((currentDuration == 2) && (nextDuration == 2))
																							{
																										if ((j == 0) || (preDuration == currentDuration))
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(false);
																											beamStatus.add("continue");
																											secondBeamStatus.add(null);
																											//measure 1 = continue	
																											// example 2,2,2
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("end");
																											//means 1,2,2 
																											//measure 1 = continue 
																											//measure 2 = end 
																										}
																	
																							}
																							else if ((currentDuration == 1) && (nextDuration == 1))
																							{
																										if ((j == 0) || (preDuration == currentDuration))
																										{
																											//example 1,1,1
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("continue");
																											//measure 2 = continue		
																											//measure 1 = continue
																											
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("begin");
																											// example 2,1,1
																											// measure 2 = begin
																											//measure 1 = continue	
																										}
																							
																							}
																							else if ((currentDuration == 1) && (nextDuration == 2))
																							{
																										if ((j == 0) || (preDuration == currentDuration))
																										{
																											//example 1,1,2
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("end");
																											//measure 2 = end		
																											//measure 1 = continue
																											
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("continue");
																										
																											// example 2,1,2
																											// measure 2 = begin
																											//measure 1 = continue	
																										}
																							
																							 }
																							else if ((currentDuration == 2) && (nextDuration == 1))
																							{
																										if ((j == 0) || (preDuration == currentDuration))
																										{
																											//example 2,2,1
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("begin");
																											//measure 2 = begin		
																											//measure 1 = continue
																											
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("end");
																											// example 1,2,1
																											// measure 2 = end
																											//measure 1 = continue	
																										}
																							
																							 }
																	
																								
																	}
																	else 
																	{
																		counter = 0;
																		NumofNotes = 0;
																		
																			if (currentDuration == 1) 
																			{
																				hasBeamNum.add(true);
																				secondBeamNum.add(true);
																				beamStatus.add("end");
																				secondBeamStatus.add("end");
																				// end it 
																				
																			}
																			else 
																			{
																				hasBeamNum.add(true);
																				secondBeamNum.add(false);
																				beamStatus.add("end");
																				secondBeamStatus.add(null);
																				// end it 
																			}
																		
																	}
													}
											
													else 
													// pre duration not equal to 2 or 1 
													{
																	if ((currentDuration == 2) && (nextDuration == 1))
																	{
																		hasBeamNum.add(true);
																		secondBeamNum.add(true);
																		beamStatus.add("begin");
																		secondBeamStatus.add("begin");
																		//example 3,2,1
																		//measure 1 begin
																		// measure 2 begin
																		
																	}
																	else if ((currentDuration == 2) && (nextDuration == 2))
																	{
																		hasBeamNum.add(true);
																		secondBeamNum.add(false);
																		beamStatus.add("begin");
																		secondBeamStatus.add(null);
																		//example 3,2,2
																		// measure 1 begin
																		
																	}
																	else if ((currentDuration == 1) && (nextDuration == 2))
																	{
																		hasBeamNum.add(true);
																		secondBeamNum.add(false);
																		beamStatus.add("begin");
																		secondBeamStatus.add(null);
																		//example 3,1,2
																		// measure 1 begin
																		
																		
																	}
																	else if ((currentDuration == 1) && (nextDuration == 1))
																	{
																		hasBeamNum.add(true);
																		secondBeamNum.add(true);
																		beamStatus.add("begin");
																		secondBeamStatus.add("begin");
																		//example 3,1,1
																		//measure 1 begin
																		// measure 2 begin
																		
																	}
													}
													
												
									    }
										
										else if (((preDuration == 2) || (preDuration == 1)  && (preHead == currentHead)) || (j == 0))
										{
											// example 1,2,3
											// tells us the current duration is the end of a beam 
											//current and pre are 2 or 1 , but next does not equal 1 or 2 					
											counter = 0;
											NumofNotes = 0;
													
													if (currentDuration == 2)
													{
														hasBeamNum.add(true);
														secondBeamNum.add(false);
														beamStatus.add("end");
														secondBeamStatus.add(null);
														
														//example 1,2,3
														//measure 1 end 
														
													}
													else 
													{
														hasBeamNum.add(true);
														secondBeamNum.add(true);
														beamStatus.add("end");
														secondBeamStatus.add("end");
														//example 1,1,3
														//measure 1 end 
														//measure 2 end 
														
													}
											
										}
											
								
									else 
									{
										
										//tells us that the notes before or after are not 1 or 2 , so no beam connection 
											hasBeamNum.add(false);
											secondBeamNum.add(false);
											beamStatus.add(null);
											secondBeamStatus.add(null);
											NumofNotes = 0;
									}
							

								
						}
						
						else 
						{
							// if current duration isnt 2 or 1 not par of a beam 
							hasBeamNum.add(false);
							secondBeamNum.add(false);
							beamStatus.add(null);
							secondBeamStatus.add(null);
							
							
							
							if (chord== false)
							{
							NumofNotes = 0;
							}
							else
							{
								NumofNotes = NumofNotes - 1;
							}
							
							chord = false;
						}		
				
				if (currentVoice != nextVoice)
				{
					counter = 0;
				}
				

				
				if (NumofNotes ==4)
				{
					NumofNotes = 0;
				}
				
				if (counter > 8)
				{
					counter = 0;
				}
				
		}
		
		
		
		
		
		
		
		
		
		
		return beamStatus;
	
	
	
			
}
	
	ArrayList <String> BeamTwoStatus(ArrayList<Integer> rowCoordinate, ArrayList<Integer> colCoordinate, 
			ArrayList <Character> NoteHeadReader, ArrayList<Integer> barLineCols, int [] rowSymbols)
	{
		//[2, 1, 1, 0, 2, 4, 3, 2, 5, 5, 4, 1, 3, 3, 0, 4, 1, 5, 5]
		//[3, 4, 5, 5, 6, 7, 8, 8, 4, 8, 10, 10, 13, 14, 14, 15, 16, 10, 12]
		//[x, o, x, x, x, x, x, x, x, o, x, x, o, x, x, x, x, o, o
		// if (duration equals 2 or 1 there's a chance of beam number being activated )
		// if notehead of next part is same, then beam number continues or begins, else it ends)
		// need to get duration and then based off that and notehead we can get everything else 
		// if col if same, the second number is skipped;
		
		hasBeamNum = new ArrayList<Boolean>();
		secondBeamNum = new ArrayList<Boolean>();
		beamStatus = new ArrayList<String>();
		secondBeamStatus = new ArrayList<String>();
		
		voice = new ArrayList <Integer> ();
		 duration = new ArrayList <Integer> ();			 
				 
			for(int j = 0; j < rowCoordinate.size(); j++) {
				
				int row = rowCoordinate.get(j);
				int col = colCoordinate.get(j);
				int nextCol = 0;
				int nextNextCol = 0;
				int preCol = 0;
				if(j+1 < rowCoordinate.size()) {nextCol = colCoordinate.get(j+1);} 
				if(j+2 < rowCoordinate.size()) {nextNextCol = colCoordinate.get(j+2);} 
				if(j>0) {preCol = colCoordinate.get(j-1);}
				
				int durationcount = 0;
				boolean breaksDivider = false; 
				 
				 
				if (col != nextCol)
				{
					for (int i = 0; i < barLineCols.size(); i++) 
					{
						if(i+1 < barLineCols.size()) 
						{
							if ((barLineCols.get(i) < col) && (nextCol > barLineCols.get(i+1)) && (col< barLineCols.get(i+1)))
							{
							durationcount = barLineCols.get(i+1) - col; 
							breaksDivider  = true;
							
							}
						}
						
						
						if (breaksDivider == false)
						{
							durationcount = nextCol - col; 
							breaksDivider = true;
							
						}
						
						if (nextCol == 0)
						{
							durationcount = barLineCols.get(barLineCols.size()-1) - col;
						}
						
						if((nextCol<col) && (barLineCols.get(i)>col))
						{
							 durationcount = barLineCols.get(i) - col;
							 break;
						}
					}
						
					
				}
				
				if (col == nextCol)
				{
					
					for (int i = 0; i < barLineCols.size(); i++) 
					{
						if(i+1 < barLineCols.size()) 
						{
							if ((barLineCols.get(i) < col) && (nextNextCol > barLineCols.get(i+1)) && (col< barLineCols.get(i+1)))
								{
								durationcount = barLineCols.get(i+1) - col; 
								breaksDivider  = true;
							
								}
						}
						
						
						if (breaksDivider == false)
						{
							durationcount = nextNextCol - col;
							breaksDivider = true;
							
						}
						
						if (nextNextCol == 0)
						{
							durationcount = barLineCols.get(barLineCols.size()-1) - col;
						}
						
						if((nextNextCol<col) && (barLineCols.get(i)>col))
						{
							 durationcount = barLineCols.get(i) - col;
							 break;
						}
					}
					
				}
				duration.add(durationcount);
				breaksDivider = false;
				
				
				
				
				
			
			}
			 
		
			
			
			for(int j = 0; j < rowCoordinate.size(); j++) {
			
				int row = rowCoordinate.get(j);
				
				if (rowSymbols[row]== 8)
				{
					voice.add(2);
				}
				else
				{
					voice.add(1);
				}
			
			
			
			
			
			
			
			
			}
			
			
			
			
			
			
			
			int NumofNotes = 0;
			int counter = 0;
			
			for(int j = 0; j < rowCoordinate.size(); j++) {
				
				int row = rowCoordinate.get(j);
				int col = colCoordinate.get(j);
				int nextCol = 0;
				int nextNextCol = 0;
				int preCol = 0;
				
				boolean chord = false;
				boolean isNextchord = false;
				
				int currentDuration = duration.get(j); 
				int nextDuration = 0; 
				int nextNextDuration = 0; 
				int preDuration = 0; 
				
				char currentHead = NoteHeadReader.get(j); 
				char nextHead = 0; 
				char nextNextHead = 0; 
				char preHead = 0; 
				
				int currentVoice = voice.get(j);
				int nextVoice = 0;
				int preVoice = 0;
				
				if(j+1 < rowCoordinate.size()) 
				{nextCol = colCoordinate.get(j+1);
				nextDuration = duration.get(j+1);
				nextVoice = voice.get(j+1);
				nextHead = NoteHeadReader.get(j+1);} 
				
				if(j+2 < rowCoordinate.size()) 
				{nextNextCol = colCoordinate.get(j+2);
				nextNextDuration = duration.get(j+2);
				nextNextHead = NoteHeadReader.get(j+2); } 
				
				if(j>0) 
				{preCol = colCoordinate.get(j-1);
				preDuration = duration.get(j-1);
				preVoice = voice.get(j-1);
				preHead = NoteHeadReader.get(j-1); }
				
			
				counter = currentDuration + counter;
				NumofNotes++;
				

				//int [] rowsample = {0, 1, 2, 1, 1, 1, 1, 2, 1, 1, 5, 5, 2, 2, 2, 2, 3, 3, 4, 4, 0, 5, 5};
				
				//int [] colsample = {3, 5, 7, 7, 9, 11, 13, 15, 15, 17, 3, 11, 20, 21, 22, 23, 24, 25, 26, 27, 28, 20, 28};
				//char [] headsample = {'x', 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'o', 'o'};
				
				if(preCol == col)
				{
					// tells us we are dealing with a coard situation so we dont need to enter a beam 
				// measure 1 = false
				// measure 2 = false
				currentDuration =10000;
				chord = true;
				}	
			
				if (nextCol == nextNextCol)
				{
					isNextchord = true; 
				}
						
				
				if ((currentDuration == 2) || (currentDuration == 1))
						{
										
			
										if (((nextDuration == 2) || (nextDuration == 1)) && (nextHead == currentHead) && (currentVoice == nextVoice) || (isNextchord = true))
										{
											
											//lets us know there's a chance of a beam, could be cpntinue or begin 
											
													if ((j == 0) || (preDuration == 2) || (preDuration == 1))
													{
														//this tells us its either begin or continue 
														
														
																	if ((NumofNotes !=4) && (counter < 9) && (currentVoice == nextVoice))
																	{
																		
																							if (j == 0)
																							{
																										if ( nextDuration == 2)
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(false);
																											beamStatus.add("begin");
																											secondBeamStatus.add(null);
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("begin");
																											secondBeamStatus.add("begin");
																										}
																							}
																	
																							else if (NumofNotes == 1)
																							{
																										if ( nextDuration == 2)
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(false);
																											beamStatus.add("begin");
																											secondBeamStatus.add(null);
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("begin");
																											secondBeamStatus.add("begin");
																										}
																	
																							}
																							
																							else if (nextCol < col) 
																							{
																										if ( currentDuration== 2)
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(false);
																											beamStatus.add("end");
																											secondBeamStatus.add(null);
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("end");
																											secondBeamStatus.add("end");
																										}
																	
																							}
																							
																							else if ((col == nextCol) && (nextNextCol < col ))
																									{
																										if ( currentDuration== 2)
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(false);
																											beamStatus.add("end");
																											secondBeamStatus.add(null);
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("end");
																											secondBeamStatus.add("end");
																										}
																								
																									}
																							
																			
																							else if ((currentDuration == 2) && (nextDuration == 2))
																							{
																										if ((j == 0) || (preDuration == currentDuration))
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(false);
																											beamStatus.add("continue");
																											secondBeamStatus.add(null);
																											//measure 1 = continue	
																											// example 2,2,2
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("end");
																											//means 1,2,2 
																											//measure 1 = continue 
																											//measure 2 = end 
																										}
																	
																							}
																							else if ((currentDuration == 1) && (nextDuration == 1))
																							{
																										if ((j == 0) || (preDuration == currentDuration))
																										{
																											//example 1,1,1
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("continue");
																											//measure 2 = continue		
																											//measure 1 = continue
																											
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("begin");
																											// example 2,1,1
																											// measure 2 = begin
																											//measure 1 = continue	
																										}
																							
																							}
																							else if ((currentDuration == 1) && (nextDuration == 2))
																							{
																										if ((j == 0) || (preDuration == currentDuration))
																										{
																											//example 1,1,2
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("end");
																											//measure 2 = end		
																											//measure 1 = continue
																											
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("continue");
																										
																											// example 2,1,2
																											// measure 2 = begin
																											//measure 1 = continue	
																										}
																							
																							 }
																							else if ((currentDuration == 2) && (nextDuration == 1))
																							{
																										if ((j == 0) || (preDuration == currentDuration))
																										{
																											//example 2,2,1
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("begin");
																											//measure 2 = begin		
																											//measure 1 = continue
																											
																										}
																										else 
																										{
																											hasBeamNum.add(true);
																											secondBeamNum.add(true);
																											beamStatus.add("continue");
																											secondBeamStatus.add("end");
																											// example 1,2,1
																											// measure 2 = end
																											//measure 1 = continue	
																										}
																							
																							 }
																	
																								
																	}
																	else 
																	{
																		counter = 0;
																		NumofNotes = 0;
																		
																			if (currentDuration == 1) 
																			{
																				hasBeamNum.add(true);
																				secondBeamNum.add(true);
																				beamStatus.add("end");
																				secondBeamStatus.add("end");
																				// end it 
																				
																			}
																			else 
																			{
																				hasBeamNum.add(true);
																				secondBeamNum.add(false);
																				beamStatus.add("end");
																				secondBeamStatus.add(null);
																				// end it 
																			}
																		
																	}
													}
											
													else 
													// pre duration not equal to 2 or 1 
													{
																	if ((currentDuration == 2) && (nextDuration == 1))
																	{
																		hasBeamNum.add(true);
																		secondBeamNum.add(true);
																		beamStatus.add("begin");
																		secondBeamStatus.add("begin");
																		//example 3,2,1
																		//measure 1 begin
																		// measure 2 begin
																		
																	}
																	else if ((currentDuration == 2) && (nextDuration == 2))
																	{
																		hasBeamNum.add(true);
																		secondBeamNum.add(false);
																		beamStatus.add("begin");
																		secondBeamStatus.add(null);
																		//example 3,2,2
																		// measure 1 begin
																		
																	}
																	else if ((currentDuration == 1) && (nextDuration == 2))
																	{
																		hasBeamNum.add(true);
																		secondBeamNum.add(false);
																		beamStatus.add("begin");
																		secondBeamStatus.add(null);
																		//example 3,1,2
																		// measure 1 begin
																		
																		
																	}
																	else if ((currentDuration == 1) && (nextDuration == 1))
																	{
																		hasBeamNum.add(true);
																		secondBeamNum.add(true);
																		beamStatus.add("begin");
																		secondBeamStatus.add("begin");
																		//example 3,1,1
																		//measure 1 begin
																		// measure 2 begin
																		
																	}
													}
													
												
									    }
										
										else if (((preDuration == 2) || (preDuration == 1)  && (preHead == currentHead)) || (j == 0))
										{
											// example 1,2,3
											// tells us the current duration is the end of a beam 
											//current and pre are 2 or 1 , but next does not equal 1 or 2 					
											counter = 0;
											NumofNotes = 0;
													
													if (currentDuration == 2)
													{
														hasBeamNum.add(true);
														secondBeamNum.add(false);
														beamStatus.add("end");
														secondBeamStatus.add(null);
														
														//example 1,2,3
														//measure 1 end 
														
													}
													else 
													{
														hasBeamNum.add(true);
														secondBeamNum.add(true);
														beamStatus.add("end");
														secondBeamStatus.add("end");
														//example 1,1,3
														//measure 1 end 
														//measure 2 end 
														
													}
											
										}
											
								
									else 
									{
										
										//tells us that the notes before or after are not 1 or 2 , so no beam connection 
											hasBeamNum.add(false);
											secondBeamNum.add(false);
											beamStatus.add(null);
											secondBeamStatus.add(null);
											NumofNotes = 0;
									}
							

								
						}
						
						else 
						{
							// if current duration isnt 2 or 1 not par of a beam [
							hasBeamNum.add(false);
							secondBeamNum.add(false);
							beamStatus.add(null);
							secondBeamStatus.add(null);
							
							
							
							if (chord== false)
							{
							NumofNotes = 0;
							}
							else
							{
								NumofNotes = NumofNotes - 1;
							}
							
							chord = false;
						}		
				
				if (currentVoice != nextVoice)
				{
					counter = 0;
				}
				
				
				if (NumofNotes ==4)
				{
					NumofNotes = 0;
				}
				
				if (counter > 8)
				{
					counter = 0;
				}
				
		}
		
		
		
		
		
		
		
		
		
		
		return secondBeamStatus;
	
	
	
			
}
	
}
>>>>>>> branch 'develop' of https://github.com/joshgenat/2311_Group7.git
