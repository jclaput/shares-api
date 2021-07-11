package com.shares.rest.api.repository;

import java.util.List;

import com.shares.rest.api.data.BatchUpdateResult;
import com.shares.rest.api.data.GuidanceReportResult;
import com.shares.rest.api.entity.EnrSection;
import com.shares.rest.api.entity.SdtStudent;

public interface SdtStudentRepositoryCustom {
	List<SdtStudent> getAllCurrentlyEnrolledStudents(boolean withAssignedSection, String shsSy, String shsSem);
	List<SdtStudent> getAllCurrentlyEnrolledStudentsSection(EnrSection enrSection, String shsSy, String shsSem);
	BatchUpdateResult batchUpdateSdtStudents(List<SdtStudent> sdtStudents);
	List<GuidanceReportResult> getGuidanceEarlyRegistrationReport(String shsSy);
}
