package toy.imageS3.upload.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileUploadService {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String S3Bucket;

    public void uploadCloud(MultipartFile multipartFile, String storeFileName){
        long size = multipartFile.getSize();
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(size);
        objectMetadata.setContentType(multipartFile.getContentType());

        putObjectInAWS(multipartFile, storeFileName, objectMetadata);
    }

    private void putObjectInAWS(MultipartFile multipartFile, String storeFileName, ObjectMetadata objectMetadata) {
        try {
            amazonS3Client.putObject(
                    new PutObjectRequest(S3Bucket, storeFileName,
                            multipartFile.getInputStream(), objectMetadata)
                            .withCannedAcl(CannedAccessControlList.PublicRead)
            );
        }catch(IOException e){
            throw new IllegalStateException();
        }
    }

    public String getFileUrl(String storeFileName){
        return amazonS3Client.getUrl(S3Bucket, storeFileName).toString();
    }
}
