/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitshuffle;

/**
 *
 * @author venki
 */
public class BitShuffleEncryption extends BitShuffle{
    
    public String stringEncryption(String hex_encr){
        int char_index = 0;
        for (char scrchar : hex_encr.toCharArray()) {
            after_left_shift = "";
            after_right_shift = "";
            if (char_index == hex_encr.toCharArray().length - 1) {
                hex_encr += doEncryption(scrchar);
            } else {
                hex_encr += doEncryption(scrchar) + "-";
            }
            char_index++;
        }
        return hex_encr;
    }
    
    private String doEncryption(char scrchar) {
        int ascii_char = scrchar;
        String before_binary_encrypt = Integer.toBinaryString(ascii_char);
        before_binary_encrypt = makeBinaryStringAsByte(before_binary_encrypt);
        divideByteShiftWise(before_binary_encrypt);
        pairs = createPairs();
        String bit_shuffle = doBitShuffle();
        String hex_encrypt = calculatedChar(bit_shuffle);
        return hex_encrypt;
    }
    
    public String calculatedChar(String bit_shuffle) {
        int encrypt_num = Integer.parseInt(bit_shuffle, 2);
        String encrypt_octal = Integer.toOctalString(encrypt_num);
        int octal_encrypt = Integer.parseInt(encrypt_octal);
        int trinary_num = convertTrinary(octal_encrypt);
        String hex_num = Integer.toHexString(trinary_num);
        return hex_num;
    }
    
}
