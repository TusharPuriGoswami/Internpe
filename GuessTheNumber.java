package com.Internpe;
import java.util.Random;
import java.util.Scanner;
class game {
    public int number;
    public int inputNumber;
    public int noOfguess = 0;
    public int getNoOfguess() {
        return noOfguess;
    }
    public void setNoOfguess(int noOfguess) {
        this.noOfguess = noOfguess;
    }
    game()
    {
        Random r = new Random();
        this.number = r.nextInt(100);
    }
    void takeUserInput()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Guess The Number : ");
        inputNumber = sc.nextInt();
    }
    boolean isCurrectNumber()
    {
        noOfguess++;
        if (inputNumber == number)
        {
            System.out.format("yes you guess it right , it was %d\n you guessed it in %d attempts" , number, noOfguess);
            return true;
        } else if (inputNumber< number) {
            System.out.println("Too Low...");
        }
        else if (inputNumber > number){
            System.out.println("Too high....");
        }
        return false;
    }
}
public class GuessTheNumber {
    public static void main(String[] args)  {
        game g = new game();
        boolean b = false;
        while (!b)
        {
        g.takeUserInput();
       b = g.isCurrectNumber();

        }

    }
}

