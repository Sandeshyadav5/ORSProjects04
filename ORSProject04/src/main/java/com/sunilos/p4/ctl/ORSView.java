package com.sunilos.p4.ctl;

/**
 * Contains ORS View and Controller URI
 * 
 * @author  Durgesh Lohiya
 * @version 1.0
 * Copyright (c) Rays EdTech
 */

public interface ORSView {

	public String APP_CONTEXT = "/ORSProject04";

	public String PAGE_FOLDER = "/jsp";

	public String JAVA_DOC_VIEW = APP_CONTEXT + "/doc/index.html";

	public String ERROR_VIEW = PAGE_FOLDER + "/MarksheetListView.jsp";

	public String MARKSHEET_VIEW = PAGE_FOLDER + "/MarksheetView.jsp";

	public String MARKSHEET_LIST_VIEW = PAGE_FOLDER + "/MarksheetListView.jsp";
	public String GET_MARKSHEET_VIEW = PAGE_FOLDER + "/GetMarksheetView.jsp";
	public String USER_VIEW = PAGE_FOLDER + "/UserView.jsp";
	public String USER_LIST_VIEW = PAGE_FOLDER + "/UserListView.jsp";
	public String COLLEGE_VIEW = PAGE_FOLDER + "/CollegeView.jsp";
	public String COLLEGE_LIST_VIEW = PAGE_FOLDER + "/CollegeListView.jsp";
	public String STUDENT_VIEW = PAGE_FOLDER + "/StudentView.jsp";
	public String STUDENT_LIST_VIEW = PAGE_FOLDER + "/StudentListView.jsp";
	public String ROLE_VIEW = PAGE_FOLDER + "/RoleView.jsp";
	public String ROLE_LIST_VIEW = PAGE_FOLDER + "/RoleListView.jsp";
	public String COURSE_VIEW = PAGE_FOLDER + "/CourseView.jsp";
	public String COURSE_LIST_VIEW = PAGE_FOLDER + "/CourseListView.jsp";
	public String SUBJECT_VIEW = PAGE_FOLDER + "/SubjectView.jsp";
	public String SUBJECT_LIST_VIEW = PAGE_FOLDER + "/SubjectListView.jsp";
	public String USER_REGISTRATION_VIEW = PAGE_FOLDER + "/UserRegistrationView.jsp";
	public String LOGIN_VIEW = PAGE_FOLDER + "/LoginView.jsp";
	public String WELCOME_VIEW = PAGE_FOLDER + "/Welcome.jsp";
	public String CHANGE_PASSWORD_VIEW = PAGE_FOLDER + "/ChangePasswordView.jsp";
	public String MY_PROFILE_VIEW = PAGE_FOLDER + "/MyProfileView.jsp";
	public String FORGET_PASSWORD_VIEW = PAGE_FOLDER + "/ForgetPasswordView.jsp";
	public String MARKSHEET_MERIT_LIST_VIEW = PAGE_FOLDER + "/MarksheetMeritListView.jsp";
	public String PRODUCT_VIEW = PAGE_FOLDER + "/ProductView.jsp";
	public String PRODUCT_LIST_VIEW = PAGE_FOLDER + "/ProductListView.jsp";
	public String INTERVIEW_VIEW = PAGE_FOLDER + "/InterViewView.jsp";
	public String INTERVIEW_LIST_VIEW = PAGE_FOLDER + "/InterViewListView.jsp";
	public String EMPLOYEE_VIEW = PAGE_FOLDER + "/EmployeeView.jsp";
	public String EMPLOYEE_LIST_VIEW = PAGE_FOLDER + "/EmployeeListView.jsp";
	public String PGHOSTEL_VIEW = PAGE_FOLDER + "/PgHostelView.jsp";
	public String PGHOSTEL_LIST_VIEW = PAGE_FOLDER + "/PgHostelListView.jsp";
	public String SOFTWARELICENSE_VIEW = PAGE_FOLDER + "/SoftwareLicenseView.jsp";
	public String SOFTWARELICENSE_LIST_VIEW = PAGE_FOLDER + "/SoftwareLicenseListView.jsp";

	public String ERROR_CTL = "/ctl/MarksheetCtl";

