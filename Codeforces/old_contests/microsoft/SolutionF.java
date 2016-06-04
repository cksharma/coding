package microsoft;

import java.io.*;
import java.util.*;

public class SolutionF {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solver = new Solution();
        solver.solve(1, in, out);
        out.close();
    }

    static class Solution {
        class Problem implements Comparable <Problem> {
            int id;
            int score;
            int time;

            Problem(int id, int score, int time) {
                this.id = id;
                this.score = score;
                this.time = time;
            }

            @Override
            public int compareTo(Problem o) {
                double avgTimePerScoreMy = 1. * time / score;
                double avgTimePerScoreHis = 1. * o.time / o.score;
                if (avgTimePerScoreMy < avgTimePerScoreHis)
                    return -1;
                else if (avgTimePerScoreMy > avgTimePerScoreHis)
                    return 1;
                else if ( time < o.time) return -1;
                else if (time > o.time) return 1;
                return 0;
            }

            @Override
            public String toString() {
                return "Problem{" +
                        "id=" + id +
                        ", score=" + score +
                        ", time=" + time +
                        '}';
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int totalTime = in.nextInt();
            String str;
            List<Problem> list = new ArrayList<>();
            while ((str = in.nextLine()) != null) {
                if (str.trim().length() == 0) break;
                String[] arr = str.split(",");
                int id = Integer.parseInt(arr[0]);
                int score = Integer.parseInt(arr[1]);
                int time = Integer.parseInt(arr[2]);
                Problem problem = new Problem(id, score, time);
                list.add(problem);
            }
            int myScore = 0;
            int remTime = totalTime;
            int partialId = -1;

            Collections.sort(list);
            List<Problem> myList = new ArrayList<>();

            for (Problem problem : list) {
                if (remTime <= 0) break;
                if (problem.time <= remTime) {
                    remTime -= problem.time;
                    myScore += problem.score;
                    myList.add(problem);
                } else {

                    myScore += Math.floor(1. * problem.score / problem.time * remTime);
                    partialId = problem.id;
                    myList.add(problem);
                    remTime = -1;
                }
            }
            System.out.println(myScore);
            Collections.sort(myList, new Comparator<Problem>() {
                @Override
                public int compare(Problem o1, Problem o2) {
                    if (o1.id < o2.id) return -1;
                    else if (o1.id > o2.id) return 1;
                    return 0;
                }
            });
            String ss = "";
            for (Problem problem : myList) {
                if (problem.id == partialId) {
                    ss += (problem.id + "*" + ",");
                } else {
                    ss += problem.id +",";
                }
            }
            if (ss.length() > 0) {
                ss = ss.substring(0, ss.length() - 1);
            }
            System.out.println(ss);
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String nextLine() {
            String inputLine = "";
            try {
                inputLine = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return inputLine;
        }
    }
}
