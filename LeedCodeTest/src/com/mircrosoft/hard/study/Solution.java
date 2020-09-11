package com.mircrosoft.hard.study;

import com.mircrosoft.hard.study.bean.ListNode;

import java.util.*;

public class Solution {

    public void reverseWords(char[] s) {
        StringBuilder one = new StringBuilder();
        StringBuilder ret = new StringBuilder();
        for(int i=0; i<s.length; i++) {
            if(s[i] != ' ') {
                one.append(s[i]);
            } else {
                if(ret.length() > 0) {
                    one.append(" ");
                }
                ret.insert(0, one);
                one = new StringBuilder();
            }
        }
        if(ret.length() > 0) {
            one.append(" ");
        }
        ret.insert(0, one);
        for(int i=0 ; i<ret.length(); i++) {
            s[i] = ret.charAt(i);
        }
    }

    public String fractionToDecimal(int ni, int di) {
        StringBuilder sb = new StringBuilder();
        if(ni == 0) {
            return "0";
        }

        long n;
        long d;
        if(ni <0 ^ di <0) {
            sb.append("-");
        }
        n = Math.abs(Long.valueOf(ni));
        d = Math.abs(Long.valueOf(di));
        long beforPoint = n/d;
        long cur = n % d;
        sb.append(beforPoint);
        if(cur == 0) {
            return sb.toString();
        }
        sb.append(".");
        // key是除数，value是需要插入括号的位置,  2 /3, sb=0.   cur =20,
        HashMap<Long, Integer> map = new HashMap<>();
        int j = sb.indexOf(".") + 1;



        while(cur !=0) {
            cur *=10;
//            while(cur < d) {
//
//                if(map.containsKey(cur)) {
//                    sb.append(")");
//                    sb.insert(map.get(cur), "(");
//                    return sb.toString();
//                } else {
//                    map.put(cur, j++);
//                }
//                sb.append("0");
//                cur *=10;
//            }
            if(map.containsKey(cur)) {
                sb.append(")");
                sb.insert(map.get(cur), "(");
                return sb.toString();
            } else {
                map.put(cur, j++);
            }


            sb.append(cur /d);
            cur %= d;
        }

        return sb.toString();

    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ret = new LinkedList<>();
        if(nums == null || nums.length == 0) {
            add(ret, lower, upper, 4);
            return ret;
        }
        add(ret, lower, nums[0], 1);
        for(int i=1; i<nums.length; i++) {
            add(ret, nums[i-1], nums[i],3);
        }
        add(ret, nums[nums.length-1], upper,2);

        return ret;


    }

    // head 1
    // tail 2
    // middle 3
    // head and tail 4
    private void add(List<String> ret, int lower, int upper, int flag) {

        StringBuilder sb = new StringBuilder();
        if(flag == 4) {
            if(lower < upper) {
                sb.append(lower);
                sb.append("->");
                sb.append(upper);
            } else {
                sb.append(lower);
            }
            ret.add(sb.toString());
            return;
        }

        if(lower == upper) {
            return;
        }
        //1 2
        if(lower == upper -1) {
            if(flag == 1) {
                sb.append(lower);
            } else if(flag == 2) {
                sb.append(upper);
            }
        }

        //3 5


        else {
            if(flag == 1) {
                sb.append(lower);
                sb.append("->");
                sb.append(upper-1);
            } else if(flag == 2) {
                sb.append(lower+1);
                sb.append("->");
                sb.append(upper);
            } else {
                if(lower == upper -2) {
                    sb.append(lower + 1);
                } else {
                    sb.append(lower + 1);
                    sb.append("->");
                    sb.append(upper-1);
                }
            }
        }
        String ans = sb.toString();
        if(!"".equals(ans))
            ret.add(sb.toString());
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int cnt = 2;
        char[] cs = s.toCharArray();
        int[] map = new int[256];
        int i = 0, j = 0;
        int max = 0;
        while (j <= cs.length) {
            if (cnt >= 0) {
                max = Math.max(max, j - i);
                if (j == cs.length) break;
                if (map[cs[j++]]++ == 0) cnt--;
            } else {
                if (--map[cs[i++]] == 0) cnt++;
            }
        }
        return max;
    }

