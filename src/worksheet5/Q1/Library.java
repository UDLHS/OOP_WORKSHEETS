package worksheet5.Q1;

import java.util.ArrayList;


public class Library {

    // Private attribute to store BorrowableItems
    private ArrayList<BorrowableItems> borrowableItemsList;

    // Constructor to initialize the list
    public Library() {
        borrowableItemsList = new ArrayList<>();
    }

    // Method to add library items
    public void addItem(BorrowableItems item) {
        borrowableItemsList.add(item);
        System.out.println("Item added to the library.");
    }

    // Method to check out library items
    // Here, we identify item by its index in the list
    public void checkoutItem(int index) {
        if (index >= 0 && index < borrowableItemsList.size()) {
            BorrowableItems item = borrowableItemsList.get(index);

            // For now, assume item is a Book
            if (item instanceof Book) {
                Book book = (Book) item;

                if (book.getAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book checked out successfully: " + book.getTitle());
                } else {
                    System.out.println("Book is already checked out: " + book.getTitle());
                }
            }
        } else {
            System.out.println("Invalid item index.");
        }
    }

    // Optional: display all items in the library
    public void displayLibrary() {
        for (int i = 0; i < borrowableItemsList.size(); i++) {
            System.out.println("Item #" + i + ":");
            borrowableItemsList.get(i).displayInfo();
            System.out.println("-------------------");
        }
    }
}

