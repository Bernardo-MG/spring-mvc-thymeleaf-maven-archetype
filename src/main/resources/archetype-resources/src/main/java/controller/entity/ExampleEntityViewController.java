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
@RequestMapping("/builder/team/dbx")
public class ExampleEntityViewController {

    /**
     * Sponsor bean parameter name.
     */
    private static final String     BEAN_SPONSOR            = "form";

    /**
     * Parameter name for the affinities.
     */
    private static final String     PARAM_AFFINITIES        = "affinities";

    /**
     * Parameter name for the available players.
     */
    private static final String     PARAM_AVAILABLE_PLAYERS = "availablePlayers";

    /**
     * Parameter name for the initial rank.
     */
    private static final String     PARAM_INITIAL_RANK      = "initialRank";

    /**
     * Parameter name for the sponsor.
     */
    private static final String     PARAM_SPONSOR           = "sponsor";

    /**
     * Parameter name for the team.
     */
    private static final String     PARAM_TEAM              = "team";

    /**
     * Name for the view after the sponsor view.
     */
    private static final String     VIEW_NEXT               = "builder/dbx/players";

    /**
     * Name for the sponsor view.
     */
    private static final String     VIEW_SPONSOR            = "builder/dbx/sponsor";

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
     * @param sponsor
     *            sponsor form data
     * @param bindingResult
     *            binding result data
     * @param session
     *            session data
     * @return the name for the view to show
     */
    @PostMapping
    public final String checkForm(final ModelMap model,
            @ModelAttribute(BEAN_SPONSOR) @Valid final ExampleEntityForm sponsor,
            final BindingResult bindingResult, final HttpSession session) {
        final String path;

        if (bindingResult.hasErrors()) {
            // Invalid sponsor data

            // Loads required data into the model
            loadFormModel(model);
            // Returns to the sponsor creation view
            path = VIEW_SPONSOR;
            // TODO: Maybe it should return a bad request status?
        } else {
            // Loads required data into the model and session
            loadNextStepModel(model, session, sponsor);

            path = VIEW_NEXT;
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
    @GetMapping
    public final String showEntityForm(final ModelMap model,
            final SessionStatus status) {
        // Clears session
        // TODO: Is this required here? Maybe a controller advice should be used
        status.setComplete();

        // Loads required data into the model
        loadFormModel(model);

        return VIEW_SPONSOR;
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
     * Loads the model data required for the next step.
     * 
     * @param model
     *            model map
     * @param session
     *            session data
     * @param form
     *            Sponsor form data
     */
    private final void loadNextStepModel(final ModelMap model,
            final HttpSession session, final ExampleEntityForm form) {
    }

    /**
     * Loads the model data required for the Sponsor edition view.
     * 
     * @param model
     *            model map
     */
    private final void loadFormModel(final ModelMap model) {
    }

}
