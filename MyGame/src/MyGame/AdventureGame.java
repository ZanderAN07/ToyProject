package MyGame;

import java.util.Scanner;

public class AdventureGame {

    public static void startGame(int s) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        GameMap map = new GameMap(s);
        while (player.hp > 0 && map.MonsterCount > 0) {
            map.printMap();
            System.out.println("WASD to move:");
            char move = scanner.nextLine().toLowerCase().charAt(0);
            map.movePlayer(player, move);
        }

        if (player.hp <= 0) {
            System.out.println("  ▄▀  ██   █▀▄▀█ ▄███▄       ████▄     ▄   ▄███▄   █▄▄▄▄ \n" +
                    "▄▀    █ █  █ █ █ █▀   ▀      █   █      █  █▀   ▀  █  ▄▀ \n" +
                    "█ ▀▄  █▄▄█ █ ▄ █ ██▄▄        █   █ █     █ ██▄▄    █▀▀▌  \n" +
                    "█   █ █  █ █   █ █▄   ▄▀     ▀████  █    █ █▄   ▄▀ █  █  \n" +
                    " ███     █    █  ▀███▀               █  █  ▀███▀     █   \n" +
                    "        █    ▀                        █▐            ▀    \n" +
                    "       ▀                              ▐                  \n);");
        } else {
            System.out.println("🎉 All monsters defeated! You win!");
        }
    }

    public static void main(String[] args) {
        System.out.println("   ▄██████▄     ▄████████   ▄▄▄▄███▄▄▄▄      ▄████████         ▄████████     ███        ▄████████    ▄████████     ███     \n" +
                "  ███    ███   ███    ███ ▄██▀▀▀███▀▀▀██▄   ███    ███        ███    ███ ▀█████████▄   ███    ███   ███    ███ ▀█████████▄ \n" +
                "  ███    █▀    ███    ███ ███   ███   ███   ███    █▀         ███    █▀     ▀███▀▀██   ███    ███   ███    ███    ▀███▀▀██ \n" +
                " ▄███          ███    ███ ███   ███   ███  ▄███▄▄▄            ███            ███   ▀   ███    ███  ▄███▄▄▄▄██▀     ███   ▀ \n" +
                "▀▀███ ████▄  ▀███████████ ███   ███   ███ ▀▀███▀▀▀          ▀███████████     ███     ▀███████████ ▀▀███▀▀▀▀▀       ███     \n" +
                "  ███    ███   ███    ███ ███   ███   ███   ███    █▄                ███     ███       ███    ███ ▀███████████     ███     \n" +
                "  ███    ███   ███    ███ ███   ███   ███   ███    ███         ▄█    ███     ███       ███    ███   ███    ███     ███     \n" +
                "  ████████▀    ███    █▀   ▀█   ███   █▀    ██████████       ▄████████▀     ▄████▀     ███    █▀    ███    ███    ▄████▀   \n" +
                "                                                                                                    ███    ███             ");
        System.out.println("=== Please Enter The Map Size ===");
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (sc.hasNextInt()) {
                int size = sc.nextInt();
                System.out.println("");
                startGame(size);
            } else {
                System.out.println("⚠️ Invalid Input");
                sc.next(); // 把错误的输入清除
            }
        }
    }
}
