package one.shirokova.online_shop;

import one.shirokova.online_shop.bag.Bag;
import one.shirokova.online_shop.bag.BagService;
import one.shirokova.online_shop.bag.BagServiceImpl;
import one.shirokova.online_shop.bag.dao.BagDao;
import one.shirokova.online_shop.bag.dao.BagDaoImpl;
import one.shirokova.online_shop.id_generator.IdGenerator;
import one.shirokova.online_shop.id_generator.SequenceGenerator;
import one.shirokova.online_shop.item.Item;
import one.shirokova.online_shop.item.ItemService;
import one.shirokova.online_shop.item.ItemServiceImpl;
import one.shirokova.online_shop.item.dao.ItemDao;
import one.shirokova.online_shop.item.dao.ItemDaoImpl;
import one.shirokova.online_shop.user.User;
import one.shirokova.online_shop.user.UserService;
import one.shirokova.online_shop.user.UserServiceImpl;
import one.shirokova.online_shop.user.dao.UserDao;
import one.shirokova.online_shop.user.dao.UserDaoImpl;
import org.apache.log4j.Logger;

import java.util.*;

import static one.shirokova.online_shop.item.Category.*;
import static one.shirokova.online_shop.item.Color.*;

public class Application {
    public static void main(String[] argv){
        Logger logger = Logger.getLogger("application");

        logger.info("APPLICATION STARTED");

        System.out.println("Welcome to online shop");
        System.out.println("List of commands: " +
                "Create user, " +
                "Choose category, " +
                "Show user's bag, " +
                "Add item to bag, " +
                "Remove item from bag");

        Scanner scanner = new Scanner(System.in);
        IdGenerator ig = new SequenceGenerator();

        ItemDao itemList = createItemList(ig);
        ItemService itemService = new ItemServiceImpl(itemList);

        UserDao userDao = new UserDaoImpl(ig);
        UserService userService = new UserServiceImpl(userDao);

        BagDao bagDao = new BagDaoImpl(ig);
        BagService bagService = new BagServiceImpl(bagDao);

        String command;

        Map<Long, Integer> bag = new HashMap<>();

        User curUser;
        Bag curBag;


        while (true){
            System.out.println("Enter command: ");
            command = scanner.nextLine();

            logger.trace("COMMAND IS " + command);

            switch (command){

                case "Create user": {
                    System.out.println("Enter login: ");
                    String login = scanner.nextLine();

                    System.out.println("Enter password: ");
                    String password = scanner.nextLine();

                    logger.trace("Creating user with login " + login);

                    curBag = bagDao.createBag(Bag.builder().
                            items(bag).build());

                    bagService.createBag(curBag);

                    curUser = userDao.createUser((User.builder().login(login)
                                                                .password(password)
                                                                .bagId(curBag.getId())
                                                                .build()));

                    logger.trace("User with id" + curUser.getId() + " was created");

                    break;
                }

                case "Choose category": {
                    System.out.println("Available categories : Shirt, Trousers, Skirt, Sweater" +
                            "\nEnter category: ");
                    String category = scanner.nextLine();

                    logger.trace("Chosen category is " + category);

                    Map<String, Item> categoryList = itemService.getCategoryList(category, itemList);

                    if (categoryList == null) {
                        System.out.println("No such category");
                    } else {
                        System.out.println(categoryList);
                    }

                    break;
                }

                case "Show bag": {
                    System.out.println("Enter login: ");
                    String login = scanner.nextLine();

                    logger.trace("Showing " + login + "' bag");

                    curUser = userService.getUserByLogin(login);

                    if (curUser != null) {
                        long bagId = curUser.getBagId();

                        System.out.println(bagService.getBag(bagId));
                    } else{
                        System.out.println("Please enter with login");
                    }

                    logger.trace(login + "' bag was showed");

                    break;
                }

                case "Add item to bag": {
                    System.out.println("Enter item id: ");
                    String id = scanner.nextLine();

                    logger.trace("Adding item " + id + " to bag");

                    logger.trace("Added item " + id + " to bag");

                    break;
                }

                case  "Remove item from bag": {
                    System.out.println("Enter item id: ");
                    String id = scanner.nextLine();

                    logger.trace("Removing item " + id + " to bag");


                    logger.trace("Added item " + id + " to bag");

                    break;
                }
                default: {
                    System.out.println("Wrong command");
                }

            }
        }
    }

    private static ItemDao createItemList(IdGenerator ig){
        ItemDao itemList = new ItemDaoImpl(ig);

        Item item1 = new Item(1l,  SHIRT, WHITE);
        Item item2 = new Item(2l, SHIRT, RED);
        Item item3 = new Item(3l, TROUSERS, BLACK);
        Item item4 = new Item(4l, SKIRT, GREEN);
        Item item5 = new Item(5l, SKIRT, YELLOW);

        itemList.createItem(item1);
        itemList.createItem(item2);
        itemList.createItem(item3);
        itemList.createItem(item4);
        itemList.createItem(item5);

        return itemList;
    }
}
