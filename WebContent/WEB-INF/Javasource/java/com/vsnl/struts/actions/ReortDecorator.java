/*
 *  Created on August 05, 2010
 ** Name: ReortDecorator.java
 * <p> 
 * 	
 * 
 * <b>Revision History:</b><pre> 
 * ======================================================================================== 
 *                          	       Prior 
 * Date       		   By          	  Version  				Description
 * [dd/mm/yyyy] 
 * ------------  -------------------- -------  ---------------------------------------------------- 
 * 05/08/2010      Siba Sahoo     		1.0   	 Created the file for PMO
 * ======================================================================================== 
 * </pre> 
 * 
  
 **/
package com.vsnl.struts.actions;

import org.displaytag.decorator.TableDecorator;

import com.vsnl.manager.CommonManager;
import com.vsnl.model.ReportEntity;

public class ReortDecorator extends TableDecorator{
	
	public String getMileStoneAmt()
	{
		ReportEntity reportEntity=(ReportEntity)getCurrentRowObject();
		CommonManager commonManager=new CommonManager();
		String amount=reportEntity.getMileStoneAmt();
		return  commonManager.amtWithComma(amount);
	}

}
