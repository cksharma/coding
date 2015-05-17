package codecon.finals.conferenceroomschedular;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solver = new Solution();
        solver.solve(1, in, out);
        out.close();
    }
}

class Solution {
    boolean[][] occupied;

    private List<Integer> getFreeSlots(int timeSlot, int noOfSlot) {
        List<Integer> list = new ArrayList<>();
        for (int roomId = 1; roomId < occupied.length; roomId++) {
            boolean available = true;
            for (int time = timeSlot; time < timeSlot + noOfSlot; time++) {

                if (time >= occupied[0].length || occupied[roomId][time]) {
                    available = false;
                    break;
                }
            }
            if (available) {
                list.add(roomId);
            }
        }
        return list;
    }

    private boolean checkBookingValidity(int roomId, int timeSlot, int noOfSlots) {
        int totalTime = timeSlot + noOfSlots - 1;

        for (int time = timeSlot; time < timeSlot + noOfSlots; time++) {
            if (occupied[roomId][time]) {
                return false;
            }
        }
        return true && totalTime < occupied[0].length;
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int N = in.nextInt();
        occupied = new boolean[N + 1][33];

        String str = null;
        while ((str = in.nextLine()) != null && str.length() > 0) {
            String[] S = str.split("-");
            if (S.length == 3) {
                int roomId = Integer.parseInt(S[0]);
                int timeSlot = Integer.parseInt(S[1]);
                int noOfSlots = Integer.parseInt(S[2]);
                boolean isBookingValid = checkBookingValidity(roomId, timeSlot, noOfSlots);
                if (isBookingValid) {
                    int totalTime = timeSlot + noOfSlots - 1;
                    for (int k = timeSlot; k < timeSlot + noOfSlots && totalTime < occupied[0].length; k++) {
                        occupied[roomId][k] = true;
                    }
                    out.println("Y");
                } else {
                    out.println("N");
                }
            } else {
                int timeSlot = Integer.parseInt(S[0]);
                int noOfSlot = Integer.parseInt(S[1]);
                List<Integer> list = getFreeSlots(timeSlot, noOfSlot);
                if (list.size() == 0) {
                    out.println("None");
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (int item : list) {
                        sb.append(item + " ");
                    }
                    out.println(sb.substring(0, sb.length() - 1));
                }
            }
        }
    }
}

class InputReader {
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

    public String nextLine() {
        String inputLine = "";
        try {
            inputLine = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputLine;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}
