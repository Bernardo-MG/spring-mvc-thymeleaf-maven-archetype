
package ${package}.test.integration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

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
    public final void testRead_Existing_Valid() {
        final ExampleEntity entity;

        entity = service.findById(1);

        Assert.assertEquals(entity.getId(), new Integer(1));
    }

    @Test
    public final void testRead_NotExisting_Invalid() {
        final ExampleEntity entity;

        entity = service.findById(100);

        Assert.assertEquals(entity.getId(), new Integer(-1));
    }

}
