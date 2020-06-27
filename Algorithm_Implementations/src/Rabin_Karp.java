// --------- an implementation of Rabin_Karp Algorithm using JAVA --------- //
public class Rabin_Karp {

    public static void Rabin_Karp_String_Match(String someString, String pattern){
        int p = 0;
        int t = 0;
        int h = 1;
        int d = 256;
        int prime = 101;
        int m = pattern.length();
        int n = someString.length();
        for(int i = 0; i< m - 1; i++)
            h = (d * h) % prime;
        for(int i = 0; i<m; i++){
            p = ((d*p) + pattern.charAt(i))%prime;
            t = ((d*t) + someString.charAt(i))%prime;
        }
        for(int i = 0; i<= n-m; i++){
            if(p == t){
                for(int j = 0; j<m; j++){
                    if(someString.charAt(i+j) != pattern.charAt(j))
                        break;
                    else
                        System.out.println("the pattern is found");
                }
            }else{
                t = (((((t - someString.charAt(i)*h)%prime)*d)) + someString.charAt(i+m))%prime;
                if(t<0)
                    t = t+ prime;
            }
        }
    }
    public static void main(String[] args){
        String something = "abcdaadaccaab";
        String pattern = "aab";
        Rabin_Karp_String_Match(something,pattern);
    }
}
