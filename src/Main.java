import Boundary.BoundaryManager;
import Boundary.StockBoundary;
import Control.AppControl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // 의존성 주입
        AppControl appControl = new AppControl();
        BoundaryManager boundaryManager = new BoundaryManager();

        // 첫 화면 출력
        boundaryManager.switchBoundary(new StockBoundary(boundaryManager, appControl));
    }
}