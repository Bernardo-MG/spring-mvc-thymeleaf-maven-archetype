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

package ${package}.domain.service;

import java.util.Objects;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ${package}.domain.repository.ExampleEntityRepository;
import ${package}.domain.model.ExampleEntity;
import ${package}.domain.model.persistence.DefaultExampleEntity;

import lombok.AllArgsConstructor;

/**
 * Default implementation of the example entity service.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
@Service
@AllArgsConstructor
public class DefaultExampleEntityService implements ExampleEntityService {

    /**
     * Repository for the domain entities handled by the service.
     */
    private final ExampleEntityRepository entityRepository;

    @Override
    public final ExampleEntity add(final DefaultExampleEntity entity) {
        return entityRepository.save(entity);
    }

    /**
     * Returns an entity with the given id.
     * <p>
     * If no instance exists with that id then an entity with a negative id is returned.
     *
     * @param identifier
     *            identifier of the entity to find
     * @return the entity for the given id
     */
    @Override
    public final ExampleEntity findById(final Integer identifier) {
        final ExampleEntity entity;

        Objects.requireNonNull(identifier, "Received a null pointer as identifier");

        if (entityRepository.existsById(identifier)) {
            entity = entityRepository.getReferenceById(identifier);
        } else {
            entity = new DefaultExampleEntity();
        }

        return entity;
    }

    @Override
    public final Iterable<DefaultExampleEntity> getAllEntities() {
        return entityRepository.findAll();
    }

    @Override
    public final Iterable<DefaultExampleEntity> getEntities(final Pageable page) {
        return entityRepository.findAll(page);
    }

    @Override
    public final void remove(final DefaultExampleEntity entity) {
        entityRepository.delete(entity);
    }

}