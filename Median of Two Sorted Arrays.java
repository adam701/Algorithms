public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if(A==null){
            return B[B.length/2];
        }
        if(B==null){
            return A[A.length/2];
        }
        if((A.length+B.length)%2>0)
            return findKthNum(A,B,(A.length+B.length)/2+1);
        else{
            return (findKthNum(A,B,(A.length+B.length)/2+1)+findKthNum(A,B,(A.length+B.length)/2))/2.0;
        }    
    }
    
    public int findKthNum(int A[], int B[], int k){
        if(A==null || A.length==0){
            return B[k-1];
        }
        if(B==null || B.length==0){
            return A[k-1];
        }
        if(k==1){
            return A[0]>B[0]?B[0]:A[0];
        }
        if(A.length>B.length){
            return findKthNum(B,A,k);
        }
        int markA,markB;
       
        if(A.length>=k/2){
            markA=k/2;
        }
        else{
            markA=A.length;
        }
        markB=k-markA;
        if(A[markA-1]>B[markB-1]){
            return findKthNum(Arrays.copyOfRange(A,0,markA),Arrays.copyOfRange(B,markB,B.length),k-markB);
        }
        else{
            return findKthNum(Arrays.copyOfRange(A,markA,A.length),Arrays.copyOfRange(B,0,markB),k-markA);
        }
    }
}