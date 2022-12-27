package toy.imageS3.upload.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import toy.imageS3.upload.domain.Item;
import toy.imageS3.upload.domain.UploadFile;
import toy.imageS3.upload.repository.ItemRepository;

import java.util.UUID;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class FileStoreService {

    private final ItemRepository itemRepository;
    private final FileUploadService fileUploadService;

    public Long saveItem(MultipartFile multipartFile, String uploadFileName){
        String storeFileName = createStoreFileName(uploadFileName);
        Item item = Item.createItem(uploadFileName, storeFileName);
        fileUploadService.uploadCloud(multipartFile, storeFileName);
        return itemRepository.save(item).getId();
    }

    private String createStoreFileName(String uploadFileName) {
        String ext = extractExt(uploadFileName);
        String uuId = UUID.randomUUID().toString();
        log.info("url={}.{}",uuId,ext);
        return uuId+"."+ext;
    }

    private String extractExt(String uploadFileName) {
        int pos = uploadFileName.lastIndexOf('.');
        return uploadFileName.substring(pos+1);
    }

    public String getFileUrl(Long itemId){
        UploadFile fileInfo = getFileInfo(itemId);
        return fileUploadService.getFileUrl(fileInfo.getStoreFileName());
    }
    public UploadFile getFileInfo(Long itemId){
        return itemRepository.findById(itemId).get().getAttachFile();
    }
}
