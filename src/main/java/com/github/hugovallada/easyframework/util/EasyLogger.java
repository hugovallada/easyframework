package com.github.hugovallada.easyframework.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EasyLogger {

    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String WHITE = "\u001B[37m";
    public static final String RESET = "\u001B[0m";

    public static DateTimeFormatter EASYDATE = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void showBanner() {
        System.out.println(
                YELLOW + """
                        ___   ____  _____ __ __      _____  ____    ____  ___ ___    ___ __    __   ___   ____   __  _
                          /  _] /    |/ ___/|  |  |    |     ||    \\  /    ||   |   |  /  _]  |__|  | /   \\ |    \\ |  |/ ]
                         /  [_ |  o  (   \\_ |  |  |    |   __||  D  )|  o  || _   _ | /  [_|  |  |  ||     ||  D  )|  ' /
                        |    _]|     |\\__  ||  ~  |    |  |_  |    / |     ||  \\_/  ||    _]  |  |  ||  O  ||    / |    \\
                        |   [_ |  _  |/  \\ ||___, |    |   _] |    \\ |  _  ||   |   ||   [_|  `  '  ||     ||    \\ |     \\
                        |     ||  |  |\\    ||     |    |  |   |  .  \\|  |  ||   |   ||     |\\      / |     ||  .  \\|  .  |
                        |_____||__|__| \\___||____/     |__|   |__|\\_||__|__||___|___||_____| \\_/\\_/   \\___/ |__|\\_||__|\\_|
                        """);

    }

    public static void log(String modulo, String mensagem) {
        String date = LocalDateTime.now().format(EASYDATE);
        System.out.printf(GREEN + "%15s " + YELLOW + "%-30s:" + WHITE + "%s\n" + RESET, date, modulo, mensagem);
    }
}
