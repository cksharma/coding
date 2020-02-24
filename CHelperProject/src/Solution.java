
import java.util.*;

public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, List<String>> hm = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (List<String> l : tickets) {

            String source = l.get(0);
            String destination = l.get(1);

            List<String> destinationList = hm.getOrDefault(source, new ArrayList<String>());
            destinationList.add(destination);
            Collections.sort(destinationList); // lexicographically
            hm.put(source, destinationList);
        }

        doDFS(hm, "JFK", result);
        return result;
    }

    public void doDFS(Map<String, List<String>> hm, String start, List<String> result){

        result.add(start);
        List<String> childrenList = hm.getOrDefault(start, new ArrayList<String>()); // some places not in map as source ex:SJC
        List<String> childrenListCopy = new ArrayList<>(childrenList); // avoid concurrent modification exception

        for(String child : childrenListCopy){
            childrenList.remove(child);
            hm.put(start, childrenList); // updating the removed child in the map
            doDFS(hm, child, result);
        }
    }
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(new ArrayList<>(Arrays.asList("MUC", "LHR")));
        tickets.add(new ArrayList<>(Arrays.asList("JFK", "MUC")));
        tickets.add(new ArrayList<>(Arrays.asList("SFO", "SJC")));
        tickets.add(new ArrayList<>(Arrays.asList("LHR", "SFO")));
        System.out.println(new Solution().findItinerary(tickets));

    }
}