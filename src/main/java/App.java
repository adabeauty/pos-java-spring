import com.thoughtworks.iamcoach.pos.dao.ItemDao;
import com.thoughtworks.iamcoach.pos.dao.ItemImple;
import com.thoughtworks.iamcoach.pos.service.*;

public class App {

    public static void main(String[] args) {

        ItemDao itemImpl = new ItemImple();
        Scanner scanner = new Scanner();
        CartService cartService = new CartService(scanner, itemImpl);

        Printer printer = new Printer(cartService);
        System.out.println(printer.printList());
    }
}
