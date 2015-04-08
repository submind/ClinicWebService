package edu.stevens.cs548.clinic.service.web.soap;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import edu.stevens.cs548.clinic.service.dto.patient.PatientDto;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.TreatmentNotFoundExn;

@WebService(
		name="IPatientWebPort",
		targetNamespace="http://cs548.stevens.edu/clinic/service/web/soap")
/*
 * Endpoint interface for the patient Web service.
 */
public interface IPatientWebService {
	
	@WebMethod(operationName="Add")
	public long addPatient (String name, Date dob, long patientId, int age) throws PatientServiceExn;
	
	@WebMethod
	public PatientDto getPatientByDbId (long id) throws PatientServiceExn;

	@WebMethod
	public PatientDto getPatientByPatId (long pid) throws PatientServiceExn;
	
	@WebMethod
	public PatientDto[] getPatientByNameDob (String name, Date dob) throws PatientServiceExn;
	
	@WebMethod
	public void deletePatient (String name, long id) throws PatientServiceExn;
	
	@WebMethod
	public TreatmentDto[] getTreatmentsByPatientDbId(long id) throws PatientNotFoundExn, TreatmentNotFoundExn, PatientServiceExn;
	
	@WebMethod
	public String siteInfo();


}
