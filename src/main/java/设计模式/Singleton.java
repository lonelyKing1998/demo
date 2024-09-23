package 设计模式;

public class Singleton {
    
    private volatile static Singleton singleton ; 

    /**
     * 单例设计模式
     */
    private Singleton(){
    }

    public  static final Singleton getSingleton(){
        if(singleton == null ){
            synchronized(Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
