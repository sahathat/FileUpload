package file.upload.fileupload_forbackend.Repository;

import file.upload.fileupload_forbackend.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}