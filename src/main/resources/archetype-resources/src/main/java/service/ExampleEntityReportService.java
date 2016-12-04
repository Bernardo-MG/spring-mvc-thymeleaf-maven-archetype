
package ${package}.service;

import net.sf.jasperreports.engine.JasperPrint;

import ${package}.model.persistence.DefaultExampleEntity;

public interface ExampleEntityReportService {

    public JasperPrint getReport(final Iterable<DefaultExampleEntity> data);

}