    /*public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 1;
        char c1 = s.charAt(left);
        while(right < s.length() && c1 == s.charAt(right)) {
            right++;
        }

        int ret = right - left + 1;
        if(right >= s.length()) {
            return s.length();
        }
        char c2 = s.charAt(right);
        int nextleft = right;
        char nextC = c2;
        right++;
        while(right < s.length()) {
            char c3 = s.charAt(right);


            if(c3 == c1 || c3 == c2) {
                if(c3 != nextC) {
                    nextC = c3;
                    nextleft = right;
                }
            } else {
                left = nextleft;
                nextleft = right;
                nextC = s.charAt(nextleft);
                c1 = s.charAt(left);
                c2 = s.charAt(nextleft);
            }


//aabbc 4

            ret = Math.max(ret, right -left+1);
            right++;
        }

        return ret;

    }*/

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return nums[0] >nums[1]?nums[1]:nums[0];
        }

        int left = 0;
        int right = nums.length-1;
        int mid = (left + right) /2;
        while(left < right) {
            if(mid -1 >=0) {
                if(nums[mid-1] < nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            if( mid + 1< nums.length) {
                if(nums[mid+1] < nums[mid]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            mid = (left + right) /2;
        }
        return nums[mid + 1];

    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode one = sortList(head);
        ListNode sec = sortList(midNext);

        return merge(one, sec);


    }

    private ListNode merge(ListNode one, ListNode sec) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(one != null && sec != null) {
            if(one.val < sec.val) {
                cur.next = one;
                one = one.next;
            } else {
                cur.next = sec;
                sec = sec.next;
            }
            cur = cur.next;
        }
        if(one != null) {
            cur.next = one;
        }
        if(sec != null) {
            cur.next = sec;
        }
        return dummy.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;

        while(cur.next != null) {
            ListNode next = cur.next;
            ListNode temp = dummy;
            boolean move = false;
            while(temp.next != null) {
                if(cur.next.val < temp.next.val) {
                    ListNode l = cur.next;
                    cur.next = cur.next.next;
                    l.next = temp.next;
                    temp.next = l;
                    move = true;
                    break;
                } else if(temp == cur) {
                    break;
                }
                temp = temp.next;
            }
            if(!move) {
                cur = next;
            }
        }
        return dummy.next;
    }

    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode cur = head;
        ArrayList<ListNode> alls = new ArrayList<>();
        while(cur != null) {
            alls.add(cur);
            cur = cur.next;
        }
        cur = head; //1
        ListNode tail = alls.get(alls.size()/2);
        int len = alls.size();
        for(int i=0; i<=len/2; i++) {
            ListNode needMove = alls.remove(alls.size() -1); //2
            needMove.next = cur.next; //2->null
            cur.next = needMove; //1->2

            if(cur.next != null) {
                cur = cur.next.next;
            }
        }
        tail.next = null;

    }

    List<List<Integer>> combineRet = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        internal(n, k, 1, new LinkedList());
        return combineRet;
    }

    private void internal(int n ,int k, int current, List<Integer> one) {
        if(one.size() == k) {
            combineRet.add(new LinkedList(one));
            return;
        }

        for(int i=current; i<=n; i++) {
            if(!one.contains(i)) {
                one.add(i);
                internal(n, k, i+1, one);
                one.remove(one.size() -1);
            }
        }
    }

    public void quanpailie(int m)  {
        internalQuanpailie(m, 1, new ArrayList<Integer>());
    }

    //0-m-1

    private void internalQuanpailie(int m, int currentIndex, List list) {
        if(list.size() == m) {
            System.out.println(Arrays.toString(list.toArray()));
        }
        for(int i= 1; i<=m; i++) {
            if(!list.contains(i)) {
                list.add(i);
                internalQuanpailie(m, currentIndex + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public void zidianxu(int k) {
        int ret[] = new int[k];
        for(int i=0; i<k; i++) {
            ret[i] = i+1;
        }
        int index = 1;
        while(k>0) {
            index = index * k;
            k--;
        }
        while(index >1) {
            nextPermutation(ret);
            System.out.println(Arrays.toString(ret));
            index--;
        }
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //n是行，m是列
        if(obstacleGrid == null || obstacleGrid[0] == null) {
            return 0;
        }
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(n == 0 || m ==0 ) {
            return 0;
        }
        int[] dp = new int[m];
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        dp[0] = 1;
        for(int i=1; i<m; i++) {
            if(obstacleGrid[0][i] == 1) {
                dp[i] = 0;
            }else {
                dp[i] = dp[i-1];
            }
        }

        for(int i=1;i<n;i++) {
            for(int j=0; j<m; j++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if(j == 0) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j-1] + dp[j];
                }
            }
        }

        return dp[m-1];
    }

    public int uniquePaths(int m, int n) {
        //n是行，m是列
        if(n == 0 || m ==0 ) {
            return 0;
        }
        if(n == 1 || m ==1 ) {
            return 1;
        }
        int[] dp = new int[m];
        for(int i=0; i<m; i++) {
            dp[i] = 1;
        }

        for(int i=1;i<n;i++) {
            for(int j=0; j<m; j++) {
                if(j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j-1] + dp[j];
                }
            }
        }

        return dp[m-1];
    }

    public String stringForTime(final long millis) {
        final int totalSeconds = (int) millis / 1000;
        final int seconds = totalSeconds % 60;
        final int minutes = (totalSeconds / 60) % 60;
        final int hours = totalSeconds / 3600;
        if (hours > 0) {
            return String.format("%d:%02d:%02d", hours, minutes, seconds);
        } else {
            return String.format("%02d:%02d", minutes, seconds);
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        int len = 0;
        ListNode cur = head;
        while(cur != null) {
            len ++;
            if(cur.next == null) {
                cur.next = head;
                break;
            }
            cur = cur.next;
        }

        int n = len - k % len -1;
        cur = head;
        while(n!=0) {
            n--;
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;

    }
    public String getPermutation(int n, int k) {

        StringBuilder ret = new StringBuilder();
        if(n ==1) {
            return "1";
        }
        boolean[] used = new boolean[n + 1];
        int temp = n;
        for(int i=0; i<temp; i++) {
            int njie = help(n-1);
            int m = k%njie == 0? k /njie :k/njie + 1;

            for(int j=1; j< temp+1; j++) {
                if(!used[j]) {
                    m--;
                }
                if(m == 0) {
                    used[j] = true;
                    ret.append(j);
                    break;
                }
            }

            if(k % njie != 0) {
                k = k %njie;
                n--;
            } else {
                for(int j= temp; j>0; j--) {
                    if(!used[j]) {
                        ret.append(j);
                    }
                }

                return ret.toString();
            }
        }
        return ret.toString();

    }
    private int help(int n) {
        switch(n) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 6;
            case 4:
                return 24;
            case 5:
                return 120;
            case 6:
                return 720;
            case 7:
                return 5040;
            case 8:
                return 40320;
            case 9:
                return 362880;
        }
        return 0;
    }


    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] ret = new int[n];
        LinkedList<Integer>[] list = new LinkedList[n];
        for(int i=0; i<n; i++) {
            list[i] = new LinkedList<>();
        }
        for(int i=0; i<n-1; i++) {
            if(list[edges[i][0]] == null) {
                list[edges[i][0]] = new LinkedList();
            }
            list[edges[i][0]].add(edges[i][1]);
        }

        for(int i=0; i<list.length; i++) {
            ret[i] = getRes(n, edges, labels, list, i, ret) + 1;
        }
        return ret;
    }

    private int getRes(int n, int[][] edges, String labels, List<Integer>[] list, int i, int[] ret) {
        List<Integer> sons = list[i];
        System.out.println(i);
        for(int j=0; j<sons.size(); j++) {
            if(labels.charAt(sons.get(j)) == labels.charAt(i)) {
                if(ret[sons.get(j)] != 0) {
                    ret[i] += ret[sons.get(j)] + 1;
                } else {
                    ret[i] += getRes(n, edges, labels, list, sons.get(j), ret) + 1;
                }
            }
        }
        return ret[i];
    }

    public boolean canJump(int[] nums) {
        if(nums == null || nums.length ==0) {
            return false;
        }
        if(nums.length == 1) {
            return true;
        }
        if(nums[0] == 0) {
            return false;
        }
        return internal(nums, nums.length -2, nums.length -1);
    }

    private boolean internal(int[] nums, int cur, int targetIndex) {
        if(cur <= 0) {
            return true;
        }
        for(int i= cur; i>=0; i--) {
            if(nums[i] + i >= targetIndex) {
                return internal(nums, i-1, i);
            }
        }

        return false;
    }




    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ret;
        }
        int l = 0;
        int u = 0;
        int r = matrix[0].length -1;
        int d = matrix.length -1;

        while(true) {
            for(int i=l; i<=r; i++) {
                ret.add(matrix[u][i]);
            }
            if(++u > d) {
                break;
            }
            for(int i=u;i<=d; i++) {
                ret.add(matrix[i][r]);
            }
            if(--r <l) {
                break;
            }
            for(int i=r; i>=l; i--) {
                ret.add(matrix[d][i]);
            }
            if(--d < u) {
                break;
            }

            for(int i=d; i>=u; i--) {
                ret.add(matrix[i][l]);
            }

            if(++l > r) {
                break;
            }
        }
        return ret;

    }
