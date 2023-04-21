/* 
 * Дан массив записей: наименование товара, цена, сорт. 
 * Найти наибольшую цену товаров 1го или 2го сорта среди товаров, 
 * название которых содержит «высший».
 * =================================================
 * у меня проблемы c кириллическими шрифтами поэтому слово "высший" заменено на "higher"  
 */

package seminar03.task01;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Product> products = getProducts();
        Product desired = findProduct(products, "higher", 2);
        System.out.println(desired);
    }

    /**
     * Ищет товар в коллекции по имени, с лимитом по сорту, 
     * @param products
     * @param filterName
     * @param limitGrade
     * @return
     */
    private static Product findProduct(List<Product> products, String filterName, int limitGrade) {
        double highPrice = 0;
        Product desired = products.get(0);
        for (Product product : products) {
            if (product.name.contains(filterName) && product.grade <= limitGrade && highPrice < product.price) {
                highPrice = product.price;
                desired = product;
            }
        }
        return desired;
    }

    /**
     * @return list of products
     */
    private static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("lower product", 40, 1));
        products.add(new Product("lower product", 60, 2));
        products.add(new Product("medium product", 100, 3));
        products.add(new Product("higher product", 200, 2));
        products.add(new Product("higher product", 210, 3));
        products.add(new Product("product higher", 220, 4));
        products.add(new Product("lower product", 50, 1));
        products.add(new Product("medium product", 310, 2));
        products.add(new Product("product higher product", 230, 1));
        products.add(new Product("higher product", 340, 2));
        products.add(new Product("medium product", 120, 1));
        products.add(new Product("higher product", 250, 2));
        products.add(new Product("lower product", 70, 1));
        return products;
    }
}

/*
 * OUTPUT============================
 * higher product (grade: 2): 340.00$
 */