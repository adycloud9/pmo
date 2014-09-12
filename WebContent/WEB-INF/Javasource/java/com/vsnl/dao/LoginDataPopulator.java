package com.vsnl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import org.apache.log4j.Logger;

import com.vsnl.dao.MenuDAO;
import com.vsnl.dao.DataAccessObject;
import com.vsnl.exception.AppException;
import com.vsnl.exception.ExceptionHandler;
import com.vsnl.util.Constants;
/**
 * @author 155977
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class LoginDataPopulator extends DataAccessObject{
    Logger logger = Logger.getLogger(LoginDataPopulator.class);
	
    public String getUserRole(String employeeId) throws Exception{      
        Connection conn=null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String role="";
        try{            
            conn = getConnection(Constants.PMS_DATASOURCE);
            
            String query = "select distinct role from test.emp_detail where empId=?";  
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, employeeId);
            rs=pstmt.executeQuery();            
            while(rs.next()){ 
            	role=rs.getString(1);   
            }
        }catch(Exception e){
                e.printStackTrace();               
        }finally{
            this.cleanUp(conn,pstmt,rs);
        }
        return role;
            
    }
    public List getMenu(String role)throws AppException {
		MenuDAO MenuDAO = new MenuDAO();
		List menuList=new ArrayList();
		try{
		menuList=MenuDAO.GetMenu(role);
		}catch(Exception e){
			logger.debug("Exception in Manager: "+e);
		}
		return menuList;
	}  
}
