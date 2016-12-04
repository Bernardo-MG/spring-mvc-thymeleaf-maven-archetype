
package ${package}.test.unit.controller;

import java.util.ArrayList;

import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ${package}.controller.report.ReportController;
import ${package}.model.persistence.DefaultExampleEntity;
import ${package}.service.DefaultExampleEntityReportService;
import ${package}.service.ExampleEntityReportService;
import ${package}.service.ExampleEntityService;

/**
 * Unit tests for {@link SponsorCreationController}, checking the methods for
 * showing the form.
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
     * Default constructor;
     */
    public TestReportController() {
        super();
    }

    /**
     * Sets up the mocked MVC context.
     */
    @BeforeTest
    public final void setUpMockContext() {
        mockMvc = MockMvcBuilders.standaloneSetup(getController()).build();
    }

    /**
     * Tests that the PDF view sets the expected attributes.
     */
    @Test
    public final void testPdf_ExpectedAttributeModel() throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(getRequest());

        // The operation was accepted
        result.andExpect(MockMvcResultMatchers.status().isOk());

        // The response indicates it is a PDF
        result.andExpect(MockMvcResultMatchers.content()
                .contentType(MediaType.APPLICATION_PDF));
    }

    /**
     * Returns a mocked controller.
     * <p>
     * It has all the dependencies stubbed.
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
