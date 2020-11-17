/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package J2LP0003;


public class bitDemo {
    public static void main(String args[]){
        int a = Integer.parseInt(("100000001111111100000001"),2);
        System.out.println(a);
        int b = ~(1 << 8);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(a&1));
    }
}
