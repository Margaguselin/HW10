import exception.BlackListedException;
import exception.NegativeBalanceException;

import java.util.ArrayList;
import java.util.List;

public class CarWashService {


    private WashStrategy washStrategy;
    private int totalWash;
    private double moneyEarned;

    private List<String> blackList = new ArrayList<>();

    public WashStrategy getWashStrategy() {
        return washStrategy;
    }

    public void setWashStrategy(WashStrategy washStrategy) {
        this.washStrategy = washStrategy;
    }

    public int getTotalWash() {
        return totalWash;
    }

    public void setTotalWash(int totalWash) {
        this.totalWash = totalWash;
    }

    public double getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public List<String> getBlackList() {
        return blackList;
    }

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }

    public boolean wash(Car car, CarOwner carOwner) throws BlackListedException,NegativeBalanceException {

        if(washStrategy == null){
            return false;
        }
        if (isClientBlackListed(carOwner.getName())) {
            throw new BlackListedException("Car owner in black list");
        }
        if (washStrategy instanceof RegularWash) {
            if (RegularWash.WASH_PRICE > carOwner.getBalance()) {
                throw new NegativeBalanceException("Insufficient funds");
            }
            moneyEarned += RegularWash.WASH_PRICE;
        }
        if (washStrategy instanceof PremiumWash) {
            if (PremiumWash.WASH_PRICE > carOwner.getBalance()) {
                throw new NegativeBalanceException("Insufficient funds");
            }
            moneyEarned += PremiumWash.WASH_PRICE;
        }
        if (washStrategy instanceof CheapWash) {
            if (CheapWash.WASH_PRICE > carOwner.getBalance()) {
                throw new NegativeBalanceException("Insufficient funds");
            }
            moneyEarned += CheapWash.WASH_PRICE;
        }
        washStrategy.wash(car, carOwner);
        totalWash ++;

        return true;
    }

    public boolean washAndDry(Car car, CarOwner carOwner) throws BlackListedException, NegativeBalanceException {

        if (washStrategy == null) {
            return false;
        }
        if (isClientBlackListed(carOwner.getName())) {
            throw new BlackListedException("Car owner in black list");
        }
        if (washStrategy instanceof RegularWash) {
            if (RegularWash.WASH_AND_DRY_PRICE > carOwner.getBalance()) {
                throw new NegativeBalanceException("Insufficient funds");
            }
            moneyEarned += RegularWash.WASH_AND_DRY_PRICE;
        }
        if (washStrategy instanceof PremiumWash) {
            if (PremiumWash.WASH_AND_DRY_PRICE > carOwner.getBalance()) {
                throw new NegativeBalanceException("Insufficient funds");
            }
            moneyEarned += PremiumWash.WASH_AND_DRY_PRICE;
        }
        if (washStrategy instanceof CheapWash) {
            if (CheapWash.WASH_AND_DRY_PRICE > carOwner.getBalance()) {
                throw new NegativeBalanceException("Insufficient funds");
            }
            moneyEarned += CheapWash.WASH_AND_DRY_PRICE;
        }
        washStrategy.washAndDry(car, carOwner);
        totalWash ++;

        return true;
    }

    public void addCarOwnerToBlackList(String name) {
        blackList.add(name);
    }

    private boolean isClientBlackListed(String name) {
        return blackList.contains(name);
    }


}
