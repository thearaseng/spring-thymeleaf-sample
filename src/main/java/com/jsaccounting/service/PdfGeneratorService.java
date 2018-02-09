package com.jsaccounting.service;

import java.util.Map;

public interface PdfGeneratorService {

    boolean createPdf(String templateName, Map map) throws Exception;

}
