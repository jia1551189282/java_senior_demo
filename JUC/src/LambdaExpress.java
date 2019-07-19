/**
 * lambda表达式
 *
 *  * 1	拷贝中括号+写死右箭头+落地大括号
 *  * 2	一个接口里面有且仅有一个方法的接口,才可以使用Lambda Express
 *  * 3	@FunctionalInterface
 *  * 4	default默认方法实现
 *  * 5	静态方法实现
 */
public class LambdaExpress {
    public static void main(String[] args) {
        //  1  匿名内部类
       /* Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("new 接口 ，通过匿名内部类的方式");
            }
        };
        foo.sayHello();*/
       // 2 lambda 表达式 无参数
        /*Foo foo = () -> {
            System.out.println("lambda 表达式");
        };
        foo.sayHello();*/
        //3 lambda 表达式 有参数
        Foo foo = (x,y) -> {
            return x+y;
        };
        System.out.println(foo.add(2,5));


    }
}

interface Foo{
   /* public void sayHello();*/
    public int add(int x,int y );

}
