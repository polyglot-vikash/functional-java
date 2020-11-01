/**
 * One of the many differences between Anonymous inner class and lambda is that the way
 * this works.
 *
 * this works differently in these two, following example shows the same.
 */
public class ThisReferenceExample {

    public void doProcess(int i, Process p) {
        p.process(i);
    }
    public static void main(String args[]){
        ThisReferenceExample obj = new ThisReferenceExample();

        // this at line 20 is pointing to the anonymous inner class object, if we move line 20 outside of Process object then it won't work as main is a static
        // class and we can't acess this in  static object.
        obj.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println(i);
                System.out.println(this);
            }

            @Override
            public String toString() {
                return "This is the anonymous inner class";
            }
        });

        obj.doProcess(20, i-> {
            System.out.println(i);
            // This will not work because unlike Anoymous inner classes lambda does not override this, hence, value of this will be similar to outside
            // in the outside main is static and static does  not have access to this hence it will throw error
            // It is smilar to arrow function  in JS
            // System.out.println(this);
        });

    }

    interface Process {
        void process(int i);
    }
}
