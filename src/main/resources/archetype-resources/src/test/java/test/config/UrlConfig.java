
package ${package}.test.config;

/**
 * Contains configuration information for the controller URLs.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class UrlConfig {

    /**
     * Form view URL.
     */
    public static final String URL_FORM = "/entity/edit";

    public static final String URL_LIST = "/entity/list";

    public static final String URL_POST = "/entity";

    /**
     * Default constructor to avoid initialization.
     */
    private UrlConfig() {
        super();
    }

}
