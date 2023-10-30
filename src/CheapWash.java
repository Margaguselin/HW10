public class CheapWash implements WashStrategy{
    public static final double WASH_PRICE = 10;
    public static final double WASH_AND_DRY_PRICE = 13;

    public static final double CLEAN_FACTOR = 40;

    @Override
    public void wash(Car car, CarOwner carOwner) {
        car.setDirtiness(car.getDirtiness() - CLEAN_FACTOR);
        carOwner.setBalance(carOwner.getBalance() - WASH_PRICE);
        if (car.getDirtiness() < 0){
            car.setDirtiness(0.0);
        }

    }

    @Override
    public void washAndDry(Car car, CarOwner carOwner) {
car.setDirtiness(car.getDirtiness() - CLEAN_FACTOR);
        carOwner.setBalance(carOwner.getBalance() - WASH_AND_DRY_PRICE);
        if (car.getDirtiness() < 0) {
            car.setDirtiness(0.0);
        }
    }
    public static double getWashPrice(){
        return WASH_PRICE;
    }
    public static double getWashAndDryPrice(){
        return WASH_AND_DRY_PRICE;
    }
    public static double getCleanFactor(){
        return CLEAN_FACTOR;
    }
}
