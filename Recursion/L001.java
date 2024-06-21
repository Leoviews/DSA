import java.util.ArrayList;

public class L001 {

    // Time complexity :O(n)
    // use case:
    // 1) search in array
    // 2) do task for n numbers kind of single for loop tasks
    // 3)one call recusion (single for loop)
    public static void printIncreasing(int a, int b) {
        if (a == b + 1) {
            return;
        }
        System.out.println(a);
        printIncreasing(a + 1, b);
    }

    public static void printDecreasing(int a, int b) {
        if (a == b + 1) {
            return;
        }
        printDecreasing(a + 1, b);
        System.out.println(a);
    }

    public static void printIncDec(int a, int b) {
        if (b < a) {
            return;
        }
        System.out.println(b);
        printIncDec(a, b - 1);
        System.out.println(b);
    }

    public static void printEvenOdd(int a, int b) {
        if (b < a) {
            return;
        }
        if (b % 2 == 0) {
            System.out.println(b);
        }
        printEvenOdd(a, b - 1);
        if (b % 2 != 0) {
            System.out.println(b);
        }
    }

    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }

        return n * fact(n - 1);
    }

    public static int power(int a, int b) {
        if (b == 0) {
            return 1;
        }

        return a * power(a, b - 1);
    }

    public static int powerBtr(int a, int b) {
        if (b == 0) {
            return 1;
        }
        int power = powerBtr(a, b / 2);

        if (b % 2 == 0) {
            return power * power;
        } else {
            return a * power * power;
        }

    }

    public static void Display(int arr[], int index) {
        if (arr.length == index) {
            return;
        }
        System.out.println(arr[index]);
        Display(arr, index + 1);

    }

    public static void displayRev(int arr[], int index) {
        if (arr.length == index) {
            return;
        }
        displayRev(arr, index + 1);
        System.out.println(arr[index]);
    }

    public static void displayEvenLoc(int arr[], int index) {
        if (arr.length == index) {
            return;
        }
        if ((index) % 2 == 0) {
            System.out.println(arr[index]);
        }
        displayEvenLoc(arr, index + 1);
    }

    public static boolean isPrime(int n) {
        boolean isPrime = true;
        if (n <= 1) {
            isPrime = false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                isPrime = false;
            break;
        }

        return isPrime;

    }

    public static void displayPrimeLoc(int arr[], int index) {
        if (arr.length == index) {
            return;
        }
        Boolean isPrime = isPrime(index);

        if (isPrime) {
            System.out.println(arr[index]);
        }
        displayPrimeLoc(arr, index + 1);

    }

    public static int find(int arr[], int data, int index) {
        if (arr.length == index) {
            return -1;
        }
        if (arr[index] == data) {
            return index;
        }
        return find(arr, data, index + 1);
    }

    public static int[] findAll(int index, int data, int arr[], int count) {
        // int count =0;
        if (arr.length == index) {
            int brr[] = new int[count];
            return brr;

        }
        if (arr[index] == data) {
            count++;
        }
        int ans[] = findAll(index + 1, data, arr, count);
        if (arr[index] == data) {
            ans[count - 1] = index;
        }
        return ans;
    }

    public static ArrayList<String> subsequneces(String str, int index) {
        if (str.length() == index) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = str.charAt(index);

        ArrayList<String> myans = subsequneces(str, index + 1);
        ArrayList<String> ans = new ArrayList<>();
        for (String s : myans) {
            ans.add(s);
            ans.add(ch + s);
        }
        return ans;
    }

    public static void subsequence(String str, int index, String ans) {
        if (str.length() == index) {
            System.out.println(ans);
            return;

        }
        subsequence(str, index + 1, ans);
        subsequence(str, index + 1, ans + str.charAt(index));

    }

    public static int subsequences0(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        count += subsequences0(str.substring(1), ans);
        count += subsequences0(str.substring(1), ans + str.charAt(0));
        return count;
    }

    public static ArrayList<String> maze(int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> ans = new ArrayList<>();

        /// Horizonatal
        if (sr + 1 <= er) {
            ArrayList<String> Horizontal = maze(sr + 1, sc, er, ec);
            for (String s : Horizontal) {
                ans.add("H" + s);
                return ans;
            }
        }
        if (sc + 1 <= ec) {
            ArrayList<String> Vertical = maze(sr, sc + 1, er, ec);
            for (String s : Vertical) {
                ans.add("V" + s);
                return ans;
            }
        }
        if (sr + 1 <= er) {
            ArrayList<String> Diagonal = maze(sr + 1, sc + 1, er, ec);
            for (String s : Diagonal) {
                ans.add("D" + s);
                return ans;
            }
        }
        return ans;
    }

    public static int mazed(int sr, int sc, int er, int ec, String ans) {
        if (sr == sc && er == ec) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        if (sr + 1 <= er) {
            count += mazed(sr + 1, sc, er, ec, ans + "H");
        }
        if (sc + 1 <= ec) {
            count += mazed(sr, sc + 1, er, ec, ans + "V");
        }
        if (sr + 1 <= er && sc + 1 <= ec) {
            count += mazed(sr + 1, sc + 1, er, ec, ans + "D");
        }

        return count;
    }
    // public static ArrayList<String> findPath(int[][] m, int n,int sr,int sc,int
    // er,int ec)
    // {

    // }
    //  static String dirs[] = { "N", "S", "E", "W", "ne", "se", "nw", "sw" };

    //  static int dirA[][] = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 1 }, { 1, 1 }, { -1, -1 }, { 1, -1 } };

    // public static void printMazePathJumps(int sr, int sc, int er, int ec, String ans, int vis[][],
    //         ArrayList<String> myans) {
    //     if (sr == er && sc == ec) {
    //         myans.add(ans);
    //         return;
    //     }
    //     vis[sr][sc] = 1;
    //     for (int d = 0; d < dirs.length; d++) {
    //         int r = sr + dirA[d][0];
    //         int c = sc + dirA[d][1];

    //         if (r <= er && c <= ec && r >= 0 && c >= 0 && vis[r][c] != 1) {
    //             printMazePathJumps(r, c, er, ec, ans + dirs[d], vis, myans);

    //         }

    //     }
    //     vis[sr][sc] = 0;
    // }

    public static void display(int arr[][]) {
        // for(int i=0;i<arr.length;i++)
        // {
        // for(int j=0;j<arr[0].length;j++)
        // {

        // }
        // }
        for (int ar[] : arr) {
            for (int num : ar) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // public static int[][] mazePathJump2(int sr, int sc, int er, int ec, String ans, int arr[][], int vis[][]) {
    //     if (sr == er && sc == ec) {
    //         System.out.println(ans);
    //         int myans[][] = new int[er + 1][ec + 1];
    //         vis[sr][sc] = 1;
    //         for (int i = 0; i < arr.length; i++) {
    //             for (int j = 0; j < arr[0].length; j++) {
    //                 myans[i][j] = vis[i][j];
    //                 System.out.println(vis[i][j]);
    //             }
    //         }

    //         vis[sr][sc] = 0;
    //         return myans;
    //     }
    //     int maxJump = arr[sr][sc];
    //     int temp[][] = new int[er + 1][ec + 1];
    //     vis[sr][sc] = 1;
    //     for (int i = 0; i < dirs.length; i++) {
    //         for (int jump = 1; jump < maxJump; jump++) {
    //             int r = sr + dirA[i][0] * jump;
    //             int c = sc + dirA[i][1] * jump;

    //             if (r >= 0 && r <= er && c >= 0 && c <= ec) {
    //                 if (vis[r][c] != 1) {
    //                     temp = mazePathJump2(r, c, er, ec, ans + dirs[i] + "" + jump, arr, vis);
    //                 }

    //                 else{
    //                     break;
    //                 }

    //             }
    //         }
    //     }
    //     vis[sr][sc] = 0;
    //     return temp;
    // }

    static class Path
    {
        String longestPath;
        String shortestPath;
        int longestPathlength;
        int shortestPathLength;
        int [][] longestPathCO;
        int [][] shortestPathCO;
    }

    
    static int[][] dirA ={{1,0},{0,1},{-1,0},{0,-1}};
    static String dirs[]={"D","R","U","L"};

    public static int[][] copyArray(int vis[][])
    {
        int rows = vis.length;
        int cols =vis[0].length;
        int ans[][] =new int [rows][cols];

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                ans[i][j] = vis[i][j];
            }
        }
        return ans;
    }

    public static Path mazePath(int sr,int sc,int er,int ec,String ans,int arr[][],int vis[][])
    {
        if(sr==er && sc==ec)
        {
            System.out.println(ans);
            Path p = new Path();
            p.longestPath = ans;
            p.shortestPath=ans;
            p.longestPathlength=ans.length();
            p.longestPathCO=copyArray(vis);
            p.shortestPathCO=copyArray(vis);
            p.shortestPathLength=ans.length();

            return p;

        }
        int temp = arr[sr][sc];
        arr[sr][sc]=-1;
        vis[sr][sc]=1;

        Path myPath = new Path();
        myPath.longestPathCO = new int[er+1][ec+1];
        myPath.shortestPathCO = new int [er+1][ec+1];
        myPath.longestPathlength= -(int) 1e9;
        myPath.shortestPathLength = (int) 1e9;
        myPath.longestPath="";
        myPath.shortestPath="";

        for(int i=0;i<dirs.length;i++)
        {
            for(int jump =1;jump<=temp;jump++)
            {
                int r= sr+jump*dirA[i][0];
                int c= sc+jump*dirA[i][1];

                if(r>=0 && c>=0 && r<=er &c<=ec)
                {
                    if(arr[r][c] >0)
                    {
                        Path tempans = mazePath(r, c, er, ec, ans+""+dirs[i]+""+jump, arr, vis);

                        if(tempans.longestPathlength>myPath.longestPathlength)
                        {
                            myPath.longestPath=tempans.longestPath;
                            myPath.longestPathlength=tempans.longestPathlength;
                            myPath.longestPathCO=tempans.longestPathCO;
                        }
                        if(tempans.shortestPathLength<myPath.shortestPathLength)
                        {
                            myPath.shortestPath=tempans.shortestPath;
                            myPath.shortestPathLength=tempans.shortestPathLength;
                            myPath.shortestPathCO = tempans.shortestPathCO;
                        }

                        
                    }
                   
                }
                else{
                    break;
                }
            }
            
        }
        arr[sr][sc]= temp;
        vis[sr][sc] =0;
        return myPath;
    }
    public static ArrayList<String> perI(int arr[],int idx,int target,ArrayList<String>ans)
    {
        if(arr.length == idx)
        {
            ArrayList<String>base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> myans = new ArrayList<>();
        int tempans =0;

        if(arr[idx] <10)
        {
            ArrayList<String> first = perI(arr, idx+1,target, myans);
            if(arr[idx] +arr[idx+1] <=10)
            {
                for(String s: first)
                {
                    myans.add("arr[idx]");
                }
            }

        }
        if(arr[0] <10)
        {
            ArrayList<String> first = perI(arr, idx+1,target, myans);
            if(arr[idx] +arr[idx+1] <=10)
            {
                for(String s: first)
                {
                    myans.add("arr[idx]");
                }
            }

        }
        if(arr[1] <10)
        {
            ArrayList<String> first = perI(arr, idx+1,target, myans);
            if(arr[idx] +arr[idx+1] <=10)
            {
                for(String s: first)
                {
                    myans.add("arr[idx]");
                }
            }

        }
        if(arr[2] <10)
        {
            ArrayList<String> first = perI(arr, idx+1,target, myans);
            if(arr[idx] +arr[idx+1] <=10)
            {
                for(String s: first)
                {
                    myans.add("arr[idx]");
                }
            }

        }
        if(arr[3] <10)
        {
            ArrayList<String> first = perI(arr, idx+1,target, myans);
            if(arr[idx] +arr[idx+1] <=10)
            {
                for(String s: first)
                {
                    myans.add("arr[idx]");
                }
            }

        }
        return myans;
    }
    public static int prmutationInfiniteCoins(int arr[],int target,String ans)
    {

        if(target==0)
        {
            System.out.println(ans);
            return 1;
        }
        int count =0;
        for(int ele : arr)
        {
            if(target-ele >=0)
            {
                count+=prmutationInfiniteCoins(arr, target-ele, ans+""+ele);
            }
        }


        return count;
    }
    public static int combinationInfiCoins(int arr[],int idx,int tar,String ans)
    {
        if(tar ==0)
        {
            System.out.println(ans);
            return 1;
        }
        int count =0;

        for(int i=idx;i<arr.length;i++)
        {
            if(tar-arr[i] >=0)
            {
                count+=combinationInfiCoins(arr, i, tar-arr[i], ans+""+arr[i]);
            }
        }
        return count;
    }
    public static int combinationOnlyCoin(int arr[],int idx,int tar,String ans)
    {
        if(tar ==0)
        {
            System.out.println(ans);
            return 1;
        }
        int count =0;

        for(int i=idx;i<arr.length;i++)
        {
            if(tar-arr[i] >=0)
            {
                count+=combinationOnlyCoin(arr, i+1, tar-arr[i], ans+""+arr[i]);
            }
        }
        return count;
    }
    public static int prmutationOnlyCoins(int arr[],int vis[],int idx,int target,String ans)
    {

        if(target==0)
        {
            System.out.println(ans);
            return 1;
        }
        int count =0;
        for(int i=0;i<arr.length;i++)
        {
            if(target-arr[i] >=0 && vis[i] ==0)
            {
                vis[i]  =1;
                count+=prmutationOnlyCoins(arr,vis, i+1, target-arr[i], ans+""+arr[i]);
                vis[i] =0;
            }
        }


        return count;
    }
    // public static int combinationInfiCoins sub(int arr[],int tar,int idx,String ans)
    // {
        
    // }
    public static int  com(int arr[],int idx,int target,String ans )
    {
        if(target ==0 || arr.length ==idx)
        {
           if(target ==0)
           {
            System.out.println(ans);
            return 1 ;
           }
           return 0;
        }
        int count=0;
        if(target -arr[idx] >=0)
        count+=com(arr, idx+1, target, ans);
        count+=com(arr,idx+1,target-arr[idx],ans+arr[idx]);

        return count;
    }
    public static int comIn(int arr[],int idx,int target,String ans)
    {
        if(target ==0 || idx ==arr.length)
        {
           if(target ==0)
           {
            System.out.println(ans);
            return 1;
           }
           return 0;

        }
        int count =0;
        if(target - arr[idx] >=0)
        {
            count+= comIn(arr, idx, target-arr[idx], ans+arr[idx]);   
        }
        count+=comIn(arr,idx+1,target,ans);
        return count;
    }
    public static int perInfi(int arr[], int idx,int target, String ans)
    {
        if(target ==0 || idx == arr.length)
        {
            if(target == 0)
            {
                System.out.println(ans);
                return 1;
            }
            return 0;

        }
        int count =0;
        if(target-arr[idx]>=0)
        {
            count+=perInfi(arr, idx, target-arr[idx], ans+arr[idx]);
        }
        count +=perInfi(arr, idx+1, target, ans);
        return count;
    }
    public static int permSing(int arr[],int target ,int idx,String ans)
    {
        if(target ==0 || idx == arr.length)
        {
            if(target ==0)
            {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count =0;
        if(arr[idx]>=0 && target -arr[idx]>=0)
        {
            int val = arr[idx];
            arr[idx] = - val;
            count+=permSing(arr, target-val, 0, ans+val);
            arr[idx] =val;
        }
        count +=permSing(arr, target, idx+1, ans);

        return count;

    }
    public static int coins140(int arr[],int sum1,int sum2,int idx ,String ans1,String ans2)
    {
        if( idx==arr.length )
        {
            if(sum1 == sum2)
            {
                System.out.println("subset1: "+ ans1 +"     " +"subset2: "+ans2 );
                System.out.println();
                
                return 1;
                
            }
            return 0;
        }
        int count =0;

        count += coins140(arr, sum1+arr[idx], sum2, idx+1, ans1+arr[idx]+"", ans2);
        
        count+= coins140(arr, sum1, sum2+arr[idx], idx+1, ans1, ans2+arr[idx]+"");

        return count;
    }
    public static int coins1401(int arr[],int sum1,int sum2,int idx ,String ans1,String ans2)
    {
        ArrayList<String> ans = new ArrayList<>();
        if( idx==arr.length )
        {
            ans.add(ans1);
            if(sum1 == sum2)
            {
                if(ans.contains(ans2))
                {
                    return 0;              
                
                }
                else{
                    System.out.println("subset1: "+ ans1 +"     " +"subset2: "+ans2 );
                    System.out.println();
                    return 1;  
                }
                
                
            }
            return 0;
        }
        int count =0;

       if(arr[idx] >=0)
       {
        count += coins140(arr, sum1+arr[idx], sum2, idx+1, ans1+arr[idx]+"", ans2);
        
        count+= coins140(arr, sum1, sum2+arr[idx], idx+1, ans1, ans2+arr[idx]+"");
       }

        return count;
    }

    

    ////////////////////////////// Solve Function /////////////////////
    public static void solve() {
        // printIncreasing(1, 5);
        // printDecreasing(1, 5);
        // printIncDec(1, 5);
        // printEvenOdd(1, 5);
        // int ans =fact(5);
        // System.out.println(ans);
        // int ans = power(2, 3);
        // System.out.println(ans);
        // int ans = powerBtr(2, 5);
        // System.out.println(ans);
        // int arr[]={5,2,4,2,1,2,3,2};
        // Display(arr, 0);
        // displayRev(arr, 0);
        // displayEvenLoc(arr, 0);
        // Boolean ans =isPrime(3);
        // System.out.println(ans);
        // displayPrimeLoc(arr, 0);
        // int ans = find(arr, 4, 0);
        // System.out.println(ans);

        // int brr[] =findAll(0, 2, arr,0);
        // for(int i=0;i<arr.length;i++)
        // {
        // System.out.println(brr[i]);
        // }
        // ArrayList<String> ans = subsequneces("abc", 0);
        // for(String s: ans)
        // {
        // System.out.println(s);
        // }
        // subsequence("abc", 0, "");
        // int ct = subsequences0("abc", "");
        // System.out.println(ct);
        // ArrayList<String> ans = maze(0, 0, 2, 2);
        // for(String s : ans)
        // {
        // System.out.println(s);
        // }
        // int maz = mazed(0, 0, 2, 2, "");
        // System.out.println(maz);
        // ArrayList<String> myans = new ArrayList<>();
        // int vis[][] = { { 0, 0, 0 ,0}, { 0, 0, 0,0 }, { 0, 0, 0,0 },{0,0,0,0} };
        // int arr[][] = { { 2, 1, 0, 0 }, { 3, 1, 1, 1 }, { 0, 1, 1, 1 }, { 1, 1, 0, 1 } };
        // printMazePathJumps(0, 0, 2, 2, "", vis, myans);
        // int size =myans.size();
        // System.out.println(size);
        // int ans[][] = mazePathJump2(0, 0, 3, 3, "", arr, vis);
        // display(ans);
        // Path ans = mazePath(0, 0, 3, 3, "", arr, vis);
        // System.out.println(ans.longestPathlength);
        // System.out.println(ans.shortestPathLength);
        // System.out.println(ans.longestPath);
        // System.out.println(ans.shortestPath);
        // int arr[]={2,3,5,7};
        // int vis[]={0,0,0,0};
        // int ans  = combinationOnlyCoin(arr,0, 10, "");
        // System.out.println(ans);
        // int ans = prmutationInfiniteCoins(arr, 10, "");
        // System.out.println(ans);
        // int ans = prmutationOnlyCoins(arr,vis,0, 10, "");
        // System.out.println(ans);
        // int ans =com(arr, 0, 10, "");
        // System.out.println(ans);
        // int ans = comIn(arr, 0, 10, "");
        // System.out.println(ans);
        // int ans = perInfi(arr, 0, 10, "");
        // System.out.println(ans);
        // int ans = permSing(arr, 10, 0, "");
        // System.out.println(ans);
        int arr[]={10,20,30,40,50,60,70};
        // int ans = coins140(arr, 0, 0, 0, "", "");
        // System.out.println(ans);
        int ans =coins1401(arr, arr[0], 0, 1, arr[0]+"", "");
        System.out.println(ans);
    }
    

    /////////// Main Method//////////////////////////////////////////////
    public static void main(String args[]) {
        solve();
    }

}