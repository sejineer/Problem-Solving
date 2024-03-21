import java.util.*;

class Solution {
    static Character[] index = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
    public String solution(String[] survey, int[] choices) {
        final int surveySize = survey.length;
        
        Map<Character, Integer> surveyMap = new HashMap<>();
        for(int i = 0; i < 8; i++) {
            surveyMap.put(index[i], 0);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < surveySize; i++) {
            int choice = choices[i];
            if(choice < 4) {
                int point = 4 - choice;
                surveyMap.replace(survey[i].charAt(0), surveyMap.get(survey[i].charAt(0)) + point);
            } else if (choice > 4) {
                int point = choice - 4;
                surveyMap.replace(survey[i].charAt(1), surveyMap.get(survey[i].charAt(1)) + point);
            }
        }
        if(surveyMap.get('R') > surveyMap.get('T')) {
            sb.append('R');
        } else if (surveyMap.get('R') < surveyMap.get('T')) {
            sb.append('T');
        } else {
            sb.append('R');
        }
        if(surveyMap.get('C') > surveyMap.get('F')) {
            sb.append('C');
        } else if (surveyMap.get('C') < surveyMap.get('F')) {
            sb.append('F');
        } else {
            sb.append('C');
        }
        if(surveyMap.get('J') > surveyMap.get('M')) {
            sb.append('J');
        } else if (surveyMap.get('J') < surveyMap.get('M')) {
            sb.append('M');
        } else {
            sb.append('J');
        }
        if(surveyMap.get('A') > surveyMap.get('N')) {
            sb.append('A');
        } else if (surveyMap.get('A') < surveyMap.get('N')) {
            sb.append('N');
        } else {
            sb.append('A');
        }
        return sb.toString();
    }
}