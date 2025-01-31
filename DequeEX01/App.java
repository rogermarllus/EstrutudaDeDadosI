public class App {
    public static void main(String[] args) throws Exception {
        Deque<Integer> deque = new Deque<>();
        deque.addInicio(3);
        deque.addInicio(2);
        deque.addFinal(4);
        deque.addFinal(5);
        deque.addInicio(1);
        deque.print();
        System.out.println("------------------------");
        deque.removeFinal();
        deque.print();
        deque.removeInicio();
        deque.print();
        deque.removeInicio();
        deque.print();
        deque.removeInicio();
        deque.print();
        deque.removeInicio();
        deque.print();
    }
}
