package tab2xml;

public class Drum_Identifier {
	
/**
 * This class is temporary, it's purpose is to read the char array made in the 
 * parser, and based on that array identify if the tab given is meant for drums.
 * Drum tabs are the only ones to use the x,X and o symbols so we are going to 
 * be looking for those.
 */
	public void drumIden()
	{
	for(int i = 0;i < lines.size(); i++) 
	{
		if (lines.contains('x'))
		{
			// then we can start using the Tab to XML converting code
			// by ending the Drum to XML method name right here
		}
		else if (lines.contains('X'))
		{
			// then we can start using the Tab to XML converting code
		}	
		else if (lines.contains('o'))
		{

			// then we can start using the Tab to XML converting code
		}
				
	} 
	
}
}