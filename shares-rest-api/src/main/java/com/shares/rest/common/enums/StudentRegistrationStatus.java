package com.shares.rest.common.enums;

/*Return Codes
 * UD - Error Undefined
 * NR - Not Registered for current school year/semester
 * AR - Already registered for current school year/semester
 * DE - Student record does not exist
 * CE - Student is already enrolled for current school year/semester
 * GR - Student already a graduated
 * KO - Student was kicked-out
 * DR - Student is a drop-out
 */
public enum StudentRegistrationStatus {
	UD, NR, AR, DE, CE, GR, KO, DR
}
