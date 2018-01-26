package com.jsaccounting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController extends AbstractBaseController {

    @RequestMapping("/tax-invoice")
    public String taxInvoice(Model model){
        return getFullViewName("tax-invoice");
    }

    @Override
    protected String getFullViewName(String viewName) {
        return "report/".concat(viewName);
    }
}
