public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder[] strBuilders=new StringBuilder[nRows];
        int lastRow=0;
        boolean up=true;
        for(int i=0;i<s.length();i++){
            if(strBuilders[lastRow]==null){
                strBuilders[lastRow]=new StringBuilder();
            }
            strBuilders[lastRow].append(s.charAt(i));
            if(lastRow>0 && lastRow<nRows-1){
                if(up){
                    lastRow--;
                }
                else{
                    lastRow++;
                }
            }
            else{
                if(lastRow==0){
                    if(nRows==1){
                        lastRow=0;
                    }
                    else{
                        lastRow=1;
                        up=false;
                    }
                }
                else if(lastRow==nRows-1){
                    lastRow--;
                    up=true;
                }
            }
        }
        String res="";
        for(int j=0;j<nRows;j++){
            if(strBuilders[j]!=null)    
                res=res+strBuilders[j].toString();
        }
        return res;
    }
}