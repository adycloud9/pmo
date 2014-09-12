package com.vsnl.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vsnl.exception.ExceptionHandler;
import com.vsnl.manager.CommonManager;
import com.vsnl.util.Constants;


public class SowDao extends DataAccessObject {
	
	 private Logger logger = null;
	 
	


	public List createSOW(String[] inParams)throws Exception
	{
		List returnList=new ArrayList();
		Connection conn=null;
		CallableStatement cmt=null;
		try {
			conn=getConnection(Constants.PMS_DATASOURCE);
			cmt=conn.prepareCall("{call create_edit_Sow(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cmt.setString(1,inParams[0]);
			cmt.setDate(2,CommonManager.getSQLFormatDate(inParams[1],"dd-MMM-yyyy"));
			cmt.setString(3,inParams[2]);
			cmt.setString(4,inParams[3]);
			cmt.setString(5,inParams[4]);
			cmt.setString(6,inParams[5]);
			cmt.setString(7,inParams[6]);
			cmt.setString(8,inParams[7]);
			cmt.setString(9,inParams[8]);
			cmt.setString(10,inParams[9]);
			cmt.setString(11,inParams[10]);
			cmt.setString(12,inParams[11]);
			cmt.setString(13,inParams[12]);
			cmt.setString(14,inParams[13]);
			cmt.setString(15,inParams[14]);
			cmt.setString(16,inParams[15]);
			cmt.setString(17,inParams[16]);
			cmt.setString(18,inParams[17]);
			cmt.setString(19,inParams[18]);
			cmt.setString(20, inParams[19]);
			for (int i = 0; i < inParams.length; i++) {
				System.out.println("createSOW:InputParameters["+(i+1)+"]-->"+inParams[i]);
			}
			System.out.println("createSOW:before execute Proc");

			cmt.registerOutParameter(21,java.sql.Types.VARCHAR);
			cmt.registerOutParameter(22,java.sql.Types.CHAR);
			cmt.execute();
			System.out.println("createSOW:After execute Proc");
			returnList.add(cmt.getString(22));
			returnList.add(cmt.getString(21));
		}
		catch (SQLException sqle) {
			 ExceptionHandler.handleException("SowDao.setSow.SQLException", sqle);
		}
		catch (Exception e) {
			 ExceptionHandler.handleException("SowDao.setSow.Exception", e);
		}
		return returnList;
	}
}

