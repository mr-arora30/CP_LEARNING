/*https://leetcode.com/problems/k-th-symbol-in-grammar/*/
public class KthGrammer{
  /* Replace  0 --> 0 1
              1---> 1 0
    0
    0 1
    0 1 1 0
    0 1 1 0 1 0 0 1

     Hypothesis: f(n,k) = 0/1 
                f(n-1,k) = 0/1;

      Base --> n>=1, K>=1          
    Induction: if 
                  k is > mid then call !solve(n-1,k)
                else 
                      call solve(n-1)*/
  public static void main(String args[]){
      System.out.println(kthGrammar(2,2));
  }
   static int kthGrammar(int n, int k) {
        return solve(n,k);
        
    }
    static int solve(int n, int k){
      
        if(n==1 && k==1)  
            return 0;    

        int mid =(int) Math.pow(2,n-1)/2;
        
        if(k<=mid)
            
           return solve(n-1,k);
        
        else
            return 1-solve(n-1,k-mid);
    }
}
