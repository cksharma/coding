package ElectionComission;

public class DOB
{
	int year;
	int month;
	int day;
	DOB(int year, int month, int day)
	{
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public boolean validVoter()
	{
		if(year < 1992) return true;
		if(year == 1992 && month <= 7) return true;
		return false;
	}
	@Override
	public String toString()
	{
		return year +"/" + month + "/" + day + "";
	}
}
