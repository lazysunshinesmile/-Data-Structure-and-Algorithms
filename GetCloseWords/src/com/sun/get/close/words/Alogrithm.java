package com.sun.get.close.words;

import java.util.*;

public class Alogrithm {
    private void update(Map<Object, List<String>> m, Object key, String value) {
        List<String> lst = m.get(key);
        if(lst == null) {
            lst = new ArrayList<>();
            m.put(key, lst);
        }
        lst.add(value);
    }



    public Map<Object, List<String>> computeAdjacentWords(List<String> words) {
        Map<Object, List<String>> adjwords = new HashMap<>();
        Map<Object, List<String>> wordsByLength = new HashMap<>();

        for(String w : words)
            update(wordsByLength, w.length(), w);

        for(Map.Entry<Object, List<String>> entry : wordsByLength.entrySet()) {
            List<String> groupwords = entry.getValue();
            int groupNum = (Integer) entry.getKey();


            for(int i =0; i< groupNum; i++) {
                Map<Object, List<String>> repToWord = new HashMap<>();
                for(String str :groupwords) {
                    String rep = str.substring(0 ,i) + str.substring(i+1);
                    update(repToWord, rep,str);
                }

                for(List<String> wordClique: repToWord.values()) {
                    if(wordClique.size() >= 2) {
                        for(String s1 : wordClique)
                            for(String s2: wordClique) {
                                if(s1 != s2) {
                                    update( adjwords, s1, s2);
                                }
                            }
                    }
                }

            }

        }
        return adjwords;
    }

    public Map<Object, List<String>> myComputeAdjacentWords(List<String> words) {
        Map<Object, List<String>> ret = new HashMap<>();

        //根据长度划分的Map
        Map<Object, List<String>> stringMapByLength = new HashMap<>();

        for(String word: words) {
            update(stringMapByLength, word.length(), word);
        }

        for(Object key : stringMapByLength.keySet()) {
            //num代表字符串长度
            int num = (Integer)key;
            //value 代表这个长度的所有字符串
            List<String> value = stringMapByLength.get(num);
            //依次删除字符串的某一个字母，并放到一个map中去。
            //删除第一个字符，sun ==> un ,soa ==> oa, 剩下的如果相同，就放到一个key对应的list中。
            for(int i= 0; i< num; i++) {

                //abc ==>{ "so":[soa,sob,soc]}
                Map<Object, List<String>> abc = new HashMap<>();
                for(String str : value) {
                    String str2 = str.substring(0, i) + str.substring(i+1);
                    update(abc, str2, str);
                }

                //val ==> [soa, sob, soc]
                for(List<String> val : abc.values()) {
                    if(val.size() < 2)
                        continue;
                    for(int j = 0; j< val.size();j++) {
                        for( int m = 0; m< val.size();m++) {
                            if(j != m) {
                                update(ret, val.get(j), val.get(m));
                            }
                        }
                    }
                }
            }


        }

        return ret;



    }
}
