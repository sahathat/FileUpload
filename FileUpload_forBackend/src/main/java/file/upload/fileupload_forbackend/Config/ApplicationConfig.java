package file.upload.fileupload_forbackend.Config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
@Configuration
public class ApplicationConfig {
}
