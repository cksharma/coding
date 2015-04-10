


import java.util.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.io.*;

public class FrequentPattern
{
    public void frequent(AssociationRule ar)
    {
        System.out.println("hmap size = " + ar.hmapConfidence.size());
        ArrayList <Integer> lst = new ArrayList <Integer> ();
        for(String sf : ar.hmapConfidence.keySet())
        {
            double a = ar.hmapConfidence.get(sf);
            lst.add((int)a);
        }
        Collections.sort(lst, Collections.reverseOrder());

        int n = lst.get(Math.min(20, lst.size() - 1));

        ArrayList <String> ok = new ArrayList <String> ();

        String[] answer = new String[Math.min(20, lst.size())];

        int i = 0;

        try
        {
            FileWriter fwr = new FileWriter("frequent1.txt");
            for(String sf : ar.hmapConfidence.keySet())
            {
                double k = ar.hmapConfidence.get(sf);
                if(k >= n * 1.0)
                {
                    fwr.write(sf + "  " + k + "%");
                    fwr.write("\n\n");
                    answer[i++] = sf + "  " + k + " %";
                }
            }
            fwr.close();
        }
        catch(Exception ex)
        {
            System.out.println("Problem in writing in file");
        }
        try
        {
            if(answer[0].length() == 0) throw new Exception();
            
            JFrame frame = new JFrame("Frequent Pattern");

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
             JOptionPane.showMessageDialog(null, "No Association Rules formed");
        }
        
   }
}
