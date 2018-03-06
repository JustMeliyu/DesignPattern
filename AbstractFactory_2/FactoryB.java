//B厂 - 生产模具+容器产品
public class FactoryB extends Factory{

    @Override
    public ContainerProductB ManufactureContainer() {
        return new ContainerProductB();
    }

    @Override
    public MouldProductB ManufactureMould() {
        return new MouldProductB();
    }
}