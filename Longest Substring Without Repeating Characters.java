public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean tailMove=true;
        HashMap<Character, Integer> map;
        int head=0,tail=0;
        int length=0;
        if(s==null || s.length()==0){
            return length;
        }
        if(s.length()>0){
            length=1;
			map.put(s.charAt(0),1);
        }
        while(1){
            if(tail==s.length()-1 && tailMove){
                break;
            }
            if(!tailMove){
                Integer num=map.get(s.charAt(head));
                map.put(s.charAt(head),num-1);
                if(num==2){
                    tailMove=true;
                    length=(tail-head)>length?(tail-head):length;
                }
                head++;
            }
            else{
                Integer num=map.get(s.charAt(++tail));
                if(num==null || num==0){
                    map.put(s.charAt(tail),1);
                }
                else
                    map.put(s.charAt(tail),num+1);
                if(num!=null && num!=0){
                    tailMove=false;
                }
                else{
                     length=(tail-head+1)>length?(tail-head+1):length;
                }
            }
        }
        
    }
}