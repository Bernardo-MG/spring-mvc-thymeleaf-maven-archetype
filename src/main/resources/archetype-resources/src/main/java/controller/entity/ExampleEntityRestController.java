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
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ${package}.model.ExampleEntity;
import ${package}.service.ExampleEntityService;

/**
 * Rest controller for the example entities.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RestController
@RequestMapping("/rest/entity")
public class ExampleEntityRestController {

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
    public ExampleEntityRestController(final ExampleEntityService service) {
        super();

        exampleEntityService = checkNotNull(service,
                "Received a null pointer as service");
    }

    /**
     * Returns a paginated collection of entities.
     * 
     * @param page
     *            pagination data
     * @return a paginated collection of entities
     */
    @GetMapping
    public Iterable<? extends ExampleEntity> getEntities(final Pageable page) {
        return getExampleEntityService().getEntities(page);
    }

    /**
     * Returns the example entity service.
     * 
     * @return the example entity service
     */
    private final ExampleEntityService getExampleEntityService() {
        return exampleEntityService;
    }

}
