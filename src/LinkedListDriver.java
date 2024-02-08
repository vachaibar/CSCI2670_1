package src;
import java.util.Scanner;

public class LinkedListDriver {
    public static void main(String[] args) {
        SortedLinkedList sortedList = new SortedLinkedList();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Commands: \n i - Insert \n d - Delete \n s - Search \n a - Delete Alternate Nodes \n m - Merge \n t - Intersection \n p - Print All \n l - Length \n q - Quit");

        char command;
        do {
            System.out.print("Enter a command: ");
            command = keyboard.next().charAt(0);

            switch (command) {
                case 'p':
                    System.out.println("The list is: " + sortedList.toString());
                    break;
                case 'l':
                    System.out.println("Length: " + sortedList.getLength());
                    break;
                case 'i':
                    System.out.print("Enter a number to insert: ");
                    int num = keyboard.nextInt();
                    ItemType item = new ItemType();
                    item.setValue(num);
                    sortedList.insertItem(item);
                    break;
                case 'd':
                    System.out.print("Enter a number to delete: ");
                    int num2 = keyboard.nextInt();
                    ItemType item2 = new ItemType();
                    item2.setValue(num2);
                    sortedList.deleteItem(item2);
                    break;
                case 's':
                    System.out.print("Enter a number to search: ");
                    int num3 = keyboard.nextInt();
                    ItemType item3 = new ItemType();
                    item3.setValue(num3);
                    if (sortedList.containsItem(item3)) {
                        System.out.println("The item is in the list");
                    } else {
                        System.out.println("The item is not in the list");
                    }
                    break;
                case 'a':
                    sortedList.deleteAlternateNodes();
                    break;
                case 'm':
                    SortedLinkedList sortedList2 = new SortedLinkedList();
                    System.out.print("Enter the number of elements in the second list: ");
                    int num4 = keyboard.nextInt();
                    for (int i = 0; i < num4; i++) {
                        System.out.print("Enter a number to insert: ");
                        int num5 = keyboard.nextInt();
                        ItemType item5 = new ItemType();
                        item5.setValue(num5);
                        sortedList2.insertItem(item5);
                    }
                    sortedList.mergeList(sortedList2);
                    break;
                case 't':
                    SortedLinkedList sortedList3 = new SortedLinkedList();
                    System.out.print("Enter the number of elements in the second list: ");
                    int num6 = keyboard.nextInt();
                    for (int i = 0; i < num6; i++) {
                        System.out.print("Enter a number to insert: ");
                        int num7 = keyboard.nextInt();
                        ItemType item7 = new ItemType();
                        item7.setValue(num7);
                        sortedList3.insertItem(item7);
                    }
                    sortedList.intersection(sortedList3);
                    break;
            }
        } while (command != 'q');

        System.out.println("Exiting the program...");
        keyboard.close();
    }
}
