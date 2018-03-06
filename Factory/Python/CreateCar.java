abstract interface Car {
    public void run();

    public void stop();
}

class Benz implements Car {
    public void run() {
        System.out.println("Benz is start");
    }

    public void stop() {
        System.out.println("Benz is stop");
    }
}

class Ford implements Car {
    public void run() {
        System.out.println("Ford is start");
    }

    public void stop() {
        System.out.println("Ford is stop");
    }
}

class Factory {
    public static Car getCarInstance(String type) {
        Car c = null;
        if ("Benz".equals(type)) {
            c = new Benz();
        }
        if ("Ford".equals(type)) {
            c = new Ford();
        }
        return c;
    }
}

public class CreateCar {

    public static void main(String[] args) {
        Car c = Factory.getCarInstance("Benz");
        if (c != null) {
            c.run();
            c.stop();
        } else {
            System.out.println("can't create the car");
        }

    }

}