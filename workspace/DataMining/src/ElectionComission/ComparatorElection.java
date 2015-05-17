package ElectionComission;

import java.util.Comparator;

public class ComparatorElection implements Comparator <Voters>
{

	@Override
	public int compare(Voters o1, Voters o2) 
	{
		int comp = o1.getVoterName().compareTo(o2.getVoterName());
		if(comp != 0) return comp;
		return o1.getDob().compareTo(o2.getDob());
	}

}
