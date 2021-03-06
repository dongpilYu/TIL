/*
    프로그래머스 레벌3 > 해시 > 베스트 앨범 > LV3
    https://programmers.co.kr/learn/courses/30/lessons/42579
 */
import java.util.*;

public class 프로그래머스_해시_베스트앨범 {
    public static void main(String[] args){
        // String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        // int[] plays = {500, 600, 150, 800, 2500};
        String[] genres = {"classic", "pop", "classic", "classic","jazz","pop", "Rock", "jazz"};
        int[] plays = {500, 600, 150, 800, 1100, 2500, 100, 1000};

        int[] arr = 프로그래머스_해시_베스트앨범.solution(genres, plays);
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
    public static void printMap(HashMap<String, ArrayList<Pair>> hm){
        for(Map.Entry<String, ArrayList<Pair>> entry : hm.entrySet()){
            System.out.println("key: " + entry.getKey());
            for(int i=0;i<entry.getValue().size();i++)
                System.out.println("value: " + entry.getValue().get(i).second());
        }
    }
    public static void printMap2(HashMap<String, ArrayList<Pair>> hm){
        for(Map.Entry<String, ArrayList<Pair>> entry : hm.entrySet()){
            System.out.println("key: " + entry.getKey());
            for(int i=0;i<entry.getValue().size();i++)
                System.out.println("value: " + entry.getValue().get(i).second());
        }
    }
    public static void printList(List<Map.Entry<String, ArrayList<Pair>>> list_entries){
        for(Map.Entry<String, ArrayList<Pair>> entry : list_entries) {
            System.out.println("key: " + entry.getKey());
        }
    }
    public static int[] solution(String[] genres, int[] plays) {
        // array를 list로 변환
        // 1. List<> list = Arrays.stream(array).collect(Collectors.toList());
        // 2. List<> list = Arrays.asList(array)
        // array를 set로 변환
        // 1. Set<> set = Arrays.stream(array).collect(Collectors.toSet());
        // 2. Set<> set = new HashSet<>(Arrays.asList());

        int[] answer = {};
        HashMap<String, ArrayList<Pair>> map1 = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            Pair p = new Pair(plays[i], i); // 재생횟수, 인덱스
            ArrayList<Pair> arr = new ArrayList<>();
            arr.add(p);

            ArrayList arr1;
            if(map1.containsKey(genres[i])){
                arr1 = map1.get(genres[i]);
                arr1.add(p);
                map1.put(genres[i], arr1);
            }else{
                arr1 = new ArrayList<Pair>();
                arr1.add(p);
                map1.put(genres[i], arr1);
            }
        }

        for(Map.Entry<String, ArrayList<Pair>> entry : map1.entrySet()){
            Collections.sort(entry.getValue(), new PairComparator());
            // value에 해당하는 arrayList를 정렬
        }


        List<Map.Entry<String, ArrayList<Pair>>> list_entries = new ArrayList<Map.Entry<String, ArrayList<Pair>>>(map1.entrySet());

        Collections.sort(list_entries, new Comparator<Map.Entry<String, ArrayList<Pair>>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList<Pair>> o1, Map.Entry<String, ArrayList<Pair>> o2) {
                int sum1 = 0, sum2 = 0;
                for(int j=0;j<o1.getValue().size();j++){
                    sum1 += o1.getValue().get(j).first();
                }
                for(int j=0;j<o2.getValue().size();j++){
                    sum2 += o2.getValue().get(j).first();
                }
                if(sum1 < sum2)
                    return 1;
                else if(sum1 > sum2)
                    return -1;
                else
                    return 0;
            }
        });
        // 엔트리 단위로 정렬
        // printList(list_entries);

        ArrayList<Integer> arr = new ArrayList<>();

        for(Map.Entry<String, ArrayList<Pair>> entry : list_entries){
            int count = (entry.getValue().size() > 2 ? 2 : entry.getValue().size());
            for(int j=0;j<count ;j++)
                arr.add(entry.getValue().get(j).second());
        }
        // System.out.println(arr.toString());

        answer = new int[arr.size()];
        int n = 0;
        for(int i : arr)
            answer[n++] = i;
        return answer;
    }
    static class Pair
    {
        Integer x;
        Integer y;
        public Pair(Integer x, Integer y){
            this.x = x;
            this.y = y;
        }
        public Integer first(){
            return x;
        }
        public Integer second(){
            return y;
        }
    }
    static class PairComparator implements Comparator<Pair> {


        public int compare(Pair a, Pair b){
            if(a.first() > b.first())
                return -1;
            else if(a.first() < b.first())
                return 1;
            else
                return 0;
        }
    }
}

