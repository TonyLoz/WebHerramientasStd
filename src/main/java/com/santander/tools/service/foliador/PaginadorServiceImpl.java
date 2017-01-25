/**
 * 
 */
package com.santander.tools.service.foliador;

import java.io.ByteArrayOutputStream;
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
	public byte[] paginarDocumento(byte[] inputFile, String outputFile) throws ServiceException {
		// the document
		PDDocument doc = null;
		byte[] stream = null;

		try {
			//System.out.println(inputFile);
			doc = PDDocument.load(inputFile);
			
			int num=1;
			for (PDPage page : doc.getPages()) {
				PDFont font = PDType1Font.HELVETICA;
				// page.getContents().getStream();
				try (PDPageContentStream contentStream = new PDPageContentStream(doc, page, true, true)) {
					// page.getContents().getStream();
					contentStream.beginText();
					contentStream.setFont(font, 24);
					contentStream.moveTextPositionByAmount(400, 100);
					contentStream.drawString("Pagina Numero: " + num);
					contentStream.endText();
				}
				
				num++;
			}

			// doc.save(outputFile);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			doc.save(byteArrayOutputStream);
		    stream = byteArrayOutputStream.toByteArray();
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
