
package ${package}.test.unit.controller;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ${package}.controller.entity.ExampleEntityViewController;
import ${package}.model.persistence.DefaultExampleEntity;
import ${package}.service.ExampleEntityService;
import ${package}.test.config.BeanConfig;
import ${package}.test.config.UrlConfig;

/**
 * Unit tests for {@link SponsorCreationController}, checking the methods for
 * sending the form data.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestExampleEntityViewControllerSendForm {

    /**
     * The view after the form.
     */
    private static final String VIEW_FORM = "/entity/form";

    /**
     * Mocked MVC context.
     */
    private MockMvc             mockMvc;

    /**
     * Default constructor;
     */
    public TestExampleEntityViewControllerSendForm() {
        super();
    }

    /**
     * Sets up the mocked MVC context.
     */
    @BeforeTest
    public final void setUpMockContext() {
        mockMvc = MockMvcBuilders.standaloneSetup(getController())
                .alwaysExpect(MockMvcResultMatchers.status().isOk()).build();
    }

    /**
     * Tests that after receiving valid form data the expected attributes are
     * loaded into the model.
     */
    @Test
    public final void testSendFormData_ExpectedAttributeModel()
            throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(getFormRequest());

        // The response model contains the expected attributes
        result.andExpect(MockMvcResultMatchers.model().attributeExists("form"));
    }

    /**
     * Tests that after received valid form data the expected view is returned.
     */
    @Test
    public final void testSendFormData_ExpectedView() throws Exception {
        final ResultActions result; // Request result

        // TODO: Just verify it is not this same view
        result = mockMvc.perform(getFormRequest());

        // The view is valid
        result.andExpect(MockMvcResultMatchers.view().name("entity/list"));
    }

    /**
     * Returns a mocked controller.
     * <p>
     * It can create mocked sponsor, sponsor team and units.
     * 
     * @return a mocked controller
     */
    @SuppressWarnings("unchecked")
    private final ExampleEntityViewController getController() {
        final ExampleEntityService service;
        final Collection<DefaultExampleEntity> entities;

        service = Mockito.mock(ExampleEntityService.class);

        entities = new LinkedList<>();

        Mockito.when(service.getAllEntities()).thenReturn(entities);

        return new ExampleEntityViewController(service);
    }

    /**
     * Returns a request builder for posting valid form data.
     * 
     * @return a request builder with valid form data
     */
    private final RequestBuilder getFormRequest() {
        return MockMvcRequestBuilders.post(UrlConfig.URL_POST).param("name",
                "name");
    }

}
