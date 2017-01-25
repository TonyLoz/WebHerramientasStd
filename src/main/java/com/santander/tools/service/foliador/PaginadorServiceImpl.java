/**
 * 
 */
package com.santander.tools.service.foliador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import com.santander.commons.exceptions.ServiceException;


/**
 * @author z615563
 *
 */
@Service
public class PaginadorServiceImpl implements PaginadorService {

	private static Logger log = Logger.getLogger(PaginadorServiceImpl.class);
	
	@Override
	public InputStream paginarDocumento(byte[] inputFile, String outputFile) throws ServiceException {
		// the document
		PDDocument doc = null;
		InputStream stream = null;

		try {
			//System.out.println(inputFile);
			doc = PDDocument.load(inputFile);

			for (PDPage page : doc.getPages()) {
				PDFont font = PDType1Font.HELVETICA;
				// page.getContents().getStream();
				try (PDPageContentStream contentStream = new PDPageContentStream(doc, page, true, true)) {
					// page.getContents().getStream();
					contentStream.beginText();
					contentStream.setFont(font, 12);
					contentStream.moveTextPositionByAmount(100, 100);
					contentStream.drawString("Hello");
					contentStream.endText();
				}
			}

			// doc.save(outputFile);
			PDStream ps = new PDStream(doc);
			stream = ps.createInputStream();
		} catch (Exception e) {

			// TODO Auto-generated catch block
			log.error(e.getMessage());
			throw new ServiceException(e.getMessage());			

		} finally {

			/*if (doc != null) {
				try {
					//doc.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					log.error(e.getMessage());
					throw new ServiceException(e.getMessage());		
				}
			}*/
		}

		return stream;
	}

}
