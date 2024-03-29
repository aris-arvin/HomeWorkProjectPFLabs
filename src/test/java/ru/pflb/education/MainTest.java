package ru.pflb.education;

import org.apache.commons.lang3.math.NumberUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTest {
    Main main;

    @BeforeClass
    public void setUp(){
        main = new Main();
    }

    @BeforeMethod
    public void showThread(){
        System.out.println((Thread.currentThread().getId()));
    }

    @DataProvider(name = "LongToBinary")
    public Object[][] longToBinary(){
        return new Object[][]{
                {269, "100001101"},{568, "1000111000"},{10000, "10011100010000"}
        };
    }

    @Test(description = "Checking parsing from decimal to binary", dataProvider = "LongToBinary")
    public void testBinary(long a, String exResult){

        Assert.assertEquals(main.convertToBinary(a), exResult);
    }

    @DataProvider(name = "LongToHex")
    public Object[][] longToHex(){
        return new Object[][]{
                {300, "12c"},{3456, "d80"},{666, "29a"}
        };
    }

    @Test(description = "Checking parsing from decimal to hex", dataProvider = "LongToHex")
    public void testHex(long a, String exResult){
        Assert.assertEquals(main.convertToHex(a), exResult);
    }

    @DataProvider(name = "BinaryToOctal")
    public Object[][] binaryToOctal(){
        return new Object[][]{
                {"10000000", "200"},{"010011", "23"},{"100100110", "446"}
        };
    }

    @Test(description = "Checking parsing from binary to oktal", dataProvider = "BinaryToOctal")
    public void testBinaryToOctal(String a, String exResult){

        Assert.assertEquals(main.convertToOctal(a), exResult);
    }

    @DataProvider(name = "StringIsNumber")
    public Object[] stringIsNumber(){
        return new Object[]{
                "0xff", "6653", "110110101011", "3BF16D41"
        };
    }

    @Test(description = "Checking String is number", dataProvider = "StringIsNumber")
    public void testString(String str){
        Assert.assertTrue(Main.checkNumber(str));
    }

    // Nevative check

    @DataProvider(name = "StringIsNotNumber")
    public Object[] checkNegativeStrings(){
        return new Object[]{
                "", "advm", " 888 88", " ", "-345g", "gmg", "null", "nan"
        };
    }

    @Test(description = "Checking String of Binary is not number", dataProvider = "StringIsNotNumber", expectedExceptions = NumberFormatException.class)
    public void testNegativeBinaryStrings(String stringIsNotNumber){
        main.convertToOctal(stringIsNotNumber);
    }
}
