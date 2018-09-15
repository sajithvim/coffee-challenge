# Solution

- This code contains the solution the Coffee Challenge.

# How to Setup / Run
- Make sure you jave installed Java 8 and the JAVA_HOME is correctly setup.
- Install maven i.e ```brew install maven```
- Run the following to build
    ```mvn clean install```
- You can run ```App.java``` as a java application to get more details.

# Code
- Code is written on a more modular way.
- There are different modules to take care of different concerns such as Billing, Tax, Promos etc.
- Each module has its own ```Builder``` which injects the relevant dependencies.
- The unit prices are configurable by editing the .json file.
- The following is a snippet as to how you can use the code through the service layer.

``` java
Order order = new Order();

Item espresso = new CoffeeItem("espresso");
espresso.setQuantity(1);

Item lCap = new CoffeeItem("cappuccino");
lCap.setItemSize("L");
lCap.setQuantity(1);

Item sFlatWhite = new CoffeeItem("flat_white");
sFlatWhite.setQuantity(1);
sFlatWhite.addAddOn("soy", 1);

Item cap = new CoffeeItem("cappuccino");
cap.setQuantity(1);

order.add(espresso);
order.add(lCap);
order.add(sFlatWhite);
order.add(cap);

service.processOrder(order, null);
System.out.println("***********************************");
System.out.println("Total : " + order.getTotal());
System.out.println("GST : " + (Math.round(order.getGst() * 100.0)) / 100.0);

```

# Furthe improvements
- I have not used BigDecimals which could potentially enhance the system trust.
- I can cover few deep level tests, but the solution works perfectly well.