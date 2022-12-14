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

package ${package}.model.form;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

/**
 * Represents the form used for the creating and editing example entities.
 * <p>
 * This is a DTO, meant to allow communication between the view and the controller, and mapping all the values from the
 * form. Each of field in the DTO matches a field in the form.
 * <p>
 * Includes Java validation annotations, for applying binding validation. This way the controller will make sure it
 * receives all the required data.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Data
public final class ExampleEntityForm implements Serializable {

    /**
     * Serialization ID.
     */
    private static final long serialVersionUID = 1328776989450853491L;

    /**
     * Name field.
     * <p>
     * This is a required field and can't be empty.
     */
    @NotEmpty
    private String            name;

}
