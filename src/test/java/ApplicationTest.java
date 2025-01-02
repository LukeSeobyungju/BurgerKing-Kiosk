import kiosk.Application;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ApplicationTest {

    Application application;
    static ByteArrayOutputStream outputMessage = new ByteArrayOutputStream();

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    public void setUp(){
        application=new Application();
        System.setOut(new PrintStream(outputMessage));
    }


    @Test
    void test1() {
        systemIn("6");
        assertThrows(IllegalArgumentException.class,()->{
            application.run();
        });
    }

    @Test
    void test2(){
        systemIn("5");
        application.run();
        assertTrue(outputMessage.toString().contains("종료합니다."));
    }

    @Test
    void test3(){
        systemIn("1 5 2 6 3 1 4 1");
        application.run();
        System.out.println(outputMessage);
        assertTrue(outputMessage.toString().contains("총 가격: 11900원"));
    }

    @Test
    void test4(){
        systemIn("1 5 2 6 4 2 2 2 3 1 1 1");
        application.run();
        assertTrue(outputMessage.toString().contains("- 감자튀김 2개"));
    }

    @Test
    void test5() {
        systemIn("3 3 4 2 1 55");
        assertThrows(IllegalArgumentException.class,()->{
            application.run();
        });
    }

    @AfterEach
    public void tearDown(){
        application=null;
        System.setOut(System.out);
    }
 }
