package Streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercises {
    private static final List<Person> people = Data.getPeople();
    private static final List<Product> products = Data.getProducts();

    public static void main(String[] args) {
        // Get people older than 30.
        List<Person> olderThan30 = people.stream()
                .filter(person -> person.getAge() > 30)
                .toList();

        System.out.println("People older than 30: " + olderThan30 + "\n");

        // Find all products in the “Electronics” category.
        List<Product> electronics = products.stream()
                .filter(prod -> prod.getCategory().equals("Electronics"))
                .toList();

        System.out.println("Products in the “Electronics” category: " + electronics + "\n");

        // Sort people by age.
        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .toList();

        System.out.println("Sorted people by age: " + sortedByAge + "\n");

        // Sort products by price (descending).

        List<Product> sortedByPriceDesc = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .toList();

        System.out.println("Sorted products by price descending: " + sortedByPriceDesc + "\n");

        // Get a list of names of all people.

        List<String> names = people.stream()
                .map(Person::getName)
                .toList();

        System.out.println("People names: " + names + "\n");

        // Get a list of product names that cost more than $100.

        List<String> productsNames = products.stream()
                .filter(product -> product.getPrice() > 100)
                .map(Product::getName)
                .toList();

        System.out.println("Products names that cost more than $100: " + productsNames + "\n");

        // Count the number of people living in “San Francisco”.

        int peopleCount = (int) people.stream()
                .filter(person -> person.getCity().equals("San Francisco"))
                .count();

        System.out.println("The number of people living in San Francisco: " + peopleCount + "\n");

        // Count the number of products in the “Apparel” category.

        int productsCount = (int) products.stream()
                .filter(product -> product.getCategory().equals("Apparel"))
                .count();

        System.out.println("The number of products in the Apparel category: " + productsCount + "\n");

        // Find the oldest person.

        Person oldestPerson = people.stream()
                .sorted((p1 ,p2) -> p2.getAge() - p1.getAge())
                .findFirst()
                .orElseThrow();

        System.out.println("The oldest person: " + oldestPerson + "\n");

        // Find the most expensive product.

        Product expensiveProduct = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .findFirst()
                .orElseThrow();

        System.out.println("The most expensive product: " + expensiveProduct + "\n");

        // Calculate the average age of people.

        double avgAge = people.stream()
                .mapToDouble(Person::getAge)
                .average()
                .getAsDouble();

        System.out.println("The average age of people: " + avgAge + "\n");

        // Calculate the average price of products.

        double avgPrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .getAsDouble();

        System.out.println("The average price of products: " + avgPrice + "\n");

        // Group people by city.

        System.out.println("People grouped by city:");

        people.stream()
                .collect(Collectors.groupingBy(Person::getCity))
                .forEach((c, p) -> System.out.println("\t" + c + ": " + p));

        System.out.println();

        // Group products by category.

        System.out.println("Name of the products group by category:");

        products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.mapping(Product::getName, Collectors.toList())))
                .forEach((cat, n) -> System.out.println("\t" + cat + ": " + n));

        System.out.println();

        // Check if any person is older than 35.

        boolean anyOlder = people.stream()
                .map(Person::getAge)
                .anyMatch(p -> p > 35);

        System.out.print("Any person is older than 35? " + (anyOlder ? "yes" : "no") + "\n\n");

        // Check if all products cost less than $1000.

        boolean allCheap = products.stream()
                .map(Product::getPrice)
                .allMatch(p -> p < 1000);

        System.out.printf("All products cost less than $1000? %s\n\n", allCheap ? "yes" : "no");

        // Collect all people names into a single string separated by commas.

        String peopleNames = people.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", "));

        System.out.printf("People names: %s\n\n", peopleNames);

        // Find the first person in the list.

        Person firstPerson = people.stream().findFirst().orElse(null);

        System.out.printf("The first person in the list: %s\n\n", firstPerson);

        // Create a list of product names in uppercase.

        List<String> productNames = products.stream()
                .map(p -> p.getName().toUpperCase())
                .toList();

        System.out.printf("The list of product names in uppercase: %s\n\n", productNames);

        // Create a map of people where the key is the name, and the value is the Person object.

        Map<String, Person> peopleMap = people.stream()
                .collect(Collectors.toMap(Person::getName, Function.identity()));

        // Get a list of products that are exactly $49.99.

        List<Product> productList = products.stream()
                .filter(product -> product.getPrice() == 49.99)
                .toList();

        System.out.println("The list of products that are exactly 49.99: " + productList + "\n");

        // Calculate the total age of all people.

        System.out.println("The total age of all people is " + people.stream()
                .map(Person::getAge)
                .reduce(Integer::sum)
                .get() + "\n"
        );

        // Find the product with the longest name.

        String maxName = products.stream()
                .map(Product::getName)
                .min((p1, p2) -> p2.length() - p1.length())
                .get();

        System.out.print("The product with the longest name is " + maxName + "\n\n");

        // Partition people into two groups: those older than 30 and those 30 or younger.

         people.stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() <= 30))
                .forEach((key, value) -> System.out.printf("%s : %s\n", (key ? "People that are 30 or younger: " : "People older than 30: "), value));

        System.out.println();

        // Group people by city and count the number of people in each city.

        System.out.println("People count grouped by city:");

        people.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()))
                .forEach((city, count) -> System.out.printf("%s: %d%n", city, count));

        // Group products by category and calculate the average price for each category.

        System.out.println("\nAverage price of products grouped by category: ");

        products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)))
                .forEach((key, value) -> System.out.printf("%s: %.2f%n", key, value));

    }
}
