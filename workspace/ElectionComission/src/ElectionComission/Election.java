package ElectionComission;

import java.util.TreeSet;
import java.util.Scanner;
import java.util.HashMap;
import java.util.StringTokenizer;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Election
{
	static HashMap <String, HashMap <String, HashMap <String, TreeSet <Voters> > > > hmap = new HashMap <String, HashMap <String, HashMap <String, TreeSet <Voters> > > >();

	static Scanner si = new Scanner(System.in);

	static Scanner ss = new Scanner(System.in);

	public static void votersAdd(String voterName, String gender, String ck, String constituency, String state)
	{
		if(voterName == null || voterName.length() == 0)
		{
			JOptionPane.showMessageDialog(null, "Please enter the Name of voter");
			return;
		}
		gender = Character.toString(gender.charAt(0)).toUpperCase();
		if(!gender.equals("M") && !gender.equals("F"))
		{
			JOptionPane.showMessageDialog(null, "Gender has to be either Male or Female");
			return;
		}
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
			JOptionPane.showMessageDialog(null, "Enter DOB as YY/MM/DD e.g. 1976/05/21");
			return;
		}
		DOB dob = new DOB(year, month, day);
		if(dob.validVoter() == false)
		{
			JOptionPane.showMessageDialog(null, "Age is not suitable for voting.");
            return;
        }

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
        JOptionPane.showMessageDialog(null, "Voters details successfully entered");
	}

	public static void votersFromState(String state)
	{
		if(hmap.containsKey(state))
		{
            List <String> lst = new ArrayList <String> ();
            for(String str : hmap.get(state).keySet())
			{
				for(String sf : hmap.get(state).get(str).keySet())
				{
					for(Voters v : hmap.get(state).get(str).get(sf))
					{
						lst.add(v.toString());
					}
				}
			}
            String[] answer = new String[lst.size()];
            int index = 0;
            for(int i = 0; i < lst.size(); i++) answer[index++] = lst.get(i);
            try
            {
                if(answer[0].length() == 0) throw new Exception();

                JFrame frame = new JFrame("Voters From State");

                frame.setBounds(0, 0, 500, 500);

                JPanel panel = new JPanel();

                frame.setVisible(true);

                JList list = new JList(answer);

                JScrollPane jsp = new JScrollPane(list);

                panel.add(jsp);

                frame.add(panel);
            }
            catch(Exception e)
            {
                 JOptionPane.showMessageDialog(null, "No voters from this state");
            }
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No voters from this State");
		}
	}

	public static void votersFromConstituency(String constituency)
	{
		boolean found = false;
        List <String> lst = new ArrayList <String> ();
		for(String str : hmap.keySet())
		{
			if(hmap.get(str).containsKey(constituency))
			{
				for(String sf : hmap.get(str).get(constituency).keySet())
				{
					for(Voters v : hmap.get(str).get(constituency).get(sf))
					{
						lst.add(v.toString());
						found = true;
					}
				}
			}
		}
		if(!found)
		{
			JOptionPane.showMessageDialog(null, "No voters from this Constituency");;
		}
        else
        {
            String[] answer = new String[lst.size()];
            int index = 0;
            for(int i = 0; i < lst.size(); i++) answer[index++] = lst.get(i);
            try
            {
                if(answer[0].length() == 0) throw new Exception();

                JFrame frame = new JFrame("Voters From Constituency");

                frame.setBounds(0, 0, 500, 500);

                JPanel panel = new JPanel();

                frame.setVisible(true);

                JList list = new JList(answer);

                JScrollPane jsp = new JScrollPane(list);

                panel.add(jsp);

                frame.add(panel);
            }
            catch(Exception e)
            {
                 JOptionPane.showMessageDialog(null, "No voters from this constituency");
            }
        }
	}

	public static void maleVotersFromConstituency(String constituency)
	{
		boolean found = false;
		List <String> lst = new ArrayList <String> ();
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
							lst.add(v.toString());
							found = true;
						}
					}
				}
			}
		}
		if(!found)
		{
			JOptionPane.showMessageDialog(null, "No male voters from this constituency");
		}
        else
        {
            String[] answer = new String[lst.size()];
            int index = 0;
            for(int i = 0; i < lst.size(); i++) answer[index++] = lst.get(i);
            try
            {
                if(answer[0].length() == 0) throw new Exception();

                JFrame frame = new JFrame("Male Voters From Constituency");

                frame.setBounds(0, 0, 500, 500);

                JPanel panel = new JPanel();

                frame.setVisible(true);

                JList list = new JList(answer);

                JScrollPane jsp = new JScrollPane(list);

                panel.add(jsp);

                frame.add(panel);
            }
            catch(Exception e)
            {
                 JOptionPane.showMessageDialog(null, "No male voters from this constituency");
            }
        }
	}

	public static void femaleVotersFromConstituency(String constituency)
	{
		boolean found = false;
        List <String> lst = new ArrayList <String> ();
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
							lst.add(v.toString());
							found = true;
						}
					}
				}
			}
		}
		if(!found)
		{
			JOptionPane.showMessageDialog(null, "No female voters from this constituency");
		}
        else
        {
            String[] answer = new String[lst.size()];
            int index = 0;
            for(int i = 0; i < lst.size(); i++) answer[index++] = lst.get(i);
            try
            {
                if(answer[0].length() == 0) throw new Exception();

                JFrame frame = new JFrame("Female Voters From Constituency");

                frame.setBounds(0, 0, 500, 500);

                JPanel panel = new JPanel();

                frame.setVisible(true);

                JList list = new JList(answer);

                JScrollPane jsp = new JScrollPane(list);

                panel.add(jsp);

                frame.add(panel);
            }
            catch(Exception e)
            {
                 JOptionPane.showMessageDialog(null, "No female voters from this constituency");
            }
        }
	}

	public static void maleAndFemaleConstituency(String constituency)
	{
		int male = 0, female = 0; boolean found =  false;
		for(String str : hmap.keySet())
		{
			if(hmap.get(str).containsKey(constituency))
			{

				for(String sf : hmap.get(str).get(constituency).keySet())
				{
					//for(Voters v : hmap.get(str).get(constituency).get(sf))
					//{
						if(sf.equals("M")) male++;
						else female++;
						found = true;
					//}
				}
			}

		}
		if(found)
		{
			String[] answer = new String[2];
            answer[0] = "Male Voters = " + male;
            answer[1] = "Female Voters = " + female;
            try
            {
                if(answer[0].length() == 0) throw new Exception();

                JFrame frame = new JFrame("Male and Female in Constituency");

                frame.setBounds(0, 0, 500, 500);

                JPanel panel = new JPanel();

                frame.setVisible(true);

                JList list = new JList(answer);

                JScrollPane jsp = new JScrollPane(list);

                panel.add(jsp);

                frame.add(panel);
            }
            catch(Exception e)
            {
                 JOptionPane.showMessageDialog(null, "No Male and Female Voters Found in this constituency");
            }
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No Male and Female Voters Found in this constituency");
		}
	}

	public static void maleAndFemaleState(String state)
	{
		int male = 0, female = 0;
		if(hmap.containsKey(state))
		{
			for(String str : hmap.get(state).keySet())
			{
				for(String sf : hmap.get(state).get(str).keySet())
				{
					//for(Voters v : hmap.get(state).get(str).get(sf))
					//{
						if(sf.equals("M")) male++;
						else female++;
					//}
				}
			}

            String[] answer = new String[2];
            answer[0] = "Male voters = " + male;
            answer[1] = "Female voters = " + female;

            try
            {
                if(answer[0].length() == 0) throw new Exception();

                JFrame frame = new JFrame("Male and Female State");

                frame.setBounds(0, 0, 500, 500);

                JPanel panel = new JPanel();

                frame.setVisible(true);

                JList list = new JList(answer);

                JScrollPane jsp = new JScrollPane(list);

                panel.add(jsp);

                frame.add(panel);
            }
            catch(Exception e)
            {
                 JOptionPane.showMessageDialog(null, "No Male and Female Voters found in this state");
            }
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No Male and Female Voters Found in this state");
		}
	}
}

