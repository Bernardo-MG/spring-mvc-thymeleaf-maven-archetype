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

package ${package}.test.unit.controller.report;

import java.util.ArrayList;

import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import ${package}.controller.report.ReportController;
import ${package}.model.persistence.DefaultExampleEntity;
import ${package}.service.DefaultExampleEntityReportService;
import ${package}.service.ExampleEntityReportService;
import ${package}.service.ExampleEntityService;

/**
 * Unit tests for {@link ReportController}, checking the methods for generating
 * reports.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestReportController {

    /**
     * PDF view URL.
     */
    private static final String URL_PDF = "/entity/pdf";

    /**
     * Mocked MVC context.
     */
    private MockMvc             mockMvc;

    /**
     * Default constructor.
     */
    public TestReportController() {
        super();
    }

    /**
     * Sets up the mocked MVC context.
     */
    @Before
    public final void setUpMockContext() {
        mockMvc = MockMvcBuilders.standaloneSetup(getController())
                .alwaysExpect(MockMvcResultMatchers.status().isOk())
                .alwaysExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_PDF)).build();
    }

    /**
     * Verifies that the PDF view sets the expected content.
     */
    @Test
    public final void testReport_Empty_ExpectedContent() throws Exception {
        mockMvc.perform(getRequest());
    }

    /**
     * Verifies that the PDF view sets the expected attributes.
     */
    @Test
    public final void testReport_Empty_ExpectedHeader() throws Exception {
        final ResultActions result; // Request result
        final String content;       // Content header

        result = mockMvc.perform(getRequest());

        content = result.andReturn().getResponse().getHeader("Content-disposition");

        Assert.assertEquals("inline; filename=EntityReport.pdf", content);
    }

    /**
     * Returns a controller with mocked dependencies.
     * 
     * @return a mocked controller
     */
    private final ReportController getController() {
        final ExampleEntityService service; // Mocked unit codex
        final ExampleEntityReportService reportService; // Mocked unit codex
        final Iterable<DefaultExampleEntity> entities;

        entities = new ArrayList<DefaultExampleEntity>();

        service = Mockito.mock(ExampleEntityService.class);
        Mockito.when(service.getAllEntities()).thenReturn(entities);

        reportService = new DefaultExampleEntityReportService();

        return new ReportController(service, reportService);
    }

    /**
     * Returns a request builder for getting the PDF view.
     * 
     * @return a request builder for the PDF view
     */
    private final RequestBuilder getRequest() {
        return MockMvcRequestBuilders.get(URL_PDF);
    }

}
