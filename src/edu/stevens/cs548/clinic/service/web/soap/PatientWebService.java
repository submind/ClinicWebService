package edu.stevens.cs548.clinic.service.web.soap;

import java.util.Date;

import javax.ejb.EJB;
import javax.jws.WebService;

import edu.stevens.cs548.clinic.service.dto.patient.PatientDto;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.TreatmentNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientServiceLocal;

@WebService(
	endpointInterface="edu.stevens.cs548.clinic.service.web.soap.IPatientWebService",
	targetNamespace="http://cs548.stevens.edu/clinic/service/web/soap",
	portName="PatientWebPort",
	serviceName="PatientWebService")

public class PatientWebService implements IPatientWebService {

	
	@EJB(beanName="PatientServiceBean")
    IPatientServiceLocal service;
    
    @Override
	public long addPatient(String name, Date dob, long patientId, int age)
			throws PatientServiceExn {
		return service.addPatient(name, dob, patientId, age);
	}
    @Override
    public PatientDto[] getPatientByNameDob(String name, Date dob) throws PatientServiceExn{
		return service.getPatientsByNameDob(name, dob);
	}
    @Override
    public PatientDto getPatientByPatId(long pid) throws PatientServiceExn {
		return service.getPatientByPatId(pid);
	}
    @Override
    public PatientDto getPatientByDbId(long id) throws PatientServiceExn {
		return service.getPatientByDbId(id);
	}

    @Override
	public void deletePatient(String name, long id) throws PatientServiceExn {
		service.deletePatientByDbId(name, id);
		
	}

	
    @Override
	public TreatmentDto[] getTreatmentsByPatientDbId(long id)
			throws PatientNotFoundExn, TreatmentNotFoundExn, PatientServiceExn {
		return service.getTreatmentsByPatientDbId(id);
	}


    @Override
	public String siteInfo() {
		return service.siteInfo();
	}

	

}
