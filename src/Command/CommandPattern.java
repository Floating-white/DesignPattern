package Command;

public class CommandPattern {
    public static void main(String[] args) {
        ConcreteCommand concreteCommand = new ConcreteCommand();
        concreteCommand.setReceiver(new Receiver());
        Invoker invoker = new Invoker();
        invoker.setCommand(concreteCommand);

        invoker.call();

    }
}

// 抽象命令
interface Command {
    public abstract void execute();
}


// 接收者
class Receiver {
    public void action() {
        System.out.println("接收者的action()方法被调用...");
    }
}

// 调用者
class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        System.out.println("调用者执行命令command...");
        command.execute();
    }
}


// 具体命令
class ConcreteCommand implements Command {
    private Receiver receiver;

    @Override
    public void execute() {
        receiver.action();
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
}

