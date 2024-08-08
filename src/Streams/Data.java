package Streams;

import java.util.Arrays;
import java.util.List;

public class Data {
    public static List<Person> getPeople() {
        return Arrays.asList(
                new Person("Alice", 30, "New York"),
                new Person("Bob", 25, "San Francisco"),
                new Person("Charlie", 35, "Los Angeles"),
                new Person("David", 28, "Chicago"),
                new Person("Eva", 22, "Houston"),
                new Person("Frank", 33, "Phoenix"),
                new Person("Grace", 27, "Philadelphia"),
                new Person("Henry", 29, "San Antonio"),
                new Person("Ivy", 26, "San Diego"),
                new Person("Jack", 24, "Dallas"),
                new Person("Karen", 32, "San Jose"),
                new Person("Leo", 31, "Austin"),
                new Person("Mona", 23, "Jacksonville"),
                new Person("Nina", 34, "Fort Worth"),
                new Person("Oscar", 36, "Columbus"),
                new Person("Paul", 21, "Charlotte"),
                new Person("Quincy", 37, "San Francisco"),
                new Person("Rachel", 20, "Indianapolis"),
                new Person("Steve", 38, "Seattle"),
                new Person("Tina", 39, "Denver")
        );
    }

    public static List<Product> getProducts() {
        return Arrays.asList(
                new Product("Laptop", 999.99, "Electronics"),
                new Product("Smartphone", 699.99, "Electronics"),
                new Product("Tablet", 399.99, "Electronics"),
                new Product("Headphones", 199.99, "Electronics"),
                new Product("Monitor", 299.99, "Electronics"),
                new Product("Keyboard", 49.99, "Accessories"),
                new Product("Mouse", 29.99, "Accessories"),
                new Product("Printer", 149.99, "Electronics"),
                new Product("Desk", 199.99, "Furniture"),
                new Product("Chair", 89.99, "Furniture"),
                new Product("Notebook", 2.99, "Stationery"),
                new Product("Table", 1002.99, "Furniture"),
                new Product("Pen", 1.99, "Stationery"),
                new Product("Pencil", 0.99, "Stationery"),
                new Product("Backpack", 49.99, "Accessories"),
                new Product("Shoes", 79.99, "Apparel"),
                new Product("Jacket", 119.99, "Apparel"),
                new Product("Jeans", 59.99, "Apparel"),
                new Product("T-Shirt", 19.99, "Apparel"),
                new Product("Socks", 9.99, "Apparel"),
                new Product("Hat", 14.99, "Apparel")
        );
    }
}
