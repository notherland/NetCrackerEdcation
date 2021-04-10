/**
 * class describing three numbers
 */
public class ThreeNumbersImpl implements ThreeNumbers {
    /**
     * x value
     */
    private int x = 0;
    /**
     * y value
     */
    private int y = 0;
    /**
     * z value
     */
    private int z = 0;

    /**
     * set x value
     * @param x
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     * set y value
     * @param y
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * set z value
     * @param z
     */
    @Override
    public void setZ(int z) {
        this.z = z;
    }

    /**
     * @return x
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * @return y
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * @return z
     */
    @Override
    public int getZ() {
        return z;
    }

    /**
     * sorts x, y, z : x - min, y - middle, z - max
     */
    @Override
    public void sort() {
        int c;
        if (x > y) {
            c = x;
            x = y;
            y = c;
        }
        if (x > z) {
            c = x;
            x = z;
            z = c;
        }
        if (y > z) {
            c = y;
            y = z;
            z = c;
        }
    }

}
