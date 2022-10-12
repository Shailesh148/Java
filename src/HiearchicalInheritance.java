
    class A {
        void input(){
            System.out.println("Enter your Name:");
        }
    }

    class B extends A {
        void show(){
            System.out.println("Anup");
        }
    }
    class C extends A {
        void display(){
            System.out.println("Anu");
        }
    }

    public class HiearchicalInheritance {

        public static void  main(String[] args){
            B v1 = new B();
            C v2 = new C();

            v1.input();
            v1.show();
            v2.input();
            v2.display();
        }
    }



