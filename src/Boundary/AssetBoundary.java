package Boundary;

import Control.AssetControl;
import Entity.AssetInfo;

import javax.swing.*;

public class AssetBoundary extends JFrame {

    private final AssetControl assetControl;

    private JLabel assetPriceLabel;
    private AssetInfo assetInfo;

    public AssetBoundary(AssetControl assetControl, AssetInfo assetInfo) {
        this.assetControl = assetControl;
        this.assetInfo = assetInfo;

        setTitle("Entity.Asset: " + assetInfo.getSymbol());
        setSize(300, 200);

        initUI();
    }

    public void initUI(){
        JLabel title = new JLabel("StockBoundary");
        add(title);

        assetPriceLabel = new JLabel("Price: " + assetInfo.getOpen());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(assetPriceLabel);

        getContentPane().add(panel);
    }

}
