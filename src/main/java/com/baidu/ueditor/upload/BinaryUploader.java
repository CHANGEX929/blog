package com.baidu.ueditor.upload;

import com.baidu.ueditor.PathFormat;
import com.baidu.ueditor.define.AppInfo;
import com.baidu.ueditor.define.BaseState;
import com.baidu.ueditor.define.FileType;
import com.baidu.ueditor.define.State;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.changex.blog.tools.AliyunOssUtils;
import com.changex.blog.tools.UUIDUtils;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class BinaryUploader {

    public static final State save(HttpServletRequest request,
                                   Map<String, Object> conf) {
        // FileItemStream fileStream = null;
        // boolean isAjaxUpload = request.getHeader( "X_Requested_With" ) != null;

        if (!ServletFileUpload.isMultipartContent(request)) {
            return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
        }

        // ServletFileUpload upload = new ServletFileUpload(
        //  new DiskFileItemFactory());
        //
        // if ( isAjaxUpload ) {
        //     upload.setHeaderEncoding( "UTF-8" );
        // }

        try {
            // FileItemIterator iterator = upload.getItemIterator(request);
            //
            // while (iterator.hasNext()) {
            //  fileStream = iterator.next();
            //
            //  if (!fileStream.isFormField())
            //      break;
            //  fileStream = null;
            // }
            //
            // if (fileStream == null) {
            //  return new BaseState(false, AppInfo.NOTFOUND_UPLOAD_DATA);
            // }
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartRequest.getFile(conf.get("fieldName").toString());
            if (multipartFile == null) {
                return new BaseState(false, AppInfo.NOTFOUND_UPLOAD_DATA);
            }

            String savePath = (String) conf.get("savePath");
            //String originFileName = fileStream.getName();
            String originFileName = multipartFile.getOriginalFilename();
            String suffix = FileType.getSuffixByFilename(originFileName);

            originFileName = originFileName.substring(0,
                    originFileName.length() - suffix.length());
            savePath = savePath + suffix;

            long maxSize = ((Long) conf.get("maxSize")).longValue();

            if (!validType(suffix, (String[]) conf.get("allowFiles"))) {
                return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
            }

            savePath = PathFormat.parse(savePath, originFileName);

            String physicalPath = conf.get("rootPath") + savePath;

            //InputStream is = fileStream.openStream();
            // InputStream is = multipartFile.getInputStream();
            String ossKey = AliyunOssUtils.upLoadFileByFilePath("blog_img/" + UUIDUtils.uuid() + originFileName, multipartFile.getBytes());
            State storageState = new BaseState(true);
            /*StorageManager.saveFileByInputStream(is,
                    physicalPath, maxSize);
            is.close();*/


            if (storageState.isSuccess()) {
                storageState.putInfo("size", multipartFile.getSize());
                storageState.putInfo("title", multipartFile.getName());
                storageState.putInfo("url", AliyunOssUtils.getFileUrl(ossKey).toString());
                storageState.putInfo("type", suffix);
                storageState.putInfo("original", originFileName + suffix);
            }

            return storageState;
            // } catch (FileUploadException e) {
            //  return new BaseState(false, AppInfo.PARSE_REQUEST_ERROR);
        } catch (IOException e) {
        }
        return new BaseState(false, AppInfo.IO_ERROR);
    }

    private static boolean validType(String type, String[] allowTypes) {
        List<String> list = Arrays.asList(allowTypes);

        return list.contains(type);
    }
}
