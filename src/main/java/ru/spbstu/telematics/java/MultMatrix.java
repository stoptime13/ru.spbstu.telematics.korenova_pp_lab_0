package ru.spbstu.telematics.java;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.*;
import java.util.*;

public class MultMatrix
{
    public static void main( String[] args )throws Exception{
       ArrClass arr1 = new ArrClass(4,3);
       ArrClass arr2 = new ArrClass(3,2);
       String path = new File("src\\main\\resource").getAbsolutePath();

       arr1.arr = readFileArr(path + "\\array1.txt", arr1.getCol(), arr1.getRow());
       arr2.arr = readFileArr(path + "\\array2.txt", arr2.getCol(), arr2.getRow());

       printArr(arr1, arr2, multMatr(arr1,arr2));
    }


    public static ArrClass multMatr(ArrClass arr1, ArrClass arr2) {
        ArrClass resultArr = new ArrClass(arr1.getCol(), arr2.getRow());

        if(arr1.getRow() != arr2.getCol()) {
            resultArr = null;
            return resultArr;
        }
        for(int i = 0; i < arr1.getCol(); i++){
            for(int j = 0; j < arr2.getRow(); j++){
                for(int k = 0; k < arr1.getRow(); k++){
                    resultArr.arr[i][j] += arr1.arr[i][k] * arr2.arr[k][j];
                }
            }
        }

        return resultArr;
    }

    public static int[][] readFileArr(String filename, int col, int row)throws Exception {
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

    public static void printArr(ArrClass arr1, ArrClass arr2, ArrClass res){
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
        for(int i = 0; i < res.getCol(); i++) {
            for (int j = 0; j < res.getRow(); j++) {
                System.out.print(res.arr[i][j] + "\t ");
            }
            System.out.print("\n");
        }
    }

}
