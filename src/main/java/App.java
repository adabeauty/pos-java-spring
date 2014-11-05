import com.thoughtworks.iamcoach.pos.dao.ItemDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");


        ItemDao itemDaoImpl  = (ItemDao)applicationContext.getBean("itemImpl");
        System.out.println(itemDaoImpl.getPromotions(1));

    }
}
