package com.jsaccounting.library.itextkhmer;

import com.itextpdf.text.pdf.BidiLine;
import com.itextpdf.text.pdf.languages.LanguageProcessor;
import com.jsaccounting.library.itextkhmer.render.UnicodeRender;

public class KhmerLigature implements LanguageProcessor {

    @Override
    public String process(String s) {
        UnicodeRender khmerRender = new UnicodeRender();
        return BidiLine.processLTR(khmerRender.render(s), 2, 0);
    }

    @Override
    public boolean isRTL() {
        return false;
    }
}
