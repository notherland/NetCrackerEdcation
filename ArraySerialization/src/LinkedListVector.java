import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class LinkedListVector implements Serializable {

    private List<Double> vector = new LinkedList<>();

    public void set(double... elements) {
        vector.clear();
        for (int i = 0; i < elements.length; i++) {
            vector.add(elements[i]);
        }
    }

    public List<Double> get() {
        return vector;
    }

    public int getSize() {
        return vector.size();
    }

    public void set(int index, double value) {

        if (index >= vector.size()) {
            for (int i = vector.size(); i <= index; i++)
                vector.add(0d);
            vector.set(index, value);
        } else if (index >= 0)
            vector.set(index, value);
    }

    public double get(int index) {
        return vector.get(index);
    }

    public double getMax() {
        if (vector.size() == 0)
            return 0;

        double max = vector.get(0);
        for (int i = 0; i < vector.size(); i++)
            max = Math.max(vector.get(i), max);
        return max;
    }

    public double getMin() {
        if (vector.size() == 0)
            return 0;

        double min = vector.get(0);
        for (int i = 0; i < vector.size(); i++)
            min = Math.min(vector.get(i), min);
        return min;

    }

    public void mult(double factor) {

        for (int i = 0; i < vector.size(); i++) {
            vector.set(i, vector.get(i) * factor);
        }
    }

    public LinkedListVector sum(LinkedListVector anotherVector) {
        for (int i = 0; i < Math.max(vector.size(), anotherVector.getSize()); i++)
            vector.set(i, (double) vector.get(i) + (double) anotherVector.get(i));
        return this;
    }

    public double scalarMult(LinkedListVector anotherVector) {
        double mult = 0;

        for (int i = 0; i < Math.max(vector.size(), anotherVector.getSize()); i++) {
            vector.set(i, vector.get(i) * anotherVector.get(i));
            mult = mult + vector.get(i);
        }
        return mult;
    }

    public double getNorm() {

        double mult = 0;
        for (int i = 0; i < vector.size(); i++) {
            vector.set(i, vector.get(i) * vector.get(i));
            mult = mult + vector.get(i);
        }
        return Math.sqrt(mult);
    }
}

