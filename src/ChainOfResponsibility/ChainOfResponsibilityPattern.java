package ChainOfResponsibility;

public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        handlerA.setNext(handlerB);
        handlerA.handleRequest("AB");
    }
}

// 抽象处理者
abstract class Handler {
    private Handler next;

    public abstract void handleRequest(String request);

    public void transfer(String request) {
        if (getNext() != null) {
            getNext().handleRequest(request);
        } else {
            System.out.println("责任链已结束");
        }
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }
}

// 具体处理类A
class ConcreteHandlerA extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.contains("A")) {
            System.out.println("具体处理者A处理该请求");
        }
        transfer(request);
    }
}

// 具体处理类B
class ConcreteHandlerB extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.contains("B")) {
            System.out.println("具体处理者B处理该请求");
        }
        transfer(request);
    }
}
