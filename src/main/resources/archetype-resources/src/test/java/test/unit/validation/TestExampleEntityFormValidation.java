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

package ${package}.test.unit.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ${package}.controller.entity.bean.ExampleEntityForm;

/**
 * Unit tests for {@link SponsorForm} bean validation.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestExampleEntityFormValidation {

    /**
     * Validator for validating the bean.
     */
    private Validator validator;

    /**
     * Default constructor.
     */
    public TestExampleEntityFormValidation() {
        super();
    }

    /**
     * Sets up the validator for the tests.
     */
    @BeforeTest
    public final void setUpValidator() {
        validator = createValidator();
    }

    /**
     */
    @Test
    public final void testValidation_NullName_Error() {
        final ExampleEntityForm form; // Tested form
        final Set<ConstraintViolation<ExampleEntityForm>> errors;
        final ConstraintViolation<ExampleEntityForm> error;

        form = new ExampleEntityForm();

        // form.setName(null);

        errors = validator.validate(form);

        Assert.assertEquals(errors.size(), 1);

        error = errors.iterator().next();
        Assert.assertEquals(error.getPropertyPath().toString(), "name");
    }

    /**
     */
    @Test
    public final void testValidation_EmptyName_Error() {
        final ExampleEntityForm form; // Tested form
        final Set<ConstraintViolation<ExampleEntityForm>> errors;
        final ConstraintViolation<ExampleEntityForm> error;

        form = new ExampleEntityForm();

        form.setName("");

        errors = validator.validate(form);

        Assert.assertEquals(errors.size(), 1);

        error = errors.iterator().next();
        Assert.assertEquals(error.getPropertyPath().toString(), "name");
    }

    /**
     * Returns the validator to use in the tests.
     * 
     * @return the validator to use in the tests
     */
    private final Validator createValidator() {
        final LocalValidatorFactoryBean localValidatorFactoryBean;

        localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();

        return localValidatorFactoryBean;
    }

}
