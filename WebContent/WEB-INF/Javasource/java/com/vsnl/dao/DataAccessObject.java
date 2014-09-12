package com.vsnl.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.vsnl.util.Constants;


import com.vsnl.exception.AppException;
import com.vsnl.exception.ExceptionHandler;

/** 
 * @author Tata Consultancy Services
 * @version 1.0
 */
public class DataAccessObject {

    private static  DataSource ds = null;
    private static Logger logger = Logger.getLogger(DataAccessObject.class);
    /**
     * DataAccessObject blank constructor .
     */
    public DataAccessObject() {
    	
    }

    /**
     * Method getDataSource
     * @param dsName String 
     * @return ds DataSource 
     * @throws Exception  
     */
    public  static DataSource getDataSource(String dsName)  throws AppException {
        try {
        	
			ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.jdbc");
			String datasource = resourceBundle.getString("datasource.prefix");   
           
				InitialContext ctx = new InitialContext();
	            ds = (DataSource) ctx.lookup(datasource+dsName);
            
            
        } catch (NamingException ne) {
        	ExceptionHandler.handleException("DataAccessObject.getDataSource.NamingException",ne);
            	
        } catch (Exception e) {
        	ExceptionHandler.handleException("DataAccessObject.getDataSource.Exception", e);	
        }
        
        return ds;
    }

    /**
     * Method getConnection
     * @param dsName String 
     * @param uName String
     * @param password String 
     * @return Connection 
     * @throws Exception  
     */

    public Connection getConnection(String dsName, String uName, String password) throws AppException {

        Connection connection = null;

        try {
        
		/* cache the datasource object */

        	if(ds ==null) {
        	     ds = DataAccessObject.getDataSource(dsName);
        	}
            connection = ds.getConnection(uName, password);
        } catch (SQLException sqle) {
        	logger.warn("DataAccessObject::getConnection::connection failure");
            ExceptionHandler.handleException("DataAccessObject.getConnection.SQLException", sqle);	
        } catch (Exception e) {
        	logger.warn("DataAccessObject::getConnection::connection failure");
            ExceptionHandler.handleException("DataAccessObject.getConnection.Exception", e);	
        }
        return connection;
    }

    
    /**
     * Method getConnection
     * @param dsName String 
     * @param uName String
     * @param password String 
     * @return Connection 
     * @throws Exception  
     */

    public Connection getConnection(String dsName) throws Exception {

      Connection connection = null;

        try {
        	 System.out.println("*********************DS name "+dsName);
       	     ds = getDataSource(dsName);
        	
       	     
            connection = ds.getConnection();
        } catch (SQLException sqle) {
        	System.out.println(sqle.getMessage());
        	throw new AppException("DataAccessObject.getConnection.SQLException", sqle);	
        } catch (Exception e) {
        	throw new AppException("DataAccessObject.getConnection.Exception", e);	
        }

        return connection;
    }
    public static Connection getDBConnection() throws Exception {
    	String strUrl="";
    	String strUsername="";
    	String strPassword="";
    	Connection conn = null;
    	try {
    			Class.forName("com.mysql.jdbc.Driver");
    			ResourceBundle bundle = ResourceBundle.getBundle("resources.dbconnection");
    			strUrl = bundle.getString("URL");
    			strUsername = bundle.getString("USERNAME");
    			strPassword = bundle.getString("PASSWORD");
    			conn = DriverManager.getConnection(strUrl,strUsername,strPassword);
    			logger.info("Connection Established.....");
    			logger.info("With Url"+strUrl);
    			logger.info("Username"+strUsername);
    			logger.info("Password"+strPassword);
    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}
    		
    		return conn; 
        }
    

    /**
     * Method cleanUp
     * @param ioConnection Connection
     * @throws Exception  
     */

    protected final void cleanUp(Connection ioConnection)  throws AppException {
		
        try {
            if (ioConnection != null) {
            	if(!ioConnection.isClosed()){
            		ioConnection.close();
            	}
            }
        } catch (SQLException peSE) {
            ExceptionHandler.handleException("DataAccessObject.cleanUp.Exception", peSE);				
        }
    }

    /**
     * Method getDataSource
     * @param ioConnection Connection 
     * @param pstmt Statement 
     * @throws Exception  
     */

    protected final void cleanUp(Connection ioConnection, Statement pstmt)  throws AppException {
        cleanUp(ioConnection, pstmt, null);
    }
    
