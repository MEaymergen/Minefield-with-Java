package odev.pkg3;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Emin
 */
public class Odev3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        System.out.println("Please enter the line size of the game.");
        int line = sc.nextInt();
        if (line == 0) {
            System.out.println("Row value cannot be 0");
            System.out.println("Please enter the line size of the game.");
            line = sc.nextInt();
        }
        System.out.println("Please enter the column size of the game.");
        int column = sc.nextInt();
        if (column == 0) {
            System.out.println("Column value cannot be 0.");
            System.out.println("Please enter the column size of the game.");
            column = sc.nextInt();
        }
        int[][] array = new int[line][column];
        int[][] array2 = new int[line][column];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                array2[i][j] = 8;
                System.out.print(array2[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("Please enter a difficulty level between 20 and 80...");
        int difficulty = sc.nextInt();
        System.out.println("MINE IS PLACED!!!");
        if (difficulty >= 20 && difficulty <= 80) {
            difficulty = (line * column * difficulty) / 100;
            for (int i = 0; i < line; i++) {
                for (int j = 0; j < column; j++) {
                    if (difficulty < 0) {
                        array[i][j] = rnd.nextInt(1);
                    } else {
                        array[i][j] = rnd.nextInt(2);
                    }
                    if (array[i][j] == 1) {
                        difficulty--;
                    }
                    System.out.print(array[i][j] + "   ");
                }
                System.out.println("    ");
            }
            int timer = 0;
            System.out.println("Please enter the line value of the game.");
            int li = sc.nextInt();
            System.out.println("Please enter the column value of the game.");
            int co = sc.nextInt();
            while (array[li][co] == 0) {
                for (int i = 0; i < line; i++) {
                    for (int j = 0; j < column; j++) {
                        if (li == i && co == j) {
                            array2[i][j] = array[i][j];
                            System.out.print(array2[li][co] + "   ");
                        } else {
                            System.out.print(array2[i][j] + "   ");
                        }
                    }
                    System.out.println("   ");
                }
                timer += 5;
            System.out.println("Please enter the line value of the game.");
                li = sc.nextInt();
            System.out.println("Please enter the column value of the game.");
                co = sc.nextInt();
            }
            if (array[li][co] == 1) {
                System.out.println("GAME OVER!!!\nYOUR SCORE : " + timer);
                for (int i = 0; i < line; i++) {
                    for (int j = 0; j < column; j++) {
                        System.out.print(array[i][j] + "   ");
                    }
                    System.out.println("    ");
                }
            }
        }
    }
}