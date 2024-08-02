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
            System.out.println("The list is empty");
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
                System.out.println("The item is not present in the list");
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
                return index +1;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public void mergeList(SortedLinkedList list2) {
        NodeType current1 = head;
        NodeType current2 = list2.head;
        SortedLinkedList mergedList = new SortedLinkedList();

        while (current1 != null && current2 != null) {
            while (current1 != null && current2 != null) {
                if (current1.info.compareTo(current2.info) <= 0) {
                    mergedList.insertItem(current1.info);
                    current1 = current1.next;
                } else {
                    mergedList.insertItem(current2.info);
                    current2 = current2.next;
                }
            }
        
            while (current1 != null) {
                mergedList.insertItem(current1.info);
                current1 = current1.next;
            }
        
            while (current2 != null) {
                mergedList.insertItem(current2.info);
                current2 = current2.next;
            }
        
            this.head = mergedList.head;
        }
    }

    public void deleteAlternateNodes() {
        NodeType current = head;

        while (current != null && current.next != null) {
            current.next = current.next.next;
            current = current.next;
        }

        if (head == null) {
            System.out.println("Original list: ");
            System.out.println("The list is empty");
            System.out.println("Modified list: ");
        }
    }

    public void intersection(SortedLinkedList list2) {
        SortedLinkedList intersectionList = new SortedLinkedList();
    
        NodeType current1 = this.head;
        NodeType current2 = list2.head;
    
        System.out.print("Intersection of lists: ");
    
        while (current1 != null && current2 != null) {
            int compareResult = current1.info.compareTo(current2.info);
            if (compareResult < 0) {
                current1 = current1.next;
            } else if (compareResult > 0) {
                current2 = current2.next;
            } else {
                intersectionList.insertItem(current1.info);
                current1 = current1.next;
                current2 = current2.next;
            }
        }
    
        System.out.println(intersectionList);
    }

    public boolean containsItem(ItemType item3) {
        NodeType current = head;
        while (current != null) {
            if (item3.compareTo(current.info) == 0) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NodeType current = head;
        while (current != null) {
            sb.append(current.info.toString()).append(" ");
            current = current.next;
        }
        return sb.toString();
    }

    public boolean isEmpty() {
        return head == null;
    }
}