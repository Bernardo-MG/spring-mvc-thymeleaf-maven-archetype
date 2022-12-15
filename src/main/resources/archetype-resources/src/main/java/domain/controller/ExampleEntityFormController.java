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

package ${package}.domain.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ${package}.domain.model.form.ExampleEntityForm;
import ${package}.domain.model.persistence.DefaultExampleEntity;
import ${package}.domain.service.ExampleEntityService;

import lombok.AllArgsConstructor;

/**
 * Controller for the example entities form view.
 * <p>
 * This serves as an adapter between the UI and the services layer.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Controller
@RequestMapping("/entity")
@AllArgsConstructor
public class ExampleEntityFormController {

    /**
     * Example entity service.
     */
    private final ExampleEntityService exampleEntityService;

    /**
     * Returns the initial entity form data.
     *
     * @return the initial entity form data
     */
    @ModelAttribute(ExampleEntityViewConstants.BEAN_FORM)
    public ExampleEntityForm getEntityForm() {
        return new ExampleEntityForm();
    }

    /**
     * Persists an entity.
     *
     * @param model
     *            model map
     * @param form
     *            form data
     * @param bindingResult
     *            binding result
     * @param response
     *            HTTP response
     * @return the next view to show
     */
    @PostMapping
    public String saveEntity(final ModelMap model,
            @ModelAttribute(ExampleEntityViewConstants.BEAN_FORM) @Valid final ExampleEntityForm form,
            final BindingResult bindingResult, final HttpServletResponse response) {
        final String               path;
        final DefaultExampleEntity entity;

        if (bindingResult.hasErrors()) {
            // Invalid form data

            // Returns to the form view
            path = ExampleEntityViewConstants.VIEW_ENTITY_FORM;

            // Marks the response as a bad request
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {

            entity = new DefaultExampleEntity();
            entity.setName(form.getName());

            exampleEntityService.add(entity);

            // TODO: This flow decision shouldn't be handled by the controller
            // TODO: This should be a redirection to the list controller
            // Loads required data into the model
            loadViewModel(model);

            path = ExampleEntityViewConstants.VIEW_ENTITY_LIST;
        }

        return path;
    }

    /**
     * Shows the entity edition view.
     * <p>
     * Actually it just returns the name of the view. Spring will take care of the rest.
     *
     * @return the name for the entity edition view
     */
    @GetMapping(path = "/edit")
    public String showEntityForm() {
        return ExampleEntityViewConstants.VIEW_ENTITY_FORM;
    }

    /**
     * Loads the model data required for the entities listing view.
     * <p>
     * As the view will list all the entities, it requires these entities as one of the parameters.
     *
     * @param model
     *            model map
     */
    private final void loadViewModel(final ModelMap model) {
        model.put(ExampleEntityViewConstants.PARAM_ENTITIES, exampleEntityService.getAllEntities());
    }

}
