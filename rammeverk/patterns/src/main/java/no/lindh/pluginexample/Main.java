package no.lindh.pluginexample;

import no.lindh.pluginexample.loaderframework.DataParser;
import no.lindh.pluginexample.loaderframework.Loader;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DataParser parserFramework = new DataParser();
        parserFramework.registerLoader(new PDFLoader());
        parserFramework.registerLoader(new ExcelLoader());
        parserFramework.load("test.pdf");
        parserFramework.load("excel.xlsx");
    }
}

class PDFLoader implements Loader {
    public void register(DataParser dp) {
        dp.registerLoaderForFileExtension("pdf", this);
        dp.registerLoaderForFileExtension("pdfv2", this);
    }

    public Map<String, String> load(byte[] bytes) {
        System.out.println("Data is being loaded by PDFLoader");
        Map<String, String> data = new HashMap<>();
        data.put("test", "OK");
        return data;
    }
}

class ExcelLoader implements Loader {
    public void register(DataParser dp) {
        dp.registerLoaderForFileExtension("xlsx", this);
    }

    public Map<String, String> load(byte[] bytes) {
        System.out.println("Data is being loaded by ExcelLoader");
        Map<String, String> data = new HashMap<>();
        data.put("test", "OK");
        return data;
    }
}
