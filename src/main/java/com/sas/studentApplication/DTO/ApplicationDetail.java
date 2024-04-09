package com.sas.studentApplication.DTO;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ApplicationDetails")
public class ApplicationDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AppId")
    private int appId;

    @Column(name = "UserId")
    private int userId;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Password")
    private String password;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "EmailId")
    private String emailId;

    @Column(name = "ProgramChoice")
    private String programChoice;

    @Lob
    @Column(name = "FacailPhoto")
    private byte[] facialPhoto;

    @Column(name = "Status")
    private String status;

    @Column(name = "CreatedBy")
    private Integer createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreateOn")
    private Date createdOn;

    @Column(name = "ModifiedBy")
    private Integer modifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ModifiedOn")
    private Date modifiedOn;

    public String getProgramChoice() {
        return programChoice;
    }

    public void setProgramChoice(String programChoice) {
        this.programChoice = programChoice;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public byte[] getFacialPhoto() {
        return facialPhoto;
    }

    public void setFacialPhoto(byte[] facialPhoto) {
        this.facialPhoto = facialPhoto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
