package file.upload.fileupload_forbackend.Service;

import file.upload.fileupload_forbackend.Entity.User;
import file.upload.fileupload_forbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserById(Integer id){
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,id + "is not found"));
    }

    public User save(User user){
        return userRepository.saveAndFlush(user);
    }

    public void deleteUser(Integer id) {
        userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,id + "is not found"));
        userRepository.deleteById(id);
    }
}
