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

package ${package}.controller.report;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ${package}.service.ExampleEntityReportService;
import ${package}.service.ExampleEntityService;

import lombok.AllArgsConstructor;

/**
 * Controller for generating reports.
 * <p>
 * This serves as an adapter between the UI and the services layer.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
@Controller
@RequestMapping("/entity")
@AllArgsConstructor
public class ReportController {

    /**
     * Default report file name.
     */
    private static final String              FILENAME = "EntityReport";

    /**
     * Example entity report service.
     */
    private final ExampleEntityReportService exampleEntityReportService;

    /**
     * Example entity service.
     */
    private final ExampleEntityService       exampleEntityService;

    /**
     * Generates a PDF report and returns it in the response.
     *
     * @param response
     *            HTTP response
     * @throws IOException
     *             if there is a problem when streaming into the response
     */
    @GetMapping(path = "/pdf")
    public void getPdfReport(final HttpServletResponse response) throws IOException {
        final OutputStream output;

        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-disposition", String.format("inline; filename=%s.pdf", FILENAME));

        output = response.getOutputStream();

        exampleEntityReportService.getReport(exampleEntityService.getAllEntities(), output);
    }

}
