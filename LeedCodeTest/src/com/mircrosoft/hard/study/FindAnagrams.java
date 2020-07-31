package com.mircrosoft.hard.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        HashMap<Character, Integer> charsCount = new HashMap<>();
        HashMap<Character, Integer> hasFound = new HashMap<>();
        HashMap<Character, Integer> startIndex = new HashMap<>();

        //初始化
        for(int i=0;i<p.length();i++) {
            char c = p.charAt(i);
            if(charsCount.containsKey(c)) {
                charsCount.put(c, charsCount.get(c)+1);
            } else {
                charsCount.put(c, 1);
            }

//            if(!startIndex.containsKey(c)) {
//                startIndex.put(c, i);
//            }
        }

        int start = 0;
        for(int i=0; i<s.length(); i++) {
            String c = s.charAt(i) + "";
            boolean isOK = true;
            char ch = c.charAt(0);
            if(p.contains(c)
                    && (hasFound.get(c.charAt(0)) == null || hasFound.get(c.charAt(0))<
                    charsCount.get(c.charAt(0)))) {
                if(hasFound.get(c.charAt(0)) == null) {
                    hasFound.put(c.charAt(0), 1);
                } else {
                    hasFound.put(c.charAt(0), hasFound.get(c.charAt(0)) + 1);
                }

                if(!startIndex.containsKey(c.charAt(0))) {
                    startIndex.put(c.charAt(0), i);
                }

                for(Character key: charsCount.keySet()) {
                    if(hasFound.get(key) == null || charsCount.get(key) > hasFound.get(key)) {
                        isOK = false;
                        break;
                    }
                }

                if(!isOK) {
                    continue;
                } else {
                    ret.add(start);
                    hasFound.put(s.charAt(start), hasFound.get(s.charAt(start) -1));
//                    hasFound.clear();
                    //改变起点
                    startIndex.remove(s.charAt(start));
                    for(int pp = start+1;pp<start + p.length();pp++) {
                        if(s.charAt(pp) == s.charAt(start)) {
                            startIndex.put(s.charAt(start), pp);
                            break;
                        }
                    }
                    start++;
                }
            } else {
                if(p.contains(c)) {
                    if(!startIndex.containsKey(c.charAt(0))) {
                        startIndex.put(c.charAt(0), i);
                    } else {
                        start = startIndex.get(c.charAt(0)) + 1;
                    }
                    continue;
                } else {
                    //没有这个字母
                    start = i+1;
                    hasFound.clear();
                    startIndex.clear();
                }
            }


        }





        return ret;
    }
}
