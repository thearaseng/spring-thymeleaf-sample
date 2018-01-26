package com.jsaccounting.service;

import com.lowagie.text.pdf.BaseFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

@Service
public class PdfGeneratorServiceImpl {

    @Autowired
    private TemplateEngine templateEngine;

    public void createPdf(String templateName, Map map) throws Exception {
        Assert.notNull(templateName, "The templateName can not be null");
        Context ctx = new Context();
        if (map != null) {
            Iterator itMap = map.entrySet().iterator();
            while (itMap.hasNext()) {
                Map.Entry pair = (Map.Entry) itMap.next();
                ctx.setVariable(pair.getKey().toString(), pair.getValue());
            }
        }

        String processedHtml = templateEngine.process(templateName, ctx);
        FileOutputStream os = null;
        String fileName = "test";
        try {
            final File outputFile = File.createTempFile(fileName, ".pdf", new File("C:\\Users\\th.seng\\Desktop\\theara"));
            os = new FileOutputStream(outputFile);

            /*URL fontUrl = getClass().getResource("ddfdf");

            System.out.println(fontUrl.getPath());*/

            ITextRenderer renderer = new ITextRenderer();

            renderer.getFontResolver().addFont("C:\\Users\\th.seng\\Desktop\\KHMKAMPOT.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            renderer.setDocumentFromString(processedHtml);
            renderer.layout();
            renderer.createPDF(os, false);
            renderer.finishPDF();
            System.out.println("PDF created successfully");
        }
        finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) { /*ignore*/ }
            }
        }
    }

}
