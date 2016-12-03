/**
 * Copyright 2016 the original author or authors
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

package ${package}.controller.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.wandrell.util.prueba.controller.entity.bean.ExampleEntityForm;
import com.wandrell.util.prueba.model.persistence.DefaultExampleEntity;
import com.wandrell.util.prueba.service.ExampleEntityService;

import ${package}.service.ExampleEntityService;
import ${package}.controller.entity.bean.ExampleEntityForm;

/**
 * Controller for the DBX Sponsor building view.
 * <p>
 * The team to be edited is stored as a session variable.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Controller
@RequestMapping("/entity")
public class ExampleEntityViewController {

    /**
     * Sponsor bean parameter name.
     */
    private static final String        BEAN_SPONSOR     = "form";

    /**
     * Sponsor bean parameter name.
     */
    private static final String        PARAM_ENTITIES   = "entities";

    /**
     * Name for the sponsor view.
     */
    private static final String        VIEW_ENTITY_FORM = "entity/form";

    /**
     * Name for the sponsor view.
     */
    private static final String        VIEW_ENTITY_LIST = "entity/list";

    /**
     * DBX team builder service.
     */
    private final ExampleEntityService exampleEntityService;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param service
     *            the sponsor creation service
     */
    @Autowired
    public ExampleEntityViewController(final ExampleEntityService service) {
        super();

        exampleEntityService = checkNotNull(service,
                "Received a null pointer as sponsor creation service");
    }

    /**
     * Checks the sponsor info before moving to the next view.
     * <p>
     * If the data is invalid then the view returns to the Sponsor edition view,
     * otherwise it moves to the next view.
     * 
     * @param model
     *            model map
     * @param form
     *            sponsor form data
     * @param bindingResult
     *            binding result data
     * @param session
     *            session data
     * @return the name for the view to show
     */
    @PostMapping
    public final String saveEntity(final ModelMap model,
            @ModelAttribute(BEAN_SPONSOR) @Valid final ExampleEntityForm form,
            final BindingResult bindingResult, final HttpSession session) {
        final String path;
        final DefaultExampleEntity entity;

        if (bindingResult.hasErrors()) {
            // Invalid sponsor data

            // Loads required data into the model
            loadFormModel(model);
            // Returns to the sponsor creation view
            path = VIEW_ENTITY_FORM;
            // TODO: Maybe it should return a bad request status?
        } else {
            entity = new DefaultExampleEntity();
            entity.setName(form.getName());

            getExampleEntityService().add(entity);

            // Loads required data into the model and session
            loadViewModel(model);

            path = VIEW_ENTITY_LIST;
        }

        return path;
    }

    /**
     * Returns the initial Sponsor form data.
     * 
     * @return the initial Sponsor form data
     */
    @ModelAttribute(BEAN_SPONSOR)
    public final ExampleEntityForm getEntityForm() {
        return new ExampleEntityForm();
    }

    /**
     * Shows the sponsor edition view.
     * 
     * @param model
     *            model map
     * @param status
     *            session status
     * @return the name for the sponsor edition view
     */
    @GetMapping(path = "/edit")
    public final String showEntityForm(final ModelMap model) {
        // Loads required data into the model
        loadFormModel(model);

        return VIEW_ENTITY_FORM;
    }

    @GetMapping(path = "/list")
    public final String showEntityList(final ModelMap model) {
        // Loads required data into the model
        loadViewModel(model);

        return VIEW_ENTITY_LIST;
    }

    /**
     * Returns the DBX team builder service.
     * 
     * @return the DBX team builder service
     */
    private final ExampleEntityService getExampleEntityService() {
        return exampleEntityService;
    }

    /**
     * Loads the model data required for the Sponsor edition view.
     * 
     * @param model
     *            model map
     */
    private final void loadFormModel(final ModelMap model) {}

    /**
     * Loads the model data required for the Sponsor edition view.
     * 
     * @param model
     *            model map
     */
    private final void loadViewModel(final ModelMap model) {
        model.put(PARAM_ENTITIES, getExampleEntityService().getAllEntities());
    }

}
