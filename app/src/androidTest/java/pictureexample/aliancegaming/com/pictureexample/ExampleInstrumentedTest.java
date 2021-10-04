package pictureexample.aliancegaming.com.pictureexample;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.aliancegaming.pictureexample.R;

import tools.fastlane.screengrab.Screengrab;
import tools.fastlane.screengrab.ScreenshotStrategy;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.aliancegaming.pictureexample", appContext.getPackageName());

        //1
        Screengrab.screenshot("rwmagic8ball_beforeFabClick");

        //2
        Screengrab.screenshot("rwmagic8ball_afterFabClick");
    }
}