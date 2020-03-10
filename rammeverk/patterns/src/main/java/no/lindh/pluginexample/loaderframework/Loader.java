package no.lindh.pluginexample.loaderframework;

import java.io.ByteArrayInputStream;
import java.util.Map;

public interface Loader {
    void register(DataParser dp);
    Map<String, String> load(byte[] bytes);
}
