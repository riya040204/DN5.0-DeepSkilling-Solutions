public class EcommerceSearch {
    public static void main(String[] args) {

        Product[] products = {
            new Product(103, "Laptop", "Electronics"),
            new Product(101, "Shoes", "Footwear"),
            new Product(105, "Phone", "Electronics"),
            new Product(102, "Shirt", "Clothing"),
            new Product(104, "Watch", "Accessories")
        };

        Product[] sortedProducts = {
            new Product(101, "Shoes", "Footwear"),
            new Product(102, "Shirt", "Clothing"),
            new Product(103, "Laptop", "Electronics"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Phone", "Electronics")
        };

        System.out.println("=== Searching for Product ID: 104 ===");
        System.out.println("-- Linear Search --");
        Product result1 = SearchAlgorithms.linearSearch(products, 104);
        System.out.println("Result: " + result1);
        System.out.println("-- Binary Search --");
        Product result2 = SearchAlgorithms.binarySearch(sortedProducts, 104);
        System.out.println("Result: " + result2);
        System.out.println("=== Time Complexity Analysis ===");
        System.out.println("Linear Search : O(n) - checks each element one by one");
        System.out.println("Binary Search : O(log n) - eliminates half each step");
        System.out.println("Conclusion    : Binary Search is faster for large catalogs");
    }
}
