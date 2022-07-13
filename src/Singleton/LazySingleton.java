package Singleton;

public class LazySingleton {
    private static volatile LazySingleton instance = null; // 保证instance在所有线程中同步

    private LazySingleton() {  // 避免在外部实例化
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

