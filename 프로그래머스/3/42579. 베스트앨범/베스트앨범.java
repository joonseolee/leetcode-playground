import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public class Music {
        Integer id; 
        Integer count;
        
        public Music(Integer id, Integer count) {
            this.id = id;
            this.count = count;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Music>> map = new TreeMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int finalI = i;
            map.compute(genre, (k, v) -> {
                Music newMusic = new Music(finalI, plays[finalI]);
                if (v == null) {
                    v = new ArrayList<>();
                }

                v.add(newMusic);
                return v;
            });
        }



        return map.entrySet().stream()
                .sorted((o1, o2) -> {
                    int o1Sum = o1.getValue().stream().mapToInt(v -> v.count).sum();
                    int o2Sum = o2.getValue().stream().mapToInt(v -> v.count).sum();
                    return Integer.compare(o2Sum, o1Sum);})
                .flatMap(entry -> {
                    if (entry.getValue().size() == 1) {
                        return entry.getValue().subList(0, 1).stream();
                    }

                    return entry.getValue().stream()
                            .sorted((o1, o2) -> {
                                if (!Objects.equals(o1.count, o2.count)) {
                                    return Integer.compare(o2.count, o1.count);
                                }

                                return Integer.compare(o1.id, o2.id);
                            })
                            .limit(2);
                })
                .mapToInt(it -> it.id)
                .toArray();
    }
}