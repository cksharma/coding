


import javax.swing.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileReader;

public class AssociationRule
{
    public int columnNumber = 0;

	public int rowNumber = 0;

	public int INF = Integer.MAX_VALUE;

	public int MAX = 50;

	public String[][] inputTokens = new String[MAX][MAX];

    private final double MIN_SUPPORT = 0.0;

    private final double MAX_SUPPORT = 100.0;

    private final double MIN_CONFIDENCE = 0.0;

    private final double MAX_CONFIDENCE = 100.0;

	public int confidence;

	public int support;

	public ArrayList <ArrayList <ArrayList <String> > > lst = new ArrayList <ArrayList <ArrayList <String> > > ();

	public ArrayList <ArrayList <ArrayList <String> > > prunned = new ArrayList <ArrayList <ArrayList <String> > > ();

	public HashMap <ArrayList <String>, Integer> hmap = new HashMap <ArrayList <String>, Integer> ();

	public HashMap <String, Double> hmapConfidence = new HashMap <String, Double> ();

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void Association(String path1, String path2, String path3)
    {
        try
        {
            NewJFrame ok = new NewJFrame();

            confidence = Integer.parseInt(path2);

            support = Integer.parseInt(path3);

			if(confidence > MAX_CONFIDENCE || support > MAX_SUPPORT || confidence < MIN_CONFIDENCE || support < MIN_SUPPORT)
			{
				throw new Exception();
			}
		}
		catch(Exception e)
		{
			System.out.println("Confidence and Support value should be in the range of 0 - 100");
			System.exit(1);
		}

		try
		{

            File myFile = new File(path1);

            FileReader rr = new FileReader(myFile);
            reader = new BufferedReader(rr);

			String line = new String();

			while((line = reader.readLine()) != null)
			{
				fillArray(inputTokens, line);
				rowNumber++;
			}
			for(int i = 0; i < rowNumber; i++)
			{
				int N = countTokens(inputTokens[i]);
				sortEachLine(inputTokens[i], N);
			}
			for(int i = 0; i < rowNumber; i++)
			{
				subSetGenerate(inputTokens[i]);
			}

			for(int i = 0; i < lst.size(); i++)
			{
				for(int j = 0; j < lst.get(i).size(); j++)
				{
					if(hmap.containsKey(lst.get(i).get(j))) hmap.put(lst.get(i).get(j), hmap.get(lst.get(i).get(j)) + 1);
					else hmap.put(lst.get(i).get(j), 1);
				}
			}

			SupportPrunning();

			ConfidencePrunning();

			System.out.println();


			System.out.println();
			System.out.println("ASSOCIATION RULES");
			System.out.println("=================");
            if(hmapConfidence.size() < 1)
			{
				System.out.println();
                System.out.println("No association rules can be generated from the data sets for the given Support and Confidence");
			}
			System.out.println();
			String ans = "";
            FileWriter fwriter = new FileWriter("output.txt");
            
           for(String item : hmapConfidence.keySet())
			{
				if(item.length() < 1) continue;
                String answer = "";
                answer = item + "   " + hmapConfidence.get(item) + "%\n" ;
                System.out.println(answer);
                fwriter.write(answer);
                fwriter.write("\n");
                //System.out.println(item + "   " + hmapConfidence.get(item));
            }
            reader.close();
            fwriter.close();
		}
		catch(Exception ex)
		{
			System.out.println("File not found on this directory");
			ex.printStackTrace();
		}
    }
    public void ConfidencePrunning()
	{

		for(int i = 0; i < lst.size(); i++)
		{
			for(int j = 0; j < lst.get(i).size(); j++)
			{
				ArrayList <String> antecedent = new ArrayList <String>(lst.get(i).get(j));

				int countAntecedent = hmap.get(lst.get(i).get(j));

				for(int k = 0; k < lst.get(i).size(); k++)
				{
					if(j == k) continue;

					ArrayList <String> consequent = new ArrayList <String> (lst.get(i).get(k));

					int bothOccurrence = CheckBothOccurence(antecedent, consequent);

					boolean status =  false;

					outer:for(int a = 0; a < antecedent.size(); a++)
					{
						for(int b = 0; b < consequent.size(); b++)
						{
							if(antecedent.get(a).equals(consequent.get(b)))
							{
								status = true;
								break outer;
							}
						}
					}
					if(status) continue;

					if(bothOccurrence * 100 >= confidence * countAntecedent)
					{
						String ans = "{";

						for(int a = 0; a < antecedent.size();a++)
                        {
                           ans += antecedent.get(a) + ", ";
                        }
						ans += "}  -->  {";

						int l1 = ans.lastIndexOf(",");

						ans = new StringBuilder(ans).replace(l1, l1 + 1,"").toString();

						for(int b = 0; b < consequent.size(); b++)
                        {
                            ans += consequent.get(b) + ", ";
                        }
						ans += "}";

						int l2 = ans.lastIndexOf(",");

						ans = new StringBuilder(ans).replace(l2, l2 + 1, "").toString();

						hmapConfidence.put(ans, bothOccurrence * 1.0 / countAntecedent * 100);
					}
				}
			}
		}
	}

	public int CheckBothOccurence(ArrayList <String> antecedent, ArrayList <String> consequent)
	{
		int both = 0;

		for(int i = 0; i < lst.size(); i++)
		{
			if(lst.get(i).contains(antecedent) && lst.get(i).contains(consequent))
				both++;
		}

		return both;
	}

	public void SupportPrunning()
	{
		while(true)
		{
			boolean flag = false;

			outer:for(int i = 0; i < lst.size(); i++)
			{
				for(int j = 0; j < lst.get(i).size(); j++)
				{
					int value = hmap.get(lst.get(i).get(j));

					if(value * 100 < support * rowNumber)
					{
						lst.get(i).remove(lst.get(i).get(j));
						flag = true;
						break outer;
					}
				}
			}

			if(!flag) break;
		}
		return;
	}

	public void subSetGenerate(String[] tokens)
	{
		int n = countTokens(tokens);

		int L = 1 << n;

		ArrayList <ArrayList <String> > now = new ArrayList <ArrayList <String> > ();

		for(int i = 1; i < L; i++)
		{
			ArrayList <String> temp = new ArrayList <String> ();

			for(int j = 0; j < n; j++)
			{
				if((i & (1 << j)) != 0)
				{
					temp.add(tokens[j]);
				}
			}
			now.add(temp);
		}
		lst.add(now);
	}

	public int countTokens(String str)
	{
		StringTokenizer st = new StringTokenizer("[ , ]");

		int count = 0;

		while(st.hasMoreTokens())
		{
			st.nextToken();
			count++;
		}

		return count;
	}

	public int countTokens(String[] ans)
	{
		int cnt = 0;

		for(int i = 0; i < ans.length; i++)
		{
			if(ans[i] == null) break;
			cnt++;
		}

		return cnt;
	}

	public void fillArray(String[][] inputTokens, String currentLine)
	{
		String[] eachRow = currentLine.split("[ , ]");
        
		int start = 0;

		for(int i = 0; i < eachRow.length; i++)
		{
			if(eachRow[i].length() < 1) continue;
			inputTokens[rowNumber][start++] = eachRow[i].trim();
		}
	}

	public void sortEachLine(String[] ans, int N)
	{

		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				if(ans[i].compareToIgnoreCase(ans[j]) < 0)
				{
					String temp = ans[i];
					ans[i] = ans[j];
					ans[j] = temp;
				}
			}
		}
    }
}
