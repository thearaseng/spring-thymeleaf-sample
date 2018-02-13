package com.jsaccounting.service.impl;

import com.jsaccounting.service.PdfGeneratorService;
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
import java.util.Map;

@Service
public class PdfGeneratorServiceImpl implements PdfGeneratorService {

    private TemplateEngine templateEngine;

    @Autowired
    public PdfGeneratorServiceImpl(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public boolean createPdf(String templateName, Map map) throws Exception {
        Assert.notNull(templateName, "The templateName can not be null");
        Context ctx = new Context();
        if (map != null) {
            for (Object o : map.entrySet()) {
                Map.Entry pair = (Map.Entry) o;
                ctx.setVariable(pair.getKey().toString(), pair.getValue());
            }
        }

        String processedHtml = templateEngine.process(templateName, ctx);
        FileOutputStream os = null;
        String fileName = "test";
        try {
            final File outputFile = File.createTempFile(fileName, ".pdf", new File("D:\\User Profile\\Desktop\\theara"));
            os = new FileOutputStream(outputFile);

            /*URL fontUrl = getClass().getResource("ddfdf");

            System.out.println(fontUrl.getPath());*/

            ITextRenderer renderer = new ITextRenderer();

            renderer.getFontResolver().addFont("D:\\User Profile\\Desktop\\kh_battambang.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

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

        return true;
    }

}
