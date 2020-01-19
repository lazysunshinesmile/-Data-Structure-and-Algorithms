package com.sun.sort.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class ContactHashMap implements Comparable<ContactHashMap>{

    public static void main(String[] args) {
        ContactHashMap contactHashMap = new ContactHashMap();
        ContactHashMap contactHashMap2 = new ContactHashMap();
        List<ContactHashMap> l = new ArrayList<>();
        l.add(contactHashMap);
        l.add(contactHashMap2);
        Collections.sort(l);
    }
    public interface Type {
        int SYMBOL = 1;
        int CHINESE = 2;
        int LETTER = 3;
        int NUMBER = 4;
    }

    private HashMap<String, Object> mMap;

    public HashMap<String, Object> getMap() {
        return mMap;
    }

    public void setMap(HashMap<String, Object> map) {
        this.mMap = map;
    }

    public ContactHashMap() {
    }

    /**
     * jdk1.7必须满足
     * a). sgn(compare(x, y)) == -sgn(compare(y, x))
     * b). (compare(x, y)>0) && (compare(y, z)>0) 意味着compare(x, z)>0
     * c). compare(x, y)==0 意味着对于任意的z：sgn(compare(x, z))==sgn(compare(y,z)) 均成立
     */
    @Override
    public int compareTo(ContactHashMap o) {


        if(o == null) return -1;
        HashMap<String, Object> map = this.getMap();
        HashMap<String, Object> compareMap = o.getMap();
        if(map == null && compareMap == null)
            return 0;
        if(map == null)
            return 1;
        if(compareMap == null)
            return -1;
        String namePinyin = (String) map.get("pinyin");
        String comparePinyin = (String) compareMap.get("pinyin");
        if(isEmpty(namePinyin) && isEmpty(comparePinyin))
            return 0;
        if(isEmpty(namePinyin))
            return 1;
        if(isEmpty(comparePinyin))
            return -1;
        //jdk1.7之后compare方法的实现必须覆盖大于0、小于0和等于0三种情况，否则会抛出llegalArgumentException
        return namePinyin.compareToIgnoreCase(comparePinyin);
    }


    private boolean isEmpty(String s) {
        if(s == null || "".equals(s)) {
            return true;
        }
        return false;
    }

    private int compareT9(String sortKeyT9, String compareT9) {
        if(sortKeyT9 == null && compareT9 == null)
            return 0;
        if(sortKeyT9 == null)
            return 1;
        if(compareT9 == null)
            return -1;

        if (sortKeyT9.compareToIgnoreCase(compareT9)<0){
            return -1;
        }
        return 1;
    }

}
