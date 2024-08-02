package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedListDriver {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java LinkedListDriver <input_file>");
            return;
        }

        String inputFile = args[0];
        SortedLinkedList sortedList = new SortedLinkedList();

        try (Scanner fileScanner = new Scanner(new File(inputFile));
             Scanner keyboard = new Scanner(System.in)) {

            System.out.println("Commands: \n i - Insert \n d - Delete \n s - Search \n a - Delete Alternate Nodes \n m - Merge \n t - Intersection \n p - Print All \n l - Length \n q - Quit");

            while (fileScanner.hasNextInt()) {
                int num = fileScanner.nextInt();
                ItemType item = new ItemType(num);
                item.setValue(num);
                sortedList.insertItem(item);
            }

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
                        ItemType item = new ItemType(num);
                        item.setValue(num);
                        System.out.println("Original list: " + sortedList.toString());

                        if (sortedList.containsItem(item)) {
                            System.out.println("The item already exists");
                            System.out.println("New list: " + sortedList.toString());
                        } else {
                            sortedList.insertItem(item);
                            System.out.println("New list: " + sortedList.toString());
                        }
                        break;
                    case 'd':
                        System.out.print("Enter a number to delete: ");
                        int num2 = keyboard.nextInt();
                        ItemType item2 = new ItemType(command);
                        item2.setValue(num2);
                        System.out.println("Original list: " + sortedList.toString());
                        sortedList.deleteItem(item2); 

                        if (sortedList.containsItem(item2)) {
                            System.out.println("Item is not present in the list");
                        } else {
                            System.out.println("New list: " + sortedList.toString());
                        }
                        break;
                    case 's':
                        System.out.print("Enter a number to search: ");
                        int num3 = keyboard.nextInt();
                        ItemType item3 = new ItemType(num3);
                        System.out.print("Original list: ");
                        if (!sortedList.isEmpty()) {
                            System.out.println(sortedList.toString());
                        } else {
                            System.out.println("\nThe list is empty");
                        }
                        int index = sortedList.searchItem(item3);
                        if (index != -1) {
                            System.out.println("The item is present at index " + (index)); 
                        } else {
                            System.out.println("Item is not present in the list");
                        }
                        break;
                    case 'a':
                        if (!sortedList.isEmpty()) {
                            System.out.println("Original list: " + sortedList.toString());
                            sortedList.deleteAlternateNodes();
                            System.out.println("New list: " + sortedList.toString());
                        } else {
                            System.out.println("Original list: ");
                            System.out.println("The list is empty");
                            System.out.println("Modified list: " );
                        }
                        break;                    
                    case 'm':
                        SortedLinkedList sortedList2 = new SortedLinkedList();
                        System.out.print("Enter the length of the new list: ");
                        int num4 = keyboard.nextInt();
                        System.out.print("Enter the numbers: ");
                        for (int i = 0; i < num4; i++) {
                            int num5 = keyboard.nextInt();
                            ItemType item5 = new ItemType(num5);
                            //item5.setValue(num5);
                            sortedList2.insertItem(item5);
                        }

                        System.out.println("list 1: " + sortedList.toString());
                        System.out.println("list 2: " + sortedList2.toString());

                        sortedList.mergeList(sortedList2);
                        System.out.println("Merged list: " + sortedList.toString());
                        break;
                    case 't':
                        SortedLinkedList sortedList3 = new SortedLinkedList();
                        System.out.print("Enter the length of the new list: ");
                        int num6 = keyboard.nextInt();
                        System.out.print("Enter a number to insert: ");
                        for (int i = 0; i < num6; i++) {
                            int num7 = keyboard.nextInt();
                            ItemType item7 = new ItemType(num7);
                            sortedList3.insertItem(item7);
                        }
                        System.out.println("List 1: " + sortedList.toString());
                        System.out.println("List 2: " + sortedList3.toString());
                        sortedList.intersection(sortedList3);
                        break;
                        default:
                        System.out.println("Invalid command. Try Again: ");
                        break;
                }
            } while (command != 'q');
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFile);
        }
    }
}

