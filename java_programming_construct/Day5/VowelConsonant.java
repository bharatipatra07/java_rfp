package java_programming_construct.basic_core_java_functional_program;

import java.util.Scanner;

//PROBLEM 9(Alphabet is Vowel or Consonant)
public class VowelConsonant{
    public static void main(String args[]){
        System.out.println("Enter a character");
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().toLowerCase().charAt(0);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            System.out.println("Vowel");
        else
            System.out.println("Consonant");
    }
}
