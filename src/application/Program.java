package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		
		Scanner input = new Scanner(System.in);
		List<Product> productList = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		
		int n = input.nextInt();
		
		input.nextLine();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			
			char ch = input.nextLine().charAt(0);
			
			//input.nextLine();
			
			System.out.print("Name: ");
			String nameProduct = input.nextLine();
			
			System.out.print("Price: ");
			double priceProduct = input.nextDouble();
			
			double customsFee;
			Date manufactureData;
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			if(ch == 'i') {				
				System.out.print("Customs fee: ");
				customsFee = input.nextDouble();
				input.nextLine();
				Product product = new ImportedProduct(nameProduct, priceProduct, customsFee);
				productList.add(product);
				
			}
			else {
				if(ch == 'u') {
					System.out.print("Manufacture date (DD/MM/YYYY): ");
					input.nextLine();					
					String data = input.nextLine();					
					manufactureData = sdf.parse(data);
					
					Product product = new UsedProduct(nameProduct, priceProduct, manufactureData);
					productList.add(product);					
				}
				else {
					Product product = new Product(nameProduct, priceProduct);
					productList.add(product);
					input.nextLine();
				}				
			}				
		}
		
		System.out.println();
		
		System.out.println("PRICE TAGS: ");
		for(Product p : productList) {
			System.out.println(p.priceTag());			
		}
		
		input.close();

	}

}
