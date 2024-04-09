package com.sas.studentApplication.DOA;

import com.sas.studentApplication.DTO.ApplicationDetail;

import java.util.List;

public interface ApplicationDetailDOA {

    public boolean save(ApplicationDetail applicationDetail);

    List<ApplicationDetail> getAllApplicationDetails();

    List<ApplicationDetail> getApplicationDetailsByUserId(int userId);

    List<ApplicationDetail> getApplicationDetailsByStatus(String status);

    List<ApplicationDetail> getApplicationDetailsByUserIdAndStatus(int userId, String status);

}
