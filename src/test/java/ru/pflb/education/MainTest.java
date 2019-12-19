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

    @DataProvider(name = "LongToBinary", parrallel = true)
    public Object[][] dtb(){
        return new Object[][]{
                {269, "101010"},{568, "1000111000"},{10000, "10011100010000"}
        };
    }

    @Test(description = "Checking parsing from decimal to binary", dataProvider = "LongToBinary")
    public void testBinary(long a, String exResult){
        Assert.assertEquals(main.convertToBinary(a), exResult);
    }

    @DataProvider(name = "LongToHex", parrallel = true)
    public Object[][] dth(){
        return new Object[][]{
                {300, "12C"},{3456, "D80"},{666, "29A"}
        };
    }

    @Test(description = "Checking parsing from decimal to hex", dataProvider = "LongToHex")
    public void testHex(long a, String exResult){
        Assert.assertEquals(main.convertToHex(a), exResult);
    }

    @DataProvider(name = "BinaryToOctal", parrallel = true)
    public Object[][] bto(){
        return new Object[][]{
                {"10000000", "200"},{"010011", "23"},{"100100110", "446"}
        };
    }

    @Test(description = "Checking parsing from binary to oktal", dataProvider = "BinaryToOctal")
    public void testBinaryToOctal(String a, String exResult){
        Assert.assertEquals(main.convertToOctal(a), exResult);
    }

    @DataProvider(name = "StringIsNumber", parrallel = true)
    public Object[] sin(){
        return new Object[]{
                "DAB", "6653", "110110101011"
        };
    }

    @Test(description = "Checking String is number", dataProvider = "StringIsNumber")
    public void testString(String str){
        Assert.assertTrue(Main.checkNumber(str));
    }





}
