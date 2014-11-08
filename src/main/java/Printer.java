import com.thoughtworks.iamcoach.pos.dao.*;
import com.thoughtworks.iamcoach.pos.model.*;
import com.thoughtworks.iamcoach.pos.service.CartService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Printer {
    private CartService cartService = null;
    private  ArrayList<CartItem> cartItems = null;
    private CategoryDao categoryImpl;

    public Printer(CartService cartService, CategoryImpl categoryImpl){
        this.cartService = cartService;
        this.cartItems = cartService.getCartInfo();
        this.categoryImpl = categoryImpl;
    }

    public String printList() {
        return printShopName() + "\n"
                + printDate() + "\n"
                + printAllCartItems() + "\n"
                + printTotal();
    }

    private String printShopName() {
        return "        ********Let's Go 购物清单*********" + "\n"
                + "----------------------------------------------------------";
    }

    private String printDate(){
        Date dateAndTime = new Date();

        java.text.DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String date = format1.format(dateAndTime);
        String time = String.format("%tr", dateAndTime);

        return "          " + date + "    " + time;
    }

    private String printAllCartItems(){
        String allCartItems = "************************************************" + "\n";

        ArrayList<Category> categories = categoryImpl.getCategories();

        for(int i=0; i<categories.size(); i++){
            int id = Integer.parseInt(categories.get(i).getId());

            if(divideCartItems(id).size() != 0){
                allCartItems += printCategory(divideCartItems(id));
            }
        }
        allCartItems +="************************************************";
        return allCartItems;
    }

    private String printCategory(ArrayList<CartItem> cartItems){
        String categoryText = "";

        categoryText += categoryImpl.getCategoryById(cartItems.get(0).getItem().getCategoryId()).getName() + "\n";

        for (CartItem cartItem : cartItems) {
            categoryText += "名称：" + cartItem.getItem().getName() + "   数量：" + cartItem.getNum()
                    + "   单价：" + cartItem.getItem().getPrice() + "元" + "   单位：" + cartItem.getItem().getUnit()
                    + "   小计：" + cartItem.getSubtotal() + "元" +"\n";

        }
        return categoryText + "\n";
    }

    private String printTotal(){

        return  "优惠前：" + cartService.getTotalSum() + "元"
                + "   优惠金额：" + (cartService.getTotalSum() - cartService.getActualSum()) + "元"
                + "   总计：" + cartService.getActualSum()+ "元" + "\n"
                + "----------------------------------------------------------";
    }


    private ArrayList<CartItem> divideCartItems(int categoryId) {
        ArrayList<CartItem> dividedCartItems = new ArrayList<CartItem>();

        for(int j=0; j<cartItems.size(); j++){
            if(cartItems.get(j).getItem().getCategoryId() == categoryId){
                dividedCartItems.add(cartItems.get(j));
            }
        }
        return dividedCartItems;
    }
}
