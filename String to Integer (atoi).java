public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sign=1;
        boolean startCounting=false;
        double sum=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                if(startCounting){
                    break;
                }
            }
            else if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                startCounting=true;
                sum=sum*10+str.charAt(i)-'0';
            }
            else if(str.charAt(i)=='-'){
                if(startCounting){
                    break;
                }
                else{
                    sign=-1;
                    startCounting=true;
                }
            }
            else if(str.charAt(i)=='+'){
                if(startCounting){
                    break;
                }
                else{
                    startCounting=true;
                }
            }
            else{
                break;
            }
        }
        if(sum*sign>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else if(sum*sign<=Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)sum*sign;
    }
}