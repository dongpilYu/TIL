import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 완주하지못한선수 {
    public static void main(String[] args){

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        String result = 완주하지못한선수.solution(participant, completion);
        System.out.println(result);

    }
    static String solution(String[] participant, String[] completion){
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for(String player : participant)
            hm.put(player, hm.getOrDefault(player, 0) + 1);

        for(String player : completion){
            if(hm.get(player) == 1)
                hm.remove(player);
            else
                hm.put(player, hm.get(player) - 1);
        }
        answer = hm.keySet().iterator().next();
        // answer = hm.entrySet().iterator().next().getKey();

        return answer;
    }
    static String betterSolution(String[] participant, String[] completion){
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for(String player: participant)
            hm.put(player, hm.getOrDefault(player, 0) + 1);
        for(Map.Entry<String,Integer> entry : hm.entrySet()){
            if(entry.getValue() == 1)
                hm.remove(entry.getKey());
            else
                hm.put(entry.getKey(), entry.getValue() - 1);
        }
        answer = hm.keySet().iterator().next();
        return answer;
    }
}
