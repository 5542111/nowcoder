public class mathSqrt {
    public static void main(String[] args) {
        grandFather child1=new child();
        child1.play();
    }
    public static double sqrt(int a) {
        double x1 = 1, x2;
        x2 = x1 / 2.0 + a / (2 * x1);//牛顿迭代公式
        while (Math.abs(x2 - x1) > 1e-4) {
            x1 = x2;
            x2 = x1 / 2.0 + a / (2 * x1);
        }
        return x2;
    }
}
class grandFather{
    public void play(){
        System.out.println("grandFather.play()");
    }
}
class father extends grandFather{
    @Override
    public void play(){
        System.out.println("father.play()");
    }
}
class child extends father{
    @Override
    public void play(){
        System.out.println("child.play()");
    }
}

