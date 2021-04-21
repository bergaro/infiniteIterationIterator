import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    private final int min;
    private final int max;
    private final List<Integer> iterList = new ArrayList<>();
    private int currentPos = 0;

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
    }

    private void initList() {
        int randomInt;
        randomInt = new Random().nextInt(max + 1 - min) + min;
        iterList.add(randomInt);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                initList();
                return currentPos < iterList.size();
            }

            @Override
            public Integer next() {
                int returnVar = iterList.get(currentPos);
                currentPos++;
                return returnVar;
            }
        };
    }

    //...
}