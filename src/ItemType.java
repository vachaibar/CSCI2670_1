package src;

public class ItemType implements Comparable<ItemType>{
    private int value;

    public ItemType(int value) {
        this.value = value;
    }

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

    public void setValue(int num) {
        this.value = num;

    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}
