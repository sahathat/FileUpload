package file.upload.fileupload_forbackend.Controller;

import file.upload.fileupload_forbackend.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileController {
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @CrossOrigin
    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> saveFile(@PathVariable String filename) {
        Resource file = fileService.loadFileAsResource(filename);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(file);
    }

    @CrossOrigin
    @PostMapping("")
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        fileService.store(file);
        return "You successfully uploaded " + file.getOriginalFilename() + "!";
    }

    @CrossOrigin
    @DeleteMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Boolean> deleteFile(@PathVariable String filename) {
        boolean file = fileService.deleteFileAsResource(filename);
        return ResponseEntity.ok().body(file);
    }
}
