import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    public static void addNumber(int n,PriorityQueue<Integer> min , PriorityQueue<Integer> max)
    {
        if(max.size()==0 || n<max.peek())
            max.add(n);
        else
            min.add(n);
    }
    
    public static void reBalance(PriorityQueue<Integer> min,PriorityQueue<Integer> max)
    {
        PriorityQueue<Integer> small=min.size()<max.size()?min:max;
        PriorityQueue<Integer> Big=min.size()>max.size()?min:max;    
        if(Big.size()-small.size()>=2)
        {
            small.add(Big.poll());
        }
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();
        
            int[] a = new int[n];
            float median;
        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            a[i] = aItem;
            addNumber(a[i],min,max);
            reBalance(min,max);
            if(min.size()==max.size())
            {
                median=(float)(min.peek()+max.peek())/2;
            }
            else
                median=min.size()>max.size()?min.peek():max.peek();
            System.out.println(median);
        }

        scanner.close();
    }
}