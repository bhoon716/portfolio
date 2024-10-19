package Boundary;

import Control.AppControl;
import Entity.Portfolio;

import javax.swing.*;

public class MainBoundary extends JPanel {

    private final BoundaryManager boundaryManager;
    private final AppControl appControl;

    private DefaultListModel<String> portfolioModel = new DefaultListModel<>();

    public MainBoundary(BoundaryManager boundaryManager, AppControl appControl) {
        this.boundaryManager = boundaryManager;
        this.appControl = appControl;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setVisible(true);

        initUI();
        updatePortfolioList();
    }

    private void initUI() {
        JLabel label = new JLabel("Main Boundary");
        add(label);

        JList<String> portfolioList = new JList<>(portfolioModel);
        JScrollPane scrollPane = new JScrollPane(portfolioList);
        add(scrollPane);  // 초기 포트폴리오 리스트 추가

        JTextField textField = new JTextField();
        add(textField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> addPortfolio(textField.getText()));
        add(addButton);

        JButton button = new JButton("Button");
        button.addActionListener(e -> boundaryManager.switchBoundary(new StockBoundary(this.boundaryManager, this.appControl)));
        add(button);
    }

    // 포트폴리오 추가
    private void addPortfolio(String name) {
        appControl.addPortfolio(name);
        updatePortfolioList();  // 새 포트폴리오 목록을 업데이트
    }

    // 포트폴리오 목록 업데이트
    private void updatePortfolioList() {
        portfolioModel.clear();  // 기존 포트폴리오 목록을 지우고 새로 추가
        for (Portfolio portfolio : appControl.getPortfolios()) {
            portfolioModel.addElement(portfolio.getName());  // 포트폴리오 이름 추가
        }
    }
}
