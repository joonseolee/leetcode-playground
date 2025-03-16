import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Staff> map = new HashMap<>();
        map.put("-", new Staff());
        
        for (int i = 0; i < enroll.length; i++) {
            Staff boss = map.get(referral[i]);
            Staff staff = new Staff();
            staff.boss = boss;
            map.put(enroll[i], staff);
        }

        for (int i = 0; i < seller.length; i++) {
            calculate(map.get(seller[i]), amount[i] * 100);
        }

        return Arrays.stream(enroll)
                .mapToInt(name -> map.get(name).income)
                .toArray();
    }

    private void calculate(Staff staff, int amount) {
        if (amount < 10 || staff.boss == null) {
            staff.income += amount;
            return;
        }

        int fee = amount / 10;
        staff.income += amount - fee;
        calculate(staff.boss, fee);
    }
    
    public static class Staff {
        int income;
        Staff boss;
    }
}