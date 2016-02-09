package com.scrumtrek.simplestore.report;

import com.scrumtrek.simplestore.Customer;

/**
 * Created by Admin on 09.02.2016.
 */
public abstract class BaseReport {
    private Customer customer;

    protected String header;
    protected String footer;

    BaseReport(Customer customer) {
        this.customer = customer;
    }

    public String getHeader() {
        return header;
    }

    public static class ReportBuilder {

        protected String result = "";
        private BaseReport report;


        public ReportBuilder(BaseReport report) {
            this.report = report;
        }

        public ReportBuilder setHeader() {
            result += report.getHeader();
            return this;
        }

        public String printReport() {
            return result;
        }
    }
}
