==================================================Longest Common Prefix
Given the array of strings A, you need to find the longest string S which is the prefix of ALL the strings in the array. Longest common prefix for a pair of 
strings S1 and S2 is the longest string S which is the prefix of both S1 and S2. For Example, longest common prefix of "abcdefgh" and "abcefgh" is "abc===========
public class Solution {
    public String util(String a, String b){
        String res = "";
        int n1 = a.length(),n2 = b.length();
        for(int i =0, j=0; i < n1 && j<n2; i++,j++){
            if(a.charAt(i) != b.charAt(j))
                break;
            res += a.charAt(i);
        }
        
        return res;
    }
    public String longestCommonPrefix(String[] A) {
        int n = A.length;
        String pref =A[0];
        for(int i =1; i<n; i++){
            pref = util(pref,A[i]);
        }
        return pref;
    }
}
