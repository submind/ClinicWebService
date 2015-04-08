package edu.stevens.cs548.clinic.service.web.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import edu.stevens.cs548.clinic.domain.IPatientDAO.PatientExn;
import edu.stevens.cs548.clinic.domain.IProviderDAO.ProviderExn;
import edu.stevens.cs548.clinic.domain.ITreatmentDAO.TreatmentExn;
import edu.stevens.cs548.clinic.service.dto.patient.PatientDto;
import edu.stevens.cs548.clinic.service.dto.provider.ProviderDTO;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.ProviderNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.ProviderServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.TreatmentNotFoundExn;

@WebService(name = "IPatientWebPort", targetNamespace = "http://cs548.stevens.edu/clinic/service/web/soap")
/*
 * Endpoint interface for the patient Web service.
 */
public interface IProviderWebService {

	@WebMethod(operationName = "Add")
	public void addProvider(String name, long npi) throws ProviderServiceExn;
	
	@WebMethod
	public void addProvider(String name, long npi, String specialization) throws ProviderServiceExn;

	@WebMethod
	public ProviderDTO[] getProviderByName(String name) throws ProviderExn,
			ProviderServiceExn;

	@WebMethod
	public ProviderDTO getProvidersByNpi(long npi) throws ProviderServiceExn;

	@WebMethod
	public void addTreatment(long patientId, long providerNPI,
			TreatmentDto TreatmentDto) throws ProviderServiceExn;

	@WebMethod
	public void deleteTreatment(long id, long tid, long npi)
			throws PatientNotFoundExn, ProviderNotFoundExn, ProviderServiceExn,
			TreatmentNotFoundExn;

	@WebMethod
	public TreatmentDto[] getTreatmentsByProviderNpi(long npi)
			throws ProviderNotFoundExn, TreatmentNotFoundExn,
			ProviderServiceExn;

	@WebMethod
	public List<Long> getTreatmentsforPatient(long npi, PatientDto patient)
			throws ProviderExn, TreatmentExn, PatientExn;

	@WebMethod
	public String siteInfo();

}
