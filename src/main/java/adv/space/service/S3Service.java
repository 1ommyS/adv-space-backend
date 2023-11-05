package adv.space.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectRequest;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystemException;

/**
 * @author 1ommy
 * @version 05.11.2023
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class S3Service {
    private final AmazonS3 s3Client;

    @Value("${application.bucket.name}")
    private String bucketName;

    @PostConstruct
    public void createBucket(String bucketName) {
        log.info("AvatarManagementService.createBucket | try to create bucket with name " + bucketName);
        Bucket bucket = s3Client.createBucket(bucketName);

        if (bucket == null) {
            log.error("AvatarManagementService.createBucket | failed creating bucket with name " + bucketName);
        }
    }

    public String uploadFile(MultipartFile multipartFile) throws FileSystemException {
        createBucket(bucketName);
        var file = convertMultipartFileToFile(multipartFile);
        s3Client.putObject(new PutObjectRequest(bucketName, file.getName(), file));

        if (!file.delete()) {
            log.error("AvatarManagementService.uploadFile | Error with deleting file from disk storage. Filename is " + file.getName());
            throw new FileSystemException("Проблема с удалением файла!");
        }

        log.info("AvatarManagementService.uploadFile | Delete file from disk storage. Filename is " + file.getName());

        return file.getName();
    }

    private File convertMultipartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("error converting multipart file to file ", e);
        }
        return convertedFile;
    }


}
