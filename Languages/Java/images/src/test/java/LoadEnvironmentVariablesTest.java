import org.junit.jupiter.api.Test;

import dev.vitorvidal.LoadEnvironmentVariables;

import static org.junit.jupiter.api.Assertions.*;

class LoadEnvironmentVariablesTest {
    @Test
    void testGetImagePath() {
        String imagePath = LoadEnvironmentVariables.getImagePath();
        assertEquals("./src/main/resources/images", imagePath);
    }
}