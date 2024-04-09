# Student Admission System of HUMBER COLLEGE
- User management part: This part is responsible for add a new applicant either by himself or by the Registrar or Administrator.

- Signing up Part: This part can be handled by the Applicants, as the first step of the application process. The applicants should sign themselves up into the system before taking any other action.

- Reporting parts: The Registrar user(s) of the system and the administrator should be able to generate reports to be checked by their staff and make the related decisions.

Screens 

**Applicant user**

1. **Signup Form Page** -  Full Name, Username, Password, Phone number, Email address, Personal facial photo, Choose the course program. ( check box).

![A computer with a screen and login screen

Description automatically generated](Aspose.Words.4fa9cb18-2abb-426e-afc0-aa462a5d4c35.001.png)

![A screenshot of a computer

Description automatically generated](Aspose.Words.4fa9cb18-2abb-426e-afc0-aa462a5d4c35.002.png)

![A screen shot of a computer

Description automatically generated](Aspose.Words.4fa9cb18-2abb-426e-afc0-aa462a5d4c35.003.png)

![A screenshot of a computer

Description automatically generated]

1. **Login Page** – See the submitted application with the status. **( Pending / Under process / Accepted / Rejected or Conditionally accepted ).**

![A screenshot of a computer

Description automatically generated]


**Registrar user ( Registar and Admin are same just Registar does not get access to add user ).**

1. **Display application page** – The application submitted by the application user will be displayed with the status – ( Pending ).
1. **Edit page –** That will allow the registrar to change the status of the application.
1. **Add page –** To add the application (Same page as the Signup page)
1. **Generate Report –** we can show the application into various status and it counts on the page.

Administrator of the System.

1. **Add Page** to add the Registrar into the user table with Role – RS and Status – Active .

   **Add Registar**

![A screenshot of a computer

Description automatically generated](Aspose.Words.4fa9cb18-2abb-426e-afc0-aa462a5d4c35.005.png)

![A screenshot of a computer

Description automatically generated](Aspose.Words.4fa9cb18-2abb-426e-afc0-aa462a5d4c35.006.png)

![A screenshot of a computer

Description automatically generated](Aspose.Words.4fa9cb18-2abb-426e-afc0-aa462a5d4c35.007.png)




1. Add application page – to submit the application.

![A screen shot of a computer

Description automatically generated](Aspose.Words.4fa9cb18-2abb-426e-afc0-aa462a5d4c35.008.png)


1. View list of application page – To approve the application.

![A screenshot of a computer

Description automatically generated](Aspose.Words.4fa9cb18-2abb-426e-afc0-aa462a5d4c35.009.png)

![A screen shot of a computer

Description automatically generated](Aspose.Words.4fa9cb18-2abb-426e-afc0-aa462a5d4c35.010.png)

![A screenshot of a computer

Description automatically generated](Aspose.Words.4fa9cb18-2abb-426e-afc0-aa462a5d4c35.011.png)

1. Generate report page – to generate the report based on the status.

   Pending .

Table

**Application** –

Id,UserId, FullName,UserName,Password,PhoneNumber,

EmailId,FacialPhoto,Status ( **0**à **Pending,1à UnderProcess,2à Accepted,3à Rejected )**

CREATE TABLE `student\_app\_db`.`ApplicationDetails` (

`  ``AppId` INT NOT NULL AUTO\_INCREMENT,

`  ``UserId` INT NOT NULL,

`  ``FullName` VARCHAR(45) NULL,

`  ``UserName` VARCHAR(45) NULL,

`  ``Password` VARCHAR(45) NULL,

`  ``PhoneNumber` VARCHAR(45) NULL,

`  ``EmailId` VARCHAR(45) NULL,

`  ``FacailPhoto` BLOB NULL,

`  ``Status` INT NULL,

`  ``CreatedBy` INT NULL,

`  ``CreateOn` DATETIME NULL,

`  ``ModifiedBy` INT NULL,

`  ``ModifiedOn` DATETIME NULL,

`  `PRIMARY KEY (`AppId`));

**User  -**    Id,UserId,Role,Status,CreatedOn,UpdatedOn,CreatedBy

CREATE TABLE `student\_app\_db`.`User` (

`  ``Id` INT NOT NULL AUTO\_INCREMENT,

`  ``Role` VARCHAR(45) NULL,

`  ``Status` VARCHAR(45) NULL,

`  ``CreatedOn` VARCHAR(45) NULL,

`  ``UpdateOn` VARCHAR(45) NULL,

`  ``CreatedBy` INT NULL,

`  `PRIMARY KEY (`Id`));

TechStack

Integrate JavaFX, Hibernate and Mysql with the MVC Pattern

MVC Pattern

View – Controller - Modal

View  à Invokes the initialize method in the Controller.

![](Aspose.Words.4fa9cb18-2abb-426e-afc0-aa462a5d4c35.012.png)

Controller : Controller invokes modal to set the data for the view and update it.



![A screenshot of a computer

Description automatically generated](Aspose.Words.4fa9cb18-2abb-426e-afc0-aa462a5d4c35.013.png)


Reference

<https://edencoding.com/mvc-in-javafx/>




[A screenshot of a computer

Description automatically generated]: Aspose.Words.4fa9cb18-2abb-426e-afc0-aa462a5d4c35.004.png
