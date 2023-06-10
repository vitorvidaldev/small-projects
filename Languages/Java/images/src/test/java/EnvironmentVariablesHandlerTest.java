import org.junit.jupiter.api.Test;

import dev.vitorvidal.handler.EnvironmentVariablesHandler;

import static org.junit.jupiter.api.Assertions.*;

class EnvironmentVariablesHandlerTest {
    @Test
    void testGetImagePath() {
        String imagePath = EnvironmentVariablesHandler.getImagePath();
        assertEquals("./src/main/resources/images", imagePath);
    }

    @Test
    void testGetVideoPath() {
        String videoPath = EnvironmentVariablesHandler.getVideoPath();
        assertEquals("./src/main/resources/videos", videoPath);
    }
}