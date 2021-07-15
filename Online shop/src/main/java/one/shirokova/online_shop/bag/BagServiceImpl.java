package one.shirokova.online_shop.bag;

import one.shirokova.online_shop.bag.dao.BagDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class BagServiceImpl implements BagService{
    private static final Logger logger = Logger.getLogger("bag_service");

    private final BagDao bagDao;

    public BagServiceImpl(BagDao bagDao) {
        this.bagDao = bagDao;
    }

    @Override
    public Bag createBag(Bag bag) {
        return bagDao.createBag(bag);
    }

    @Override
    public Bag getBag(long id) {
        return bagDao.getBag(id);
    }

    @Override
    public void removeBag(long id) {
        bagDao.removeBag(id);
    }

    @Override
    public Bag updateBag(Bag bag) {
        return bagDao.updateBag(bag);
    }
}