	public String MARKSHEET_CTL = APP_CONTEXT + "/ctl/MarksheetCtl";
	public String MARKSHEET_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetListCtl";
	public String USER_CTL = APP_CONTEXT + "/ctl/UserCtl";
	public String USER_LIST_CTL = APP_CONTEXT + "/ctl/UserListCtl";
	public String COLLEGE_CTL = APP_CONTEXT + "/ctl/CollegeCtl";
	public String COLLEGE_LIST_CTL = APP_CONTEXT + "/ctl/CollegeListCtl";
	public String STUDENT_CTL = APP_CONTEXT + "/ctl/StudentCtl";
	public String STUDENT_LIST_CTL = APP_CONTEXT + "/ctl/StudentListCtl";
	public String ROLE_CTL = APP_CONTEXT + "/ctl/RoleCtl";
	public String ROLE_LIST_CTL = APP_CONTEXT + "/ctl/RoleListCtl";
	public String COURSE_CTL = APP_CONTEXT + "/ctl/CourseCtl";
	public String COURSE_LIST_CTL = APP_CONTEXT + "/ctl/CourseListCtl";
	public String SUBJECT_CTL = APP_CONTEXT + "/ctl/SubjectCtl";
	public String SUBJECT_LIST_CTL = APP_CONTEXT + "/ctl/SubjectListCtl";
	public String USER_REGISTRATION_CTL = APP_CONTEXT + "/UserRegistrationCtl";
	public String LOGIN_CTL = APP_CONTEXT + "/LoginCtl";
	public String WELCOME_CTL = APP_CONTEXT + "/WelcomeCtl";
	public String LOGOUT_CTL = APP_CONTEXT + "/LoginCtl";
	public String GET_MARKSHEET_CTL = APP_CONTEXT + "/ctl/GetMarksheetCtl";
	public String CHANGE_PASSWORD_CTL = APP_CONTEXT + "/ctl/ChangePasswordCtl";
	public String MY_PROFILE_CTL = APP_CONTEXT + "/ctl/MyProfileCtl";
	public String FORGET_PASSWORD_CTL = APP_CONTEXT + "/ForgetPasswordCtl";
	public String MARKSHEET_MERIT_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetMeritListCtl";
	public String UPLOAD_PHOTO_CTL = APP_CONTEXT + "/ctl/UploadPhotoCtl";

	public String FACULTY_VIEW = PAGE_FOLDER + "/FacultyView.jsp";
	public String FACULTY_LIST_VIEW = PAGE_FOLDER + "/FacultyListView.jsp";
	public String FACULTY_CTL = APP_CONTEXT + "/ctl/FacultyCtl";
	public String FACULTY_LIST_CTL = APP_CONTEXT + "/ctl/FacultyListCtl";
	
	/// --- Reports ---- /////

	public String STUDENT_REPORT_CTL = APP_CONTEXT + "/ctl/StudentReportCtl";
	public String COLLEGE_REPORT_CTL = APP_CONTEXT + "/ctl/CollegeReportCtl";
	public String USER_REPORT_CTL = APP_CONTEXT + "/ctl/UserReportCtl";
	public String ROLE_REPORT_CTL = APP_CONTEXT + "/ctl/RoleReportCtl";
	public String COURSE_REPORT_CTL = APP_CONTEXT + "/ctl/CourseReportCtl";
	public String SUBJECT_REPORT_CTL = APP_CONTEXT + "/ctl/SubjectReportCtl";
	public String MARKSHEET_REPORT_CTL = APP_CONTEXT + "/ctl/MarksheetReportCtl";
	public String FACULTY_REPORT_CTL = APP_CONTEXT + "/ctl/FacultyReportCtl";
	public String EMPLOYEE_REPORT_CTL = APP_CONTEXT + "/ctl/EmployeeReportCtl";
	public String PRODUCT_REPORT_CTL = APP_CONTEXT + "/ctl/ProductReportCtl";
	public String PGHOSTEL_REPORT_CTL = APP_CONTEXT + "/ctl/PgHostelReportCtl";
	public String SOFTWARELICENSE_REPORT_CTL = APP_CONTEXT + "/ctl/SoftwareLicenseReportCtl";
	public String HOSPITAL_REPORT_CTL = APP_CONTEXT + "/ctl/HospitalReportCtl";
	
	//// --- ctl //// list ------//////
	
	public String PRODUCT_CTL = APP_CONTEXT + "/ctl/ProductCtl";
	public String PRODUCT_LIST_CTL = APP_CONTEXT + "/ctl/ProductListCtl";
	public String INTERVIEW_CTL = APP_CONTEXT + "/ctl/InterViewCtl";
	public String INTERVIEW_LIST_CTL = APP_CONTEXT + "/ctl/InterViewListCtl";
	public String EMPLOYEE_CTL = APP_CONTEXT + "/ctl/EmployeeCtl";
	public String EMPLOYEE_LIST_CTL = APP_CONTEXT + "/ctl/EmployeeListCtl";
	public String PGHOSTEL_CTL = APP_CONTEXT + "/ctl/PgHostelCtl";
	public String PGHOSTEL_LIST_CTL = APP_CONTEXT + "/ctl/PgHostelListCtl";
	public String SOFTWARELICENSE_CTL = APP_CONTEXT + "/ctl/SoftwareLicenseCtl";
	public String SOFTWARELICENSE_LIST_CTL = APP_CONTEXT + "/ctl/SoftwareLicenseListCtl";
	
	///// ----- Module ------ ///////

