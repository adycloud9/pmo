package com.vsnl.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
public class PdfHelper
{
	
	public static BaseFont getFont(String fontType)
	{
		BaseFont bf=null;
		try {
			if (fontType.equalsIgnoreCase("arial")) {
				bf=BaseFont.createFont("C:\\Documents and Settings\\330943\\My Documents\\SIBA_WORKSPACE\\pmo_latest\\WebContent\\font\\arial.ttf",BaseFont.CP1252, BaseFont.EMBEDDED);
			}
			if (fontType.equalsIgnoreCase("comic")) {
				bf=BaseFont.createFont("C:\\Documents and Settings\\330943\\My Documents\\SIBA_WORKSPACE\\pmo_latest\\WebContent\\font\\comicbd.ttf",BaseFont.CP1252, BaseFont.EMBEDDED);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bf;
	}
	
	/**
	 * 
	 * @param table
	 * @param text
	 * @param colspan
	 * @param rowspan
	 * @param border
	 * @param bgColor
	 * @param borderClr
	 * @return
	 */
	public static  PdfPTable addCell(PdfPTable table,String text,int colspan,int rowspan,int border,BaseColor bgColor,BaseColor borderClr)
	{
		try {
			Font font = new Font(getFont("comic"), 8);
			Paragraph pg=new Paragraph(text,font);
			pg.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			PdfPCell cell = new PdfPCell();
			
			if (border!=1) {
				cell.setBorder(border);
				cell.setBorderColor(borderClr);
			}
			cell.setBackgroundColor(bgColor);
			cell.setRowspan(rowspan);
			cell.setColspan(colspan);
			cell.setPaddingBottom(6);
			cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			cell.addElement(pg);
			table.addCell(cell);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return table;
	}
	
	/**
	 * 
	 * @param table
	 * @param text
	 * @param colspan
	 * @param rowspan
	 * @param border
	 * @param bgColor
	 * @param borderClr
	 * @return
	 */
	public static  PdfPTable addCellHeader(PdfPTable table,String text,int colspan,int rowspan,int border,BaseColor bgColor,BaseColor borderClr)
	{
	    try {
		    //Font font = new Font(getFont("arial"), 20,Font.BOLD);
	    	Font font=FontFactory.getFont(FontFactory.TIMES_BOLD, 24,Font.UNDERLINE);
			Paragraph pg=new Paragraph(text,font);
			pg.setAlignment(Paragraph.ALIGN_CENTER);
			PdfPCell cell = new PdfPCell();
			cell.setBorder(border);
			cell.setBorderColor(borderClr);
			cell.setBackgroundColor(bgColor);
			cell.setRowspan(rowspan);
			cell.setColspan(colspan);
			cell.setPadding(3);
			cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			cell.addElement(pg);
			table.addCell(cell);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return table;
	}
	
	
	public static  PdfPTable addRectangle(PdfPTable table,String text,int colspan,int rowspan,int border,BaseColor bgColor,String alignment)
	{
		try {
			Font font = new Font(getFont("comic"), 8);
			Paragraph pg=new Paragraph(text,font);
			if (alignment.equalsIgnoreCase("center")) {
				pg.setAlignment(Paragraph.ALIGN_CENTER);
			}
			else {
				pg.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			}
			PdfPCell cell = new PdfPCell();
			cell.setBorder(Rectangle.BOX);
			cell.setRowspan(rowspan);
			cell.setColspan(colspan);
			cell.setPadding(3);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			cell.setBackgroundColor(bgColor);
			cell.addElement(pg);
			table.addCell(cell);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return table;
	}
	
	/**
	 * 
	 * @param number
	 * @return
	 */
	public static Paragraph addEmptyLine(Paragraph paragraph,int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
		return paragraph;
	}
	
	/**
	 * 
	 * @param text
	 * @param table
	 * @param tableSize
	 * @param numOfColumns
	 * @return
	 */
	 public static PdfPTable addColumn(String text,PdfPTable table,int tableSize,int numOfColumns) {
		 int colspan=tableSize/numOfColumns; 
		return addCell(table,text,colspan, 1, 1, new BaseColor(255,255,255), new BaseColor(0,0,0));
		}
	 
	 public static PdfPTable addColumnHeader(String text,PdfPTable table) { 
		 return addCell(table,text,4, 1, 1, new BaseColor(255,255,255), new BaseColor(0,0,0));
	 }
	 
	 
	 public static  PdfPTable addListIntoCell(PdfPTable table,List list,int colspan,int rowspan,int border,BaseColor bgColor,BaseColor borderClr)
		{
			try {
				PdfPCell cell = new PdfPCell();
				if (border!=1) {
					cell.setBorder(border);
					cell.setBorderColor(borderClr);
				}
				cell.setBackgroundColor(bgColor);
				cell.setRowspan(rowspan);
				cell.setColspan(colspan);
				cell.setPaddingBottom(6);
				cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.addElement(list);
				table.addCell(cell);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return table;
		}


}
