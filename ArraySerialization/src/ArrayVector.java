import java.io.Serializable;
import java.util.Arrays;

public class ArrayVector implements Serializable{


    private double[] vector = new double[0];

    public void set(double... elements) {
        this.vector = new double[elements.length];

        for (int i = 0; i < elements.length; i++) {
            vector[i] = elements[i];
        }
    }

    public double[] get() {
        return vector;
    }

    public ArrayVector clone() {
        ArrayVector vector = new ArrayVector();

        vector.set(this.vector);
        return vector;
    }

    public int getSize() {
        return vector.length;
    }

    public void set(int index, double value) {

        if (index >= vector.length) {
            double[] arrayVector = new double[index + 1];

            System.arraycopy(vector, 0, arrayVector, 0, vector.length);
            arrayVector[index] = value;
            vector = arrayVector;
        } else if (index >= 0)
            vector[index] = value;
    }

    public double get(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= vector.length) throw new ArrayIndexOutOfBoundsException();

        return vector[index];
    }

    public double getMax() {
        if (vector.length == 0)
            return 0;

        double max = vector[0];
        for (int i = 0; i < vector.length; i++)
            max = Math.max(vector[i], max);
        return max;
    }

    public double getMin() {
        if (vector.length == 0)
            return 0;

        double min = vector[0];
        for (int i = 0; i < vector.length; i++)
            min = Math.min(vector[i], min);
        return min;

    }

    public void sortAscending() {
        Arrays.sort(vector);

    }

    public void mult(double factor) {

        for (int i = 0; i < vector.length; i++) {
            vector[i] = vector[i] * factor;
        }
    }

    public ArrayVector sum(ArrayVector anotherVector) {
        for (int i = 0; i < Math.max(vector.length, anotherVector.getSize()); i++)
            vector[i] = vector[i] + anotherVector.get(i);
        return this;
    }

    public double scalarMult(ArrayVector anotherVector) {
        double mult = 0;

        for (int i = 0; i < Math.max(vector.length, anotherVector.getSize()); i++) {
            vector[i] = vector[i] * anotherVector.get(i);
            mult = mult + vector[i];
        }
        return mult;
    }

    public double getNorm() {

        double mult = 0;
        for (int i = 0; i < vector.length; i++) {
            vector[i] = vector[i] * vector[i];
            mult = mult + vector[i];
        }
        return Math.sqrt(mult);
    }
}

