//import cbsd.entity.User;
//import cbsd.service.UserService;
//import cbsd.service.UserServiceImpl;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
///**
//* Created by Dell on 2/3/2557.
//*/
//public class UserDAOTest {
//
//    UserService userService = null;
//@Before
//public void setUp() throws Exception{
//        userService = new UserServiceImpl();
//    }
//@Test
//    public void getUserTest() throws  Exception{
//        List<User> user = new ArrayList<User>();
//    user = userService.getUser();
//        assertEquals(0,user);
//    }
//
//    @Test
//    public void addUserTest() throws Exception{
//        User user = new User();
//        user.setUsername("chartchai");
//        user.setName("BaiTong");
//        user.setSurname("Surname");
//        user.setAddress("225");
//
//        User expectUser = new User();
//        user.setUsername("chartchai");
//        user.setName("BaiTong");
//        user.setSurname("Surname");
//        user.setAddress("225");
//
//        List<User> userList = new ArrayList<User>();
//        userList.add(expectUser);
//
//            userService.addUser(user);
//            assertEquals(userList,userService.getUser());
//
//
//
//
//    }
//
//
//}
