package MyGame;

public class Enemy {
    String name;
    int hp, attack;
    boolean isBoss;
    Enemy(String n, int h, int atk){
        name = n;
        hp = h;
        attack = atk;
    }
    int getHp(){
        return hp;
    }
    void ReduceHP(int r){
        hp -= r;
    }
    void RegularRecover(){
        hp += 1;
    }
    void Attack(Player player){
        player.ReduceHP(attack);
    }
}
