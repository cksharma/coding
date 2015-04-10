

import java.util.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.io.*;

public class SearchPattern
{
    public void Search(String s, AssociationRule ar)
    {
        List <String> lstsearch = new ArrayList <String> ();

        for(String sf : ar.hmapConfidence.keySet())
        {
            if(sf.toLowerCase().contains(s.toLowerCase()))
            {
                lstsearch.add(sf);
            }
        }

        int i = 0;

        String[] answer = new String[lstsearch.size() + 2];
        try
        {
            FileWriter fwr = new FileWriter("search.txt");
            for(String sf : lstsearch)
            {
                answer[i++] = sf + "   " + ar.hmapConfidence.get(sf) + "%";
                fwr.write(sf + "   " + ar.hmapConfidence.get(sf) + "%\n\n");
            }
            fwr.close();
        }
        catch(Exception ex)
        {
            System.out.println("Problem in writing the search results in file");
        }
        try
        {

           System.out.println("lst.size() = " + lstsearch.size());

           if(lstsearch.isEmpty()) throw new Exception();

            JFrame frame = new JFrame("Searching Rules");

            frame.setBounds(0, 0, 500, 500);

            JPanel panel = new JPanel();

            frame.setVisible(true);

            JList list = new JList(answer);

            JScrollPane jsp = new JScrollPane(list);

            panel.add(jsp);

            frame.add(panel);
        }

        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"No Association Rules formed with the given Data");
        }
    }
}
