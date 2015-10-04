import java.io.*;
import java.sql.SQLException;
import java.util.*;
import java.util.Map.Entry;


public class apriori_class {

    static int SUPPORT=0;
    static float CONFIDENCE=0 ;

    static LinkedHashMap<String,TreeSet<Integer>> testfrequentSet1= new LinkedHashMap<String,TreeSet<Integer>>();
    static LinkedHashMap<String,TreeSet<Integer>> testfrequentSet2= new LinkedHashMap<String,TreeSet<Integer>>();
    static LinkedHashMap<String,TreeSet<Integer>> testAllfrequentSet= new LinkedHashMap<String,TreeSet<Integer>>();
    static LinkedHashMap<String,TreeSet<Integer>> frequentSetForAsso= new LinkedHashMap<String,TreeSet<Integer>>();

    //MAp for Association rule
    static HashMap<LinkedHashSet<String>,LinkedHashSet<String>> Head= new HashMap<LinkedHashSet<String>,LinkedHashSet<String>>();
    static HashMap<LinkedHashSet<String>,LinkedHashSet<String>> Body= new HashMap<LinkedHashSet<String>,LinkedHashSet<String>>();
    static HashMap<LinkedHashSet<String>,LinkedHashSet<String>> Rule= new HashMap<LinkedHashSet<String>,LinkedHashSet<String>>();

    public static void main(String[] args) {

        try{


            readConfig();


        }
        catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{}//end try
        // System.out.println("Goodbye!");
    }//end main

