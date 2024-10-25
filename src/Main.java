import Boundary.MainBoundary;
import Control.AssetControl;
import Control.PortfolioControl;
import Logic.AssetLogic;
import Logic.PortfolioLogic;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            AssetLogic assetLogic = new AssetLogic();
            PortfolioLogic portfolioLogic = new PortfolioLogic();

            AssetControl assetControl = new AssetControl(assetLogic);
            PortfolioControl portfolioControl = new PortfolioControl(portfolioLogic);

            MainBoundary mainScreen = new MainBoundary(assetControl, portfolioControl);
            mainScreen.setVisible(true);
        });
    }
}