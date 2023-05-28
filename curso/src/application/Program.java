package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UserProduct;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
				
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			System.out.println("Product #"+(i+1)+" data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				Product p = new ImportedProduct(name, price, customsFee);
				list.add(p);
			}
			else if(ch == 'c') {
				Product p = new Product(name, price);
				list.add(p);
			}
			else {
				System.out.print("Manufacture date (DD/MM/YY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				Product p = new UserProduct(name, price, date);
				list.add(p);
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product p : list) {
			System.out.println(p);
		}
		
		sc.close();
	}
} 