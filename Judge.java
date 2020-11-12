//Rose Tabares - CS245 - Lab07
import java.util.*;

public class Judge {
    public static int findJudge(int N, int[][] trust) {//function to find the judge
        //N: int = number of people in the town (always between 1 and 1000)
        //trust: int [] [] = the trust array (The number of entries in trust is always less than 10,000, Each item in the trust array is unique and different)
        //function returns the ID of the judge or -1 if no judge is found.

        //In a town, there are N people. There is a rumor that one of these people is secretly the town judge. If the town judge exists, then:
            //1. The town judge trusts nobody.
            //2. Everybody (except for the town judge) trusts the town judge.
            //3. There is exactly one person that satisfies properties 1 and 2.

        //Initialize arrays to store who trusts and who is trusted
        int[] townTrust = new int[N];//trusts the judge
        int[] townTrusted = new int[N];//trusted people
        //loop through trust array
        for(int i = 0; i < trust.length; i++){

            int a = trust[i][0];//set an int a to the array at i and 0
            int b = trust[i][1];//set an int b to the array at i and 1

            townTrust[a - 1]++;//set the townTrust array at a-1 and increment
            townTrusted[b - 1]++;//set the townTrusted array at b-1 and increment

        }
        //loop through all different number of people
        for(int i = 0; i < N; i++){
            //if i is trusted by everyone (N-1) and trusts no one (0), then it is the town judge
            if(townTrust[i] == 0 && townTrusted[i] == N - 1){
                return i + 1;
            }
        }
        //if NO judge, then return -1
        return -1;
    }

    public static void main(String[] args) {
        // Initialize trust arrays for different examples
        //trust[i] = [a, b] representing that the person labelled a trusts the person labelled b
        int trust1[][] = {{1, 2}};
        int trust2[][] = {{1, 3}, {2, 3}};
        int trust3[][] = {{1, 3}, {2, 3}, {3, 1}};
        int trust4[][] = {{1, 2}, {2, 3}};
        int trust5[][] = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        //set int n to the result of findJudge with n and the trust array:
        int n1 = findJudge(2,trust1); //should output 2
        int n2 = findJudge(3,trust2); //should output 3
        int n3 = findJudge(3,trust3); //should output -1
        int n4 = findJudge(3,trust4); //should output -1
        int n5 = findJudge(4,trust5); //should output 3
        
        //create array including all findJudge outputs:
        int judges[] = {n1, n2, n3, n4, n5};
        //Output town judge, if any 
        for (int i=0; i<judges.length; i++){
            if(judges[i]==-1){
                System.out.println("There is NO judge in town "+(i+1)+" : "+judges[i]);
            }else{
                System.out.println("The judge in town "+(i+1)+" is: " + judges[i]);
            }
        }
    }
}
