package com.sun.sort.algorithm;

public class MaxArea {

    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(height));
    }
    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0; i<height.length;i++) {
            for(int j = i+1;j<height.length;j++) {
                int h = height[i] <height[j] ? height[i]:height[j];
                max = max > (j-i) * h ?max :(j-i)*h;
            }
        }

        return max;
    }
}
