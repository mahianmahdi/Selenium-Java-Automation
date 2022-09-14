package Misc_Excercises;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Excercise {
    public static void main(String[] args) {
        Faker f = new Faker(new Locale("en-US"));
        System.out.println(f.numerify("150000"));
    }
}
