package java_programming_construct.Day2;


import java.util.Scanner;

public class SwitchVowelConsonant {
    public static void main() {
        System.out.println("Enter a character");
        Scanner sc=new Scanner(System.in);
        char character=sc.next().toLowerCase().charAt(0);
        switch (character) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("Vowel");
                break;
            default:
                System.out.println("Consonant");
        }
    }
}