    private static void iteration_1()
            throws SQLException {
        LinkedHashMap<String,TreeSet<Integer>> tempAllfrequentSet= new LinkedHashMap<String,TreeSet<Integer>>();
        for(int i=1;i<=100;i++)
        {
            //String s = "innerHashSet"+i;
            TreeSet<Integer> innerHashSet = new TreeSet<Integer>();
            TreeSet<Integer> innerHashSet1 = new TreeSet<Integer>();
            tempAllfrequentSet.put("G"+i+"_UP", innerHashSet);
            tempAllfrequentSet.put("G"+i+"_Down", innerHashSet1);
        }

        TreeSet<Integer> innerHashSet1= new TreeSet<Integer>();
        tempAllfrequentSet.put("ALL", innerHashSet1);

        TreeSet<Integer> innerHashSet2= new TreeSet<Integer>();
        tempAllfrequentSet.put("AML", innerHashSet2);

        TreeSet<Integer> innerHashSet3= new TreeSet<Integer>();
        tempAllfrequentSet.put("Breast Cancer", innerHashSet3);

        TreeSet<Integer> innerHashSet4= new TreeSet<Integer>();
        tempAllfrequentSet.put("Colon Cancer", innerHashSet4);


        try {
            BufferedReader reader = new BufferedReader(new FileReader("association-rule-test-data.txt"));
            String line = null;
            int rowCnt=0;
            while ((line = reader.readLine()) != null)
            {
                String split[] = line.split("\t");
                rowCnt++;
                for(int i=1;i<=101;i++)
                {

                    if(i<101)
                    {
                        String ud = "_"+split[i];
                        TreeSet<Integer> temp = new TreeSet<Integer>();
                        temp=tempAllfrequentSet.get("G"+i+ud);
                        temp.add(rowCnt);
                        tempAllfrequentSet.put("G"+i+ud, temp);
                        //testfrequentSet1.put("G"+i+"_UP", innerHashSet_1);
                    }
                    else
                    {
                        TreeSet<Integer> temp = new TreeSet<Integer>();
                        temp=tempAllfrequentSet.get(split[i]);
                        temp.add(rowCnt);
                        tempAllfrequentSet.put(split[i], temp);
                        //testfrequentSet1.get(split[i]).add(i);
                    }

                }


            }

            for ( Entry<String, TreeSet<Integer>> entry : tempAllfrequentSet.entrySet()) {

                //System.out.print(entry.getKey());
                //System.out.println("    "+entry.getValue().size());
                if(entry.getValue().size()>=SUPPORT)
                    testfrequentSet1.put(entry.getKey(), entry.getValue());
            }
            System.out.println();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        System.out.println( "size of frequent itemset 1   :"+testfrequentSet1.size());
        testAllfrequentSet.putAll(testfrequentSet1);
        // System.out.println( "iteration 1 :  "+testAllfrequentSet.size());
        //                for ( Entry<String, TreeSet<Integer>> entry : testfrequentSet1.entrySet()) {
        //
        //                    System.out.print(entry.getKey());
        //                    System.out.println("    "+entry.getValue().size());
        //
        //                }
        LinkedHashMap<String,TreeSet<Integer>> tempfrequentSet1= new LinkedHashMap<String,TreeSet<Integer>>();
        tempfrequentSet1.putAll(testfrequentSet1);
        int size=tempfrequentSet1.size();
        Set<String> keyset= tempfrequentSet1.keySet();

        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                String s1 =(String) keyset.toArray()[i];
                String s2 =(String) keyset.toArray()[j];
                String[] s3=s1.split("_");
                String[] s4=s2.split("_");
                if(!s3[0].equals(s4[0]))
                {
                    TreeSet<Integer> t1= new TreeSet<Integer>();
                    t1 = (TreeSet<Integer>) tempfrequentSet1.get(s1).clone();
                    TreeSet<Integer> t2= new TreeSet<Integer>();
                    t2 = (TreeSet<Integer>) tempfrequentSet1.get(s2).clone();
                    t1.retainAll(t2);
                    if(t1.size()>=SUPPORT)
                        testfrequentSet2.put(s1+","+s2,t1);
                }


            }
        }
        if(testfrequentSet2.size()>0)
            System.out.println( "size of frequent itemset 2   :"+testfrequentSet2.size());
        testAllfrequentSet.putAll(testfrequentSet2);
        frequentSetForAsso.putAll(testfrequentSet2);

    }

    private static void AllIterations() throws Exception
    {

        LinkedHashMap<String,TreeSet<Integer>> intermediate1= new LinkedHashMap<String,TreeSet<Integer>>();

        intermediate1.putAll(testfrequentSet2);

        testfrequentSet2.clear();
        int iterationCount=1;
        int PreviousInnerSize=0;
        int currentInnerSize=1;
        int itemsetcount=3;
        while(PreviousInnerSize!=currentInnerSize)
        {
            PreviousInnerSize=currentInnerSize;
            int size= intermediate1.size();
            Set<String> keyset= intermediate1.keySet();

            for (int i = 0; i < size; i++) {
                LinkedHashMap<String , String> inner = new LinkedHashMap<String, String>();
                for (int j = i+1; j < size; j++) {
                    String s1 =(String) keyset.toArray()[i];
                    String s2 =(String) keyset.toArray()[j];
                    String[] s3=s1.split(",");
                    String[] s4= s2.split(",");

                    if(s3.length==s4.length)
                    {
                        StringBuilder sb1= new StringBuilder();
                        for (int k = 0; k < s3.length-1; k++) {
                            sb1.append(s3[k]);

                        }
                        StringBuilder sb2= new StringBuilder();
                        for (int k = 0; k < s4.length-1; k++) {
                            sb2.append(s4[k]);

                        }
                        if(sb1.toString().equals(sb2.toString()))
                        {
                            TreeSet<Integer> T1= new TreeSet<Integer>();
                            T1=(TreeSet<Integer>) intermediate1.get(s1).clone();
                            TreeSet<Integer> T2= new TreeSet<Integer>();
                            T2=(TreeSet<Integer>) intermediate1.get(s2).clone();

                            T1.retainAll(T2);
                            if(T1.size()>=SUPPORT)
                            {


                                for (String string : s3) {
                                    if(!inner.containsKey(string))
                                        inner.put(string,string);
                                }
                                for (String string : s4) {
                                    if(!inner.containsKey(string))
                                        inner.put(string,string);
                                }

                                if(inner.size()> currentInnerSize)
                                {
                                    currentInnerSize=inner.size();
                                }
                                if(inner.size()>iterationCount)
                                {
                                    StringBuilder s11=new StringBuilder();
                                    for( Entry<String, String> entry : inner.entrySet()) {
                                        s11.append(entry.getKey()+",");
                                    }
                                    String whrClause= s11.toString();
                                    int len=whrClause.length();
                                    whrClause= whrClause.substring(0, len-1);




                                    //									String s[] = whrClause.split(",");
                                    //
                                    //									TreeSet<String> tree = new TreeSet<String>();
                                    //									for(int k=0; k<s.length ; k++)
                                    //									{
                                    //										tree.add(s[k]);
                                    //									}
                                    //
                                    //									Iterator<String> itr = tree.iterator();
                                    //									StringBuilder a = new  StringBuilder();
                                    //									while(itr.hasNext())
                                    //									{
                                    //										a.append(itr.next()).append(",");
                                    //									}
                                    //
                                    //									int len1=a.length();
                                    //									String str = a.substring(0, len1-1);
                                    //									testfrequentSet2.put(str, T1);



                                    testfrequentSet2.put(whrClause, T1);
                                    //System.out.println(whrClause+"  "+T1.size());
                                }
                                inner.clear();

                            }

                        }
                        else
                            break;
                    }


                }
            }

            //add here
            if(testfrequentSet2.size()>0)
                System.out.println( "size of frequent itemset "+ itemsetcount+++" :  "+testfrequentSet2.size());
            testAllfrequentSet.putAll(testfrequentSet2);
            frequentSetForAsso.putAll(testfrequentSet2);
            //System.out.println( "iteration  :  "+testAllfrequentSet.size());
            //				for ( Entry<String, TreeSet<Integer>> entry : testfrequentSet2.entrySet()) {
            //
            //					System.out.print(entry.getKey());
            //					System.out.println("    "+entry.getValue().size());
            //
            //				}

            intermediate1.clear();
            intermediate1.putAll(testfrequentSet2);
            testfrequentSet2.clear();
            iterationCount++;
        }
        //		for ( Entry<String, TreeSet<Integer>> entry : frequentSetForAsso.entrySet()) {
        //
        //			System.out.print(entry.getKey());
        //			System.out.println("    "+entry.getValue().size());
        //
        //		}
        System.out.println("Total  :" +testAllfrequentSet.size());
    }

    private static void GenRule() throws Exception
    {
        int ruleCnt=1;
        for ( Entry<String, TreeSet<Integer>> entry : frequentSetForAsso.entrySet()) {
            //System.out.println("***************************************"+entry.getKey());
            float supp_all =testAllfrequentSet.get(entry.getKey()).size();
            String a=entry.getKey();
            //String a="a,b,c,d,e";
            //int size = a.size();
            int count = 1;
            String lhs = null;
            StringBuilder rhs = null;

            String [] arr = a.split(",");
            int size = arr.length;
            //ArrayList<String> t = new ArrayList<String>();
            //ArrayList<String> temp = new ArrayList<String>();
            LinkedHashSet<String> temp= new LinkedHashSet<String>();
            LinkedHashSet<String> t= new LinkedHashSet<String>();

            for (String string : arr) {

                temp.add(string);
            }


            while(count < size)
            {

                //String [] temp  = (String[]) t.toArray();

                lhs = new String();


                for(int i=0; i<temp.size() ; i++)
                {
                    lhs = (String) temp.toArray()[i];
                    rhs = new StringBuilder();
                    for(int j=0; j<size ; j++)
                    {
                        if(!lhs.contains(arr[j]))
                        {
                            rhs.append(arr[j]).append(",");
                        }


                    }
                    String RHS= rhs.toString();
                    int len=RHS.length();
                    RHS= RHS.substring(0, len-1);
                    //if(testAllfrequentSet.containsKey(lhs))
                    //{
                    float supp_lhs = testAllfrequentSet.get(lhs).size();

                    float conf = (supp_all)/supp_lhs;



                    if(conf>CONFIDENCE)
                    {
                        System.out.println(ruleCnt+++" "+lhs+"  ------>  "+RHS + "  ------   Confidence  " + conf);

                        String[] SplitLHS = lhs.split(",");
                        String[] SplitRHS = RHS.split(",");

                        LinkedHashSet<String> LHSSet= new LinkedHashSet<String>();
                        LinkedHashSet<String> RHSSet= new LinkedHashSet<String>();
                        LinkedHashSet<String> RuleSet= new LinkedHashSet<String>();
                        for (String string : SplitLHS) {
                            LHSSet.add(string);
                            RuleSet.add(string);

                        }
                        for (String string : SplitRHS) {
                            RHSSet.add(string);
                            RuleSet.add(string);
                        }

                        LinkedHashSet<String> rule1=new LinkedHashSet<>();
                        rule1.add(lhs+"-->"+RHS);

                        LinkedHashSet<String> rule2=new LinkedHashSet<>();
                        rule2.add(lhs+"-->"+RHS);

                        LinkedHashSet<String> rule3=new LinkedHashSet<>();
                        rule3.add(lhs+"-->"+RHS);


                        //---------------HEAD
                        if(Head.containsKey(RHSSet))
                        {
                            Head.get(RHSSet).add(lhs+"-->"+RHS);
                        }
                        else
                        {
                            Head.put(RHSSet, rule1);
                        }

                        //----------BODY
                        if(Body.containsKey(LHSSet))
                        {
                            Body.get(LHSSet).add(lhs+"-->"+RHS);
                        }
                        else
                        {
                            Body.put(LHSSet, rule2);
                        }

                        //----------RULE
                        if(Rule.containsKey(RuleSet))
                        {
                            Rule.get(RuleSet).add(lhs+"-->"+RHS);
                        }
                        else
                        {
                            Rule.put(RuleSet, rule3);
                        }


                    }

                }

                for(int i=0; i<temp.size()-1 ; i++)
                {
                    for(int j=i+1; j<temp.size() ; j++)
                    {
                        String combination = new String();
                        StringBuilder c = new StringBuilder();

                        if(((String) temp.toArray()[i]).contains(","))
                        {
                            String[] c1 = (String[]) ((String) temp.toArray()[i]).split(",");
                            String[] c2 = (String[]) ((String) temp.toArray()[j]).split(",");

                            if(c1.length==c2.length)
                            {
                                StringBuilder sb1= new StringBuilder();
                                for (int k = 0; k < c1.length-1; k++) {
                                    sb1.append(c1[k]);
                                }
                                StringBuilder sb2= new StringBuilder();
                                for (int k = 0; k < c2.length-1; k++) {
                                    sb2.append(c2[k]);
                                }
                                if(sb1.toString().equals(sb2.toString()))
                                {
                                    LinkedHashSet<String> hs = new LinkedHashSet<String>();
                                    //TreeSet<String> tree = new TreeSet<String>();
                                    for(int k=0; k<c1.length ; k++)
                                    {
                                        //tree.add(c1[k]);
                                        hs.add(c1[k]);
                                    }
                                    for(int k=0; k<c2.length ; k++)
                                    {
                                        //tree.add(c2[k]);
                                        hs.add(c2[k]);
                                    }



                                    Iterator<String> itr = hs.iterator();
                                    while(itr.hasNext())
                                    {
                                        c.append(itr.next()).append(",");
                                    }
                                    combination= c.substring(0, c.length()-1);
                                    t.add(combination);
                                    //System.out.println("Combination  :"+combination);



                                }
                                else
                                    break;
                            }

                        }
                        else
                        {
                            combination = (String) temp.toArray()[i]+","+(String) temp.toArray()[j];
                            t.add(combination);
                            //System.out.println("Combination  :"+combination);
                        }


                    }

                }

                count++;
                temp.clear();
                temp.addAll(t);
                t.clear();
            }

        }
    }

    private static void Template1(String p1, String p2, String p3 )
    {
        if(p1.equals("RULE"))
        {
            if(p2.equals("ANY"))
            {
                //traverse the rule map

                traverseRule(p2, p3);


            }
            else if(p2.equals("NONE"))
            {
                traverseRule(p2, p3);
            }
            else
            {
                traverseRule(p2, p3);
            }
        }
        else if(p1.equals("HEAD"))
        {
            if(p2.equals("ANY"))
            {
                //traverse the rule map

                traverseHead(p2, p3);


            }
            else if(p2.equals("NONE"))
            {
                traverseHead(p2, p3);
            }
            else
            {
                traverseHead(p2, p3);
            }
        }
        else if(p1.equals("BODY"))
        {
            if(p2.equals("ANY"))
            {
                //traverse the rule map

                traverseBody(p2, p3);


            }
            else if(p2.equals("NONE"))
            {
                traverseBody(p2, p3);
            }
            else
            {
                traverseBody(p2, p3);
            }
        }


    }
    private static void traverseRule(String p2, String p3)
    {
        int count=1;
        String[] items= p3.split(",");
        LinkedHashSet<String> itemsset= new LinkedHashSet<>();
        for (String string : items) {
            itemsset.add(string);
        }
        //traverse the rule map

        for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Rule.entrySet()) {
            LinkedHashSet<String> n1= new LinkedHashSet<>();
            n1=(LinkedHashSet<String>) ent.getKey().clone();

            n1.retainAll(itemsset);

            if(p2.equals("ANY"))
            {
                if(n1.size()>=1)
                {
                    LinkedHashSet<String> n2= new LinkedHashSet<>();
                    n2=ent.getValue();
                    //System.out.println("RULE     :");
                    for (String string : n2) {
                        System.out.println(count+++"    "+string);
                    }

                }
            }
            else if(p2.equals("NONE"))
            {
                if(n1.size()==0)
                {
                    LinkedHashSet<String> n2= new LinkedHashSet<>();
                    n2=ent.getValue();
                    //System.out.println("RULE     :");
                    for (String string : n2) {
                        System.out.println(count+++"    "+string);
                    }

                }
            }
            else
            {
                if(n1.size()==Integer.parseInt(p2))
                {
                    LinkedHashSet<String> n2= new LinkedHashSet<>();
                    n2=ent.getValue();
                    //System.out.println("RULE     :");
                    for (String string : n2) {
                        System.out.println(count+++"	"+string);
                    }

                }
            }




        }



    }

    private static void traverseHead(String p2, String p3)
    {int count=1;
        String[] items= p3.split(",");
        LinkedHashSet<String> itemsset= new LinkedHashSet<>();
        for (String string : items) {
            itemsset.add(string);
        }
        //traverse the rule map

        for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Head.entrySet()) {
            LinkedHashSet<String> n1= new LinkedHashSet<>();
            n1=(LinkedHashSet<String>) ent.getKey().clone();

            n1.retainAll(itemsset);

            if(p2.equals("ANY"))
            {
                if(n1.size()>=1)
                {
                    LinkedHashSet<String> n2= new LinkedHashSet<>();
                    n2=ent.getValue();
                    //System.out.println("RULE     :");
                    for (String string : n2) {
                        System.out.println(count+++"    "+string);
                    }

                }
            }
            else if(p2.equals("NONE"))
            {
                if(n1.size()==0)
                {
                    LinkedHashSet<String> n2= new LinkedHashSet<>();
                    n2=ent.getValue();
                    //System.out.println("RULE     :");
                    for (String string : n2) {
                        System.out.println(count+++"    "+string);
                    }

                }
            }
            else
            {
                if(n1.size()==Integer.parseInt(p2))
                {
                    LinkedHashSet<String> n2= new LinkedHashSet<>();
                    n2=ent.getValue();
                    //System.out.println("RULE     :");
                    for (String string : n2) {
                        System.out.println(count+++"    "+string);
                    }

                }
            }




        }



    }
    private static void traverseBody(String p2, String p3)
    {
        int count=1;
        String[] items= p3.split(",");
        LinkedHashSet<String> itemsset= new LinkedHashSet<>();
        for (String string : items) {
            itemsset.add(string);
        }
        //traverse the rule map

        for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Body.entrySet()) {
            LinkedHashSet<String> n1= new LinkedHashSet<>();
            n1=(LinkedHashSet<String>) ent.getKey().clone();

            n1.retainAll(itemsset);

            if(p2.equals("ANY"))
            {
                if(n1.size()>=1)
                {
                    LinkedHashSet<String> n2= new LinkedHashSet<>();
                    n2=ent.getValue();
                    //System.out.println("RULE     :");
                    for (String string : n2) {
                        System.out.println(count+++"    "+string);
                    }

                }
            }
            else if(p2.equals("NONE"))
            {
                if(n1.size()==0)
                {
                    LinkedHashSet<String> n2= new LinkedHashSet<>();
                    n2=ent.getValue();
                    //	System.out.println("RULE     :");
                    for (String string : n2) {
                        System.out.println(count+++"    "+string);
                    }

                }
            }
            else
            {
                if(n1.size()==Integer.parseInt(p2))
                {
                    LinkedHashSet<String> n2= new LinkedHashSet<>();
                    n2=ent.getValue();
                    //System.out.println("RULE     :");
                    for (String string : n2) {
                        System.out.println(count+++"    "+string);
                    }

                }
            }




        }



    }


    private static void Template2(String p1,String p2)
    {
        int cnt=1;
        int size= Integer.parseInt(p2);
        if(p1.equals("RULE"))
        {
            for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Rule.entrySet()) {
                if(ent.getKey().size()>=size)
                {
                    for (String string : ent.getValue()) {
                        System.out.println(cnt+++"	"+string);
                    }
                }

            }
        }
        else if(p1.equals("BODY"))
        {
            for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Body.entrySet()) {
                if(ent.getKey().size()>=size)
                {
                    for (String string : ent.getValue()) {
                        System.out.println(cnt+++"	"+string);
                    }
                }

            }
        }
        else if(p1.equals("HEAD"))
        {
            for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Head.entrySet()) {
                if(ent.getKey().size()>=size)
                {
                    for (String string : ent.getValue()) {
                        System.out.println(cnt+++"	"+string);
                    }
                }

            }
        }
    }

    private static void Template3(String p1, String p2, String p3,String p4, String p5)
    {
        LinkedHashSet<String> P2itemsset= new LinkedHashSet<>();
        for (String string : p2.split(",")) {
            P2itemsset.add(string);
        }
        LinkedHashSet<String> P5itemsset= new LinkedHashSet<>();
        for (String string : p5.split(",")) {
            P5itemsset.add(string);
        }
        if(p3.equals("AND"))
        {
            LinkedHashSet<String> finalHead= new LinkedHashSet<>();
            LinkedHashSet<String> finalBody= new LinkedHashSet<>();



            if((!p1.equals("NONE")) && p4.equals("NONE"))
            {
                for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Head.entrySet()) {
                    LinkedHashSet<String> n1= new LinkedHashSet<>();
                    n1=(LinkedHashSet<String>) ent.getKey().clone();

                    n1.retainAll(P2itemsset);
                    if(n1.size()==Integer.parseInt(p1))
                    {
                        LinkedHashSet<String> n2= new LinkedHashSet<>();
                        n2=ent.getValue();
                        //System.out.println("RULE     :");
                        for (String string : n2) {
                            //System.out.println(string);
                            finalHead.add(string);
                        }

                    }

                }

                for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Body.entrySet()) {
                    LinkedHashSet<String> n1= new LinkedHashSet<>();
                    n1=(LinkedHashSet<String>) ent.getKey().clone();

                    n1.retainAll(P5itemsset);
                    if(n1.size()==0)
                    {
                        LinkedHashSet<String> n2= new LinkedHashSet<>();
                        n2=ent.getValue();
                        //System.out.println("RULE     :");
                        for (String string : n2) {
                            //System.out.println(string);
                            finalBody.add(string);
                        }

                    }

                }

                finalHead.retainAll(finalBody);
                int cnt=1;
                for (String string : finalHead) {
                    System.out.println(cnt+++"	"+string);
                }



            }
            else if(p1.equals("NONE") && (!p4.equals("NONE")))
            {
                for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Head.entrySet()) {
                    LinkedHashSet<String> n1= new LinkedHashSet<>();
                    n1=(LinkedHashSet<String>) ent.getKey().clone();

                    n1.retainAll(P2itemsset);
                    if(n1.size()==0)
                    {
                        LinkedHashSet<String> n2= new LinkedHashSet<>();
                        n2=ent.getValue();
                        //System.out.println("RULE     :");
                        for (String string : n2) {
                            //System.out.println(string);
                            finalHead.add(string);
                        }

                    }

                }

                for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Body.entrySet()) {
                    LinkedHashSet<String> n1= new LinkedHashSet<>();
                    n1=(LinkedHashSet<String>) ent.getKey().clone();

                    n1.retainAll(P5itemsset);
                    if(n1.size()==Integer.parseInt(p4))
                    {
                        LinkedHashSet<String> n2= new LinkedHashSet<>();
                        n2=ent.getValue();
                        //System.out.println("RULE     :");
                        for (String string : n2) {
                            //System.out.println(string);
                            finalBody.add(string);
                        }

                    }

                }

                finalHead.retainAll(finalBody);
                int cnt=1;
                for (String string : finalHead) {
                    System.out.println(cnt+++"	"+string);
                }

            }
            else if(p1.equals("NONE") && p4.equals("NONE"))
            {
                int cnt=1;
                for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Rule.entrySet()) {
                    LinkedHashSet<String> n1= new LinkedHashSet<>();
                    n1=(LinkedHashSet<String>) ent.getKey().clone();
                    P2itemsset.addAll(P5itemsset);
                    n1.retainAll(P2itemsset);
                    //n1.retainAll(P5itemsset);
                    if(n1.size()==0)
                    {
                        LinkedHashSet<String> n2= new LinkedHashSet<>();
                        n2=ent.getValue();
                        System.out.println("RULE     :");
                        for (String string : n2) {
                            System.out.println(cnt+++"	"+string);
                        }

                    }

                }
            }
            else if((!p1.equals("NONE")) && (!p4.equals("NONE")))
            {
                for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Head.entrySet()) {
                    LinkedHashSet<String> n1= new LinkedHashSet<>();
                    n1=(LinkedHashSet<String>) ent.getKey().clone();

                    n1.retainAll(P2itemsset);
                    if(n1.size()==Integer.parseInt(p1))
                    {
                        LinkedHashSet<String> n2= new LinkedHashSet<>();
                        n2=ent.getValue();
                        //System.out.println("RULE     :");
                        for (String string : n2) {
                            //System.out.println(string);
                            finalHead.add(string);
                        }

                    }

                }

                for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Body.entrySet()) {
                    LinkedHashSet<String> n1= new LinkedHashSet<>();
                    n1=(LinkedHashSet<String>) ent.getKey().clone();

                    n1.retainAll(P5itemsset);
                    if(n1.size()==Integer.parseInt(p4))
                    {
                        LinkedHashSet<String> n2= new LinkedHashSet<>();
                        n2=ent.getValue();
                        //System.out.println("RULE     :");
                        for (String string : n2) {
                            //System.out.println(string);
                            finalBody.add(string);
                        }

                    }

                }

                finalHead.retainAll(finalBody);
                int cnt=1;
                for (String string : finalHead) {
                    System.out.println(cnt+++"	"+string);
                }



            }

        }
        else if(p3.equals("OR"))
        {
            LinkedHashSet<String> finalRules= new LinkedHashSet<>();

            if((!p1.equals("NONE")) && p4.equals("NONE"))
            {
                for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Head.entrySet()) {
                    LinkedHashSet<String> n1= new LinkedHashSet<>();
                    n1=(LinkedHashSet<String>) ent.getKey().clone();

                    n1.retainAll(P2itemsset);
                    if(n1.size()==Integer.parseInt(p1))
                    {
                        LinkedHashSet<String> n2= new LinkedHashSet<>();
                        n2=ent.getValue();
                        //System.out.println("RULE     :");
                        for (String string : n2) {
                            //System.out.println(string);
                            finalRules.add(string);
                        }

                    }

                }

                for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Body.entrySet()) {
                    LinkedHashSet<String> n1= new LinkedHashSet<>();
                    n1=(LinkedHashSet<String>) ent.getKey().clone();

                    n1.retainAll(P5itemsset);
                    if(n1.size()==0)
                    {
                        LinkedHashSet<String> n2= new LinkedHashSet<>();
                        n2=ent.getValue();
                        //System.out.println("RULE     :");
                        for (String string : n2) {
                            //System.out.println(string);
                            finalRules.add(string);
                        }

                    }

                }
            }
            else if(p1.equals("NONE") && (!p4.equals("NONE")))
            {
                for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Head.entrySet()) {
                    LinkedHashSet<String> n1= new LinkedHashSet<>();
                    n1=(LinkedHashSet<String>) ent.getKey().clone();

                    n1.retainAll(P2itemsset);
                    if(n1.size()==0)
                    {
                        LinkedHashSet<String> n2= new LinkedHashSet<>();
                        n2=ent.getValue();
                        //System.out.println("RULE     :");
                        for (String string : n2) {
                            //System.out.println(string);
                            finalRules.add(string);
                        }

                    }

                }

                for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Body.entrySet()) {
                    LinkedHashSet<String> n1= new LinkedHashSet<>();
                    n1=(LinkedHashSet<String>) ent.getKey().clone();

                    n1.retainAll(P5itemsset);
                    if(n1.size()==Integer.parseInt(p4))
                    {
                        LinkedHashSet<String> n2= new LinkedHashSet<>();
                        n2=ent.getValue();
                        //System.out.println("RULE     :");
                        for (String string : n2) {
                            //System.out.println(string);
                            finalRules.add(string);
                        }

                    }

                }
            }
            else if(p1.equals("NONE") && p4.equals("NONE"))
            {
                for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Head.entrySet()) {
                    LinkedHashSet<String> n1= new LinkedHashSet<>();
                    n1=(LinkedHashSet<String>) ent.getKey().clone();

                    n1.retainAll(P2itemsset);
                    if(n1.size()==0)
                    {
                        LinkedHashSet<String> n2= new LinkedHashSet<>();
                        n2=ent.getValue();
                        //	System.out.println("RULE     :");
                        for (String string : n2) {
                            //System.out.println(string);
                            finalRules.add(string);
                        }

                    }

                }

                for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Body.entrySet()) {
                    LinkedHashSet<String> n1= new LinkedHashSet<>();
                    n1=(LinkedHashSet<String>) ent.getKey().clone();

                    n1.retainAll(P5itemsset);
                    if(n1.size()==0)
                    {
                        LinkedHashSet<String> n2= new LinkedHashSet<>();
                        n2=ent.getValue();
                        //System.out.println("RULE     :");
                        for (String string : n2) {
                            //System.out.println(string);
                            finalRules.add(string);
                        }

                    }

                }
            }
            else if((!p1.equals("NONE")) && (!p4.equals("NONE")))
            {
                for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Head.entrySet()) {
                    LinkedHashSet<String> n1= new LinkedHashSet<>();
                    n1=(LinkedHashSet<String>) ent.getKey().clone();

                    n1.retainAll(P2itemsset);
                    if(n1.size()==Integer.parseInt(p1))
                    {
                        LinkedHashSet<String> n2= new LinkedHashSet<>();
                        n2=ent.getValue();
                        //System.out.println("RULE     :");
                        for (String string : n2) {
                            //System.out.println(string);
                            finalRules.add(string);
                        }

                    }

                }

                for (Entry<LinkedHashSet<String>,LinkedHashSet<String>> ent:Body.entrySet()) {
                    LinkedHashSet<String> n1= new LinkedHashSet<>();
                    n1=(LinkedHashSet<String>) ent.getKey().clone();

                    n1.retainAll(P5itemsset);
                    if(n1.size()==Integer.parseInt(p4))
                    {
                        LinkedHashSet<String> n2= new LinkedHashSet<>();
                        n2=ent.getValue();
                        //System.out.println("RULE     :");
                        for (String string : n2) {
                            //System.out.println(string);
                            finalRules.add(string);
                        }

                    }

                }
            }

            int cnt=1;
            for (String string : finalRules) {
                System.out.println(cnt+++"	"+string);
            }

        }
    }

    private static void readConfig() throws Exception
    {
        String proceed=null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            File configFile = new File("config.properties.txt");
            if (configFile.exists()) {
                System.out.println("Exists");
            } else {
                System.out.println("Doesn't Exist");
            }
            try {
                FileReader reader = new FileReader(configFile);
                Properties props = new Properties();
                props.load(reader);

                if(SUPPORT!=Integer.parseInt(props.getProperty("Support")))
                {
                    testfrequentSet1.clear();
                    testfrequentSet2.clear();
                    testAllfrequentSet.clear();
                    frequentSetForAsso.clear();
                    Head.clear();
                    Body.clear();
                    Rule.clear();
                    SUPPORT= Integer.parseInt(props.getProperty("Support"));
                    CONFIDENCE=Float.parseFloat(props.getProperty("Confidence"));
                    System.out.println("Support >= "+SUPPORT);

                    iteration_1();
                    AllIterations();
                    System.out.println();
                    System.out.println("Confidence >= "+CONFIDENCE);
                    System.out.println();
                    GenRule();

                }
                else if(CONFIDENCE!=Float.parseFloat(props.getProperty("Confidence")))
                {
                    Head.clear();
                    Body.clear();
                    Rule.clear();
                    CONFIDENCE=Float.parseFloat(props.getProperty("Confidence"));
                    System.out.println();
                    System.out.println("Confidence >= "+CONFIDENCE);
                    System.out.println();
                    GenRule();
                }
                //SUPPORT= Integer.parseInt(props.getProperty("Support"));

                String Template1 = props.getProperty("Template1");
                if(Template1 .equalsIgnoreCase("Yes"))
                {
                    String T1Part1 = props.getProperty("T1Part1");
                    String T1Part2 = props.getProperty("T1Part2");
                    String T1Part3 = props.getProperty("T1Part3");
                    System.out.println();
                    System.out.println("Template1 is    : " + T1Part1+" HAS "+T1Part2+" OF ("+T1Part3+")" );
                    System.out.println();
                    //System.out.println("T1Part1 name is: " + T1Part1 );
                    //System.out.println("T1Part2 name is: " + T1Part2 );
                    //System.out.println("T1Part3 name is: " + T1Part3 );
                    Template1(T1Part1, T1Part2, T1Part3);

                }

                String Template2 = props.getProperty("Template2");
                if(Template1 .equalsIgnoreCase("Yes"))
                {
                    String T2Part1 = props.getProperty("T2Part1");
                    String T2Part2 = props.getProperty("T2Part2");
                    System.out.println();
                    System.out.println("Template2 is    : SizeOf("+T2Part1+")>="+T2Part2);
                    System.out.println();
                    //System.out.println("T1Part1 name is: " + T2Part1 );
                    //System.out.println("T1Part2 name is: " + T2Part2 );
                    Template2(T2Part1, T2Part2);

                }

                String Template3 = props.getProperty("Template3");
                if(Template3.equalsIgnoreCase("Yes"))
                {
                    String p1 = props.getProperty("p1");
                    String p2 = props.getProperty("p2");
                    String p3 = props.getProperty("p3");
                    String p4 = props.getProperty("p4");
                    String p5 = props.getProperty("p5");
                    System.out.println();
                    System.out.println("Template3 is    : HEAD HAS ("+p1+") OF("+p2+") "+p3+" BODY HAS ("+p4+") OF ("+p5+")");
                    System.out.println();
                    //				System.out.println("p1 name is: " + p1 );
//					System.out.println("p1 name is: " + p2 );
//					System.out.println("p1 name is: " + p3 );
//					System.out.println("p1 name is: " + p4 );
//					System.out.println("p1 name is: " + p5 );
                    //Template2(T2Part1, T2Part2);
                    Template3(p1, p2, p3, p4, p5);
                }



                reader.close();
                System.out.println("Do you want to continue(Y:N)  ");
                System.out.print("Please change the config file before pressing Y  :");
                proceed= br.readLine();
            } catch (FileNotFoundException ex) {
                // file does not exist
            } catch (IOException ex) {
                // I/O error
            }

        } while (proceed.equalsIgnoreCase("y"));


    }

}



