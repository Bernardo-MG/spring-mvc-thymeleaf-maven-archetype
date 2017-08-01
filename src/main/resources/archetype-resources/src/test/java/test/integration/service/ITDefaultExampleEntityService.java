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

package ${package}.test.integration.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import org.testng.Assert;

import ${package}.model.ExampleEntity;
import ${package}.model.persistence.DefaultExampleEntity;
import ${package}.service.ExampleEntityService;

@ContextConfiguration(locations = { "classpath:context/service.xml",
        "classpath:context/persistence.xml",
        "classpath:context/application-context.xml" })
@TestPropertySource({ "classpath:config/persistence-access.properties",
        "classpath:config/service.properties" })
public final class ITDefaultExampleEntityService
        extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private ExampleEntityService service;

    public ITDefaultExampleEntityService() {
        super();
    }

    @Test
    public final void testAdd_Existing_Valid() {
        final DefaultExampleEntity entity;
        final Integer entitiesCount;
        final Integer finalEntitiesCount;

        entitiesCount = ((Collection<DefaultExampleEntity>) service
                .getAllEntities()).size();

        entity = new DefaultExampleEntity();
        entity.setName("ABC");

        service.add(entity);

        finalEntitiesCount = ((Collection<DefaultExampleEntity>) service
                .getAllEntities()).size();

        Assert.assertEquals(finalEntitiesCount, new Integer(entitiesCount + 1));
    }

    @Test
    public final void testFindById_Existing_Valid() {
        final ExampleEntity entity;

        entity = service.findById(1);

        Assert.assertEquals(entity.getId(), new Integer(1));
    }

    @Test
    public final void testFindById_NotExisting_Invalid() {
        final ExampleEntity entity;

        entity = service.findById(100);

        Assert.assertEquals(entity.getId(), new Integer(-1));
    }

}
