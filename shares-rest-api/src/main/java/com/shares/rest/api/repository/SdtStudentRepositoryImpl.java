package com.shares.rest.api.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.Query;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;
import org.springframework.beans.factory.annotation.Autowired;

import com.shares.rest.api.data.BatchUpdateResult;
import com.shares.rest.api.data.GuidanceReportResult;
import com.shares.rest.api.entity.EnrSection;
import com.shares.rest.api.entity.SdtStudent;
import com.shares.rest.api.entity.SdtStudent_;
import com.shares.rest.api.hibernate.SafeSession;
import com.shares.rest.api.utils.Loop;

public class SdtStudentRepositoryImpl implements SdtStudentRepositoryCustom, SafeSession {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CfgStatusRepository cfgStatusRepository;
	
	private String evaluateObjectToString(Object object) {
		if(object == null) {
			return "";
		}
		else {
			return object.toString();
		}
	}
		
	@Override
	public List<SdtStudent> getAllCurrentlyEnrolledStudents(boolean withAssignedSection, String shsSy, String shsSem) {
		Session session = getTangibleSession(sessionFactory);
			
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<SdtStudent> criteriaQuery = criteriaBuilder.createQuery(SdtStudent.class);
		Root<SdtStudent> root = criteriaQuery.from(SdtStudent.class);
		
		Predicate predStatusCen = criteriaBuilder.equal(root.get(SdtStudent_.status), cfgStatusRepository.findByCode("CEN"));
		Predicate predforSY = criteriaBuilder.equal(root.get(SdtStudent_.shsSy), shsSy);
		Predicate predForSem = criteriaBuilder.equal(root.get(SdtStudent_.shsSem), shsSem);
		Predicate predWOSection = criteriaBuilder.isNull(root.get(SdtStudent_.section));

		Predicate predFinal = criteriaBuilder.and(predforSY, predForSem, predStatusCen);
		if(withAssignedSection) {
			predFinal = criteriaBuilder.and(predforSY, predForSem, predStatusCen);
		}
		else {
			predFinal = criteriaBuilder.and(predforSY, predForSem, predStatusCen, predWOSection);
		}
		
		criteriaQuery.select(root)
		.where(predFinal);
			
		Query<SdtStudent> qry = session.createQuery(criteriaQuery);
		
		/*List<SdtStudent> returnList = new ArrayList<>(); 
		qry.getResultList().forEach(sdtStudent -> {
			if(withAssignedSection) {
				if(!sdtStudent.getEnrSection().isEmpty()) {
					returnList.add(sdtStudent);
				}
			}
			else {
				if(sdtStudent.getEnrSection().isEmpty()) {
					returnList.add(sdtStudent);
				}				
			}
			
		});		
				
		return returnList;*/
		
		return qry.getResultList();
	}

	@Override
	public List<SdtStudent> getAllCurrentlyEnrolledStudentsSection(EnrSection enrSection, String shsSy, String shsSem) {
		Session session = getTangibleSession(sessionFactory);

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<SdtStudent> criteriaQuery = criteriaBuilder.createQuery(SdtStudent.class);
		Root<SdtStudent> root = criteriaQuery.from(SdtStudent.class);

		Predicate predStatusCen = criteriaBuilder.equal(root.get(SdtStudent_.status), cfgStatusRepository.findByCode("CEN"));
		Predicate predForSY = criteriaBuilder.equal(root.get(SdtStudent_.shsSy), shsSy);
		Predicate predForSem = criteriaBuilder.equal(root.get(SdtStudent_.shsSem), shsSem);
		Predicate predSection = criteriaBuilder.equal(root.get(SdtStudent_.section),  enrSection);

		Predicate predFinal = criteriaBuilder.and(predForSY, predForSem, predSection, predStatusCen);
		criteriaQuery.select(root)
		.where(predFinal);

		Query<SdtStudent> qry = session.createQuery(criteriaQuery);	

		return qry.getResultList();
	}

	@Override
	public BatchUpdateResult batchUpdateSdtStudents(List<SdtStudent> sdtStudents) {

		BatchUpdateResult updateResult = new BatchUpdateResult();
		Transaction transaction = null;		
		try(Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			sdtStudents.forEach(Loop.withCounter((i, sdtStudent) -> {
				session.update(sdtStudent);
			    /*if ( i % 20 == 0 ) { //20, same as the JDBC batch size
			        //flush a batch of inserts and release memory:
			        session.flush();
			        session.clear();
			    }*/
			}));
			
			transaction.commit();
			session.close();			
			updateResult.setUpdateSuccessfull(true);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			updateResult.setMessage(ex.getMessage());
			updateResult.setUpdateSuccessfull(false);
			
			if (transaction != null) {
				transaction.rollback();
			}			
		}
		
		return updateResult;
	}

	@Override
	public List<GuidanceReportResult> getGuidanceEarlyRegistrationReport(String shsSy) {
		Session session = getTangibleSession(sessionFactory);
		
	
		ProcedureCall call = session.createStoredProcedureCall("SP_GuidanceReport");
		call.registerParameter(1, String.class, ParameterMode.IN).bindValue(shsSy);
		Output output = call.getOutputs().getCurrent();
		
		@SuppressWarnings("unchecked")
		List<Object[]> results = ((ResultSetOutput)output).getResultList();
		
		List<GuidanceReportResult> resultSet = new ArrayList<>();
		results.forEach(result -> {
			GuidanceReportResult rec = new GuidanceReportResult();
			rec.setId(evaluateObjectToString(result[0]));
			rec.setLrn(evaluateObjectToString(result[1]));
			rec.setStudentName(evaluateObjectToString(result[2]));
			rec.setFcSchoolCode(evaluateObjectToString(result[3]));
			rec.setFcSchoolName(evaluateObjectToString(result[4]));
			rec.setFcSchoolOthers(evaluateObjectToString(result[5]));			
			rec.setFcTrackCode(evaluateObjectToString(result[6]));
			rec.setFcTrackName(evaluateObjectToString(result[7]));
			rec.setFcStrndSpecCode(evaluateObjectToString(result[8]));
			rec.setFcStrndSpecName(evaluateObjectToString(result[9]));
			rec.setScSchoolCode(evaluateObjectToString(result[10]));
			rec.setScSchoolName(evaluateObjectToString(result[11]));
			rec.setScSchoolOthers(evaluateObjectToString(result[12]));			
			rec.setScTrackCode(evaluateObjectToString(result[13]));
			rec.setScTrackName(evaluateObjectToString(result[14]));
			rec.setScStrndSpecCode(evaluateObjectToString(result[15]));
			rec.setScStrndSpecName(evaluateObjectToString(result[16]));			
			rec.setGender(evaluateObjectToString(result[17]));
			
			resultSet.add(rec);
		});
		
		return resultSet;
	}
}