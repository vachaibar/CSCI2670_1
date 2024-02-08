package src;


public class ItemType implements Comparable<ItemType> {
    private int value;

    public ItemType(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(ItemType item) {
        if (this.value < item.value) {
            return -1;
        } else if (this.value > item.value) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getValue() {
        return this.value;
    }

    public void initalize(int num) {
        this.value = num;
    }
}
