import java.util.ArrayList;
import java.util.List;

public class Recaman {
    private List<Integer> recamanInts;

    //switched == true if the last generated Recaman int was
    //generated from a switch from adding vs subtracting
    //or vise versa.
    private boolean switched;
    private boolean prevAdded;

    Recaman() {
        recamanInts = new ArrayList<Integer>();
        recamanInts.add(0);
        prevAdded = true;
        switched = false;
    }

    //returns true if added, false if subtracted
    public boolean nextRecaman() {
        int size = recamanInts.size();
        int lastRecaman = recamanInts.get(size - 1);
        int temp = lastRecaman - size;
        if (temp < 0 || recamanInts.contains(temp)) {
            recamanInts.add(lastRecaman + size);
            switched = prevAdded ? true : false;
            prevAdded = true;

            return true;

        } else {
            recamanInts.add(temp);
            switched = prevAdded ? false : true;
            prevAdded = false;

            return false;
        }
    }

    //generates the first n Recaman ints
    public void generateRecaman(int n) {
        for (int i = 1; i < n; i++) {
            nextRecaman();
        }
    }

    public int getSize() {
        return recamanInts.size();
    }

    public boolean isSwitched() {
        return switched;
    }
}
