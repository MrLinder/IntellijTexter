import javax.swing.JTextArea;

public class Analyzing {

		DataStack Data = null;
		String Result = null;
		
		public Analyzing()
		{
			Data = new DataStack(ViewPanel.SourceData);
			
			if(ViewPanel.ResultsData.length() == 0)
				Result = new String();
			else
				Result = ViewPanel.ResultsData.toString();
			
			
			String currentString = new String();
	        String currentWord = new String();
	        String currentMeaning = new String();
	        
            do{
                if((currentString = Data.popSubString()) != null)
                {
                    currentWord = currentString.substring(0, currentString.indexOf('='));
                    currentMeaning = currentString.substring(currentString.indexOf('=')+1, currentString.indexOf('\n'));

                    
                    if( Result.trim().length() == 0 )
                    {
                    	Result += currentString;
                    	ViewPanel.area_sys.append(Result);
                    }
                    else
                    {
                    	if(!Result.contains(currentWord))
                    	{
                    		Result += currentString;
                    		ViewPanel.area_two.append(currentString);
                    		ViewPanel.area_sys.append("Append: " + currentString);
                    	}
                    	else
                    	{
                    		ViewPanel.area_sys.append("\tConteins:  " + currentString);
                    	}
                    }
                }
            }while(currentString != null);
			
			
				
            ViewPanel.ResultsData.append(Result);
            
		}
}

