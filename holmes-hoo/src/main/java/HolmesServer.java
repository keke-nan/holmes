import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description
 * @Author keke
 * @Date 2020/7/19  11:28
 */
@SpringBootApplication(scanBasePackages = "com.holmes.hoo")
@MapperScan("com.holmes.hoo.mapper")
public class HolmesServer {

    public static void main(String[] args) {
        SpringApplication.run(HolmesServer.class, args);
    }
}
