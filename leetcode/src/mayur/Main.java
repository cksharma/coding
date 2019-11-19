package mayur;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        List<String> lines = Files.readAllLines(Paths.get("fix_to_csv_records.csv"));
        int ans = 0;
        int cells = 1;
        for (int i = 0; i < lines.get(0).length(); ++i) {
            if (lines.get(0).charAt(0) == ',') ++cells;
        }

        List<String> result = new ArrayList<>();
        for (String line : lines) {
            StringBuilder sb = new StringBuilder();
            int index = 0;
            while (index >= 0) {
                int curIndex = index;
                index = line.indexOf(',', curIndex);
                if (index >= 0) { sb.append(line.substring(curIndex, index)).append("\t"); index++; }
            }
            result.add(sb.toString());
        }
        //for (int i = 0; i < 1; ++i) {
            FileWriter writer = new FileWriter("output.xlsx");
            for (String res : result) {
                writer.write(res + "\n");
            }
            writer.close();
        //}
        long end = System.currentTimeMillis();
        System.out.println(((end - start) / 1000.0) + " seconds");
    }
}


