import java.lang.reflect.Array;

public class DynamicArray<T> {
    Class<T> clazz;
    private T[] items;
    private int size;
    private static final double INC = 1.2;

    public DynamicArray(Class<T> clazz) {
        this.clazz = clazz;
        this.size = 0;
        this.items = createEmptyArray(0);
    }

    private void checkRange(int i) {
        if (i < 0 || size <= i)
            throw new IndexOutOfBoundsException();
    }

    private T[] createEmptyArray(int capacity) {
        return (T[]) Array.newInstance(this.clazz, capacity);
    }

    public int length() {
        return size;
    }

    public T getItem(int i) {
        checkRange(i);
        return this.items[i];
    }

    public void setItem(int i, T item) {
        checkRange(i);
        this.items[i] = item;
    }

    public void addItem(T item) {
        if (size == this.items.length) {
            T[] new_arr = createEmptyArray((int) (this.items.length * INC) + 1);
            for (int i = 0; i < this.items.length; i++) {
                new_arr[i] = this.items[i];
            }
            this.items = new_arr;
        }
        this.items[this.size] = item;
        this.size++;
    }

    public T[] toArray(){
        T[] result = createEmptyArray(this.size);
        for (int i = 0; i < this.items.length; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    public int indexOf(T needle){
        return -1;
    }

    public T delete(int index){

    }
}
