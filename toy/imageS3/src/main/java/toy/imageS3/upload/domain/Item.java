package toy.imageS3.upload.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private UploadFile attachFile;

    private Item(UploadFile attachFile) {
        this.attachFile = attachFile;
    }

    public static Item createItem(String uploadFileName,String storeFileName){
        UploadFile uploadFile = new UploadFile(uploadFileName, storeFileName);
        return new Item(uploadFile);
    }
}
