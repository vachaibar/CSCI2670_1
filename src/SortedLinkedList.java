package src;

public class SortedLinkedList {
    private NodeType head;

    public SortedLinkedList() {
        this.head = null;
    }

    public int getLength() {
        int length = 0;
        NodeType current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public void insertItem(ItemType item) {
        if (containsItem(item)) {
            System.out.println("Sorry. You cannot insert the duplicate item");
            return;
        }

        NodeType newNode = new NodeType(item);

        if (head == null || item.compareTo(head.info) < 0) {
            newNode.next = head;
            head = newNode;
        } else {
            NodeType current = head;
            while (current.next != null && item.compareTo(current.next.info) > 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void deleteItem(ItemType item) {
        if (head == null) {
            System.out.println("Sorry. The list is empty");
            return;
        }

        if (item.compareTo(head.info) == 0) {
            head = head.next;
        } else {
            NodeType current = head;
            while (current.next != null && item.compareTo(current.next.info) != 0) {
                current = current.next;
            }
            if (current.next == null) {
                System.out.println("Sorry. The item to be deleted is not in the list");
            } else {
                current.next = current.next.next;
            }
        }
    }

    public int searchItem(ItemType item) {
        NodeType current = head;
        int index = 0;
        while (current != null) {
            if (item.compareTo(current.info) == 0) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public void mergeList(SortedLinkedList list2) {
        SortedLinkedList mergedList = new SortedLinkedList();

        NodeType current1 = this.head;
        NodeType current2 = list2.head;

        while (current1 != null || current2 != null) {
            if (current1 == null) {
                mergedList.insertItem(current2.info);
                current2 = current2.next;
            } else if (current2 == null) {
                mergedList.insertItem(current1.info);
                current1 = current1.next;
            } else {
                int compareResult = current1.info.compareTo(current2.info);
                if (compareResult < 0) {
                    mergedList.insertItem(current1.info);
                    current1 = current1.next;
                } else if (compareResult > 0) {
                    mergedList.insertItem(current2.info);
                    current2 = current2.next;
                } else {
                    // Duplicate, only add once
                    mergedList.insertItem(current1.info);
                    current1 = current1.next;
                    current2 = current2.next;
                }
            }
        }

        System.out.print("Merged list: " + mergedList);
    }

    public void deleteAlternateNodes() {
        NodeType current = head;

        while (current != null && current.next != null) {
            current.next = current.next.next;
            current = current.next;
        }
    }

    public void intersection(SortedLinkedList list2) {
        SortedLinkedList intersectionList = new SortedLinkedList();

        NodeType current1 = this.head;
        NodeType current2 = list2.head;

        while (current1 != null && current2 != null) {
            int compareResult = current1.info.compareTo(current2.info);
            if (compareResult < 0) {
                current1 = current1.next;
            } else if (compareResult > 0) {
                current2 = current2.next;
            } else {
                // Common element, add to intersectionList
                intersectionList.insertItem(current1.info);
                current1 = current1.next;
                current2 = current2.next;
            }
        }

        System.out.print("Intersection: " + intersectionList);
    }
}
