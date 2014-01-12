public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int temp=Math.abs(x);
        int sign;
        if(x!=0){
            sign=temp/x;
        }
        else{
            sign=0;
        }
        double res=0;
        while(temp>0){
            res=res*10+temp%10;
            temp=temp/10;
        }
        return (int) res*sign;
        
    }
}