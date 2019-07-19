package dmitry.quiz.queues;

/**
 * Three in One: Describe how you could use a single array to implement three stacks.
 * Solution: each stack jumps to 3 for push/pop.
 */
public class ManyStacksInOneArray<T> {
    private int[] lastIndexes;
    // We cannot hold generified T[] because constructor new T[capacity] does not work with Generics in Java
    private Object[] values;

    private int stacks = 0;

    /**
     * Construct for multiple stacks
     *
     * @param stacks   number of stacks
     * @param capacity max elements in each stack
     */
    public ManyStacksInOneArray(int stacks, int capacity) {
        values = new Object[capacity];
        lastIndexes = new int[stacks];
        for (int i = 0; i < stacks; i++) {
            lastIndexes[i] = -(stacks - i);
        }
        this.stacks = stacks;
    }

    /**
     * Push value o given stack
     */
    public void push(int stack, T value) {
        int lastIndex = lastIndexes[stack - 1];
        int newIndex = lastIndex + stacks;
        values[newIndex] = value;
        lastIndexes[stack - 1] = newIndex;
    }

    /**
     * Pop value from given stack
     */
    public T pop(int stack) {
        int lastIndex = lastIndexes[stack - 1];
        T value = (T) values[lastIndex];
        values[lastIndex] = null;
        lastIndexes[stack - 1] -= stacks;

        return value;
    }
}