//        vector<int> spiralOrder(vector<vector<int>>& matrix) {
//            vector <int> ans;
//            if(matrix.empty()) return ans; //若数组为空，直接返回答案
//            int u = 0; //赋值上下左右边界
//            int d = matrix.size() - 1;
//            int l = 0;
//            int r = matrix[0].size() - 1;
//            while(true)
//            {
//                for(int i = l; i <= r; ++i) ans.push_back(matrix[u][i]); //向右移动直到最右
//                if(++ u > d) break; //重新设定上边界，若上边界大于下边界，则遍历遍历完成，下同
//                for(int i = u; i <= d; ++i) ans.push_back(matrix[i][r]); //向下
//                if(-- r < l) break; //重新设定有边界
//                for(int i = r; i >= l; --i) ans.push_back(matrix[d][i]); //向左
//                if(-- d < u) break; //重新设定下边界
//                for(int i = d; i >= u; --i) ans.push_back(matrix[i][l]); //向上
//                if(++ l > r) break; //重新设定左边界
//            }
//            return ans;
//        }

    public double myPow(double x, int n) {
        // x^n = x^(110101...);括号里面的是n的二进制
        //     = x^(2^0 + 2^1+...)
        //     = x^(2^0) * x^(2^1)...
        //     = x^1 * x^2 * x*4* x*8
        if(n == 0) {
            return 1;
        }
        boolean isfu = false;
        long m = n;
        if(m < 0) {
            isfu = true;
            m = 0-m;
        }
        long i =1;
        double ret = 1;
        double chen = x;
        while(i <= m) {
            if((m & i) == i) {
                ret = ret * chen;
            }

            chen *= chen;//x2
            i <<= 1;
        }
        if(isfu) {
            ret = 1/ret;
        }
        return ret;
    }






    public int threeSumClosest(int[] nums, int target) {
        int ret = 0;


        Arrays.sort(nums);
        int len = nums.length;
        int minDiff = 3000;
        for(int i=0; i<len-1; i++) {
            int a = nums[i];
            if(i > 0 && a == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = len -1;
            int b = nums[left];
            int c = nums[right];
            while(left < right) {
                if(left -1 != i && nums[left -1] == b) {
                    continue;
                }
                if(Math.abs(a + b + c - target) < minDiff ) {
                    minDiff = Math.abs(a + b + c - target);
                    ret = a+ b + c;
                } else if(a+ b +c == target) {
                    return target;
                }
                if(a + b + c < target) {
                    left ++;
                    b = nums[left];
                } else {
                    right --;
                    c = nums[right];
                }
            }
        }

        return ret;
    }

    /* public List<String> letterCombinations(String digits) {
         String[] dictionary = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
         List<String> ret = new LinkedList<>();
         for(int i=0; i<digits.length(); i++) {
             int k = Integer.parseInt(digits.charAt(i) + "");
             ret = addOneNumber(ret, dictionary[k]);
         }
         return ret;
     }

     private List<String> addOneNumber(List<String> cur, String dictionaryString){
         List<String> ret = new LinkedList<>();
         for(int j=0; j<cur.size(); j++) {
             for(int i=0; i< dictionaryString.length(); i++) {
                 String curStr = cur.get(j);
                 curStr += dictionaryString.charAt(i);
                 ret.add(curStr);
             }
         }
         if(cur.size() == 0) {
             for(int i=0; i< dictionaryString.length(); i++) {
                 String curStr = dictionaryString.charAt(i) + "";
                 ret.add(curStr);
             }
         }

         return ret;
     }*/
/*

        List<String> ret = new LinkedList<>();
        HashMap<Character, String> dictionary = new HashMap();
        public List<String> letterCombinations(String digits) {
            dictionary = new HashMap<Character, String>();
            dictionary.put('2', "abc");
            dictionary.put('3', "def");
            dictionary.put('4', "ghi");
            dictionary.put('5', "jkl");
            dictionary.put('6', "mno");
            dictionary.put('7', "pqrs");
            dictionary.put('8', "tuv");
            dictionary.put('9', "wxyz");
            if(digits == null || digits.length() == 0) {
                return ret;
            }
            internal("", digits, 0);
            return ret;
        }

        private void internal(String cur, String digits, int digitsIndex) {
            if(digitsIndex == digits.length()) {
                ret.add(cur);
                return;
            }
            String toAddString = dictionary.get(digits.charAt(digitsIndex));
            for(int i=0; i<toAddString.length(); i++) {
                String temp = cur;
                temp += toAddString.charAt(i);
                internal(temp, digits, digitsIndex+1);
            }

        }

        public void testString(String s) {
            s = s + "s";
        }
*/
    //我的递归
    List<String> ret = new LinkedList<>();
    int diguicount = 0;
    String[] dictionary = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations2(String digits) {
        if(digits == null || digits.length() == 0) {
            return ret;
        }
        internal("", digits, 0);
        return ret;
    }

    private void internal(String cur, String digits, int digitsIndex) {
        diguicount++;
        if(digitsIndex == digits.length()) {
            ret.add(cur);
            return;
        }
        char[] toAddString = help(digits.charAt(digitsIndex));
        // String toAddString = dictionary[digits.charAt(digitsIndex)-'0'];
        for(int i=0; i<toAddString.length; i++) {
            String temp = cur;
            temp += toAddString[i];
            internal(temp, digits, digitsIndex+1);
        }

    }


    //模范递归
    //定义结果集合
    List<String> res = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        //进行特殊情况判断
        if(digits.length()==0){
            return res;
        }

        //使用回溯法来进行求解

        //把字符串转换为字符数组
        char[] c = digits.toCharArray();

        int n = c.length;

        char[] track = new char[n];

        //回溯
        backtrack(c,track,0);
        return res;
    }

    public void backtrack(char[] c,char[] track,int len){
        diguicount++;
        //定义结束条件
        if(len == c.length){
            res.add(new String(track));
            return;
        }

        char[] as = help(c[len]);



        //做选择
        for(int i=0;i<as.length;i++){
            //排除不正确的选择
            for(int j=0;j<track.length;j++){
                if(c[j]==as[i]){
                    continue;
                }
            }

            //做选择
            track[len] = as[i];


            //进入下一层决策树
            backtrack(c,track,len+1);

            //撤销选择；

            track[len] = '+';


        }

    }

    public char[] help(char s){

        //判断数字对应的集合是什么
        switch(s){

            case '2':
                return  new char[]{'a','b','c'};

            case '3':
                return  new char[]{'d','e','f'};

            case '4':
                return  new char[]{'g','h','i'};

            case '5':
                return  new char[]{'j','k','l'};

            case '6':
                return  new char[]{'m','n','o'};

            case '7':
                return  new char[]{'p','q','r','s'};

            case '8':
                return  new char[]{'t','u','v'};

            case '9':
                return  new char[]{'w','x','y','z'};

        }

        return new char[1];

    }

    public int divide(int dividend, int divisor) {
        boolean isFu = (dividend > 0 && divisor < 0 ) || (dividend < 0 && divisor > 0);
        long a = dividend;
        long b = divisor;
        a = a > 0? a : -a;
        b = b > 0 ? b : -b;
        if(b == 1) {
            if(a >= Integer.MAX_VALUE || a <= Integer.MIN_VALUE) {
                return isFu ?Integer.MIN_VALUE:Integer.MAX_VALUE;
            } else{
                return (int)(isFu ? 0-a:a);
            }
        }
        if(a < b) {
            return 0;
        }
        long ret = 1;
        long temp = b;
        while(temp + temp <= a) {
            temp += temp; //12 6
            ret += ret;//3 2
        }
        ret += divide((int) (a - temp), (int)(b));
        if(isFu) {
            ret = 0 - ret < Integer.MIN_VALUE ? Integer.MIN_VALUE : 0-ret;
        }
        return (int) ret;
    }
        /*int divide(int dividend, int divisor) {
            if(dividend == 0) return 0;
            if(divisor == 1) return dividend;
            if(divisor == -1){
                if(dividend>Integer.MIN_VALUE) return -dividend;// 只要不是最小的那个整数，都是直接返回相反数就好啦
                return Integer.MAX_VALUE;// 是最小的那个，那就返回最大的整数啦
            }
            long a = dividend;
            long b = divisor;
            int sign = 1;
            if((a>0&&b<0) || (a<0&&b>0)){
                sign = -1;
            }
            a = a>0?a:-a;
            b = b>0?b:-b;
            long res = div(a,b);
            if(sign>0)return res>Integer.MAX_VALUE?Integer.MAX_VALUE: (int) res;
            return (int) -res;
        }
        int div(long a, long b){  // 似乎精髓和难点就在于下面这几句
            if(a<b) return 0;
            long count = 1;
            long tb = b; // 在后面的代码中不更新b
            while((tb+tb)<=a){
                count = count + count; // 最小解翻倍
                tb = tb+tb; // 当前测试的值也翻倍
            }
            return (int) (count + div(a-tb,b));
        }*/


    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len <=1) {
            return;
        }
        int i = len-2;
