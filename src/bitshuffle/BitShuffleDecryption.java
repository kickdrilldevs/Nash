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
public class BitShuffleDecryption extends BitShuffle implements NumericalOperation{
    
    public String stringDecryption(String hex_encr){
        String hex_decr = "";
        for (String hex_ecr : hex_encr.split("-")) {
            after_left_shift = "";
            after_right_shift = "";
            hex_decr += doDecryption(hex_ecr);         
        }
        return hex_decr;
    }
    
    private String doDecryption(String hex_encrpyt) {
        int trinary_num = convertHextoDec(hex_encrpyt);
        int octal_encrypt = convertTrinaryToNum(trinary_num);
        int encrypt_decimal = Integer.parseInt(Integer.toString(octal_encrypt), 8);
        String binary_decrypt = Integer.toBinaryString(encrypt_decimal);
        binary_decrypt = makeBinaryStringAsByte(binary_decrypt);
        divideByteShiftWise(binary_decrypt);
        String decrypt_binary = doBitShuffle();
        char decrypt_char = (char) Integer.parseInt(decrypt_binary, 2);
        return "" + decrypt_char;
    }
    
}
