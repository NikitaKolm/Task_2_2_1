package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
//Без машин
        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//С машинами
        userService.add(new User("User5", "Lastname5", "user5@mail.ru", new Car("model1", 1)));
        userService.add(new User("User6", "Lastname6", "user6@mail.ru", new Car("model2", 2)));
//Поиск по машине
        User user7 = new User("User7", "Lastname7", "user7@mail.ru", new Car("model3", 3));
        userService.add(user7);
        User result = userService.getUserByCar(user7.getCar().getModel(), user7.getCar().getSeries());
        System.out.println("Пользователь когорого искали:");
        System.out.println(user7);
        System.out.println("Пользовательно которого нашли:");
        System.out.println(result);

        context.close();
    }
}
