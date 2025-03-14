import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Report> map = new HashMap<>();
        // init
        for (String id : id_list) {
            map.put(id, new Report());
        }

        for (String text : report) {
            String[] words = text.split(" ");
            map.computeIfPresent(words[0], (key, v) -> {
                v.reportingUsers.add(words[1]);
                return v;
            });
            map.computeIfPresent(words[1], (key, v) -> {
                v.reportedUsers.add(words[0]);
                return v;
            });
        }

        return Arrays.stream(id_list)
                .mapToInt(it -> {
                    Report document = map.get(it);
                    return document.reportingUsers.stream()
                            .filter(user -> map.get(user).reportedUsers.size() >= k)
                            .mapToInt(user -> 1)
                            .sum();
                })
                .toArray();
    }
    
    public static class Report {
        Set<String> reportingUsers;
        Set<String> reportedUsers;
        
        public Report() {
            this.reportingUsers = new HashSet<>();
            this.reportedUsers = new HashSet<>();
        }
    }
}