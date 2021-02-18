package edu.wctc;

import java.io.*;
import java.util.Scanner;

public class Main {

    private Scanner keyboard = new Scanner(System.in);
    private PaintCalculator paintCalculator = new PaintCalculator();

    public static void main(String[] args) {new Main();} {

        Scanner keyboard = new Scanner(System.in);

        boolean stillContinue = true;

        while (stillContinue != false) {

            printMenu();

            String input = keyboard.nextLine();
            switch (input) {

                case "1":
                    createRoom();
                    break;
                case "2":
                    System.out.println(paintCalculator.toString());
                    break;
                case "3":
                    readFile();
                    break;
                case "4":
                    writeFile();
                    break;
                case "5":
                   stillContinue = false;
                   break;
                default:
                    System.out.println("not a vaild input please try again.");
                    break;

            }


        }

      System.exit(0);

    }

    private void printMenu() {

        System.out.println("");
        System.out.println("Select Action");
        System.out.println("1. Add a room");
        System.out.println("2. View rooms");
        System.out.println("3. Read rooms from file");
        System.out.println("4. Write rooms to file");
        System.out.println("5. Exit program");
        System.out.print("Please enter your choice: ");

    }

    private void createRoom() {

        double length;
        double width;
        double height;

        System.out.print("Enter in a length value: ");
        length = Double.parseDouble(keyboard.nextLine());

        System.out.print("Enter in a width value: ");
        width = Double.parseDouble(keyboard.nextLine());

        System.out.print("Enter in a height value: ");
        height = Double.parseDouble(keyboard.nextLine());

        paintCalculator.addRoom(width, length, height);

    }

    private void writeFile() {

        try (
                FileOutputStream fos = new FileOutputStream("room.obj");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(paintCalculator);
        } catch (IOException e) {
            System.out.println("Error file not found");
            e.printStackTrace();
        }

    }

    private void readFile() {

        try (
                FileInputStream fis = new FileInputStream("room.obj");
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            paintCalculator = (PaintCalculator) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }
    }
}
