package ElectionComission;

import java.util.TreeSet;
import java.util.Scanner;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Election 
{
	static HashMap <String, HashMap <String, HashMap <String, TreeSet <Voters> > > > hmap = new HashMap <String, HashMap <String, HashMap <String, TreeSet <Voters> > > >();
	
	static Scanner si = new Scanner(System.in);
	
	static Scanner ss = new Scanner(System.in);
	
	public static void votersAdd() 
	{
		System.out.println("Enter the name of the voter");
		String voterName = ss.nextLine();
		
		System.out.println("Enter the gender of voter i.e  M or F  ?");
		String gender = ss.nextLine().toUpperCase();
		if(!gender.equals("M") && !gender.equals("F"))
		{
			System.out.println("Gender should be M or F .. ");
			return;
		}
		System.out.println("Enter the date of birth of Voter");
		System.out.println("it should be is format  year/month/day e.g. 1976/06/23");
		
		String ck = ss.nextLine();
		StringTokenizer stk = new StringTokenizer(ck, "[/]");
		int year = 0, month = 0, day = 0;
		try
		{
			year = Integer.parseInt(stk.nextToken());
			month = Integer.parseInt(stk.nextToken());
			day = Integer.parseInt(stk.nextToken());
		}
		catch(NumberFormatException e1)
		{
			System.out.println("U haven't entered date of birth as year/month/day e.g. 1976/06/23 .. Re-enter the details");
			return;
		}
		DOB dob = new DOB(year, month, day);
		if(dob.validVoter() == false)
		{
			throw new VoterAgeException("age is not suitable for voting");
		}
		System.out.println("Enter the constituency of voter");
		String constituency = ss.nextLine();
		System.out.println("Enter the state of voter");
		String state = ss.nextLine();
		Voters v = new Voters(voterName, gender, dob);
		
		if(hmap.containsKey(state))
		{
			if(hmap.get(state).containsKey(constituency))
			{
				if(hmap.get(state).get(constituency).containsKey(gender))
				{
					hmap.get(state).get(constituency).get(gender).add(v);
				}
				else
				{
					TreeSet <Voters> hv = new TreeSet <Voters> (new ComparatorElection());
					hv.add(v);
					hmap.get(state).get(constituency).put(gender, hv);
				}
			}
			else
			{
				TreeSet <Voters> hv = new TreeSet <Voters> (new ComparatorElection());
				hv.add(v);
				HashMap <String, TreeSet <Voters> > hvs = new HashMap <String, TreeSet <Voters> > ();
				hvs.put(gender,  hv);
				hmap.get(state).put(constituency, hvs);
			}
		}
		else
		{
			TreeSet <Voters> hv = new TreeSet <Voters> (new ComparatorElection());
			hv.add(v);
			HashMap <String, TreeSet <Voters> > hvs = new HashMap <String, TreeSet <Voters> > ();
			hvs.put(gender,  hv);
			HashMap <String, HashMap <String, TreeSet <Voters> > > hvss = new HashMap <String, HashMap <String, TreeSet <Voters> > > ();
			hvss.put(constituency, hvs);
			hmap.put(state, hvss);
		}
	}
	
	public static void votersFromState()
	{
		System.out.println("Enter the state");
		String state = ss.nextLine();
		if(hmap.containsKey(state))
		{
			for(String str : hmap.get(state).keySet())
			{
				for(String sf : hmap.get(state).get(str).keySet())
				{
					for(Voters v : hmap.get(state).get(str).get(sf))
					{
						System.out.println(v);
					}
				}
			}
		}
		else
		{
			System.out.println("No voters from this state");
		}
	}
	
	public static void votersFromConstituency()
	{
		System.out.println("Enter the consituency");
		String constituency = ss.nextLine();
		boolean found = false;
		for(String str : hmap.keySet())
		{
			if(hmap.get(str).containsKey(constituency))
			{
				for(String sf : hmap.get(str).get(constituency).keySet())
				{
					for(Voters v : hmap.get(str).get(constituency).get(sf))
					{
						System.out.println(v);
						found = true;
					}
				}
			}
		}
		if(!found)
		{
			System.out.println("No voters found in this constituency");
		}
	}
	
	public static void maleVotersFromConstituency()
	{
		System.out.println("Enter the constituency name whose Male voters u wanna see");
		String constituency = ss.nextLine();
		boolean found = false;
		for(String str : hmap.keySet())
		{
			if(hmap.get(str).containsKey(constituency))
			{
				for(String sf : hmap.get(str).get(constituency).keySet())
				{
					for(Voters v : hmap.get(str).get(constituency).get(sf))
					{
						if(sf.equals("M") || sf.equals("MALE"))
						{
							System.out.println(v);
							found = true;
						}	
					}
				}
			}
		}
		if(!found)
		{
			System.out.println("No male voters found in this constituency");
		}
	}
	
	public static void femaleVotersFromConstituency()
	{
		System.out.println("Enter the constituency name whose female voters u wanna see");
		String constituency = ss.nextLine();
		boolean found = false;
		for(String str : hmap.keySet())
		{
			if(hmap.get(str).containsKey(constituency))
			{
				for(String sf : hmap.get(str).get(constituency).keySet())
				{
					for(Voters v : hmap.get(str).get(constituency).get(sf))
					{
						if(sf.equals("F") || sf.equals("FEMALE"))
						{
							System.out.println(v);
							found = true;
						}	
					}
				}
			}
		}
		if(!found)
		{
			System.out.println("No female voters found in this constituency");
		}
	}
	
	public static void maleAndFemaleConstituency()
	{
		System.out.println("Enter the constituency name whose male and Female voters u wanna see");
		String constituency = ss.nextLine();
		int male = 0, female = 0; boolean found =  false;
		for(String str : hmap.keySet())
		{
			if(hmap.get(str).containsKey(constituency))
			{
					
				for(String sf : hmap.get(str).get(constituency).keySet())
				{
					for(Voters v : hmap.get(str).get(constituency).get(sf))
					{
						if(sf.equals("M")) male++;
						else female++;
						found = true;
					}
				}	
			}
			
		}
		if(found)
		{
			System.out.println("Number of male voters = " + male);
			System.out.println("Number of female voters = " + female);
		}
		else
		{
			System.out.println("No male and female voters found in this constituency");
		}
	}
	
	public static void maleAndFemaleState()
	{
		System.out.println("Enter the state name ");
		String state = ss.nextLine();
		int male = 0, female = 0;
		if(hmap.containsKey(state))
		{
			for(String str : hmap.get(state).keySet())
			{
				for(String sf : hmap.get(state).get(str).keySet())
				{
					for(Voters v : hmap.get(state).get(str).get(sf))
					{
						if(sf.equals("M")) male++;
						else female++;
					}
				}
			}
		}
		else
		{
			System.out.println("No male and female voters found in this state");
		}
		System.out.println("Number of male voters = " + male);
		System.out.println("Number of female voters  = "  + female);
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Welcome to voting system");
		System.out.println();
		System.out.println("Enter your choices   ");
		System.out.println("======================");
		System.out.println();
		
		while(true)
		{
			System.out.println();
			System.out.println("1. All a voter to the list");
			System.out.println("2. List all voters from a specific state");
			System.out.println("3. List all voters from a specific constituency");
			System.out.println("4. List all male voters from a specific constituency");
			System.out.println("5. List all female voters from a specific constituency");
			System.out.println("6. List the total number of Male and Female voters in a constituency");
			System.out.println("7. List the total number of Male and Female voters in a state");
			System.out.println("8. To exit ......");
			System.out.println();
			int choice = si.nextInt();
			boolean flag = false;
			switch(choice)
			{
				case 1 :
					try
					{
						votersAdd();
					}
					catch(VoterAgeException e1)
					{
						System.out.println(e1.getMessage());
					}
					break;
				case 2:
					votersFromState();
					break;
				case 3:
					votersFromConstituency();
					break;
				case 4:
					maleVotersFromConstituency();
					break;
				case 5: 
					femaleVotersFromConstituency();
					break;
				case 6:
					maleAndFemaleConstituency();
					break;
				case 7:
					maleAndFemaleState();
					break;
				default:
					flag = true;
					System.out.println("Exitting  ... ");
					break;
			}
			if(flag) break;
		}	
	}
}

class VoterAgeException extends RuntimeException
{
	VoterAgeException(String message)
	{
		super(message);
	}
}