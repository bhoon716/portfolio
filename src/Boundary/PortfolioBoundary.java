package Boundary;

import Control.AssetControl;
import Control.PortfolioControl;
import Entity.Asset;
import Entity.AssetType;
import Entity.Portfolio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;

public class PortfolioBoundary extends JFrame {

    private JLabel portfolioInfoLabel;
    private JTable assetsTable;
    private JButton addAssetButton;
    private JButton editAssetButton;
    private JButton deleteAssetButton;

    private PortfolioControl portfolioController;
    private AssetControl assetControl;
    private String portfolioName;

    private Portfolio portfolio;

    public PortfolioBoundary(PortfolioControl portfolioController, AssetControl assetControl, String portfolioName) {
        this.portfolioController = portfolioController;
        this.assetControl = assetControl;
        this.portfolioName = portfolioName;
        this.portfolio = portfolioController.getPortfolio(portfolioName);

        setTitle("Portfolio: " + portfolioName);
        setSize(600, 400);
        initUI();
    }

    private void initUI() {
        portfolioInfoLabel = new JLabel();
        updatePortfolioInfo();

        assetsTable = new JTable();
        updateAssetsTable();

        addAssetButton = new JButton("Add Asset");
        editAssetButton = new JButton("Edit Asset");
        deleteAssetButton = new JButton("Delete Asset");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addAssetButton);
        buttonPanel.add(editAssetButton);
        buttonPanel.add(deleteAssetButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(portfolioInfoLabel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(assetsTable), BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        addAssetButton.addActionListener(e -> addAsset());

        editAssetButton.addActionListener(e -> editAsset());

        deleteAssetButton.addActionListener(e -> deleteAsset());
    }

    private void addAsset() {
        JPanel panel = new JPanel(new GridLayout(0, 2));

        JComboBox<AssetType> assetTypeComboBox = new JComboBox<>(AssetType.values());
        JTextField symbolField = new JTextField();
        JTextField avgPriceField = new JTextField();
        JTextField quantityField = new JTextField();

        panel.add(new JLabel("타입:"));
        panel.add(assetTypeComboBox);
        panel.add(new JLabel("심볼:"));
        panel.add(symbolField);
        panel.add(new JLabel("평단가:"));
        panel.add(avgPriceField);
        panel.add(new JLabel("수량:"));
        panel.add(quantityField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Add Asset", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            AssetType assetType = (AssetType) assetTypeComboBox.getSelectedItem();
            String symbol = symbolField.getText();
            double averagePrice = Double.parseDouble(avgPriceField.getText());
            double quantity = Double.parseDouble(quantityField.getText());

            if (assetType != null && !symbol.isEmpty()) {
                try {
                    Asset asset = assetControl.searchAsset(assetType, symbol, averagePrice, quantity);
                    portfolioController.addAssetToPortfolio(portfolioName, asset);
                    updateAssetsTable();
                    updatePortfolioInfo();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error fetching asset data");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter valid asset details");
            }
        }
    }

    private void editAsset() {
        int selectedRow = assetsTable.getSelectedRow();
        if (selectedRow >= 0) {
            Asset asset = portfolio.getAssets().get(selectedRow);

            // 현재 자산 정보를 기반으로 초기 값을 설정하는 입력 필드
            JTextField symbolField = new JTextField(asset.getSymbol());
            JTextField avgPriceField = new JTextField(String.valueOf(asset.getAveragePrice()));
            JTextField quantityField = new JTextField(String.valueOf(asset.getQuantity()));

            JPanel panel = new JPanel(new GridLayout(0, 2));
            panel.add(new JLabel("심볼:"));
            panel.add(symbolField);
            panel.add(new JLabel("평단가:"));
            panel.add(avgPriceField);
            panel.add(new JLabel("수량:"));
            panel.add(quantityField);

            int result = JOptionPane.showConfirmDialog(this, panel, "Edit Asset", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String newSymbol = symbolField.getText();
                double newAvgPrice = Double.parseDouble(avgPriceField.getText());
                double newQuantity = Double.parseDouble(quantityField.getText());

                if (!newSymbol.isEmpty()) {
                    portfolioController.removeAssetFromPortfolio(portfolioName, asset);

                    try {
                        AssetType assetType = asset.getAssetType();
                        Asset newAsset = assetControl.searchAsset(assetType, newSymbol, newAvgPrice, newQuantity);
                        portfolioController.addAssetToPortfolio(portfolioName, newAsset);
                        updateAssetsTable();
                        updatePortfolioInfo();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Error fetching asset data");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an asset to edit");
        }
    }


    private void deleteAsset() {
        int selectedRow = assetsTable.getSelectedRow();
        if (selectedRow >= 0) {
            Asset asset = portfolio.getAssets().get(selectedRow);
            portfolioController.removeAssetFromPortfolio(portfolioName, asset);
            updateAssetsTable();
            updatePortfolioInfo();
        } else {
            JOptionPane.showMessageDialog(this, "Please select an asset to delete");
        }
    }

    private void updatePortfolioInfo() {
        if (portfolio != null) {
            portfolioInfoLabel.setText("Total Value: " + portfolio.getTotalValue());
        }
    }

    private void updateAssetsTable() {
        if (portfolio != null) {
            String[] columnNames = {"타입", "심볼", "자산가치", "수량", "평단가", "현재가", "수익"};
            Object[][] data = new Object[portfolio.getAssets().size()][7];
            int i = 0;
            for (Asset asset : portfolio.getAssets()) {
                data[i][0] = asset.getAssetType();
                data[i][1] = asset.getSymbol();
                data[i][2] = asset.getEvaluation();
                data[i][3] = asset.getQuantity();
                data[i][4] = asset.getAveragePrice();
                data[i][5] = asset.getPrice();
                data[i][6] = asset.getProfitLoss() + "(" + asset.getChange() + "%)";
                i++;
            }
            assetsTable.setModel(new DefaultTableModel(data, columnNames));
        }
    }
}
