package ua.epam.spring.hometask.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ua.epam.spring.hometask.models.Role;
import ua.epam.spring.hometask.models.User;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ua.epam.spring.hometask.utils.Constants.UPLOADING_DIR;

public class PdfUtil {

    public static Document createPdfResponseFile(Iterable<User> users) throws Exception {
        Document document = new Document();
        File newFile = new File(UPLOADING_DIR + "users.pdf");
        newFile.createNewFile();
        PdfWriter.getInstance(document, new FileOutputStream(UPLOADING_DIR + "users.pdf"));
        document.open();
        document.add(new Paragraph("Users"));
        PdfPTable table = new PdfPTable(4);
        List<String[]> row = new ArrayList<>();

        for (User user : users) {
            String[] data = new String[4];
            data[0] = user.getId().toString();
            data[1] = user.getFirstName();
            data[2] = user.getLastName();
            data[3] = user.getRoles().stream().map(Role::toString).collect(Collectors.joining(","));
            row.add(data);
        }

        for (String[] cols : row) {
            for (String col : cols) {
                table.addCell(col);
            }
        }

        document.add(table);
        document.close();

        return document;
    }
}
