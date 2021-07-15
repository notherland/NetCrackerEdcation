package one.shirokova.online_shop.id_generator;

import lombok.Data;

@Data
public class SequenceGenerator implements IdGenerator{
    private long id = 0;

    @Override
    public long getId() {
        return id++;
    }
}
