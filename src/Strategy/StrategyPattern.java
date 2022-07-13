package Strategy;

public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context();
        StrategyA A = new StrategyA();
        StrategyB B = new StrategyB();

        context.setStrategy(A);
        context.strategyMethod();
        context.setStrategy(B);
        context.strategyMethod();
    }
}


// 抽象策略类
interface Strategy {
    public void strategyMethod(); // 策略方法
}

// 具体策略类A
class StrategyA implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("具体策略类A的策略方法执行。");
    }
}

// 具体策略类B
class StrategyB implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("具体策略类B的策略方法执行。");
    }
}

// 环境类：策略方法的调用者
class Context {
    private Strategy strategy;

    public void strategyMethod() {
        strategy.strategyMethod();
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
