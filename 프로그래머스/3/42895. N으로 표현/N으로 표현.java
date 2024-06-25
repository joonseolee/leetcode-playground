import java.util.*;

class Solution {
    public int solution(int N, int number) {
        return doSomething(N, number);
    }
    
    public int doSomething(int N, int number) {
        if (N == number) return 1;
        
        // DP 배열 생성
        List<Set<Integer>> dp = new ArrayList<>();
        
        // N을 i번 사용해서 만들 수 있는 모든 숫자를 dp에 저장
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }
        
        // N을 i번 사용해서 만들 수 있는 숫자들
        dp.get(1).add(N);
        
        // N을 1~8번 사용하여 만들 수 있는 숫자들 계산
        for (int i = 2; i < 9; i++) {
            Set<Integer> currentSet = dp.get(i);
            
            // N을 i번 이어붙인 숫자 추가 (예: 55, 555, ...)
            currentSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            for (int j = 1; j < i; j++) {
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i - j);
                
                for (int num1 : set1) {
                    for (int num2 : set2) {
                        currentSet.add(num1 + num2);
                        currentSet.add(num1 - num2);
                        currentSet.add(num1 * num2);
                        if (num2 != 0) {
                            currentSet.add(num1 / num2);
                        }
                    }
                }
            }
            
            // 목표 숫자 확인
            if (currentSet.contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}