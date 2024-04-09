package com.sas.studentApplication.Config;

public class DBConstantUtil {

    public enum ApplicationDetailStatus {
        PENDING("Pending"),
        APPROVED("Approved"),
        REJECTED("Rejected"),
        CANCELLED("Cancelled");

        private final String value;

        ApplicationDetailStatus(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
}
