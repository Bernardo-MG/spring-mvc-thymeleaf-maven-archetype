/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2017-2019 the original author or authors.
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

package ${package}.test.unit.controller.form;

import java.util.Collection;
import java.util.ArrayList;

import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import ${package}.controller.entity.ExampleEntityFormController;
import ${package}.controller.entity.ExampleEntityViewConstants;
import ${package}.model.persistence.DefaultExampleEntity;
import ${package}.service.ExampleEntityService;
import ${package}.test.config.UrlConfig;

/**
 * Unit tests for {@link ExampleEntityFormController}, verifying the service is
 * called.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestExampleEntityFormControllerServiceCalled {

    /**
     * Mocked MVC context.
     */
    private MockMvc              mockMvc;

    private ExampleEntityService service;

    /**
     * Default constructor.
     */
    public TestExampleEntityFormControllerServiceCalled() {
        super();
    }

    /**
     * Sets up the mocked MVC context.
     * <p>
     * It expects all the responses to have the OK (200) HTTP code.
     */
    @BeforeEach
    public final void setUpMockContext() {
        service = Mockito.mock(ExampleEntityService.class);

        mockMvc = MockMvcBuilders.standaloneSetup(getController(service))
                .alwaysExpect(MockMvcResultMatchers.status().isOk()).build();
    }

    /**
     * Verifies that after received valid form data the expected view is
     * returned.
     */
    @Test
    public final void testSendFormData_CalledService() throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(getFormRequest());

        // The view is valid
        result.andExpect(MockMvcResultMatchers.view()
                .name(ExampleEntityViewConstants.VIEW_ENTITY_LIST));
        
        Mockito.verify(service, Mockito.times(1)).add(Mockito.any());
    }

    /**
     * Returns a controller with mocked dependencies.
     * 
     * @param service
     *            service for the controller
     * @return a mocked controller
     */
    private final ExampleEntityFormController
            getController(final ExampleEntityService service) {
        final Collection<DefaultExampleEntity> entities; // Mocked entities

        entities = new ArrayList<>();

        Mockito.when(service.getAllEntities()).thenReturn(entities);

        return new ExampleEntityFormController(service);
    }

    /**
     * Returns a request builder for posting the form data.
     * <p>
     * This request contains all the required request parameters.
     * <p>
     * There is only a single required parameter, the {@code name} parameter.
     * 
     * @return a request builder for posting the form data
     */
    private final RequestBuilder getFormRequest() {
        return MockMvcRequestBuilders.post(UrlConfig.URL_FORM_POST)
                .param("name", "name");
    }

}
