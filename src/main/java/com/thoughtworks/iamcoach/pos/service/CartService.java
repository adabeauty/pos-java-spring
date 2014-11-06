package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.*;
import com.thoughtworks.iamcoach.pos.model.*;

import java.util.*;

public class CartService implements CartServiceInter {
    private ItemDao itemImple;
    private ArrayList<String> inputs;

    public CartService(Scanner scanner, ItemDao itemImple){
        this.inputs = scanner.getInputs();
        this.itemImple = itemImple;
    }

    public ArrayList<CartItem> getCartInfo() {

        ArrayList<CartItem> cartItems = new ArrayList<CartItem>();

        ArrayList<Item> items = itemImple.getItems();
        ArrayList<Promotion> promotionArrayList = null;

        double[] numbers = getNumbers(inputs, items);

        for(int i=0; i<numbers.length; i++){
            if(numbers[i] != 0){
                promotionArrayList =  itemImple.getPromotions(Integer.parseInt(items.get(i).getId()));
                cartItems.add(new CartItem(items.get(i), numbers[i], promotionArrayList));
            }
        }
        return cartItems;
    }

    public double getTotalSum() {
        ArrayList<CartItem> cartItems = this.getCartInfo();

        double total = 0;
        for(int i=0; i<cartItems.size(); i++){
            double actualSubTotal = cartItems.get(i).getNum() * cartItems.get(i).getItem().getPrice();
            total += actualSubTotal;
        }

        return total;
    }

    public double getActualSum() {
        ArrayList<CartItem> cartItems = this.getCartInfo();

        double actutalTotal = 0;
        for(int i=0; i<cartItems.size(); i++){
            actutalTotal += cartItems.get(i).getSubtotal();
        }
        return actutalTotal;
    }
    
    private double[] getNumbers(ArrayList<String> inputs, ArrayList<Item> items) {
        double numbers[] = new double[items.size()];

        for(int i=0; i<items.size(); i++){
            for(int j=0; j<inputs.size(); j++){
                boolean canSplit = inputs.get(j).contains("-");
                if(canSplit){
                    numbers[i] +=  processSplitedBarcode(i, j, inputs, items);
                }else{
                    numbers[i] += processBarcode(i, j, inputs, items);
                }
            }
        }
        return numbers;
    }

    private double processSplitedBarcode(int i, int j, ArrayList<String> inputs, ArrayList<Item> items){
        double number = 0;

        String[] barcodeAndNumber = inputs.get(j).split("-");
        if(items.get(i).getBarcode().equals(barcodeAndNumber[0])){
            number = Double.parseDouble(barcodeAndNumber[1]);
        }
        return number;
    }

    private double processBarcode(int i, int j, ArrayList<String> inputs, ArrayList<Item> items){
        if(items.get(i).getBarcode().equals(inputs.get(j))){
            return 1.0;
        }
        return 0.0;
    }

}
