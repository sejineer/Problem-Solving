import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        final int bandTime = bandage[0];
        final int heal = bandage[1];
        final int bonusHeal = bandage[2];
        final int maxHealth = health;
        
        Map<Integer, Integer> attackTimes = new HashMap<>();
        int maxTime = 0;
        for(int[] i : attacks) {
            attackTimes.put(i[0], i[1]);
            maxTime = Math.max(maxTime, i[0]);
        }
        
        int stack = 0;
        for(int i = 1; i <= maxTime; i++) {
            if(attackTimes.containsKey(i)) {
                stack = 0;
                health -= attackTimes.get(i);
                if(health <= 0) return -1;
            } else {
                stack++;
                health += heal;
                if(stack == bandTime) {
                    health += bonusHeal;
                    stack = 0;
                }
                if(health > maxHealth) {
                    health = maxHealth;
                }
            }
        }
        return health;
    }
}