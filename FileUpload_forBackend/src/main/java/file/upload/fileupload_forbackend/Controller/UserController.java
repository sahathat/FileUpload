package file.upload.fileupload_forbackend.Controller;

import file.upload.fileupload_forbackend.Entity.User;
import file.upload.fileupload_forbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @CrossOrigin
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
