package com.company;

import java.util.*;


public class Main {
    // private


    // main
    public static void main(String[] args) {
        int n = 3;
        String res = "0";
        for(int i = 0; i < n; i++) {
            res += complement(res);
        }
        System.out.println();

    }

    // function
    public static String complement(String str) {
        int pos = 0;
        String res = "";
        while(pos < str.length()) {
            if(str.charAt(pos) == '0') {
                res += "1";
            } else {
                res += "0";
            }
            pos++;
        }
        return res;
    }

}