//            1 2 3 5 4 0
//            nums[i] = 3
        for(;i>=0 && nums[i] >= nums[i+1]; i--);
        if(i == -1) {
            Arrays.sort(nums);
            return;
        }
        int j = len -1;
        //nums[j] = 4
        for(;j>i && j>=0 && nums[j] <= nums[i]; j--);
        swipe(nums, i, j);
//            1 2 4 5 3 0
        Arrays.sort(nums, i+1, len);
        //1 2 4 0 3 5
    }
    private void swipe(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        if(nums.length == 1) {
            return nums[0] == target? 0:-1;
        }
        if(nums[0] == target) {
            return 0;
        }
        int left = 0;
        int right = nums.length -1;

        while(left <= right) {
            int mid = (left + right) / 2;
            int l = nums[left];
            int r = nums[right];
            int m = nums[mid];
            if(m == target) {
                return mid;
            }
            if(target < nums[0]) {
                if(m < nums[0]) {
                    if(target < m) {
                        right = mid -1;
                    } else {
                        left = mid +1;
                    }
                } else {
                    l = mid + 1;
                }
            } else {
                if(m < nums[0]) {
                    right = mid -1;
                } else {
                    if(target > m) {
                        left = mid + 1;
                    } else {
                        right = mid -1;
                    }
                }
            }
        }

        return -1;

    }

    public boolean isValidSudoku(char[][] board) {
        //横
        for(int i=0; i<9; i++) {
            int[] dictionary = new int[10];
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                if(dictionary[board[i][j] - '0'] > 0) {
                    return false;
                }
                dictionary[board[i][j] - '0']++;
            }
        }
        //竖
        for(int i=0; i<9; i++) {
            int[] dictionary = new int[10];
            for(int j=0; j<9; j++) {
                if(board[j][i] == '.') {
                    continue;
                }
                if(dictionary[board[j][i] - '0'] > 0) {
                    return false;
                }
                dictionary[board[j][i] - '0']++;
            }
        }
        for(int i=1; i<=7; i+=3) {
            //第i个方格
            for(int j=1; j<=7; j+=3) {
                int[] dictionary = new int[10];
                if(board[i-1][j-1] != '.') {
                    if(dictionary[board[i-1][j-1] - '0'] > 0) {
                        return false;
                    }
                    dictionary[board[i-1][j-1] - '0']++;
                }
                if(board[i-1][j] != '.') {
                    if(dictionary[board[i-1][j] - '0'] > 0) {
                        return false;
                    }
                    dictionary[board[i-1][j] - '0']++;
                }
                if(board[i-1][j+1] != '.') {
                    if(dictionary[board[i-1][j+1] - '0'] > 0) {
                        return false;
                    }
                    dictionary[board[i-1][j+1] - '0']++;
                }
                if(board[i][j-1] != '.') {
                    if(dictionary[board[i][j-1] - '0'] > 0) {
                        return false;
                    }
                    dictionary[board[i][j-1] - '0']++;
                }
                if(board[i][j] != '.') {
                    if(dictionary[board[i][j] - '0'] > 0) {
                        return false;
                    }
                    dictionary[board[i][j] - '0']++;

                }
                if(board[i][j+1] != '.') {
                    if(dictionary[board[i][j+1] - '0'] > 0) {
                        return false;
                    }
                    dictionary[board[i][j+1] - '0']++;
                }
                if(board[i+1][j-1] != '.') {
                    if(dictionary[board[i+1][j-1] - '0'] > 0) {
                        return false;
                    }
                    dictionary[board[i+1][j-1] - '0']++;

                }
                if(board[i+1][j] != '.') {
                    if(dictionary[board[i+1][j] - '0'] > 0) {
                        return false;
                    }
                    dictionary[board[i+1][j] - '0']++;
                }
                if(board[i+1][j+1] != '.') {
                    if(dictionary[board[i+1][j+1] - '0'] > 0) {
                        return false;
                    }
                    dictionary[board[i+1][j+1] - '0']++;
                }
            }
        }
        return true;
    }

    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        for(int i=len1-1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for(int j=len2-1; j>=0; j--) {
                if(i+j + 2< len1 + len2 && res[i+j +2] >= 10) {
                    res[i+j + 1] += res[i+j+2]/10;
                    res[i + j + 2] = res[i+j+2] %10;
                }
                int b = num2.charAt(j) - '0';
                int product = a*b;
                res[i+j +1] += product %10;
                res[i+j] += product /10;
            }
        }

        if(res[1] >= 10) {
            res[0] += res[1]/10;
            res[1] = res[1] %10;
        }
        StringBuilder ret = new StringBuilder();
        for(int i=0; i<res.length; i++) {
            if(i== 0 && res[i] == 0){
                continue;
            }
            ret.append(res[i]);
        }
        return ret.toString();


