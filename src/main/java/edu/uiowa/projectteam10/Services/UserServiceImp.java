//package edu.uiowa.projectteam10.Services;
//
//import edu.uiowa.projectteam10.converter.RegisterFormtoUser;
//import edu.uiowa.projectteam10.login.RegisterForm;
//import edu.uiowa.projectteam10.model.User;
//import edu.uiowa.projectteam10.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserServiceImp implements UserService{
//
//        private UserRepository userRepository;
//        private RegisterFormtoUser registerFormToUser;
//
//
//    @Autowired
//        public UserServiceImp(UserRepository userRepository, RegisterFormtoUser registerFormtoUser) {
//            this.userRepository = userRepository;
//            this.registerFormToUser = registerFormtoUser;
//        }
//
//
//        @Override
//        public List<User> listAll() {
//            List<User> products = new ArrayList<>();
//            userRepository.findAll().forEach(products::add); //fun with Java 8
//            return products;
//        }
//
//        @Override
//        public User getById(Long id) {
//            return userRepository.findById(id).orElse(null);
//        }
//
//    @Override
//    public User saveOrUpdate(User user) {
//        return null;
//    }
//
//
//    @Override
//    public void delete(Long id) {
//            UserRepository.deleteById(id);
//        }
//
//
//    @Override
//        public User saveOrUpdateProductForm(RegisterForm RegisterForm) {
//            User savedUser = saveOrUpdate(registerFormToUser.convert(RegisterForm));
//
//            System.out.println("Saved Product Id: " + savedProduct.getId());
//            return savedProduct;
//        }
//    }
//
//}
