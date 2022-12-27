package toy.imageS3.upload.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import toy.imageS3.upload.service.FileStoreService;

import java.io.File;

@Slf4j
@Controller
@RequestMapping("/upload")
@RequiredArgsConstructor
public class UploadController {

    private final FileStoreService fileStoreService;

    @ResponseBody
    @PostMapping
    public Long uploadImage(@RequestBody MultipartFile bodyImage){
        return fileStoreService.saveItem(bodyImage, bodyImage.getOriginalFilename());
    }

    @GetMapping("/show")
    public String getFile(@RequestParam Long itemId){
        return "redirect:"+fileStoreService.getFileUrl(itemId);
    }
}
