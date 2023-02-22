/**
 * @(#)T001Dto.java 01-00 2021/07/16
 *
 * Copyright(C) 2021 by FUJINET CO., LTD.
 *
 * Last_Update 2021/07/16
 * Version 1.00.
 */
package fjs.cs.dto;

/**
 * T001Dto
 * 
 * @version 1.00
 * @since 1.00
 * @author Long-PH
 * 
 */
public class T001Dto {
	public String USERID, PASSWORD;

	public T001Dto() {

	}

	public T001Dto(String uSERID, String pASSWORD) {
		super();
		USERID = uSERID;
		PASSWORD = pASSWORD;
	}

	public String getUSERID() {
		return USERID;
	}

	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
}
