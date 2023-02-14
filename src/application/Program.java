package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		
		System.out.println("Enter account data: ");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Holder: ");
		String holder = sc.next();
		System.out.print("Initial balance: ");
		Double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdraw = sc.nextDouble();
		
		Account acc = new Account(number, holder, balance, withdraw);
		
		System.out.println();
		System.out.print("Enter amount to withdraw: ");
		withdraw = sc.nextDouble();
		
		try {
		acc.withdraw(withdraw);
		System.out.printf("New balance: %.2f",acc.getBalance());
		}
		catch(DomainExceptions e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		sc.close();
	}

}
