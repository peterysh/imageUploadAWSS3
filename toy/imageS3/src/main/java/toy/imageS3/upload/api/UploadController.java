package toy.imageS3.upload;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Slf4j
@Controller
@RequestMapping("/upload")
public class UploadController {

    @ResponseBody
    @PostMapping("/image")
    public String uploadImage(@RequestBody(required = false) MultipartFile bodyFile,
                            @RequestParam(required = false) MultipartFile headerFile){
        log.info("body : {}", bodyFile.getOriginalFilename());
        log.info("header: {}", headerFile.getOriginalFilename());
        return "ok";
    }
//
//    @ResponseBody
//    @PostMapping("/file")
//    public File uploadFile(){
//
//    }
}
