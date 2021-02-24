/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitshuffle;

import java.util.HashMap;

/**
 *
 * @author venki
 */
public interface NumericalOperation {
    
    int HEXADECIMAL_BASE = 16;
    int BYTE_LENGTH = 8;
    int HALF_BYTE_LENGTH = BYTE_LENGTH / 2;
    int TRINARY_BASE = 3;
    
    
    default int convertHextoDec(String hex_encrpyt) {
        int trinary_num = 0;
        int power_length = hex_encrpyt.length() - 1;
        HashMap<Character, Integer> hexa_base = BitShuffle.initHashmap();
        for (char digit : hex_encrpyt.toCharArray()) {
            int digit_value;
            if ((digit == 'a')
                    || (digit == 'b')
                    || (digit == 'c')
                    || (digit == 'd')
                    || (digit == 'e')
                    || (digit == 'f')) {
                digit_value = hexa_base.get(digit);
            } else {
                digit_value = Integer.parseInt("" + digit);
            }
            trinary_num += (digit_value * Math.pow(HEXADECIMAL_BASE, power_length--));
        }
        return trinary_num;
    }
    
    
    default int convertTrinary(int octal_encrypt) {
        int quotient;
        int updated_num = octal_encrypt;
        if (octal_encrypt < TRINARY_BASE) {
            return octal_encrypt;
        }
        String trinary = "";
        do {
            quotient = updated_num / TRINARY_BASE;
            int reminder = updated_num % TRINARY_BASE;
            trinary += reminder;
            updated_num = quotient;
        } while (quotient >= TRINARY_BASE);
        trinary += quotient;
        int trinary_long = Integer.parseInt(new StringBuilder(trinary).reverse().toString());
        return trinary_long;
    }

    default int convertTrinaryToNum(int decrypt_int) {
        String decrypt_num = Integer.toString(decrypt_int);
        int power_length = decrypt_num.length() - 1;
        int octal_int = 0;
        for (char digit : decrypt_num.toCharArray()) {
            octal_int += (Integer.parseInt("" + digit) * Math.pow(TRINARY_BASE, power_length--));
        }
        return octal_int;
    }

    
}
