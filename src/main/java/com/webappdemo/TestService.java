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

    // Har second badhne wala counter
    // private final AtomicInteger tick = new AtomicInteger(0);

    // // Track width (andar ka length jaha bullet chalegi)
    // private static final int TRACK_LENGTH = 40;

    // Har 1 second me tick ++
    @Scheduled(fixedRate = 1000)
    public void advance() {
        tick.updateAndGet(t -> (t + 1) % TRACK_LENGTH);
    }

    public String getCurrentFrame() {
        int pos = tick.get();

        StringBuilder sb = new StringBuilder();

        // --- Jet ascii upar ---
        sb.append("                  STEALTH F-22 RAPTOR FIRING\n");
        sb.append("                          /\\\n");
        sb.append("                         /  \\\n");
        sb.append("                        /____\\\n");
        sb.append("                   ____/______\\____\n");
        sb.append("                 _/                \\_\n");
        sb.append("                /____________________\\\n");
        sb.append("\n");

        // --- Bullet track / goli line ---
        sb.append("              BULLET TRACK (har second goli aage badhegi)\n");

        sb.append("              |");  // left border

        for (int i = 0; i < TRACK_LENGTH; i++) {
            if (i == pos) {
                sb.append("-->"); // yahi goli hai
                i += 2;          // 3 chars use kar liye ( '-', '-', '>' )
            } else {
                sb.append(" ");
            }
        }

        sb.append("|"); // right border
        sb.append("\n");

        sb.append("\n");
        sb.append("              Refresh page har 1-2 second me aur dekh goli aage ja rahi hai.\n");

        return sb.toString();
    }

    private final AtomicInteger tick = new AtomicInteger(0);

    // beech ka track jahan goli chalegi (odd rakha hai taaki center index ho)
    private static final int TRACK_LENGTH = 41;  // index 0..40, center = 20

    // har 1 second me time badhega
    @Scheduled(fixedRate = 1000)
    public void step() {
        tick.incrementAndGet();
    }

    public String getCurrentFrame1() {
        int t = tick.get();

        int half = TRACK_LENGTH / 2;     // 20
        int phase = t % (half + 1);      // 0..20

        int leftPos = phase;             // left goli -> right
        int rightPos = TRACK_LENGTH - 1 - phase;   // right goli -> left

        StringBuilder sb = new StringBuilder();

        // ================= JETS TOP VIEW =================
        sb.append("                    AAMNE-SAAMNE FIGHTER JETS DOGFIGHT\n");
        sb.append("\n");
        sb.append("      LEFT: F-22 RAPTOR                        RIGHT: Su-30\n");
        sb.append("             /\\                                         /\\\n");
        sb.append("            /  \\\\                                     /  \\\n");
        sb.append("           /____\\\\                                   /____\\\n");
        sb.append("          /|    |\\\\                                 //|    |\\\n");
        sb.append("         /_|____|_\\\\_______________________________//_|____|_\\\n");
        sb.append("\n");

        // ================= BULLET TRACK =================
        sb.append("                    BULLET TRACK (har second goli aage)\n");
        sb.append("                    |");

        for (int i = 0; i < TRACK_LENGTH; i++) {
            if (i == leftPos && i == rightPos) {
                sb.append("X");          // dono goli takraye -> explosion
            } else if (i == leftPos) {
                sb.append(">");          // left jet ki goli
            } else if (i == rightPos) {
                sb.append("<");          // right jet ki goli
            } else {
                sb.append(" ");
            }
        }

        sb.append("|\n\n");

        sb.append("   Legend: '>' = F-22 bullet, '<' = Su-30 bullet, 'X' = explosion center\n");
        sb.append("   Har 1 second me page refresh karo, goli aage badhti dikhegi.\n");

        return sb.toString();
    }
    
}
