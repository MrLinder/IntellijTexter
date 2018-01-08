/**
 * Created by LindXdeep on 02.01.2018.
 */
//package linder.igor;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args)
    {
        int Array[] = {1,0,0,1,0,1,0,0,1,1,0,1,0,1};

        System.out.print("sourse array: ");
        PrintArray(Array);

        SwitchArr(Array);

        System.out.print("\nresults array: ");
        PrintArray(Array);

        System.out.print("\nload array step three : ");
        int Array2[] = new int [8];
        LoadStepThreeArray(Array2);
        PrintArray(Array2);

        int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("\nArray multiply on two: ");
        System.out.print("\nSourse: ");
        PrintArray(mas);

        MultiplyArray(mas);

        System.out.print("\nResults: ");
        PrintArray(mas);

        System.out.print("\nFind Max and Min Array elements: \n");

        System.out.print("\nSourse: ");
        PrintArray(mas);

        Sort(mas);

        System.out.print("\nResults: ");
        PrintArray(mas);

        System.out.println("\nMin " + mas[0]);

        int endelem = mas.length;
        System.out.println("\nMax " + mas[endelem-1]);


    }

    public static void PrintArray(int[] arr)
    {
        for ( int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
    }

    public static void SwitchArr(int[] arr)
    {
        for ( int i = 0; i < arr.length; ++i)
        {
            if (arr[i] != 0)
                arr[i] = 0;
            else
                arr[i] = 1;
        }
    }

    public static void LoadStepThreeArray(int[] arr)
    {
        int count, i, temp;
        count = i = 0;
        temp = 1;
        do
        {
            if (i - temp == 3 || i == 1 )
                arr[count++] = temp = i;
        } while (i++ != 22 );
    }

    public static void MultiplyArray(int[] arr)
    {
        int i = 0;
        do
        {
            if (arr[i] < 6)
                arr[i] *= 2;
        } while (++i < arr.length);
    }

    public static void Sort(int[] arr)
    {
        int j, k;
        int lb = 1;
        int rb = arr.length-1;  // границы неотсортированной части массива
        k = 0;

        do
        {
            for(j = 1; j <= rb; j++ )
            {
                if(arr[j-1]>arr[j])
                {
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                    k = j;
                }
            }
            rb = k - 1;
            for(j = rb; j > 0; j-- )
            {
                if(arr[j-1]>arr[j])
                {
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                    k = j;
                }
            }
            lb = k + 1;

        }while(lb < rb);
    }





}