    /**
     * Method cleanUp  
     * @param pstmt Statement 
     * @throws Exception  
     */
    protected final void cleanUp(PreparedStatement pstmt)  throws AppException {
		
        try {
            if (pstmt != null) {
            	pstmt.close();
            }
        } catch (SQLException peSE) {
            ExceptionHandler.handleException("DataAccessObject.cleanUp.Exception", peSE);				
        }
    }
    /**
     * Method cleanUp  
     * @param pstmt Statement ,ResultSet rs
     * @throws Exception  
     */
    protected final void cleanUp(PreparedStatement pstmt,ResultSet rs)  throws AppException {
		
        try {
            if (pstmt != null) {
            	pstmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException peSE) {
            ExceptionHandler.handleException("DataAccessObject.cleanUp.Exception", peSE);				
        }
    }
    
    
    /**
     * Method cleanUp
     * @param ioConnection Connection
     * @param pstmt Statement
     * @param rs ResultSet 
     * @throws Exception  
     */

    protected final void cleanUp(Connection ioConnection, Statement pstmt, ResultSet rs)  throws AppException {
		
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (rs != null) {
                rs.close();
            }
			
        } catch (SQLException peSE) {
            ExceptionHandler.handleException("DataAccessObject.cleanUp.Exception", peSE);				
        } finally {
            this.cleanUp(ioConnection);
        }
    }
  protected final void cleanUp(Connection ioConnection, PreparedStatement pstmt, ResultSet rs,CallableStatement call)  throws AppException {
		
        try {
        	cleanUp(pstmt,rs);
            cleanUp(call);
        } catch (Exception peSE) {
            ExceptionHandler.handleException("DataAccessObject.cleanUp.Exception", peSE);				
        } finally {
            this.cleanUp(ioConnection);
        }
    }
  protected final void cleanUp(CallableStatement call)  throws AppException {
		
      try {
      	 if(call!=null){
          	call.close();
          }
			
      } catch (SQLException peSE) {
          ExceptionHandler.handleException("DataAccessObject.cleanUp.Exception", peSE);				
      } finally {
      }
  }
    /**
     * Method cleanUp
     * @param ioConnection Connection 
     * @param pstmts Vector 
     * @throws Exception  
     */


    /**
     * Method rollBack
     * @param ioConnection Connection
     * @throws Exception 
     */

    protected final void rollBack(Connection ioConnection)  throws AppException {
		
        try {
            if (ioConnection != null) {
                ioConnection.rollback();

            }
        } catch (SQLException peSE) {
            ExceptionHandler.handleException("DataAccessObject.cleanUp.Exception", peSE);				

        } finally {}
    }
    /**
     * To clean the ArrayList Object
     * @param ioConnection
     * @throws AppException
     */
   protected final void cleanObject(List list)  throws AppException {
		
        try {
            if (list != null) {
            	list.clear();

            }
        } catch (Exception peSE) {
            ExceptionHandler.handleException("DataAccessObject.cleanUp.Exception", peSE);				

        } finally {
        	
        }
    }
    
    /**
     * Method getSysDate
     * @param 
     * @throws Exception 
     */
    public String getSysDate () throws Exception {
    	String date = null;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	try {
    		conn = this.getConnection(Constants.PMS_DATASOURCE);
    		String query = "select to_char(sysdate,'dd-MM-yyyy') systemdate from dual";
    		pstmt = conn.prepareStatement(query);
    		rs = pstmt.executeQuery();
    		while (rs.next()){
    			date = rs.getString("systemdate");
    		}
    		
    	} catch (SQLException sqle) {
        	throw new AppException("DataAccessObject.getSysdate.SQLException", sqle);	
        } catch (Exception e) {
        	throw new AppException("DataAccessObject.getSysdate.Exception", e);	
        } finally {
        	this.cleanUp(conn, pstmt, rs);
        }
    	
    	return date;
    }
    
    /**
     * Method getSysDate
     * @param 
     * @throws Exception 
     */
    public String getSysDateinMon () throws Exception {
    	String date = null;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	try {
    		conn = this.getConnection(Constants.PMS_DATASOURCE);
    		//select to_char(sysdate,'dd-mon-yyyy') from dual
    		String query = "select to_char(sysdate,'dd-mon-yyyy') systemdate from dual";
    		pstmt = conn.prepareStatement(query);
    		rs = pstmt.executeQuery();
    		while (rs.next()){
    			date = rs.getString("systemdate");
    		}
    		
    	} catch (SQLException sqle) {
        	throw new AppException("DataAccessObject.getSysdate.SQLException", sqle);	
        } catch (Exception e) {
        	throw new AppException("DataAccessObject.getSysdate.Exception", e);	
        } finally {
        	this.cleanUp(conn, pstmt, rs);
        }
    	
    	return date;
    }

}


