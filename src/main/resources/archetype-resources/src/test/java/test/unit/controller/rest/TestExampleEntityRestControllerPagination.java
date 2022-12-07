/**
 * Copyright 2018 the original author or authors
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

package ${package}.test.unit.controller.rest;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import ${package}.controller.entity.ExampleEntityRestController;
import ${package}.model.ExampleEntity;
import ${package}.model.persistence.DefaultExampleEntity;
import ${package}.service.ExampleEntityService;
import ${package}.test.config.UrlConfig;

/**
 * TeamPlayer tests for {@link ExampleEntityRestController}, validating the
 * results of REST requests.
 * <p>
 * The tested controller gives support only for GET requests.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestExampleEntityRestControllerPagination {

    /**
     * Argument captor for pagination data.
     */
    private ArgumentCaptor<Pageable>   captor;

    /**
     * Mocked MVC context.
     */
    private MockMvc                    mockMvc;

    /**
     * Mocked service.
     */
    private final ExampleEntityService service;

    /**
     * Default constructor;
     */
    public TestExampleEntityRestControllerPagination() {
        super();

        service = getExampleEntityService();
    }

    /**
     * Sets up the mocked MVC context.
     */
    @BeforeEach
    public final void setUpMockContext() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(new ExampleEntityRestController(service))
                .setCustomArgumentResolvers(
                        new PageableHandlerMethodArgumentResolver())
                .alwaysExpect(MockMvcResultMatchers.status().isOk())
                .alwaysExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .build();
    }

    /**
     * Verifies that the page received as parameter is used for pagination.
     */
    @Test
    public final void testGet_Page_SetInPagination() throws Exception {
        final Pageable pageable;

        mockMvc.perform(getGetRequestWithPage());

        pageable = captor.getValue();

        Assertions.assertEquals(10, pageable.getPageNumber());
    }

    /**
     * Verifies that default pagination values are used when no pagination
     * parameters are received.
     */
    @Test
    public final void testGet_WithoutPagination_DefaultValues()
            throws Exception {
        final Pageable pageable;

        mockMvc.perform(getGetRequest());

        pageable = captor.getValue();

        Assertions.assertEquals(20, pageable.getPageSize());
        Assertions.assertEquals(0, pageable.getPageNumber());
    }

    /**
     * Returns a mocked service.
     * <p>
     * It is prepared for using the pagination data argument captor.
     * 
     * @return a mocked service
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private final ExampleEntityService getExampleEntityService() {
        final ExampleEntityService service;   // Mocked service
        final Collection<ExampleEntity> entities; // Returned entities

        service = Mockito.mock(ExampleEntityService.class);

        entities = new ArrayList<>();
        entities.add(new DefaultExampleEntity());
        entities.add(new DefaultExampleEntity());
        entities.add(new DefaultExampleEntity());

        captor = ArgumentCaptor.forClass(Pageable.class);

        Mockito.when(service.getEntities(captor.capture()))
                .thenReturn((Iterable) entities);

        return service;
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

    /**
     * Returns a request builder prepared for reading entities and a page set.
     * 
     * @return a request builder prepared for reading entities
     */
    private final RequestBuilder getGetRequestWithPage() {
        return MockMvcRequestBuilders.get(UrlConfig.URL_REST + "?page=10")
                .contentType(MediaType.APPLICATION_JSON);
    }

}
