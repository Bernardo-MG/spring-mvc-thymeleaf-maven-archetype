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

package ${package}.controller.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ${package}.service.ExampleEntityService;

/**
 * Controller for the example entities views.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Controller
@RequestMapping("/entity")
public class ExampleEntityListController {

    /**
     * Example entity service.
     */
    private final ExampleEntityService exampleEntityService;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param service
     *            example entity service
     */
    @Autowired
    public ExampleEntityListController(final ExampleEntityService service) {
        super();

        exampleEntityService = checkNotNull(service,
                "Received a null pointer as service");
    }

    /**
     * Shows the entity listing view.
     * 
     * @param model
     *            model map
     * @return the name for the entity listing view
     */
    @GetMapping(path = "/list")
    public final String showEntityList(final ModelMap model) {
        // Loads required data into the model
        loadViewModel(model);

        return ExampleEntityViewConstants.VIEW_ENTITY_LIST;
    }

    /**
     * Returns the example entity service.
     * 
     * @return the example entity service
     */
    private final ExampleEntityService getExampleEntityService() {
        return exampleEntityService;
    }

    /**
     * Loads the model data required for the edition view.
     * 
     * @param model
     *            model map
     */
    private final void loadViewModel(final ModelMap model) {
        model.put(ExampleEntityViewConstants.PARAM_ENTITIES,
                getExampleEntityService().getAllEntities());
    }

}
