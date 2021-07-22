package one.shirokova.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

@Slf4j
@Component
class Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        String command;

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Enter command: ");
            command = scanner.nextLine();

            log.trace("COMMAND IS " + command);

            switch (command) {

                case "Get hello world": {
                    RestTemplate restTemplate = new RestTemplate();
                    String fooResourceUrl
                            = "http://localhost:8080/hello-world";
                    ResponseEntity<String> response
                            = restTemplate.getForEntity(fooResourceUrl, String.class);
                    System.out.println(response);
                }
            }
        }
    }
}