import java.lang.reflect.Array;
import java.util.*;

public class 베스트앨범 {
    public static void main(String[] args) {

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = 베스트앨범.solution(genres, plays);

    }

    static int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> all = new HashMap<>(); // 장르 : 총재생
        HashMap<String, ArrayList<Music>> seperate = new HashMap<>(); // 장르 : [ (인덱스 : 재생수), ... ]

        for (int i = 0; i < genres.length; i++) {
            if (all.containsKey(genres[i])){
                all.put(genres[i], all.get(genres[i]) + plays[i]);
            } else {
                all.put(genres[i], plays[i]);
            }

            ArrayList<Music> musicList;
            if(seperate.containsKey(genres[i])){
                musicList = seperate.get(genres[i]);
            }else{
                musicList = new ArrayList<>();
            }
            musicList.add(new Music(i, plays[i]));
            seperate.put(genres[i], musicList);
        }

        // entrySet을 value 기준으로 정렬
        List<Map.Entry<String, Integer>> list = new ArrayList<>(all.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        ArrayList<Integer> arr = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : list){
            String key = entry.getKey();

            ArrayList<Music> musicList = seperate.get(key);
            Collections.sort(musicList);
            int count = 0;
            for(Music music : musicList){
                if(count >= 2)
                    break;
                // System.out.println(key + " " + music.getIdx() + " " + music.getNum());
                arr.add(music.getIdx());

                count ++;
            }
        }

        // System.out.println(arr.toString());
        int[] result = new int[arr.size()];

        for(int i=0;i<arr.size();i++)
            result[i] = arr.get(i);

        return result;

//        for(Map.Entry<String, Integer> entry : all.entrySet()){
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
//
//        for(Map.Entry<String, ArrayList<Music>> entry : seperate.entrySet()){
//            System.out.println(entry.getKey());
//            for(Music music : entry.getValue()){
//                System.out.println(music.getIdx() + " " + music.getNum());
//            }
//        }
    }
}

class Music implements Comparable<Music>{

    private int idx;
    private int num;

    Music(int idx, int num){
        this.idx = idx;
        this.num = num;
    }

    public int getIdx(){
        return idx;
    }
    public int getNum(){
        return num;
    }

    @Override
    public int compareTo(Music m) {

        if(this.num > m.getNum()){
            return -1; // 내림차순
        }else if(this.num == m.getNum()){
            return 0;
        }else{
            return 1;
        }
    }
}
