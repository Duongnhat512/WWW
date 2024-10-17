package bai7;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.sql.*;

@WebServlet(name = "FileUploadDBServlet", urlPatterns = {"/fileUploadDB"})
@MultipartConfig(
        maxFileSize = 16177215
)
public class FileUploadDBServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    private static final int BUFFER_SIZE = 4096;
    private static final String SAVE_DIR = "images";

    private String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=UploadFileServletDB;encrypt=false";
    private String dbUser = "sa";
    private String dbPass = "sapassword";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        InputStream inputStream = null;

        Part filePart = request.getPart("photo");
        String fileUploadName = "";
        if (filePart != null) {
            fileUploadName = filePart.getName();
            inputStream = filePart.getInputStream();
        }

        Connection con = null;
        String message = null;
        String filePath = "D:\\Study\\WWW\\ThucHanh\\21110291_NguyenNhatDuong_Tuan2\\files\\" + fileUploadName + ".jpg";
        try{
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            con = DriverManager.getConnection(dbURL, dbUser, dbPass);
            String sql = "INSERT INTO contacts (first_name, last_name, photo) values (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);

            if (inputStream != null){
                statement.setBlob(3, inputStream);
            }
            int row = statement.executeUpdate();
            if(row > 0){
                message = "File uploaded and saved into database";
            }

            String sql1 = "Select photo From contacts Where first_name = ? and last_name = ?";
            PreparedStatement statement1 = con.prepareStatement(sql1);
            statement1.setString(1, firstName);
            statement1.setString(2, lastName);

            ResultSet rs = statement1.executeQuery();
            while (rs.next()){
                Blob blob = rs.getBlob("photo");
                inputStream = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream(filePath);

                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1){
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
                outputStream.close();
            }
        }catch (SQLException e){
            message = "ERROR: " + e.getMessage();
            e.printStackTrace();
        } finally {
            if (con != null){
                try {
                    con.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        request.setAttribute("message", message);
//        getServletContext().getRequestDispatcher("/MessageServlet").forward(request, response);
    }
}
