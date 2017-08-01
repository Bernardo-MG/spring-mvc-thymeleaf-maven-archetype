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
                .attributeExists(ExampleEntityViewController.BEAN_FORM));

        // The response contains the expected errors
        result.andExpect(MockMvcResultMatchers.model()
                .attributeHasFieldErrors(ExampleEntityViewController.BEAN_FORM, "name"));
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
