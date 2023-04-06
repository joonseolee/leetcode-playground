class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Model> queue = new PriorityQueue<>(new Comparator<Model>() {
            @Override
            public int compare(Model o1, Model o2) {
                return Integer.compare(o2.score, o1.score);
            }
        });
        
        for (int i = 0; i < score.length; i++) {
            queue.add(new Model(score[i], i));
        }
        
        String[] results = new String[score.length];
        for (int i = 1; i <= results.length; i++) {
            Model model = queue.poll();
            String message = fetchMessage(i);
            results[model.location] = message;
        }
        
        return results;
    }
    
    private String fetchMessage(int i) {
        if (i == 1) {
            return "Gold Medal";
        } else if (i == 2) {
            return "Silver Medal";
        } else if (i == 3) {
            return "Bronze Medal";
        } else {
            return i + "";
        }
    }
    
    public static class Model {
        int score;
        int location;

        public Model(int score, int location) {
            this.score = score;
            this.location = location;
        }
    }
}