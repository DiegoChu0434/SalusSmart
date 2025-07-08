package Interfaces;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PDFReportGenerator {
    
    public static void generarReporteUsuarios(List<Usuario> usuarios, String rutaArchivo) throws DocumentException, IOException {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));
            document.open();
            
            // Agregar título
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLUE);
            Paragraph title = new Paragraph("Reporte de Usuarios", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            document.add(title);
            
            // Crear tabla
            PdfPTable table = new PdfPTable(9); // 9 columnas
            float[] columnWidths = {1f, 2f, 2f, 1.5f, 2f, 2f, 1.5f, 2.5f, 1.5f};
            table.setWidths(columnWidths);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            
            // Estilo para encabezados
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
            
            // Encabezados
            String[] headers = {"ID", "Nombres", "Apellidos", "DNI", "Fecha Nac.", 
                              "Dirección", "Contacto", "Correo", "Rol"};
            
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
                cell.setBackgroundColor(BaseColor.BLUE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPadding(5);
                table.addCell(cell);
            }
            
            // Datos
            Font dataFont = FontFactory.getFont(FontFactory.HELVETICA, 10);
            for (Usuario usuario : usuarios) {
                addCell(table, String.valueOf(usuario.getId_usuario()), dataFont);
                addCell(table, usuario.getNombre(), dataFont);
                addCell(table, usuario.getApellido(), dataFont);
                addCell(table, String.valueOf(usuario.getDni()), dataFont);
                addCell(table, usuario.getFechaNacimiento(), dataFont);
                addCell(table, usuario.getDireccion(), dataFont);
                addCell(table, usuario.getCelular(), dataFont);
                addCell(table, usuario.getCorreo(), dataFont);
                addCell(table, usuario.getRol(), dataFont);
            }
            
            document.add(table);
            
            // Agregar fecha de generación
            Font footerFont = FontFactory.getFont(
    FontFactory.HELVETICA_OBLIQUE,  // itálica
    10, 
    BaseColor.BLACK
);
            Paragraph footer = new Paragraph("Reporte generado el: " + 
                LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE), footerFont);
            footer.setSpacingBefore(20);
            footer.setAlignment(Element.ALIGN_RIGHT);
            document.add(footer);
            
        } finally {
            if (document != null && document.isOpen()) {
                document.close();
            }
        }
    }
    
    private static void addCell(PdfPTable table, String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(5);
        table.addCell(cell);
    }
} 