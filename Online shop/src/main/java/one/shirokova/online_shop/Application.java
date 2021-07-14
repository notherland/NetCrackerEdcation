package one.shirokova.online_shop;

import one.shirokova.online_shop.item.Item;
import one.shirokova.online_shop.item_list.ItemList;
import one.shirokova.online_shop.item_list.ItemListService;
import one.shirokova.online_shop.item_list.ItemListServiceImpl;
import one.shirokova.online_shop.user.User;
import one.shirokova.online_shop.user.UserService;
import one.shirokova.online_shop.user.UserServiceImpl;
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
                "Enter with login, " +
                "Choose category, " +
                "Show user's bag, " +
                "Add item to bag, " +
                "Remove item from bag");

        Scanner scanner = new Scanner(System.in);
        ItemList itemList = createItemList();
        ItemListService itemListService = new ItemListServiceImpl();
        User curUser = null;
        UserService userService = new UserServiceImpl();
        String command;


        while (true){
            System.out.println("Enter command: ");
            command = scanner.nextLine();

            logger.trace("COMMAND IS " + command);

            switch (command){

                case "Enter with login": {
                    System.out.println("Enter login: ");
                    String login = scanner.nextLine();

                    logger.trace("Creating user with login " + login);

                    curUser = userService.createUser(login);

                    logger.trace("User " + login + " was created");

                    break;
                }

                case "Choose category": {
                    System.out.println("Available categories : Shirt, Trousers, Skirt, Sweater" +
                            "\nEnter category: ");
                    String category = scanner.nextLine();

                    logger.trace("Chosen category is " + category);

                    Map<String, Item> categoryList= itemListService.getCategoryList(category, itemList);

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

                    if (curUser != null) {
                        System.out.println(curUser.getBag());
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

                    userService.addItem(curUser, id);

                    logger.trace("Added item " + id + " to bag");

                    break;
                }

                case  "Remove item from bag": {
                    System.out.println("Enter item id: ");
                    String id = scanner.nextLine();

                    logger.trace("Removing item " + id + " to bag");

                    if (!userService.removeItem(curUser, id))
                        System.out.println("No such item in bag");

                    logger.trace("Added item " + id + " to bag");

                    break;
                }
                default: {
                    System.out.println("Wrong command");
                }

            }
        }
    }

    private static ItemList createItemList(){
        ItemList itemList = new ItemList();

        Item item1 = new Item("Sh1", SHIRT, WHITE);
        Item item2 = new Item("Sh2", SHIRT, RED);
        Item item3 = new Item("Tr1", TROUSERS, BLACK);
        Item item4 = new Item("Sk1", SKIRT, GREEN);
        Item item5 = new Item("Sk2", SKIRT, YELLOW);

        itemList.addItem(item1);
        itemList.addItem(item2);
        itemList.addItem(item3);
        itemList.addItem(item4);
        itemList.addItem(item5);

        return itemList;
    }
}
