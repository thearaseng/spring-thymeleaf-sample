package com.jsaccounting.configuration;

import com.itextpdf.text.pdf.languages.LanguageProcessor;
import com.jsaccounting.library.itextkhmer.KhmerLigature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsAccountingConfig {

    @Bean
    public LanguageProcessor khmerLigature(){
        return new KhmerLigature();
    }

}
