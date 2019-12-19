package ru.pflb.education;

import org.apache.commons.lang3.math.NumberUtils;

public class Main {


    public String convertToBinary(long a){
        return Long.toBinaryString(a);
    }
    public String convertToHex(long a){
        return Long.toHexString(a);
    }
    public String convertToOctal(String binar){
        return Long.toOctalString(Integer.parseInt(binar, 2));
    }

    public static boolean checkNumber(String b){
        if (b.matches("^[0-9A-Fa-f]+$")){
            return NumberUtils.isCreatable(Long.toBinaryString(Long.parseLong(b.substring(2), 16)));
        }
        else return NumberUtils.isCreatable(b);
    }
}
