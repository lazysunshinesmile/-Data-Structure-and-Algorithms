package com.mircrosoft.hard.study;


import java.util.*;

public class TestMain {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        [1556913,-259675,-7667451,-4380629,-4643857,-1436369,7695949,-4357992,-842512,-118463]
//        -9681425
//        System.out.println(solution.numSubmatrixSumTarget(new int[][]{{0,1,0},{1,1,1},{0,1,0}}, 0));
//        System.out.println(solution.numSubmatrixSumTarget(new int[][]{{0,0,0,1,1},{1,1,1,0,1},{1,1,1,1,0},{0,0,0,1,0},{0,0,0,1,1}}, 0));
//        System.out.println(solution.confusingNumberII(1000000000));//226
//
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(9999999999l);

//        System.out.println(solution.minimumLength("cabaabac"));
//        System.out.println(solution.minimumLength("cd"));
//        System.out.println(solution.minimumLength("ada"));
//        System.out.println(solution.minimumLength("aabccabba"));
//        System.out.println(solution.minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
//        System.out.println("x");
//        System.out.println(solution.minimumLength("aaaadaa"));
//        System.out.println(solution.minimumLength("aaaa"));
//        System.out.println(solution.minimumLength("aaghaa"));
//        System.out.println(solution.maxValue(new int[][]{{74,91,40}},1));
        System.out.println(solution.maxValue(new int[][]{
                        {21,77,43},
                        {2,74,47},
                        {6,59,22},
                        {47,47,38},
                        {13,74,57},
                        {27,55,27},
                        {8,15,8}}
                ,4));
//        System.out.println(solution.maxValue(new int[][]{{1,2,4},{3,4,3},{2,3,1}},2));
//        System.out.println(solution.maxValue(new int[][]{{1,2,4},{3,4,3},{2,3,10}},2));
//        System.out.println(solution.maxValue(new int[][]{{1,1,4},{2,2,3},{3,3,10}},2));
//        57
//        7
//        10
//        14
    }


    private static void print(int[][] ret) {
        for (int i=0; i<ret.length; i++) {
            System.out.println(Arrays.toString(ret[i]));
        }
    }

    public static class MinSegmentTree {
        private ArrayList<Integer> minSegmentTree;
        private int n;

        public MinSegmentTree(int[] arr) {
            n = arr.length;
            minSegmentTree = new ArrayList<>(2 * n);

            for  (int i = 0; i < n; i++) {
                minSegmentTree.add(0);
            }

            for (int i = 0; i < n; i++) {
                minSegmentTree.add(arr[i]);
            }

            for (int i = n - 1; i > 0; i--) {
                minSegmentTree.set(i, Math.min(minSegmentTree.get(2 * i), minSegmentTree.get(2 * i + 1)));
            }
        }

        public void update(int i, int value) {
            i += n;
            minSegmentTree.set(i,  value);

            while (i > 1) {
                i /= 2;
                minSegmentTree.set(i, Math.min(minSegmentTree.get(2 * i), minSegmentTree.get(2 * i + 1)));
            }
        }


        public int minimum(int left, int right) {
            left += n;
            right += n;
            int min = Integer.MAX_VALUE;

            while (left < right) {
                if ((left & 1) == 1) {
                    min = Math.min(min, minSegmentTree.get(left));
                    left++;
                }

                if ((right & 1) == 1) {
                    min = Math.min(min,  minSegmentTree.get(right));
                    right--;
                }
                left >>= 1;
                right >>= 1;
            }

            return min;
        }
    }

    static class ThroneInheritance {
        static  class Person {
            public Person(String name, int identiy) {
                this.name = name;
                this.identiy = identiy;
            }

            public int identiy = 0; //0国王 1 是儿子 2 是孙子
            public boolean isDeath = false;
            public String  name;
            public Person next;


            public boolean equals(Person p, int identiy) {
                return this.name.equals(p.name);
            }

            public String toString() {
                return "name:" + name + ", identiy:" + identiy + ", isDeath:" + isDeath
                        + ", next:" + next.name;
            }
        }

        HashMap<String, Person> mAlls = new HashMap<>();

        Person mKing;
        public ThroneInheritance(String kingName) {
            mKing = new Person(kingName, 0);
            mAlls.put(kingName, mKing);
        }

        public void birth(String parentName, String childName) {
            Person parent = mAlls.get(parentName);
            Person child = new Person(childName, parent.identiy-1);
            mAlls.put(childName, child);
//            if(parent.next == null) {
//                parent.next = child;
//            } else if(parent.next.identiy >= parent.identiy) {
//                child.next = parent.next;
//                parent.next = child;
//            } else if(parent.identiy > parent.next.identiy) {
//                while(parent != null && parent.next != null && parent.next.identiy <= parent.identiy) {
//                    parent = parent.next;
//                }
//
//                if(parent.next == null) {
//                    parent.next = child;
//                } else {
//                    child.next = parent.next;
//                    parent.next = child;
//                }
//            }
            /*if(parent.identiy == 0) {
                while(parent.next != null ) {
                    parent = parent.next;
                }
                parent.next = child;
            } else if(parent.identiy == -1)*/
            int parentIdnetiy = parent.identiy;
                while (parent.next != null && parent.next.identiy < parentIdnetiy) {
                    parent = parent.next;
                }
                child.next = parent.next;
                parent.next = child;
        }
//[null,null,null,null,null,null,
//        ["king","logan","leonard","hosea","carl","ronda"],null,null,null,["king","logan","hosea","carl","ronda","betty","helen"],null,null,["king","logan","hosea","alfred","carl","ronda","helen"],["king","logan","hosea","alfred","carl","ronda","helen"]]
        public void death(String name) {
            mAlls.get(name).isDeath = true;
        }

        public List<String> getInheritanceOrder() {
            Person p = mKing;
            List<String> ret = new LinkedList<>();
            while(p != null) {
                if(!p.isDeath) {
                    ret.add(p.name);
                }
                p = p.next;
            }
            return ret;
        }
    }
}
