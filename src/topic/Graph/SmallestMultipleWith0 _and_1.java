/*=============================================Smallest Multiple With 0 and 1
You are given an integer N. You have to find smallest multiple of N which consists of digits 0 and 1 only. Since this multiple could be large, 
return it in form of a string=======================================================================*/
public class Solution {
    int mod(String t,int n){
        int r =0;
        for(int i =0; i<t.length(); i++){
            r = r*10 + (t.charAt(i) - '0');
            r = r%n;
        }
        return r;
    }
    public String multiple(int A) {
        LinkedList<String> q = new LinkedList<>();
        HashSet<Integer> visit = new HashSet<>();
        String t = "1";
        q.add(t);
        while(!q.isEmpty()){
            t = q.poll();
            int rem = mod(t,A);
            if(rem ==0){
                return t;
                
            }else if(!visit.contains(rem)){
                visit.add(rem);
                q.add(t +"0");
                q.add(t +"1");
            }
            
        }
        return "0";
    }
}
