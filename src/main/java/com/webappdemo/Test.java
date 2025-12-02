package com.webappdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Test {
    @Autowired
    TestService testService;
    @GetMapping("/pattern")
    public String getUltraPattern() {

        StringBuilder sb = new StringBuilder();
        int n = 10; // diamond height control

        // Upper part
        for (int i = 1; i <= n; i++) {

            // Leading spaces
            for (int j = 1; j <= n - i; j++) {
                sb.append("&nbsp;");
            }

            // Left hashes
            for (int j = 1; j <= i; j++) {
                sb.append("#");
            }

            sb.append("&nbsp;&nbsp;"); // gap between left hash & stars

            // Stars
            for (int j = 1; j <= i * 2 - 1; j++) {
                sb.append("*");
            }

            sb.append("&nbsp;&nbsp;"); // gap between stars & right hash

            // Right hashes
            for (int j = 1; j <= i; j++) {
                sb.append("#");
            }

            sb.append("<br>");
        }

        // Lower part
        for (int i = n - 1; i >= 1; i--) {

            for (int j = 1; j <= n - i; j++) {
                sb.append("&nbsp;");
            }

            for (int j = 1; j <= i; j++) {
                sb.append("#");
            }

            sb.append("&nbsp;&nbsp;");

            for (int j = 1; j <= i * 2 - 1; j++) {
                sb.append("*");
            }

            sb.append("&nbsp;&nbsp;");

            for (int j = 1; j <= i; j++) {
                sb.append("#");
            }

            sb.append("<br>");
        }

        return sb.toString();
    }
    @GetMapping("/ak47")
    public String getHeavyAk47() {

        StringBuilder sb = new StringBuilder();

        sb.append("                                _____________________________________________\n");
        sb.append("                        ________/=============================================-\\\n");
        sb.append("              _________/   ____   ____   ____   ____   ____   ____   __________\\\n");
        sb.append("             |   _____   |____| |____| |____| |____| |____| |____| |___________|\n");
        sb.append("             |__|_____|_________________________________________________________]\n");
        sb.append("                       /   /          ____      ___       ____\n");
        sb.append("                      /   /          / __ \\\\    /   \\\\     / ___\\\\\n");
        sb.append("             ________/   /          | |  | |  |  ^  |   | |___|\n");
        sb.append("            |   ________/            \\\\ \\\\_/ /  |  | | |   \\\\___  \\\\\n");
        sb.append("            |__|                     \\\\___/    |__|_|_|    ____| |\n");
        sb.append("                                                \\\\_____\\\\  |______/\n");

        return "<pre>" + sb.toString() + "</pre>";
    }
    @GetMapping("/tank")
    public String getHeavyTank() {

        StringBuilder sb = new StringBuilder();

        sb.append("                                   ________________________________\n");
        sb.append("                             _____/                                \\______\n");
        sb.append("                       _____/      _____________   _____________          \\_____\n");
        sb.append("              ________/       ____/             \\_/             \\____          \\\n");
        sb.append("             |  ________    _/   ___   ____   _____   ____   ___   \\_   ________|\n");
        sb.append("             | |        \\__/   _/   \\_/    \\_/     \\_/    \\_/   \\_   \\_/        |\n");
        sb.append("             | |_________/   _/   _________   _________   _______   \\__________|\n");
        sb.append("             |______________/   _/  /       \\ /       \\ /       \\_   \\____________\n");
        sb.append("                 |   |        _/  _/         |         |         \\_   \\      |   |\n");
        sb.append("                 |   |_______/  _/           |         |           \\_  \\_____|   |\n");
        sb.append("                 |______________/            |_________|            \\____________|\n");
        sb.append("                /   /                _____        _____       _______   \\   \\ \n");
        sb.append("               /___/                /     \\______/     \\_____/       \\___\\___\\\n");
        sb.append("            __/   /__________      |   O   O   O   O   O   O   O   O   \\__________\\__\n");
        sb.append("           |________________|=======\\_____________________________________|________________|\n");

        return "<pre>" + sb.toString() + "</pre>";
    }
    @GetMapping("/epic-jet-scene")
    public String getEpicJetScene() {

        StringBuilder sb = new StringBuilder();

        sb.append("                                                    /\\       \n");
        sb.append("                                   ________________/  \\___   \n");
        sb.append("                       ___________/__==______==___/      \\______________       \n");
        sb.append("                    __/                                         .-^^-.   \\__    \n");
        sb.append("                  _/                                          .-/_____ \\-.  \\_  \n");
        sb.append("                _/             STEALTH F-22 RAPTOR          .- /_/ |_|\\_\\ \\ -. \\ \n");
        sb.append("               /                                            \\  \\__/_|_\\__/ /  / /\n");
        sb.append("      ________/___________      _________            ______  '-----------'  / / \n");
        sb.append("     /                    \\____/        \\___________/      \\______________/ /  \n");
        sb.append("    /  ESCORT Su-30s           \\                         /                 /   \n");
        sb.append("   /____________________________\\_______________________/_________________/    \n");
        sb.append("           \\                         \\         |        /                      \n");
        sb.append("            \\                         \\        |       /                       \n");
        sb.append("             \\_________________________\\       |      /__________________      \n");
        sb.append("                 |   |           |     /      / \\    |   |        |   |       \n");
        sb.append("                 |   |           |    /      /   \\   |   |        |   |       \n");
        sb.append("                 |___|___________|___/______/_____\\__|___|________|___|       \n");
        sb.append("                   /_/           \\_\\            /_/        \\_\\               \n");
        sb.append("          . . .  missiles >>>>>>>   *      *       *      *        *   . . .   \n");
        sb.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        sb.append("             CARRIER DECK                    OCEAN SURFACE / WAVES             \n");

        return "<pre>" + sb.toString() + "</pre>";
    }

    @GetMapping(value = "/jet-scene", produces = MediaType.TEXT_HTML_VALUE)
    public String getScene() {
        String ascii = testService.getCurrentScene();
        return "<pre>" + ascii + "</pre>";
    }
}
