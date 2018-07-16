package chapter9.recipe1;

import java.awt.*;
/**
 * Chapter: Miscellaneous
 * Recipe:
 */

public class JavaApp {
    public static void main(String... args) {
        Color defaultColor = ColoredText.defaultColor;

        String rawText =
                " one Of The Best Programming Skills You Can Have " +
                "Is Knowing When To Walk Away For Awhile. ";
        String text = ColoredText.processText(rawText);
        ColoredText myText = new ColoredText(text);
        myText.printToConsole();
    }
}
