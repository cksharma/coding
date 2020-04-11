import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GrammarStatus
{	
	public void getSongNameDetails(String operatorRBTTable)
	{
		String tableQuery = "select count(distinct localSongNameRx) from " + operatorRBTTable + ";";
		String grammarQuery = "select count(distinct PhraseGrammar.PHRASERX) from PhraseGrammar, " + operatorRBTTable +" where PhraseGrammar.PHRASERX=" + operatorRBTTable + ".LOCALSONGNAMERX and PhraseGrammar.ISGRAMMARUSED=1;";							
		System.out.println(tableQuery);
		System.out.println(grammarQuery);
	}
	
	public void getMovieNameDetails(String operatorRBTTable)
	{
		String tableQuery = "select count(distinct localMovieNameRx) from " + operatorRBTTable + ";";
		String grammarQuery = "select count(distinct PhraseGrammar.PHRASERX) from PhraseGrammar, " + operatorRBTTable + " where PhraseGrammar.PHRASERX=" + operatorRBTTable + ".LOCALMOVIENAMERX and PhraseGrammar.ISGRAMMARUSED=1;";							
		System.out.println(tableQuery);
		System.out.println(grammarQuery);
	}
	
	public void getSingerDetails(String operatorRBTTable)
	{
		String tableQuery = "select count(distinct regexp_replace(lower(trim(SINGER)), \'([[:punct:][:blank:]]{1,})\',\'\')) from " + operatorRBTTable + ";";
		String grammarQuery = "select count(distinct PhraseGrammar.PhraseRx) from PhraseGrammar, " + operatorRBTTable + " where PhraseGrammar.PhraseRx=regexp_replace(lower(trim(" + operatorRBTTable + ".SINGER)), \'([[:punct:][:blank:]]{1,})\',\'\') and PhraseGrammar.isGrammarUsed= 1;";
		System.out.println(tableQuery);
		System.out.println(grammarQuery);		
	}
	
	public void solve() throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the OP table");
		String operatorRBTTable = reader.readLine();
		
		getSongNameDetails(operatorRBTTable);
		getMovieNameDetails(operatorRBTTable);
		getSingerDetails(operatorRBTTable);
	}

	public static void main(String[] args)
	{
		try
		{
			new GrammarStatus().solve();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
