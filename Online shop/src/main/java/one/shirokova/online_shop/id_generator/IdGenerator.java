package one.shirokova.online_shop.id_generator;

public interface IdGenerator {
    public static final SequenceGenerator sequenceGenerator = new SequenceGenerator();

    public long getId();
}
