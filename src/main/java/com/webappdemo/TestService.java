package com.webappdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestService {

    private final List<String> scenes = new ArrayList<>();
    private final AtomicInteger index = new AtomicInteger(0);

    public TestService() {
        scenes.add(sceneF22());
        scenes.add(sceneSu30());
        scenes.add(sceneDogfight());
    }

    // Har 10 second me scene rotate hoga
    @Scheduled(fixedRate = 10_000)
    public void rotateScene() {
        index.updateAndGet(i -> (i + 1) % scenes.size());
    }

    public String getCurrentScene() {
        return scenes.get(index.get());
    }

    // ---------- SCENES ----------

    private String sceneF22() {
        StringBuilder sb = new StringBuilder();
        sb.append("                     STEALTH F-22 RAPTOR\n");
        sb.append("                            /\\\n");
        sb.append("                           /  \\\n");
        sb.append("                          / /\\ \\\n");
        sb.append("                     ____/ /  \\ \\____\n");
        sb.append("                 ___/_____/====\\_____\\___\n");
        sb.append("            ____/        /====\\        \\____\n");
        sb.append("           /            /======\\            \\\n");
        sb.append("          /            /========\\            \\\n");
        sb.append("         |            /==========\\            |\n");
        sb.append("         |___________/============\\___________|\n");
        sb.append("              \\______\\==========/______/ \n");
        sb.append("                     O            O      (engines)\n");
        return sb.toString();
    }

    private String sceneSu30() {
        StringBuilder sb = new StringBuilder();
        sb.append("                        SUKHOI Su-30 (Dual Engine)\n");
        sb.append("                           _____\n");
        sb.append("                          / ___ \\\n");
        sb.append("                 ________/ /   \\ \\________\n");
        sb.append("           _____/        / /| |\\ \\        \\_____\n");
        sb.append("         _/            _/ /_| |_\\ \\_            \\_\n");
        sb.append("        /            _/  /  | |  \\  \\            \\\n");
        sb.append("       /            /   /   | |   \\   \\            \\\n");
        sb.append("      |            /   /    | |    \\   \\            |\n");
        sb.append("      |___________/___/_____|_|_____\\___\\___________|\n");
        sb.append("           \\____   O                 O   ____/      (twin engines)\n");
        sb.append("                \\____________________________/\n");
        return sb.toString();
    }

    private String sceneDogfight() {
        StringBuilder sb = new StringBuilder();
        sb.append("                            DOGFIGHT SCENE\n");
        sb.append("   F-22                         MISSILE                   Su-30\n");
        sb.append("     /\\                                                    /\\\n");
        sb.append("    /  \\      >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>        /  \\\n");
        sb.append("   /_/\\_\\----------------------------------------------/_/\\_\\\n");
        sb.append("                *   *   *  EXPLOSION  *   *   *\n");
        sb.append("\n");
        sb.append("                      CARRIER / GROUND BELOW\n");
        sb.append("        ______________________________________________________\n");
        sb.append("       /______________________________________________________\\\n");
        return sb.toString();
    }
    
}
