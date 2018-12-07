package com.mindtree.discussion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import com.mindtree.discussion.entity.Product;
import com.mindtree.discussion.exception.service.ServiceException;
import com.mindtree.discussion.service.ProductService;
import com.mindtree.discussion.service.serviceImpl.ProductServiceImpl;
import com.mindtree.discussion.util.sort.CategoryComparator;
import com.mindtree.discussion.util.sort.PriceComparator;

public class App {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		ProductService productService = new ProductServiceImpl();
		while (true) {
			System.out.println("Enter Choice : \n1. Insert from File  \n2. Read By Product Name ");
			System.out.println("3. Get All Product  \n4. Sort by price  \n5. Sort by Type  \n6. Into Map \n7. Exit");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
					String line = "";
					while ((line = br.readLine()) != null) {
						Product product = new Product();
						String[] data = line.split(",");
						product.setSlNo(Integer.parseInt(data[0]));
						product.setProduct(data[1]);
						product.setPrice(Double.parseDouble(data[2]));
						product.setType(data[3]);
						try {
							System.out.println(productService.insert(product));
						} catch (ServiceException e) {
							System.out.println("Error While Inserting" + e);
						}
					}

				} catch (FileNotFoundException e1) {
					System.out.println("File Not Found");
				} catch (IOException e) {
					System.out.println(e);
				}
			}
				break;
			case 2: {
				System.out.println("Enter the product name : ");
				try {
					System.out.println(productService.read(s.next()));
				} catch (ServiceException e) {
					System.out.println("Unable to read ");
				}
			}
				break;
			case 3:
				List<Product> list = null;
				try {
					list = productService.getAll();
				} catch (ServiceException e) {
					System.out.println("Error While Get All" + "\n" + e);
				}

				list.forEach(System.out::println);
				s.nextLine(); {
			}
				break;

			case 4: {
				System.out.println("Sort by Price");
				List<Product> pList = null;
				try {
					pList = productService.getAll();
				} catch (ServiceException e) {
					System.out.println("Error While Get All" + "\n" + e);
				}
				Comparator<Product> com = new PriceComparator();
				Collections.sort(pList, com);
				pList.forEach(System.out::println);
			}
				break;
			case 5: {

				System.out.println("Sort by Type");
				List<Product> pTList = null;
				try {
					pTList = productService.getAll();
				} catch (ServiceException e) {
					System.out.println("Error While Get All" + "\n" + e);
				}
				Comparator<Product> com = new CategoryComparator();
				Collections.sort(pTList, com);
				pTList.forEach(System.out::println);

			}
				break;
			case 6: {
				System.out.println("HashMap");
				List<Product> mapList = null;
				try {
					mapList = productService.getAll();
				} catch (ServiceException e) {
					System.out.println("Error While Get All" + "\n" + e);
				}
				HashMap<String, Product> map = new HashMap<>();
				for (int i = 0; i < mapList.size(); i++) {
					map.put(mapList.get(i).getProduct(), mapList.get(i));
				}

				for (Entry<String, Product> entry : map.entrySet()) {
					System.out.println(entry.getKey() + " --> " + entry.getValue());
				}

			}
				break;
			case 7: {
				System.exit(1);
			}
				break;
			}

		}
		/*
		 * Product product = new Product(); ProductService productService = new
		 * ProductServiceImpl(); product.setProduct("MIlk"); product.setPrice(100);
		 * product.setType("Commerce");
		 * 
		 * try { System.out.println(productService.insert(product)); } catch
		 * (ServiceException e) { System.out.println("Error While Inserting"); }
		 * 
		 * try { System.out.println(productService.read("Milk")); } catch
		 * (ServiceException e) { System.out.println("Error while Reading"); }
		 */

	}
}
