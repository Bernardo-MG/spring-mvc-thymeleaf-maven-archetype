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

package ${package}.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Initializes all the controllers with the general project information.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@ControllerAdvice
public final class ProjectInfoInitializer {

    /**
     * Project author name.
     */
    @Value("${project.author.name}")
    private String authorName;

    /**
     * Project author URL.
     */
    @Value("${project.author.url}")
    private String authorUrl;

    /**
     * Project license name.
     */
    @Value("${project.license.name}")
    private String licenseName;

    /**
     * Project license URL.
     */
    @Value("${project.license.url}")
    private String licenseUrl;

    /**
     * Project description.
     */
    @Value("${project.description}")
    private String pageDescription;

    /**
     * Project keywords.
     */
    @Value("${project.keywords}")
    private String pageKeywords;

    /**
     * Project version.
     */
    @Value("${project.version}")
    private String appVersion;

    /**
     * Project year.
     */
    @Value("${project.year}")
    private String appYear;

    /**
     * Project license SCM URL.
     */
    @Value("${project.scm.url}")
    private String scmUrl;

    /**
     * Default constructor.
     */
    public ProjectInfoInitializer() {
        super();
    }

    /**
     * Returns the project license name.
     * 
     * @return the project license name
     */
    @ModelAttribute("appLicense")
    public final String getLicense() {
        return licenseName;
    }

    /**
     * Returns the project license URL.
     * 
     * @return the project license URL
     */
    @ModelAttribute("appLicenseUrl")
    public final String getLicenseUrl() {
        return licenseUrl;
    }

    /**
     * Returns the project author.
     * 
     * @return the project author
     */
    @ModelAttribute("projectAuthor")
    public final String getProjectAuthor() {
        return authorName;
    }

    /**
     * Returns the project author URL.
     * 
     * @return the project author URL
     */
    @ModelAttribute("projectAuthorUrl")
    public final String getProjectAuthorUrl() {
        return authorUrl;
    }

    /**
     * Returns the project description.
     * 
     * @return the project description
     */
    @ModelAttribute("pageDescription")
    public final String getPageDescription() {
        return pageDescription;
    }

    /**
     * Returns the project keywords.
     * 
     * @return the project keywords
     */
    @ModelAttribute("pageKeywords")
    public final String getPageKeywords() {
        return pageKeywords;
    }

    /**
     * Returns the project version.
     * 
     * @return the project version
     */
    @ModelAttribute("appVersion")
    public final String getAppVersion() {
        return appVersion;
    }

    /**
     * Returns the project year.
     * 
     * @return the project year
     */
    @ModelAttribute("appYear")
    public final String getAppYear() {
        return appYear;
    }

    /**
     * Returns the project SCM URL.
     * 
     * @return the project SCM URL
     */
    @ModelAttribute("projectGithubUrl")
    public final String getScmUrl() {
        return scmUrl;
    }

}
