/**
 * Copyright ${currentYear} the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package ${package}.test.domain.unit.controller.rest;

import java.util.ArrayList;
import java.util.Collection;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ${package}.domain.controller.ExampleEntityRestController;
import ${package}.domain.model.ExampleEntity;
import ${package}.domain.model.persistence.DefaultExampleEntity;
import ${package}.domain.service.ExampleEntityService;
import ${package}.test.domain.config.UrlConfig;

/**
 * TeamPlayer tests for {@link ExampleEntityRestController}, validating the results of REST requests.
 * <p>
 * The tested controller gives support only for GET requests.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestExampleEntityRestController {

    /**
     * Mocked MVC context.
     */
    private MockMvc mockMvc;

    /**
     * Default constructor;
     */
    public TestExampleEntityRestController() {
        super();
    }

    /**
     * Sets up the mocked MVC context.
     */
    @BeforeEach
    public final void setUpMockContext() {
        mockMvc = MockMvcBuilders.standaloneSetup(getController())
            .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
            .alwaysExpect(MockMvcResultMatchers.status()
                .isOk())
            .alwaysExpect(MockMvcResultMatchers.content()
                .contentType(MediaType.APPLICATION_JSON))
            .build();
    }

    /**
     * Verifies that the data read from the service is returned.
     */
    @Test
    public final void testGet_ExpectedResults() throws Exception {
        final ResultActions result; // Request result

        result = mockMvc.perform(getGetRequest());

        // The operation was accepted
        result.andExpect(MockMvcResultMatchers.status()
            .isOk());

        // The response model contains the expected attributes
        result.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)));
    }

    /**
     * Returns a controller with mocked dependencies.
     *
     * @return a controller with mocked dependencies
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private final ExampleEntityRestController getController() {
        final ExampleEntityService      service;  // Mocked service
        final Collection<ExampleEntity> entities; // Returned entities

        service = Mockito.mock(ExampleEntityService.class);

        entities = new ArrayList<>();
        entities.add(new DefaultExampleEntity());
        entities.add(new DefaultExampleEntity());
        entities.add(new DefaultExampleEntity());

        Mockito.when(service.getEntities(ArgumentMatchers.any()))
            .thenReturn((Iterable) entities);

        return new ExampleEntityRestController(service);
    }

    /**
     * Returns a request builder prepared for reading entities.
     *
     * @return a request builder prepared for reading entities
     */
    private final RequestBuilder getGetRequest() {
        return MockMvcRequestBuilders.get(UrlConfig.URL_REST)
            .contentType(MediaType.APPLICATION_JSON);
    }

}
