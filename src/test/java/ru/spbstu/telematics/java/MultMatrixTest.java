package ru.spbstu.telematics.java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;

import java.io.File;
import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class MultMatrixTest extends TestCase  {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MultMatrixTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(MultMatrixTest.class);
    }
    private static int[][] readFileArr(String filename, int col, int row)throws Exception{
        Scanner scanner = new Scanner(new File(filename));
        int[] tall = new int[col * row];
        int i = 0;
        while (scanner.hasNextInt()) {
            tall[i++] = scanner.nextInt();
        }

        int[][] result = new int[col][row];
        for(int k = 0; k < col; k++){
            for(int l = 0; l < row; l++){
                result[k][l] = tall[k*row +l];
            }
        }
        return result;
    }

    private static void printArr(int num, ArrClass arr1, ArrClass arr2, ArrClass res, ArrClass check){
        System.out.println("\n\nТест" + num + ":");
        System.out.println("Первый массив:");
        for(int i = 0; i < arr1.getCol(); i++) {
            for (int j = 0; j < arr1.getRow(); j++) {
                System.out.print(arr1.arr[i][j] + "\t ");
            }
            System.out.print("\n");
        }

        System.out.println("Второй массив:");
        for(int i = 0; i < arr2.getCol(); i++) {
            for (int j = 0; j < arr2.getRow(); j++) {
                System.out.print(arr2.arr[i][j] + "\t ");
            }
            System.out.print("\n");
        }

        System.out.println("Результат:");
        if(res == null) {
            System.out.print("Неверная размерность массива!");
            Assert.assertEquals(check, res);
        }
        else {
            for (int i = 0; i < res.getCol(); i++) {
                for (int j = 0; j < res.getRow(); j++) {
                    System.out.print(res.arr[i][j] + "\t ");
                }
                System.out.print("\n");
            }
            Assert.assertArrayEquals(check.arr, res.arr);
        }

    }




    String path = new File("src\\main\\resource").getAbsolutePath();


    /**
     * Rigourous Test :-)
     */
    public void testMult1() throws Exception{
        ArrClass arr1 = new ArrClass(5,6);
        ArrClass arr2 = new ArrClass(6,3);

        arr1.arr = readFileArr(path+"\\arr_5_6.txt", arr1.getCol(), arr1.getRow());
        arr2.arr = readFileArr(path+"\\arr_6_3.txt", arr2.getCol(), arr2.getRow());

        ArrClass check = new ArrClass(5,3);
        check.arr = readFileArr(path + "\\check_5_3.txt", check.getCol(), check.getRow());
        printArr(1,arr1, arr2,MultMatrix.multMatr(arr1,arr2),check);
        }

    public void testMult2() throws Exception{
        ArrClass arr1 = new ArrClass(4,4);
        ArrClass arr2 = new ArrClass(4,4);
        arr1.arr = readFileArr(path + "\\arr_4_4.txt", arr1.getCol(), arr1.getRow());
        arr2.arr = readFileArr(path + "\\arr_4_4.txt", arr2.getCol(), arr2.getRow());

        ArrClass check = new ArrClass(4,4);
        check.arr = readFileArr(path + "\\check_4_4.txt", check.getCol(), check.getRow());
        printArr(2, arr1, arr2,MultMatrix.multMatr(arr1,arr2), check);
    }

    public void testMult3() throws Exception{
        ArrClass arr1 = new ArrClass(7,4);
        ArrClass arr2 = new ArrClass(4,2);
        arr1.arr = readFileArr(path + "\\arr_7_4.txt", arr1.getCol(), arr1.getRow());
        arr2.arr = readFileArr(path + "\\arr_4_2.txt", arr2.getCol(), arr2.getRow());

        ArrClass check = new ArrClass(7,2);
        check.arr = readFileArr(path + "\\check_7_2.txt", check.getCol(), check.getRow());
        printArr(3, arr1, arr2,MultMatrix.multMatr(arr1,arr2),check);
    }

    public void testMult4() throws Exception{
        ArrClass arr1 = new ArrClass(2,4);
        ArrClass arr2 = new ArrClass(4,3);
        arr1.arr = readFileArr(path + "\\arr_2_4.txt", arr1.getCol(), arr1.getRow());
        arr2.arr = readFileArr(path + "\\arr_4_3.txt", arr2.getCol(), arr2.getRow());

        ArrClass check = new ArrClass(2,3);
        check.arr = readFileArr(path + "\\check_2_3.txt", check.getCol(), check.getRow());
        printArr(4, arr1, arr2,MultMatrix.multMatr(arr1,arr2),check);
    }

    public void testMult5() throws Exception{
        ArrClass arr1 = new ArrClass(2,2);
        ArrClass arr2 = new ArrClass(1,2);
        arr1.arr = readFileArr(path + "\\arr_2_2.txt", arr1.getCol(), arr1.getRow());
        arr2.arr = readFileArr(path + "\\arr_1_2.txt", arr2.getCol(), arr2.getRow());

        ArrClass check = null;
        printArr(5, arr1, arr2,MultMatrix.multMatr(arr1,arr2),check);
    }


}
