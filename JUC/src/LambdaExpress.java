/**
 * lambda���ʽ
 *
 *  * 1	����������+д���Ҽ�ͷ+��ش�����
 *  * 2	һ���ӿ��������ҽ���һ�������Ľӿ�,�ſ���ʹ��Lambda Express
 *  * 3	@FunctionalInterface
 *  * 4	defaultĬ�Ϸ���ʵ��
 *  * 5	��̬����ʵ��
 */
public class LambdaExpress {
    public static void main(String[] args) {
        //  1  �����ڲ���
       /* Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("new �ӿ� ��ͨ�������ڲ���ķ�ʽ");
            }
        };
        foo.sayHello();*/
       // 2 lambda ���ʽ �޲���
        /*Foo foo = () -> {
            System.out.println("lambda ���ʽ");
        };
        foo.sayHello();*/
        //3 lambda ���ʽ �в���
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
