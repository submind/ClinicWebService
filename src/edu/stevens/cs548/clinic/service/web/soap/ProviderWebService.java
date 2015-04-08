package edu.stevens.cs548.clinic.service.web.soap;

import java.util.List;

import javax.ejb.EJB;
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
import edu.stevens.cs548.clinic.service.ejb.IProviderServiceLocal;

@WebService(
	endpointInterface = "edu.stevens.cs548.clinic.service.web.soap.IProviderWebService", 
	serviceName = "ProviderWebService", 
	targetNamespace = "http://cs548.stevens.edu/clinic/service/web/soap", 
	portName = "ProviderWebPort")
public class ProviderWebService implements IProviderWebService {

	@EJB(beanName = "ProviderServiceBean")
	IProviderServiceLocal service;

	@Override
	public void addProvider(String name, long npi) throws ProviderServiceExn {
		service.addProvider(name, npi);

	}
	
	@Override
	public void addProvider(String name, long npi, String specialization) throws ProviderServiceExn {
		service.addProvider(name, npi, specialization);

	}

	@Override
	public ProviderDTO[] getProviderByName(String name) throws ProviderExn,
			ProviderServiceExn {
		return service.getProviderByName(name);
	}

	@Override
	public ProviderDTO getProvidersByNpi(long npi) throws ProviderServiceExn {
		return service.getProvidersByNpi(npi);
	}


	@Override
	public void addTreatment(long patientId, long providerNPI,
			TreatmentDto TreatmentDto) throws ProviderServiceExn {
		service.addTreatment(patientId, providerNPI, TreatmentDto);
	}

	@Override
	public void deleteTreatment(long id, long tid, long npi)
			throws PatientNotFoundExn, ProviderNotFoundExn, ProviderServiceExn,
			TreatmentNotFoundExn {
		service.deleteTreatment(id, tid, npi);
	}

	@Override
	public List<Long> getTreatmentsforPatient(long npi, PatientDto patient)
			throws ProviderExn, TreatmentExn, PatientExn {
		return service.getTreatmentsforPatient(npi, patient);
	}

	@Override
	public TreatmentDto[] getTreatmentsByProviderNpi(long npi)
			throws ProviderNotFoundExn, TreatmentNotFoundExn,
			ProviderServiceExn {
		return service.getTreatmentsByProviderNpi(npi);
	}

	@Override
	public String siteInfo() {
		return service.siteInfo();
	}

}
