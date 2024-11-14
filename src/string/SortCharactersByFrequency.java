package string;

import java.util.LinkedList;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String str) {
        int[] arr = new int[122];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }

        LinkedList<Pair> freqList = new LinkedList<Pair>();

        for (int i = 48; i < 122; i++) {
            if(arr[i]>0){
                freqList.add(new Pair((char) i, arr[i]));
            }
        }

        freqList.sort((o1, o2) -> o2.count - o1.count);

        StringBuilder ansString = new StringBuilder();
        for(Pair p : freqList){
            while(p.count-->0){
                ansString.append(p.ch);
            }
        }
        return ansString.toString();
    }

    static class Pair{
        char ch ;
        int count ;
        Pair(char ch,int count){
            this.ch = ch;
            this.count = count;
        }
    }
}
