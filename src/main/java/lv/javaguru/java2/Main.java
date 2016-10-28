package lv.javaguru.java2;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.Registration;
import lv.javaguru.java2.domain.User;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        User user = new User();
        UserDAO userDAO = new UserDAOImpl();
        Registration registration = new Registration();
        Scanner scanner = new Scanner(System.in);
//        do {
//            System.out.println("enter login");
//            user.setLogin(scanner.nextLine());
//            user.setFirstName(user.getLogin());
//            System.out.println("enter password");
//            user.setPassword(scanner.nextLine());
//            user.setLastName(user.getPassword());
////            System.out.println("enter id");
////            user.setUserId(scanner.nextLong());
////            userDAO.update(user);
//            registration.recordNewUser(user);
//        } while (user.getUserId() == null);
        userDAO.delete((long)1005);
        userDAO.getAll().forEach(System.out::println);

    }
}
