/**
 * Joseph Pallechio
 * Launcher.java
 * Launches UI applicatoin
 */
package launcher;

import gui.PartsDatabaseUI;
import javafx.application.Application;

/**
 * @author Joseph Pallechio
 * @version 1.0
 *
 */
public class Launcher
{
    /**
     * starts application
     * @param args system arguments
     */
    public static void main(String[] args)
    {
        Application.launch(PartsDatabaseUI.class, args);
    }
}
