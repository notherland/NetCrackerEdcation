/**
 * interface describing three numbers
 */
public interface ThreeNumbers {
    /**
     * set x value
     * @param x
     */
    void setX(int x);

    /**
     * set y value
     * @param y
     */
    void setY(int y);

    /**
     * set z value
     * @param z
     */
    void setZ(int z);

    /**
     * return x value
     * @return x
     */
    int getX();

    /**
     * return y value
     * @return
     */
    int getY();

    /**
     * return z value
     * @return
     */
    int getZ();

    /**
     * sort x, y and z
     */
    void sort();
}
