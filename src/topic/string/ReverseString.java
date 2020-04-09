======================================================Reverse the String
Given a string A. Return the string A after reversing the string word by word. NOTE:
A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed strin==================================================
public class Solution {
    public String solve(String A) {
        int n = A.length();
        if(n == 1){
            return A;
        }
       ArrayList<String> a  = new ArrayList<>();
       int idx = 0;
       for(int i =0; i<n;i++){
           StringBuilder s = new StringBuilder();
           while(i < n && A.charAt(i) == ' '){
               i++;
           }
           while(i < n && A.charAt(i) != ' '){
               s.append(A.charAt(i));
               i++;
           }
           a.add(s.toString());
           idx++;
       }
       StringBuilder sr = new StringBuilder();
       for(int i = idx-1; i>= 0; i--){
           sr.append(a.get(i));
           if(i != 0){
               sr.append(' ');
           }
       }
       
        return sr.toString();
    }
}
