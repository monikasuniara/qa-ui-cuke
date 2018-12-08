package au.com.cuke.ui.core;


import au.com.cuke.ui.core.ui.SharedDriver;
import cucumber.runtime.java.picocontainer.PicoFactory;

public class PicoDependencyInjector extends PicoFactory {

    public PicoDependencyInjector() {
        addClass(SharedDriver.class);
    }
}
