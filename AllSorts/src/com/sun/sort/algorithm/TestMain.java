package com.sun.sort.algorithm;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        TestMain testMain = new TestMain();

        List<Son> sons = new ArrayList<>();
        sons.add(new Son());
        sons.add(new Son());
        sons.add(new Son());
        testMain.getName(sons);
    }

    private void getName(List<? extends Parent> parents) {
        for(Parent t : parents) {
            System.out.println(t.getName());
        }
    }

    static class Parent {
        public String getName() {
            return "Parent";
        }
    }

    static class Son extends Parent {
        public String getName() {
            return "Son";
        }
    }
}
