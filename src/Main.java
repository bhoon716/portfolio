import Boundary.BoundaryManager;
import Boundary.MainBoundary;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        BoundaryManager boundaryManager = new BoundaryManager();

        boundaryManager.switchBoundary(new MainBoundary(boundaryManager));
    }
}