package com.jsaccounting.controller;

import com.jsaccounting.service.PdfGeneratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class ReportController extends AbstractBaseController {

    @Autowired
    PdfGeneratorServiceImpl pdfGeneratorService;

    @RequestMapping("/tax-invoice")
    public String taxInvoice(Model model){

        Map<String, String> map = new HashMap<>();
        map.put("test", "សួស្ដី");
        map.put("test", "សួស្ដី");

        try {
            pdfGeneratorService.createPdf("report/tax-invoice", map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getFullViewName("tax-invoice");
    }

    @Override
    protected String getFullViewName(String viewName) {
        return "report/".concat(viewName);
    }
}
