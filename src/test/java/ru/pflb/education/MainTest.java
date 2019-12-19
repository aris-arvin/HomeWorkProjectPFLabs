package ru.pflb.education;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTest {
    Main main = new Main();

    @BeforeClass
    public void setUp(){
        main = new Main();
    }

    @BeforeMethod
    public void showThread(){
        System.out.println((Thread.currentThread().getId()));
    }

    @DataProvider(name = "LongToBinary")
    public Object[][] dtb(){
        return new Object[][]{
                {269, "100001101"},{568, "1000111000"},{10000, "10011100010000"}
        };
    }

    @Test(description = "Checking parsing from decimal to binary", dataProvider = "LongToBinary")
    public void testBinary(long a, String exResult){
        Assert.assertEquals(main.convertToBinary(a), exResult);
    }

    @DataProvider(name = "LongToHex")
    public Object[][] dth(){
        return new Object[][]{
                {300, "12c"},{3456, "d80"},{666, "29a"}
        };
    }

    @Test(description = "Checking parsing from decimal to hex", dataProvider = "LongToHex")
    public void testHex(long a, String exResult){
        Assert.assertEquals(main.convertToHex(a), exResult);
    }

    @DataProvider(name = "BinaryToOctal")
    public Object[][] bto(){
        return new Object[][]{
                {"10000000", "200"},{"010011", "23"},{"100100110", "446"}
        };
    }

    @Test(description = "Checking parsing from binary to oktal", dataProvider = "BinaryToOctal")
    public void testBinaryToOctal(String a, String exResult){
        Assert.assertEquals(main.convertToOctal(a), exResult);
    }

    @DataProvider(name = "StringIsNumber")
    public Object[] sin(){
        return new Object[]{
                "15b", "6653", "110110101011"
        };
    }

    @Test(description = "Checking String is number", dataProvider = "StringIsNumber")
    public void testString(String str){
        Assert.assertTrue(Main.checkNumber(str));
    }





}
