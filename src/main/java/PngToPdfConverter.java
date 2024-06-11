import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;

import java.io.IOException;
import java.util.Scanner;

public class PngToPdfConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Type png file path: ");
        String pngPath = scan.nextLine().replaceAll("\"", "");
        System.out.print("Type pdf file path: ");
        String pdfPath = scan.nextLine().replaceAll("\"", "");
        try{
            pngToPdf(pngPath,pdfPath);
            System.out.println("Success: "+ pdfPath);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void pngToPdf(String pngPath, String pdfPath) throws IOException {
        PdfWriter pdfWriter = new PdfWriter(pdfPath);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        ImageData imageData = ImageDataFactory.create(pngPath);
        Image image = new Image(imageData);
        document.add(image);
        document.close();
    }
}
