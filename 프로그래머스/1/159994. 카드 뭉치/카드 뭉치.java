class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int size = goal.length;
        int card1Index = 0;
        int card2Index = 0;
        for (int i = 0; i < size; i++) {
            String target = goal[i];
            if (card1Index < cards1.length && target.equals(cards1[card1Index])) {
                card1Index++;
            } else if (card2Index < cards2.length && target.equals(cards2[card2Index])) {
                card2Index++;
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}