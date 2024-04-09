module com.sas.demo2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires java.sql;
    requires org.apache.logging.log4j;
    requires jakarta.persistence;

    opens com.sas.studentApplication to javafx.fxml;
    exports com.sas.studentApplication;
    exports com.sas.studentApplication.Controller;
    exports com.sas.studentApplication.Config;
    opens com.sas.studentApplication.Controller to javafx.fxml;
    exports com.sas.studentApplication.DTO;
    opens com.sas.studentApplication.DTO to org.hibernate.orm.core;}