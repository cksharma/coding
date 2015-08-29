/**
 * Created by cksharma on 8/20/15.
 */
public class Test {
    public static void main(String[] args) {
        String s = "abbcbda,cbdaaa,b,dadaaad,dccbbbc,dccadd,ccbdbc,bbca,bacbcdd,a,bacb,cbc,adc,c,cbdbcad,cdbab,db,abbcdbd,bcb,bbdab,aa,bcadb,bacbcb,ca,dbdabdb,ccd,acbb,bdc,acbccd,d,cccdcda,dcbd,cbccacd,ac,cca,aaddc,dccac,ccdc,bbbbcda,ba,adbcadb,dca,abd,bdbb,ddadbad,badb,ab,aaaaa,acba,abbb";
        String[] arr = s.split(",");
        int cnt = 0;
        for (String item : arr) {
            System.out.print("dict.add(\"" + item + "\");");
            if (++cnt % 5 == 0) System.out.println();
        }

        String r = "HelloWorld";


    }
}
