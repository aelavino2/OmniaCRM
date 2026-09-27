package com.omniacrm.core.dev;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Dev only: opens Swagger UI in the browser once the app is ready. Enabled by bootRun.
 * Uses an OS command because Spring Boot runs headless, so java.awt.Desktop is unavailable.
 */
@Component
@ConditionalOnProperty(name = "omnia.dev.open-swagger-ui", havingValue = "true")
class SwaggerBrowserLauncher {

    private static final Logger log = LoggerFactory.getLogger(SwaggerBrowserLauncher.class);

    @EventListener
    void openSwaggerUi(ApplicationReadyEvent event) {
        String port = event.getApplicationContext().getEnvironment().getProperty("local.server.port");
        String url = "http://localhost:" + port + "/swagger-ui.html";
        try {
            new ProcessBuilder(browserCommand(url)).start();
            log.info("Opened Swagger UI in the browser: {}", url);
        } catch (IOException e) {
            log.warn("Could not open the browser, open it manually: {}", url, e);
        }
    }

    private static List<String> browserCommand(String url) {
        String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        if (os.contains("win")) {
            return List.of("rundll32", "url.dll,FileProtocolHandler", url);
        }
        if (os.contains("mac")) {
            return List.of("open", url);
        }
        return List.of("xdg-open", url);
    }
}
