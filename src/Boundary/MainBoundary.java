package Boundary;

import Control.AssetControl;
import Control.PortfolioControl;
import Entity.Asset;
import Entity.AssetInfo;
import Entity.AssetType;
import Entity.Portfolio;

import javax.swing.*;
import java.awt.*;

public class MainBoundary extends JFrame {

    private final AssetControl assetController;
    private final PortfolioControl portfolioControl;

    private JList<AssetType> assetTypeList;
    private JTextField symbolTextField;
    private JButton searchButton;

    private JList<String> portfolioList;
    private JButton viewPortfolioButton;
    private JButton addPortfolioButton;
    private JButton deletePortfolioButton;

    private static final String ERROR_SELECT_ASSET = "Please select an asset type and enter a symbol";
    private static final String ERROR_SELECT_PORTFOLIO = "Please select a portfolio";
    private static final String ERROR_EMPTY_PORTFOLIO_NAME = "Portfolio name cannot be empty";
    private static final String CONFIRM_DELETE = "Are you sure you want to delete portfolio: ";

    public MainBoundary(AssetControl assetControl, PortfolioControl portfolioControl) {
        this.assetController = assetControl;
        this.portfolioControl = portfolioControl;
        setTitle("Portfolio Manage");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        assetTypeList = new JList<>(AssetType.values());
        symbolTextField = new JTextField(10);
        searchButton = new JButton("Search");

        portfolioList = new JList<>();
        viewPortfolioButton = new JButton("View Portfolio");
        addPortfolioButton = new JButton("Add Portfolio");
        deletePortfolioButton = new JButton("Delete Portfolio");

        JPanel searchPanel = createSearchPanel();
        JPanel portfolioPanel = createPortfolioPanel();

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(searchPanel, BorderLayout.NORTH);
        getContentPane().add(portfolioPanel, BorderLayout.CENTER);

        updatePortfolioList();

        searchButton.addActionListener(e -> searchAsset());
        viewPortfolioButton.addActionListener(e -> viewPortfolio());
        addPortfolioButton.addActionListener(e -> addPortfolio());
        deletePortfolioButton.addActionListener(e -> deletePortfolio());
    }

    // 검색 패널 생성
    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Asset Type:"));
        searchPanel.add(assetTypeList);
        searchPanel.add(new JLabel("Symbol:"));
        searchPanel.add(symbolTextField);
        searchPanel.add(searchButton);
        return searchPanel;
    }

    // 포트폴리오 패널 생성
    private JPanel createPortfolioPanel() {
        JPanel portfolioPanel = new JPanel();
        portfolioPanel.setLayout(new BorderLayout());

        JPanel portfolioButtonsPanel = new JPanel();
        portfolioButtonsPanel.add(viewPortfolioButton);
        portfolioButtonsPanel.add(addPortfolioButton);
        portfolioButtonsPanel.add(deletePortfolioButton);

        portfolioPanel.add(new JLabel("Portfolios:"), BorderLayout.NORTH);
        portfolioPanel.add(new JScrollPane(portfolioList), BorderLayout.CENTER);
        portfolioPanel.add(portfolioButtonsPanel, BorderLayout.SOUTH);
        return portfolioPanel;
    }

    // 자산 검색
    private void searchAsset() {
        AssetType selectedType = assetTypeList.getSelectedValue();
        String symbol = symbolTextField.getText();

        try {
            if (selectedType != null && !symbol.isEmpty()) {
                AssetInfo assetInfo = assetController.getAssetInfo(selectedType, symbol);
                new AssetBoundary(assetController, assetInfo).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            showErrorMessage(ERROR_SELECT_ASSET);
        }
    }

    // 포트폴리오 보기
    private void viewPortfolio() {
        String selectedPortfolio = portfolioList.getSelectedValue();
        if (selectedPortfolio != null) {
            new PortfolioBoundary(portfolioControl, assetController, selectedPortfolio).setVisible(true);
        } else {
            showErrorMessage(ERROR_SELECT_PORTFOLIO);
        }
    }

    // 포트폴리오 추가
    private void addPortfolio() {
        String portfolioName = promptInput();
        if (portfolioName != null && !portfolioName.trim().isEmpty()) {
            portfolioControl.createPortfolio(portfolioName.trim());
            updatePortfolioList();
        } else {
            showErrorMessage(ERROR_EMPTY_PORTFOLIO_NAME);
        }
    }

    // 포트폴리오 삭제
    private void deletePortfolio() {
        String selectedPortfolio = portfolioList.getSelectedValue();
        if (selectedPortfolio != null) {
            int confirm = showConfirmDialog(CONFIRM_DELETE + selectedPortfolio + "?");
            if (confirm == JOptionPane.YES_OPTION) {
                portfolioControl.deletePortfolio(selectedPortfolio);
                updatePortfolioList();
            }
        } else {
            showErrorMessage(ERROR_SELECT_PORTFOLIO);
        }
    }

    // 포트폴리오 목록 업데이트
    private void updatePortfolioList() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Portfolio portfolio : portfolioControl.getPortfolioList()) {
            listModel.addElement(portfolio.getName());
        }
        portfolioList.setModel(listModel);
    }

    // 에러 메시지 출력 메서드
    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    // 입력 프롬프트 메서드
    private String promptInput() {
        return JOptionPane.showInputDialog(this, "Enter new portfolio name:");
    }

    // 확인 대화상자 메서드
    private int showConfirmDialog(String message) {
        return JOptionPane.showConfirmDialog(this, message, "Confirm Delete", JOptionPane.YES_NO_OPTION);
    }
}
