
package ${package}.test.integration.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.wandrell.util.prueba.model.ExampleEntity;
import com.wandrell.util.prueba.model.persistence.DefaultExampleEntity;
import com.wandrell.util.prueba.service.ExampleEntityService;

import org.testng.Assert;

import ${package}.model.ExampleEntity;
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
