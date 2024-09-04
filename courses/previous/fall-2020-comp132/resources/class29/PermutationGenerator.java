package examples.recursion;

import java.util.*;

/**
 * Generates a list of all of the permutations of the characters of a given
 * string.
 * 
 * @author Grant Braught, revisions by Farhan Siddiqui
 * @author Dickinson College
 * @version Aug 10, 2019
 */
public class PermutationGenerator {

    /**
     * Generate all of the permutations of the characters in the specified
     * String.
     * 
     * @param str the string of characters to permute.
     * @return the permutations of the characters in str.
     */
    public static ArrayList<String> generatePermutations(String str) {
        ArrayList<String> perms = new ArrayList<String>();

        if (str.length() == 1) {
            // since there is only one character so it is its only permutation.
            perms.add(str);
            return perms;
        }
        else {
            /*
             * for each character X in s, get the permutations of all of the
             * other characters and then prepend X. E.g. for ABC we prepend A
             * onto BC and CB, then prepend B onto AC and CA and finally prepend
             * C onto AB and BA.
             */
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                String subStr = str.substring(0, i) + str.substring(i + 1);
                ArrayList<String> subPerms = generatePermutations(subStr);
                for (String sp : subPerms) {
                    perms.add(new String(c + sp));
                }
            }

            return perms;
        }
    }

    /**
     * Generate and print all permutations of a given string.
     */
    public static void main(String[] args) {

        ArrayList<String> perms = generatePermutations("ABC");
        
        for (String s : perms) {
            System.out.println(s);
        }
    }
}
