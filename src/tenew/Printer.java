/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenew;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

/**
 *
 * @author Joel
 */

public class Printer implements Printable{
    public static String mText;

    public static void setmText(String mText) {
        Printer.mText = mText;
    }
  
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

//        String mText = "SHOP MA;"
//                + "Pannampitiya;"
//                + "---------------------------------------;"
//                + "09-10-2012  harsha  no: 001 ;"
//                + "No  Item  Qty  Price  Amount ;"
//                + "---------------------------------------;"
//                + "1   Bread 1    50.00  50.00 ;"
//                + "---------------------------------------;";

        //Prepare the rendering
        String[] bill = this.mText.split(";");
        int y = 15;
        Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 10);
        graphics.setFont(f);
        for (int i = 0; i < bill.length; i++) {
            graphics.drawString(bill[i], 0, y);
            y = y + 15;
        }

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
     public void PrintTicket() throws PrinterException {
//        PrinterService ps = new PrinterService();
//        //get the printer service by printer name
//        PrintService pss = ps.getCheckPrintService("Bullzip PDF Printer");
        PrintService pss =
                PrintServiceLookup.lookupDefaultPrintService();
        
        if (pss != null) {
            String printServiceName = pss.getName();
            System.out.println("Print Service Name is " + printServiceName);
        } else {
            System.out.println("No default print service found");
        }

        PrinterJob job = PrinterJob.getPrinterJob();
        PageFormat pf = job.defaultPage();
         Paper p = new Paper();
         p.setImageableArea(5,5, p.getWidth()-10, p.getHeight()-10);
         pf.setPaper(p);         
        job.setPrintService(pss);
        job.setPrintable(this,pf);

        try {
            job.print();               
            //job.print(); 
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }

    }    
}
