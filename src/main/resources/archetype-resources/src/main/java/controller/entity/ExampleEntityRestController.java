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

import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ${package}.model.persistence.DefaultExampleEntity;
import ${package}.service.ExampleEntityService;
import ${package}.controller.entity.bean.ExampleEntityForm;

/**
 * REST controller for the example entity.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/entity")
public class ExampleEntityRestController {

    /**
     * Service for the example entity.
     */
    private final ExampleEntityService exampleEntityService;

    /**
     * Constructs a controller with the specified dependencies.
     * 
     * @param service
     *            example entity service
     */
    public ExampleEntityRestController(final ExampleEntityService service) {
        super();

        exampleEntityService = checkNotNull(service,
                "Received a null pointer as service");
    }

    /**
     * Adds an entity to the DB.
     * 
     * @param toCreate
     *            entity to persist on DB
     * @param errors
     *            binding errors
     */
    @PostMapping(path = "/entities",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final void addEntity(@RequestBody final ExampleEntityForm toCreate,
            final BindingResult errors) {
        final DefaultExampleEntity entity;

        // TODO: Generate the entity from the form

        // TODO: Maybe the response status should change if the data is invalid
        if (!errors.hasErrors()) {
            // TODO: Map form to entity
            entity = new DefaultExampleEntity();
            getExampleEntityService().add(entity);
        }
    }

    /**
     * Removes and entity from the DB.
     * 
     * @param toDelete
     *            entity to remove from DB
     * @param errors
     *            binding errors
     */
    @DeleteMapping(path = "/entities",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public final void removeEntity(
            @RequestBody final ExampleEntityForm toDelete,
            final BindingResult errors) {
        final DefaultExampleEntity entity;

        // TODO: Generate the entity from the form

        // TODO: Maybe the response status should change if the data is invalid
        if (!errors.hasErrors()) {
            // TODO: Map form to entity
            entity = new DefaultExampleEntity();
            getExampleEntityService().remove(entity);
        }
    }

    /**
     * Returns the sample entity service.
     * 
     * @return the sample entity service
     */
    private final ExampleEntityService getExampleEntityService() {
        return exampleEntityService;
    }

}
