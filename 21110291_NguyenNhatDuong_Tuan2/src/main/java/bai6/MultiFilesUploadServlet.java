package bai6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


import java.io.File;
import java.io.IOException;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 3, // 3MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
@WebServlet(name = "uploadFile", value = "/upload-files")
public class MultiFilesUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String uploadPath = "D:\\Study\\WWW\\ThucHanh\\21110291_NguyenNhatDuong_Tuan2\\files";

    public void init(){
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()){
            uploadDir.mkdir();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            for(Part filePart : request.getParts()){
                if (filePart == null || filePart.getSubmittedFileName() == null || filePart.getSubmittedFileName().isEmpty()){
                    continue;
                }
                String fileName = filePart.getSubmittedFileName();
                filePart.write(uploadPath + File.separator + fileName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}

