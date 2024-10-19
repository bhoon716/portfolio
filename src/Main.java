import Boundary.BoundaryManager;
import Boundary.MainBoundary;
import Control.AppControl;
import Logic.PortfolioManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // 의존성 주입
        PortfolioManager portfolioManager = new PortfolioManager();
        AppControl appControl = new AppControl(portfolioManager);
        BoundaryManager boundaryManager = new BoundaryManager();

        // 첫 화면
        boundaryManager.switchBoundary(new MainBoundary(boundaryManager, appControl));
    }
}