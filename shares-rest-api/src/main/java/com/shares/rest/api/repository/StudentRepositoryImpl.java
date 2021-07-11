package com.shares.rest.api.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.shares.rest.api.entity.StudentTable;
import com.shares.rest.api.hibernate.SafeSession;

public class StudentRepositoryImpl implements StudentRepositoryCustom, SafeSession {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List<StudentTable> getAllStudentsForTableDisplay() {
		Session session = getTangibleSession(sessionFactory);
		
		StringBuilder hql = new StringBuilder();
		hql.append("select sd from StudentTable1 sd ");
		hql.append("join fetch sd.status st ");
		hql.append("join fetch sd.elemRegion er ");
		hql.append("join fetch sd.jhsRegion jr ");
		hql.append("join fetch sd.shsSchoolFirstchoice sshFc ");
		hql.append("join fetch sd.shsTrackFirstchoice stkFc ");
		hql.append("join fetch sd.shsStrspecFirstchoice sspFc ");
		hql.append("join fetch sd.shsSchoolSecondchoice sshSc ");
		hql.append("join fetch sd.shsTrackSecondchoice stkSc ");
		hql.append("join fetch sd.shsStrspecSecondchoice sspSc ");
		hql.append("where st.cfMajor = 'SST' and er.cfMajor = 'RGN' and ");
		hql.append("jr.cfMajor = 'RGN' and sshFc.cfMajor = 'SCH' and ");
		hql.append("stkFc.cfMajor = 'TRK' and stkFc.cfGeneral2 = sshFc.cfMinor and ");
		hql.append("sspFc.cfMajor = 'SAS' and sspFc.cfGeneral1 = stkFc.cfMinor and sspFc.cfGeneral2 = sshFc.cfMinor and ");
		hql.append("sshSc.cfMajor = 'SCH' and stkSc.cfMajor = 'TRK' and stkSc.cfGeneral2 =  sshSc.cfMinor and ");
		hql.append("sspSc.cfMajor = 'SAS' and sspSc.cfGeneral1 = stkSc.cfMinor and sspSc.cfGeneral2 = sshSc.cfMinor");
		Query<StudentTable> qry = session.createQuery(hql.toString(), 
			StudentTable.class);
				
		return qry.getResultList();
	}
}
