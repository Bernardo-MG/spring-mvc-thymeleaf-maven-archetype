/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) ${currentYear} the original author or authors.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package ${package}.service;

import java.io.OutputStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import ${package}.model.ExampleEntity;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Default implementation of the report service.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
@Service
public final class DefaultExampleEntityReportService
        implements ExampleEntityReportService {

    /**
     * Chapter font.
     */
    private final Font chapterFont   = FontFactory
            .getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);

    /**
     * Paragraph font.
     */
    private final Font paragraphFont = FontFactory
            .getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

    public DefaultExampleEntityReportService() {
        super();
    }

    @Override
    public final void getReport(final Iterable<? extends ExampleEntity> data,
            final OutputStream output) {
        final Document document;
        final Paragraph header;
        final Paragraph body;

        document = new Document();
        try {
            PdfWriter.getInstance(document, output);
        } catch (final DocumentException e) {
            throw new RuntimeException(e);
        }
        document.open();

        header = getHeader();
        body = getBody(data);

        try {
            document.add(header);
            document.add(body);
        } catch (final DocumentException e) {
            throw new RuntimeException(e);
        }
        document.close();
    }

    /**
     * Builds the header paragraph.
     * 
     * @return the header paragraph
     */
    private final Paragraph getHeader() {
        final Chunk chunk;

        chunk = new Chunk("Report", chapterFont);

        return new Paragraph(chunk);
    }

    /**
     * Builds the report body.
     * 
     * @param data
     *            data to print
     * @return the body paragraph
     */
    private final Paragraph
            getBody(final Iterable<? extends ExampleEntity> data) {
        final Paragraph paragraph;
        final PdfPTable table;

        paragraph = new Paragraph();

        paragraph.add(new Paragraph(" ", paragraphFont));

        table = new PdfPTable(2);
        paragraph.add(table);

        // Adds headers
        Stream.of("id", "name").forEach(columnTitle -> {
            final PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(columnTitle));
            table.addCell(header);
        });

        StreamSupport.stream(data.spliterator(), false).forEach((entity) -> {
            table.addCell(String.valueOf(entity.getId()));
            table.addCell(entity.getName());
        });

        return paragraph;
    }

}
