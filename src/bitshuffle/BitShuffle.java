/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitshuffle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author venki
 */
public class BitShuffle implements NumericalOperation{

    

    /**
     * @param args the command line arguments
     */
    ArrayList<PairBit> pairs;

    String after_left_shift = "";
    String after_right_shift = "";

    

    public String makeBinaryStringAsByte(String before_binary_encrypt) {
        String trail_str = "";
        for (int strt = 0; strt < BYTE_LENGTH - before_binary_encrypt.length(); strt++) {
            trail_str += "0";
        }
        return trail_str + before_binary_encrypt;
    }

    public ArrayList<PairBit> createPairs() {
        ArrayList<PairBit> pairs = new ArrayList<>();
        for (int one = 0; one < HALF_BYTE_LENGTH - 1; one++) {
            for (int second = one + 1; second < HALF_BYTE_LENGTH; second++) {
                if (one != second) {
                    PairBit pairBit = new PairBit();
                    pairBit.onebit = one;
                    pairBit.secondbit = second;
                    pairs.add(pairBit);
                }
            }
        }
        return pairs;
    }

    public String doBitShuffle() {
        char[] left_bit_list = after_left_shift.toCharArray();
        char[] right_bit_list = after_right_shift.toCharArray();

        for (PairBit pairBit : pairs) {

            if (left_bit_list[pairBit.onebit] != left_bit_list[pairBit.secondbit]) {
                char swap_one = left_bit_list[pairBit.onebit];
                char swap_two = left_bit_list[pairBit.secondbit];
                left_bit_list[pairBit.onebit] = swap_two;
                left_bit_list[pairBit.secondbit] = swap_one;
            }
            if (right_bit_list[pairBit.onebit] != right_bit_list[pairBit.secondbit]) {
                char swap_one = right_bit_list[pairBit.onebit];
                char swap_two = right_bit_list[pairBit.secondbit];
                right_bit_list[pairBit.onebit] = swap_two;
                right_bit_list[pairBit.secondbit] = swap_one;
            }
        }
        after_left_shift = new String(left_bit_list);
        after_right_shift = new String(right_bit_list);
        return after_right_shift + after_left_shift;
    }

    public void divideByteShiftWise(String before_binary_encrypt) {
        int bit_index = 0;
        for (char bit_char : before_binary_encrypt.toCharArray()) {
            if (bit_index < HALF_BYTE_LENGTH) {
                after_left_shift += "" + bit_char;
            } else {
                after_right_shift += "" + bit_char;
            }
            bit_index++;
        }
    }

    public static HashMap<Character, Integer> initHashmap() {
        HashMap<Character, Integer> hexa_base = new HashMap<>();
        hexa_base.put('a', 10);
        hexa_base.put('b', 11);
        hexa_base.put('c', 12);
        hexa_base.put('d', 13);
        hexa_base.put('e', 14);
        hexa_base.put('f', 15);
        return hexa_base;
    }
}