//            for(int i=len1-1; i >= 0; i--) {
//                int a = num1.charAt(i) - '0';
//                for(int j=len2-1; j>=0; j--) {
//                    int b = num2.charAt(j) - '0';
//                    res[i+j +1] += a*b;
//                }
//            }
//
//            String ret = "";
//            for(int i=res.length -1; i>0; i--) {
//                res[i-1] += res[i] /10;
//                ret = res[i] %10 + ret;
//            }
//            if(res[0] != 0)
//                ret = res[0] + ret;
//            return ret;
    }


    List<List<Integer>> ret2 = new LinkedList();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        internal(nums, new LinkedList(), new LinkedList());
        return ret2;
    }

    private void internal(int[] nums, List<Integer> res, List<Integer> hasSelectedIndex) {
        if(hasSelectedIndex.size() == nums.length) {
            ret2.add(new LinkedList(res));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(hasSelectedIndex.contains(i)) {
                continue;
            }
            if(i >= 1 && nums[i] == nums[i-1] && !hasSelectedIndex.contains(i-1)) {
                continue;
            }
            res.add(nums[i]);
            hasSelectedIndex.add(i);
            internal(nums, res, hasSelectedIndex);
            hasSelectedIndex.remove(hasSelectedIndex.size() - 1);
            res.remove(res.size() -1);
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n/2;i++) {
            for(int j=i; j<n-1-i; j++) {
                int a = matrix[i][j]; //1
                int b = matrix[j][n-1-i]; //2
                int c = matrix[n-1-i][n-1-j]; //3
                int d = matrix[n-1-j][i]; //4

                matrix[i][j] = d;
                matrix[j][n-1-i] = a;
                matrix[n-1-i][n-1-j] = b;
                matrix[n-1-j][i] = c;
            }
        }
        HashMap<String, List> map = new HashMap();
        List<List> k = new LinkedList<>(map.values());

    }

    /**
     * 15.
     *
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *  
     *
     * 示例：
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     *
     * 解法：
     * 先固定一个数，然后双指针开始运动。
     */

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ret = new LinkedList<>();
        if(nums.length < 3) {
            return ret;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0; i< len - 2; i++) {
            int a = nums[i];
            //去重
            if(i >= 1 && a == nums[i -1]) {
                continue;
            }
            //剪枝
            if(nums[i] + nums[i+1] + nums[i + 2] > 0) {
                //当前情况的最小的数>0
                return ret;
            } else if(i >= 2 && nums[i] + nums[len -1] + nums[len - 2] < 0) {
                //当前情况最大的数<0
                continue;
            }
            int left = i+ 1;
            int right = len -1;
            int b = nums[left];
            int c = nums[right];
            while(left < right) {
                //剪枝
                //如果上一个数没有被选中即（left - 1 !=i），且b==上一个数，那不应该再检查了。
                if(left - 1 !=i && b == nums[left-1]) {
                    left ++;
                    continue;
                }
                if(b + c + a < 0) {
                    left ++;
                    b = nums[left];
                } else if(b + c + a == 0) {
                    List<Integer> subRet = new LinkedList<>();
                    subRet.add(a);
                    subRet.add(b);
                    subRet.add(c);
                    ret.add(subRet);
                    left ++;
                    right --;
                    b = nums[left];
                    c = nums[right];
                } else {
                    right --;
                    c = nums[right];
                }
            }

        }
        return ret;
    }

    /**
     * 12.
     *
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
     *
     * 示例 1:
     *
     * 输入: 3
     * 输出: "III"
     * 示例 2:
     *
     * 输入: 4
     * 输出: "IV"
     * 示例 3:
     *
     * 输入: 9
     * 输出: "IX"
     * 示例 4:
     *
     * 输入: 58
     * 输出: "LVIII"
     * 解释: L = 50, V = 5, III = 3.
     * 示例 5:
     *
     * 输入: 1994
     * 输出: "MCMXCIV"
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-to-roman
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        // I             1
        //IV             4
        // V             5
        //IX             9
        // X             10
        //XL             40
        // L             50
        //XC             90
        // C             100
        //CD             400
        // D             500
        //CM             900
        // M             1000
        //455
        //方案1 贪心算法,尽量选择最好的。
        // int[] nums = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        // String[] luoma = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        // String ret = "";
        // while(num > 0) {
        //     int i = 0;
        //     while( i < nums.length) {
        //         if(num >= nums[i]) {
        //             ret += luoma[i];
        //             num -= nums[i];
        //             break;
        //         }
        //         i++;
        //     }
        // }
        // return ret;

        //方案2：
        StringBuilder ret = new StringBuilder("");
        String[][] alls = {
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","M","MM","MMM"}
        };
        ret.append(alls[3][num/1000]);
        ret.append(alls[2][(num % 1000)/100]);
        ret.append(alls[1][(num % 100)/10]);
        ret.append(alls[0][(num % 10)]);
        return ret.toString();


    }

    /**
     * 11.
     *
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     *
     * 示例：
     *
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param height
     * @return
     *
     * 解法：双指针，移动左右两个矮的那个
     *
     * 指针移动规则与证明： 每次选定围成水槽两板高度 h[i],h[j] 中的短板，向中间收窄 11 格。以下证明：
     *
     * 设每一状态下水槽面积为 S(i, j),(0 <= i < j < n)，
     * 由于水槽的实际高度由两板中的短板决定，
     * 则可得面积公式 S(i, j) = min(h[i], h[j]) × (j - i)。
     * 在每一个状态下，无论长板或短板收窄 11 格，都会导致水槽 底边宽度 -1−1：
     * 若向内移动短板，水槽的短板 min(h[i], h[j])可能变大，因此水槽面积 S(i, j)可能增大。
     * 若向内移动长板，水槽的短板 min(h[i], h[j])不变或变小，下个水槽的面积一定小于当前水槽面积
     *
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;
        int max = 0;
        while(left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            max = Math.max(max, h*w);
            if(height[left] < height[right]) {
                left ++;
            } else if(height[left] >= height[right]) {
                right--;
            }
        }
        return max;
    }

    /**
     * 8.
     *
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     *
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
     *
     * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
     * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
     *
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
     *
     * 提示：
     *
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     *  
     *
     * 示例 1:
     *
     * 输入: "42"
     * 输出: 42
     * 示例 2:
     *
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     * 示例 3:
     *
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     * 示例 4:
     *
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     *      因此无法执行有效的转换。
     * 示例 5:
     *
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     *      因此返回 INT_MIN (−231) 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param str
     * @return
     */

    public int myAtoi(String str) {
        str = str.trim();
        int length = str.length();
        boolean first = true;
        boolean isFu = false;
        int start = -1 , end = -1;
        for(int i=0; i<length; i++) {
            char c = str.charAt(i);
            if(c == ' ' && first) {
                continue;
            }
            if( c== '-' && first) {
                isFu = true;
                first = false;
            } else if(c == '+' && first) {
                first = false;
            }
            else if( c>='0' && c <='9') {
                if(start == -1)
                    start = i;
                end = i + 1;
                first = false;
            } else {
                end = i;
                break;
            }
        }
        if(start == -1) {
            return 0;
        }

        String  integer = str.substring(start, end);
        int k = 0;
        try {
            k =Integer.parseInt(integer);
        }catch(Exception e) {
            return isFu?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
        return isFu? (0-k) : k;

    }

    /**
     * 6.
     *
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     * 示例 1:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     *
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param numRows
     * @return
     *
     * 解法，找规律。横排的字符串是有规律的。记住对s.charAt(index)中的index做检查
     */

    public String convert(String s, int numRows) {
        if(s == null || numRows == 1) {
            return s;
        }
        int len = s.length();
        StringBuilder ret = new StringBuilder("");
        int skip = numRows * 2 -2;//4

        //一行一行的组合字符串，现在是第i行。
        for(int i=0; i<numRows; i++) {
            int index = i; //i=1
            //循环条件，以中间那个字符串为结束标准，因为固定列的字符可能已经超出了s的范围。
            //从循环中也看出来，index-2i是可能用到的最小的s的下标值。
            while(index - 2*i < len) {
                if(i == 0 || i == numRows -1) {
                    //第一行和最后一行中间没有其他字符串。
                    if(index < len) {
                        ret.append(s.charAt(index));
                    }
                } else {
                    //其他行是每隔固定列中间会有一个字符串。
                    if(index - 2*i >=0) {
                        ret.append(s.charAt(index - 2*i)); //2
                    }
                    if(index < len) {
                        ret.append(s.charAt(index));//PAHNA
                    }
                }

                index += skip; // 4
            }
        }
//            "PINALSIGYAHRPI"
//             PINALSIGYAHRPI                                            PI
        return ret.toString();
    }

    /**
     * 5.
     *
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     *
     * 解法：
     * babad -> #b#a#b#a#d#
     * 依次为中心点，向两边扩散。找到最大长度的起点和长度，最后截取
     */

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        String result = insertChar(s);
        int length = result.length();
        int begin = 0;
        int len = 1;
        for(int i=1; i<length-1; i++) {
            int left = i-1;
            int right = i + 1;
            while(left >=0 && right < length
                    && result.charAt(left) == result.charAt(right)) {
                left --;
                right++;
            }
            right--;
            left++;
            int curLen = (right-left)/2;
            if(len < curLen) {
                len = curLen;
                begin = left/2;
            }
        }

        return s.substring(begin, begin + len);


    }

    public String insertChar(String s) {
        int length = s.length();
        StringBuilder ret = new StringBuilder("#");
        for(int i=0; i<length; i++) {
            ret.append(s.charAt(i) + "#");
        }
        return ret.toString();
    }

    /**
     * 3.
     *
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */

    public int lengthOfLongestSubstring(String s) {
        int[] all = new int[128];
        int ret = 0;
        for(int i=0, j=0; j<s.length();j++) {
            i = Math.max(all[s.charAt(j)], i);
            ret = Math.max(ret, j - i +1);
            all[s.charAt(j)] = j +1;
        }
        return ret;
    }

    /**
     * 2.
     *
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode retPre = new ListNode(-1);
        ListNode realRetPre = retPre;
        int k = 0;
        while(l1 != null || l2 != null) {
            int a = 0;
            int b = 0;
            if(l1 != null){
                a = l1.val;
            }
            if(l2 != null) {
                b = l2.val;
            }
            int sum = a + b + k;
            retPre.next = new ListNode(sum % 10);
            k = sum/10;
            retPre = retPre.next;
            if(l1 != null)  {
                l1 = l1.next;
            }

            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(k != 0) {
            retPre.next = new ListNode(k);
        }
        return realRetPre.next;
    }
}
