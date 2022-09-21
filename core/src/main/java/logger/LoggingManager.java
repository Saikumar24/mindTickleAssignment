package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingManager {
    public LoggingManager() {
        /**
         * Constructor call
         */
    }

    public static final Logger logger = LogManager.getLogger();
}
