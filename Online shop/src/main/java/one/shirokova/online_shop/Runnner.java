package one.shirokova.online_shop;

import lombok.extern.slf4j.Slf4j;
import one.shirokova.online_shop.bag.BagService;
import one.shirokova.online_shop.id_generator.IdGenerator;
import one.shirokova.online_shop.item.ItemDTO;
import one.shirokova.online_shop.item.ItemService;
import one.shirokova.online_shop.user.UserDTO;
import one.shirokova.online_shop.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static one.shirokova.online_shop.item.Category.*;
import static one.shirokova.online_shop.item.Color.*;

@Slf4j
@Component
public class Runnner implements CommandLineRunner {

    private final IdGenerator idGenerator;
    private final UserService userService;
    private final ItemService itemService;
    private final BagService bagService;

    public Runnner(IdGenerator idGenerator, UserService userService, ItemService itemService, BagService bagService) {
        this.idGenerator = idGenerator;
        this.userService = userService;
        this.itemService = itemService;
        this.bagService = bagService;
    }


    @Override
    public void run(String... args) throws Exception {
        log.info("APPLICATION STARTED");

        System.out.println("Welcome to online shop");
        System.out.println("List of commands: " +
                "Create user, " +
                "Choose category(doesn't work), " +
                "Show item list, " +
                "Show bag, " +
                "Add item to bag, " +
                "Remove item from bag");

        Scanner scanner = new Scanner(System.in);

        String command;


        while (true){
            System.out.println("Enter command: ");
            command = scanner.nextLine();

            log.trace("COMMAND IS " + command);

            switch (command){

                case "Create user": {
                    System.out.println("Enter login: ");
                    String login = scanner.nextLine();

                    System.out.println("Enter password: ");
                    String password = scanner.nextLine();

                    log.trace("Creating user with login " + login);

                    Map<Long, Integer> bagList = new HashMap<>();

//                    Bag bag = bagService.createBag(Bag.builder().
//                            items(bagList).build());
//
//                    bagService.createBag(bag);
//
//                    User user = userService.createUser((User.builder().login(login)
//                            .password(password)
//                            .bagId(bag.getId())
//                            .build()));
//
//                    log.trace("User with id" + user.getId() + " was created");

                    break;
                }

                case "Choose category": {
                    break;
                }

                case "Show bag": {
                    System.out.println("Enter login: ");
                    String login = scanner.nextLine();

                    log.trace("Showing " + login + "' bag");

                    UserDTO user = userService.findByLogin(login);

                    if (user != null) {
                        long bagId = user.getBagId();

                        System.out.println(bagService.getBag(bagId));
                    } else{
                        System.out.println("Please enter with login");
                    }

                    log.trace(login + "' bag was showed");

                    break;
                }

                case "Add item to bag": {
                    System.out.println("Enter login: ");
                    String login = scanner.nextLine();
                    UserDTO user = userService.findByLogin(login);
                    Long bagId = user.getBagId();

                    System.out.println("Enter item id: ");
                    String itemId = scanner.nextLine();

                    log.trace("Adding item " + itemId + " to bag");

                    bagService.addItemToBag(bagId, Long.parseLong(itemId));

                    log.trace("Added item " + itemId + " to bag");

                    break;
                }

                case  "Remove item from bag": {
                    System.out.println("Enter login: ");
                    String login = scanner.nextLine();
                    UserDTO user = userService.findByLogin(login);
                    Long bagId = user.getBagId();

                    System.out.println("Enter item id: ");
                    String id = scanner.nextLine();

                    log.trace("Removing item " + id + " to bag");

                    bagService.removeItemFromBag(bagId, Long.getLong(id));

                    log.trace("Added item " + id + " to bag");

                    break;
                }

                default: {
                    System.out.println("Wrong command");
                }

            }
        }
    }

    private void createItemList(){
        ItemDTO item1 = new ItemDTO(1l,  SHIRT, WHITE);
        ItemDTO item2 = new ItemDTO(2l, SHIRT, RED);
        ItemDTO item3 = new ItemDTO(3l, TROUSERS, BLACK);
        ItemDTO item4 = new ItemDTO(4l, SKIRT, GREEN);
        ItemDTO item5 = new ItemDTO(5l, SKIRT, YELLOW);

        itemService.createItem(item1);
        itemService.createItem(item2);
        itemService.createItem(item3);
        itemService.createItem(item4);
        itemService.createItem(item5);
    }
}
