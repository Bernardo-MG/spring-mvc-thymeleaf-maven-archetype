
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

import com.wandrell.util.prueba.controller.entity.ExampleEntityViewController;
import com.wandrell.util.prueba.model.persistence.DefaultExampleEntity;
import com.wandrell.util.prueba.service.ExampleEntityService;
import com.wandrell.util.prueba.test.config.BeanConfig;
import com.wandrell.util.prueba.test.config.UrlConfig;

import ${package}.controller.entity.ExampleEntityViewController;
import ${package}.model.persistence.DefaultExampleEntity;
import ${package}.service.ExampleEntityService;
import ${package}.test.config.BeanConfig;
import ${package}.test.config.UrlConfig;

/**
 * Unit tests for {@link SponsorCreationController}, checking the methods for
 * sending the form data with missing data.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestExampleEntityViewControllerFormMissingData {

    /**
     * The sponsor form view.
     */
    private static final String VIEW_FORM = "entity/form";

    /**
     * Mocked MVC context.
     */
    private MockMvc             mockMvc;

    /**
     * Default constructor;
     */
    public TestExampleEntityViewControllerFormMissingData() {
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
     * Tests that after receiving form data missing the sponsor name the
     * expected attributes are loaded into the model.
     */
    @Test
    public final void testSendFormData_NoName_ExpectedAttributeModel()
            throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(getNoNameFormRequest());

        // The response model contains the expected attributes
        result.andExpect(MockMvcResultMatchers.model()
                .attributeExists(BeanConfig.FORM_BEAN));

        // The response contains the expected errors
        result.andExpect(MockMvcResultMatchers.model()
                .attributeHasFieldErrors(BeanConfig.FORM_BEAN, "name"));
    }

    /**
     * Tests that after receiving form data missing an affinity the view is
     * again the form view.
     */
    @Test
    public final void testSendFormData_NoName_NoViewChange() throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(getNoNameFormRequest());

        // The view is valid
        result.andExpect(MockMvcResultMatchers.view().name(VIEW_FORM));
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
     * Returns a request builder for posting form data without a sponsor name.
     * 
     * @return a request builder with form data without a sponsor name
     */
    private final RequestBuilder getNoNameFormRequest() {
        return MockMvcRequestBuilders.post(UrlConfig.URL_POST);
    }

}
