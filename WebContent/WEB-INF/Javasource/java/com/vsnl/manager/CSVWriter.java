package com.vsnl.manager;

/**
 * This class handles the writing of data into a CSV file
 *
 * Name: CSVWriter.java
 * <p>
 * <b>Revision History:</b><pre>
 * ============================================================================================
 *                            Prior
 * Date             By                   Version  	    Description
 * ----------     ---------------         -------  	   -------------------------------------------------------
 * 20/07/2010	  Saurabh Dandekar		    1.0			 Created the File - Changes done for Roar CR - Credit Debit Bulk Upload
 * 20/07/2010	  Megha Kala		        1.1			 Changes done for Dispatch Phase 2 CR  
 * ==============================================================================================
 * </pre>
 *
 
 * @version  1.0.0
 * @since    POS 1.0
 **/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * helper class to write table data to a csv-file (comma separated values).
 * the first line in file is a list of fieldnames, all following lines
 * are data lines.
 * usage: create a object using the constructor. call writeHeader
 * for writing the filename header then add data with writeData.
 * at the end close() closes the file.
 *
 */
public class CSVWriter {

    private String             newline = System.getProperty("line.separator");
    private OutputStreamWriter writer  = null;
    private int                nbrCols = 0;
    private int                nbrRows = 0;

    /**
     * constructor.
     * creates a csv file for writing data to it
     * @param file the file to write data to
     * @param encoding encoding to use or null (=defualt)
     */
    public CSVWriter(File file, String encoding) throws IOException {

        if (encoding == null) {
            encoding = System.getProperty("file.encoding");
        }

        FileOutputStream fout = new FileOutputStream(file);

        writer = new OutputStreamWriter(fout, encoding);
    }

    /**
     * writes the csv header (fieldnames). should be called after
     * construction one time.
     * @param header String[] with fieldnames
     */
    public void writeHeader(String[] header) throws IOException {

        this.nbrCols = header.length;

        doWriteData(header);
    }

    /**
     * writes a data-record to the file. note that data[] must have
     * same number of elements as the header had.
     *
     * @param data data to write to csv-file
     */
    public void writeData(String[] data) throws IOException {
    	doWriteData(data);
        
    }

    /**
     * closes the csv file.
     */
    public void close() throws IOException {
        this.writer.close();
    }

    /**
     * @param values
     * @throws IOException
     */
    private void doWriteData(String[] values) throws IOException {

        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                this.writer.write(",");            	
            }
            if (values[i] != null) {
                this.writer.write("\"");
                this.writer.write(this.toCsvValue(values[i]));
                this.writer.write("\"");
            }
        }
        this.writer.write(newline);

        this.nbrRows++;
    }

//  version 1.1 starts here
    /**
     * writes the csv header (fieldnames). should be called after
     * construction one time.
     * @param header String[] with fieldnames
     */
    public void writeHeaderToCSV(String[] header) throws Exception {

        this.nbrCols = header.length;

        writeDataIntoCSVFile(header);
    }

    /**
     * writes a data-record to the file. note that data[] must have
     * same number of elements as the header had.
     *
     * @param data data to write to csv-file
     */
    public void writeDataToCSV(String[] data) throws Exception {
    	writeDataIntoCSVFile(data);
        
    }
  
    /**
     * @param values
     * @throws Exception
     */
    private void writeDataIntoCSVFile(String[] values) throws Exception {

    		
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                this.writer.write(",");            	
            }
            if (values[i] != null) {                
                this.writer.write(this.toCsvValue(values[i]));      
               
            }
        }
        this.writer.write(newline);        
        this.nbrRows++;
    }
    
    /**
     * writes a data-record to the file. note that data[] must have
     * same number of elements as the header had.
     *
     * @param data data to write to a seperated-file
     */
    public void writeDataToSV(String[] data,String seperator) throws Exception {
    	writeDataIntoSVFile(data,seperator);
        
    }
    
    /**
     * writes the csv header (fieldnames). should be called after
     * construction one time.
     * @param header String[] with fieldnames
     */
    public void writeHeaderIntoSVFile(String[] header,String seperator) throws Exception {

        this.nbrCols = header.length;

        writeDataIntoSVFile(header,seperator);
    }
  
    /**
     * @param values
     * @throws Exception
     */
    private void writeDataIntoSVFile(String[] values,String seperator) throws Exception {

    	String str="";
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                this.writer.write(seperator);            	
            }           
            if (values[i] != null) { 
            	str=values[i].replaceAll("\n","");         
                this.writer.write(this.toCsvValue(str));                     
            }
        }
        this.writer.write(newline);        
        this.nbrRows++;
    } 
    
    // version 1.1 ends here
    
    
    /**
     * @param str
     * @return
     */
    private String toCsvValue(String str) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);            
            sb.append(c);

            switch (c) {

                case '"' :
                    sb.append('"');
                    break;
               
            }
        }       
        return sb.toString();
    }
}