	public String HOSPITAL_CTL = APP_CONTEXT + "/ctl/HospitalCtl";
	public String HOSPITAL_VIEW = PAGE_FOLDER + "/HospitalView.jsp";
	public String HOSPITAL_LIST_CTL = APP_CONTEXT + "/ctl/HospitalListCtl";
	public String HOSPITAL_LIST_VIEW = PAGE_FOLDER + "/HospitalListView.jsp";
	
	/////// ---- SmartParking ---- ///////
	
	public String SMARTPARKING_CTL = APP_CONTEXT + "/ctl/SmartParkingCtl";
	public String SMARTPARKING_VIEW = PAGE_FOLDER + "/SmartParkingView.jsp";
	public String SMARTPARKING_LIST_CTL = APP_CONTEXT + "/ctl/SmartParkingListCtl";
	public String SMARTPARKING_LIST_VIEW = PAGE_FOLDER + "/SmartParkingListView.jsp";
	
	///// --------- AiScanner Module------////
	
	public String AISCANNER_CTL = APP_CONTEXT + "/ctl/AiScannerCtl";
	public String AISCANNER_VIEW = PAGE_FOLDER + "/AiScannerView.jsp";
	public String AISCANNER_LIST_CTL = APP_CONTEXT + "/ctl/AiScannerListCtl";
	public String AISCANNER_LIST_VIEW = PAGE_FOLDER + "AiScannerListView.jsp";
	public String AISCANNER_REPORT_VIEW = "/reports/AiScannerListReport.jrxml";
	
	/// ----- QrScannerCode module ------- ////
	
	public String QRSCANNERCODE_CTL = APP_CONTEXT + "/ctl/QrScannerCodeCtl";
	public String QRSCANNERCODE_VIEW = PAGE_FOLDER + "/QrScannerCodeView.jsp";
	public String QRSCANNERCODE_LIST_CTL = APP_CONTEXT + "/ctl/QrScannerCodeListCtl";
	public String QRSCANNERCODE_LIST_VIEW = PAGE_FOLDER + "/QrScannerCodeListView.jsp";
	public String QRSCANNERCODE_REPORT_VIEW = "/reports/QrScannerCodeListReport.jrxml";
	
	/// ----- Delivery module ----- ////

	public String DELIVERY_CTL = APP_CONTEXT + "/ctl/DeliveryCtl";
	public String DELIVERY_VIEW = PAGE_FOLDER + "/DeliveryView.jsp";
	public String DELIVERY_LIST_CTL = APP_CONTEXT + "/ctl/DeliveryListCtl";
	public String DELIVERY_LIST_VIEW = PAGE_FOLDER + "/DeliveryListView.jsp";
	public String DELIVERY_REPORT_VIEW = "/reports/DeliveryListReport.jrxml";
	public String DELIVERY_REPORT_CTL = APP_CONTEXT + "/ctl/DeliveryReportCtl";
	
	///----pet model ----////

	public String PET_CTL = APP_CONTEXT + "/ctl/PetCtl";
	public String PET_VIEW = PAGE_FOLDER + "/PetView.jsp";
	public String PET_LIST_CTL = APP_CONTEXT + "/ctl/PetListCtl";
	public String PET_LIST_VIEW = PAGE_FOLDER + "/PetListView.jsp";	
	
	////------ Report View ------- //////

	public String COURSE_REPORT_VIEW = "/reports/CourseListReport.jrxml";
	public String STUDENT_REPORT_VIEW = "/reports/StudentListReport.jrxml";
	public String COLLEGE_REPORT_VIEW = "/reports/CollegeListReport.jrxml";
	public String USER_REPORT_VIEW = "/reports/UserListReport.jrxml";
	public String ROLE_REPORT_VIEW = "/reports/RoleListReport.jrxml";
	public String SUBJECT_REPORT_VIEW = "/reports/SubjectListReport.jrxml";
	public String MARKSHEET_REPORT_VIEW = "/reports/MarksheetListReport.jrxml";
	public String FACULTY_REPORT_VIEW = "/reports/FacultyListReport.jrxml";
	public String EMPLOYEE_REPORT_VIEW = "/reports/EmployeeListReport.jrxml";
	public String PRODUCT_REPORT_VIEW = "/reports/ProductListReport.jrxml";
	public String PGHOSTEL_REPORT_VIEW = "/reports/PgHostelListReport.jrxml";
	public String SOFTWARELICENSE_REPORT_VIEW = "/reports/SoftwareLicenseListReport.jrxml";
	public String HOSPITAL_REPORT_VIEW = "/reports/HospitalListReport.jrxml";
	public String SMARTPARKING_REPORT_VIEW = "/reports/SmartParkingListReport.jrxml";
	public String SMARTPARKING_REPORT_CTL = APP_CONTEXT + "/ctl/SmartParkingReportCtl";
	public String PET_REPORT_CTL = APP_CONTEXT + "/ctl/PetReportCtl";
	public String PET_REPORT_VIEW = "/reports/PetListReport.jrxml";
	

}
