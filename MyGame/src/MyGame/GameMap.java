package MyGame;

import java.util.Scanner;

public class GameMap {
    int MonsterCount = 0;
    int size;
    Tile[][] grid;
    int playerX = 0, playerY = 0;
    public GameMap(int size) {
        this.size = size;
        grid = new Tile[size][size];
        initMap();
    }
    void initMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double rand = Math.random();
                if (rand < 0.1) {
                    grid[i][j] = new Tile("town");
                } else if (rand < 0.3) {
                    grid[i][j] = new Tile("monster");
                    MonsterCount += 1;
                } else {
                    grid[i][j] = new Tile("empty");
                }
            }
        }
        grid[0][0].type = "start";
    }

    void printMap() {
        //每次有动作后更新map
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == playerX && j == playerY) {
                    System.out.print("P "); // 玩家
                }
                else {
                    switch (grid[i][j].type) {
                        case "town": System.out.print("T "); break;
                        case "monster": System.out.print("M "); break;
                        default: System.out.print(". "); break;
                    }
                }
            }
            System.out.println();
        }
    }
    void movePlayer(Player p, char move){
        int NewX = playerX;
        int NewY = playerY;
        switch (move){
            case 'w': NewX --; break;
            case 'a': NewY --; break;
            case 's': NewX ++; break;
            case 'd': NewY ++; break;
        }
        if (NewX < 0 || NewX >= size || NewY < 0 || NewY >= size) {
            System.out.println("=== Invalid Move: Out Of The Boundary ===");
            System.out.println("=== Please Try Again ===");
            return; // 防止继续往下执行
        }

        else{
            playerX = NewX;
            playerY = NewY;
            Tile current = grid[playerX][playerY];
            switch (current.type){
                case "monster":
                    Enemy m;
                    double r = Math.random();
                    if(r < 0.3){
                        m = new Enemy("Slime", 20, 3);
                    } else if (r < 0.6) {
                        m = new Enemy("Assassin", 3, 8);
                    }
                    else{
                        m = new Enemy("Goblin", 10, 5);
                    }
                    EventSystem.battle(p,m);
                    MonsterCount -- ;
                    current.type = "empty";
                    break;
                case "town":
                    System.out.println("===Welcome To Town===");

                    Scanner sc = new Scanner(System.in);
                    while(true){
                        System.out.println("+--------------------------------------------------+\n" +
                                "|                                                  |\n" +
                                "|        \uD83C\uDF3C  WELCOME TO TOWN, TRAVELER! \uD83C\uDF3C          |\n" +
                                "|                                                  |\n" +
                                "|      This cozy little place awaits you...        |\n" +
                                "|                                                  |\n" +
                                "|     Press 1  ➤  Visit the \uD83D\uDECD\uFE0F  Shop               |\n" +
                                "|     Press 2  ➤  Visit the \uD83D\uDEE0\uFE0F  Iron Smith          |\n" +
                                "|     Press -1 ➤  Leave the Town \uD83C\uDF19                |\n" +
                                "|                                                  |\n" +
                                "|         May your journey be warm and bright!     |\n" +
                                "+--------------------------------------------------+\n");
                        if (sc.hasNextInt()) {
                            int press = sc.nextInt();
                            if (press == -1) {
                                break;
                            } else if (press == 1) {
                                Shop s = new Shop();
                                s.enterShop(p);
                            } else if (press == 2) {
                                Smith smi = new Smith();
                                smi.enterSmith(p);
                            }
                        }else {
                            System.out.println("⚠️ 请输入合法的编号！");
                            sc.next(); // 把错误的输入清除
                        }
                    }
            }
            }
        }
    }
