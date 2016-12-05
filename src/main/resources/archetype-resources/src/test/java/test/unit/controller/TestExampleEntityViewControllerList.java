
package ${package}.test.unit.controller;

import java.util.Collection;
import java.util.LinkedList;

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

/**
 * Unit tests for {@link SponsorCreationController}, checking the methods for
 * showing the form.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestExampleEntityViewControllerList {

    /**
     * The name of the players bean.
     */
    private static final String ENTITIES = "entities";

    /**
     * Form view URL.
     */
    private static final String URL_VIEW = "/entity/list";

    /**
     * Mocked MVC context.
     */
    private MockMvc             mockMvc;

    /**
     * Default constructor;
     */
    public TestExampleEntityViewControllerList() {
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
     * Tests that the form view loads the expected attributes into the model.
     * <p>
     * The form requires a bean which will contain all its data.
     */
    @Test
    public final void testShowForm_ExpectedAttributeModel() throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(getViewRequest());

        // The operation was accepted
        result.andExpect(MockMvcResultMatchers.status().isOk());

        // The response model contains the expected attributes
        result.andExpect(
                MockMvcResultMatchers.model().attributeExists(ENTITIES));
    }

    /**
     * Returns a mocked controller.
     * <p>
     * It has all the dependencies stubbed.
     * 
     * @return a mocked controller
     */
    private final ExampleEntityViewController getController() {
        final ExampleEntityService service;
        final Collection<DefaultExampleEntity> entities;

        service = Mockito.mock(ExampleEntityService.class);

        entities = new LinkedList<>();

        Mockito.when(service.getAllEntities()).thenReturn(entities);

        return new ExampleEntityViewController(service);
    }

    /**
     * Returns a request builder for getting the tested form view.
     * 
     * @return a request builder for the form view
     */
    private final RequestBuilder getViewRequest() {
        return MockMvcRequestBuilders.get(URL_VIEW);
    }

}
