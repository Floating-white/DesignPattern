package Command.apply;


public class CookingCommand {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        Breakfast food1 = new ChangFen();
        Breakfast food2 = new HunDun();
        Breakfast food3 = new HeFen();

        waiter.setChangFen(food1);
        waiter.setHunDun(food2);
        waiter.setHeFen(food3);

        waiter.chooseChangFen();
        waiter.chooseHunDun();
        waiter.chooseHeFen();

    }
}

// 调用者
class Waiter {
    private Breakfast changFen, hunDun, heFen;

    public void setChangFen(Breakfast changFen) {
        this.changFen = changFen;
    }

    public void setHunDun(Breakfast hunDun) {
        this.hunDun = hunDun;
    }

    public void setHeFen(Breakfast heFen) {
        this.heFen = heFen;
    }

    public void chooseChangFen() {
        changFen.cooking();
    }
    public void chooseHunDun() {
        hunDun.cooking();
    }
    public void chooseHeFen() {
        heFen.cooking();
    }
}


// 接收者1
class ChangFenChef {
    public void cooking() {
        System.out.println("做肠粉..");
    }
}

// 接收者2
class HunDunChef {
    public void cooking() {
        System.out.println("做混沌..");
    }
}

// 接收者3
class HeFenChef {
    public void cooking() {
        System.out.println("做河粉..");
    }
}


// 抽象命令
interface Breakfast {
    public abstract void cooking();
}

// 具体命令 1
class ChangFen implements Breakfast {
    private ChangFenChef receiver;

    public ChangFen() {
        this.receiver = new ChangFenChef();
    }

    public void cooking() {
        receiver.cooking();
    }
}

// 具体命令 2
class HunDun implements Breakfast {
    private HunDunChef receiver;

    public HunDun() {
        this.receiver = new HunDunChef();
    }

    public void cooking() {
        receiver.cooking();
    }
}

// 具体命令 3
class HeFen implements Breakfast {
    private HeFenChef receiver;

    public HeFen() {
        this.receiver = new HeFenChef();
    }

    public void cooking() {
        receiver.cooking();
    }
}
