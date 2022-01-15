import java.util.*;

public class 베스트앨범 {
    public static void main(String[] args) {

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        String result = 베스트앨범.solution(genres, plays);
        System.out.println(result);
    }

    static String solution(String[] genres, int[] plays) {

        HashMap<String, Integer> all = new HashMap<>(); // 장르 : 총재생
        HashMap<String, ArrayList<Music>> seperate = new HashMap<>(); // 장르 : [ (인덱스 : 재생수), ... ]

        for (int i = 0; i < genres.length; i++) {

            if (all.containsKey(genres[i])){
                all.put(genres[i], all.get(genres[i]) + plays[i]);
            } else {
                all.put(genres[i], plays[i]);
            }

            if(seperate.containsKey(genres[i])){
                ArrayList<Music> musicList = seperate.get(genres[i]);
                musicList.add(new Music(i, plays[i]));
                seperate.put(genres[i], musicList);

            }else{
                ArrayList<Music> musicList = new ArrayList<>();
                musicList.add(new Music(i, plays[i]));
                seperate.put(genres[i], musicList);
            }
        }
        // 로그 찍어보기
        all.forEach((k, v) -> System.out.println(k + " " + v));
        seperate.forEach((k, v) -> System.out.println(k + " " + v));



        // value 기준으로 정렬하기


        return "";
    }

    static class Music{

        private int idx;
        private int num;

        Music(int idx, int num){
            this.idx = idx;
            this.num = num;
        }

    }


    }
