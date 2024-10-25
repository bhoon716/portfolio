package Boundary;

import Entity.AssetInfo;

import javax.swing.*;
import java.awt.*;

public class AssetBoundary extends JFrame {

    private final AssetInfo assetInfo;

    public AssetBoundary(AssetInfo assetInfo) {
        this.assetInfo = assetInfo;

        setTitle("Asset Info: " + assetInfo.getSymbol());
        setSize(400, 300);  // 창 크기 확대

        initUI();
    }

    public void initUI(){
        JLabel title = new JLabel("Stock Information");
        title.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel symbolLabel = new JLabel("Symbol: " + assetInfo.getSymbol());
        JLabel timestampLabel = new JLabel("Timestamp: " + assetInfo.getTimestamp());
        JLabel openLabel = new JLabel("Open: " + assetInfo.getOpen());
        JLabel highLabel = new JLabel("High: " + assetInfo.getHigh());
        JLabel lowLabel = new JLabel("Low: " + assetInfo.getLow());
        JLabel closeLabel = new JLabel("Close: " + assetInfo.getClose());
        JLabel volumeLabel = new JLabel("Volume: " + assetInfo.getVolume());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(title);
        panel.add(symbolLabel);
        panel.add(timestampLabel);
        panel.add(openLabel);
        panel.add(highLabel);
        panel.add(lowLabel);
        panel.add(closeLabel);
        panel.add(volumeLabel);

        getContentPane().add(panel);
    }

}
