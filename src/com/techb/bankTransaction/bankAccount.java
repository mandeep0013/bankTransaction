package com.techb.bankTransaction;

import java.util.Scanner;

class Bank {
    private String accno;
    private String name;
    private long balance;
    private String email;
    private long phoneNo;

    Scanner sc = new Scanner(System.in);
    
    public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	//method to open an account
    void openAccount() {
        System.out.print("Enter Account No: ");
        accno = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextLong();
        System.out.print("Enter Email: ");
        email = sc.next();
        System.out.print("Enter Phone number: ");
        phoneNo = sc.nextLong();
    }

    //method to display account details
    void showAccount() {
        System.out.println(accno + "," + name + "," + balance + email + phoneNo);
    }

    //method to deposit mone
    void deposit() {
        long amt;
        System.out.println("Enter Amount U Want to Deposit : ");
        amt = sc.nextLong();
        balance = balance + amt;
    }

    //method to withdraw money
    void withdrawal() {
        long amt;
        System.out.println("Enter Amount U Want to withdraw : ");
        amt = sc.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
        } else {
            System.out.println("Less Balance..Transaction Failed..");
        }
    }
    
    static class PhoneNumberFormatting
    
    {
    	public static void main(String arg[])	
    	{
    	    long n=10;
    	    int a[]=new int[10]; 
                Scanner sc=new Scanner(System.in);
    	    System.out.println("Enter a digits of phone number");
    	    for(int i=0;i<n;i++)
    	    {
              
    	      a[i]=sc.nextInt();
                  if(a[i]<0 || a[i]>9)
    		{
                     
    		System.out.print("wrong input");
    		return;
    		}
    		
    		System.out.println("");
     
                }  
    	    
    		System.out.print("phone number format--->");
    	    for(int i=0;i<n;i++)
    	    {
    	      if(i==0)
    		System.out.print("\"(");
                   if(i==3)
    		System.out.print(") ");
    		
    	      if(i==6)
    		System.out.print("-");
    	      
    	      if (i==9)
    		System.out.print(a[i]);
    		
    	      
    		}
    	  
    	}
    }
    //method to search an account number
    boolean search(String acn) {
        if (accno.equals(acn)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}

public class bankAccount {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        //create initial accounts
        System.out.print("How Many Customer U Want to Input : ");
        int n = sc.nextInt();
        Bank C[] = new Bank[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new Bank();
            C[i].openAccount();
        }

        //run loop until menu 5 is not pressed
        int ch;
        do {
            System.out.println("Main Menu\n1. Display All\n 2. Search By Account\n 3. Deposit\n 4. Withdrawal\n 5.E xit ");
                System.out.println("Ur Choice :"); ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        for (int i = 0; i < C.length; i++) {
                            C[i].showAccount();
                        }
                        break;

                    case 2:
                        System.out.print("Enter Account No U Want to Search...: ");
                        String acn = sc.next();
                        boolean found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Account No : ");
                        acn = sc.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                C[i].deposit();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Account No : ");
                        acn = sc.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                C[i].withdrawal();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;

                    case 5:
                        System.out.println("Good Bye..");
                        break;
                }
            }
            while (ch != 5);
        }
    }

