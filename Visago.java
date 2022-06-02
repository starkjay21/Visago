package com.LearnDemo;

import java.util.Scanner;

public class Visago {
    static String[] name = {"Blue Queen" , "Red Star" , "Seagull Resorts" , "Regency Inn" , "Holiday Inn" , "The Redmond Inn"};
    static short[] star = {3,4,4,3,7,5};
    static double[] del_suite = {15000,19000,18500,18500,22000,20000};
    static double[] suite = {12000,14000,12500,12500,16000,14000};
    static double[] del_double = {8000,10000,8500,8500,12000,10000};
    static double[] dou_ble = {6000,8000,7500,6500,10000,8000};
    static double[] del_single = { 4000,6000,6500,4500,9000,7000};
    static double[] single = {2000,4000,4500,2500,7000,5000};

    static String client_name;
    static int no;
    static int choice;
    static int budget;
    static double total;
    static int f;
    static int c = 1;
    static int days;
    static int j= 0;
    public static void welcome(){
        System.out.println("Hi ");
        System.out.println("Welcome to Visago!! ");
        System.out.println("I am Jayesh ");
        System.out.println("I will guide you through the process of completing the booking process ");
    }
    public static void input(){
        Scanner sc1 = new Scanner(System.in);

        System.out.print("Please Enter Your Name: ");
        client_name = sc1.nextLine();
        System.out.println();

        System.out.print("Please Enter The Number of Adults (15+) : ");
        no = sc1.nextInt();
        System.out.println();

        System.out.print("Please Enter The Number Of Days Of stay :");
        days = sc1.nextInt();
        System.out.println();

        System.out.print("Please Enter Budget (in INR): ");
        budget = sc1.nextInt();
        System.out.println();



    }
    public static void options(){

        boolean flag = true;
        for (int i = 0; i < 6; i++) {


            f=0;
            switch (choice) {
                case 1 -> {total = (double)days * Math.ceil(no/2.0) * del_suite[i];f=2; flag = false;}
                case 2 -> {total = (double)days * Math.ceil(no/2.0) * suite[i];f=2;flag = false;}
                case 3 -> {total = (double)days * Math.ceil(no/2.0) * del_double[i];f=2;flag = false;}
                case 4 -> {total = (double)days * Math.ceil(no/2.0) * dou_ble[i];f=2;flag = false;}
                case 5 -> {total = (double)days * Math.ceil(no/2.0) * del_single[i];f=2;flag = false;}
                case 6 -> {total = (double)days * (double)no * single[i];f=2;flag = false;}
                default -> {
                    System.out.println("Invalid option entered !!! Please try again");
                    f=1;
                }
            }
            if (f == 2) {
                if ((int)total * 1.07 <= budget)
                    display(i, total);
            }
            if (f == 1)
                break;

        }
        if(!flag){
            System.out.println("Sorry :-( No hotels found within your budget");
        }



    }
    public static void display(int a,double t){

        if (j++ == 0)
            System.out.println("Your Options are ");

        System.out.println("Hotel number : " + c);
        c++;

        System.out.println("Hotel name : " + name[a]);

        System.out.print("Star Rating : ");
        for (int i = 1; i <= star[a] ; i++) {
            System.out.print('*');
        }
        System.out.println();
        System.out.println("Total Amount (inclusive of all taxes) : Rs. " + (int)(t*1.07) + ".00");
        System.out.println();
        System.out.println();

        f=2;
    }
    public static void book(int ch){

        System.out.println("WELCOME TO " + name[ch-1]  );
        System.out.println("Customer Name : " + client_name);
        int a = 2;
        System.out.println("Your chosen room details : ");
        switch (choice) {
            case 1 -> System.out.println("Deluxe Suite");
            case 2 -> System.out.println("Suite");
            case 3 -> System.out.println("Deluxe Double Room");
            case 4 -> System.out.println("Double Room");
            case 5 -> {
                System.out.println("Deluxe Single");
                a = 1;
            }
            case 6 -> {
                System.out.println("Single");
                a = 1;
            }
            default -> {
                System.out.println("Invalid option entered !!! Please try again");
                f = 1;
            }
        }
        switch (choice) {
            case 1 -> total = (double)days * Math.ceil(no/2.0) * del_suite[ch-1];
            case 2 -> total = (double)days * Math.ceil(no/2.0) * suite[ch-1];
            case 3 -> total = (double)days * Math.ceil(no/2.0) * del_double[ch-1];
            case 4 -> total = (double)days * Math.ceil(no/2.0) * dou_ble[ch-1];
            case 5 -> total = (double)days * (double)no * del_single[ch-1];
            case 6 -> total = (double)days * (double)no * single[ch-1];
            default -> {
                System.out.println("Invalid option entered !!! Please try again");
                f = 1;
            }
        }
        if(no == 1)
            a=1;
        System.out.println("Number of Rooms : " + (no/a));
        System.out.println("Number of Adults : "+ no);
        System.out.println("Amount Details :");
        System.out.println("Room Charges : Rs." + (int)total + ".00");
        System.out.println("Tax          : Rs." + (int)(total*0.07)+ ".00");
        System.out.println("-----------------------------------------------");
        System.out.println("Grand Total  : Rs." + (int)(total*1.07)+".00");
        Scanner sc3= new Scanner(System.in);
        System.out.println("Do you confirm ? ");
        System.out.println("Enter Y to confirm");
        System.out.println("Enter any other key to deny");
        char x = sc3.next().trim().charAt(0);
        if (x == 'Y' || x == 'y') {
            System.out.println("Directing to Payment Gateway..........");
            System.out.println("Payment Successful ");
            System.out.println("Enjoy your vacation :-)");
        }
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        welcome();
        input();
        do {
            System.out.println("Please Enter Type Of Room : ");
            System.out.println("1 -> Deluxe Suite");
            System.out.println("2 -> Suite ");
            System.out.println("3 -> Deluxe Double");
            System.out.println("4 -> Double ");
            System.out.println("5 -> Deluxe Single ");
            System.out.println("6 -> Single ");
            choice = sc.nextInt();
            options();
        }while(f == 1);

        System.out.println("Do you want to proceed to booking ?");
        System.out.println("Press Y to proceed ");
        System.out.println("Press any other key to exit ");
        char ch = sc.next().trim().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            System.out.println("ENTER CHOSEN HOTEL NUMBER");
            System.out.println("1 -> Blue Queen");
            System.out.println("2 -> Red Star");
            System.out.println("3 -> Seagull Resorts");
            System.out.println("4 -> Regency Inn ");
            System.out.println("5 -> Holiday Inn");
            System.out.println("6 -> The Redmond Inn");

            book(sc.nextInt());
        }
        System.out.println("Thank you for using Visago !");
        System.out.println("Please Visit Again :-) ");

    }

}
