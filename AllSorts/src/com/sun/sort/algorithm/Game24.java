package com.sun.sort.algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Game24 {

    public static void main(String[] args) {
        Game24 game24 = new Game24();
        //0010, 1101
        LinkedList data = new LinkedList();
         data.add(3d);
         data.add(4d);
         data.add(6d);
         data.add(7d);
         StringBuffer s = new StringBuffer(data.get(0)+"");
        System.out.println(game24.compute(data));
//        System.out.println(s.toString());
    }

    //暴力解法
    public boolean compute(LinkedList<Double> data) {
        if(data.size() == 0)
            return false;
        if(data.size() == 1) {
            return Math.abs(data.get(0) - 24) < 1e-6;
        }

        for(int i=0; i<data.size();i++) {
            for (int j=0;j<data.size();j++) {
                Double a = data.get(i);
                Double b = data.get(j);

                if(i==j) {
                    continue;
                }
//                ArrayList<Double> data2 = new ArrayList<>(data);
//                data2.remove(a);
//                data2.remove(b);

                LinkedList<Double> data2 = new LinkedList<>();
                for(int k=0;k<data.size();k++) {
                    if(k!=i && k!=j) {
                        data2.add(data.get(k));
                    }
                }


                for(int k = 0; k<4;k++) {
                    if(k == 0) {
                        data2.add(a +b);
                    }
                    if(k == 1) {
                        data2.add(a-b);
                    }
                    if(k == 2) {
                        data2.add(a*b);
                    }
                    if(k == 3) {
                        if(b!=0) {
                            data2.add(a/b);
                        }else{
                            continue;
                        }
                    }
                    if(compute(data2)) {
                        return true;
                    }
                    data2.remove(data2.size()-1);
                }


            }
        }
        return false;

    }
}
