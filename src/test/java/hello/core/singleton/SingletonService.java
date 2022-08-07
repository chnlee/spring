package hello.core.singleton;

public class SingletonService {

    // static 사용시 메모리가 jvm의 static 메모리에 올라간다. 즉, 해당하는 객체를 공유한다는 의미이다. 생성자를 만들 수 없음
    // final은 재할당할 수 없도록 만드는 것이다.
    private static final SingletonService instance = new SingletonService();

    // 오직 이 static 메서드를 통해서만 조회할 수 있다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private으로 선언하여 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
