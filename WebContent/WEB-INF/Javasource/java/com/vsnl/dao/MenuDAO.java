/** 
 * 
 * 
 * Name: MenuDao.java
 * <p> 
 * <b>Revision History:</b><pre> 
 * ===================================================================================================== 
 *                            Prior 
 * Date        By              Version      Description 
 * ---------- --------------- -------  ------------------------------------------------------------------ 
 *                				 1.0	    Created the File. 
 * 
 * =========================================================================================================== 
 * </pre> 
 * 
  

 **/
package com.vsnl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.vsnl.model.Letter;
import com.vsnl.util.Constants;
import com.vsnl.exception.AppException;
import com.vsnl.exception.ExceptionHandler;

public class MenuDAO extends DataAccessObject{
	
	public List GetMenu(String role) throws SQLException,AppException{		
		List MenuDetailsList =  new ArrayList() ;
		Connection conn=null;
		PreparedStatement pstmt = null;
		PreparedStatement innerPstmt = null;
		ResultSet rs = null;
		ResultSet innerRs = null;
		String Query =null;
		String innerQuery =null;
		try
		{   
			Query= "select b.menu_id,b.menu_code,b.menu_title,b.menu_url from menu_master b where b.menu_id in (select distinct a.p_menu_id from user_menu a,menu_matrix b where a.Menu_id = b.Menu_id and  b.role =?)";
			
			//innerQuery="select distinct b.menu_id,b.menu_code,b.menu_title,b.menu_url from user_menu a,menu_master b where a.Menu_id = b.Menu_id and b.p_menu_id = ? and b.menu_id <> b.p_menu_id";
			innerQuery="SELECT DISTINCT B.MENU_ID, B.MENU_CODE, B.MENU_TITLE, B.MENU_URL FROM USER_MENU A, MENU_MASTER B,menu_matrix C WHERE A.MENU_ID = B.MENU_ID AND C.MENU_ID = b.menu_id and C.ROLE = ? AND B.P_MENU_ID = ? ORDER BY MENU_ID";//ver 1.1
			System.out.println("Query: "+Query);
			conn=getConnection(Constants.PMS_DATASOURCE);
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, role);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				Letter letter=new Letter();
				letter.setMenuId(rs.getString("menu_id"));
				letter.setMenuCode(rs.getString("menu_code"));
				letter.setMenuTitle(rs.getString("menu_title"));
				letter.setMenuurl(rs.getString("menu_url"));
				MenuDetailsList.add(letter);
				Connection innerConn = getConnection(Constants.PMS_DATASOURCE);
				innerPstmt = innerConn.prepareStatement(innerQuery);
				innerPstmt.setString(1, role);
				innerPstmt.setString(2, letter.getMenuId());
			
				innerRs = innerPstmt.executeQuery();
				while(innerRs.next())
				{
					Letter innerLetter=new Letter();
					innerLetter.setMenuId("-"+innerRs.getString("menu_id"));
					innerLetter.setMenuCode(innerRs.getString("menu_code"));
					innerLetter.setMenuTitle(innerRs.getString("menu_title"));
					innerLetter.setMenuurl(innerRs.getString("menu_url"));
					MenuDetailsList.add(innerLetter);
				}
				innerRs.close();
				innerPstmt.close();
				innerConn.close();
			}
			System.out.println("fuction executed. List Size is: "+MenuDetailsList.size());
		}
		catch(SQLException sqle)
		{
			ExceptionHandler.handleException("MenuDAO.Menudatabase.SQLException",sqle);
			}
		catch (Exception e){
			ExceptionHandler.handleException("MenuDAO.Menudatabase.SQLException",e);
		}
		finally{
		this.cleanUp(conn,pstmt,rs);
		}
		
		return MenuDetailsList;
  }	
		
}