package database;

import java.util.ArrayList;
import java.util.List;

class datasLayer {
    public static datasLayer instance;
    private List<product> _products;
    private List<order> _orders;
    private List<orderLineItem> _orderLineItems;
    private List<inventory> _inventories;

    public static datasLayer getInstance() {
        if (instance == null) {
            instance = new datasLayer();
        }
        return instance;
    }

    private datasLayer() {
        this._products = new ArrayList<>();
        this._orders = new ArrayList<>();
        this._orderLineItems = new ArrayList<>();
        this._inventories = new ArrayList<>();
    }

    public void addProduct(product product) {
        this._products.add(product);
    }

    public void addOrder(order order) {
        this._orders.add(order);
    }

    public void addOrderLineItem(orderLineItem orderLineItem) {
        this._orderLineItems.add(orderLineItem);
    }

    public void addInventory(inventory inventory) {
        this._inventories.add(inventory);
    }

    
}