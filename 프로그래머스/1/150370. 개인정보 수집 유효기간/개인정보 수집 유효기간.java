import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        final int termsSize = terms.length;
        final int privaciesSize = privacies.length;
        
        String[] todaySplit = today.split("\\.");
        int todayYear = Integer.parseInt(todaySplit[0]);
        int todayMonth = Integer.parseInt(todaySplit[1]);
        int todayDay = Integer.parseInt(todaySplit[2]);
        
        Map<String, Integer> termMap = new HashMap<>();
        for(int i = 0; i < termsSize; i++) {
            String[] temp = terms[i].split(" ");
            termMap.put(temp[0], Integer.parseInt(temp[1]));
        }
        
        ArrayList<Integer> ansList = new ArrayList<>();
        int idx = 1;
        for(int i = 0; i < privaciesSize; i++) {
            String[] temp = privacies[i].split(" ");
            String[] date = temp[0].split("\\.");
            Integer tempMonth = Integer.parseInt(date[1]) + termMap.get(temp[1]);
            Integer tempYear = Integer.parseInt(date[0]);
            Integer tempDay = Integer.parseInt(date[2]);
            if(tempMonth > 12) {
                if(tempMonth % 12 == 0) {
                    tempYear += (tempMonth / 12) - 1;
                    tempMonth = 12;
                } else {
                    tempYear += tempMonth / 12;
                    tempMonth = tempMonth % 12;
                }
            }
            if(tempDay == 1) {
                if(tempMonth == 1) {
                    tempYear -= 1;
                    tempMonth = 12;
                    tempDay = 28;
                } else {
                    tempMonth -= 1;
                    tempDay = 28;
                }
            } else {
                tempDay -= 1;
            }
            if(todayYear > tempYear) {
                ansList.add(idx);
            } else if (todayYear == tempYear) {
                if(todayMonth > tempMonth) {
                    ansList.add(idx);
                } else if (todayMonth == tempMonth) {
                    if(todayDay > tempDay) {
                        ansList.add(idx);
                    }
                }
            }
            idx++;
        }
        int resIdx = 0;
        int[] res = new int[ansList.size()];
        for(int i : ansList) {
            res[resIdx] = i;
            resIdx++;
        }
        return res;
    }
}