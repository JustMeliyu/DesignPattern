//A厂 - 生产模具+容器产品
public class FactoryA extends Factory{

    @Override
    public ContainerProductA ManufactureContainer() {
        return new ContainerProductA();
    }

    @Override
    public MouldProductA ManufactureMould() {
        return new MouldProductA();
    }
}