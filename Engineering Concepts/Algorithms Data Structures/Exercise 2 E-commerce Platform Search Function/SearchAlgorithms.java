public class SearchAlgorithms {

    public static Product linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == targetId) {
                System.out.println("Linear Search: Found at index " + i);
                return products[i];
            }
        }
        System.out.println("Linear Search: Product not found");
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].productId == targetId) {
                System.out.println("Binary Search: Found at index " + mid);
                return products[mid];
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Binary Search: Product not found");
        return null;
    }
}
