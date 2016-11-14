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
    private String projectDescription;

    /**
     * Project keywords.
     */
    @Value("${project.keywords}")
    private String projectKeywords;

    /**
     * Project version.
     */
    @Value("${project.version}")
    private String projectVersion;

    /**
     * Project year.
     */
    @Value("${project.year}")
    private String projectYear;

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
    @ModelAttribute("projectLicense")
    public final String getLicense() {
        return licenseName;
    }

    /**
     * Returns the project license URL.
     * 
     * @return the project license URL
     */
    @ModelAttribute("projectLicenseUrl")
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
    @ModelAttribute("projectDescription")
    public final String getProjectDescription() {
        return projectDescription;
    }

    /**
     * Returns the project keywords.
     * 
     * @return the project keywords
     */
    @ModelAttribute("projectKeywords")
    public final String getProjectKeywords() {
        return projectKeywords;
    }

    /**
     * Returns the project version.
     * 
     * @return the project version
     */
    @ModelAttribute("projectVersion")
    public final String getProjectVersion() {
        return projectVersion;
    }

    /**
     * Returns the project year.
     * 
     * @return the project year
     */
    @ModelAttribute("projectYear")
    public final String getProjectYear() {
        return projectYear;
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
