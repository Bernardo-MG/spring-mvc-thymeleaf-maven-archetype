
package ${package}.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import ${package}.model.persistence.DefaultExampleEntity;

@Service
public final class DefaultExampleEntityReportService implements ExampleEntityReportService {

    public DefaultExampleEntityReportService() {
        super();
    }

    @Override
    public final JasperPrint getReport(final Iterable<DefaultExampleEntity> data) {
        final File reportFile;
        final JasperReport jasperReport;
        final JasperPrint jasperPrint;
        final Map<String, Object> parameters;

        // TODO: The file should be received as a configuration value
        try {
            reportFile = new ClassPathResource("/report/entities.jasper")
                    .getFile();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }

        if (!reportFile.exists()) {
            // TODO: Compile report
        }

        try {
            jasperReport = (JasperReport) JRLoader
                    .loadObjectFromFile(reportFile.getPath());
        } catch (final JRException e) {
            throw new RuntimeException(e);
        }

        parameters = new LinkedHashMap<>();

        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                    new JRBeanCollectionDataSource(
                            IteratorUtils.toList(data.iterator())));
        } catch (final JRException e) {
            throw new RuntimeException(e);
        }

        return jasperPrint;
    }

}
