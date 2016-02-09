package com.scrumtrek.simplestore.report;

import com.scrumtrek.simplestore.Customer;

/**
 * Created by Admin on 09.02.2016.
 */
public abstract class BaseReport {
    protected Customer customer;

    protected String header;
    protected String footer;

    BaseReport(Customer customer) {
        this.customer = customer;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    public static class ReportBuilder {


        private BaseReport report;
        private String header = "";
        private String footer = "";



        public ReportBuilder(BaseReport report) {
            this.report = report;
        }

        public ReportBuilder setHeader() {
            header = report.getHeader();
            return this;
        }

        public ReportBuilder setFooter() {
            footer = report.getFooter();
            return this;
        }

        public String printReport() {
            return header + footer;
        }
    }
}
